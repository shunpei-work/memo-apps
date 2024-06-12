package com.techacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Memo;
import com.techacademy.repository.MemoRepository;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;
    
    @Transactional
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
    
    @Transactional
    public void save(Memo memo) {       
        memoRepository.saveAndFlush(memo);
    }
}
