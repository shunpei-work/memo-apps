package com.techacademy.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * DBに保持されているメモ情報を全て取得する
     * @return List<Memo>
     */
    @Transactional
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
    
    /**
     * 保存機能
     * メモ情報をDBに保存する
     * @param memo
     */
    @Transactional
    public void save(Memo memo) {
        memoRepository.saveAndFlush(memo);
    }
    
    /**
     * 削除機能
     * 指定されたIDの列をDBから削除する
     * @param id 削除するメモID
     */
    @Transactional
    public void delete(long id) {
        memoRepository.deleteById(id);
    }
    
    /**
     * 更新機能
     * DBのメモ情報を更新する
     * @param id 更新するメモID
     */
    @Transactional
    public void update(Memo memo) {
        memoRepository.save(memo);
        
    }
    
    /**
     * IDに紐づくメモ情報を1件取得
     * @param id メモID
     * @return memo メモオブジェクト
     */
    public Memo findById(long id) {
        return memoRepository.findById(id).get();
    }
    
    /**
     * 検索機能
     * タイトルに検索文字列が含まれるリスト取得
     * @param word 検索ワード
     * @return List<Memo> メモリスト
     */
    public List<Memo> findByTitle(String word) {
        return memoRepository.findByTitle(word);
    }
    
    /**
     * 作成日フォーマッター
     * ”yyyy-MM-dd”を”yyyy/MM/dd”に変換
     * @param LocalDate 現在時間
     * @return String型に変換した日付
     */
    public String format(LocalDate currentDate) {
        // 日付フォーマットを定義
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // フォーマッターを適用
        String formatDate = currentDate.format(formatter);       
        return formatDate;
    }
    
}


