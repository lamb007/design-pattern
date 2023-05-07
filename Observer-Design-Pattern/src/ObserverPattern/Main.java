package ObserverPattern;

public class Main {
    public static void main(String[] args) {
        // 创建图书馆
        Library library = new Library();
        // 添加图书
        library.addBook(new Book("1", "Java教程"));
        library.addBook(new Book("2", "Python教程"));
        library.addBook(new Book("3", "C++教程"));
        library.addBook(new Book("4", "C#教程"));
        library.addBook(new Book("5", "Go教程"));
        // 创建观察者
        Borrower borrower1 = new Borrower("u1", "张三", library);
        Borrower borrower2 = new Borrower("u2", "李四", library);
        // 注册观察者
        library.registerObserver(borrower1);
        library.registerObserver(borrower2);
        // 张三借书
        borrower1.borrowBook(new Book("1", "Java教程"));
        borrower1.borrowBook(new Book("2", "Python教程"));
        // 李四借书
        // 借已经借出去的书
        borrower2.borrowBook(new Book("1", "Java教程"));
        // 张三还书
        borrower1.returnBook(new Book("1", "Java教程"));

    }
}
