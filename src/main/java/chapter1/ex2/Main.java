package chapter1.ex2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrimitiveRootSearcher primitiveRootSearcher = new PrimitiveRootSearcher();
        List<Integer> primitiveRoots = primitiveRootSearcher.find(5);
        System.out.println("primitiveRoots = " + primitiveRoots);
    }
}
