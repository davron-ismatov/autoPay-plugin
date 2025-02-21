package uz.zaytun.autopay.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.zaytun.autopay.service.RequestSenderService;
import uz.zaytun.autopay.service.TransactionService;
import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.request.transaction.*;
import uz.zaytun.autopay.service.dto.response.transaction.*;
import uz.zaytun.autopay.utils.DTOFactory;

import static uz.zaytun.autopay.constants.Constants.*;

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
    public AutopayBaseResponse<TransactionSynchResponseDTO> sync(TransactionSynchRequestDTO dto) {
        log.info("transaction sync: {}", dto.toString());

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
