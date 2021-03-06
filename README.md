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

开始这节之前要先把**Project0**做完！！附送完成链接:[项目0: 宇宙](https://github.com/zerenlu/CS61B_2019Spring/tree/master/proj0)

Array 数组在java中是固定长度/大小，一旦定义后就不能再改变其容量。 为了使数组这种数据结构更加灵活的被使用，列表List被创造了出来，这也是这一章的主要目的所在。 在讲如何构建列表之前，首先要弄清楚赋值这个概念，即`=`。

### 什么是赋值？

赋值的概念很直接，就是将变量储存的值复制给另外一个值，这也被称为“赋值黄金法则”。 但赋值类型决定了赋值的影响不同。 Java中有8个主要类型，byte, short, int, long, float, double, boolean, char。 所有除了这8个类型以外的类型，被称为reference type参考类型。 那么主要类型与参考类型到底有什么区别呢？

### 变量类型及其赋值

简单来讲的话，**主要类型**储存的是值，**参考类型**储存的是地址。 这里可能会产生一个疑问，声明的变量是什么？ 对于变量，我们可以把它想象成一个盒子/筐，声明变量的过程就是让电脑准备个筐，用来放值或者对象的地址。 举个栗子：
```
int x = 5;//5 这个值被赋予到变量x, x这个变量目前装的值是5
int y;// 声明了另外一个筐
y = x;// x筐里的值复制到了y这个筐
x = 2; //x筐里的值现在变成了2，但是y的筐里的值没有变哟
System.out.println("x is: " + x);
System.out.println("y is: " + y);
```

刚才这个栗子是关于主要类型的赋值，下面再看看参考类型的赋值：
```
Walrus a = new Walrus(1000, 8.3); //通过类walrus产生一个实例，并对实例初始化，注意这里放在a这个筐里的
								//是实例的地址，类在实例化的时候java会根据构造函数来分配储存空间用来盛放这个实例的内容
								//new 这个关键字会在实例化类之后返回实例的地址，因此这个时候a里面盛放的是实例的地址。
Walrus b;//在声明储存参考类型的变量时，无论对象是什么类型，java都会分配容量为64bit的筐，用来储存对象的地址。
b = a;//a中存放的地址复制到了b中，注意，这时a和b储存了同一个对象的地址。
b.weight = 5;//实例的值发生了变化！这时a.weight也变成了5！
System.out.println(a);
System.out.println(b);
```
 * 如果在声明参考类型变量的时候并没有实例化，那么声明的变量里储存的地址为`null`，即全是0。

 ### 传递参数

函数的参数的赋值也遵循黄金法则，栗如: 
```
public static double average(double a, double b) {
    return (a + b) / 2;
}
public static void main(String[] args) {
    double x = 5.5;
    double y = 10.5;
    double avg = average(x, y);
}
```
在调用`average`函数时，函数需要两个`double`参数，x 和 y的值会被复制到形参局部变量a和b中。

### 数组的实例化

之前已经提到过如何初始化一个数组`int[] a = new int[]{1, 2, 3, 4};`, 这里面a储存了数组这个对象的地址，需要注意的一点是，如果a这时被赋值为其他数组的地址，而之前的数组地址并没有进行备份的话，之前的数组对象就没有踪迹可寻了，虽然它还在那里T_T。

### 自创列表IntLists

直接上代码吧:
```
public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
}
```
使用方法：

```
IntList L = new IntList(5, null);
L.rest = new IntList(10, null);
L.rest.rest = new IntList(15, null);
```
或者
```
IntList L = new IntList(15, null);
L = new IntList(10, L);
L = new IntList(5, L);
```
第二种方法和第一种方法是等效的，仔细想想很有意思233。

#### 列表method之一：获取列表大小

递归方法:
```
public int size() {
    if (rest == null) {
        return 1;
    }
    return 1 + this.rest.size();
}
```
迭代方法：
```
public int iterativeSize() {
    IntList p = this;
    int totalSize = 0;
    while (p != null) {
        totalSize += 1;
        p = p.rest;
    }
    return totalSize;
}
```
不管是递归方法还是迭代方法，都要找到增值的条件，然后基于这个条件来数数！

知识点:
 * size() 中 `rest == null` 等效于 `this.rest == null` 因为size方法是在实例中调用的，即L.size()，也就是说实例已经有了rest参数，因此可以直接用。
 * this不能重新赋值给变量，因此用p（pointer)储存this

