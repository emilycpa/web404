package com.uniquery;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.database.DataBaseUtil;
import com.database.po.Product;
import com.util.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UnicomQuery {
	// 账户查询
	private final String account = "daoyi";
	private final String password = "daoyi316";
	// 精准匹配
	private final String account1 = "daoyi";
	private final String password1 = "daoyi134";

	/**
	 * 实时费用查询
	 * 
	 * @param phoneNum
	 * @return
	 */
	public String realtimeBill(String phoneNum) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String responseContent = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.222.27.26:10000/UniQueryReceiver");
			JSONObject jsonParam = new JSONObject();
			String timestamp = Util.getTimestamp("yyyyMMddHHmmss");
			jsonParam.put("timestamp", timestamp);
			jsonParam.put("phone", phoneNum);
			jsonParam.put("account", account);
			jsonParam.put("code", "102011203100");
			jsonParam.put("accesskey", Util.encodeMD5(account + Util.encodeMD5(password) + timestamp));

			List<BasicNameValuePair> httpParams = new ArrayList<BasicNameValuePair>();
			httpParams.add(new BasicNameValuePair("content", jsonParam.toString()));
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(httpParams, "UTF-8");
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (Exception e) {

			}
		}
		return responseContent;
	}

	public String balance(String phoneNum) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String responseContent = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.222.27.26:10000/UniQueryReceiver");
			JSONObject jsonParam = new JSONObject();
			String timestamp = Util.getTimestamp("yyyyMMddHHmmss");
			jsonParam.put("timestamp", timestamp);
			jsonParam.put("phone", phoneNum);
			jsonParam.put("account", account);
			jsonParam.put("code", "102011203000");
			jsonParam.put("accesskey", Util.encodeMD5(account + Util.encodeMD5(password) + timestamp));

			List<BasicNameValuePair> httpParams = new ArrayList<BasicNameValuePair>();
			httpParams.add(new BasicNameValuePair("content", jsonParam.toString()));
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(httpParams, "UTF-8");
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (Exception e) {

			}
		}
		return responseContent;
	}

	public String packageUsage(String phoneNum) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String responseContent = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://10.222.27.26:10000/UniQueryReceiver");
			JSONObject jsonParam = new JSONObject();
			String timestamp = Util.getTimestamp("yyyyMMddHHmmss");
			jsonParam.put("timestamp", timestamp);
			jsonParam.put("phone", phoneNum);
			jsonParam.put("account", account);
			jsonParam.put("code", "QryUserResKF");
			jsonParam.put("bcycid", Util.getTimestamp("yyyyMM"));
			jsonParam.put("accesskey", Util.encodeMD5(account + Util.encodeMD5(password) + timestamp));

			List<BasicNameValuePair> httpParams = new ArrayList<BasicNameValuePair>();
			httpParams.add(new BasicNameValuePair("content", jsonParam.toString()));
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(httpParams, "UTF-8");
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (Exception e) {

			}
		}
		return responseContent;
	}

	public List<Product> queryProduct(String phoneNum) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String responseContent = null;
		List<Product> data = new ArrayList<Product>();
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://113.57.230.126:10002/ProductFilterService");
//			HttpPost httpPost = new HttpPost("http://10.223.2.74:10002/ProductFilterService");
			JSONObject jsonParam = new JSONObject();
			String timestamp = Util.getTimestamp("yyyyMMddHHmmss");
			jsonParam.put("timestamp", timestamp);
			jsonParam.put("phone", phoneNum);
			jsonParam.put("channelCode", account1);

			String[] strAttr = { password1, timestamp, account1, phoneNum };
			jsonParam.put("signature", getSignature(strAttr));

			List<BasicNameValuePair> httpParams = new ArrayList<BasicNameValuePair>();
			httpParams.add(new BasicNameValuePair("subMessage", jsonParam.toString()));
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(httpParams, "UTF-8");
			httpPost.setEntity(uefEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
				JSONObject resJson = JSONObject.fromObject(responseContent);
				System.out.println(responseContent);
				if (resJson.has("respCode") && resJson.getString("respCode").equals("00")) {
					if (resJson.has("result")) {
						JSONArray products = resJson.getJSONArray("result");
						System.out.println(products.toString());
//						for (int i = 0; i < products.size(); i++) {
//							Product p = DataBaseUtil.queryProduct(products.getString(i));
//							if (p != null)
//								data.add(p);
//						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (Exception e) {

			}
		}
		return data;
	}

	protected String getSignature(String[] strArr) throws NoSuchAlgorithmException {
		java.util.Arrays.sort(strArr);
		StringBuffer sb = new StringBuffer();
		for (String str : strArr) {
			sb.append(str);
		}
		return Util.encodeMD5(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		UnicomQuery query = new UnicomQuery();
		List<Product> data = query.queryProduct("18627770375");
		for(Product p : data)
			System.out.println(p.getName());
	}
}
