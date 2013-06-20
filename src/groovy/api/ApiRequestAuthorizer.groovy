package api

import api.exception.ApiInvalidKeyException
import api.exception.ApiRequestExpiredException
import api.exception.ApiInvalidSignatureException

@SuppressWarnings("serial")
public class ApiRequestAuthorizer {
    private final static Long ALLOWED_TIMESTAMP_INTERVAL = 600000;

    public boolean isAuthorized(request, consumers) {

        boolean hasValidKey = isValidKey(request.parameterMap["key"][0]);

        if (hasValidKey) {
            boolean hasValidTimestamp = isValidTimestamp(request.parameterMap["timestamp"][0]);

            if (hasValidTimestamp) {
                String stringToBeSigned = createStringToBeSigned(request);

                boolean hasValidSignature = isValidSignature(stringToBeSigned, request.parameterMap["signature"][0], consumers[request.parameterMap["key"][0]]);

                if (hasValidSignature) {
                    return true;
                } else {
                    throw new ApiInvalidSignatureException("Failed to authenticate with signature: ${request.parameterMap["signature"][0]}");
                }

            } else {
                throw new ApiRequestExpiredException("Timestamp: ${request.parameterMap["timestamp"][0]} rejected");
            }

        } else {
            throw new ApiInvalidKeyException("Key: ${request.parameterMap["key"][0]} is not valid");
        }

        return true;
    }

    private static boolean isValidKey(String key, Map<String, String> consumers) {
        if (key && consumers.keySet().contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidTimestamp(String timestamp) {

        if (timestamp) {
            Long currentTimestamp = getCurrentTimestamp()
            if (currentTimestamp - Long.parseLong(timestamp, 10) < ALLOWED_TIMESTAMP_INTERVAL) {
                return true;
            }
        }
        return false;

    }

    private static String createStringToBeSigned(request) {
        String filteredQueryString = request.queryString.replaceAll(/(&signature=[^&]+)/, '');
        String stringToBeSigned = request.method + request.scheme + "://" + request.serverName + request.forwardURI + "?" + filteredQueryString;
        return URLEncoder.encode(stringToBeSigned, "UTF8");
    }

    private static boolean isValidSignature(String stringToBeSigned, String signature, String secret) {
        if (signature) {
            String computedSignature = HmacSha1MessageSigner.sign(stringToBeSigned, secret);
            if (computedSignature.equals(signature)) {
                return true;
            }
        }
        return false;

    }

    protected Long getCurrentTimestamp() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Long currentTimestamp = calendar.getTimeInMillis();
        return currentTimestamp
    }

}
