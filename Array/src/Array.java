
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取 数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        data[size] = e;
//        size++;
        add(size, e);
    }

    // 在数组头部插入一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第 index 个位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * equals 与 == 区别
     * equals比较引用，== 比较值
     */
    // 查找数组中是否有元素 e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找元素 e 所在位置并返回 e 的下标
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中返回 index 位置元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index innegal .");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 释放引用
        data[size] = null; // loitering objects != memory leak
        // 所用长度为数组总长度1/4时间再缩容为1/2
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素 e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 获取 index 索引位置的元素
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index error");
        }
        return data[index];
    }

    // 设置 index 位置元素为 e
    void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index Error.");
        }
        data[index] = e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(" , ");
            }
        }
        res.append(']');
        return res.toString();
    }

    // 动态数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
