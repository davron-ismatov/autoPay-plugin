package uz.zaytun.autopay.domain.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AutopayErrors {
    READ_TIMEOUT(new Message("Javobni o'qib olishda xatolik", "Ошибка чтение: время ожидания истекло", "Read timeout")),
    CONNECTION_TIMEOUT(new Message("Serverga ulanishda xatolik", "Ошибка соединения: время ожидания истекло", "Connection timeout")),
    UNKNOWN_ERROR(new Message("Kutilmagan xatolik", "Неизвестная ошибка", "Unknown error")),
    RESPONSE_IS_NULL(new Message("Javob bo'sh", "Ответ пуст", "Response is null")),
    CLIENT_ERROR(new Message("Mijoz xatosi", "Ошибка клиента", "Client error")),
    SERVER_ERROR(new Message("Server xatosi", "Ошибка сервера", "Server error")),
    RESPONSE_BODY_IS_NULL(new Message("Kutilayotgan javob bo'sh", "Тело ответа пусто", "Response body is null")),
    RESULT_IS_NULL(new Message("Qaytgan javob bo'sh", "Результат в теле пусто", "Result is null")),
    UNAUTHORIZED(new Message("Ruhsat yo'q", "Токен не действителен", "Unauthorized"));

    private final Message message;

    public record Message(String uz, String ru, String en) {
    }
}
