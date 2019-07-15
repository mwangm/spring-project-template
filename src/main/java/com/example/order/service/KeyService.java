package com.example.order.service;

import com.example.order.api.request.CreateKeyRequest;
import com.example.order.api.response.KeyDetailResponse;
import com.example.order.domain.Key;
import com.example.order.exception.NotFoundException;
import com.example.order.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeyService {

    private KeyRepository keyRepository;

    @Autowired
    public KeyService(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    public Key create(CreateKeyRequest request) {
        return keyRepository.save(
                Key.builder()
                        .number(request.getNumber())
                        .type(request.getType())
                        .build()
        );
    }

    public KeyDetailResponse getKey(Long id) {
        Optional<Key> key = keyRepository.findById(id);
        return key.map(KeyDetailResponse::fromKey).orElseThrow(NotFoundException::new);
    }
}
