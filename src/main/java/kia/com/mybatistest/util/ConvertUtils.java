package kia.com.mybatistest.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Slf4j
public class ConvertUtils {

    public static String encoder(String str){
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("unsupportedEncoding: {}", e.getCause());
            return e.getMessage();
        }
    }

    public static String decoder(String str){
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("unsupportedEncoding: {}", e.getCause());
            return e.getMessage();
        }
    }
}
