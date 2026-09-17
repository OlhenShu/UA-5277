package com.softserve.academy.module13;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Демонстрація основних методів класу {@link String}.
 * <p>
 * Ключова ідея: String — незмінний (immutable) тип. Жоден метод не змінює рядок,
 * на якому його викликали, — кожен повертає НОВИЙ рядок.
 */
public class StringMethodExample {

    public static void main(String[] args) {
        demonstrateCreationAndComparison();
        demonstrateLengthAndSearch();
        demonstrateExtraction();
        demonstrateTransformation();
        demonstrateSplitAndJoin();
        demonstrateFormattingAndConversion();
        demonstrateImmutability();
    }

    /* ==================== 1. Створення та порівняння ==================== */
    private static void demonstrateCreationAndComparison() {
        printHeader("1. Створення та порівняння");

        // Строковий літерал потрапляє в String Pool (пул рядків) у пам'яті.
        String str1 = "Hello, World!";

        // Конкатенація літералів обчислюється компілятором,
        // тому str3 — це той самий об'єкт із пулу, що й str1.
        String str3 = "Hello," + " World!";

        // new String(...) ЗАВЖДИ створює новий об'єкт у heap, поза пулом.
        String str2 = new String("Hello, World!");

        // equals() порівнює ВМІСТ рядків — саме так треба порівнювати рядки.
        System.out.println("str1.equals(str3) = " + str1.equals(str3));   // true
        System.out.println("str1.equals(str2) = " + str1.equals(str2));   // true

        // == порівнює ПОСИЛАННЯ (адреси об'єктів), а не вміст.
        System.out.println("str1 == str3      = " + (str1 == str3));      // true — обидва з пулу
        System.out.println("str1 == str2      = " + (str1 == str2));      // false — різні об'єкти

        // intern() повертає посилання на еквівалентний рядок із пулу.
        System.out.println("str1 == str2.intern() = " + (str1 == str2.intern())); // true

        // equalsIgnoreCase() — порівняння вмісту без урахування регістру.
        System.out.println("\"JAVA\".equalsIgnoreCase(\"java\") = " + "JAVA".equalsIgnoreCase("java")); // true

        // compareTo() — лексикографічне порівняння: <0, 0 або >0.
        // Використовується при сортуванні (Comparable).
        System.out.println("\"apple\".compareTo(\"banana\") = " + "apple".compareTo("banana")); // від'ємне
        System.out.println("\"banana\".compareTo(\"apple\") = " + "banana".compareTo("apple")); // додатне
        System.out.println("\"apple\".compareTo(\"apple\")  = " + "apple".compareTo("apple"));  // 0

        // compareToIgnoreCase() — те саме, але без урахування регістру.
        System.out.println("\"Apple\".compareToIgnoreCase(\"apple\") = " + "Apple".compareToIgnoreCase("apple")); // 0

        // Безпечне порівняння, коли змінна може бути null:
        // літерал ставимо ліворуч, щоб гарантовано не отримати NullPointerException.
        String mayBeNull = null;
        System.out.println("\"test\".equals(null) = " + "test".equals(mayBeNull)); // false, без винятку
    }

