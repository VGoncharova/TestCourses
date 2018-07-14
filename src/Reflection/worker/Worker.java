package ru.raiffeisen.cources.worker;


public class Worker {
    public void work1(){
        System.out.println("work1");
    }

    @Override
    public String toString() {
        return "Worker{}";
    }

    @Deprecated
    public void work2(){
        System.out.println("work2");
    }

    @SuppressWarnings(value = "")
    public void work3(){
        System.out.println("work3");
    }

    public void work4(){
        System.out.println("work4");
    }

    public void work5(){
        System.out.println("work5");
    }
}
