package httpclient;

public class BlockTEASecurityManagerImpl implements SecurityManager{

    public BlockTEASecurityManagerImpl() {
    }

    /**
     * decrypt
     *
     * @param ciphertext String
     * @param shareKey String
     * @return String
     * @throws SecurityException <br>
     * @todo Implement this com.ztesoft.sso.security.SecurityManager method
     */
    public String decrypt(String ciphertext, String shareKey) throws SecurityException {
        String plaintext = null;
        try {
            plaintext = teaDecrypt(ciphertext, shareKey);
        }
        catch (Exception ex) {
            throw new SecurityException("Error:teaDecrypt-ciphertext=" + ciphertext + ";shareKey=" + shareKey, ex);
        }
        return plaintext;
    }

    /**
     * encrypt
     *
     * @param plaintext String
     * @param shareKey String
     * @return String
     * @throws SecurityException <br>
     * @todo Implement this com.ztesoft.sso.security.SecurityManager method
     */
    public String encrypt(String plaintext, String shareKey) throws SecurityException {
        String ciphertext = null;
        try {
            ciphertext = teaEncrypt(plaintext, shareKey);
        }
        catch (Exception ex) {
            throw new SecurityException("Error:teaEncrypt-plaintext=" + plaintext + ";securityKey=" + shareKey, ex);
        }

        return ciphertext;
    }

