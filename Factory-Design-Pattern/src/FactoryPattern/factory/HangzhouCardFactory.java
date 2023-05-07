package FactoryPattern.factory;

import FactoryPattern.pojo.Card;
import FactoryPattern.pojo.HangzhouCommonCard;
import FactoryPattern.pojo.HangzhouGoldCard;
import FactoryPattern.pojo.HangzhouSliverCard;

/**
 * @author yzw
 * @date 2023年04月28日 20:16
 */
public class HangzhouCardFactory extends CardFactory {
    // 单例模式
    private static HangzhouCardFactory instance = null;

    private HangzhouCardFactory() {
    }

    public static HangzhouCardFactory getInstance() {
        // 双重检查锁定 防止多线程环境下，instance的值不一致
        if (instance == null) {
            synchronized (HangzhouCardFactory.class) {
                if (instance == null) {
                    instance = new HangzhouCardFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Card createCard(String type) {
        Card card = null;
        if ("Gold".equals(type)) {
            card = new HangzhouGoldCard();
        } else if ("Silver".equals(type)) {
            card = new HangzhouSliverCard();
        } else if ("Common".equals(type)) {
            card = new HangzhouCommonCard();
        }
        return card;
    }
}
