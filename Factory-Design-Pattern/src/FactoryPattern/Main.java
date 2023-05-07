package FactoryPattern;

import FactoryPattern.factory.BeijingCardFactory;
import FactoryPattern.factory.CardFactory;
import FactoryPattern.factory.HangzhouCardFactory;
import FactoryPattern.pojo.Card;

/**
 * @author yzw
 * @date 2023年04月28日 20:20
 */
public class Main {
    public static void main(String[] args) {
        CardFactory hangzhouCardFactory = HangzhouCardFactory.getInstance();
        Card hangzhouCard = hangzhouCardFactory.applyCard("Gold");
        hangzhouCard.showCard();

        hangzhouCard = hangzhouCardFactory.applyCard("Silver");
        hangzhouCard.showCard();

        hangzhouCard = hangzhouCardFactory.applyCard("Common");
        hangzhouCard.showCard();

        CardFactory beijingCardFactory = BeijingCardFactory.getInstance();
        Card beijingCard = beijingCardFactory.applyCard("Gold");
        beijingCard.showCard();

        beijingCard = beijingCardFactory.applyCard("Silver");
        beijingCard.showCard();

        beijingCard = beijingCardFactory.applyCard("Common");
        beijingCard.showCard();

    }
}