    //
    // teaEncrypt: Use Corrected Block TEA to encrypt plaintext using password
    // (note plaintext & password must be strings not string objects)
    //
    // Return encrypted text as string
    //
    /**
     * teaEncrypt <br>
     *
     * @param plaintext <br>
     * @param password <br>
     * @return String <br>
     */
    private String teaEncrypt(String plaintext, String password) {
        if (plaintext.length() == 0) {
            return (""); // nothing to encrypt
        }
        // 'escape' plaintext so chars outside ISO-8859-1 work in single-byte packing, but keep
        // spaces as spaces (not '%20') so encrypted text doesn't grow too long (quick & dirty)
        String asciitext = plaintext;
        int[] v = strToLongs(asciitext); // convert string to array of longs

        if (v.length <= 1) {
            int[] temp = new int[2];
            temp[0] = 0; // algorithm doesn't work for n<2 so fudge by adding a null
            temp[1] = v[0];
            v = temp;
        }
        int[] k = strToLongs(password.substring(0, 16).toLowerCase()); // simply convert first 16 chars of password as
        // key
        int n = v.length;

        // int z = v[n - 1], y = v[0], delta = 0x9E3779B9;
        // int mx, e, q = (int) Math.floor(6 + 52 / n), sum = 0;
        int z = v[n - 1];
        int y = v[0];
        int delta = 0x9E3779B9;
        int mx;
        int e;
        int q = (int) Math.floor(6 + 52 / n);
        int sum = 0;

        while (q-- > 0) { // 6 + 52/n operations gives between 6 & 32 mixes on each word
            sum += delta;
            e = sum >>> 2 & 3;
            for (int p = 0; p < n; p++) {
                y = v[(p + 1) % n];
                mx = (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
                z = v[p] += mx;
            }
        }

        String ciphertext = longsToHexStr(v);

        return ciphertext;
    }

    //
    // teaDecrypt: Use Corrected Block TEA to decrypt ciphertext using password
    //
    /**
     * teaDecrypt <br>
     *
     * @param ciphertext <br>
     * @param password <br>
     * @return String <br>
     */
    private String teaDecrypt(String ciphertext, String password) {
        if (ciphertext.length() == 0) {
            return ("");
        }
        int[] v = hexStrToLongs(ciphertext);
        int[] k = strToLongs(password.substring(0, 16).toLowerCase());
        int n = v.length;

        // int z = v[n - 1], y = v[0], delta = 0x9E3779B9;
        // int mx, e, q = (int) Math.floor(6 + 52 / n), sum = q * delta;
        int z = v[n - 1];
        int y = v[0];
        int delta = 0x9E3779B9;
        int mx;
        int e;
        int q = (int) Math.floor(6 + 52 / n);
        int sum = q * delta;

        while (sum != 0) {
            e = sum >>> 2 & 3;
            for (int p = n - 1; p >= 0; p--) {
                z = v[p > 0 ? p - 1 : n - 1];
                mx = (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
                y = v[p] -= mx;
            }
            sum -= delta;
        }

        String plaintext = longsToStr(v);

        // strip trailing null chars resulting from filling 4-char blocks:

        return plaintext;
    }

    // supporting functions
    /*--------------------------str begin---------------------------------*/
    /**
     * strToLongs
     *
     * @param s String
     * @return int[]
     */
    private int[] strToLongs(String s) { // convert string to array of longs, each containing 4 chars
        // note chars must be within ISO-8859-1 (with Unicode code-point < 256) to fit 4/long
        int length = s.length() / 4;
        int left = s.length() % 4;
        if (left > 0) {
            length++;
        }
        int[] longs = new int[length];
        int maxIndex = length;
        if (left > 0) {
            maxIndex--;
        }
        for (int i = 0; i < maxIndex; i++) {
            // note little-endian encoding - endianness is irrelevant as long as
            // it is the same in longsToStr()
            longs[i] = (int) s.charAt(i * 4) + ((int) s.charAt(i * 4 + 1) << 8) + ((int) s.charAt(i * 4 + 2) << 16)
                    + ((int) s.charAt(i * 4 + 3) << 24);
        }
        if (left > 0) {
            // flag is ture,to process the left chars
            for (int j = 0; j < left; j++) {
                longs[maxIndex] += (int) (s.charAt(maxIndex * 4 + j) << (j * 8));
            }
        }

        return longs; // note running off the end of the string generates nulls since
    } // bitwise operators treat NaN as 0

    /**
     * longsToStr<br>
     *
     * @param longs int[]
     * @return <br>
     */
    private String longsToStr(int[] longs) { // convert array of longs back to string
        String result = "";
//        int[] a = new int[longs.length];
        for (int i = 0; i < longs.length; i++) {
            // a[i] = longToStr(longs[i]);
            // result += a[i];
            result += longToStr(longs[i]);
        }
        return result; // use Array.join() rather than repeated string appends for efficiency
    }

    /**
     * longToStr <br>
     *
     * @param l int
     * @return <br>
     */
    private static String longToStr(int l) {
        if (l == 0) {
            return "";
        }
        char c[] = new char[4];
        int index = -1;
        for (int i = 0; i < 4; i++) {
            c[i] = (char) (l >>> ((3 - i) * 8) & 0xff);
            if (c[i] > 0 && index < 0) {
                index = i;
            }
        }
        char[] newc = new char[4 - index];
        for (int i = 0; i < 4 - index; i++) {
            // newc[i] = c[3 - i];
            System.arraycopy(c, 3 - i, newc, i, 1);
        }
        return new String(newc);
    }

    /*--------------------------str end---------------------------------*/

    /*--------------------------hex str begin---------------------------------*/
    /**
     * hexStrToLongs
     *
     * @param s String
     * @return int[]
     */
    private int[] hexStrToLongs(String s) { // convert string to array of longs, each containing 4 chars
        // note chars must be within ISO-8859-1 (with Unicode code-point < 256) to fit 4/long
        String[] ss = s.split("-");
        int length = ss.length;
        int[] longs = new int[length];

        for (int i = 0; i < length; i++) {
            byte[] bytes = UnicodeFormatter.hexStrToBytes(ss[i]);
            for (int j = 0; j < bytes.length; j++) {
                longs[i] += UnicodeFormatter.byteToInt(bytes[j]) << (j * 8);
            }
        }

        return longs; // note running off the end of the string generates nulls since
    } // bitwise operators treat NaN as 0

    /**
     * longsToHexStr <br>
     *
     * @param longs int[]
     * @return <br>
     */
    private String longsToHexStr(int[] longs) {
        String result = "";
        String[] a = new String[longs.length];
        for (int i = 0; i < longs.length; i++) {
            a[i] = longToHexStr(longs[i]);
            if (i > 0) {
                result += "-";
            }
            result += a[i];
        }
        return result;
    }

    /**
     * longToHexStr<br>
     *
     * @param l int
     * @return <br>
     */
    private static String longToHexStr(int l) {
        char c[] = new char[4];
        int index = -1;
        for (int i = 0; i < 4; i++) {
            c[i] = (char) (l >>> ((3 - i) * 8) & 0xff);
            if (c[i] > 0 && index < 0) {
                index = i;
            }
        }
        byte[] newc = new byte[4 - index];
        for (int i = 0; i < 4 - index; i++) {
            newc[i] = (byte) c[3 - i];
        }
        return UnicodeFormatter.bytesToHexStr(newc);
    }

}
