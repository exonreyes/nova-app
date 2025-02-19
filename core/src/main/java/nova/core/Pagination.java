package nova.core;

public record Pagination(int page, int size, Long totalItems, int totalPages) {
}