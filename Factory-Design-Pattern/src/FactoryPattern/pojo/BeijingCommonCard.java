package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:50
 */
public class BeijingCommonCard extends Card{
    public BeijingCommonCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.9));
        super.setPrintPattern("北京天坛风景图案");
    }
}
