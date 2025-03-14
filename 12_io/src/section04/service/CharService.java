package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {

	/*]문자 기반 스트림]
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * 
	 * - 문자만 작성된 파일(txt, bin 등), 
	 *   채팅, JSON, 웹 요청(주소)/응답(HTML)
	 *   
	 * - 문자 기반 스트림 최상위 인터페이스 : 
	 * 	Reader(입력), Writer(출력)
	 */
	
	
	/**
	 * 문자 기반 스트림을 이용한 파일 출력
	 */
	public void fileOutput1() {
		FileWriter fw = null;
		
		try {
			
			 String content = """
1. 동해물과 백두산이 마르고 닳도록
하느님이 보우하사 우리나라 만세
무궁화 삼천리 화려 강산
대한 사람 대한으로 길이 보전하세

2. 남산 위에 저 소나무 철갑을 두른 듯
바람 서리 불변함은 우리 기상일세
무궁화 삼천리 화려 강산
대한 사람 대한으로 길이 보전하세

3. 가을 하늘 공활한데 높고 구름 없이
밝은 달은 우리 가슴 일편단심일세
무궁화 삼천리 화려 강산
대한 사람 대한으로 길이 보전하세

4. 이 기상과 이 맘으로 충성을 다하여
괴로우나 즐거우나 나라 사랑하세
무궁화 삼천리 화려 강산
대한 사람 대한으로 길이 보전하세			 		
			 		
			 		
""";
			 // 폴더가 없을 경우 생성
			 String path = "io_test/char";
			 File folder = new File(path);
			 if(!folder.exists())folder.mkdirs();
			 
			 
			 // 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "애국가1절.txt");
			
			// 문자 기반 스트림을 이용해서 출력하기
			fw.write(content); // String, char[] 출력을 위한 기능이 알아서 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			fw.flush(); // 근데 어차피 이거 close() 시 자동으로 수행됨(따라서 굳이 안써도 됨)
			// 용어는 알아두기!!!
			
			System.out.println("출력 완료");
			
			//=========================
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 문자 기반 스트림 + 보조 스트림을 이용한 파일 출력
	 */
	public void fileOutput2() {
		FileWriter fw = null;
		BufferedWriter bw = null; // 버퍼를 이용한 보조 스트림 => 시간적 효율 더 좋음
		
		
		try {
			
			String content = """
					1. 동해물과 백두산이 마르고 닳도록
					하느님이 보우하사 우리나라 만세
					무궁화 삼천리 화려 강산
					대한 사람 대한으로 길이 보전하세
					
					2. 남산 위에 저 소나무 철갑을 두른 듯
					바람 서리 불변함은 우리 기상일세
					무궁화 삼천리 화려 강산
					대한 사람 대한으로 길이 보전하세
					
					3. 가을 하늘 공활한데 높고 구름 없이
					밝은 달은 우리 가슴 일편단심일세
					무궁화 삼천리 화려 강산
					대한 사람 대한으로 길이 보전하세
					
					4. 이 기상과 이 맘으로 충성을 다하여
					괴로우나 즐거우나 나라 사랑하세
					무궁화 삼천리 화려 강산
					대한 사람 대한으로 길이 보전하세			 		
			 		
			 		
					""";
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists())folder.mkdirs();
			
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "애국가1절_buffer.txt");
			
			// 보조 스트림 객체 생성!!!!!!!!!!!!!
			bw = new BufferedWriter(fw);
			
			// 문자 기반 스트림을 이용해서 출력하기
			bw.write(content); // String, char[] 출력을 위한 기능이 알아서 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			bw.flush(); // 근데 어차피 이거 close() 시 자동으로 수행됨(따라서 굳이 안써도 됨)
			// 용어는 알아두기!!!
			
			System.out.println("출력 완료");
			
			//=========================
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 문자 기반 입력 스트림 + 보조 스트림 이용해서 파일 읽어오기
	 */
	public void fileInput() {
		
		/*
		 * [try-with-resource]
		 * - 자바 7버전(2011년)에서 추가된 기능
		 * - finally에서 작성하던 close 처리 구문을
		 *   자동으로 수행하도록 만드는 구문
		 * - 근데 그리 많이 사용하지는 않음
		 */
		
		String path = "io_test/char/애국가1절.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) { 
			// new FileReader()는 기반 스트림 안만들었으므로 객체 생성
			
			// 보조 스트림을 이용해서 파일 내용 읽어오기
			
			StringBuilder sb = new StringBuilder(); // 읽어온 내용 누적			
			String temp = null; // 임시 변수
			while(true) {
				
				temp = br.readLine(); // 한 줄씩 읽어오기(엔터 전까지만 읽어옴)=> 엔터는 안읽어옴
				
				if(temp == null) break;  // 읽어온 내용이 없으면 반복 종료
			// 이게 없으면 밑에 print구문에 오류뜸
				
				sb.append(temp); //  읽어온 내용 누적(엔터 미포함)
				sb.append("\n"); // 엔터 추가
			}
			
			System.out.println("읽어오기 성공!");
			System.out.println("----------------------------------");
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// finally에서 close하던 구문 생략 가능
	}
	
	
	// 키보드 입력도 문자 입력
	// 키보드 입력 -> 바이트(2진수) 코드 입력 -> 컴퓨터가 문자로 변환
	/* Scanner가 느리기에 Scanner 대신 스트림을 이용한 문자열 입력 받기*/
	// ->  Scanner가 편리하긴 한데 매우 느림!!
	
	public void keyboardInput() {
		
		// System.in : 기본 장치(키보드)와 연결된 InputStream 반환
		
		// 버퍼는 문자기반, 키보드 입력은 바이트 기반
		
		// InputStreamReader : 바이트 스트림 -> 문자 스트림 변환
		// try(BufferedReader br = new BufferedReader(System.in)) // 오류 => 문자기반(버퍼),  비이트기반 (시스템점인)
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			System.out.print("문자열 입력1 : ");
			String input1 = br.readLine(); // 입력된 한 줄 읽어오기
			
			System.out.print("문자열 입력2 : ");
			String input2 = br.readLine(); // 입력된 한 줄 읽어오기
			
			System.out.println("input1 : " + input1);
			System.out.println("input2 : " + input2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
