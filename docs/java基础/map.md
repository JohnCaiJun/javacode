# Map

Map<K,V> 是一种键-值（Key-Value）映射表

![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_22-28-28.png)


- 可以通过key快速查找Value（元素）


![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_22-21-24.png)
![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_22-21-41.png)


- V put(K key, V value) : 把Key-Value放入Map
- V get(K key): 通过Key获取Value
- boolean containsKey(K key): 判断key是否存在


### 遍历Map

- 遍历Key可以使用for...each循环遍历keySet()

```java
for (String k: map.keySet()){
    Integer value = map.get(key);
}

```

- 同时遍历Key和Value可以使用for..each循环遍历entrySet()

```java
for(Map.Entry<String, Integer> entry: map.entrySet()){
    String k = entry.getKey();
    Integer value = entry.getValue();
}
```

- HashMap不保证有序

- TreeMap有序 --> 可以自定义排序算法

![image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/java%E9%9B%86%E5%90%88/Snipaste_2020-05-04_22-29-15.png)

### 总结
- Map<K,V>是一种映射表，可以通过Key快速查找Value
- 可以通过for...eache遍历KeySet()
- 可以通过for...eache遍历entrySet()
- 需要对Key排序时使用TreeMap
- 通常使用HashMap