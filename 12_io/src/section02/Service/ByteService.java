package section02.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {

	/*Stream(스트림)
	 * - 데이터가 이동하는 통로 역할의 객체
	 * 
	 * - 데이터의 흐름은 기본적으로 단방향
	 */
	
	/*[Byte 기반 스트림]
	 * - 1Byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위 클래스 : Input Stream, OutputStream
	 * 
	 * - 입/출력 가능 데이터
	 *  문자열, 파일(이미지, 영상, 오디오, pdf 등 모든 파일)
	 *  * 단, 2byte 범위 문자열이 깨질 수 있고
	 *   좁은 통로(1byte)를 이용하다보니 속도가 상대적으로 느림
	 *   
	 *   *********************************************
	 *   Stream 객체는 Java 프로그램이 종료 되어도
	 *   외부 장치/파일/프로그램과의 연결이 유지되기 때문에
	 *   자동으로 사라지지 않는다!!!
	 *    -> 프로그램 종료 전
	 *      Stream 객체의 메모리를 반환하는 close()구문 필수!!
	 *      (안 그러면 메모리 소비 커짐)
	 *   *********************************************
	 */
	
	/**
	 * 지정된 경로에
	 * 파일 생성 + 내용 출력(파일 기반 바이트 스트림 이용)
	 * @throws IOException 
	 */
	public void fileByteOutpt() {
		
		//fos 참조 변수를 try, finally에서 모두 사용할 수 있게 선언
		FileOutputStream fos = null;
		
		try {
			// 폴더경로, 파일명 지정
			String folderPath = "io_test/byte"; // 프로젝트폴더/io_test/byte(상대경로)
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성함
			File folder = new File(folderPath);
			
			if(folder.exists() == false) {
				folder.mkdirs(); // 폴더 생성
			}
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성
			// -> 이 때, 해당 파일이 없으면 자동으로 생성된다!!
			// fos = new FileOutputStream(folderPath + "/" + fileName); // 슬래시 안에는 절대로 띄어쓰기X
			fos = new FileOutputStream(folderPath + "/" + fileName/* , true */); // true를 쓰면 이어쓰기 옵션 됨
			// io_test/byte/바이트기반테스트.txt
			
			
			// txt 파일에 출력할 내용 작성
			
			/*StringBuilder : String의 불변성 문제를 해결하기 위한 객채*/
			StringBuilder builder = new StringBuilder();
			builder.append("Hello World!\n");
			builder.append("234567879\n");
			builder.append("!@#$%^&*(\n");
			builder.append("와 완전 쉽죠\n");
			builder.append("자바 너무 재밌어요!!!\n");
			builder.append("대답해봐요! 재밌죠?\n");
			
			
			// StringBuilder는 String이 아님
			// StringBuilder에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			/*연결된 외부 txt파일로 content 내용을 출력*/
			// 방법1) 1byte씩 끊어서 출력
			/*for(int i=0; i<content.length(); i++) {
				
				char ch = content.charAt(i); // i번째 문자 1개 반환
				
				// 바이트 기반 스트림 -> 1byte 범위만 출력 가능
				// -> 0 ~ 255(바이트 범위) 사이 글자는 정상 출력
				//    이후 글자(한글 등)은 모두 깨져서 출력됨
				fos.write(ch); // IOException 발생 가능성 있음
				// 근데 및에는 FileNotFoundException만 있음
				// 빨간줄 클릭하고 두번째 클릭해서 밑에 catch문 추가
				
			}*/ // 한글 깨지는거 막기위해..
			
			// 방법2) String을 byte로 먼저 변환한 후
			//       손실되는 데이터 없이 출력하기
			// 44302 -> ac00 이 ac/[00]으로 쪼개짐 => 254
			// 따라서 byte로 바꿔서..
			byte[] bytes = content.getBytes(); //String가면 byte[]형태로 있어 => 따라서 String을 byte[]형태로 그대로 얻어오기
			
			fos.write(bytes); // 손실되는 데이터 없이 모든 문자열(byte) 출력
			
			System.out.println("출력 완료");
			
			// ============================
			
			//==============================
			// 밑에 먼저 하고 위에
			
			// FileOutputStream fos = new FileOutputStream("");
//			fos = new FileOutputStream("");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				// ============================
				// 위 설명에 따라 마지막에 무조건 close()!!!!!!!!!
				
				if(fos != null) {
					// NullPointerException 방지
					fos.close(); // IOException 발생 가능성 있음 
					// 여기 빨간줄은 IOException쓰면되
					// fos와 다른 블록에 있기에(지역변수) 에러뜸
					// 따라서 try위에 저거 먼저 선언
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	/**
	 * 보조 스트림 중 BufferedFileByteOutputStream을 이용해서
	 * 출력 속도 향상시키기
	 */
	public void bufferedFileByteOutput() {
		
		/*버퍼(buffer)란?
		 * - 데이터가 모아져있는 메모리상의 임시 공간
		 *   ==  장바구니
		 *   -> 한 번에 많은 양의 데이터를 이동 시켜서
		 *    시간 효율을 좋아지게 만듦
		 * - nextInt(), nextLint()
		 */
		
		/*스트림 객체 참조 변수 선언*/
		FileOutputStream fos = null; // 기반 스트림(단독 사용O)
		BufferedOutputStream bos = null; // 보조 스트림(단독 사용X)
		// -> 보조 스트림은 꼭 기반 스트림에 붙여서 사용!!!
		
		try {
			
			/*기반 스트림 생성*/
			fos = new FileOutputStream("io_test/byte/버퍼_바이트.txt");
			// -> 이 txt 파일이 없으면 생성됨
			
			/*보조 스트림 생성*/
			// 보조 스트림 생성 시 기반 스트림과 연결
			bos = new /*자동완성 봐바*/BufferedOutputStream(fos);
			
//			String content = "Lights will guide you home\r\n"
//					+ "And ignite your bones\r\n"
//					+ "And I will try to fix you"
//					길어서 보기 않좋아
			
			// """ """ : 내부에 작성된 모양 그대로의 문자열 생성(<pre>같음)
			String content = """
					Lights will guide you home
					And ignite your bones
					And I will try to fix you
					
					""";
			
			// 보조 스트림을 이용해서 출력
			// -> 내용 출력 시 버퍼를 이용해서 한번에 출력!
			// 원해는 a->b->c 이렇게를 abc이렇게 내보냄
			bos.write(content.getBytes());
			
			System.out.println("출력 완료!");
			
		} catch (Exception e) { // 다형성 이용해서 모든 예외 처리
			e.printStackTrace();
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환
			try {
				
				if(bos != null) bos.close();
				// 보조 스트림만 close 하면
				// 연결된 기반 스트림도 같이 close 된다!!
				
			} catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	/**
	 * 바이트 기반 파일 입력(파일 읽어오기)
	 */
	// 노래 가사 먼저 넣어놓기
	public void fileByteInput() {
		
		FileInputStream fis = null;
		
		try { // catch쪽 먼저 작성!!
			// 파일 입력용 바이트 기반 스트람 생성 (아래 작성후!)
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			int value = 0; // 읽어온 1byte를 저장할 임시 변수
			
			// 읽어온 내용 누적용 객체
			StringBuilder sb = new StringBuilder();
			
			while(true){ // 무한 반복
				
				// int fis.read()
				// - 파일로부터 1바이트 읽어서 반환
				// - 호출 시 마다 다음 내용을 읽어옴
				// - 읽어올 내용이 없다면 -1 반환
				//value = fis.read(); //Reads a byte  
				// 그래도 한글이 깨짐(왜??)
				
				// =>> 아래 public fileByteInput으로 가
				
				if(value == -1) break; // 반복 종료
				
				sb.append((char)value); // -1이 아니면 문자로 변환해서 누적
			}
			
			// 읽어온 값 처림
			System.out.println(sb.toString());
			
			
			// =============================================
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 스츠림 객체 메모리 반환(close())
			try {
				// fis.close(); // 마우스 올리면 두번째거! ->try catch!!
				if(fis != null) fis.close(); // 마우스 올리면 두번째거! ->try
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
		}
		
		
		
	}
	
	/**
	 * 바이트 기반 파일 입력2(한글 안깨지게 읽어오기)
	 */
	public void fileByteInput2() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// byte[] readAllByte()
			// - 연결된 파일의 내용을 모두 byte로 변환하여 읽어오기
			// - byte[] 형태로 반환됨
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes); 
			// byte[]을 String에 그대로 저장
			
			System.out.println(content);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 스츠림 객체 메모리 반환(close())
			try {

				if(fis != null) fis.close(); // 마우스 올리면 두번째거! ->try
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
		}
		
	}
	
	
	/**
	 * 보조 스트림(BufferedInputStream)을 이용해서
	 * 효율적으로 파일 읽어오기
	 * (앞에것들은 그렇게 효율적이지 X)
	 */
	public void bufferedFileByInput() {
		
		FileInputStream fis = null; // 기반 스트림
		BufferedInputStream bis = null; // 보조 스트림
		
		
		try {
			
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// 보조 스트림 생성
			bis = new BufferedInputStream(fis); // 기반 스트림 연결됨
			// 따라서 여기서부터는 fis를 쓸필요없이 bis쓰면 됨

			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes); 
			System.out.println(content);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(bis != null) bis.close(); // 마우스 올리면 두번째거! ->try
				
				// 보조 스트림만 close해도 연결된 기반 스트림도 close
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
		}
		
	}
	
	//==================================================================
	
	/**
	 * [파일 복사]
	 * <pre>
	 * - 복사할 파일의 경로를 입력 받아
	 *   같은 경로에 복사된 파일을 생성
	 * 
	 * - 입력 받은 경로에 파일이 존재하지 않으면
	 *  -> "파일이 존재하지 않습니다" 출력
	 *  
	 * - 존재하면
	 *  -> 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 *  
	 * 	[실행 화면]
	 * 	파일 경로 입력 : io_test/byte/노래가사.txt
	 *  복사 완료 :io_test/byte/노래가사_copy.txt
	 *  
	 * </pre>
	 */
	public void fileCopy() {
		
		// 스캐너, 파일 입출력 스트림, 보조스트림 참조 변수 선언
		
		Scanner sc = null; // 경로 입력용
		
		FileInputStream fis = null; // 입력 기반
		FileOutputStream fos = null;// 출력 기반
		
		BufferedInputStream bis = null; // 입력 보조
		BufferedOutputStream bos = null; // 출력 보조
		
		
		try {
			
			sc = new Scanner(System.in);
			
			// 1) 파일 경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String path = sc.nextLine();
			
			// 2) 입력 받은 경로의 파일과 FileinputStream 연결하기
			fis = new FileInputStream(path);
			// -> path에 파일이 없다면
			//   FileNotFoundException 발생 => catch에서 처리
			
			// 3) 보조 입력용 스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 4) 연결된 파일을 byte[]배열로 읽어오기
			byte[] bytes = bis.readAllBytes(); // == 이저 자체가 읽어온 파일!!

			// 5) 입력 받은 경로 파일명에 _copy 붙이기
			StringBuilder sb = new StringBuilder();
			sb.append(path); // 기존 경로 추가
			
			// D:\workspace\04_Java\12_io\io_test\byte\노래가사.txt
			// 여기서 . !!!찾아!! 뒤에서 처음 나온 .
			
			// 뒤에서부터 검색하여 찾은 "." 위치(index) 반환
			int insertPoint = sb.lastIndexOf(".");
			
			// 찾은 "."dkvdp "_copy"삽입하기
			sb.insert(insertPoint, "_copy");			
			
			// 복사본의 경로
			String copyPath = sb.toString();
			
			
			// 6) 출력용 기반 스트림 객체 생성
			fos = new FileOutputStream(copyPath);
			
			// 7) 출력용 보조 스트림 객체 생성
			bos = new BufferedOutputStream(fos);
			
			// 8) 보조 스트림을 이용해서 출력하기
			bos.write(bytes); // 읽어온 파일 (bytes) 출력하기
			
			System.out.println("복사 완료 : " + copyPath);
			
		} catch (FileNotFoundException e) {
				System.out.println("파일이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			
			// 스트림 객체 메모리 반환
			try {
				if(bis != null) bis.close(); // 참조하는게 있을 때만 close
				if(bos != null) bos.close();
				if(sc != null) sc.close();
				
			} catch (IOException e) {
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
