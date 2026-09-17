package com.softserve.academy.module13;

import java.util.List;
import java.util.Locale;

/**
 * Демонстрація створення та форматування таблиці засобами класу {@link String}
 * (методи {@code format}, {@code formatted}, {@code repeat}) та {@code System.out.printf}.
 * <p>
 * Основна ідея форматування: специфікатор має вигляд
 * <pre>%[індекс$][прапорці][ширина][.точність]тип</pre>
 * наприклад {@code %-20s} — рядок, вирівняний ЛІВОРУЧ у полі шириною 20 символів.
 */
public class TableFormattingExample {

    /**
     * Дані, які виводитимемо у вигляді таблиці.
     */
    private static final List<Product> PRODUCTS = List.of(
            new Product("Ноутбук Lenovo IdeaPad 5", "Техніка", 3, 27499.99),
            new Product("Миша бездротова", "Аксесуари", 12, 649.5),
            new Product("Монітор 27\"", "Техніка", 5, 8990.0),
            new Product("Кабель HDMI 2 м", "Аксесуари", 40, 199.99),
            new Product("Клавіатура механічна", "Аксесуари", 7, 2450.0)
    );

    public static void main(String[] args) {
        demonstrateFormatSpecifiers();
        printTableWithFixedWidth();
        printTableWithDynamicWidth();
        printTableWithTruncation();
    }

    /* ==================== 1. Специфікатори форматування ==================== */
    private static void demonstrateFormatSpecifiers() {
        printHeader("1. Специфікатори форматування");

        // %s — рядок. Ширина задає МІНІМАЛЬНИЙ розмір поля (довший текст не обрізається).
        System.out.printf("[%s]%n", "текст");          // [текст]
        System.out.printf("[%10s]%n", "текст");        // праворуч (за замовчуванням)
        System.out.printf("[%-10s]%n", "текст");       // ліворуч — прапорець '-'

        // %d — ціле число.
        System.out.printf("[%d]%n", 42);
        System.out.printf("[%6d]%n", 42);              // вирівнювання праворуч
        System.out.printf("[%06d]%n", 42);             // доповнення нулями — прапорець '0'
        System.out.printf("[%+d]%n", 42);              // завжди зі знаком — прапорець '+'

        // %f — дробове число. .2 — точність (кількість знаків після коми, з округленням).
        System.out.printf("[%f]%n", 3.14159);          // 6 знаків за замовчуванням
        System.out.printf("[%.2f]%n", 3.14159);        // 3.14
        System.out.printf("[%10.2f]%n", 3.14159);      // ширина 10 + 2 знаки

        // ',' — роздільник тисяч. Він залежить від локалі, тому для передбачуваного
        // результату локаль краще задавати явно.
        System.out.printf(Locale.US, "[%,.2f]%n", 1234567.891);       // 1,234,567.89
        System.out.printf(Locale.GERMANY, "[%,.2f]%n", 1234567.891);  // 1.234.567,89

        // Для %s точність, навпаки, ОБРІЗАЄ рядок до вказаної кількості символів.
        System.out.printf("[%.4s]%n", "abcdefgh");     // abcd

        // %n — перенесення рядка (платформонезалежне, краще за "\n").
        // %% — вивести сам символ відсотка.
        System.out.printf("Виконано на 85%%%n");

        // Індекс аргументу (%1$s) дозволяє використати один аргумент кілька разів.
        System.out.printf("%1$s -> %2$s -> %1$s%n", "A", "B");

        // String.format() робить те саме, але повертає рядок, а не друкує його.
        String cell = String.format("%-12s|", "комірка");
        System.out.println(cell);

        // formatted() (Java 15) — той самий format(), але викликаний на шаблоні.
        System.out.println("%-12s|".formatted("те саме"));
    }

    /* ==================== 2. Таблиця з фіксованою шириною ==================== */
    private static void printTableWithFixedWidth() {
        printHeader("2. Таблиця з фіксованою шириною колонок");

        // Один шаблон для заголовка і для даних: усі значення передаємо як рядки (%s),
        // бо числа ми форматуємо окремо — так простіше тримати вирівнювання.
        String rowFormat = "| %-26s | %-10s | %5s | %12s | %13s |%n";

        // Роздільник збираємо через repeat(): ширина колонки + 2 пробіли навколо тексту.
        String separator = "+" + "-".repeat(28)
                + "+" + "-".repeat(12)
                + "+" + "-".repeat(7)
                + "+" + "-".repeat(14)
                + "+" + "-".repeat(15) + "+";

        System.out.println(separator);
        System.out.printf(rowFormat, "Назва", "Категорія", "К-сть", "Ціна, грн", "Сума, грн");
        System.out.println(separator);

        double grandTotal = 0;
        for (Product product : PRODUCTS) {
            grandTotal += product.total();
            System.out.printf(rowFormat,
                    product.name(),
                    product.category(),
                    product.quantity(),
                    money(product.price()),
                    money(product.total()));
        }

        System.out.println(separator);
        // Підсумковий рядок: перші три колонки об'єднуємо в один напис.
        System.out.printf(rowFormat, "РАЗОМ", "", "", "", money(grandTotal));
        System.out.println(separator);
    }

