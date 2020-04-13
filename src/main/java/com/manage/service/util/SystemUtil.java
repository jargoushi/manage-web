package com.manage.service.util;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/10
 * @Content:
 */
public class SystemUtil {

    /**
     * @return
     * @throws MalformedObjectNameException 获取当前tomcat机器的端口号
     */
    public static String getLocalPort() throws MalformedObjectNameException {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        return port;
    }

    /**
     * @return 获取当前机器的IP
     */
    public static String getLocalIP() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }


        byte[] ipAddr = addr.getAddress();
        String ipAddrStr = "";
        for (int i = 0; i < ipAddr.length; i++) {
            if (i > 0) {
                ipAddrStr += ".";
            }
            ipAddrStr += ipAddr[i] & 0xFF;
        }
        return ipAddrStr;
    }
}
