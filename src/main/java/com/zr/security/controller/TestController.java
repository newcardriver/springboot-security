package com.zr.security.controller;


import com.zr.security.Utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/v1/test")
    public R test() {
        return R.ok();
    }
}
