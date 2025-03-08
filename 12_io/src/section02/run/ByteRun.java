package section02.run;

import section02.Service.ByteService;

public class ByteRun {
	public static void main(String[] args) {
		
		ByteService service = new ByteService();
		
		// service.fileByteOutpt(); // 파일 출력
		// service.bufferedFileByteOutput(); // 버퍼 파일 출력
		// service.fileByteInput(); // 파일 입력(한글 깨짐)
		// service.fileByteInput2(); // 파일 입력2(한글 안깨짐)
		// service.bufferedFileByInput(); // 버퍼 파일 입력
		service.fileCopy();
		
	}
}
