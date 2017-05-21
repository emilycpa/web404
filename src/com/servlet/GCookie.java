package com.servlet;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.jni.Global;
import org.apache.http.NameValuePair;

/**
 * Servlet implementation class GCookie
 */
public class GCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("333333333333");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 
		 CloseableHttpClient httpclient = HttpClients.createDefault();  
		
	        // 创建httppost    
		 System.out.println("11111eeeeeeeeeeee111111");
	        HttpPost httppost = new HttpPost("http://www.daoyi027.com:8080/404/dd.jsp");  
	       // httpclient.getParams().setVirtualHost("a.xxxx.com");
	        httppost.setHeader("url", "www.daoyio27.com:8080");
	        // 创建参数队列    
	       // httppost.setHeader("User-Agent", "Chrome");
	       // httppost.setHeader("Referer", "www.daoyio27.com:8080");
	       // HashMap<String, String> headers = new HashMap<String, String>();  
	       // headers.put("Referer", p.url);  
	        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625  Firefox/3.6.6 Greatwqs");  
	        httppost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");  
	        httppost.setHeader("Accept-Language","zh-cn,zh;q=0.5");  
	        httppost.setHeader("Host","www.yourdomain.com");  
	        httppost.setHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");  
	        httppost.setHeader("Referer", "www.daoyio27.com:8080/index.html"); 
	        
	        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	        formparams.add(new BasicNameValuePair("reqType", request.getParameter("reqType")));  
	        formparams.add(new BasicNameValuePair("ad", request.getParameter("ad")));  
	        formparams.add(new BasicNameValuePair("url", request.getParameter("url")));  
	        UrlEncodedFormEntity uefEntity;  
	        String s=null;
	        try {  
	            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
	            httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
	            httppost.setEntity(uefEntity);  
	            System.out.println("executing request " + httppost.getURI());  
	            CloseableHttpResponse rese = httpclient.execute(httppost);  
	            try {  
	                HttpEntity entity = rese.getEntity(); 
	                Header[] heads = rese.getAllHeaders();
	                for(Header head:heads)
	                {
	                	 System.out.println("Header content: " +head.toString());  
	                }
	                if (entity != null) {  
	                	s=EntityUtils.toString(entity, "UTF-8");
	                    System.out.println("--------------------------------------");  
	                    System.out.println("Response content: " +s);  
	                    System.out.println("--------------------------------------");  
	                }  
	            } finally {  
	            	//rese.close();  
	            }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (UnsupportedEncodingException e1) {  
	            e1.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            // 关闭连接,释放资源    
	            try {  
	                httpclient.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        
	        PrintWriter out = null;
			try {
				out = response.getWriter();
				// JSONArray jsonArray = new JSONArray();
				// jsonArray.add(json);
				//out.println("<script>window.name="+json+"";</script>"); 
				System.out.println("ssssss is="+s);
				out.write(s);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
	    }

}
