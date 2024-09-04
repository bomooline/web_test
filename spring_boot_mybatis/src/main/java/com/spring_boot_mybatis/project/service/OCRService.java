package com.spring_boot_mybatis.project.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class OCRService {
	@Autowired
    Environment env;
	
	public String clovaOCRService(String filePathName) {
		System.out.println("2: " + filePathName);
		
		String apiURL = env.getProperty("ocr.apiURL");    
		String secretKey = env.getProperty("ocr.secretKey");
		
		String imageFile = filePathName;
		String result = "";

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
			
			 result = jsonToString(response.toString());
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public String ocrTemplate() {
		String apiURL = "https://hf7frkljsr.apigw.ntruss.com/custom/v1/32597/5070e28655bf7983475be6aedc85fe48ce32f539dcf10722665932bd1921279e/infer";
		String secretKey = "Tm93dVpxbVhQaUxEalVlU296YUhDeUxtUVp6bGtYbnY=";
		String imageFile =  "D:/springWorkspace/ai/upload/영수증.jpg";
		String result = "";

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
			
			 jsonToString2(response.toString());
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public String ocrTemplate2() {
		String apiURL = "https://hf7frkljsr.apigw.ntruss.com/custom/v1/32599/53c474c7b03b3a85d5c03e1af219e7ad100628bce1ac1a8ca06ae2744b62b9ac/infer";
		String secretKey = "cE9zUWtVbWhVUmllcUNlekJQd0tCS2VWWkJvV2FWYk4=";
		String imageFile =  "D:/springWorkspace/ai/upload/영수증.jpg";
		String result = "";

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
			
			 jsonToString3(response.toString());
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	IOException {
	StringBuilder sb = new StringBuilder();
	sb.append("--").append(boundary).append("\r\n");
	sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
	sb.append(jsonMessage);
	sb.append("\r\n");

	out.write(sb.toString().getBytes("UTF-8"));
	out.flush();

	if (file != null && file.isFile()) {
		out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
		StringBuilder fileString = new StringBuilder();
		fileString
			.append("Content-Disposition:form-data; name=\"file\"; filename=");
		fileString.append("\"" + file.getName() + "\"\r\n");
		fileString.append("Content-Type: application/octet-stream\r\n\r\n");
		out.write(fileString.toString().getBytes("UTF-8"));
		out.flush();

		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[8192];
			int count;
			while ((count = fis.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			out.write("\r\n".getBytes());
		}

		out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
	}
	out.flush();
}
	
	// JSON 문자열 파싱 
	public String  jsonToString(String jsonResultStr) {
		
		String inferText = "";
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		JSONArray imagesArray = (JSONArray) jsonObj.get("images");
		
		jsonObj = imagesArray.getJSONObject(0);
		JSONArray fieldsArray = (JSONArray) jsonObj.get("fields");
		
		for(int i = 0; i < fieldsArray.length(); i++) {
			JSONObject fieldsObj = fieldsArray.getJSONObject(i);
			inferText += fieldsObj.getString("inferText") + " ";
		}
		
		return inferText;
	}
	
	// JSON 문자열 파싱 : OCR Template
	public void jsonToString2(String jsonResultStr) {
		
		//String inferText = "";
		JSONObject jsonObj = new JSONObject(jsonResultStr);		
		JSONArray imagesArray = jsonObj.getJSONArray("images");	
		
		jsonObj = imagesArray.getJSONObject(0);
		
		JSONObject titleObj = jsonObj.getJSONObject("title");
		String title = titleObj.getString("inferText");
		System.out.println("title : " + title);		
		
		JSONArray fieldsArray = jsonObj.getJSONArray("fields");
		
		for(int i = 0; i < fieldsArray.length(); i++) {
			JSONObject fieldsObj = fieldsArray.getJSONObject(i);
			//inferText += fieldsObj.getString("inferText") + " ";
			String inferText = fieldsObj.getString("inferText");
			System.out.println(inferText);
		}		
		
	}
	
	// JSON 문자열 파싱 : OCR Template2
		public void jsonToString3(String jsonResultStr) {
			
			//String inferText = "";
			JSONObject jsonObj = new JSONObject(jsonResultStr);		
			JSONArray imagesArray = jsonObj.getJSONArray("images");	
			
			jsonObj = imagesArray.getJSONObject(0);
			
			JSONObject titleObj = jsonObj.getJSONObject("title");
			String title = titleObj.getString("inferText");
			System.out.println("title : " + title);		
			
			JSONArray fieldsArray = jsonObj.getJSONArray("fields");
			
			for(int i = 0; i < fieldsArray.length(); i++) {
				JSONObject fieldsObj = fieldsArray.getJSONObject(i);
				//inferText += fieldsObj.getString("inferText") + " ";
				String name = fieldsObj.getString("name");
				String inferText = fieldsObj.getString("inferText");
				System.out.println(name + " : " + inferText);
			}		
			
		}
		
}
