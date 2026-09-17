package com.softserve.academy.module13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Демонстрація регулярних виразів (java.util.regex) на прикладах правил валідації.
 * <p>
 * <b>Шпаргалка по метасимволах:</b>
 * <pre>
 *   .      будь-який символ (крім перенесення рядка)
 *   \d \D  цифра / НЕ цифра            \w \W  літера, цифра або _ / навпаки
 *   \s \S  пробільний символ / навпаки  \b     межа слова
 *   [abc]  будь-який із символів        [^abc] будь-який, КРІМ перелічених
 *   [a-z]  діапазон символів            a|b    альтернатива (або a, або b)
 *   ^ $    початок / кінець рядка       (...)  група із захопленням
 *
 *   Квантифікатори:  *  (0+)   +  (1+)   ?  (0 або 1)
 *                    {n} (рівно n)   {n,} (n і більше)   {n,m} (від n до m)
 *   Жадібні за замовчуванням; додавання '?' робить їх лінивими: +? *? {n,m}?
 *
 *   (?=...) позитивний lookahead — «далі має бути», але сам текст НЕ споживається
 *   (?!...) негативний lookahead — «далі НЕ має бути»
 *   (?:...) група БЕЗ захоплення (тільки для групування)
 *   (?&lt;name&gt;...) іменована група
 * </pre>
 * <b>Важливо:</b> у Java-рядку зворотний слеш подвоюється:
 * регулярний вираз {@code \d{3}} у коді записується як {@code "\\d{3}"}.
 */
public class RegexValidationExample {

    // Спрощена перевірка email. Повний стандарт RFC 5322 описати регуляркою нереально,
    // тому на практиці беруть «достатньо строгий» вираз + підтвердження листом.
    private static final Pattern EMAIL =
            Pattern.compile("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$");
    // Український номер: +380XXXXXXXXX або 0XXXXXXXXX.
    private static final Pattern PHONE_STRICT =
            Pattern.compile("^(\\+380|0)\\d{9}$");

