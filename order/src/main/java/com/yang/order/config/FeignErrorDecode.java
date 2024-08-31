package com.yang.order.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecode implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return new RuntimeException("LLLL");
    }
}
