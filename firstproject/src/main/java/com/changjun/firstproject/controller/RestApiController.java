package com.changjun.firstproject.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.changjun.firstproject.dto.request.ExampleDto;
import com.changjun.firstproject.dto.response.ExampleResponseDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

class ParamDto {
    String data1;
    String data2;

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}

// Rest API를 위한 Controller임을 명시해주는 어노테이션
// @Controller + @Responsebody = RestController
// response는 HTML을 제외한 MIME type을 반환한다
// URL path 패턴을 지정해서 해당 패턴이 올마르면 지정한 클래스로 처리하도록 함
@RestController
@RequestMapping(value = "api")
public class RestApiController {

    @RequestMapping(method = { RequestMethod.GET }, value = "hello2") // 지금 보면 map이 api / hello2 로 되어있기 때문에
                                                                      // 요청을 보낼때에도 http://localhost:4040/api/hello2 같이
                                                                      // 주소를 보내야한다. 클래스 안에 메서드가 있기 때문에
                                                                      // 여기서 value는 명령을 보내는 주소이며 method는 역할 해당 예시에서는 get
                                                                      // 으로 보냈을때 작동을 하라는것
                                                                      // GetMapping과 동일하다
    public String hello2() {
        return "hello2";
    }

    // GET Method @GetMapping
    // @RequestMappint(method=RequestMethod.get, value="get-method")
    // 클라이언트가 서버에게 데이터를 받기 위한 Request Method
    // request 를 url에 넣어서 보냄
    @GetMapping("get-method") // 바로 path 인 value 값만 설정하게 됨
    public String getMethod() {
        return "Response of Get Request";
    }

    // Post Method @PostMapping
    // @RequestMappint(method=RequestMethod.post, value="post-method")
    // Post Method : 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    // request를 body에 넣어서 보냄
    @PostMapping("post-method")
    public String postMethod() {
        return "Response of Get Request";

    }

    // Patch Method @PatchMapping
    // Patch Method : 클라이언트가 서버에 데이터를 일부만 수정하가 위한 요청의 Method
    // @RequestMappint(method=RequestMethod.patch, value="patch-method")
    // request를 body에 넣어서 보냄

    @PatchMapping("patch-method")
    public String patchMethod() {
        return "Response of Patch Request";

    }
    // Delete Method @DeleteMapping
    // Delete Method : 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 method
    // @RequestMappint(method=RequestMethod.DELETE, value="delete-method")
    // request 를 url에 넣어서 보냄

    @DeleteMapping("delete-method")
    public String deleteMethod() {
        return "Response of Delete Request";

    }
    // PathVariable() 로 Get, Delete Method에서 데이터를 받기
    // 리소스에 지정한 패턴에 맞춰서 Request URL을 지정한다면 지정한 패턴에 따라 데이터를 받아오는 것

    @GetMapping({ "path-variable/{data1}/{data2}", "path-variable/{data1}" }) // 받는 방식을 배열로 설정해서 할수있다. 이렇게하면 특정데이터(예시에선
                                                                              // data1 만 받는 요청을 보내도 아래와 같은 메서드가 실행된다)
                                                                              // 단 해당 패스에 required에 false를 설정해주어야 한다.
    public String pathVariable(@PathVariable("data1") String dataA, // value 지워도 됨. 무언가를 적었을때 기본 설정은 value임
            @PathVariable(value = "data2", required = false) String dataB) { // 데이터를 2개이상 받을 때
        return dataA + "" + dataB + "" + "데이터를 입력받았습니다.";
    }

    // @RequestParam 로 Get, Delete Method 에서 데이터 받기
    // 완전 path 뒤에 ?name=value[&...] 형식에 맞춰 name에 해당하는 value를 받아오는 방식
    // "?"뒤는 path 로 인식하지 않음
    // 보내고 받는 형태가 name,value 라는 객체의 형태이기 때문에 객체로 사용할수있다.
    // 아래의 Param

    // @GetMapping("request-param")
    // public String requestParam(ParamDto dto) { // RequestParam 의 뒤에는 괄호가 안들어감
    // 클래스를 사용해서 객체의 형태로도 받을수 있음.
    // // 여러개 보낼때 에는 &사용
    // return dto.getData1() + dto.getData2() + "데이터를 입력 받았습니다.";

    // }

    @GetMapping("request-param")
    public String requestParam(@RequestParam String data1, @RequestParam String data2) { // RequestParam 의 뒤에는 괄호가 안들어감
                                                                                         // 클래스를 사용해서 객체의 형태로도 받을수 있음.
                                                                                         // 여러개 보낼때 에는 &사용
        return data1 + data2 + "데이터를 입력 받았습니다.";

    }

    // @RequestBody 로 Post, Put, Patch Method에서 데이터 받기
    // Request Body에 있는 데이터를 받기 위한 어노테이션
    // @PostMapping("request-body")
    // public String requestBody(@RequestBody String data){

    // return data + "데이터를 받았습니다.";
    // }
    @PostMapping("request-body")
    public ResponseEntity<ParamDto> requestBody(@RequestBody ParamDto dto) {

        return ResponseEntity.status(408).body(dto);

    }

    @PostMapping("lombok") // getter setter tostring 등을 활용 하기 위해서 데이터를 보낼때에는 body 부분에 보낸다.
    public ResponseEntity<ExampleResponseDto> lombok(@Valid @RequestBody ExampleDto requestBody) { // 참조 타입을 ExampleDto로 설정함 그
                                                                                            // 타입 변수 이름이 request body
        String data1 = requestBody.getParameter1();
        String data2 = requestBody.getParameter2();
        String data3 = requestBody.getParameter3();
        // ExampleResponseDto responseDto = new ExampleResponseDto(data1,data2,data3);
        ExampleResponseDto responseData = ExampleResponseDto.builder().data1(data1).data2(data2).data3(data3).build();// bulider을
                                                                                                                      // 쓰면
                                                                                                                      // 어떤
                                                                                                                      // 변수
                                                                                                                      // 자리에
                                                                                                                      // 어떤
                                                                                                                      // 데이터가
                                                                                                                      // 들어갈지
                                                                                                                      // 설정
                                                                                                                      // 할수
                                                                                                                      // 있다.
        return ResponseEntity.status(200).body(responseData);
    }

}
