package com.sdk.roleService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class RestTests {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void roleRetrievedSuccessfully() throws Exception {
                mvc.perform(
                                MockMvcRequestBuilders.post("/role/create")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(objectMapper.writeValueAsString(new RoleCreateTest("NEWROLE"))))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.msg").exists())
                        .andExpect(jsonPath("$.msg").value("NEWROLE role created successfully"))
                        .andReturn();

        }

        @Test
        public void assignRoleRetrievedSuccessfully() throws Exception {
                mvc.perform(
                                MockMvcRequestBuilders.put("/role/assign")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(objectMapper.writeValueAsString(new RoleAssignTest("54383a18-425c-4f50-9424-1c4c27e776dd",
                                                "7676a4bf-adfe-415c-941b-1739af07039b", "DEVELOPER"))))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.msg").exists())
                        .andExpect(jsonPath("$.msg").value("Role: DEVELOPER assigned successfully to " +
                                "user id: 54383a18-425c-4f50-9424-1c4c27e776dd in team id: 7676a4bf-adfe-415c-941b-1739af07039b"))
                        .andReturn();

        }

}
