package nova.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Data<T> {
    private T data;
    private Pagination pagination;
    private String code;
    private String message;

    public Data(T data) {
        this.data = data;
    }

    public Data(T data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }
}