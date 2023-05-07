package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:49
 */
public class HangzhouGoldCard extends Card {
    public HangzhouGoldCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.7));
        super.setPrintPattern("杭州灵隐寺风景图案");
    }
}
