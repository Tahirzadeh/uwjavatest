package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private int count = 0;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    count++;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public String tostring() {
    return "{{FIXME}}";
  }

  //Returns the age of the person
  public int getAge() {
	  return age;
  }
  
  //Sets the age
  public void setAge(int age) {
	  if(age < 0) {
		  throw new IllegalArgumentException("Invalid Age");
	  }
	  this.age = age;
  }
  
  //Returns name
  public String getName() {
	  return name;
  }
  
  //Sets name
  public void setName(String name) {
	  if (name == null) {
		  throw new IllegalArgumentException("Invalid Name");
	  }
	  this.name = name;
  }
  
  //Returns salary
  public double getSalary() {
	  return salary;
  }
  
  //Sets salary
  public void setSalary(double salary) {
	  this.salary = salary;
  }
  
  //Returns the number of 'persons' created
  public int count() {
	  return count;
  }
  
  public boolean equals(Object other) {
	  if(other instanceof Person) {
		  Person person = (Person) other;
		  return person.name == this.name && person.age == this.age;
	  }
	  return false;
	  //return this.name == other.name && this.age == other.age;
  }
  
  public static class AgeComparator implements Comparator<Person> {
	  public int compare(Person one, Person two) {
		  return one.age - two.age;
	  }
  }
  
  public int compareTo(Person other) {
	  return (int) (other.getSalary() - this.getSalary());
  }
  
  public static ArrayList<Person> getNewardFamily() {
	  ArrayList<Person> family = new ArrayList<Person>();
	  family.add(new Person("Ted", 41, 250000));
	  family.add(new Person("Charlotte", 43, 150000));
	  family.add(new Person("Michael", 22, 10000));
	  family.add(new Person("Matthew", 15, 0));
	  return family;
  }
  
  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
