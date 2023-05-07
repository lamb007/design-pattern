package FactoryPattern.factory;

import FactoryPattern.pojo.BeijingCommonCard;
import FactoryPattern.pojo.BeijingGoldCard;
import FactoryPattern.pojo.BeijingSliverCard;
import FactoryPattern.pojo.Card;

/**
 * @author yzw
 * @date 2023年04月28日 20:16
 */
public class BeijingCardFactory extends CardFactory{
    // 单例模式
    private static BeijingCardFactory instance = null;

    private BeijingCardFactory() {
    }

    public static BeijingCardFactory getInstance() {
        // 双重检查锁定
        if (instance == null) {
            synchronized (BeijingCardFactory.class) {
                if (instance == null) {
                    instance = new BeijingCardFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Card createCard(String type) {
        Card card = null;
        if ("Gold".equals(type)) {
            card = new BeijingGoldCard();
        } else if ("Silver".equals(type)) {
            card = new BeijingSliverCard();
        } else if ("Common".equals(type)) {
            card = new BeijingCommonCard();
        }
        return card;
    }
}
