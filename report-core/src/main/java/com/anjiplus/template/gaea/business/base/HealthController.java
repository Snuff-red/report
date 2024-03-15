package com.anjiplus.template.gaea.business.base;

import com.anji.plus.gaea.bean.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 **/
@RestController
public class HealthController {

    @GetMapping("health")
    public ResponseBean health() {
        return ResponseBean.builder().build();
    }

}
