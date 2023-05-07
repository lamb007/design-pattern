package ObserverPattern;

/**
 * @description: 主题类(目标类)接口
 * @author yzw
 * @date 2023/4/9 21:02
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
