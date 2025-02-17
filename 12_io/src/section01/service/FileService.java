package section01.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileService {

    public void test1(){
        // File directory = new File("D:\\home_workspace\\04_Java\\12_io\\io_teset"); // true
         File directory = new File("D:\\home_workspace\\04_Java\\12_io\\io_teset\\20250217"); // false

        System.out.println("폴더 경로 : " + directory.getPath());
        System.out.println("폴더 유무 확인 : " + directory.exists());

        if(!directory.exists()){
            if(directory.mkdirs()){
                System.out.println("폴더가 생성되었습니다.");
            }
        } else{
            System.out.println("부모 폴더 : " + directory.getParent());

            File parent = new File(directory.getParent());

            File[] files = parent.listFiles();
            for(File f : files) {
                System.out.println(f);
                f.delete();
            }

            if(parent.delete()){
                System.out.println("폴더가 삭제되었습니다.");
            }

//            if(directory.delete()){
//                System.out.println("폴더가 삭제되었습니다.");
//            }

        }
    }

    public void test2(){

        File folder = new File("io_test/20250217");

        if(!folder.exists()){
            folder.mkdirs();
        }

        File file = new File(folder.getPath() + "/파일생성.txt");

        if(!file.exists()){
//            if(file.createNewFile()){
//                System.out.println("파일이 생성되었습니다.");
//            }
            try{
                if (file.createNewFile()) {
                    System.out.println("파일이 생성 되었습니다.");
                }

            } catch(IOException e){
                System.out.println("--- 파일 생성 중  예외 발생---");
                e.printStackTrace();
            }

        } else{
            System.out.println("이미 " + file.getName() + " 파일이 존재합니다.");
        }

    }

    public void test3(){
        Scanner sc = new Scanner(System.in); // 키보드(외부 입력장치)=>스트림으로 읽어옴

        System.out.print("폴더 경로 입력 : ");
        String path = sc.nextLine();

        File folder = new File(path);

        if(!folder.exists()) {
            System.out.println("잘못된 경로가 입력 되었습니다.");
            return;
        }

        File[] files = folder.listFiles();

        for(File f : files) {
            String fileName = f.getName();

            long lastModified = f.lastModified();

            SimpleDateFormat sdt
                    = new SimpleDateFormat("yyyy-MM-dd a h:mm");

            String date = sdt.format(lastModified);

            // 파일 유형
            String type = null;
            if(f.isFile()) type = "파일"; // 맞으면 파일
            else           type = "폴더";


            // 파일 크기
            String kb = null;
            if(f.isFile()) { // 파일인 경우에만 파일 크기 츨정
                long fileSize = f.length(); // 파일의 바이트 크기 반환

                // Byte -> KB로 변경
                long size = fileSize/1024;

                if(size < 1) size=1; // 1kb 미만은 모두 1로 표기

                kb = size + "KB";

            }

            System.out.printf(
                    "%-20s %-20s %-5s %-10s\n",
                    fileName, date, type, kb==null ? "" : kb);


        }
    }




}
