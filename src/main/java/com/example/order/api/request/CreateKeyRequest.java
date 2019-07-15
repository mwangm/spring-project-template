package com.example.order.api.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateKeyRequest {
    @NotNull
    String number;

    @NotNull
    String type;
}
