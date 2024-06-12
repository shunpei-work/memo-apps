package com.techacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techacademy.entity.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long>{

}