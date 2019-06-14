public class Person {
    // TASK 2.1
    public String name;


    public void WhatName(){
        System.out.println("Name is " + name);
    }

    // TASK 2.2

static class Student extends Person{
        public String univer;

        public void WhatUniver() {
            System.out.printf("Study in  " + univer);
    }

}

}
