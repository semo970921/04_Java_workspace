package list.service;

import list.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<BookDTO> bookList  = new ArrayList<BookDTO>();
    public BookService(){
        bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
        bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800, "포레스트북스"));
        bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
        bookList.add(new BookDTO("작별하지 않는다", "한강", 16800, "문학동네"));
        bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
    }

    // getter
    public List<BookDTO> getBookList(){
        return bookList;
    }

    public BookDTO selectIndex(int index){
        if(checkIndex(index) == false) return null;

        return bookList.get(index);
    }

    public boolean checkIndex(int index){
        if(index<0 || index>=bookList.size()){
            return false;
        }
        return true;
    }

    public boolean addBook(BookDTO book){
        if(bookList.contains(book)) return false;

        return bookList.add(book);
    }


    public String modifyBookPrice22222(int index, int newPrice){
        BookDTO target = bookList.get(index);
        int oldPrice = target.getPrice();
        target.setPrice(newPrice);

        return String.format(
                "[%s] 가격이 [%d] -> [%d]으로 수정되었습니다.",
                target.getTitle(), oldPrice, newPrice);
    }

    public BookDTO removeBook(int index){
        if(checkIndex(index) == false) return null;

        return bookList.remove(index);
    }




}
