package wvs.cryptography.controller.dto;

import wvs.cryptography.entity.TransactionEntity;
import wvs.cryptography.service.TransactionService;

public record TransactionResponse(
        Long id,
        String userDocument,
        String creditCardToken,
        Long transactionValue) {

    public static TransactionResponse fromEntity(TransactionEntity entity) {
        return new TransactionResponse(
                entity.getTransactionId(),
                entity.getRawUserDocument(),
                entity.getRawCreditCardToken(),
                entity.getTransactionValue()
        );
    }
}
