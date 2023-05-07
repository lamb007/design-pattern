package FactoryPattern.generator;

import java.util.UUID;

/**
 * @author yzw
 * @date 2023年04月28日 20:51
 */
public class CardIdUtil {
    private static String prefix = "ATM";
    // 生成卡号
    public static String generateCardNumber() {
        return prefix + UUID.randomUUID().toString();
    }

}
