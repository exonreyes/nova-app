package nova.commons;

public interface Executor<T, K> {
    T execute(K params);
}
