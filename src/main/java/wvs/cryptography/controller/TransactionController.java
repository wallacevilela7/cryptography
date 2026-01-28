package wvs.cryptography.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wvs.cryptography.controller.dto.CreateTransactionRequest;
import wvs.cryptography.controller.dto.TransactionResponse;
import wvs.cryptography.controller.dto.UpdateTransactionRequest;
import wvs.cryptography.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateTransactionRequest request) {
        service.create(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        var content = service.listAll(page, pageSize);

        return ResponseEntity.ok(content);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable Long id) {
        var transaction = service.findById(id);

        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody UpdateTransactionRequest request) {
        service.update(id, request);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
