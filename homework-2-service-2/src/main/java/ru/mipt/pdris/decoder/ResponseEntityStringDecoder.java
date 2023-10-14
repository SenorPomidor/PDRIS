package ru.mipt.pdris.decoder;

import feign.Response;
import feign.codec.Decoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ResponseEntityStringDecoder implements Decoder {

    @Override
    public Object decode(Response response, Type type) throws IOException {
        if (type instanceof ParameterizedType parameterizedType) {
            if (ResponseEntity.class.equals(parameterizedType.getRawType()) &&
                    String.class.equals(parameterizedType.getActualTypeArguments()[0])) {
                InputStreamReader isReader = new InputStreamReader(response.body().asInputStream());
                BufferedReader reader = new BufferedReader(isReader);
                String responseBody = reader.readLine();
                HttpStatus status = HttpStatus.valueOf(response.status());
                return new ResponseEntity<>(responseBody, status);
            }
        }
        throw new UnsupportedOperationException();
    }
}
