package com.test.utilforwork;

import org.apache.log4j.Logger;

import java.util.UUID;

public class UUIDTool {
    private static final Logger logger = Logger.getLogger(UUIDTool.class);
    public UUIDTool() {
    }
    public static String getUUID() {
		/*UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;*/

        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
//		String[] ss = getUUID(10);
        for (int i = 0; i < 45; i++) {
//            System.out.println(getUUID());
            logger.info(getUUID());
        }
//        System.out.println(getUUID().length());
    }

}
