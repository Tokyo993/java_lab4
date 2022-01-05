package com.company;

import java.util.Scanner;

class Polynom {

    // Полином степени n-1:
    private int n;

    // Коэффициенты полинома:
    private double[] a;

    // Определение коэффициентов полинома на основе массива:
    void set(double[] a) {
        this.n = a.length;
        this.a = new double[n];
        int i;
        for (i = 0; i < n; i++)
            this.a[i] = a[i];
    }

    // Определение коэффициентов полинома
    // (аргументы - размер массива и число для заполнения):
    void set(int n, double z) {
        this.n = n;
        this.a = new double[n];
        int i;
        for (i = 0; i < n; i++)
            this.a[i] = z;
    }

    // Определение коэффициентов полинома
    // (аргумент - размер массива, массив заполняется нулями):
    void set(int n) {
        set(n, 0);
    }

    // Вычисление значения полинома в точке:
    double value(double x) {
        double z = 0, q = 1;
        for (int i = 0; i < n; i++) {
            z += a[i] * q;
            q *= x;
        }
        return z;
    }

    // Отображение коэффициентов полинома:
    void show() {
        int i;
        System.out.print("Степень x:\t");
        for (i = 0; i < n - 1; i++) {
            System.out.print(" " + i + "\t");
        }
        System.out.println(" " + (n - 1));
        System.out.print("Коэффициент:\t");
        for (i = 0; i < n - 1; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println(a[n - 1]);
    }

    // Отображение значения полинома в точке:
    void show(double x) {
        System.out.println("Значение аргумента x=" + x);
        System.out.println("Значение полинома P(x)=" + value(x));
    }

    // Производная от полинома:
    Polynom diff() {
        Polynom t = new Polynom(n - 1);
        for (int i = 0; i < n - 1; i++)
            t.a[i] = a[i + 1] * (i + 1);
        return t;
    }

    // Производная от полинома порядка k:
    Polynom diff(int k) {
        if (k >= n) return new Polynom(1);
        if (k > 0) return diff().diff(k - 1);
        else return new Polynom(a);
    }

    // Сумма полиномов:
    Polynom plus(Polynom Q) {
        Polynom t;
        int i;
        if (n >= Q.n) {
            t = new Polynom(a);
            for (i = 0; i < Q.n; i++)
                t.a[i] += Q.a[i];
        } else {
            t = new Polynom(Q.a);
            for (i = 0; i < n; i++)
                t.a[i] += a[i];
        }
        return t;
    }

    // Разность полиномов:
    Polynom minus(Polynom Q) {
        return plus(Q.prod(-1));
    }

    Polynom div(double z) {
        return prod(1 / z);
    }

    // Произведение полинома на число:
    Polynom prod(double z) {
        Polynom t = new Polynom(a);
        for (int i = 0; i < n; i++)
            a[i] *= z;
        return t;
    }

    // Произведение полинома на полином:
    Polynom prod(Polynom Q) {
        int N = n + Q.n - 1;
        Polynom t = new Polynom(N);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Q.n; j++) {
                t.a[i + j] += a[i] * Q.a[j];
            }
        }
        return t;
    }

    // Конструкторы класса:
    Polynom(double[] a) {
        set(a);
    }

    Polynom(int n, double z) {
        set(n, z);
    }

    Polynom(int n) {
        set(n);
    }
}

