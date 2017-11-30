/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author jluis
 */
public class DataBase {

    private final String baseUrl = "https://challenge1-b4f80.firebaseio.com/";
    private String secureToken = null;
    private static final String _configPUT = "curl -X PUT -d ";
    private static final String _configPOST = "-X POST -d";
    private static final String _configPATCH = "-X PATCH -d";
    private static final String _configDELETE = "-X DELETE  -d";
    public DataBase() {

    }

    public void put(String data, String type) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + type + ".json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(data);
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();

    }

    public void post(String data, String type) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + type + ".json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(data);
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();

    }

    public void patch(String data, String type) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + type + ".json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(data);
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();

    }

    public void deletePost( String type) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + type + ".json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
       
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();

    }
    
     public String read(String data, String type) throws MalformedURLException, IOException {
        URL url = new URL(baseUrl + type + ".json");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();

		
		con.setRequestMethod("GET");

		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		
		System.out.println(response.toString());
            return response.toString();
    }
}
