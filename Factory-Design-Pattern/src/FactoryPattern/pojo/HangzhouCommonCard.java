package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:50
 */
public class HangzhouCommonCard extends Card{
    public HangzhouCommonCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.9));
        super.setPrintPattern("杭州西湖风景图案");
    }
}