    /* ==================== 2. Довжина та пошук ==================== */
    private static void demonstrateLengthAndSearch() {
        printHeader("2. Довжина та пошук");

        String text = "Java programming language";

        // length() — кількість символів (для String це метод, не поле, як у масиві).
        System.out.println("length() = " + text.length()); // 25

        // isEmpty() — true лише якщо довжина дорівнює 0.
        System.out.println("\"\".isEmpty()    = " + "".isEmpty());    // true
        System.out.println("\"   \".isEmpty() = " + "   ".isEmpty()); // false — пробіли теж символи

        // isBlank() (Java 11) — true, якщо рядок порожній АБО містить лише пробільні символи.
        System.out.println("\"   \".isBlank() = " + "   ".isBlank()); // true

        // charAt(index) — символ за індексом; індексація з 0.
        System.out.println("charAt(0) = " + text.charAt(0));                    // J
        System.out.println("charAt(length()-1) = " + text.charAt(text.length() - 1)); // e
        // УВАГА: text.charAt(100) кине StringIndexOutOfBoundsException.

        // indexOf() — індекс ПЕРШОГО входження, або -1, якщо не знайдено.
        System.out.println("indexOf(\"a\")      = " + text.indexOf("a"));     // 1
        System.out.println("indexOf(\"a\", 5)   = " + text.indexOf("a", 5));  // пошук починаючи з індексу 5
        System.out.println("indexOf(\"Python\") = " + text.indexOf("Python")); // -1

        // lastIndexOf() — індекс ОСТАННЬОГО входження.
        System.out.println("lastIndexOf(\"a\") = " + text.lastIndexOf("a"));

        // contains() — чи міститься підрядок (зручніше, ніж indexOf(...) != -1).
        System.out.println("contains(\"gram\") = " + text.contains("gram")); // true

        // startsWith() / endsWith() — перевірка початку та кінця рядка.
        System.out.println("startsWith(\"Java\")     = " + text.startsWith("Java"));      // true
        System.out.println("endsWith(\"language\")   = " + text.endsWith("language"));    // true
        System.out.println("startsWith(\"gram\", 9)  = " + text.startsWith("gram", 9));   // з певної позиції

        // matches() — чи відповідає ВЕСЬ рядок регулярному виразу.
        System.out.println("\"+380671234567\".matches(\"\\\\+380\\\\d{9}\") = "
                + "+380671234567".matches("\\+380\\d{9}")); // true
    }

    /* ==================== 3. Вибірка підрядків ==================== */
    private static void demonstrateExtraction() {
        printHeader("3. Вибірка підрядків");

        String email = "student@softserve.com";

        // substring(beginIndex) — від індексу і до кінця рядка.
        System.out.println("substring(8) = " + email.substring(8)); // softserve.com

        // substring(begin, end) — [begin; end): початок включно, кінець НЕ включно.
        System.out.println("substring(0, 7) = " + email.substring(0, 7)); // student

        // Практичний приклад: витягнути домен за позицією символу '@'.
        String domain = email.substring(email.indexOf('@') + 1);
        System.out.println("Домен: " + domain); // softserve.com

        // chars() (Java 8) — потік кодів символів; зручно для підрахунків.
        long vowels = "programming".chars()
                .filter(c -> "aeiouy".indexOf(c) >= 0)
                .count();
        System.out.println("Кількість голосних у \"programming\": " + vowels);

        // toCharArray() — копія вмісту у вигляді масиву char[].
        char[] chars = "Java".toCharArray();
        System.out.println("toCharArray() = " + Arrays.toString(chars)); // [J, a, v, a]
    }

    /* ==================== 4. Перетворення рядка ==================== */
    private static void demonstrateTransformation() {
        printHeader("4. Перетворення (повертають НОВИЙ рядок)");

        String messy = "   Hello, World!   ";

        // trim() — прибирає пробіли та керівні символи (код <= U+0020) з обох боків.
        System.out.println("trim()   = [" + messy.trim() + "]");

        // strip() (Java 11) — те саме, але коректно працює з Unicode-пробілами.
        System.out.println("strip()  = [" + messy.strip() + "]");

        // stripLeading() / stripTrailing() — обрізання лише зліва або лише справа.
        System.out.println("stripLeading()  = [" + messy.stripLeading() + "]");
        System.out.println("stripTrailing() = [" + messy.stripTrailing() + "]");

        // toUpperCase() / toLowerCase() — зміна регістру.
        System.out.println("toUpperCase() = " + "Java".toUpperCase()); // JAVA
        System.out.println("toLowerCase() = " + "Java".toLowerCase()); // java

        // replace(char, char) та replace(CharSequence, CharSequence) — заміна всіх входжень.
        System.out.println("replace('a', 'o') = " + "Java".replace('a', 'o')); // Jovo
        System.out.println("replace(\"World\", \"Java\") = " + "Hello, World!".replace("World", "Java")); // Hello, Java!

        // replaceAll() працює з РЕГУЛЯРНИМ виразом, replaceFirst() — лише перше входження.
        System.out.println("replaceAll(\"\\\\d\", \"*\") = " + "a1b2c3".replaceAll("\\d", "*")); // a*b*c*
        System.out.println("replaceFirst(\"\\\\d\", \"*\") = " + "a1b2c3".replaceFirst("\\d", "*")); // a*b2c3

        // concat() — з'єднання; зазвичай зручніше використовувати оператор +.
        System.out.println("concat() = " + "Hello, ".concat("World!"));

        // repeat(n) (Java 11) — повторення рядка n разів.
        System.out.println("repeat(3) = " + "ab".repeat(3)); // ababab

        // lines() (Java 11) — розбиття багаторядкового тексту на потік рядків.
        String multiline = """
                перший рядок
                другий рядок
                третій рядок""";   // текстовий блок (Java 15)
        multiline.lines().forEach(line -> System.out.println("  рядок -> " + line));
    }

