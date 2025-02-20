package com.example.autopayplugin.service;

import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.transaction.*;

public interface TransactionService {
    AutopayBaseResponse<TransactionGetResponseDTO> get(TransactionGetRequestDTO dto);

    AutopayBaseResponse<TransactionSynchResponseDTO> synch(TransactionSynchRequestDTO dto);

    AutopayBaseResponse<TransactionDTO> findByExt(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionCancelResponseDTO> cancel(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationSetResponseDTO> verificationSet(TransactionVerificationSetRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationCheckResponseDTO> verificationCheck(TransactionVerificationCheckRequestDTO dto);
}
