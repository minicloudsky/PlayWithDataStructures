## 数组队列的复杂度
ArrayQueue<E>
- void enqueue(E)  O(1)
- E dequeue()     O(n)
- int getCapacity() O(1)
- int getSize()    O(1)
- E getFront()     O(1)
- boolean isEmpty() O(1)
## 循环队列的复杂度分析
front == tail 队列为空
front = (tail+1) % queue.capacity 队列满
### LoopQueue<E>
- void enqueue(E) O(1) 均摊复杂度
- E dequeue() O(1) 均摊
- E getFront() O(1)
- int getSize() O(1)
- boolean isEmpty() O(1)