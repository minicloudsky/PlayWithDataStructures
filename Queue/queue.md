## 数组队列的复杂度
ArrayQueue<E>
- void enqueue(E)  O(1)
- E dequeue()     O(n)
- int getCapacity() O(1)
- int getSize()    O(1)
- E getFront()     O(1)
- boolean isEmpty() O(1)
## 循环队列的复杂度分析
### LoopQueue<E>
- void enqueue(E) O(1) 均摊复杂度
