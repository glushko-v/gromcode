package gromcode.main.lesson25;

public class TestClass<T, K, V> {

    T doSomething1(T t){
        System.out.println(t);
        return t;
    }

    K doSomething2(K k){
        System.out.println(k);
        return k;
    }

    V doSomething3(V v){
        System.out.println(v);
        return v;
    }
}
