package FactoryPattern.pojo;

import java.math.BigDecimal;

/**
 * @author yzw
 * @date 2023年04月28日 19:49
 */
public class BeijingSliverCard extends Card {
    public BeijingSliverCard() {
        super();
        super.setDiscount(BigDecimal.valueOf(0.8));
        super.setPrintPattern("北京故宫风景图案");
    }
}
