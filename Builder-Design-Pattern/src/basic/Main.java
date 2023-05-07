package basic;

/**
 * @author yzw
 * @date 2023年05月07日 20:47
 */
public class Main {
    public static void main(String[] args) {
        // 低配置 必须参数
        Computer2 computer2 = new Computer2("i7", "杂牌", "16G");
        // 设置可选参数
        computer2.setFan("低级风扇");

        // 高配置 必须参数
        Computer2 computer3 = new Computer2("i9", "三星", "32G");
        // 设置可选参数
        computer3.setFan("高级风扇");
        computer3.setEarphone("高级耳机");
    }
}
