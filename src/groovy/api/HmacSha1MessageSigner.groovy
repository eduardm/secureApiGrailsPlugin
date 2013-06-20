package api

import org.apache.commons.codec.binary.Base64

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

public class HmacSha1MessageSigner {

    private static final String MAC_NAME = "HmacSHA1";


    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }


    public static String sign(String stringToBeSigned, String secret)
            throws Exception {
        String signature = calculateRFC2104HMAC(stringToBeSigned, secret);
        return signature;
    }

    private static String calculateRFC2104HMAC(String data, String key)
            throws Exception {
        String result;
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), MAC_NAME);

        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(data.getBytes());

        result =new String(new Base64().encode(rawHmac));

        return result;
    }
}
