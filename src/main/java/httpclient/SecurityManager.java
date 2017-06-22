package httpclient;

/**
 * zhanglu
 */
public interface SecurityManager {

    /**
     * 加密接口 <br>
     *
     * @param plaintext <br>
     * @param shareKey <br>
     * @return String <br>
     * @throws SecurityException <br>
     */
    String encrypt(String plaintext, String shareKey) throws SecurityException;

    /**
     * 解密接口 <br>
     *
     * @param ciphertext <br>
     * @param shareKey <br>
     * @return String <br>
     * @throws SecurityException <br>
     */
    String decrypt(String ciphertext, String shareKey) throws SecurityException;
}
