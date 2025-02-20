package com.example.autopayplugin.service.impl;

import com.example.autopayplugin.service.RequestSenderService;
import com.example.autopayplugin.service.TransactionService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.transaction.*;
import com.example.autopayplugin.utils.DTOFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.autopayplugin.constants.Constants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final RequestSenderService requestSenderService;

    @Override
    public AutopayBaseResponse<TransactionGetResponseDTO> get(TransactionGetRequestDTO dto) {
        log.info("get transaction: {}", dto.toString());

        AutopayBaseRequest<TransactionGetRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_GET, dto);

        return requestSenderService.sendRequest(request, TransactionGetResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<TransactionSynchResponseDTO> synch(TransactionSynchRequestDTO dto) {
        log.info("transaction synch: {}", dto.toString());

        AutopayBaseRequest<TransactionSynchRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_SYNCHRONIZE, dto);

        return requestSenderService.sendRequest(request, TransactionSynchResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<TransactionDTO> findByExt(TransactionFindAndCancelRequestDTO dto) {
        log.info("findByExt: {}", dto.toString());

        AutopayBaseRequest<TransactionFindAndCancelRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_FIND, dto);

        return requestSenderService.sendRequest(request, TransactionDTO.class);
    }

    @Override
    public AutopayBaseResponse<TransactionCancelResponseDTO> cancel(TransactionFindAndCancelRequestDTO dto) {
        log.info("cancel: {}", dto.toString());

        AutopayBaseRequest<TransactionFindAndCancelRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_CANCEL, dto);

        return requestSenderService.sendRequest(request, TransactionCancelResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<TransactionVerificationSetResponseDTO> verificationSet(TransactionVerificationSetRequestDTO dto) {
        log.info("verificationSet: {}", dto.toString());

        AutopayBaseRequest<TransactionVerificationSetRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_VERIFICATION_SET, dto);

        return requestSenderService.sendRequest(request, TransactionVerificationSetResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<TransactionVerificationCheckResponseDTO> verificationCheck(TransactionVerificationCheckRequestDTO dto) {
        log.info("verificationCheck: {}", dto.toString());

        AutopayBaseRequest<TransactionVerificationCheckRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(TRANSACTION_VERIFICATION_CHECK, dto);

        return requestSenderService.sendRequest(request, TransactionVerificationCheckResponseDTO.class);
    }
}
