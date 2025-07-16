package com.playwright;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
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
    void contextLoads() throws InterruptedException {
        BrowserContext context = browserUtil.createPersistentBrowserContext(false,String.valueOf(22),"minimax");
        Page page = context.newPage();
        // 获取输入框并输入内容
        page.navigate("https://chat.minimaxi.com/");
        Thread.sleep(3000);
        page.locator("xpath=/html/body/section/div/div/section/header/div[2]/div[2]/div[2]/div").click();
        Locator phone = page.locator(".h-7.w-7.rounded-full").nth(2);
        phone.waitFor(new Locator.WaitForOptions().setTimeout(12000).setState(WaitForSelectorState.ATTACHED));;
        System.out.println("Count: " + phone.count());
        System.out.println("IsVisible: " + phone.first().isVisible());
        System.out.println("IsEnabled: " + phone.first().isEnabled());

//        page.locator("//*[@id=\"chat-input\"]").nth(1).click();
//        Thread.sleep(1000);
//        page.locator("//*[@id=\"chat-input\"]").nth(1).fill("你好");
//        logInfo.sendTaskLog( "用户指令已自动输入完成",userId,"MiniMax");
//        Thread.sleep(1000);
//        page.locator("//*[@id=\"chat-input\"]").nth(1).press("Enter");
//        logInfo.sendTaskLog("指令已自动发送成功", userId, "MiniMax");
//        String string = miniMaxUtil.waitMiniMaxHtmlDom(page,  "22", "MiniMax");
//        System.out.println(string);
    }

}
