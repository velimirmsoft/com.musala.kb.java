Short and Long answers on some questions and tasks with Generic Types.
Also I have included examples of Generic Type interfaces, classes and methods and testing them with different types of data.

-------------------------------------------------------------------------------------------------------------------

1. Write a generic method to count the number of elements in a collection that have a specific property 
(for example, odd integers, prime numbers, palindromes).

2. Will the following class compile? If not, why?

public final class Algorithm {
    public static <T> T max(T x, T y) {
        return x > y ? x : y;
    }
}

-------------------------------------------------------------------------------------------------------------------

Answer: No. The greater than (>) operator applies only to primitive numeric types.

3. Write a generic method to exchange the positions of two different elements in an array.

Answer:
public final class Algorithm {
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

-------------------------------------------------------------------------------------------------------------------

4. If the compiler erases all type parameters at compile time, why should you use generics?

Answer: You should use generics because:
- The Java compiler enforces tighter type checks on generic code at compile time.
- Generics support programming types as parameters.
- Generics enable you to implement generic algorithms.

-------------------------------------------------------------------------------------------------------------------

5. What is the following class converted to after type erasure?
public class Pair<K, V> {

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(); { return key; }
    public V getValue(); { return value; }

    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    private K key;
    private V value;
}

Answer:
public class Pair {

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey()   { return key; }
    public Object getValue() { return value; }

    public void setKey(Object key)     { this.key = key; }
    public void setValue(Object value) { this.value = value; }

    private Object key;
    private Object value;
}

-------------------------------------------------------------------------------------------------------------------

6. What is the following method converted to after type erasure?
public static <T extends Comparable<T>>
    int findFirstGreaterThan(T[] at, T elem) {
    // ...
}

Answer:
public static int findFirstGreaterThan(Comparable[] at, Comparable elem) {
    // ...
    }

-------------------------------------------------------------------------------------------------------------------

7. Will the following method compile? If not, why?

public static void print(List<? extends Number> list) {
    for (Number n : list)
        System.out.print(n + " ");
    System.out.println();
}

Answer: Yes. We are using the wild card here '?' - meaning we can use any type of Number (Integer, Double, Float ... ).

-------------------------------------------------------------------------------------------------------------------

8. Write a generic method to find the maximal element in the range [begin, end) of a list.

Answer:
import java.util.*;

public final class Algorithm {
    public <E> E max(List<E> list, int begin, int end) {

		E maxElem = list.get(begin);

		for (++begin; begin < end; ++begin)
			if (((Integer) maxElem).compareTo((Integer) list.get(begin)) < 0)
				maxElem = list.get(begin);
		return maxElem;
		
	}
}

-------------------------------------------------------------------------------------------------------------------

9. Will the following class compile? If not, why?

public class Singleton<T> {

    public static T getInstance() {
        if (instance == null)
            instance = new Singleton<T>();

        return instance;
    }

    private static T instance = null;
}

Answer: No. You cannot create a static field of the type parameter T. 

-------------------------------------------------------------------------------------------------------------------

10. Given the following classes:

class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node<T> { /* ... */ }

Will the following code compile? If not, why?

Node<Circle> nc = new Node<>();
Node<Shape>  ns = nc;

Answer: No. Because Node<Circle> is not a subtype of Node<Shape>. 
It's types are subclasses but that has nothing to do with the Node class.

-------------------------------------------------------------------------------------------------------------------

11. Consider this class:

class Node<T> implements Comparable<T> {
    public int compareTo(T obj) { /* ... */ }
    // ...
}

Will the following code compile? If not, why?

Answer: Yes.

Node<String> node = new Node<>();
Comparable<String> comp = node;

Exactly what question number 10 is missing.

-------------------------------------------------------------------------------------------------------------------

12. How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?

public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
    
Note that two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.

-------------------------------------------------------------------------------------------------------------------