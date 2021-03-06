package com.whitemagic2014.util;

import com.whitemagic2014.bot.MagicBotR;
import com.whitemagic2014.util.time.MagicOnceTask;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.data.Message;

import java.util.Date;

/**
 * @Description: 用来发送消息的工具类
 * @author: magic chen
 * @date: 2020/9/29 16:31
 **/
public class MagicMsgSender {

    private static final Bot bot = MagicBotR.getBot();


    /**
     * @Name: sendGroupMsg
     * @Description: 发送群消息
     * @Param: groupId
     * @Param: msg
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/29 17:02
     **/
    public static void sendGroupMsg(Long groupId, Message msg) {
        bot.getGroup(groupId).sendMessage(msg);
    }

    /**
     * @Name: sendGroupMsgDelay
     * @Description: 发送延时群消息
     * @Param: groupId
     * @Param: msg
     * @Param: delay
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/30 17:07
     **/
    public static void sendGroupMsgDelay(Long groupId, Message msg, Long delay) {
        String key = MagicMd5.getMd5String("g" + groupId + msg.toString() + System.currentTimeMillis());
        new MagicOnceTask(key) {
            @Override
            public void handle() {
                bot.getGroup(groupId).sendMessage(msg);
            }
        }.schedule(delay);
    }

    /**
     * @Name: sendGroupMsgTiming
     * @Description: 发送定时群消息
     * @Param: groupId
     * @Param: msg
     * @Param: time
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/30 17:07
     **/
    public static void sendGroupMsgTiming(Long groupId, Message msg, Date time) {
        String key = MagicMd5.getMd5String("g" + groupId + msg.toString()+ System.currentTimeMillis());
        new MagicOnceTask(key) {
            @Override
            public void handle() {
                bot.getGroup(groupId).sendMessage(msg);
            }
        }.schedule(time);
    }

    /**
     * @Name: sendFriendMsg
     * @Description: 发送私聊消息
     * @Param: uid
     * @Param: msg
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/29 17:12
     **/
    public static void sendFriendMsg(Long uid, Message msg) {
        bot.getFriend(uid).sendMessage(msg);
    }


    /**
     * @Name: sendFriendMsgDelay
     * @Description: 发送延时私聊消息
     * @Param: uid
     * @Param: msg
     * @Param: delay
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/30 17:10
     **/
    public static void sendFriendMsgDelay(Long uid, Message msg, Long delay) {
        String key = MagicMd5.getMd5String("u" + uid + msg.toString()+ System.currentTimeMillis());
        new MagicOnceTask(key) {
            @Override
            public void handle() {
                bot.getFriend(uid).sendMessage(msg);
            }
        }.schedule(delay);
    }


    /**
     * @Name: sendFriendMsgTiming
     * @Description: 发送定时私聊消息
     * @Param: uid
     * @Param: msg
     * @Param: time
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/30 17:10
     **/
    public static void sendFriendMsgTiming(Long uid, Message msg, Date time) {
        String key = MagicMd5.getMd5String("u" + uid + msg.toString()+ System.currentTimeMillis());
        new MagicOnceTask(key) {
            @Override
            public void handle() {
                bot.getFriend(uid).sendMessage(msg);
            }
        }.schedule(time);
    }


    /**
     * @Name: sendBoradcast
     * @Description: 发送广播消息
     * @Param: msg
     * @Return: void
     * @Author: magic chen
     * @Date: 2020/9/29 17:02
     **/
    public static void sendBoradcast(Message msg) {
        for (Group g : bot.getGroups()) {
            g.sendMessage(msg);
        }
    }


}
