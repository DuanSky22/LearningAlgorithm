package com.sky.learningJava.Collections;

class Person implements Comparable {
    private String name;
    private int age;
     
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }  
     
    public void setAge(int age){
        this.age = age;
    }
     
    @Override
    public int hashCode() {
        return name.hashCode()*37+age;
    }
     
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Person)obj).name) && this.age== ((Person)obj).age;
    }
    
    @Override
    public String toString(){
    	return "["+this.name+" "+this.age+"] ";
    }

	@Override
	public int compareTo(Object o) {
		return this.name.compareTo(((Person)o).name);
	}

	
    
    
}
