package com.project.repository;

import com.project.repository.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer,Long> {

    Optional<Transfer>findByAccountNo(Long accountNo);
}
