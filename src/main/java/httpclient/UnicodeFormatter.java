package httpclient;

/**
 * UnicodeFormatter
 */
public class UnicodeFormatter {
    /**
     * Returns hex String representation of byte b
     */
    private static char hexDigit[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    /**
     * byteToHex
     *
     * @param b byte
     * @return String
     */
    public static String byteToHex(byte b) {

        char[] array = {
                hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f]
        };
        return new String(array);
    }

    /**
     * charToHex
     *
     * @param c char
     * @return String
     */
    public static String charToHex(char c) {
        // Returns hex String representation of char c
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
        return byteToHex(hi) + byteToHex(lo);
    }

    /**
     * hexToByte
     *
     * @param hex String
     * @return byte
     */
    public static byte hexToByte(String hex) {
        int result = 0;

        if (hex.charAt(0) <= 57) {
            result = (hex.charAt(0) - 48) * 16;
        } else {
            result = (hex.charAt(0) - 55) * 16;
        }
        if (hex.charAt(1) <= 57) {
            result += (hex.charAt(1) - 48);
        } else {
            result += (hex.charAt(1) - 55);
        }

        return (byte) result;
    }

    /**
     * bytesToHexStr
     *
     * @param bytes byte[]
     * @return String
     */
    public static String bytesToHexStr(byte[] bytes) {
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            result += byteToHex(bytes[i]);
        }
        return result;
    }

    /**
     * hexStrToBytes
     *
     * @param hexes String
     * @return byte[]
     */
    public static byte[] hexStrToBytes(String hexes) {
        byte result[] = new byte[hexes.length() / 2];
        for (int i = 0; i < hexes.length() / 2; i++) {
            result[i] = hexToByte(hexes.substring(2 * i, 2 * i + 2));
        }
        return result;
    }

    /**
     * byteToInt
     *
     * @param b byte
     * @return int
     */
    public static int byteToInt(byte b) {
        return (b << 24) >>> 24;
    }
}
