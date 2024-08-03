package com.techacademy.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techacademy.entity.Memo;
import com.techacademy.service.MemoService;

import lombok.RequiredArgsConstructor;

/**
 * 新規登録機能
 */

@Controller
@RequiredArgsConstructor
public class CreateController {
    
    @Autowired
    private MemoService memoService;
    
    @RequestMapping("create")
    public String create() {
        return "create";
    }
   
    @RequestMapping(value = "createConfirm",method=RequestMethod.POST)
    public String createConfirm(@RequestParam("title") String title, @RequestParam("content") String content,Model model) {
        Memo memo = new Memo();
        memo.setTitle(title);
        memo.setContent(content);
        
        // 作成日を取得、LocalDate型に変換
        LocalDate currentDate = LocalDateTime.now().toLocalDate();
        String createDate = memoService.format(currentDate);       
        memo.setCreateDate(createDate);
        
        // フォームに入力された値をDBに登録
        memoService.save(memo);
        
        // 画面に表示するため、モデルに追加
        model.addAttribute("title",title);
        model.addAttribute("content",content);
        model.addAttribute("createDate",createDate);
        return "createConfirm";
    }
    
}
