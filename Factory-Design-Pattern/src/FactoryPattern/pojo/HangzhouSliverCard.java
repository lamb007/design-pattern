package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:49
 */
public class HangzhouSliverCard extends Card {
    public HangzhouSliverCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.8));
        super.setPrintPattern("杭州雷峰塔风景图案");
    }
}
