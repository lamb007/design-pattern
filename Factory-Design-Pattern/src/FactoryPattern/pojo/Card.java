package FactoryPattern.pojo;

import FactoryPattern.generator.CardIdGenerator;
import FactoryPattern.generator.CardIdUtil;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:38
 */
public abstract class Card {
    private String cardId;
    private BigDecimal discount;
    // 卡片印刷图案
    private String printPattern;


    public Card() {
        this.cardId = CardIdUtil.generateCardNumber();
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPrintPattern() {
        return printPattern;
    }

    public void setPrintPattern(String printPattern) {
        this.printPattern = printPattern;
    }

    // 卡片制作
    public void makeCard() {
        System.out.println("卡号：" + this.cardId + "的卡片已制作完成");
    }
    // 图案印刷
    public void printPattern() {
        System.out.println("卡号：" + this.cardId + "的卡片图案已印刷完成");
    }
    // 卡片登记
    public void checkInCard() {
        System.out.println("卡号：" + this.cardId + "的卡片已完成登记");
    }

    // 展示
    public void showCard() {
        System.out.println("卡号为" + this.cardId + "的卡片信息如下：");
        System.out.println("    折扣：" + this.discount);
        System.out.println("    图案：" + this.printPattern);
        System.out.println();
    }
}
