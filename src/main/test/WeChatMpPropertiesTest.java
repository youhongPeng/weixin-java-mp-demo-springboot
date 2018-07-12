import com.github.binarywang.demo.wx.mp.WxMpDemoApplication;
import com.github.binarywang.demo.wx.mp.config.WechatMpProperties;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pengyh
 * @date 2018/7/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class WeChatMpPropertiesTest {
    @Autowired
    WechatMpProperties wechatMpProperties;

    @Autowired
    WxMpService wxMpService;

    @Test
    public void ymlTest() throws WxErrorException{
        System.out.println("appid是-------"+wechatMpProperties.getAppId());
        System.out.println("secret是-------"+wechatMpProperties.getSecret());
        System.out.println("token是-------"+wechatMpProperties.getToken());
    }

    public void testSendKefuMessage() throws WxErrorException {
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConsts.KefuMsgType.TEXT);
        message.setToUser("o2gVL08BmOHJy0IbDiEH7BfvWkb0");
        message.setContent("欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");

        boolean result = this.wxMpService.getKefuService().sendKefuMessage(message);
        assertThat(result).isTrue();
    }

    @Test
    public void testSendKefuMessageWithKfAccount() throws WxErrorException {
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConsts.KefuMsgType.TEXT);
        message.setToUser("o2gVL08BmOHJy0IbDiEH7BfvWkb0");
        message.setKfAccount("");
        message.setContent("欢迎欢迎，热烈欢迎\n换行测试\n超链接:<a href=\"http://www.baidu.com\">Hello World</a>");

        boolean result = this.wxMpService.getKefuService().sendKefuMessage(message);
        assertThat(result).isTrue();
    }
}