class LinkedList{
    /*
        ✔public LinkedList() // initialize an empty linked list
        ✔public LinkedList(double value) // initialize the list with value
        ✔public LinkedList(double[] values) // initialize the list with the values from the array
        ✔public LinkedList(LinkedList list) // initialize the list with another list
        ✔public void printList() // print the linked list
        ✔public void append(double value) // add the value to the end of list
        ✔public void prepend(double value) // add the value to the start of the list
        ✔public boolean checkIntegrity() // check if the list can be traversed
        private void insertBefore(Node node, double value) // insert a node before the specified node (private)
        ✔public void add(double value) // add the value to the end of list
        ✔public boolean add(double value, int index) // add the value at the specified index
        ✔public void add(double[] values) // add the array of values to the end of list
        ✔public boolean add(double[] values, int index) add the array of values to the end of list
        ✔public void add(LinkedList list) // add another linked list to the end of list
        ✔public void add(LinkedList list, int index) // add another linked list at specified index
        ✔public double get(int index) // get the value by index
        ✔public int get_index(double value) // get the index of the value in the list
        ✔public LinkedList slice() // get a copy of the list
        ✔public LinkedList slice(int l, int r) // get a part of the copy of the list
        ✔public void remove() // delete the last element in the list
        ✔public void remove(int index) // delete the element at specified index
        ✔public void remove(double element) // delete the specified element from the list
        ✔public void remove(double[] elements) // delete all items from the list specified in the array
        ✔public void remove(LinkedList list) // delete all items from the list specified in another linked list
        ✔public LinkedList getGreaterThan(double value) // get all values than are greater than specified
        ✔public LinkedList getGreaterOrEqualThan(double value) // get all values than are greater than or equal to specified
        ✔public LinkedList getLessOrEqualThan(double value) // get all values than are less than specified
        ✔public LinkedList getLessThan(double value) // get all values than are less than or equal to specified
        ✔public double min() // get the minimum value in the list
        ✔public double max() // get the maximum value in the list
        ✔public LinkedList getPositiveValues() // get all values that are positive
        ✔public LinkedList getNegativeValues() // get all values that are negative
         */

    // An inner class which represents a node of linked list
    class Node {
        // A value list item takes
        private double value;
        // A pointer to the next item, initially null because the next item is not added
        private Node next = null;
        // A private constructor because the node is controlled by parent class only
        private Node(double value){
            this.value = value;
        }
    }
    // A pointer to the first item in the list
    private Node head = null;
    // A pointer to the last item in the list
    private Node tail = null;
    // The length of the list
    public int len = 0;

    /**
     * Add the item to the end of the list
     * @param value a value to be appended
     */
    public void append(double value){
        // Create a new node which will be appended
        Node tail_node = new Node(value);
        // If the list has items add the reference to new node to the tail
        if (this.tail != null)
            this.tail.next = tail_node;
        // Move the tail pointer to new node
        this.tail = tail_node;
        // If the list was empty set the head pointer to this new node
        if (this.head == null) this.head = this.tail;
        // Increment the list length value
        this.len++;
    }

    /**
     * Add the item to the beginning of the list
     * @param value a value to be prepended
     */
    public void prepend(double value){
        // Save the first node
        Node next = this.head;
        // Create a new node and add move the head pointer to it
        this.head = new Node(value);
        // Add the previously first node to the next reference of head pointer
        this.head.next = next;
        // If the list was initially empty move the head pointer to this node
        if (this.tail == null) this.tail = this.head;
        // Increment the list length value
        this.len++;
    }

