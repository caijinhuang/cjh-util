## 小Cai工具包
> 需求背景：项目开发中时常会遇到http请求或者解析request的post请求中json参数对象的流等问题。以及项目开发中遇到的比较普遍的问题，于是整理出来的实用小工具。一来是方便下次使用二来是对工具进行整理归类，方便下次改进。
 
 ### 目前支持以下工具方法
 - com.cjh.common.util.http.*
    - HttpRequestUtil 【 http请求 】
        - String post(url,String jsonObj)
        - String get(url)
    - RequestParseUtils 【 解析HttpServletRequest 请求对象内容，设计初衷是为了解析post请求的json对象 】
        - String getRequestJsonString(HttpServletRequest request) 【获取客户端请求的数据】
        - String getRequestPostStr(HttpServletRequest request) 【获取客户端post请求的字符串内容】
        - byte[] getRequestPostBytes(HttpServletRequest request) 【获取post的json数据流字节数组】
        
 
 > 持续更新中。。。。