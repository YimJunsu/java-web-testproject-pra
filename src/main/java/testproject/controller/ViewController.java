package testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 메인
    @GetMapping("/index.html")
    String index(){return "/index.html";}
    // 예약
    @GetMapping("/dPdir.html")
    String dPdir(){return "/dPdir.html";}
    // 접수(환자 목록, 환자 등록)
    @GetMapping("/wjqtn.html")
    String wjqtn(){return "/wjqtn.html";}
    // 환자 등록
    @GetMapping("/upload.html")
    String register(){return "/upload.html";}
    // 예약 등록
    @GetMapping("/reservation.html")
    String reservation(){return "reservation.html";}
}
