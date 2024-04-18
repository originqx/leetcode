package org.example.doublepoint;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;

public class MoveZeroes {
    public static void main(String[] args) {
//        new Solution().moveZeroes(new int[]{   0,  0, 1});
        Gson gson = new Gson();
        System.out.println(gson.toJson(ErrorType2.NETWORK));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            if (nums[i] == 0) {
                left = i;
                swap(nums, left, right);
            }
            right++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

enum ErrorType {
    NONE("服务端数据为空"),
    LOGIN_INVALID("登录状态异常，请重新登陆"),
    NETWORK("网络连接异常，请稍后重试"),
    PERMISSION_DENIED("无操作权限，请联系管理员分配"),
    BUSINESS("系统内部错误，请联系收银系统工作人员"),
    VERSION("主副收银版本不一致,请检查"),
    CONFIG_ERROR("有新的配置数据，请更新"),
    NEED_BUY("当前服务已到期，如需使用请联系销售人员购买"),
    DISK_FULL("磁盘可用空间不足，请清理");

    private String errorMsg;

    private ErrorType(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String toString() {
        return "ErrorType{errorMsg='" + this.errorMsg + '\'' + '}';
    }
}

enum ErrorType2 {
    // ... 枚举常量定义
    NONE("服务端数据为空"),
    LOGIN_INVALID("登录状态异常，请重新登陆"),
    NETWORK("网络连接异常，请稍后重试"),
    PERMISSION_DENIED("无操作权限，请联系管理员分配"),
    BUSINESS("系统内部错误，请联系收银系统工作人员"),
    VERSION("主副收银版本不一致,请检查"),
    CONFIG_ERROR("有新的配置数据，请更新"),
    NEED_BUY("当前服务已到期，如需使用请联系销售人员购买"),
    DISK_FULL("磁盘可用空间不足，请清理");

    private String errorMsg;

    private ErrorType2(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String toString() {
        return "ErrorType{errorMsg='" + this.errorMsg + '\'' + '}';
    }

    // 序列化代理类
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 123456789L; // 选择一个唯一的版本号
        private final String name; // 枚举的名字
        private final String errorMsg; // 需要序列化的额外信息

        SerializationProxy(ErrorType2 errorType) {
            this.name = errorType.name();
            this.errorMsg = errorType.getErrorMsg();
        }

        // 在反序列化时返回对应的枚举实例
        private Object readResolve() {
            return ErrorType.valueOf(name);
        }
    }

    // 在序列化时替换为代理实例
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // 其他方法和枚举定义 ...
}
