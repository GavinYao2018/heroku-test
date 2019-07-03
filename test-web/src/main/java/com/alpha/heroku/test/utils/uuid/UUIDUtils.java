package com.alpha.heroku.test.utils.uuid;

/**
 * * @author 龚玉鹏
 * 
 * @date 2017年2月16日 下午7:57:26
 */
public final class UUIDUtils {

	private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(getWorkerId());

	/**
	 * 得到有序的UUID
	 * 
	 * @author yaohuiyan
	 * @datetime 2017年11月25日 下午10:37:20
	 * @copyright (c) 2017,frontpay.cn
	 * @return
	 */
	public static String uuid() {
		return getSnowflakeId();
	}

	private static String getSnowflakeId() {
		return String.valueOf(snowflakeIdWorker.nextId());
	}

	private static long getWorkerId() {
		long workerId = IpUtils.getLastIpNum();
		if (workerId == -1l) {
			/**
			 * 本系统SnowflakeIdWorker的workerId范围为0-1023，ip最后一段数字最大为255
			 * 一旦获取本机ip失败，就取300-1023之间的随机数做为workerId
			 */
			workerId = RandomUtils.createNumber(300, 1023);
		}
		return workerId;
	}
}