    /* ==================== 3. Таблиця з динамічною шириною ==================== */
    private static void printTableWithDynamicWidth() {
        printHeader("3. Таблиця з динамічною шириною (рамка з псевдографіки)");
        // УВАГА: щоб символи рамки та кирилиця відображались коректно, консоль має
        // працювати в UTF-8 (у Windows-терміналі: chcp 65001).

        String[] headers = {"Назва", "Категорія", "К-сть", "Ціна, грн", "Сума, грн"};

        // true — вирівнювати ліворуч (текст), false — праворуч (числа).
        boolean[] leftAlign = {true, true, false, false, false};

        // Готуємо дані у вигляді матриці рядків: +1 рядок для підсумку.
        String[][] rows = new String[PRODUCTS.size() + 1][];
        double grandTotal = 0;
        for (int i = 0; i < PRODUCTS.size(); i++) {
            Product product = PRODUCTS.get(i);
            grandTotal += product.total();
            rows[i] = new String[]{
                    product.name(),
                    product.category(),
                    String.valueOf(product.quantity()),
                    money(product.price()),
                    money(product.total())
            };
        }
        rows[rows.length - 1] = new String[]{"РАЗОМ", "", "", "", money(grandTotal)};

        // Ширина кожної колонки = довжина найдовшого значення в ній (враховуючи заголовок).
        int[] widths = calculateWidths(headers, rows);

        String rowFormat = buildRowFormat(widths, leftAlign);
        // Заголовок вирівнюємо по центру — це доводиться робити вручну,
        // бо у String.format немає прапорця центрування.
        String headerFormat = buildRowFormat(widths, new boolean[headers.length]);

        System.out.println(buildSeparator(widths, '┌', '┬', '┐'));
        System.out.printf(headerFormat, (Object[]) center(headers, widths));
        System.out.println(buildSeparator(widths, '├', '┼', '┤'));

        for (int i = 0; i < rows.length; i++) {
            // Перед підсумковим рядком малюємо ще один роздільник.
            if (i == rows.length - 1) {
                System.out.println(buildSeparator(widths, '├', '┼', '┤'));
            }
            System.out.printf(rowFormat, (Object[]) rows[i]);
        }

        System.out.println(buildSeparator(widths, '└', '┴', '┘'));
    }

    /* ==================== 4. Обрізання довгих значень ==================== */
    private static void printTableWithTruncation() {
        printHeader("4. Обрізання значень, що не вміщуються");

        int nameWidth = 14;
        String rowFormat = "| %-" + nameWidth + "s | %-9s |%n";
        String separator = "+" + "-".repeat(nameWidth + 2) + "+" + "-".repeat(11) + "+";

        System.out.println(separator);
        System.out.printf(rowFormat, "Назва", "Категорія");
        System.out.println(separator);
        for (Product product : PRODUCTS) {
            // fit() гарантує, що колонка не «поїде» через задовгу назву.
            System.out.printf(rowFormat, fit(product.name(), nameWidth), product.category());
        }
        System.out.println(separator);

        // Готовий рядок таблиці можна не друкувати одразу, а накопичити у StringBuilder
        // (наприклад, щоб потім записати у файл або повернути з методу).
        StringBuilder report = new StringBuilder();
        for (Product product : PRODUCTS) {
            report.append(String.format("%-16s %s%n", fit(product.name(), 16), money(product.total())));
        }
        System.out.print("\nТой самий звіт, зібраний у StringBuilder:\n" + report);
    }

    /**
     * Форматує суму з роздільником тисяч і двома знаками після коми.
     */
    private static String money(double value) {
        return String.format(Locale.US, "%,.2f", value);
    }

    /* ==================== Допоміжні методи ==================== */

    /**
     * Обчислює ширину кожної колонки як довжину найдовшого значення в ній.
     */
    private static int[] calculateWidths(String[] headers, String[][] rows) {
        int[] widths = new int[headers.length];
        for (int col = 0; col < headers.length; col++) {
            widths[col] = headers[col].length();
        }
        for (String[] row : rows) {
            for (int col = 0; col < row.length; col++) {
                widths[col] = Math.max(widths[col], row[col].length());
            }
        }
        return widths;
    }

    /**
     * Збирає шаблон рядка таблиці, наприклад: {@code │ %-24s │ %-9s │ %5s │%n}.
     * Саме так формат стає залежним від даних, а не «зашитим» у код.
     */
    private static String buildRowFormat(int[] widths, boolean[] leftAlign) {
        StringBuilder format = new StringBuilder();
        for (int col = 0; col < widths.length; col++) {
            format.append("│ %")
                    .append(leftAlign[col] ? "-" : "")
                    .append(widths[col])
                    .append("s ");
        }
        return format.append("│%n").toString();
    }

    /**
     * Малює горизонтальну лінію рамки із заданими кутовими символами.
     */
    private static String buildSeparator(int[] widths, char left, char middle, char right) {
        StringBuilder line = new StringBuilder().append(left);
        for (int col = 0; col < widths.length; col++) {
            line.append("─".repeat(widths[col] + 2))          // +2 — пробіли навколо тексту
                    .append(col == widths.length - 1 ? right : middle);
        }
        return line.toString();
    }

    /**
     * Центрує заголовки в межах ширини колонки, доповнюючи їх пробілами.
     */
    private static String[] center(String[] headers, int[] widths) {
        String[] centered = new String[headers.length];
        for (int col = 0; col < headers.length; col++) {
            int free = widths[col] - headers[col].length();
            int leftPadding = free / 2;
            centered[col] = " ".repeat(leftPadding) + headers[col] + " ".repeat(free - leftPadding);
        }
        return centered;
    }

    /**
     * Обрізає задовге значення, позначаючи скорочення трикрапкою.
     */
    private static String fit(String value, int width) {
        return value.length() <= width ? value : value.substring(0, width - 1) + "…";
    }

    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===\n");
    }

    /**
     * Один рядок таблиці. Record зручний для даних: поля незмінні, геттери генеруються автоматично.
     */
    private record Product(String name, String category, int quantity, double price) {

        /**
         * Сума за позицією = кількість * ціна.
         */
        double total() {
            return quantity * price;
        }
    }
}
