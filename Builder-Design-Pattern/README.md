以组装电脑主机为例

- CPU、显示器、内存、外存等是每台电脑必须有的
- 耳机、风扇等不是必须的。

并且，不同价位的电脑会配备不同的规格的固定部件。同时，对于非必需品用户可以自由选择型号购买，或者不买。



## 1.构造方法构建Computer对象

```Java
package basic;


public class Computer {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数 例如：购买高配置电脑赠送低配置耳机，不赠送风扇，购买配置电脑赠送高配置风扇和耳机
    private String fan;
    private String earphone;

    // 通过构造函数传入必须参数
    public Computer(String CPU, String screen, String memory) {
        this.CPU = CPU;
        this.screen = screen;
        this.memory = memory;
    }

    public Computer(String CPU, String screen, String memory, String fan) {
        this.CPU = CPU;
        this.screen = screen;
        this.memory = memory;
        this.fan = fan;
    }

    // 构造函数增加2个可选参数
    public Computer(String CPU, String screen, String memory, String fan, String earphone) {
        this.CPU = CPU;
        this.screen = screen;
        this.memory = memory;
        this.fan = fan;
        this.earphone = earphone;
    }
}

```



缺点：

- 代码可读性差，难以维护
- 上面的代码中，赠送earphone必须为fan制定默认值。除非增加一个只有earphone一个可选参数的构造方法。
- 可复用性低。



## 2.构造方法和set方法 构建

```Java
package basic;


public class Computer2 {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数
    private String fan;
    private String earphone;

    // 通过构造函数传入必须参数
    public Computer2(String CPU, String screen, String memory) {
        this.CPU = CPU;
        this.screen = screen;
        this.memory = memory;
    }
    // 通过set方法传入可选参数
    public void setFan(String fan) {
        this.fan = fan;
    }
    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }

}
```



缺点：

- 通过大量setter分别设置属性，容易出错，导致Object 状态将不一致。例如一个属性没有设置具体值，那么这个对象的状态就会不一致，后续如果有要用到这个属性的地方，就会出现错误或异常。
- 可复用性低。即使每次创建同一种对象都需要重复set



## 3.问题产生的原因

对象的构造过于复杂——有可选和不可选的部件，每个部件都有不同型号

```Java
    public static void main(String[] args) {
        // 低配置 必须参数
        Computer2 computer2 = new Computer2("i7", "杂牌", "16G");
        // 设置可选参数
        computer2.setEarphone("低级耳机");
        
        // 高配置 必须参数
        Computer2 computer3 = new Computer2("i9", "三星", "32G");
        // 设置可选参数
        computer3.setFan("高级风扇");
    }
```

例子中属性较少，当属性增多时，可重用性和可维护性性过低



## 4.封装setter？

无法重用setter，容易写错？

- 解决办法：封装setter

```Java
package basic;

/**
 * @author yzw
 * @date 2023年05月07日 20:12
 */
public class Computer3 {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数 例如：购买高配置电脑赠送低配置风扇，不赠送耳机，购买配置电脑赠送高配置风扇和耳机
    private String fan;
    private String earphone;

    // 低级
    public Computer3 buildLowComputer(Computer3 computer3) {
        computer3.setCPU("低配CPU");
        computer3.setMemory("低配memory");
        computer3.setScreen("低配screen");
        computer3.setEarphone("赠送的低配耳机");
        return computer3;
    }
    // 高配
    public Computer3 buildHighComputer(Computer3 computer3) {
        computer3.setCPU("高配CPU");
        computer3.setMemory("高配memory");
        computer3.setScreen("高配screen");
        computer3.setEarphone("赠送的高配耳机");
        computer3.setFan("赠送的高级风扇");
        return computer3;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }
}

```

仍然有缺点：

不符合OCP：对拓展开发，对修改关闭

如果需要增加或删除套餐(配置),就需要修改Computer3的代码。

**原因**：将对象的创建过程与对象本身耦合在一起了



## 5.建造者模式

变化的部分：为电脑设置不同属性值的部分。



为不同的套餐/配置创建不同的建造者

- LowComputerBuilder
- HighComputerBuilder

又由于不同电脑的构建有共同点，都需要CPU、内存、显示器、外存等，因此容易想到使用接口或抽象类建立一个抽象的建造者，此处使用抽象类。

建造者模式中的三个角色：

1. **产品**：需要生产的产品，此处指电脑。
2. **抽象建造者**：抽象出来的构建者类，用于定义创建对象所需的步骤以及创建的步骤的调用过程。
3. **具体建造者**：抽象建造者的具体实现，对于不同的创建过程(此处指不同的配置)可以用不同的类进行实现。



建造者用于创建对象的各个部件，Director用于组装对象

建造者模式中的第四个角色：

​	4.**Director**：用于组装对象。构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象。

它主要有两个作用。

1. 隔离了客户与对象的生产过程
2. **负责控制产品对象的生产过程**，因为通常对象的构建需要遵循一定的顺序。例如，控制构建顺序，先构建主板，然后往主板上安装CPU、内存条等。





此时如果要增加套餐：中等配置？

- 创建一个MediumComputerBuilder集成抽象类，然后使用这个Builder即可。满足OCP。



**建造者模式的优点**：

1. 客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。

   ```java
       public static void main(String[] args) {
           // 购买低配电脑
           ComputerBuilder lowComputerBuilder = new LowComputerBuilder();
           Director director = new Director(lowComputerBuilder);
           Computer computer = director.construct();
           System.out.println("-----------------------------------------");
           // 购买高配电脑
           ComputerBuilder highComputerBuilder = new HighComputerBuilder();
           director = new Director(highComputerBuilder);
           computer = director.construct();
       }
   ```

   clinet只需要知道“低配电脑”“高配电脑”，直接使用即可，而不用关注“低配电脑”和“高配电脑“如何构建。

   

   

2. 每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，同时，指挥者类针对抽象建造者类编程，系统扩展方便，符合 “开闭原则”。

   著需要构造注入不同类型的具体建造者即可建造不同对象。

   ```Java
   public class Director {
       // 抽象建造者
       private ComputerBuilder builder;
   
       // 通过构造注入一个具体建造者
       public Director(ComputerBuilder builder) {
           this.builder = builder;
       }
   
       public Computer construct() {
           // 多态，运行时调用具体建造者的方法
           // 可能有先后顺序
           builder.buildCPU();
           builder.buildScreen();
           builder.buildMemory();
           builder.buildFan();
           builder.buildEarphone();
           return builder.buildComputer();
       }
   }
   ```

   

3. 可以更加精细地控制产品的创建过程 。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。

   ```Java
   package improve;
   
   /**
    * @author yzw
    * @date 2023年05月07日 21:01
    */
   public class HighComputerBuilder extends ComputerBuilder{
       @Override
       public void buildCPU() {
           System.out.println("配备高配CPU");
       }
   
       @Override
       public void buildScreen() {
           System.out.println("配备高配屏幕");
       }
   
       @Override
       public void buildMemory() {
           System.out.println("配备高配内存");
       }
   
       @Override
       public void buildFan() {
           System.out.println("赠送高配耳机");
       }
   
       @Override
       public void buildEarphone() {
           System.out.println("赠送高配耳机");
       }
   }
   
   ```

   

   使用场景？

   - 在开发中，有时候我们需要创建出一个很复杂的对象，这个对象的创建有一个固定的步骤，并且每个步骤中会涉及到多个组件对象，这个时候就可以考虑使用建造者模式。

   



