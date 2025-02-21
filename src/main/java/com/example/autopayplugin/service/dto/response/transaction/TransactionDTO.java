package com.example.autopayplugin.service.dto.response.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    @Schema(description = "Id of Merchant (filial) which created by you")
    private Integer merchantId;

    @Schema(description = "PINFL of client")
    private String pinfl;

    @Schema(description = "loan_id of Contract")
    private String loanId;

    @Schema(description = "This ext_id belongs to the transaction, and it is unique for each transaction. Other operations like cancel, change sync status will be done by this attribute")
    private String ext;

    @Schema(description = "Referral number of transaction, it is also unique")
    private String rrn;

    @Schema(description = "This card object contains available data about card")
    private CardDTO card;

    @Schema(description = "Status of transaction [success, cancelled]")
    private String status;

    @Schema(description = "Loan ID, max 100 characters.")
    private String processing;

    @Schema(description = """
            Date [Y-m-d]
            Transaction provided date
            """)
    private String date;

    @Schema(description = """
            BigInt (tiyin)
            Amount of transaction
            
            """)
    private Double amount;

    @Schema(description = "Terminal (terminal_id) of transaction")
    private String terminal;

    @Schema(description = "Merchant (merchant_id) of transaction")
    private String merchant;

    @Schema(description = """
            Indicates whether the transaction has been successfully synchronized with the partner's system.
            true: The partner has retrieved the transaction, processed it in their system, and confirmed synchronization with our system by sending a request.
            false: The transaction has not yet been retrieved or processed by the partner.
            Partners are expected to send a request to mark transactions as synced after saving them to their own system and completing the necessary processing.
            This is optional processing for partners.
            """)
    private Boolean isSynced;

    @Schema(description = "Id if push request to partner system after successful transactio")
    private String pushId;

    private Instant createdAt;
    private Instant updatedAt;
}
