package ObserverPattern;

import java.util.List;

public interface Observer {
    void update(List<Book> availableBooks);
}