    /* ==================== 5. Розбиття та об'єднання ==================== */
    private static void demonstrateSplitAndJoin() {
        printHeader("5. Розбиття та об'єднання");

        String csv = "Ivan,Petro,Olha,Maria";

        // split(regex) — розбиває рядок за роздільником (це РЕГУЛЯРНИЙ вираз!).
        String[] names = csv.split(",");
        System.out.println("split(\",\") = " + Arrays.toString(names));

        // Роздільники-метасимволи треба екранувати: "." сам по собі означає "будь-який символ".
        System.out.println("split(\"\\\\.\") = " + Arrays.toString("192.168.0.1".split("\\.")));

        // split(regex, limit) — обмеження кількості частин: останній елемент лишається цілим.
        System.out.println("split(\",\", 2) = " + Arrays.toString(csv.split(",", 2)));

        // String.join() — статичний метод, зворотна операція до split().
        System.out.println("String.join(\" | \", ...) = " + String.join(" | ", names));

        // StringJoiner — коли потрібні префікс та суфікс.
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String name : names) {
            joiner.add(name);
        }
        System.out.println("StringJoiner = " + joiner);
    }

    /* ==================== 6. Форматування та конвертація ==================== */
    private static void demonstrateFormattingAndConversion() {
        printHeader("6. Форматування та конвертація");

        // String.format() / formatted() (Java 15) — підстановка значень у шаблон.
        // %s — рядок, %d — ціле, %.2f — дробове з двома знаками, %n — перенесення рядка.
        String report = String.format("Студент: %s, вік: %d, середній бал: %.2f", "Олег", 20, 4.756);
        System.out.println(report);
        System.out.println("Товар: %s, ціна: %,.2f грн".formatted("Ноутбук", 34999.5));

        // valueOf() — конвертація будь-якого типу в рядок (безпечна для null).
        System.out.println("String.valueOf(42)    = " + 42);
        System.out.println("String.valueOf(3.14)  = " + String.valueOf(Math.PI));
        System.out.println("String.valueOf(true)  = " + String.valueOf(true));
        System.out.println("String.valueOf((Object) null) = " + String.valueOf((Object) null)); // "null"

        // Зворотна конвертація: рядок -> число (кине NumberFormatException, якщо формат хибний).
        int parsed = Integer.parseInt("123");
        System.out.println("Integer.parseInt(\"123\") + 1 = " + (parsed + 1)); // 124

        // hashCode() — числовий хеш вмісту; однаковий для однакових рядків.
        System.out.println("\"Java\".hashCode() = " + "Java".hashCode());

        // toString() у String повертає сам об'єкт — метод присутній заради Object API.
        System.out.println("\"Java\".toString() = " + "Java".toString());
    }

    /* ==================== 7. Незмінність (immutability) ==================== */
    private static void demonstrateImmutability() {
        printHeader("7. Незмінність рядків");

        String original = "Java";

        // Результат методу ПОТРІБНО присвоїти — інакше він просто втрачається.
        original.toUpperCase();
        System.out.println("Після виклику без присвоєння: " + original); // Java — не змінився

        String upper = original.toUpperCase();
        System.out.println("Після присвоєння: " + upper); // JAVA

        // Конкатенація в циклі створює новий об'єкт на кожній ітерації — це повільно.
        // Для накопичення тексту використовуйте StringBuilder (змінний і швидкий).
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            builder.append(i).append(" ");
        }
        System.out.println("StringBuilder = " + builder.toString().strip());
        System.out.println("reverse()     = " + new StringBuilder("Java").reverse()); // avaJ
    }

    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }
}
