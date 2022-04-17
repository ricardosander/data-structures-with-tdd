package io.github.ricardosander.datastructures;

class MyVector {

    private int size;
    private String[] elements;

    MyVector() {
        this(100);
    }

    MyVector(int initialSize) {
        size = 0;
        elements = new String[initialSize];
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return size;
    }

    void add(String element) {
        add(element, this.size);
    }

    void add(String element, int index) {
        if (index == this.size()) {
            addAtEnd(element);
            return;
        }
        addAtPosition(element, index);
    }

    String get(int index) {
        if (isValidIndex(index)) {
            throw createInvalidIndexException();
        }
        return this.elements[index];
    }

    boolean contains(String element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    String remove(int index) {
        String element = this.get(index);
        copyToTheLeftFrom(index);
        this.size--;
        return element;
    }

    private void ensuresSize() {
        if (isFull()) {
            resize();
        }
    }

    private boolean isFull() {
        return this.size() >= this.elements.length;
    }

    private void resize() {
        var newArray = new String[this.size() * 2];
        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
    }

    private boolean isValidIndex(int index) {
        return index >= size;
    }

    private IllegalArgumentException createInvalidIndexException() {
        return new IllegalArgumentException("Invalid position given");
    }

    private void addAtEnd(String element) {
        ensuresSize();
        this.elements[size++] = element;
    }

    private void copyToTheRightFrom(int index) {
        for (int i = this.size() - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private void copyToTheLeftFrom(int index) {
        for (int i = index; i < this.size(); i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void addAtPosition(String element, int index) {
        copyToTheRightFrom(index);
        this.elements[index] = element;
        size++;
    }
}
