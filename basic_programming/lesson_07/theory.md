# Lesson 07

## 00. Разбор домашнего задания

### Task09

* Когда мы считываем информацию с консоли посимвольно, нам приходят символы/коды. Мы ничего не знаем об их значении.

* Все, что мы знаем:

- Получить код самого символа в таблице Unicode (UTF)

```java
char c = scanner.next().charAt(0); // например, подано 'A'
int code = c; // code -> 65, неявное преобразование
```

- Получить символ по его коду:

```java
int code = 65;
char c = (char)code; // c -> 'A', явное преобразование
```

- С символами можно работать как с числами

```java
char c = 'A'; // 65
c = (char)(c + 1); // c -> 'B', c -> 66
```

* Как получить `int`-число на основе `char`-цифры:

```java
int digit = c - '0';
```

* Любое число можно представить в виде сомножителей со степенью 10-ти:

```
abcd = a * 1000 + b * 100 + c * 10 + d * 1

4,3,2,9 -> 4329

4 * 1000 + 3 * 100 + 2 * 10 + 9 * 1 = 4329

a,b,c,d - известный, точнее изветны их коды, нужно получить сами числа

int number = ....;
```

* Почему неправильно так:

```
System.out.println("" + number0 + number1 + number2 + number3 + number4)
```

```
Это как ввод в банкомате суммы. Ввели СИМВОЛЫ: 345 и компилятор это и читает как отдельные символы которые просто стоят вместе : 3.  4. 5! Он и выдаст вам так деньги сначала три потом четыре и пять. Результат неприятный. А нужно этот ввод запихнуть в одну переменную и выдать 345
```

* Потому что вы просто склеиваете строки и выводите на экран, а реального числа, с которым дальше можно работать вы не получаете.

* Помним, как работает Scanner:

```
int number = scanner.nextInt();
number = number + 1;
```

## 01. Преобразование типов

* Переменные могут быть разных типов (рассматриваем численные типы):

- byte - целые числа (1 байт)
- int - целые числа (4 байта)
- double - вещественные числа (8 байт)
- char - символьный тип (2 байта)

* Мы можем выполнять преобразования между перемеными разных типов одного вида

### Явное преобразование

#### Пример 1

```
int a = 8;
byte b = a;
```

* Здесь мы кладем переменную типа `int` со значением `8` в переменную типа `byte` (преобразование `int` в `byte`, от большему к меньшему).

* Компилятор не может выполнить такое преобразование "с ходу", потому что тут потенциально возможна потеря данных. Поскольку `int` больше, чем `byte`.  Следовательно код выше не скомпилируется, будет ошибка:

```
possible lossy conversion from int to byte
```

* Явное преобразование - преобразования от большего к меньшему, с возможной потерей данных и с явным указанием целевого типа. Чтобы дать компилятору понять, что мы идем на этот шаг осознанно:

```java
int a = 90;
byte b = (byte)a;
```

#### Пример 2

* Преобразование от `double` к `int`:

```java
double d = 15.7;
int i = d;
```

* Получаем ошибку:

```
possible lossy conversion from double to int
```

* Пишем явное преобразование:

```java
double d = 15.7;
int i = (int)d; // 15
```

#### Пример 3

* Преобразование `int` (4 байта) в `char` (2 байта)

```java
int  i = 65;
char c = i;
```

* Получаем ошибку

```
possible lossy conversion from int to char
```

* Пишем явное преобразование 

```java
int  i = 65;
char c = (char)i; // c -> 'A'
```

#### Какие преобразование должны быть указаны явно?

* Преобразования с потерей данных:

- `int` в `byte`
- `double` в `int`
- `int` в `char`
- `double` в `char`
- `double` в `long`

* Формула явного преобразования:

```
МЕНЬШИЙ_ТИП переменная = (МЕНЬШИЙ_ТИП)переменная_большего_типа;
```

* Намеренная потеря данных

### Неявное преобразование 

* Преобразования от `меньшего` к `большему` без потери данных:

* Например `char` в любой тип, больше 2-х байт:

```java
char c = 'A';

double d = c;
long l = c;
int i = c;
```

* Например `int` в `long` или `double`:

```java
int i = 75;

long l = i;
double d = i;
```

* Например `long` в `double`:

```java
long l = 10;
double d = l;
```

### Последовательность неявных преобразований:

```
byte(1 байт) -> char(2 байта) -> int(4 байта) -> long(8 байт) -> double(8 байт)
```

* Идем вправо - неявно
* Идем влево - явно

### Переменные разных типов в одном выражений

* Целые числа в коде по-умолчанию - `int`

```java
long i = 2147483648; // ошибка компиляции - integer number too large
```

```java
long i = (long)2_147_483_648; // ошибка компиляции - integer number too large
```

- правильно:

```java
long i = 2147483648L; 
```

* Вещественные числа в коде по-умолчанию - `double`

* Действует правило - все типы преобразуются к самому БОЛЬШЕМУ в выражении:

```java
int i = 10;
double d = 5.0;
long x = 100;

int result1;
long result2;
double result3;

//        result1 = i + d + x; // нельзя
//        result2 = i + d + x; // нельзя

result3 = i + d + x; // можно
```

* В целом можно запомнить принцип с коробками.

## 01. Условный оператор

* Условие (ветвление) - это одна из структур управления. Позволяет разделить логику работы на ветки и исполнять только одну из них, в зависимости от условия.

* Если условие истинное, то выполняется `блок1`, если условие - ложное, то выполняется `блок2`

![image](https://raw.githubusercontent.com/ait-tr/cohort27/main/basic_programming/lesson_07/img/1.png)

* Например, если число четное - делим на два, если нечетное - прибавляем 1

![image](https://raw.githubusercontent.com/ait-tr/cohort27/main/basic_programming/lesson_07/img/2.png)

```
if (условие) {
	блок1;
} else {
	блок2;
}
```

* `условие` - выражение, которое имеет результат `true`/`false`

### Тип boolean

* `boolean` - логический тип, может хранить значения `true` или `false`

### Операторы сравнения

* Их результат всегда `true`/`false`

* Это операторы:

- `==` - равенство
- `<=` - меньше равно
- `>=` - больше равно
- `!=` - не равно, 4 != 4 (`false`), 5 != 4 (`true`)
- `>` - больше
- `<` - меньше

### Блок-схема задачи

```
если число четное, и оканчивается на 0 - разделить на 10
если число четное и оканчивается на 2 - разделить на 2
если число нечетное - просто вывести противоположное значение
все остальные ситуации игнорируются
```

* см. код `Main2`

![image](https://raw.githubusercontent.com/ait-tr/cohort27/main/basic_programming/lesson_07/img/3.png)