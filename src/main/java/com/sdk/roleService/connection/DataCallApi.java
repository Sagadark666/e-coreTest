package com.sdk.roleService.connection;

import com.sdk.roleService.interfaces.IDataCallApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataCallApi implements IDataCallApi {

     String BASEURL = "https://cgjresszgg.execute-api.eu-west-1.amazonaws.com";
     URL url;
     HttpURLConnection connection;

    @Override
    public String getContent(String path) throws IOException {
        BASEURL += path;
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
        return content.toString();
    }
 }
