package wvs.cryptography.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wvs.cryptography.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
