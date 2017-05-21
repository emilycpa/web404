package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;

/**
 * Servlet Filter implementation class CorsFilter
 */
public class CorsFilter implements Filter {

	
	  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
    }  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
                         FilterChain chain) throws IOException, ServletException {  
        try {  
            HttpServletRequest httpRequest = (HttpServletRequest) request;  
            HttpServletResponse httpResponse = (HttpServletResponse) response;  
  
            // 跨域  
            Enumeration headerNames = httpRequest.getHeaderNames();
    		while (headerNames.hasMoreElements()) {
    			String key = (String) headerNames.nextElement();
    			String value = httpRequest.getHeader(key);
    			System.out.println("head key222=" + key + "   head value==" + value);
    			
    		}
            String origin = httpRequest.getHeader("Origin");  
           System.out.println("httpRequest.getMethod()"+httpRequest.getMethod());
           if ( httpRequest.getMethod().equals("OPTIONS") ) {  
          	 
               httpResponse.setStatus(HttpServletResponse.SC_OK);  
               return;  
           }
            
           if (origin == null||origin.equals("")) {  
        	  
                httpResponse.setHeader("Access-Control-Allow-Origin", "*");  
           } else {  
        	  
        	   System.out.println("origin=="+origin);
               httpResponse.setHeader("Access-Control-Allow-Origin", origin);  
             //System.out.println("or1111");
               //httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); 
           }  
           // httpResponse.addHeader("Access-Control-Allow-Origin", "*"); 
           
           httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept,X-Cookie");  
             
            httpResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE,gzip, deflate, sdch"); 
            httpResponse.setHeader("Access-Control-Max-Age", "30");
       	   httpResponse.setHeader("Access-Control-Allow-Headers", "POWERED-BY-MENGXIANHUI");  
         	//httpResponse.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\""); 
          // httpResponse.setStatus(HttpServletResponse.SC_OK); 
              
            chain.doFilter(request, response);  
        } catch (Exception e) {  
            e.printStackTrace(); 
        }  
    }  
    @Override  
    public void destroy() {  
    }  
}  