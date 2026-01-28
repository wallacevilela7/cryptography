package wvs.cryptography.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import wvs.cryptography.controller.dto.CreateTransactionRequest;
import wvs.cryptography.controller.dto.TransactionResponse;
import wvs.cryptography.controller.dto.UpdateTransactionRequest;
import wvs.cryptography.entity.TransactionEntity;
import wvs.cryptography.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTransactionRequest request) {
        var entity = new TransactionEntity();
        entity.setRawUserDocument(request.userDocument());
        entity.setRawCreditCardToken(request.creditCardToken());
        entity.setTransactionValue(request.transactionValue());

        repository.save(entity);
    }

    public Page<TransactionResponse> listAll(int page, int pageSize) {

        return repository.findAll(PageRequest.of(page, pageSize))
                .map(TransactionResponse::fromEntity);
    }

    public TransactionResponse findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return TransactionResponse.fromEntity(entity);
    }

    public void update(Long id, UpdateTransactionRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        entity.setTransactionValue(request.transactionValue());
        repository.save(entity);
    }

    public boolean delete(Long id) {
        var exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
        }

        return exists;
    }
}
