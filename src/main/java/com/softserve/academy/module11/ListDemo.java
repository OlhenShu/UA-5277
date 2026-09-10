package com.softserve.academy.module11;

import java.util.*;

/**
 * This class demonstrates the usage of List interface and its implementations.
 * And demonstrates all the main methods of List interface.
 */
public class ListDemo {
    public static void main(String[] args) {
        // 1. Створення списку
        List<String> list = new ArrayList<>();

        // 2. Додавання елементів (add, addAll)
        System.out.println("--- 1. Додавання елементів ---");
        list.add("Apple");              // add(E e) - додавання в кінець
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        System.out.println("Початковий список: " + list);

        list.add(2, "Blueberry");       // add(int index, E element) - вставка за індексом
        System.out.println("Після add(2, 'Blueberry'): " + list);

        List<String> additionalFruits = List.of("Elderberry", "Fig");
        list.addAll(additionalFruits);          // addAll(Collection c) - додавання колекції в кінець
        System.out.println("Після addAll(additionalFruits): " + list);

        list.addAll(1, List.of("Apricot", "Avocado")); // addAll(int index, Collection c) - вставка колекції за індексом
        System.out.println("Після addAll(1, ['Apricot', 'Avocado']): " + list);

        // 3. Отримання елементів та розмір (get, size, isEmpty, getFirst, getLast)
        System.out.println("\n--- 2. Отримання елементів та розмір ---");
        System.out.println("Розмір списку (size()): " + list.size());
        System.out.println("Чи порожній список (isEmpty()): " + list.isEmpty());
        System.out.println("Елемент за індексом 0 (get(0)): " + list.get(0));
        System.out.println("Елемент за індексом 4 (get(4)): " + list.get(4));
        System.out.println("Перший елемент (getFirst()): " + list.getFirst());
        System.out.println("Останній елемент (getLast()): " + list.getLast());

        // 4. Заміна елементів (set, replaceAll)
        System.out.println("\n--- 3. Заміна елементів ---");
        String previous = list.set(0, "Green Apple"); // set(int index, E element) - повертає старе значення
        System.out.println("Замінено елемент: " + previous + " -> Green Apple");
        System.out.println("Список після set(0, 'Green Apple'): " + list);

        list.replaceAll(fruit -> fruit.toUpperCase()); // replaceAll(UnaryOperator operator)
        System.out.println("Після replaceAll (у верхній регістр): " + list);

        // 5. Пошук та перевірка наявності (contains, containsAll, indexOf, lastIndexOf)
        System.out.println("\n--- 4. Пошук та перевірка наявності ---");
        list.add("BANANA"); // додамо дублікат для демонстрації lastIndexOf
        System.out.println("Поточний список: " + list);
        System.out.println("Містить 'BANANA' (contains): " + list.contains("BANANA"));
        System.out.println("Містить 'ORANGE' (contains): " + list.contains("ORANGE"));
        System.out.println("Містить всі ['FIG', 'DATE'] (containsAll): " + list.containsAll(List.of("FIG", "DATE")));
        System.out.println("Перший індекс 'BANANA' (indexOf): " + list.indexOf("BANANA"));
        System.out.println("Останній індекс 'BANANA' (lastIndexOf): " + list.lastIndexOf("BANANA"));

        // 6. Сортування (sort)
        System.out.println("\n--- 5. Сортування ---");
        list.sort(Comparator.naturalOrder()); // sort(Comparator c)
        System.out.println("Після сортування в алфавітному порядку: " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("Після сортування у зворотному порядку: " + list);

        // 7. Підсписок (subList)
        System.out.println("\n--- 6. Підсписок (subList) ---");
        List<String> subList = list.subList(1, 4); // [fromIndex, toIndex)
        System.out.println("Підсписок list.subList(1, 4): " + subList);

        // 8. Видалення елементів (remove, removeAll, retainAll, removeIf)
        System.out.println("\n--- 7. Видалення елементів ---");
        String removedByIndex = list.removeFirst(); // remove(int index)
        System.out.println("Видалено за індексом 0: " + removedByIndex);
        System.out.println("Список після видалення за індексом: " + list);

        boolean isRemoved = list.remove("BANANA"); // remove(Object o) - видаляє перше входження
        System.out.println("Видалено 'BANANA' за значенням: " + isRemoved);
        System.out.println("Список після remove('BANANA'): " + list);

        list.removeIf(item -> item.startsWith("A")); // removeIf(Predicate filter)
        System.out.println("Після removeIf (видалення слів на 'A'): " + list);

        list.removeAll(List.of("FIG", "DATE")); // removeAll(Collection c)
        System.out.println("Після removeAll(['FIG', 'DATE']): " + list);

        List<String> toRetain = List.of("CHERRY", "BLUEBERRY", "NON_EXISTING");
        list.retainAll(toRetain); // retainAll(Collection c) - залишає тільки спільні елементи
        System.out.println("Після retainAll(['CHERRY', 'BLUEBERRY', 'NON_EXISTING']): " + list);

        // 9. Ітерація (for-each, Iterator, ListIterator)
        System.out.println("\n--- 8. Ітерація та обхід ---");
        System.out.print("Обхід через forEach: ");
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();

        System.out.print("Обхід через Iterator: ");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("Обхід вперед і назад через ListIterator:");
        ListIterator<String> listIterator = list.listIterator();
        System.out.print("  Вперед: ");
        while (listIterator.hasNext()) {
            System.out.print("[" + listIterator.nextIndex() + "]=" + listIterator.next() + " ");
        }
        System.out.println();

        System.out.print("  Назад: ");
        while (listIterator.hasPrevious()) {
            System.out.print("[" + listIterator.previousIndex() + "]=" + listIterator.previous() + " ");
        }
        System.out.println();

        // 10. Конвертація в масив (toArray)
        System.out.println("\n--- 9. Конвертація в масив ---");
        Object[] objectArray = list.toArray();
        System.out.println("Масив Object[]: " + Arrays.toString(objectArray));

        String[] stringArray = list.toArray(new String[0]);
        System.out.println("Типізований масив String[]: " + Arrays.toString(stringArray));

        // 11. Очищення списку (clear)
        System.out.println("\n--- 10. Очищення списку ---");
        list.clear();
        System.out.println("Після clear(): " + list);
        System.out.println("Чи порожній список (isEmpty()): " + list.isEmpty());
    }
}
