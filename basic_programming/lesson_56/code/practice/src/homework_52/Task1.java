package homework_52;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

  // Во всех задачах разбивайте решение на несколько коммитов:
  // - условие в комментарии и никакого кода
  // - решение без учёта файлов - чтение с клавиатуры и вывод на экран
  // - добавляем файлы, если они указаны в задаче
  // - разбиваем задачу на методы
  // - добавляем `try`..`catch`
  //
  // Напишите программу создания небольшого словаря сленговых программерских выражений, чтобы она
  // потом по запросу возвращала значения из этого словаря.
  //
  // ## Формат входных данных
  //
  // ## Формат выходных данных
  // Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
  // необходимо вывести **на экран** его определение.
  //
  // Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
  //
  //
  // ## Примечание 2
  // Гарантируется, что в определяемом слове или фразе отсутствует двоеточие (`:`), следом за
  // которым идёт пробел.
  //
  // ## Пример входных данных
  // 5
  // Змея: язык программирования Python
  // Баг: от англ. bug — жучок, клоп, ошибка в программе
  // Конфа: конференция
  // Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
  // Бета: бета-версия, приложение на стадии публичного тестирования
  // 3
  // Змея
  // Жаба
  // костыль
  //
  // ## Пример выходных данных
  // язык программирования Python
  // Не найдено
  // код, который нужен, чтобы исправить несовершенство ранее написанного кода
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // ### Файл `dict.txt`
    // В первой строке задано одно целое число `n` — количество слов в словаре.
    int n = scanner.nextInt();
    scanner.nextLine();
    // В следующих `n` строках записаны слова и их определения, разделенные двоеточием и символом
    // пробела.
    Map<String, String> dictionary = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      String wordAndDescription = scanner.nextLine();
      //                       012345678
      // wordAndDescription = "Змея: язык программирования Python"
      int separatorIndex = wordAndDescription.indexOf(": ");
      // separatorIndex = 4 // индекс начала ": "
      String word = wordAndDescription.substring(0, separatorIndex);
      // word = "Змея" // от beginIndex включая до endIndex не включая
      String description = wordAndDescription.substring(separatorIndex + 2);
      // description = "язык программирования Python" // c (separatorIndex + 2 = 6) до конца строки
      dictionary.put(word.toLowerCase(), description);
    }
    // ### Ввод с клавиатуры
    // В первой строке записано целое число `m` — количество поисковых слов, чье определение нужно
    // вывести.
    int m = scanner.nextInt();
    scanner.nextLine();
    // В следующих `m` строках записаны сами слова, по одному на строке.
    for (int i = 0; i < m; ++i) {
      String word = scanner.nextLine();
      // Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
      // необходимо вывести **на экран** его определение.
      if (dictionary.containsKey(word.toLowerCase())) {
        System.out.println(dictionary.get(word.toLowerCase()));
      } else {
        // Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
        System.out.println("Не найдено");
      }
    }
  }
}
