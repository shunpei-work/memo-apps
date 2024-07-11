package com.techacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techacademy.entity.Memo;
import com.techacademy.service.MemoService;

import lombok.RequiredArgsConstructor;

/**
 * メモのデータを利用して画面表示をするクラス
 * 初期表示（トップ画面）
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class TopController {
    
    // 固定メッセージ定義
    public static final String deleteMsg = "削除が完了しました！";
    public static final String editMsg = "更新が完了しました！";
    
    // 削除フラグ
    public boolean deleteFlag = false;
    // 編集フラグ
    public boolean editFlag = false;

    @Autowired
    private MemoService memoService;
    
    /**
     * メモリストを取得
     */
    @RequestMapping("/top")
    public String getMemoList(Model model){
        // 値を全件取得して表示させる
        List<Memo> memoInfoList = memoService.findAll(); 
        model.addAttribute("memoInfoList",memoInfoList);
        // 削除していればメッセージ表示
        if(deleteFlag == true) {
            model.addAttribute("deleteMsg",deleteMsg);
            deleteFlag = false;
        }
        return "top";
    } 
    
    /**
     * 削除機能
     */
    @RequestMapping("top/delete")
    public String delete(@RequestParam("id")long id,Model model){
        try {         
            memoService.delete(id);
            deleteFlag = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/top";
    }
    
    /**
     * 更新ページアクセス
     */
    @GetMapping("top/edit/{id}")
    public String edit(@PathVariable("id")long id,Model model) {
        Memo memoForm = memoService.findById(id);
        model.addAttribute("memoForm",memoForm);
        return "edit";
    }
    
    /**
     * 更新機能
     */
    @PostMapping("top/edit/{id}")
    public String update(Memo memo,Model model) {
        try {
            memoService.save(memo);
            editFlag = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        // 値を全件取得して表示させる
        List<Memo> memoInfoList = memoService.findAll();
        model.addAttribute("memoInfoList",memoInfoList);
        // 編集していればメッセージ表示
        if(editFlag == true) {
            model.addAttribute("editMsg",editMsg);
            editFlag = false;
        }
        return "top";
    }
    
    /**
     * 検索機能
     */
    @PostMapping("top/{word}")
    public String searchWord(@RequestParam("word")String word,Model model){
        // 検索文字列が含まれるリストのみ取得して表示させる
        List<Memo> memoSearchList = memoService.findByTitle(word);
        model.addAttribute("memoSearchList",memoSearchList);
        return "top";
    }
}
