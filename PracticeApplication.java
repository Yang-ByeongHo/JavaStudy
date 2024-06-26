package com.spring.test;

import java.util.Arrays;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class Calculator{
	
	protected int left;
	protected int right;

	public void setOprands(int left, int right) {
		this.left = left;
		this. right = right;
	}
	public void sum() {
		System.out.println(this.left + this.right);
	}
	public void avg() {
		System.out.println((this.left + this.right) / 2);
	}
}

class SubstractionCalculator extends Calculator{
	public void substract() {
		System.out.println(this.left - this.right);
	}
}

@SpringBootApplication
public class PracticeApplication {
	public static void main(String[] args) {
		SubstractionCalculator c1 = new SubstractionCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.substract();
		
//		Calculator c2 = new Calculator();
//		c2.setOprands(20, 40);
//		c2.sum();
//		c2.avg();
	}

}
