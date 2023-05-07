package FactoryPattern.generator;

/**
 * @author yzw
 * @date 2023年04月28日 19:47
 */
@Deprecated
public class CardIdGenerator {

    private static CardIdGenerator instance = null;

    private String id;

    private String prefix = "ATM";

    private int count = 0;

    private CardIdGenerator() {
    }

    public static CardIdGenerator getInstance() {
        if (instance == null) {
            instance = new CardIdGenerator();
        }
        return instance;
    }

    // 防止多线程环境下，count的值不一致
    public synchronized String generateCardNumber() {
        id = prefix + count;
        count ++;
        return id;
    }
}
