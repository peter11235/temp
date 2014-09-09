package edu.elon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {

	ATM atm;
	@Before
	public void setUp() throws Exception {
		atm = new ATM(50);
	}

	@After
	public void tearDown() throws Exception {
		atm = null;
	}

	@Test
	public void testDeposit() {
		atm.deposit(50);
		double expected = 100;
		double actual = atm.getBalance();
		assertEquals(expected, actual, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeDeposit() {
		atm.deposit(-1);
		fail("Should have thrown exception");
	}
	

	@Test
	public void testGetBalance() {
		double expected = 50;
		double actual = atm.getBalance();
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testToString() {
		atm.deposit(5000);
		String expected = "Amount balance is $5,050.00";
		String actual = atm.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testWithdraw() {
		atm.withdraw(25);
		double expected = 25;
		double actual = atm.getBalance();
		assertEquals(expected, actual, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithdrawTooMuch() {
		atm.withdraw(50.01);
		fail("Should have thrown an exception");
	}
	

}