#### 列表method之二获取列表的元素get()

```
public int get(int i) {
	IntList p = this;
	int count = 0;
	while(count != i){
		p = p.rest;
		count++;

	}
	return p.first;
}
```

下面就要开始用IntelliJ啦，IDE！！！！

### SLList

由于上一节造的IntList是基于递归算法，不懂递归的话会不明所以，不利于用户使用，因此这一节要创造一个新的列表结构叫做SLList。

#### 性能提高：

在初始化时，上一节不仅要提供第一个值，还要提供链接剩下列表的地址`new IntNode(x, null)`，这样很不方便，于是在上一节的类的基础上，我们使用另外一个类来优化初始化，即不输入链接剩下列表的地址`null`进行初始化`SLList L = new SLList(5);`。 通过构造函数即可：
```
public class SLList {
    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }
}
```
其中IntNode遇上一节中的类结构一样。
```
public class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n) {
        item = i;
        next = n;
    }
}
```
如果需要向List中添加成员，我们可以用简化的`addFirst`：
```
    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }
```
如果需要获得第一个成员的值，则可以用`getFirst`:
```
/** Retrieves the front item from the list. */
public int getFirst() {
    return first.item;
}
```

为什么没用`this`关键字?这是一个非常值得思考的问题。

**因为this关键字是局部变量，而这里需要一个全局变量first**

##### Public vs. Private

private关键字主要是为了变量不被外部调用影响，从而达到信息安全的目的，因为private变量与方法只能被同一java文件的代码访问。

于是为了避免列表内容被修改，我们需要声明first为私有变量，即：
```
public class SLList {
    private IntNode first;
...
```

##### 嵌入类

嵌入类指的是在一个已经声明的类内部继续声明一个类，当一个类仅仅被用来当做工具的时候，嵌入类可以节省java文件的个数并保持代码的整洁。

```
public class SLList {
       public class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
       }

       private IntNode first; 

       public SLList(int x) {
           first = new IntNode(x, null);
       } 
...
```

**如果嵌入类不会被其他类调用，那么我们要将嵌入类也声明为private**
**如果嵌入的类并不会用到任何父类的变量或方法，就可以将这个嵌入类声明为静态类**

##### 新方法 获取List的容量以及将新元素添加到最后一位
添加元素到最后一位：
```
/** Adds an item to the end of the list. */
public void addLast(int x) {
    IntNode p = first;

    /* Advance p to the end of the list. */
    while (p.next != null) {
        p = p.next;
    }
    p.next = new IntNode(x, null);
}
```
计算列表内元素个数：
```
private static int size(IntNode p) {
    if (p.next == null) {
        return 1;
    }

    return 1 + size(p.next);
}
```
通过这个方法，我们可以再声明一个同名方法但不需要输入形参，以此来获得整个列表的个数：

```
public int size() {
    return size(first);
}
```

这种声明同名的方法但形参不一样的用法叫做**过载overloaded**

##### size改进

上一小节提到的size方法需要运行时间，如果要获取一个容量为1000的列表的容量的话，相当于size方法要运行1000次，这非常耗时间，于是这里引入一个新的概念叫做缓存caching, 我们在SLList中引入一个新的全局变量size:
```
public class SLList {
    ... /* IntNode declaration omitted. */
    private IntNode first;
    private int size;

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public int size() {
        return size;
    }
    ...
}
```
每当向列表中添加新元素的时候，size变量就会自加一，于是只要能够读出这个变量的值就可以知道列表的大小。

##### 空表
通过SLList的构造函数我们可以用SLList来生成一个空表
```
public SLList() {
    first = null;
    size = 0;
}
```

