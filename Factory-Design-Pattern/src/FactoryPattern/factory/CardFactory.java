package FactoryPattern.factory;

import FactoryPattern.pojo.Card;

/**
 * @author yzw
 * @date 2023年04月28日 19:57
 */
public abstract class CardFactory {
    public Card applyCard(String type) {
        Card card = createCard(type);
        System.out.println("=====卡号为" + card.getCardId() + "的卡片开始制作=====");
        card.makeCard();
        card.printPattern();
        card.checkInCard();
        System.out.println("=====卡号为" + card.getCardId() + "的卡片制作完成=====");
        return card;
    }

    public abstract Card createCard(String type);
}
