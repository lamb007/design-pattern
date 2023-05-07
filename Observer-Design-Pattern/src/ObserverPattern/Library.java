package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 具体的主题
 * @author yzw
 * @date 2023/4/9 21:03
 */
public class Library implements Subject {
    // 目标类相关的属性
    private List<Book> availableBooks;
    // 观察者列表
    private List<Observer> borrowers;

    public Library() {
        availableBooks = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    // 借书
    public boolean borrowBook(Book book) {
        // ...... 一些借书的业务逻辑
        return removeBook(book);
    }

    // 还书
    public void returnBook(Book book) {
        // ...... 一些还书的业务逻辑
        addBook(book);
    }

    public void addBook(Book book) {
        availableBooks.add(book);
        bookStatusChanged();
    }

    public boolean removeBook(Book book) {
        if (availableBooks.remove(book)) {
            bookStatusChanged();
            return true;
        }else {
            return false;
        }
    }

    // 监控状态改变
    public void bookStatusChanged() {
        // 通知观察者
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        borrowers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        borrowers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        borrowers.forEach(borrower -> borrower.update(availableBooks));
    }
}
