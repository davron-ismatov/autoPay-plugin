package uz.zaytun.autopay.service;

import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.request.transaction.*;
import uz.zaytun.autopay.service.dto.response.transaction.*;

public interface TransactionService {
    AutopayBaseResponse<TransactionGetResponseDTO> get(TransactionGetRequestDTO dto);

    AutopayBaseResponse<TransactionSynchResponseDTO> sync(TransactionSynchRequestDTO dto);

    AutopayBaseResponse<TransactionDTO> findByExt(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionCancelResponseDTO> cancel(TransactionFindAndCancelRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationSetResponseDTO> verificationSet(TransactionVerificationSetRequestDTO dto);

    AutopayBaseResponse<TransactionVerificationCheckResponseDTO> verificationCheck(TransactionVerificationCheckRequestDTO dto);
}
