package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

    private TodoListService service = null;
    private BufferedReader br = null; // Scanner 대신 사용

    // 기본 생성자
    public TodoListView() {

        try {
            service = new TodoListServiceImpl();
            br = new BufferedReader(new InputStreamReader(System.in));

        } catch (Exception e) {
            System.out.println("*** 프로그램 실행 중 오류 발생 ***");
            e.printStackTrace();
            System.exit(0); // 프로그램 종료
        }
    }


    // ------------------------------------------------------------------------------------------------------


    /**
     * Todo List 화면 시작
     */
    public void startView() {

        int selectNumber = 0;

        do {
            try {
                selectNumber = selectMenu();

                switch (selectNumber) {
                    case 1: todoListFullView();        break;
                    case 2: todoDetailView(); 	        break;
                    case 3: todoAdd(); 					break;
                    case 4: todoComplete(); 		    break;
                    case 5: todoUpdate(); 			    break;
                    case 6: todoDelete(); 			        break;

                    case 0:
                        System.out.println("@@@ 프로그램 종료 @@@");
                        br.close();
                        break;

                    default: System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
                }

                System.out.println("=====================================================================");


            } catch (NumberFormatException e) {
                System.out.println("### 숫자만 입력해 주세요 ###");
            } catch (IOException e) {
                System.err.println("### 입/출력 관련 예외 발생 ###");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } while (selectNumber != 0);



        try {
            if (br != null) 	br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // ------------------------------------------------------------------------------------------------------


    /** 메뉴 출력 및 선택
     * @return 선택한 메뉴 번호 반환
     * @throws NumberFormatException
     * @throws IOException
     */
    private int selectMenu() throws NumberFormatException, IOException {

        System.out.println("\n====== Todo List =====\n");

        System.out.println("1. Todo List Full View");
        System.out.println("2. Todo Detail View");
        System.out.println("3. Todo Add");
        System.out.println("4. Todo Complete");
        System.out.println("5. Todo Update");
        System.out.println("6. Todo Delete");
        System.out.println("0. EXIT");


        System.out.print("select menu number >>> ");
        int input = Integer.parseInt(br.readLine());
        System.out.println();

        return input;
    }


    // ------------------------------------------------------------------------------------------------------


    /** 할 일 목록 모두 보기
     */
    private void todoListFullView() {

        System.out.println("\n===============[1. Todo List Full View]===============\n");

        Map<String, Object> map = service.todoListFullView();
        List<Todo> todoList = (List<Todo>)map.get("todoList");
        int completeCount = (int)map.get("complementCount");

        System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n", completeCount, todoList.size());
        System.out.println("----------------------------------------------------------");
        System.out.println("인덱스             등록일                  완료여부       할 일 제목");
        System.out.println("----------------------------------------------------------");

        // 할 일 목록 출력
        for (int i = 0; i < todoList.size(); i++) {
            Todo todo = todoList.get(i);
            String formattedDate = service.dateFormat(todo.getRegDate());  // 날짜 포맷 변경
            String completeMark = todo.isComplete() ? "(O)" : "(X)";  // 완료 여부 표시

            System.out.printf("[ %d ]  %s  %s    %s\n", i, formattedDate, completeMark, todo.getTitle());
        }

//        System.out.println("==========================================================");
//        System.out.println("\n====== Todo List =====");

    }


    // ------------------------------------------------------------------------------------------------------


    /** 할 일 상세 조회
     * @throws IOException
     * @throws NumberFormatException
     */
    private void todoDetailView() throws NumberFormatException, IOException {

        System.out.println("\n===============[2. Todo Detail View]===============\n");


    }


    // ------------------------------------------------------------------------------------------------------


    /** 할 일 추가
     * @throws IOException
     *
     */
    private void todoAdd() throws IOException {

        System.out.println("\n===============[3. Todo Add]===============\n");

    }


    // ------------------------------------------------------------------------------------------------------


    /** 할 일 완료 여부 변경 (O <-> X)
     * @throws IOException
     * @throws NumberFormatException
     */
    private void todoComplete() throws NumberFormatException, IOException {
        System.out.println("\n===============[4. Todo Complete]===============\n");

    }



    // ------------------------------------------------------------------------------------------------------


    /** 할 일 수정
     * @throws IOException
     * @throws NumberFormatException
     */
    private void todoUpdate() throws NumberFormatException, IOException {
        System.out.println("\n===============[5. Todo Update]===============\n");

    }



    // ------------------------------------------------------------------------------------------------------

    private void todoDelete() throws NumberFormatException, IOException {
        System.out.println("\n===============[6. Todo Delete]===============\n");


    }




}