package com.sdk.roleService.service;

import com.sdk.roleService.controller.AssignRoleResponse;
import com.sdk.roleService.controller.CreateRoleResponse;
import com.sdk.roleService.interfaces.IMembershipRepo;
import com.sdk.roleService.interfaces.IRoleRepo;
import com.sdk.roleService.interfaces.IRoleService;
import com.sdk.roleService.interfaces.IValidationService;
import com.sdk.roleService.model.MembershipModel;
import com.sdk.roleService.model.RoleModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

 public class ValidationService implements IValidationService {

     String BASEURL = "https://cgjresszgg.execute-api.eu-west-1.amazonaws.com";
     URL url;
     HttpURLConnection connection;

     @Override
     public boolean userExists(String userId) throws IOException {
         BASEURL += "/users/"+userId;
         url = new URL(BASEURL);
         connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         BufferedReader in = new BufferedReader(
                 new InputStreamReader(connection.getInputStream()));
         String inputLine;
         StringBuilder content = new StringBuilder();
         while ((inputLine = in.readLine()) != null) {
             content.append(inputLine);
         }
         in.close();
         connection.disconnect();
         return !content.toString().equals("null");
     }

     @Override
     public boolean teamExists(String teamId) throws IOException {
         BASEURL += "/teams/"+teamId;
         url = new URL(BASEURL);
         connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         BufferedReader in = new BufferedReader(
                 new InputStreamReader(connection.getInputStream()));
         String inputLine;
         StringBuilder content = new StringBuilder();
         while ((inputLine = in.readLine()) != null) {
             content.append(inputLine);
         }
         in.close();
         connection.disconnect();
         return !content.toString().equals("null");
     }

     @Override
     public boolean isUserInTeam(String userId, String teamId) throws IOException {
         BASEURL += "/teams/"+teamId;
         url = new URL(BASEURL);
         connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         BufferedReader in = new BufferedReader(
                 new InputStreamReader(connection.getInputStream()));
         String inputLine;
         StringBuilder content = new StringBuilder();
         while ((inputLine = in.readLine()) != null) {
             content.append(inputLine);
         }
         in.close();
         connection.disconnect();
         return content.toString().contains(userId);
     }
 }
