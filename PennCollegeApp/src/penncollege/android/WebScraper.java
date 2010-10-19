package penncollege.android;


import java.io.*;
import java.net.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

public class WebScraper {
	public static void updateLocalDB() {
		
	}
	/**
	 * Gets the text between startStr and endStr in the url uri
	 * @param uri - URL to download info from
	 * @param startStr - String that isn't included in return to start from
	 * @param endStr - String that isn't included in return to end at
	 * @return - String between startStr and endStr, or null if a problem happened
	 */
	protected  static String getInside(String uri,String startStr, String endStr){
		String src = "";
		src = getHTTPSource(uri);
		if(src.equals("")) {
			//Problem
			return null;
		}else{
			int start = src.indexOf(startStr)+startStr.length();
			int end = src.indexOf(endStr);
			return src.substring(start,end);
		}
		
	}
	/**
	 * Gets text between the 
	 * @param src 
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	protected static String getInsideStr(String src,String startStr, String endStr){
			int start = src.indexOf(startStr)+startStr.length();
			int end = src.indexOf(endStr);
			return src.substring(start,end);
		}
	
	//Taken from http://www.agilemedicine.com/medBlog/?p=21
	protected  static String getHTTPSource(String url) {
		String src = "";
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			URI uri = new URI(url);
			HttpGet method = new HttpGet(uri);
			HttpResponse res = client.execute(method);
			InputStream data = res.getEntity().getContent();
			 src = generateString(data);
		} catch (Exception e) {
			
		}
		return src;
	}
	
	//Taken from http://www.agilemedicine.com/medBlog/?p=21
	protected  static String generateString(InputStream stream) {
		   InputStreamReader reader = new InputStreamReader(stream);
		  BufferedReader buffer = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		 
		try {
		String cur;
		   while ((cur = buffer.readLine()) != null) {
		            sb.append(cur + "\n");
		       }
		    } catch (IOException e) {
		       // TODO Auto-generated catch block
		        e.printStackTrace();
		   }
		  
		    try {
		       stream.close();
		  } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	    return sb.toString();
		 }
}
