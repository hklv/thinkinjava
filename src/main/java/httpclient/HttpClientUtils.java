package httpclient;

import com.google.gson.JsonObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * http工具
 *
 * @author ZhangLu
 * @create 2016-12-26 15:41
 **/
public class HttpClientUtils {
    /**
     * Default charset for each request.
     */
    private static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * Default timeout for each request.
     */
    private static final int DEFAULT_TIMEOUT = 5000;

    /**
     * 构造器私有化
     */
    private HttpClientUtils() {
    }

    /**
     * 发送一个post请求
     *
     * @param url    地址
     * @param params 参数
     * @return 返回结果
     * @throws IOException
     */
    public static String post(String url, Map<String, String> params) throws IOException {
        PostMethod method = new PostMethod(url);
        method.setRequestHeader("Content-Type","application/json");
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, DEFAULT_CHARSET);
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, DEFAULT_TIMEOUT);

        if (MapUtils.isNotEmpty(params)) {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                jsonObject.addProperty(entry.getKey(),entry.getValue());
            }
            method.setRequestEntity(new StringRequestEntity(jsonObject.toString(),"application/json", "UTF-8"));

            }


        return executeMethod(method);
    }

    /**
     * 发送一个get请求
     *
     * @param url 地址
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        GetMethod method = new GetMethod(url);
        HttpMethodParams hmp = method.getParams();

        hmp.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, DEFAULT_CHARSET);
        hmp.setParameter(HttpMethodParams.SO_TIMEOUT, DEFAULT_TIMEOUT);

        return executeMethod(method);
    }

    /**
     * 执行post或者get方法
     *
     * @param method post或者get方法
     * @return
     * @throws IOException
     */
    private static String executeMethod(HttpMethodBase method) throws IOException {
        HttpClient httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
        try {
            int statusCode = httpClient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                throw new IOException("Method failed: " + method.getStatusLine());
            }

            // get response stream.
            InputStream stream = method.getResponseBodyAsStream();
           // System.out.println(IOUtils.toString(stream));
            // charset
            String charset = method.getRequestCharSet();
            String response;
            try {
                // try to turn stream to bytes.
                byte[] responseBytes = IOUtils.toByteArray(stream);
                // decode with the reponse charset.
                if (StringUtils.isNotBlank(charset)) {
                    try {
                        response = new String(responseBytes, charset);
                    } catch (UnsupportedEncodingException e) {
                        response = new String(responseBytes);
                    }
                } else {
                    // decode with default charset.
                    response = new String(responseBytes);
                }

                return response;
            } finally {
                // close stream.
                IOUtils.closeQuietly(stream);
            }
        } finally {
            // release connection.
            method.releaseConnection();
        }
    }
}
