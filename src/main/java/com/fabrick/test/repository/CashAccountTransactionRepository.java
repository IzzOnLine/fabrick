package com.fabrick.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabrick.test.entities.CashAccountTransaction;

@Repository
public interface CashAccountTransactionRepository extends JpaRepository<CashAccountTransaction, String> {

}
