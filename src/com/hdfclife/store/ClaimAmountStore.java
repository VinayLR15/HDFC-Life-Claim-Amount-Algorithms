package com.hdfclife.store;

import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.StoreFullException;

public class ClaimAmountStore {

    private final int[] data;
    private int size;
    private int lastShiftCount;

    public ClaimAmountStore() {
        this(16);
    }

    public ClaimAmountStore(int capacity) {
        if (capacity < 16) {
            capacity = 16;
        }

        this.data = new int[capacity];
        this.size = 0;
        this.lastShiftCount = 0;
    }

    public void add(int amount) {
        if (size == data.length) {
            throw new StoreFullException("Store is full");
        }

        data[size] = amount;
        size++;
    }

    public void insert(int index, int amount) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        if (size == data.length) {
            throw new StoreFullException("Store is full");
        }

        lastShiftCount = 0;

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastShiftCount++;
        }

        data[index] = amount;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    public int getLastShiftCount() {
        return lastShiftCount;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }

        return result;
    }
}