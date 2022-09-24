package com.example.testcode.controller;

import com.example.testcode.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World";

    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public  String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
            return  name + " " + email + " " + organization;

    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return  memberDto.toString();
    }

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping(value = "/member0")
    public String postMember(@RequestBody Map<String, Object> postData) {

        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");

        });
        return sb.toString();
    }

}
