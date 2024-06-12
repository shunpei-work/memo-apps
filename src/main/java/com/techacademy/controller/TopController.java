package com.techacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Memo;
import com.techacademy.service.MemoService;

import lombok.RequiredArgsConstructor;

/**
 * メモのデータを利用して画面表示をするクラス
 * 初期表示（トップ画面）
 */

@Controller
@RequiredArgsConstructor
public class TopController {

    @Autowired
    private MemoService memoService;

    /**
     * 値を全件取得して表示させる
     */
    @RequestMapping("top")
    public String showMemoList(Model model){
        List<Memo> memoInfoList = memoService.findAll(); 
        model.addAttribute("memoInfoList", memoInfoList);
        return "top";
    }
    
    

}