    /* ==================== 2. Правила валідації ==================== */
    // Той самий номер, але з дозволеними роздільниками: +38 (067) 123-45-67.
    //s- означає пробіл або дефіс, \s — будь-який пробільний символ (пробіл, табуляція, перенос рядка).
    private static final Pattern PHONE_LOOSE =
            Pattern.compile("^\\+?38[\\s-]?\\(?0\\d{2}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$");
    // Пароль: мінімум 8 символів, є мала й велика літери, цифра і спецсимвол.
    // Кожен (?=...) — незалежна перевірка «десь далі є потрібний символ»;
    // саме так кілька умов поєднуються в одному виразі.
    private static final Pattern PASSWORD = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9])\\S{8,}$");
    // Логін: починається з літери, далі літери/цифри/підкреслення, всього 3–16 символів.
    private static final Pattern LOGIN =
            Pattern.compile("^[A-Za-z][A-Za-z0-9_]{2,15}$");
    // IPv4: чотири октети 0–255. Діапазон чисел регуляркою задається переліком варіантів.
    private static final Pattern IPV4 = Pattern.compile(
            "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
    // Дата у форматі dd.MM.yyyy — перевіряється лише ФОРМАТ (див. коментар нижче).
    private static final Pattern DATE =
            Pattern.compile("^(0[1-9]|[12]\\d|3[01])\\.(0[1-9]|1[0-2])\\.(19|20)\\d{2}$");
    private static final Pattern POSTAL_CODE = Pattern.compile("^\\d{5}$");          // індекс
    private static final Pattern EDRPOU = Pattern.compile("^\\d{8}$");               // ЄДРПОУ
    private static final Pattern CARD = Pattern.compile("^\\d{4}([ -]?\\d{4}){3}$"); // картка
    private static final Pattern HEX_COLOR = Pattern.compile("^#([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$");
    private static final Pattern URL = Pattern.compile("^https?://[\\w.-]+(:\\d{1,5})?(/\\S*)?$");
    /**
     * Той самий email, але без ^ та $ — щоб шукати входження всередині тексту.
     */
    private static final Pattern EMAIL_IN_TEXT = Pattern.compile("[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+");

    public static void main(String[] args) {
        demonstrateBasics();
        demonstrateValidationRules();
        demonstrateGroups();
        demonstrateReplacement();
        demonstrateSplitAndSearch();
        demonstrateFlags();
        demonstratePitfalls();
    }

    /* ==================== 1. Основи: Pattern і Matcher ==================== */
    private static void demonstrateBasics() {
        printHeader("1. Основи: Pattern і Matcher");

        // Найпростіший спосіб — String.matches(). Компілює вираз при КОЖНОМУ виклику,
        // тому підходить для разових перевірок.
        System.out.println("\"abc123\".matches(\"[a-z]+\\\\d+\") = " + "abc123".matches("[a-z]+\\d+"));

        // Якщо вираз використовується багато разів — компілюємо його один раз
        // і зберігаємо у static final полі. Pattern потокобезпечний.
        Pattern pattern = Pattern.compile("[a-z]+\\d+");

        // Matcher — одноразовий об'єкт, прив'язаний до конкретного тексту. НЕ потокобезпечний.
        Matcher matcher = pattern.matcher("abc123");

        // matches() — чи відповідає виразу ВЕСЬ рядок цілком.
        System.out.println("matches() = " + matcher.matches()); // true

        // find() — чи є ДЕСЬ у тексті фрагмент, що відповідає виразу.
        System.out.println("find() у \"...abc123...\" = "
                + pattern.matcher("текст abc123 далі").find()); // true
        System.out.println("matches() у \"...abc123...\" = "
                + pattern.matcher("текст abc123 далі").matches()); // false — є зайвий текст

        // lookingAt() — відповідність лише на ПОЧАТКУ тексту.
        System.out.println("lookingAt() = " + pattern.matcher("abc123 далі").lookingAt()); // true

        // asMatchPredicate() (Java 11) — готовий Predicate, зручно для фільтрації колекцій.
        Predicate<String> isCode = pattern.asMatchPredicate();
        System.out.println("Відфільтровані: "
                + List.of("abc123", "ABC", "x9").stream().filter(isCode).toList());
    }

    private static void demonstrateValidationRules() {
        printHeader("2. Правила валідації");

        check("Email", EMAIL, "student@softserve.com", "ivan.petrenko+work@ex.co.ua", "no-at-sign.com", "a@b");
        check("Телефон (строго)", PHONE_STRICT, "+380671234567", "0671234567", "067123456");
        check("Телефон (з роздільниками)", PHONE_LOOSE, "+38 (067) 123-45-67", "38-067-123-45-67", "12345");
        check("Пароль", PASSWORD, "Qwerty1!", "qwerty123", "Qwerty1", "Q1!aaaaa");
        check("Логін", LOGIN, "ivan_95", "Ol", "1ivan", "very_long_login_name_here");
        check("IPv4", IPV4, "192.168.0.1", "255.255.255.255", "256.1.1.1", "10.0.1");
        check("Дата dd.MM.yyyy", DATE, "17.09.2026", "31.02.2026", "1.9.2026");
        check("Поштовий індекс", POSTAL_CODE, "79000", "7900");
        check("ЄДРПОУ", EDRPOU, "12345678", "1234567");
        check("Номер картки", CARD, "1234 5678 9012 3456", "1234-5678-9012-3456", "1234567890123456", "1234 5678");
        check("HEX-колір", HEX_COLOR, "#fff", "#A1B2C3", "#12345");
        check("URL", URL, "https://softserve.academy/course?id=5", "ftp://example.com");

        // ВАЖЛИВО: регулярка перевіряє лише форму запису, а не реальність значення.
        // "31.02.2026" за формою коректна, але такої дати не існує —
        // для справжньої перевірки потрібен парсинг.
        System.out.println("\n31.02.2026 відповідає шаблону: " + DATE.matcher("31.02.2026").matches());
        System.out.println("31.02.2026 є реальною датою: " + isRealDate("31.02.2026"));
        System.out.println("17.09.2026 є реальною датою: " + isRealDate("17.09.2026"));
    }

    /**
     * Двоетапна валідація: спершу формат регуляркою, потім реальність значення.
     */
    private static boolean isRealDate(String value) {
        if (!DATE.matcher(value).matches()) {
            return false;
        }
        try {
            LocalDate.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /* ==================== 3. Групи та витяг даних ==================== */
    private static void demonstrateGroups() {
        printHeader("3. Групи: витягуємо дані з тексту");

        // Нумеровані групи: group(0) — весь збіг, далі групи за порядком дужок.
        Matcher date = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})").matcher("Дедлайн: 17.09.2026");
        if (date.find()) {
            System.out.println("group(0) = " + date.group(0)); // 17.09.2026
            System.out.println("день = " + date.group(1) + ", місяць = " + date.group(2)
                    + ", рік = " + date.group(3));
            System.out.println("позиція збігу: " + date.start() + ".." + date.end());
        }

        // Іменовані групи (?<name>...) — читабельніше за номери й стійкіше до правок виразу.
        Pattern logPattern = Pattern.compile(
                "^(?<date>\\d{4}-\\d{2}-\\d{2}) (?<time>\\d{2}:\\d{2}:\\d{2}) "
                        + "(?<level>[A-Z]+) +(?<message>.+)$");

        List<String> logLines = List.of(
                "2026-09-17 10:15:03 ERROR  Не вдалося підключитися до БД",
                "2026-09-17 10:15:04 INFO   Повторна спроба через 5 с",
                "зіпсований рядок без формату"
        );

        for (String line : logLines) {
            Matcher m = logPattern.matcher(line);
            if (m.matches()) {
                System.out.printf("[%s] %s о %s: %s%n",
                        m.group("level"), m.group("date"), m.group("time"), m.group("message"));
            } else {
                System.out.println("Не розпізнано: " + line);
            }
        }

        // (?:...) — група без захоплення: групує варіанти, але не створює зайвий номер.
        Matcher protocolLess = Pattern.compile("(?:https?://)?(?<host>[\\w.-]+)")
                .matcher("https://softserve.academy");
        if (protocolLess.find()) {
            System.out.println("Хост: " + protocolLess.group("host"));
        }
    }

    /* ==================== 4. Заміна тексту ==================== */
    private static void demonstrateReplacement() {
        printHeader("4. Заміна за регулярним виразом");

        // replaceAll() — замінює ВСІ входження, replaceFirst() — лише перше.
        System.out.println("a1b2c3 -> " + "a1b2c3".replaceAll("\\d", "#"));
        System.out.println("a1b2c3 -> " + "a1b2c3".replaceFirst("\\d", "#"));

        // Нормалізація пробілів: будь-яка послідовність пробільних символів -> один пробіл.
        String messy = "  Забагато\t\tпробілів   і\n переносів  ";
        System.out.println("[" + messy.replaceAll("\\s+", " ").strip() + "]");

        // У рядку заміни $1, $2 — посилання на групи захоплення.
        System.out.println("Петренко Іван -> "
                + "Петренко Іван".replaceAll("(\\S+)\\s+(\\S+)", "$2 $1"));

        // Маскування картки: лишаємо останні 4 цифри.
        // (?=...) гарантує, що попереду ще рівно 4 цифри в кінці рядка.
        System.out.println("Картка: " + "1234567890123456".replaceAll("\\d(?=\\d{4})", "*"));

        // Форматування номера телефону через групи.
        System.out.println("Телефон: "
                + "0671234567".replaceAll("^0(\\d{2})(\\d{3})(\\d{2})(\\d{2})$", "+38 ($1) $2-$3-$4"));

        // Коли заміна залежить від самого збігу — використовуємо Matcher.replaceAll
        // з функцією (Java 9) замість ручного циклу appendReplacement/appendTail.
        String prices = "Ціни: 100 грн, 250 грн, 999 грн";
        String doubled = Pattern.compile("\\d+").matcher(prices)
                .replaceAll(match -> String.valueOf(Integer.parseInt(match.group()) * 2));
        System.out.println("Подвоєні ціни: " + doubled);

        // Якщо в тексті заміни є $ або \, їх треба екранувати через quoteReplacement().
        System.out.println("Ціна: " + "COST".replaceAll("COST", Matcher.quoteReplacement("$100")));
    }

    /* ==================== 5. Розбиття та пошук усіх входжень ==================== */
    private static void demonstrateSplitAndSearch() {
        printHeader("5. Розбиття та пошук усіх входжень");

        // split() приймає саме РЕГУЛЯРНИЙ вираз, а не звичайний роздільник.
        String data = "Іван;  Петро ,Ольга;Марія";
        System.out.println(Arrays.toString(data.split("\\s*[;,]\\s*"))); // роздільник ; або , з пробілами

        // Метасимволи в ролі роздільника треба екранувати.
        System.out.println(Arrays.toString("192.168.0.1".split("\\.")));

        // Pattern.quote() перетворює будь-який текст на літерал — корисно,
        // коли роздільник приходить ззовні і може містити метасимволи.
        String userSeparator = "|";
        System.out.println(Arrays.toString("a|b|c".split(Pattern.quote(userSeparator))));

        // Класичний цикл пошуку всіх входжень.
        // УВАГА: \w, \b, \d за замовчуванням працюють ЛИШЕ з ASCII, тому для кирилиці
        // або вказують діапазони явно, або вмикають Pattern.UNICODE_CHARACTER_CLASS.
        Matcher words = Pattern.compile("[А-ЯІЇЄҐ][а-яіїєґ']+")
                .matcher("Приїхали Іван, Ольга та Марія до Львова.");
        System.out.print("Слова з великої літери: ");
        while (words.find()) {
            System.out.print(words.group() + " ");
        }
        System.out.println();

        // results() (Java 9) — той самий обхід, але як Stream.
        List<String> emails = EMAIL_IN_TEXT.matcher("Пишіть на ivan@ex.com або olha@test.org")
                .results()
                .map(MatchResult::group)
                .toList();
        System.out.println("Знайдені email: " + emails);
    }

    /* ==================== 6. Прапорці компіляції ==================== */
    private static void demonstrateFlags() {
        printHeader("6. Прапорці компіляції");

        // CASE_INSENSITIVE — без урахування регістру (для латиниці).
        // UNICODE_CASE додає коректну роботу з кирилицею та іншими алфавітами.
        Pattern ci = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        System.out.println("CASE_INSENSITIVE: " + ci.matcher("JaVa").matches());

        Pattern ciUnicode = Pattern.compile("київ", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        System.out.println("UNICODE_CASE: " + ciUnicode.matcher("КИЇВ").matches());

        String text = """
                ERROR перша проблема
                INFO  все добре
                ERROR друга проблема""";

        // MULTILINE: ^ та $ починають означати початок/кінець КОЖНОГО рядка, а не всього тексту.
        long errors = Pattern.compile("^ERROR.*$", Pattern.MULTILINE).matcher(text).results().count();
        System.out.println("Рядків із ERROR: " + errors); // 2

        // DOTALL: крапка починає збігатися і з перенесенням рядка.
        System.out.println("Без DOTALL: " + Pattern.compile("перша.*друга").matcher(text).find());
        System.out.println("З DOTALL:   " + Pattern.compile("перша.*друга", Pattern.DOTALL).matcher(text).find());

        // Прапорці можна вмикати і всередині самого виразу: (?i) — те саме, що CASE_INSENSITIVE.
        System.out.println("Інлайн (?i): " + "JAVA".matches("(?i)java"));
    }

    /* ==================== 7. Типові пастки ==================== */
    private static void demonstratePitfalls() {
        printHeader("7. Типові пастки");

        String html = "<b>жирний</b> текст";

        // Жадібний квантифікатор бере МАКСИМАЛЬНО довгий фрагмент.
        Matcher greedy = Pattern.compile("<.+>").matcher(html);
        System.out.println("Жадібний <.+>  : " + (greedy.find() ? greedy.group() : "-")); // <b>жирний</b>

        // Лінивий (+?) зупиняється на найкоротшому збігу.
        Matcher lazy = Pattern.compile("<.+?>").matcher(html);
        System.out.println("Лінивий  <.+?> : " + (lazy.find() ? lazy.group() : "-"));     // <b>

        // group() без попереднього успішного find()/matches() кине IllegalStateException.
        Matcher empty = Pattern.compile("\\d+").matcher("без цифр");
        try {
            empty.group();
        } catch (IllegalStateException e) {
            System.out.println("Помилка: " + e.getClass().getSimpleName()
                    + " — спершу треба викликати find() або matches()");
        }

        // Некоректний вираз виявляється тільки під час компіляції — у рантаймі.
        try {
            Pattern.compile("[a-z");
        } catch (java.util.regex.PatternSyntaxException e) {
            System.out.println("Помилка синтаксису: " + e.getDescription());
        }

        // Ще дві поради без запуску коду:
        // 1) Вкладені квантифікатори на кшталт (a+)+$ спричиняють катастрофічний бектрекінг —
        //    на довгому вхідному рядку перевірка може «зависнути» (ReDoS).
        // 2) Pattern.compile() у циклі — марна робота: компілюйте вираз один раз
        //    у static final полі, як зроблено в цьому класі.
        System.out.println("Уникайте вкладених квантифікаторів типу (a+)+ та компіляції в циклі.");
    }

    /* ==================== Допоміжні методи ==================== */

    /**
     * Друкує результат перевірки набору зразків одним правилом.
     */
    private static void check(String ruleName, Pattern pattern, String... samples) {
        System.out.println(ruleName + "  (" + pattern.pattern() + ")");
        for (String sample : samples) {
            boolean valid = pattern.matcher(sample).matches();
            System.out.printf("   %s  %s%n", valid ? "OK   " : "ПОМИЛКА", sample);
        }
    }

    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===\n");
    }
}