但如果是空表的话， 之前的方法addLast()就会报错（没错，这就是BUG！），我们现在来修复它：
##### 处理空表的情况
处理空表情况的方法一是单独对这一情况进行辨识并处理，即通过if条件语句先来判断列表是否为空，然后再根据情况进行处理。 这种方法不好，因为在某些大型项目中需要考虑很多情况，非常耗时间和资源，因此我们要想一种从根本上解决这一问题的办法。

这里提到的这种办法是创建sentinel nodes,就是说在创建列表的初期就已经有一个基础节点了。

### 2.3 DLList
到这节才揭晓，SLList是single linked list就是元素间节点全是单向的，DLList顾名思义就是双向节点。双向节点会储存前一节点的储存地址，就像以前一个节点会储存下一节点的地址一样，双向节点储存了前一节点和下一节点的地址，好处就是在处理最后节点的添加与删除的时候，消耗的时间是固定的。

这一节的一个思维模式很重要，就是尽量不要在代码中对特殊情况进行处理，而是要构建一个数据结构来满足所有的情况。

#### 泛型

泛型使得程序可以在实例化时再指定类中的某些变量为哪种类型，这样在写程序时就不必对于形参进行特别声明了。


```
public class DLList<BleepBlorp> { //泛型声明与类声明在同一行
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode prev;
        public BleepBlorp item; //使用泛型来声明变量
        public IntNode next;
        ...
    }
    ...
}
```

<BleepBlorp>即为泛型，实例化时的应用方式为：
```
DLList<String> d2 = new DLList<>("hello");
```

初始化时可以省略类型(<>)，因为声明变量时已经声明元素类型了。元素类型关键字: *Integer*, *Double*, *Character*, *Boolean*, *Long*, *Short*, *Byte*, *Float*.

