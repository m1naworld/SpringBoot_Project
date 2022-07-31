package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") // 공통 URL
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }
    // 요즘은 안쓰는 방식 @RequestMapping -> 요즘은 HTTP 메서드에 맞는 어노테이션 사용
    // @GetMapping @PostMapping @PutMapping @DeleteMapping


    // URL에 값을 담아 전달되는 요청을 처리하는 방법
    @GetMapping(value = "/variable1/{variable}") // 중괄호를 이용해 어느 위치에서 값을 받을지 지정
    public String getVariable1(@PathVariable String variable){  //메서드의 매개변수와 그 값을 연결하기 위해 @PathVariable 명시,
        //*주의 @GetMapping 어노테이션과 @PathVariable에 지정된 변수의 이름을 동일하게 맞춰야 함
        return variable;
    }

    // @GetMapping 어노테이션과 @PathVariable 변수가 다를 경우
    //만약 동일하게 못 맞출 경우 @PathVariable 뒤에 괄호를 열어 @GetMapping 어노테이션 변수명을 지정함
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // URL 경로에 값을 담아 보내는 방법외에 쿼리 형식으로 값을 전달할 수 있음
    // URI에서 '?'를 기준으로 우측에 '{키}={값}' 형태로 구성된 요청을 전송하는 방법
    // 키와 @RequestParam 뒤에 적는 이름을 동일하게 설정하기 어렵다면 위와 같이 value 요소로 매핑! @RequestParam("키값")

    //localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // 만약 쿼리스트링에 어떤 값이 들어올지 모른다면! Map 객체를 활용할 수도 있음
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }





}
