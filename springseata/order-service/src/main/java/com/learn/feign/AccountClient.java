package com.learn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-service", url = "http://localhost:8111")
public interface AccountClient {
    @GetMapping("/account/debit")
    public String debit(@RequestParam("userId") String userId,
                        @RequestParam("money") Integer money,
                        @RequestParam("orderId") String orderId);
}
