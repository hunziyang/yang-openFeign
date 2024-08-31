package com.yang.order.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.order.result.Result;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.Type;

public class ResultDecode implements Decoder {

    private static final ObjectMapper objectMapper = new JacksonConfig().objectMapper();

    @SneakyThrows
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        String typeName = type.getTypeName();
        Class<?> aClass = Class.forName(typeName);
        if (Result.class.equals(aClass)) {
            throw new RuntimeException("feign 返回类型不对");
        }
        Response.Body body = response.body();
        if (body == null) {
            throw new RuntimeException("feign 响应体为空");
        }
        Result result = objectMapper.readValue(body.asInputStream(), Result.class);
        if (result.getCode() != 200) {
           throw new FeignErrorDecode().decode("", response);
        }
        return result;
    }
}
