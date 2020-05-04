# List

List<E>是一种有序链表

* 方法：
- void add(E e) 在末尾添加一个元素
- void add(int index, E e) 在指定索引添加一个元素
- int remove(int index) 删除指定索引的元素
- int remove(Object e) 删除某个元素
- E get(int index) 获取指定索引的元素
- int size() 包含元素的个数

### 两种结构
- 数组也是有序结构，但是大小固定，且删除元素时需要移动后续元素

![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_20-54-21.png)


- ArrayList<E> 内部使用数组存储所有元素

当ArrayList空间被使用完，ArrayList会先创建一个更大的数组，然后将旧的数组内容复制到新建的数组中去。

![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_21-04-33.png)


- LinkedList<E> 内部每个元素都指向下一个元素

![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_21-09-39.png)

* 特点：
- List元素可以重复
- List元素可以是NULL

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(2);
list.add(null);
list.add(3);
list.size(); // 5

```

![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_21-09-52.png)

### 遍历

- 通过get(int index)
```java
for(int i = 0; i < list.size(); i++){
     String s = list.get(i);
 }
```

- 使用Iterator<E>
```java
for(Iterator<String> it = list.iterator();  it.hasNextr()){
   String s = it.next();
}
```

- 使用foreach

```java
for(String s:list){
    
}
```

### List和Array转换

把List<E> 变为 Array :

- Object[] toArray()
- <T> T[] toArray(T[] a)

```java
List<Integer> list = new ArrayList<>();

list.add(1);
list.add(2);
list.add(3);

Integer[] array = list.toArray(new Integer[list.size]); 

```

把Array 变为 List<E> :
- <T> List<T> Arrays.asList(T... a)

```java
Integet[] array = {1,2,3};
List<Integer> arrrayList = new ArrayList<>(Arrays.asList(array));
arrayList.addAll(list);

// Arrays.asList(array) 返回的是只读的，不能调用add方法添加元素
```

### 总结
- 按索引顺序访问的长度可变的链表
- 优先使用ArrayList而不是LinkedList
- 可以直接使用for...each遍历
- 可以直接和Array相互转换


