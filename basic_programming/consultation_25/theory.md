1. Понять, где у вас работа с консолью - сделать для этого отдельные классы
2. Понять, где у вас работа с файлами - сделать для этого отдельные классы
3. Понять, где у вас "логика" - сделать для этого отдельные классы (сервисы)
4. Понять, где у вас проверка входных данных - тоже отдельный класс

Тестировать те классы, в которых есть логика, независимая от ввода и вывода.
-----------------------------------------------------------------------------

Метод может быть не простым, он может вызывать кучу других методов, но вы должны иметь возможность
подать ему на вход что-то простое и понятное (Scanner - не простое и понятное) и получить
простой и понятный эффект.

Не нужно писать тесты на консоль.