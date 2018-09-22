package com.kuddu.addressbook;

import java.io.PrintWriter;
import java.util.Vector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ContactAspect {
	@Pointcut(value="execution(* com.kuddu.addressbook.AddressBook.updatePerson(..))")
	private void callUpdatePersonMethod(){}
	
	@Pointcut(value = "execution(* com.kuddu.addressbook.AddressBook.deletePerson(..))")
	private void deletePersonAdvice(){}

	@Before("callUpdatePersonMethod()&&target(abook)")
	public void beforeUpdateAdvice(JoinPoint jp, AddressBook abook){		
		Vector<Person> people = abook.getPeople();
		try{
			PrintWriter writer = new PrintWriter("updateFile.txt");
			for(int i= 0;i<people.size();i++){
				writer.write(people.get(i).toString());
				}
			writer.close();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
				}
		}
	
	@Before("deletePersonAdvice() && target(ab)")
	public void deleteP(AddressBook ab){	
		Vector<Person> people = ab.getPeople();
		try{
			PrintWriter writer = new PrintWriter("deleteFile.txt");
			for(int i= 0;i<people.size();i++)
				writer.write(people.get(i).toString());
			writer.close();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
				}
		}
	}

