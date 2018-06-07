package com.niu.utils;

public class Constants {
	/**
	 * json 格式返回数据的 status 标示说明
	 */
	public static interface ReturnResult {
		public static int SUCCESS = 1;
		public static int FAIL = -1;
	}

	/**
	 * 前后台用户
	 */
	public static interface UserType {
		public static int PRE = 0;
		public static int BACKEND = 1;
	}

	/**
	 * 
	 * 快递运费模板！
	 * 
	 * @author 牛牛牛！！！牛牛！！牛！
	 * 
	 * @date 2018-1-12
	 * 
	 * @version
	 * 
	 */
	public static interface Expressage {
		public static int SHENGTONG = 15;
		public static int YUANTONG = 15;
		public static int SHONGFENG = 30;
		public static int YOUZHENG = 25;
	}

	// cookie中购物车字符串
	public static interface Cookie {
		public static String COOKIE_CART = "cookieCart";
	}

	/**
	 * 
	 * 购物车字符串！
	 * 
	 * @author 牛牛牛！！！牛牛！！牛！
	 * 
	 * @date 2018-1-16
	 * 
	 * @version
	 * 
	 */
	public static interface Memcached {
		public static String MEMCACHED_CART = "memcachedCart";
		public static String FAVORITE = "favorite";
	}
}
