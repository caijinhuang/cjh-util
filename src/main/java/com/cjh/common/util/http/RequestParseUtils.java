/*
 * @(#) GetRequestJsonUtils
 *
 * <br> @author cjh
 * <br> 2018-06-05 22:36:08
 * <br> @version 1.0
 * servlet的post请求，请求参数解析
 * ————————————————————————————————
 *     修改记录
 *     修改者：
 *     修改时间：
 *     修改原因：
 * ————————————————————————————————
 */

package com.cjh.common.util.http;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取request中的json数据
 */
public class RequestParseUtils {

    static Logger logger = Logger.getLogger("");

    /**
     * 获取客户端请求的数据
     * @param request HttpServletRequest
     * @return
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
        throws IOException {
        String submitMehtod = request.getMethod();
        // GET ：get请求直接获取url参数并去除空格
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
            // POST ：post请求需要读取输入字节流信息，反序列化成字符串
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 获取request请求的字符串内容
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
        throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    /**
     * 获取对象字节数组
     * @param request
     * @return
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request){
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return new byte[0];
        }
        byte[] buffer = new byte[contentLength];
        for (int i=0;i<contentLength;){
            try {
                int readlen = request.getInputStream().read(buffer,i,contentLength-i);
                if(readlen == -1){
                    break;
                }
                i += readlen;
            } catch (IOException e) {
                logger.error("对象读取错误:"+e.getStackTrace());
            }
        }
        return buffer;
    }
}
