package com.learning.microservices.wallet.modal;

import com.learning.microservices.wallet.domain.TransactionStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TransactionResponse {
    private TransactionStatus status;
    private Double updatedBalance;
}
