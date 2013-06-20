package api

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.Base64

class HmacSha1MessageSigner {

    private static final String MAC_NAME = "HmacSHA1"

    String getSignatureMethod() {
        return "HMAC-SHA1"
    }

    static String sign(String stringToBeSigned, String secret) {
        return calculateRFC2104HMAC(stringToBeSigned, secret)
    }

    private static String calculateRFC2104HMAC(String data, String key) {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), MAC_NAME)

        Mac mac = Mac.getInstance(MAC_NAME)
        mac.init(signingKey)

        byte[] rawHmac = mac.doFinal(data.getBytes())

        return new String(new Base64().encode(rawHmac))
    }
}
