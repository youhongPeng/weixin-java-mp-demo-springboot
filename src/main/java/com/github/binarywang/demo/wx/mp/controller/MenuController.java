package com.github.binarywang.demo.wx.mp.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pengyh
 * @date 2018/7/11
 */
@RestController
@RequestMapping("/wc/menu")
public class MenuController {


    @Autowired
    WxMpService wxMpService;

    @GetMapping(value = "/create",produces = "text/plain;charset=utf-8")
    public String menuCreate() throws WxErrorException{

        WxMenu menu = new WxMenu();

        WxMenuButton button1 = new WxMenuButton();
        button1.setName("个人中心");

        WxMenuButton button11=new WxMenuButton();
        button11.setType(WxConsts.MenuButtonType.VIEW);
        button11.setName("账号管理");
        button11.setUrl("https://www.jianshu.com/");

        WxMenuButton button2 = new WxMenuButton();
        button2.setName("会议预约");

        WxMenuButton button21=new WxMenuButton();
        button21.setType(WxConsts.MenuButtonType.VIEW);
        button21.setName("预约普通会议");
        button21.setUrl("https://github.com/");

        WxMenuButton button22=new WxMenuButton();
        button22.setType(WxConsts.MenuButtonType.VIEW);
        button22.setName("预约视频会议");
        button22.setUrl("https://github.com/");

        WxMenuButton button3 = new WxMenuButton();
        button3.setName("我的会议");

        WxMenuButton button31 = new WxMenuButton();
        button31.setType(WxConsts.MenuButtonType.VIEW);
        button31.setName("我的会议及日程");
        button31.setUrl("http://www.soso.com/");

        WxMenuButton button32 = new WxMenuButton();
        button32.setType(WxConsts.MenuButtonType.VIEW);
        button32.setName("会议控制");
        button32.setUrl("http://www.soso.com/");

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        button1.getSubButtons().add(button11);

        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);

        button3.getSubButtons().add(button31);
        button3.getSubButtons().add(button32);

        return this.wxMpService.getMenuService().menuCreate(menu);
    }
}
