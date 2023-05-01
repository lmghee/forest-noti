package com.ssafy.forest.jwt;

import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class JwtDecoder {

    public static DecodedToken decode(String jwt) throws UnsupportedEncodingException {
        String[] pieces = jwt.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");

        return new Gson().fromJson(jsonString, DecodedToken.class);
    }
}