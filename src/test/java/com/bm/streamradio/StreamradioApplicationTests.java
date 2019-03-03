package com.bm.streamradio;

import com.bm.streamradio.entity.Account;
import com.bm.streamradio.entity.Category;
import com.bm.streamradio.entity.Radio;
import com.bm.streamradio.entity.Station;
import com.bm.streamradio.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamradioApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void contextLoads() {
        Account account = new Account();
        account.setUser("alma");

        Category category = new Category();
        category.setName("pop");
        category.setDescription("valami");

        Radio station = new Radio();
        station.setName("elso");
        station.setDescription("leiras");

        category.addStation(station);
        //account.setCategories(Arrays.asList(category));
        account.addCategory(category);
        Account result = accountRepository.save(account);
        assertEquals(account, result);
    }

}
