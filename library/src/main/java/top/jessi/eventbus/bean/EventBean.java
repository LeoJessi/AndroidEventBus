package top.jessi.eventbus.bean;

/**
 * Created by Jessi on 2024/1/8 17:27
 * Email：17324719944@189.cn
 * Describe：EventBus实体类
 */
public final class EventBean<T> {
    private String message;
    private T data;

    public EventBean(String message) {
        this.message = message;
    }

    public EventBean(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SuppressWarnings("unchecked")
    public <T> T getData() {
        return (T) data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
