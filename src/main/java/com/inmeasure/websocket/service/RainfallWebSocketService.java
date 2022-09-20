package com.inmeasure.websocket.service;

import com.alibaba.fastjson.JSON;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Rainfall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint(path = "/webSocket/rainfall/{deviceId}")
public class RainfallWebSocketService {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的TempHumWebSocketService对象。
     */
    private static ConcurrentHashMap<Long, RainfallWebSocketService> webSocketMap = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 接收deviceId
     */
    private Long deviceId = null;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathVariable() Long deviceId) {
        //获取当前连接的session和前端回传的设备id
        this.session = session;
        this.deviceId = deviceId;
        //将设备id和TempHumWebSocketService组成键值对存入Map中，以便后续获取信息
        if (webSocketMap.containsKey(deviceId)) {
            webSocketMap.remove(deviceId);
            webSocketMap.put(deviceId, this);
        } else {
            webSocketMap.put(deviceId, this);
            //在线设备加一
            addOnlineCount();
        }
        log.info("设备显示端连接:" + deviceId + ",当前设备显示端数为:" + getOnlineCount());
        sendMessage("连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(deviceId)) {
            webSocketMap.remove(deviceId);
            subOnlineCount();
        }
        log.info("设备显示端退出:" + deviceId + ",当前设备显示端数为:" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param msg
     * @param session
     */
    @OnMessage
    public void onMessage(String msg, Session session) {
        log.info("设备显示端:" + deviceId + ",报文:" + msg);
    }

    /**
     * websock连接出错
     *
     * @param session
     * @param error
     */
    public void onError(Session session, Throwable error) {
        log.error("设备显示端:" + this.deviceId + ",原因:" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) {
        this.session.sendText(message);
    }

    /**
     * 服务器向特定客户端发送自定义消息
     * @param rainfall
     */
    public static void sendInfo(Rainfall rainfall) {
        Long deviceId = rainfall.getDeviceId();
        //判断当前设备显示端是否已经建立连接
        if (deviceId != null && webSocketMap.containsKey(deviceId)) {
            //从Map中获取当前设备id对应的TempHumWebSocketService对象
            RainfallWebSocketService coWebSocketService = webSocketMap.get(deviceId);
            //将消息对象转成json字符串
            String msg = JSON.toJSONString(rainfall);
            //获取当前设备id对应的session对象，并发送消息
            coWebSocketService.session.sendText(msg);
        } else {
            log.error("设备显示端：" + deviceId + "未连接");
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        RainfallWebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        RainfallWebSocketService.onlineCount--;
    }

}
