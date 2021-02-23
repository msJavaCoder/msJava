package com.imood.msjava.数据结构;

/**
 * @author msJava
 * @Description: 数组的基本操作
 */
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组指定位置插入元素
     *
     * @param index   要插入的数据位置
     * @param element 要插入的元素
     */
    public void intser(int index, int element) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素的范围！");
        }

        if (size >= array.length) {
            resize();
        }

        // 元素向后移动一个位置
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        // 维护一下最新的元素数量
        size++;
    }

    /**
     * 数组 扩容  扩容后的数量是之前的二倍
     */
    public void resize() {
        // 创建一个新数组
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 删除数组指定位置的元素
     *
     * @param index 即将删除的元素的下标
     * @return 删除的元素
     * @throws Exception
     */
    public int delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素的范围！");
        }
        // 即将要删除的元素
        int deleteElement = array[index];
        // 将删除的元素后面的元素向前移动一个位置
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        return deleteElement;
    }

}
