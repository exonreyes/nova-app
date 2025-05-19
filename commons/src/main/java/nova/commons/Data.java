package nova.commons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class Data<T> {
    private boolean success;
    private T data;
    private String message;
    private Instant timestamp;
    private Map<String, ?> meta;

    private Data(T data, String message, Map<String, ?> meta) {
        this.success = true;
        this.data = data;
        this.message = message;
        this.meta = meta;
        this.timestamp = Instant.now();
    }

    public static <T> Data<T> of(T data, String message) {
        return new Data<T>(data, message, null);
    }

    public static <T> Data<T> paginated(T data, int page, int size, Long totalItems, int totalPages) {
        Map<String, ?> meta = Map.of("page", page, "size", size, "totalItems", totalItems, "totalPages", totalPages);
        return new Data<T>(data, "Información paginada", meta);
    }
}