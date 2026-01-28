package wvs.cryptography.controller.dto;

public record CreateTransactionRequest(String userDocument,
                                       String creditCardToken,
                                       Long transactionValue) {
}
