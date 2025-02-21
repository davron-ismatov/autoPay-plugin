package uz.zaytun.autopay.service;

import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;

public interface RequestSenderService {
    <T, R> AutopayBaseResponse<R> sendRequest(AutopayBaseRequest<T> request, Class<R> responseClass);
}
