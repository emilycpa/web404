package com.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES加密
 * 
 * @author gaobo
 *
 */
public class DesUtil {

	public static final String KEY = "window12#$43@!`-=(.)keys";
	private static final String SECRET_KEY_TYPE = "DES";
	private static final String ECB_MOB = "DES/ECB/PKCS5Padding";
	private static final String CHAESET_NAME = "UTF-8";

	public static void main(String[] args) throws Exception {
		String data = "13057663921";
		System.out.println(encrypt(data));
		System.out.println(decrypt(encrypt(data)));

	}

	/**
	 * 加密
	 * 
	 * @param data
	 *            加密数据
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception {
		Cipher enCipher = Cipher.getInstance(ECB_MOB);
		Key key = getKey(KEY);
		enCipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] pasByte = enCipher.doFinal(data.getBytes(CHAESET_NAME));
		return DesUtil.encodeByte2HexStr(pasByte);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 *            解密数据
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data) throws Exception {
		Cipher deCipher = Cipher.getInstance(ECB_MOB);
		Key key = getKey(KEY);
		deCipher.init(Cipher.DECRYPT_MODE, key);
		byte[] pasByte = deCipher.doFinal(DesUtil.parseHexStr2Byte(data));
		return new String(pasByte, CHAESET_NAME);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 *            解密数据
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data, String password) throws Exception {
		Cipher deCipher = Cipher.getInstance(ECB_MOB);
		Key key = getKey(password);
		deCipher.init(Cipher.DECRYPT_MODE, key);
		byte[] pasByte = deCipher.doFinal(DesUtil.parseHexStr2Byte(data));
		return new String(pasByte, CHAESET_NAME);
	}

	/**
	 * 二进制转变为16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String encodeByte2HexStr(byte[] buf) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转变为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	private static Key getKey(String password) throws Exception{
		byte[] DESkey = password.getBytes(CHAESET_NAME);
		DESKeySpec keySpec = new DESKeySpec(DESkey);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_TYPE);
		return keyFactory.generateSecret(keySpec);
	}
}
