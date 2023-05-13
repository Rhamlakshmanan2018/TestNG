package org.Test;

import org.testng.annotations.Test;

public class priority {
	@Test(priority = 1)
	private void tc1() {
		System.out.println("test case:1");

	}
	@Test(priority = -1)
	private void tc2() {
		System.out.println("test case:2");

	}
	@Test(priority = 3)
	private void tc3() {
		System.out.println("test case:3");

	}
	@Test(priority = -4)
	private void tc4() {
		System.out.println("test case:4");

	}
	@Test(priority = 6)
	private void tc6() {
		System.out.println("test case:6");
	}
	@Test(priority = -2)
	private void tc5() {
		System.out.println("test case:5");
	}
}
