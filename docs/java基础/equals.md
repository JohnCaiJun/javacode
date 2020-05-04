# equals()方法


- contains() 判断List中是否包含某个元素（对象）

而判断是否包含某个对象，该对象必须正确实现equals方法

### 总结

- List的实现类用过元素的equals方法比较两个元素
- 放入的元素必须正确覆写equals方法，JDK提供的String、Integer等已经覆写了equals方法
- 编写equals方法可借助Objects.equals()判断

> 如果不在List中查找元素，不必覆写equals方法