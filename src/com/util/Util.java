package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import sun.misc.BASE64Decoder;

public class Util {

	public static String decodeBase64(String code) throws IOException {
		byte[] bt = null;
		BASE64Decoder decode = new BASE64Decoder();
		bt = decode.decodeBuffer(code);
		return new String(bt);
	}

	public static String getTimestamp(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}

	/**
	 * 32位md5加密全小写
	 * 
	 * @param originString
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encodeMD5(String originString) throws NoSuchAlgorithmException {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(originString.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}

	public static String getMobileNumber() throws ClientProtocolException, IOException {
		String url = "http://113.57.230.43/khtc.aspx?url=http://113.57.230.176:8888";
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);

		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer buffer = new StringBuffer();
		String temp = null;
		while ((temp = reader.readLine()) != null)
			buffer.append(temp);
		reader.close();
		httpClient.close();

		return buffer.toString();
	}

	public static void getMobileInfo(String mobile, int type) throws Exception {
		String userNumber = DesUtil.encrypt(mobile);
		String url = null;
		if (type == 1)
			url = "http://wap.10010hb.net/hbwebvas/wap/netData.jsp";
		else if (type == 2)
			url = "http://wap.10010hb.net/hbwebvas/wap/accountBalance.jsp";
		else if (type == 3)
			url = "http://wap.10010hb.net/hbwebvas/wap/flowBalance.jsp";
		else if (type == 4)
			url = "http://wap.10010hb.net/hbwebvas/wap/packageUsage.jsp";
		else
			throw new Exception("type param is error.");
		url = url + "?usernumber=" + userNumber;
		System.out.println(url);
		System.out.println(userNumber);
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);

		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer buffer = new StringBuffer();
		String temp = null;
		while ((temp = reader.readLine()) != null)
			buffer.append(temp);
		reader.close();
		httpClient.close();

		System.out.println(buffer.toString());
	}

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
	}
}
