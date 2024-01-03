package com.escolago.library.repository;

import com.escolago.library.model.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan,Integer> {
}
