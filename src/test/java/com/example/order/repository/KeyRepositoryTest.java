package com.example.order.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = {"test"})
@DataJpaTest
public class KeyRepositoryTest {

    @Autowired
    private KeyRepository keyRepository;

    @Test
    public void test(){
        System.out.println("^^^^^^^^^^");
    }

}