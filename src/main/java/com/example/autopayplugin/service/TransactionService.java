package com.example.autopayplugin.service;

import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.request.transaction.*;
import com.example.autopayplugin.service.dto.response.transaction.*;

public interface TransactionService {
    AutopayBaseResponse<TransactionGetResponseDTO> get(TransactionGetRequestDTO dto);

    AutopayBaseResponse<TransactionSynchResponseDTO> sync(TransactionSynchRequestDTO dto);

    AutopayBaseResponse<TransactionDTO> findByExt(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionCancelResponseDTO> cancel(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationSetResponseDTO> verificationSet(TransactionVerificationSetRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationCheckResponseDTO> verificationCheck(TransactionVerificationCheckRequestDTO dto);
}
