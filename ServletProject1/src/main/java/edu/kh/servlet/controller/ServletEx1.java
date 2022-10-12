package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller : 요청에 따라 응답할 코드르 제어

// Serlvet 클래스를 만드기 위해서는     # 추상 클래스 : 추상 메서르를 0개 이상 포함한 클래스 / 추상메서드 : 이름만 있는 메서드, 상속받은 자식이 무조넉오버라이딩 해야함
// javax.servlet.http.HttpServlet 추상클래스(직접 객체 생성 불가)를 반드시 상속 받아야 한다!
// - 요청, 응답을 위한 방법(메서드) 제공
// - tomcat에서 제공하는 클래스

public class ServletEx1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpServletRequest : 클라이언트의 정보 + 요청 관련 정보가 담긴 객체(요청관련객체)
		
//		HttpServletResponse : 서버가 클라이언트에게 응답하는 방법을 제공하는 객체(응답관련객체)
		
		System.out.println("이름, 나이를 제출 받아서 처리할 코드 수행 : ");
		
		
		// 요청 시 함께 전달된 input 태그의 값(== Parameter)을 얻어오는 방법
		
		// req.getParameterr("input 태그의 name 속성 값");
		// -> String 형태로 입력된 값 반환
		// ** 얻어온 파라미터는 무조건 String **
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		
		System.out.println(inputName + " / " + inputAge);
		
		
		// resp.getWriter() : 서버가 클라이언트에게 응답할 수 있는 스트림을 얻어옴
		// -> PrintWriter : 출력 전용 스트릠
		
//		resp.setCharacterEncoding("UTF-8"); -> 사용 X
		
		// 문서 형식과 문자 인코딩 지정
		// -> html 문서이고 문자는 UTF-8 형식으올 인코딩 되어 있다.
		// --> 브라우저에 해당 내용에 맞게 해석
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print(inputName + "님의 나이는 "+ inputAge +"세 입니다.");
		
	}
}
