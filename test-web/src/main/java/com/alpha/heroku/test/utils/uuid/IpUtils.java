package com.alpha.heroku.test.utils.uuid;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ucs_wangguangyun on 2017/2/28.
 */
public class IpUtils {

    private final static Logger logger = LoggerFactory.getLogger(IpUtils.class);

    public static String getHostAddress() {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            return ip;
        } catch (UnknownHostException e) {
            logger.error("error getting local host ip.", e);
            return null;
        }
    }    

    /**
     * 获取ip串中最后的数字
     * @return
     */
    public static long  getLastIpNum(){
        String ip=getHostAddress();
        if(ip==null){
            return -1l;
        }
        String lastNum=ip.substring(ip.lastIndexOf('.')+1);
        return Long.valueOf(lastNum);
    }


    public static void main(String[] args) {
        System.out.println(IpUtils.getLastIpNum());
    }

}
