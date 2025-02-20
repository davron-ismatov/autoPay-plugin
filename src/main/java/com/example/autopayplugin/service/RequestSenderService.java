package com.example.autopayplugin.service;

import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;

public interface RequestSenderService {
    <T, R> AutopayBaseResponse<R> sendRequest(AutopayBaseRequest<T> request, Class<R> responseClass);
}
