package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:49
 */
public class BeijingGoldCard extends Card {
    public BeijingGoldCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.7));
        super.setPrintPattern("北京长城风景图案");
    }
}
