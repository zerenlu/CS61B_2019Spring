# cs61b_2019spring
*Data structure and algorithm course of UCB 2019*
* [cs61b](https://sp19.datastructur.es/)

## chapter 1 Introduction

### 1.1 Essentials 

#### 基本概念与语法

* Java 是完全基于class(类)来编译与运行的编程语言，也就是说所有的函数、数据结构都应该放在类的结构中。
* 所有声明的类中必须有且只有一个方法method(类似于C语言中的主函数)main()， 声明为`public static void main(String[] args) {}`。
* 语句以`;`结尾,语句块以`{}`作分隔。

#### Java的编译与运行

* 从Java源代码到输出代码所运行的结果主要分为两步：编译器(compiler)编译源代码(.java)生成.class文件，解释器（interpreter）解释class文件给机器并让机器执行解释好的命令。
* ```
	$javac Helloworld.java /*javac 编译*/
	$java HelloWorld /*java 解释运行*/
  ```

#### 变量与循环

* 在Java中变量必须先声明才能使用，声明后的变量类型不能更改~~???不能强制转换类型???~~。 因此java为静态语言，即声明好的变量类型不能再更改。 与之相对的， Python为动态语言，定义好的变量在程序运行的过程中是可以更改的。
* Java在编译阶段会先检验变量是否声明及正确赋值，编译通过后再运行
* 循环 `while(statement){do sth.;}`
* `System.out.println(5 + "10");` 输出`510`
* `System.out.println(5 + 10);` 输出`15`


#### 定义函数(function)/方法(method)

* 函数/方法的定义也要在类中，并且方法定义时也要声明类型。

#### 代码格式以及注释

* 确保你写的代码其他人也能看懂！！！
* Javadoc能通过特殊的注释格式生成html格式代码文档, class:
```
// import statements

/**
 * @author      Firstname Lastname <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Test {
    // class body
}
```
method:
```
/**
 * Short one line description.                           (1)
 * <p>
 * Longer description. If there were any, it would be    (2)
 * here.
 * </p>
 * And even more explanations to follow in consecutive
 * paragraphs separated by HTML paragraph breaks.
 *
 * @param  variable Description text text text.          (3)
 * @return Description text text text.
 */
public int methodName (...) {
    // method body with a return statement
}
```


### 1.2 Objects 对象

#### Static methods vs. Non-static methods

* 静态方法即有关键字 `static` 声明的 methods(方法)。 main 方法就是典型的静态方法。
* 静态方法的特征就是不需要创建实例就可以被调用
* 不是所有的class内部都需要声明main方法
* 可以通过`Class.Method`的方式在main中调用其它类里的方法

##### Instance Variables and Object Instantiation实例变量与对象实例化

* 类中声明的变量和方法都是类的成员，访问类的成员需通过`.`， 即`d.makenoise()`。
* 对象为类的实例化。也就是说类是抽象的概念，对象是根据具体的类所创建出的实际的东西，即实例。
* 在类中无`static`关键字声明的方法被称作实例方法或者非静态方法，无`static`声明的变量为实例变量或非静态变量。
* 非静态方法只有先通过实例化（使用new关键字和对应的类名称`d = new Dog()`）才可以被使用，由此也可以看出，被实例化的类可以被赋值给变量。

**其实课程的这部分讲的并不是很清晰结构化，带着疑问继续把这节听完会对静态与非静态有更全面的了解。**

##### Constructors 构造器

* 构造器其实就是用来初始化一个实例的，比如说在声明新的实例的时候初始化实例中的某些值。
* 构造器编写方法: 在类中声明一个与类同名的类似于method的东西。 比如在`class Dog`中声明构造器为`public Dog(int w) {}`, 这样在实例化的时候可以进行初始化`Dog d = new Dog(44);`。

##### Arrays of Objects 创建包含对象的数组

* 一般创建数组的格式为`int[] someArray = new int[5];`，与之类似，如果`Dog`已被声明为类的话，创建包含对象的数组的格式则为`Dog[] dogs = new Dog[2];`注意，这个时候类并没有被实例化，目前只是声明了包含对象的数组而已，如果进行实例话的话需要单独实例化，即`dogs[0] = new Dog(3);`

##### Class Methods vs. Instance Methods 类方法与实例方法，即静态方法与非静态方法

* **这一节进一步阐述了静态方法与非静态方法的应用区别**，从应用情景上来讲，静态方法是被设计用来描述属于类的行为，也就是说这一行为对于属于同一类的实例来说不会有任何差别，或者这个类本身不会有子类/没必要有子类（Math这个类就不需要再有子类，所有的计算方法都可以声明在这个类下面）。 非静态方法则是被设计用来描述实例的行为，实例即个体，可能在参数上以及行为表现上千差万别，但他们都是基于一个蓝图（类）创建出来的，在这个蓝图（类）里用非静态方法定义了在不同条件下实例应该有的行为表现。
* **无论哪种方法，都要明确返回值的类型**
* 关于这两种方法的声明方式， 静态方法要加上`static`关键字，例如“public static Dog maxDog(Dog d1, Dog d2){}”, 而非静态方法则不需要特别的关键字，例如“public Dog maxDog(Dog d2)”。 注意 非静态方法用`this`关键字来指代实例自己这个对象， 也就是说，我通过`Dog wangcai = new Dog(17);`创建了一个实例`wangcai`, wangcai(旺财)这个实例在进行`maxDog`这个方法的时候，`maxDog`中`this.weightInPounds`指的就是`wangcai.weightInPounds`,即`17`。

* 区别列表:

|static methods | non-static methods|
|--------------  | ------------------|
|通过`Class.Method`调用 | 只能先`new`实例化，然后才能通过实例调用`object.Method`|
|只能使用静态变量和局部变量 | 可以访问所有类型的变量|
|不能被子类方法重写 | 可以被子类方法重写|

#### Command Line Arguments 命令行输入

* 主函数的形参（输入）为`String[] args`，也就是说，主函数的输入为字符串数组，数组元素以空格分隔` `。 举个栗子: `java TestArgu a b c d`中，`a b c d` 以`["a", "b", "c", "d"]`的形式储存在`args`中。 

## Chapter 2 Lists 列表

开始这节之前要先把**Project0**做完！！