    /**
     * Print the linked list
     */
    public void printList(){
        // Iterate through list items and print the values unless the list is empty,
        // in that case print the alert
        Node current = this.head;
        if (current == null) System.out.println("The list is empty");
        else {
            System.out.print("[");
            while (current != null){
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

    /**
     * Used for inserting item between linked list items
     * @param node node that follows
     * @param value a value which the preceding item takes
     */
    private void insertBefore(Node node, double value){
        // Create a new node which is going to be inserted
        Node middle_node = new Node(value);
        // Save the preceding note's next reference
        Node next = node.next;
        // Add the created note to the preceding note's next reference
        node.next = middle_node;
        // Add the saved reference to the created node's next reference
        middle_node.next = next;
        // Increment the list length value
        this.len++;
    }

    /**
     * Add the values from another linked list to the end of the list
     * @param list another linked list which values to be added
     */
    public void add(LinkedList list){
        // Iterate through the specified list and append its values to this list
        Node current = list.head;
        while (current != null){
            this.append(current.value);
            current = current.next;
        }
    }

    /**
     * Add the values from another linked list at specified index
     * @param list another linked list which values to be added
     * @param index the position in this list
     * @throws Exception the index might be out of range
     */
    public void add(LinkedList list, int index) throws Exception {
        // Iterate through the specified list and append its values at
        // specified index + the offset for each element
        Node current = list.head;
        int i = 0;
        while (current != null){
            this.add(current.value, index + i);
            current = current.next;
            i++;
        }
    }

    /** Add the value to the end of the list
     * @param value the value to be added
     */
    public void add(double value){
        this.append(value);
    }

    /** Add the values from an array to the end of the list
     * @param values the values to be added
     */
    public void add(double[] values){
        for(double value: values)
            this.append(value);
    }

    /** Adds the values from the array to specified index
     * @param values an array of items to be added
     * @param index a position to add element at
     * @return true if successful
     * @throws Exception the specified index should be in
     * the range of list indices
     */
    public boolean add(double[] values, int index) throws Exception {
        for (int i = 0; i < values.length; i++){
            if (!this.add(values[i], index+i))
                return false;
        }
        return true;
    }

    /**
     * @param value the value to be added
     * @param index a position to add value at
     * @return true if successful
     * @throws Exception the specified index should be in
     * the range of list indices
     */
    public boolean add(double value, int index) throws Exception {
        if (index < 0 || index > this.len){
            throw new Exception("The index is out of range");
        }
        // if the index is zero prepend the value and return
        if (index == 0){
            this.prepend(value);
            return true;
        }
        // Iterate through list and if the current index is the same as
        // the specified one -1 do the following:
        Node current = this.head;
        int i = 0;
        while (current != null){
            if (i == index-1) {
                // append a value if the next item doesn't exist
                if (current.next == null)
                    this.append(value);
                // insert a value before the next item and return
                else
                    this.insertBefore(current, value);
                return true;
            }
            current = current.next;
            i++;
        }
        // return false otherwise
        return false;
    }

    /** Check is the list is traversable
     * @return true if the list is traversable
     */
    public boolean checkIntegrity(){
        // Iterate through the list and return true if the last item
        // is accessible
        Node current = this.head;
        while (current != null){
            if (current == this.tail)
                return true;
            current = current.next;
        }
        return false;
    }

    /** Find the minimal value among the values in the list
     * @return the minimal value found in the list
     * @throws Exception the list should not be empty
     */
    public double min() throws Exception{
        if (this.head == null)
            throw new Exception("The list is empty");
        double min = this.head.value;
        // Iterate through the list and compare values
        Node current = this.head.next;
        while (current != null){
            if (current.value < min){
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }

    /** Find the maximal value among the values in the list
     * @return the maximal value found in the list
     * @throws Exception the list should not be empty
     */
    public double max() throws Exception{
        if (this.head == null)
            throw new Exception("The list is empty");
        double max = this.head.value;
        // Iterate through the list and compare values
        Node current = this.head.next;
        while (current != null){
            if (current.value > max){
                max = current.value;
            }
            current = current.next;
        }
        return max;
    }

    /** Get the position of an item in the list
     * @param index the position of an item in the list
     * @return the value at specified position
     * @throws Exception the index should be in the range of list's indices
     */
    public double get(int index) throws Exception{
        if (index < 0 || index >= this.len)
            throw new Exception("The index is out of range");
        int i = 0;
        // Iterate through the list and return the value of an item unless the
        // index is out of range, or the list is empty
        Node current = this.head;
        while(current != null){
            if (i == index)
                break;
            current = current.next;
            i++;
        }
        return current.value;
    }

    /** Get the index of the specified value
     * @param value the value to be looked for
     * @return the index of the value
     */
    public int get_index(double value){
        Node current = this.head;
        // If the list is empty return -1
        if (current == null)
            return -1;
        int i = 0;
        // Iterate through the list and
        // If the value is found return the index,
        // Otherwise return -1
        while (current != null){
            if (current.value == value)
                return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    /** Remove the element at specified position in the list
     * @param index the position of the item to be removed
     * @throws Exception the index should be in the range of list indices
     */
    public void remove(int index) throws Exception{
        if (index < 0 || index >= this.len) {
            throw new Exception("Index is out of range");
        }
        // If the index is 0 do the following
        if (index == 0){
            // If the list has 0 or 1 value null the pointers, list length
            // and return
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
                this.len = 0;
                return;
            }
            // Otherwise, move the head pointer to the next item and
            // null the former head pointer, decrement list length and return
            Node head = this.head;
            this.head = head.next;
            head = null;
            this.len -= 1;
            return;
        }
        // Iterate through the list until the element
        // at specified position - 1 found
        Node current = this.head;
        int i = 0;
        while (i < index - 1){
            current = current.next;
            i++;
        }
        // Save the target element
        Node middle = current.next;
        // If the target element is the last one move
        // the tail pointer to the previous one and null the target element
        if (middle == this.tail){
            this.tail = current;
            current.next = null;
        // Otherwise, change the current element's next
        // reference to the item after the target one
        } else {
            current.next = middle.next;
        }
        // Null the target item and decrement the list length
        middle = null;
        this.len -= 1;
    }

    /** Remove the last item in the list
     * @throws Exception the list should not be empty
     */
    public void remove() throws Exception{
        this.remove(this.len -1);
    }

    /** Remove the element from the list
     * @param element the element to be deleted
     * @throws Exception the list should contain the specified element
     */
    public void remove(double element) throws Exception{
        // Find the position of the element in the list and
        // remove it if it's found
        int index = this.get_index(element);
        if (index == -1) {
            throw new Exception("The element is not in the list");
        }
        this.remove(index);
    }

    /** Remove the elements of the specified array from the list
     * @param elements elements to be deleted
     * @throws Exception the list should contain the specified elements
     */
    public void remove(double[] elements) throws Exception{
        // Iterate through the array and for each
        // element do the following:
        for (double element: elements){
            // Find the index of and element
            int index = this.get_index(element);
            // If it's found remove it
            if (index == -1){
                continue;
            }
            this.remove(index);
        }
    }

    /** Remove the elements of the specified linked list from this list
     * @param list elements to be deleted
     * @throws Exception the list should contain the specified elements
     */
    public void remove(LinkedList list) throws Exception{
        // Iterate through the specified list and
        // for each item do the following:
        Node current = list.head;
        while(current != null){
            // Find the index of and element
            int index = this.get_index(current.value);
            // If it's found remove it
            if (index != -1){
                this.remove(index);
            }
            current = current.next;
        }
    }

    /** Get a copy of the list which included only
     * the values from the range of indices
     * @param l the left index
     * @param r the right index
     * @return a copy of the list which included only
     * the values from the range of indices
     * @throws Exception
     */
    public LinkedList slice(int l, int r) throws Exception{
        if(r <= l){
            throw new Exception("Right index should be greater than than left one");
        }
        if (l < 0){
            throw new Exception("Left index is out of range");
        }
        if (r > this.len){
            throw new Exception("Right index is out of range");
        }
        // Initialize an empty linked list
        LinkedList slice = new LinkedList();
        // Iterate through the list until left index is reached
        Node current = this.head;
        int i = 0;
        while (i != l){
            current = current.next;
            i++;
        }
        // Append the list values to the new list until
        // the right index is reached
        while (i < r){
            slice.append(current.value);
            current = current.next;
            i++;
        }
        return slice;
    };

    /** Get the copy of this list
     * @return the copy of this list
     * @throws Exception
     */
    public LinkedList slice() throws Exception{
        return this.slice(0, len);
    }

    /** Get the values that are greater than the specified one
     * @param value the value to compare list items
     * @return a copy of the list which contains the values
     * that satisfy the condition
     */
    public LinkedList getGreaterThan(double value){
        // Iterate through the list and append the values
        // that satisfy the condition
        Node current = this.head;
        LinkedList list = new LinkedList();
        while (current != null){
            if (current.value > value){
                list.append(current.value);
            }
            current = current.next;
        }
        return list;
    }
    /** Get the values that are greater than or equal to the specified one
     * @param value the value to compare list items
     * @return a copy of the list which contains the values
     * that satisfy the condition
     */
    public LinkedList getGreaterOrEqualThan(double value){
        // Iterate through the list and append the values
        // that satisfy the condition
        Node current = this.head;
        LinkedList list = new LinkedList();
        while (current != null){
            if (current.value >= value){
                list.append(current.value);
            }
            current = current.next;
        }
        return list;
    }
    /** Get the values that are less than or equal to the specified one
     * @param value the value to compare list items
     * @return a copy of the list which contains the values
     * that satisfy the condition
     */
    public LinkedList getLessOrEqualThan(double value){
        // Iterate through the list and append the values
        // that satisfy the condition
        Node current = this.head;
        LinkedList list = new LinkedList();
        while (current != null){
            if (current.value <= value){
                list.append(current.value);
            }
            current = current.next;
        }
        return list;
    }
    /** Get the values that are less than the specified one
     * @param value the value to compare list items
     * @return a copy of the list which contains the values
     * that satisfy the condition
     */
    public LinkedList getLessThan(double value){
        // Iterate through the list and append the values
        // that satisfy the condition
        Node current = this.head;
        LinkedList list = new LinkedList();
        while (current != null){
            if (current.value < value){
                list.append(current.value);
            }
            current = current.next;
        }
        return list;
    }

    public LinkedList getPositiveValues(){
        return this.getGreaterThan(0);
    }

    public LinkedList getNegativeValues(){
        return this.getLessThan(0);
    }

    // Empty class constructor
    public LinkedList(){}

    // Class constructor
    public LinkedList(double value){
        this.append(value);
    }

    // Class constructor
    public LinkedList(double[] values) {
        for (int i = 0; i < values.length; i++) {
            this.append(values[i]);
        }
    }

    // Class constructor
    public LinkedList(LinkedList list){
        this.add(list);
    }

}

public class Main {
    static void task1(){
        // Коэффициенты для полинома:
        System.out.print("Количесво коэффициентов: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double [] coefs= new double[n];
        System.out.print("Ведите коэффициенты: ");
        for (int i = 0; i < n; i++){
            double coef = scan.nextDouble();
            coefs[i] = coef;
        }
        scan.close();
        // Создание полинома:
        Polynom P = new Polynom(coefs);

        System.out.println("\tКоэффициенты исходного полинома:");
        // Коэффициенты полинома:
        P.show();

        System.out.println("\tЗначение полинома в точке:");
        // Значение полинома для единичного аргумента:
        P.show(1);

        System.out.println("\tВторая производная:");
        // Вычисление второй производной для полинома:
        Polynom Q = P.diff(2);
        // Результат вычисления производной (коэффициенты):
        Q.show();

        System.out.println("\tСумма полиномов:");
        // Сумма полиномов (результат):
        Q.plus(P).show();

        System.out.println("\tРазность полиномов:");
        // Сумма полиномов (результат):
        Q.minus(P).show();

        System.out.println("\tПроизведение полиномов:");
        // Произведение полиномов (результат):
        Q.prod(P).show();

        System.out.println("\tПроизведение полинома на число 5:");
        // Произведение полиномов (результат):
        Q.prod(5).show();

        System.out.println("\tДеление полинома на число 2:");
        // Произведение полиномов (результат):
        Q.div(2).show();
    }
    static void task2(){
        try {
            LinkedList list1 = new LinkedList(); // empty list
            LinkedList list2 = new LinkedList(1); // initialized by value
            LinkedList list3 = new LinkedList(new double[]{10, 20, 30}); // initialized by array of values
            LinkedList list4 = new LinkedList(list3); // initialized by another list

            System.out.println("Created linked lists: ");
            list1.printList();
            list2.printList();
            list3.printList();
            list4.printList();

            System.out.println("\nAdded values with 'append', 'prepend', checked integrity: ");
            list1.append(50);
            list2.append(60);
            list3.prepend(70);
            list4.prepend(80);

            System.out.println("list1 integrity:" + (list1.checkIntegrity() ? "yes": "no"));
            list1.printList();
            System.out.println("list2 integrity:" + (list2.checkIntegrity() ? "yes": "no"));
            list2.printList();
            System.out.println("list3 integrity:" + (list3.checkIntegrity() ? "yes": "no"));
            list3.printList();
            System.out.println("list4 integrity:" + (list4.checkIntegrity() ? "yes": "no"));
            list4.printList();

            list1.add(100.0); // add value to the end of list
            list1.add(100.0, 0); // add value at index

            list2.add(new double[]{100, 200, 300}); // add array of values to the end of list
            list2.add(new double[]{100, 200, 300}, 1); // add array of values at index

            list3.add(list1); // add another list to the end of list

            list4.add(list1, 0); // add another list at index

            System.out.println("\nLists after adding values with 'add'");
            System.out.println("list1 integrity:" + (list1.checkIntegrity() ? "yes": "no"));
            list1.printList();
            System.out.println("list2 integrity:" + (list2.checkIntegrity() ? "yes": "no"));
            list2.printList();
            System.out.println("list3 integrity:" + (list3.checkIntegrity() ? "yes": "no"));
            list3.printList();
            System.out.println("list4 integrity:" + (list4.checkIntegrity() ? "yes": "no"));
            list4.printList();

            System.out.println("\nGet index of an element (80.0 in list4): " +
                    list4.get_index(80.0));
            System.out.println("Get element by index (3 in list4): "+
                    list4.get(3));

            LinkedList list5 = list4.slice();
            System.out.println("\nList 5 (a copy of list 4 with 'slice'): ");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();
            System.out.println("list4 integrity:" + (list4.checkIntegrity() ? "yes": "no"));
            list4.printList();

            System.out.println("\nA slice of list 5[3:5]:");
            list5.slice(3,5).printList();
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            System.out.println("Whole list 5:");
            list5.printList();

            list5.remove();
            System.out.println("\nRemoved last element of list 5");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();

            list5.remove(0);
            System.out.println("\nRemoved element of index 0 of list 5");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();

            list5.remove(100.0);
            System.out.println("\nRemoved element 100.0 of list 5");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();

            list5.remove(new double[]{50, 10});
            System.out.println("\nRemoved an array of elements {50, 10} of list 5");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();

            System.out.println("\nThe list 4:");
            list4.printList();

            list4.remove(list5);
            System.out.println("Removed elements of list 5 out of list 4");
            System.out.println("list5 integrity:" + (list5.checkIntegrity() ? "yes": "no"));
            list5.printList();
            System.out.println("list4 integrity:" + (list4.checkIntegrity() ? "yes": "no"));
            list4.printList();

            System.out.println("\nThe list 2:");
            list2.printList();

            System.out.println("Elements of list 2 greater than 100:");
            list2.getGreaterThan(100).printList();
            System.out.println("Elements of list 2 greater than or equal to 100:");
            list2.getGreaterOrEqualThan(100).printList();
            System.out.println("Elements of list 2 less than 100:");
            list2.getLessThan(100).printList();
            System.out.println("Elements of list 2 less than or equal to 100:");
            list2.getLessOrEqualThan(100).printList();

            System.out.println("\nThe list 2:");
            list2.printList();

            System.out.println("The max value in list 2: " + list2.max());
            System.out.println("The min value in list 2: " + list2.min());

            list2.append(-1);
            list2.prepend(-1);

            System.out.println("\nAdded -1 to both sides of list 2");
            list2.printList();

            System.out.println("\nNegative values in list2: ");
            list2.getNegativeValues().printList();
            System.out.println("Positive values in list2: ");
            list2.getPositiveValues().printList();
        } catch (Exception e){
            e.printStackTrace();
            return;
        }

    }

    public static void main(String[] args) {
        task1();//Вызов задания 1
        task2();//Вызов задания 2
    }
}
