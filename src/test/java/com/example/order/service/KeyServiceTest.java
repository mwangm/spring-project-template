package com.example.order.service;

import com.example.order.api.response.KeyDetailResponse;
import com.example.order.domain.Key;
import com.example.order.repository.KeyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class KeyServiceTest {
    @InjectMocks
    KeyService keyService;

    @Mock
    private KeyRepository keyRepository;

    @Test
    public void getKey() {
        Key key = Key.builder().number("32MGYYYY").build();
        given(keyRepository.findById(anyLong())).willReturn(Optional.of(key));

        KeyDetailResponse response = keyService.getKey(1L);

        assertThat(response.getNumber(), is(key.getNumber()));
        assertThat(response.getId(), is(key.getId()));
    }
}