关于DLList, 将在Project1a中构建: [Project 1a](https://github.com/zerenlu/CS61B_2019Spring/tree/master/proj1a)

### 2.4 Array 数组

数组，顾名思义就是存放一组数的一种数据结构，它的特点如下：
 - 以数列序号形式存放数据 e.g. A[i]
 - 长度固定，长度为N，则需要N个存储空间来储存数据，在同一数组中储存的数据类型必须相同
 - 不包含方法Methods

#### 创建数组 与 更改数组
有三种方式创建数组:
 - `x = new int[3];`
 - `y = new int[]{1, 2, 3, 4, 5};`
 - `int[] z = {9, 10, 11, 12, 13};`

 x, y, z 都是64bit， 用来存储数组的地址。

 字符串也可以构建数组哟: `String[] s = new String[6];` 这个数组中的每项存储的都是一个String的地址，因此每项也是64bit。赋值时`s[4] = "多拉贡";`，则`s[4]`存储的是一个地址，这个地址指向字符串`"多拉贡"`。

 数组的拷贝需要用到系统函数`System.arraycopy(b, 0, x, 3, 2);`,原因是这样滴, 由于数组变量存储的是地址，因此如果这样:
 ```
 int[] x, y;
 x = new int[]{1, 2, 3, 4};
 y = x;
 ```
 那么y中将存储与x一样的地址，y和x指向同一个数组，并不是对数组进行了复制。 系统函数用法: `System.arraycopy(b, 0, x, 3, 2);` 将b数组中的第*0*位开始的*2*个数复制到x数组中从第*3*位开始的数中。

#### 2D数组
创建二维数组的方式与创建一维数组的方式很像:
```
int[][] matrix;
matrix = new int[4][];//创建一个一维数组，每项初始化为null
matrix = new int[4][4];//创建五个一维数组，第一组存储的是剩下四组的地址，剩下四组初始值为0

int[][] pascalAgain = new int[][]{{1}, {1, 1},
                                 {1, 2, 1}, {1, 3, 3, 1}};
```

二维数组简单来说就是多存储一个参考地址，a reference of a reference。 `matrix` 是个地址，`matrix[0]`存储的也是个地址，`matrix[0][0]`存储的才是值。

#### 数组与类的区别
二者最大的区别是数组可以在运行时指定元素的序列，但类不行:
```
int indexOfInterest = askUserForInteger();
int[] x = {100, 101, 102, 103};
int k = x[indexOfInterest];//从用户获得指定序列，没有问题
System.out.println(k);
```

```
String fieldOfInterest = "mass";
Planet p = new Planet(6e24, "earth");
double mass = p.fieldOfInterest;//编译器并不认识实例p中的fieldOfInterest成员，因此报错
```

### 2.5 ArrayList AList

与DLList相比，AList的优势在于根据坐标获得某一项的值时，消耗的时间更短。 DLList需要遍历整个List直到到达对应的坐标，而AList则只需要A[i]就行了。 A[i]的运行时间是个固定值，原因在于Array的存储是连续的一系列地址，因此在知道A的地址的情况下，第i个元素的地址就是A的地址加上i。

```
/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:找到的规律
 addLast: The next item we want to add, will go into position size 在末尾添加元素之后，下次添加的位置与size值相同
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class AList {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size = size - 1;//没必要将最后一项设为0，因为size已经不包括最后一项了。
        return x;
    }
}
```

#### 扩大Array
如果数组被填满了，那么就要扩大它:
```
int[] a = new int[size + 1];
System.arraycopy(items, 0, a, 0, size);
a[size] = 11;
items = a;
size = size + 1;
``` 

上面代码每次只扩大一个，如果要添加很多次(1000)的话，会很慢，因此用乘法:[size * 2]。

在扩建了之后，如果又删除了大量的元素，可以根据使用率size/length来缩小数组，这样就不会造成空间的浪费了。

在Java中，泛型数组是不存在的，因此有一种类似于泛型数组的方法: `Glorp[] items = (Glorp []) new Object[8];`

前面提到在删除元素时没必要将其置零，但如果数组存储的是地址的话，将其置为null，则原来地址所存储的数据就会被删除，因为已经这个地址已经不被其他数据所用了。

关于AList, 将在Project1a中构建: [Project 1a](https://github.com/zerenlu/CS61B_2019Spring/tree/master/proj1a).

## Chapter 3 测试

这一章会传授测试的方法！测试是检查错误的优秀方式。

### 3.1 测试的新方式

学会使用JUnit库来测试，这样就能省去很多输出字符串的代码啦！
```
org.junit.Assert.assertEquals(expected, actual);//比较两个参数是否相同，两个参数可以为数组。
```

测试有个很大的好处就是能够帮助人在重构代码的时候更方便地保证程序的功能不变，重构指的就是在保证代码功能不变的情况下使得代码更简洁或更高效或blablabla。

每次调用比较函数都要先在前面写一长串`org.junit.Assert.`很麻烦，为了简便可以在最前面写上
```
import org.junit.Assert.*
```
这样就只用写`assertEquals`就可以了。

为了不用为了单一测试而将某些测试注释掉，可以在每个测试的方法加上`@org.junit.Test`，这样InteliJ就会自动识别并编译这些测试了，因此也不再需要main函数了。

Test Driven Development以测试为优先前提的开发模式会先把测试写好，然后测试代码直到通过为止，测试有Unit test和Integration test，单元测试只测单一的函数，集成测试测试整个系统。

## Chapter 4 继承

前面提到过Java中的过载属性，过载属性有可能会导致代码的重复，那么解决这一问题的方法就是使用继承。

### Hypernyms上位, Hyponyms下位, 以及 Interface Inheritance 接口继承

上下位其实就是类别的从属关系。 上下位的关系可以通过"是"来表达： 牧羊犬**是**狗。 狗就是Hypernym, 牧羊犬就是Hyponym。

在Java中描述这种上下关系就需要用到关键词`interface`和`implements`。
定义一个上位词List61B，使用interface。
```
public interface List61B<Item> {
    //这里面描述List可以做的事情，而不是如何做事情。
    public void addFirst(Item x);
    public void addLast(Item y);
    ...
}
```
在声明List61B的下位词AList时使用implements，这个过程也叫做interface inheritance:
```
public class AList<Item> implements List61B<Item> {...}
```

AList的这种声明就意味着它在宣称List61B中有的函数，AList这边也一样全都有。

#### 方法重写Overriding
Override其实就是子类将父类中的方法细化，重写，毕竟父类List61B中啥都没写嘛，只是声明了有啥，所以子类AList在继承父类时需要Override父类中提到的方法。

Override是针对父类子类中的同名方法的关系的解释，我们一般说AList overrides addFirst()，AList 重写了addFirst方法。

Overload只是针对某一方法的行为的解释，我们一般说某个方法过载了，并不会提到父子类关系。

如果在子类中某一方法是override，则在这个方法的前一行声明@override，以便编译器及时查看是否有错。

#### Implementation inheritance 构建继承/方法继承

与接口继承不同，implementation inheritance方法继承可以将具体的执行代码写在List61B中，当然，要使用一个新的关键词`default`:
```
default public void print() {
    for (int i = 0; i < size(); i += 1) {
        System.out.print(get(i) + " ");
    }
    System.out.println();
}
```
在List61B中声明之后，就不需要在AList中写print()方法了。

而如果我们在AList或者SList中写了print()方法，那么SList中的print()将会override List61B中的print(), 这是Java的Dynamic method selection, 在子类中声明的方法为dynamic方法。

但Dynamic method selection只应用在override，在overload方法中并不起作用，举个栗子：
```
/*peek方法是过载的，一个形参类型为SLList，另一个形参类型为List61B*/
public static void peek(List61B<String> list) {
    System.out.println(list.getLast());
}
public static void peek(SLList<String> list) {
    System.out.println(list.getFirst());
}
```
在调用的过程中
```
SLList<String> SP = new SLList<String>();
List61B<String> LP = SP;
SP.addLast("elk");
SP.addLast("are");
SP.addLast("cool");
peek(SP);
peek(LP);
```
虽然SP和LP指向的是同一个地址，但peek(SP)与peek(LP)的结果是不同的，因为SP和LP的类型不一样。

### 4.2 Extends 扩展， casting转型，Higher order functions高阶函数

Extends用于继承已有具体方法的类，就是创建子类，并继承父类所有的方法， 比如我们要建一个RotatingSLList，这个类继承所有SLList的方法，而且还有自己独有的一个方法`rotateRight`， 那么我们需要这样声明它:
```
public class RotatingSLList<Item> extends SLList<Item>
//implementation
public void rotateRight() {
    Item x = removeLast();
    addFirst(x);
}
```

子类会继承父类的所有成员，包括实例变量，静态变量，方法，嵌入方法， 但构造器不会被继承，private成员会被继承但无法访问，毕竟是私有嘛，私房钱会被继承并使用吗！

如果需要override父类中的某些方法，但改动是基于父类的方法，可以用关键字`super.`调用父类的方法:
```
@Override
    public Item removeLast() {
        Item x = super.removeLast();//调用父类方法
        deletedItems.addLast(x);
        return x;
    }
```

Java的类在调用的时候必须以构造器开始，所以如果没有在类中定义构造器的话，编译器就会报错，那么子类如何简便的定义构造器呢？用`super();`
```
public VengefulSLList(Item x) {
    super(x);
    deletedItems = new SLList<Item>();
}
```

#### 继承会破坏封装
在Superclass中我们定义
```
public void bark() {
    barkMany(1);
}

public void barkMany(int N) {
    for (int i = 0; i < N; i += 1) {
        System.out.println("bark");
    }
}
```
在Subclass中我们定义
```
@Override
public void barkMany(int N) {
    System.out.println("As a dog, I say: ");
    for (int i = 0; i < N; i += 1) {
        bark();
    }
}
```
创建了子类的实例后我们调用barkMany函数时，根据动态方法的原则，bark()会到父类中去找，然后父类的这个bark()又调用barkMany(),由于动态方法只会选择同名中的一个，即子类中的那个，那么bark()又会被调用。。。。这时出现了无限循环！

#### 类型检查与转型(Casting)

Java的程序运行分为两步-Compile time和Run time。 编译时间那部分负责静态类型，Run time负责动态类型。 举个例子:
```
VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);// vsl 静态类型为VengefulSLList, 动态类型也是
SLList<Integer> sl = vsl; //sl 静态类型为SLList, 动态类型为VengefulSLList

sl.addLast(50);//VengefulSLList中没有定义或Override addLast()方法，所以从父类SLList中寻找
sl.removeLast();//removeLast()被VengefulSLList override了，所以用动态方法，即VengefulSLList中定义的removeLast()

sl.printLostItems();//这个会造成编译器报错，因为sl的静态类型为SLList, 而SLList没有printLostItems成员，尽管sl在run time(动态类型)中的类型是VengefulSLList。

VengefulSLList<Integer> vsl2 = sl;//这个也会造成编译器报错，因为sl is not a vsl2，类型不兼容。
```

#### 高阶函数 High order function

高阶函数的意思就是函数本身也可以作为其他函数的形参/输入。 具体的操作方法就是通过interface完成的：
```
public interface IntUnaryFunction {
    int apply(int x);
}
```
```
public class TenX implements IntUnaryFunction {
    /* Returns ten times the argument. */
    public int apply(int x) {
        return 10 * x;
    }
}
```

```
public class Demo{
    public static int do_twice(IntUnaryFunction f, int x) {
    return f.apply(f.apply(x));
}

main{
    System.out.println(do_twice(new TenX(), 2));
}
}
```

### 4.3 子类型多态vs高阶函数
这节讲得比较没那么容易理解，简单来讲就是父类引用子类对象:
```
Cat a = new Cat();
Animal b = new Cat();
```
父类可以调用自己定义的成员函数，如果子类重写了某些函数，那么父类调用的将是子类重写的函数，但是父类不能调用没有在父类中声明的函数。

嘛，光讲道理是没用的，还是要结合实际用途干起来才行！

## Chapter 5 泛型与自动转型
这一章介绍了一些Java的语法，跟数据结构没啥关系，两点注意事项:
 - 可以用`final`关键词来声明一个变量无法被改变`public final int Month;`
 - 可以对类型应用`extend`关键字来声明对应的变量可以应用父类的方法`public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {...}`，这个太牛逼了。

## Chapter 6 Exceptions, Iterators, Iterables, Object Methods

### 6.1 列表，集合
集合就是一个组合里面所有的元素都是唯一的，不重复的。 这一节没啥特别的，看下一节。

### 6.2 抛出例外【啥破翻译
使用内部已经定义好的方法来报错`throw new IllegalArgumentException("can't add null");`

### 6.3 迭代 iteration
这里讲的迭代就是继承一个迭代器iterator从而获得迭代器的方法。

### 6.4 常用对象方法 toString 和 equals

Nothing special. Let's do the project 1B!

## Chapter 7 函数包和控制权限 Package and Access Control

### Package

包的使用：`import` + 包中的类的名字， 然后就可以用包中的类了， 例如：
```
import ug.joshh.animal.Dog;
...
Dog d = new Dog(...);
```
创建包：`package` + 包的名字，包的名字对应存储的文件夹路径，例如：
```
package ug.joshh.animal;

public class Dog {
    private String name;
    private String breed;
    …
}//Dog 类储存在路径ug/joshh/animal/下
```

如果不声明某些类是在哪个包中，这个类就会被默认为在Default包下。 *注意*：除了小的程序，一定要声明这个类在哪个包下，因为Default包无法被`import`或其他方法引用（貌似反射可以？）

在InteliJ中，File->new Package 可以用来创建程序包。

JAR 文件可以用来直接导入多个类、 包。 JAR 文件只是多个类的压缩文件，将JAR文件后缀改成zip之后就可以看到里面的内容。

导入JAR文件InteliJ：File → Project Structure → Artifacts → JAR添加完之后记得Build → Build Artifacts

### Access Control

访问权限，主要是看某一声明的变量到底能不能被其他函数/包/类访问。
目前的关键字有public, private, protected以及无关键字声明(代表着可以被同类和同包访问)：
|Modifier|Class|Package|Subclass|World|
|--------|--------|--------|--------|--------|
|public|Y|Y|Y|Y|
|protected|Y|Y|Y|N|
||Y|Y|N|N|
|private|Y|N|N|N|

## Chapter 8 高效编程

### 8.1 封装， API 和 ADT
API(Application Programming Interface)是通过接口提供一系列功能。 ADT(Abstract Data Structures)是通过行为(behaviors)来定义自己的上层类，具体实现方法(implementations)并不是定义ADT的要点， 比如Deque是一种数据结构，它的行为包括添加，删除等等，但具体的实现方法有多种，可以是Array实现，也可以是链表实现。

### 8.2 Asymptotics 效率分析

从这部分开始是课程的下半部分，将会集中在分析程序的时间复杂度、空间复杂度。

嘛，讲了一堆有的没的，说白了就是看一个算法在最坏的情况下需要用时多久，根据最坏情况粗略判断这个算法的复杂度，复杂度就是Big O, O(f(n))中f(n)这个函数代表了算法所耗时的大致计算。

### 8.3 Asymptotics 效率分析II

这部分进一步讲了如果要算一个算法的复杂度，需要仔细算下来，不能只靠看有几个for循环。

### 8.4 Omega, Amortized Analysis 平摊分析

平摊分析是从全貌分析算法复杂度的一种方法，简单来讲，就是把所有cost全考虑进去然后取平均。

## 9 集合 Disjoint Sets
第八章讲了分析算法的复杂度基本需要哪些工具，概念。 这章开始讲基本的算法。

### 9.1 简介
Disjoint Sets是指两个集合交集为0，也就是这两个集合没有相同的成员。 这个类包含两种方法：connect()和isConnect(). connect()将两个成员连接起来，isConnect()用来判断两个成员是否相连接。

### 9.2 Quick Find

快速查找的算法是基于List数据结构，列表的index代表了对应的成员，index所存储的值代表了这个成员所属的集合。
```
public class QuickFindDS implements DisjointSets {

    private int[] id;

    /* Θ(N) */
    public QuickFindDS(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    /* need to iterate through the array => Θ(N) */
    public void connect(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    /* Θ(1) */
    public boolean isConnected(int p, int q){
        return (id[p] == id[q]);
    }
```

### 9.3 Quick Union
quick union的算法就是将每个index的父节点储存在index所指向的值中，也就是形成一个树形结构:
```
public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
```
### 9.4 Weighted quick union

在连接的时候直接将小的集合的根连接到大的集合的根节点上。 这样的话复杂度就可以降低到logN。

### 9.5 WQU with Path Compression

加上path compression后，就是在find()运行时，将要查找的元素的父节点设置为父节点的父节点直到root。

## 10 ADT abstract data type

### 10.1 简介
数据结构类型由其行为决定，而不是其实现的方法。

常用的数据结构类型：栈，列表，集合（无重复元素），图（键/值一一对应）

### 10.2 Binary Search Trees二叉查找树！！！

经典的数据结构概念，便于迅速查找，性质为：
- 对于任意两个节点的值p,q, 一定有`p>q`或`p<q` 为真，但不能同时为真
- 对于任意三个节点的值p,q,r，如果p>q, 且q>r则能推出p>r

以上为数学上的定义/解释，描述性的解释为：对于一棵树或者具有下列性质的二叉树
- 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
- 若任意节点的右子树不空，则右子树上所有节点的值均大于或等于它的根节点的值；
- 任意节点的左、右子树也分别为二叉查找树；

二叉搜索树的数据结构可以用来实现set, map等抽象数据结构。

在二叉搜索树中插入某个值，最好用递归方法。在二叉搜索树中删除某个值，要找到这个值的precussesor 和 successer，然后将二者其一代替要删除的值，这样能保证二叉树搜索树的属性。