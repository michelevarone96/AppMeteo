package com.mvarone.appmeteo.util;

import java.util.Base64;

public class Base64Decoder {

    public static String decodeBase64(String encoded) {
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return new String(decodedBytes);
    }
}
