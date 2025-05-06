package com.curso.v0;

public class Test1 extends Concrate {
    Test1() {
    	super();
        System.out.println("t ");
    }

    public static void main(String[] args) {
        new Test1();
        //s c t
    }
}

class Concrate extends Send {
    Concrate() {
    	super();
        System.out.println("c ");
    }

    private Concrate(String s) {

    }
}

abstract class Send{
    Send() {
    	super();
        System.out.println("s ");
    }
}