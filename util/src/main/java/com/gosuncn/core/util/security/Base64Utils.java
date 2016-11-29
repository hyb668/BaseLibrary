package com.gosuncn.core.util.security;

import android.util.Base64;

/**
 * Base64加解密
 * @author HWJ
 *
 */
public class Base64Utils {
	
	/**
	 * Base64加密
	 * @param str
	 * @return
	 */
	public static String encode(String str){
		return new String(Base64.encode(str.getBytes(), Base64.DEFAULT));
	}
	
	/**
	 * Base64解密
	 * @param strBase64
	 * @return
	 */
	public static String decode(String strBase64){
		return new String(Base64.decode(strBase64.getBytes(), Base64.DEFAULT));
	}
}
