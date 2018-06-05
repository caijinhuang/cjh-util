/*
 * @(#) HttpRequestUtilTest
 *
 * <br> @author cjh
 * <br> 2018-06-05 22:11:31
 * <br> @version 1.0
 * ————————————————————————————————
 *     修改记录
 *     修改者：
 *     修改时间：
 *     修改原因：
 * ————————————————————————————————
 */

package com.cjh.common.util.http;

import com.alibaba.fastjson.JSON;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class HttpRequestUtilTest {

    Logger logger = Logger.getLogger(getClass());
    @Test
    public void get() throws Exception {
        String url = "http://localhost:8080/reader/jsonTest";
        Map data = new HashMap();
        data.put("userName","小菜");
        String result  = HttpRequestUtil.post(url, JSON.toJSONString(data));
        logger.info("打印日志:"+result);
    }

    @Test
    public void post() throws Exception {
    }

}