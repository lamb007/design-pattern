package ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Borrower implements Observer {
    private String id;
    private String name;
    // 这个观察者申请却未借到的书
    private List<Book> applyBooks;

    private Subject library;

    public Borrower() {
    }

    public Borrower(String id, String name, Library library) {
        this.id = id;
        this.name = name;
        this.applyBooks = new ArrayList<>();
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(id, borrower.id) && Objects.equals(name, borrower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    // 申请借书
    public void borrowBook(Book book) {
        Library library = (Library) this.library;
        boolean success = library.borrowBook(book);
        if(success) {
            System.out.println(getName() + "，借书成功");
        }else {
            System.out.println(getName() + "，您想借的书不存在或已经被借走，借书失败，若有书籍更新，我们会通知您");
            // 添加到申请列表中
            applyBooks.add(book);
        }
    }

    // 还书
    public void returnBook(Book book) {
        Library library = (Library) this.library;
        library.returnBook(book);
        System.out.println(getName() + "，还书成功");

    }


    public void update(List<Book> availableBooks) {
        availableBooks.forEach(book -> {
            // 如果申请列表中包含这本书，就打印出来
            if (applyBooks.contains(book)) {
                System.out.println("=======通知：你好，" + name + ", 您预约的下面的书可以使用了：=======");
                System.out.println(book);
            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
