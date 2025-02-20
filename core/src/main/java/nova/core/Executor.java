package nova.core;

public interface Executor<T,K> {
    T execute(K params);
}
