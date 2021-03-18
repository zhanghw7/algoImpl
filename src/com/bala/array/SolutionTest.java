package com.bala.array;


import java.lang.reflect.Method;


public class SolutionTest {

    public static void main(String[] args){
        Class<Solution> solutionClass = Solution.class;
        Method[] methods = solutionClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }
}
