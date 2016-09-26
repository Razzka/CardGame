package com.razzka.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ControllerHelper {
    public static HttpHeaders httpHeaderImage(final String fileName, final int fileSize) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.IMAGE_PNG);
        responseHeaders.setContentLength(fileSize);
        return responseHeaders;
    }
    
    public static HttpHeaders httpHeaderEntity() {
    	HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_PLAIN);
        return responseHeaders;
    }
}
