package com.example.order.api;

import com.example.order.api.request.CreateKeyRequest;
import com.example.order.api.response.CreateKeyResponse;
import com.example.order.api.response.KeyDetailResponse;
import com.example.order.domain.Key;
import com.example.order.service.KeyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/keys")
public class KeyController {
    private KeyService keyService;

    @Autowired
    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create key.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created."),
    })
    public CreateKeyResponse createKey(@RequestBody CreateKeyRequest createKeyRequest) {
        Key key = keyService.create(createKeyRequest);
        return new CreateKeyResponse(key.getId());

    }


    @ApiOperation(value = "Get detail")
    @GetMapping("{id}")
    public KeyDetailResponse getDetail(@PathVariable String id) {
        return keyService.getKey(Long.valueOf(id));
    }
}
