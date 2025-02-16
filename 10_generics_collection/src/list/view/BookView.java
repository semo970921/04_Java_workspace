package list.view;

import list.dto.BookDTO;
import list.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookView {

    private Scanner sc = new Scanner(System.in);
    private BookService service = new BookService();

    /**
     * 프로그램 메인 메뉴
     */
    public void displayMenu() {
        int input = 0; // 메뉴 번호를 저장할 변수

        do {
            System.out.println("\n***** 도서 관리 프로그램 *****\n");
            System.out.println("1. 전체 조회");
            System.out.println("2. index 번호로 조회");
            System.out.println("3. 책 추가하기");
            System.out.println("4. 책 가격 수정하기");
            System.out.println("5. 책 제거하기(index)");

            // 추가 메뉴
            System.out.println("6. 제목이 일치하는 책 1권 조회하기");
            System.out.println("7. 제목이 일치하는 책 제거하기");
            System.out.println("8. 출판사가 일치하는 책 모두 조회하기");
            System.out.println("9. 저자가 일치하는 책 모두 조회하기");
            System.out.println("10. 검색어가 제목,저자에 포함된 모든 책 조회하기");
            System.out.println("11. bookList 제목 오름차순으로 정렬시키기");




            System.out.println("0. 종료하기");
            System.out.println();

            System.out.print("메뉴 번호 입력 >> ");
            input = sc.nextInt();
            sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거(오류 방지)
            System.out.println("-------------------------");

            switch(input) {
                case 1: selectAll(); break;
                case 2: selectIndex(); break;
                case 3: addBook(); break;
                case 4: modifyBookPrice2(); break;
                case 5: removeBook(); break;
               // case 6: selectTitle(); break;
               // case 7: removeBookTitle(); break;
               // case 8: selectPublisherAll(); break;
               // case 9: selectAuthorAll(); break;
               // case 10: searchBook(); break;
               // case 11: bookListSorting(); break;
                case 0: System.out.println("*** 프로그램이 종료됩니다 ***"); break;
                default: System.out.println("@@@ 메뉴 번호 잘못 입력 @@@");
            }
        }while(input != 0);
    }

    private void selectAll(){
        System.out.println("\n### 전체 조회 ###\n");

        List<BookDTO> list = service.getBookList();

        if (list.isEmpty()) {
            System.out.println("저장된 책이 존재하지 않습니다.");
            return;
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(i + ") " + list.get(i)/*.toString()*/);
        }
    }


    public void selectIndex(){
        System.out.println("\n### index 번호로 조회 ###\n");

        System.out.print("조회할 책 index 번호 : ");
        int index = sc.nextInt();

        BookDTO book = service.selectIndex(index);

        if(book == null){
            System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
            return;
        }

        System.out.println(book/*.toString()*/);
        System.out.println("제목 : " + book.getTitle());
        System.out.println("저자 : " + book.getAuthor());
        System.out.println("가격 : " + book.getPrice());
        System.out.println("출판사 : " + book.getPublisher());
    }


    private void addBook() {
        System.out.println("\n### 책 추가하기 ###\n");

        System.out.print("제목 : ");
        String title = sc.nextLine();

        System.out.print("저자 : ");
        String author = sc.nextLine();

        System.out.print("가격 : ");
        int price = sc.nextInt();
        sc.nextLine();

        System.out.print("출판사 : ");
        String publisher = sc.nextLine();

        boolean result
                = service.addBook(new BookDTO(title, author, price, publisher));

        if(result){
            System.out.println(title + " 책이 추가 되었습니다.");
        } else {
            System.out.println(title + " 책이 이미 존재합니다.");
        }

    }

    public void modifyBookPrice() {
        System.out.println("\n### 책 가격 수정하기 ###\n");

        System.out.print("수정할 책 index 번호 : ");
        int index = sc.nextInt();

        BookDTO target = service.selectIndex(index);
        // 해당 인덱스에 책이 없다면
        if(target == null) {
            System.out.println("해당 인덱스에 책이 존재하지 않습니다." );
            return;
        }

        // 해당 인덱스에 책이 있다면
        System.out.print("수정할 가격 입력 : ");
        int newPrice = sc.nextInt();
        int oldPrice = target.getPrice();
        target.setPrice(newPrice); // (SOLID 원칙 위배)

        System.out.printf(
                "[%s] 가격이 [%d] -> [%d]으로 수정되었습니다.\n",
                target.getTitle(), oldPrice, newPrice);
    }


    private void modifyBookPrice2(){
        System.out.println("\n### 책 가격 수정하기 ###\n");

        System.out.print("수정할 책 index 번호 : ");
        int index = sc.nextInt();

        // 인덱스 범위 초과 시
        if(service.checkIndex(index) == false) {
            System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
            return;
        }

        // 해당 인덱스에 책이 있다면
        // 1)"수정할 가격 입력 : " 출력
        System.out.print("수정할 가격 입력 : ");
        int newPrice = sc.nextInt();
        System.out.println(service.modifyBookPrice22222(index,  newPrice));
    }


    private void removeBook(){
        System.out.println("\n### 책 제거하기(index) ###\n");

        System.out.print("제거할 책 인덱스 번호 : ");
        int index = sc.nextInt();

        BookDTO target = service.removeBook(index);

        if(target == null) {
            System.out.println("해당 인덱스에 책이 존재하지 않습니다" );
        }else {
            System.out.printf("[%s] 책이 제거되었습니다\n",
                    target.getTitle());
        }
    }

}
