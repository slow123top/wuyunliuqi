package icat.sinomed.entity;

import java.util.HashMap;
import java.util.Map;

import jodd.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liucong on  16-3-25-025.
 */
@Slf4j
public class APIResponse {
    private String message;
    private Status status;
    private String code;
    private Object data;

    public enum Status {
        SUCCESS, ERROR, UNDEFINED
    }

    public static APIResponse newSuccessApiResponse(String message) {
        return new APIResponse(message, Status.SUCCESS);
    }

    public static APIResponse newSuccessApiResponse() {
        return new APIResponse("", Status.SUCCESS);
    }

    public static APIResponse newErrorApiResponse() {
        return new APIResponse("", Status.ERROR);
    }

    public APIResponse() {
        this("", Status.UNDEFINED);
    }

    public APIResponse(String message, Status status) {
        this(message, status, "");
    }

    public APIResponse(String message, Status status, String code) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.data = new HashMap<>();
    }

    public String getMessage() {
        return message;
    }

    public APIResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public APIResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public APIResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public APIResponse setData(Object data) {
        this.data = data;
        return this;
    }

    @SuppressWarnings("unchecked")
    public APIResponse setDataValue(String key, Object value) {
        if (this.data == null) {
            this.data = new HashMap<>();
        }

        if (this.data instanceof Map) {
            Map map = (Map) this.data;
            map.put(key, value);
        } else {
            BeanUtil.declaredForcedSilent.setProperty(this.data, key, value);
        }

        return this;
    }

}
