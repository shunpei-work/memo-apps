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
    
    /**
     * 全件取得機能
     * @return List<Memo>
     */
    @Transactional
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
    
    // 登録機能
    @Transactional
    public void save(Memo memo) {
        memoRepository.saveAndFlush(memo);
    }
    
    // 指定されたIDの列削除機能
    @Transactional
    public void delete(long id) {
        memoRepository.deleteById(id);
    }
    
    // 更新機能
    @Transactional
    public void update(Memo memo) {
        memoRepository.save(memo);
        
    }
    
    /**
     * IDに紐づくメモ情報を取得
     * @param id メモID
     * @return memo メモオブジェクト
     */
    public Memo findById(long id) {
        return memoRepository.findById(id).get();
    }
}
