package com.example.playwright;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.playwright.utils.BrowserUtil;
import com.playwright.utils.MiniMaxUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaywrightApplicationTests {

    @Autowired
    MiniMaxUtil miniMaxUtil;
    @Autowired
    BrowserUtil browserUtil;
    @Test
    void contextLoads() {
        BrowserContext context = browserUtil.createPersistentBrowserContext(false,String.valueOf(22),"minimax");
        Page page = context.newPage();
        String string = miniMaxUtil.waitAndGetMiniMaxAnswer(page, "你是谁，10个字说出来", "22", "MiniMax");
        System.out.println(string);
    }

}
