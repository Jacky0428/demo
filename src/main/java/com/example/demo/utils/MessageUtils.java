package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 訊息工具類
 * 用於 Controller 中回傳給前端
 */
public class MessageUtils {

    /**
     * 狀態列舉
     * success : 成功
     * error   : 失敗
     */
    private enum Status {
        success, // 成功
        error // 失敗
    }

    private MessageUtils() { }

    /**
     * 成功時的訊息格式 (無資料)
     * @return Map 回傳訊息格式
     */
    public static Map<String, Object> success() {
        Map<String, Object> map = new HashMap<>();
        // 成功狀態
        map.put("status", Status.success);
        return map;
    }

    /**
     * 成功時的訊息格式
     *
     * @param data 資料
     * @return Map 回傳訊息格式
     */
    public static Map<String, Object> success(Object data) {
        Map<String, Object> map = new HashMap<>();
        // 成功狀態
        map.put("status", Status.success);
        // 資料
        map.put("data", data);
        return map;
    }


    /**
     * 失敗時的訊息格式
     *
     * @param message 錯誤訊息
     * @return Map 回傳訊息格式
     */
    public static Map<String, Object> error(String message) {
        Map<String, Object> map = new HashMap<>();
        // 失敗狀態
        map.put("status", Status.error);
        // 資料
        map.put("message", message);
        return map;
    }

}