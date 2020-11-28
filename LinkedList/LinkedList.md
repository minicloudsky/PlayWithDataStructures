### 链表
#### 链表对比数组
- 数组最好用于索引有语意的情况，scores[2]
- 最大优点: 支持快速查询
- 链表不适合用语索引有语意的情况，不支持随机访问
- 最大优点: 动态
### 链表的时间复杂度分析
-- 添加操作 O(n)
-- addLast(e) O(n)
-- addFirst(e) O(1)
-- add(index,e) O(n/2) = O(n)
-- 删除操作 O(n)
-- removeFirst() O(1)
-- removeLast() O(1)
-- remove(index,e) O(n/2) = O(n)
-- 修改操作 O(n)
-- set(index,e) O(n)
-- 查找操作 O(n)
-- get(index) O(n)
-- contains(e) O(n)
-- find(e) O(n)
-- 如果只对链表头进行操作: O(1)
-- 如果只查链表头的元素: O(1)