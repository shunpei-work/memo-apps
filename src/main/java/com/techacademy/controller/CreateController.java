package com.techacademy.controller;

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
 * メモの新規作成をするクラス
 * 初期表示（新規作成画面）
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
        // フォームに入力された値をDBに登録
        memoService.save(memo);
        // 画面に表示するため、モデルに追加
        model.addAttribute("title",title);
        model.addAttribute("content",content);
        return "createConfirm";
    }
    
}
