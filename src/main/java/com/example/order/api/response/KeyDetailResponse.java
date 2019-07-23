package com.example.order.api.response;

import com.example.order.domain.Key;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class KeyDetailResponse {
    private Long id;
    private String number;

    public static KeyDetailResponse fromKey(Key key) {
        return KeyDetailResponse.builder()
                .id(key.getId())
                .number(key.getNumber())
                .build();
    }
}
