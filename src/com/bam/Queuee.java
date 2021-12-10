package com.bam;

import rzp.generics.queue.Queue;
import rzp.generics.queue.QueueException;
import rzp.generics.queue.QueueExtra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Queuee<T extends Comparable<T>> implements Queue<T>, QueueExtra<T> {

    private final List<T> data = new ArrayList<>();
    private int maxSize = -1;

    @Override
    public void init(int maxSize) throws QueueException {

        if (maxSize != -1) throw new QueueException("Очередь уже инициализирована");
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {

        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return data.size() == maxSize;
    }

    @Override
    public int size() {

         return data.size();

    }

    @Override
    public boolean contains(T item) {

        return data.contains(item);
    }

    @Override
    public T peek() throws QueueException {
        if (isEmpty()) throw new QueueException("Очередь пуста!");
        return data.get(0);
    }

    @Override
    public T poll() throws QueueException {
        if (isEmpty()) throw new QueueException("Очередь пуста!");
        return data.remove(0);
    }

    @Override
    public void offer(T item) throws QueueException {

        if (isFull()) throw  new QueueException("Очередь переполнена!");
        data.add(item);
    }

    public T getMin()
    {
        T min = data.get(0);

        for (T item: data)
        {
            if (item.compareTo(min) < 0 )
            {
                min = item;
            }
        }

        return min;
    }

    public T getMax()
    {
        T max = data.get(0);

        for (T item: data)
        {
            if (item.compareTo(max) > 0 )
            {
                max = item;
            }
        }

        return max;
    }


    @Override
    public void offer(T[] items) throws QueueException, IllegalStateException {

        for (T item : items)
        {
            offer(item);
        }
    }
}
