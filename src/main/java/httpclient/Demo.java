package httpclient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-25 23:43.
 */
public class Demo {
    private final static String TEST_URL = "http://192.168.72.233:8089/portal/restful/data/webuser/info";
    private final static String appSecret = "6ka6garpfci06ve9";
    private final static String appId = "0t580p8jzv10bma4";

    public static WebUser getUserInfo() {
        String result = null;
        try {
            Map<String, String> paramMap = new HashMap<>(1);
            //  paramMap.put(SMS_VALUE_CODE, randomCode);
            paramMap.put("appId", appId);
            paramMap.put("encryptData", makeEncryptDate(appId));
            paramMap.put("userName", "sjqyxxgly");
            paramMap.put("version", "v1.0");
            result = HttpClientUtils.post(TEST_URL, paramMap);
            return JsonUtils.json2pojo(result, WebUser.class);
        } catch (Exception e) {
            System.out.println(result);
        }
        return null;
    }

    private static String makeEncryptDate(String appId) throws Exception {
        long timeStamp = new Date().getTime() / 1000;
        byte[] bytes = new byte[4];
        new Random().nextBytes(bytes);
        String randId = bytes2Hex(bytes);
        StringBuilder sb = new StringBuilder("#!");
        sb.append(appId)
                .append(";")
                .append(timeStamp)
                .append(";")
                .append(randId);
        SecurityManager sm = new BlockTEASecurityManagerImpl();
        try {
            return sm.encrypt(sb.toString(), appSecret);
        } catch (SecurityException e) {
            throw new Exception("P_ENCRYPTION_FAIL");
        }
    }

    private static String bytes2Hex(byte[] src) {
        StringBuilder sb = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append(0);
            }
            sb.append(hv);
        }
        return sb.toString();
    }


        public static void main(String[] args){
            String str="123";
            String str1="123";
            System.out.println(str==str1);
            System.out.println(str.equals(str1));
             String str2 = new String("123");
             String str3 = new String("123");
             System.out.println(str2==str3);
             System.out.println(str2.equals(str3));
    }
}
