/*
    Drools5 Integration Helper
    Copyright (C) 2009  Mathieu Boretti mathieu.boretti@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package com.grandsea.interfaces;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import java.util.concurrent.ExecutionException;

import org.boretti.drools.integration.drools5.DroolsProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class CustomerEvaluatorTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][]{
				{new Customer("Name", "Prenom", false, 10, true),false},
				{new Customer("Name", "Prenom", false, 60, true),false},
				{new Customer("Name", "Prenom", true, 10, true),false},
				{new Customer("Name", "Prenom", true, 60, true),false},
				{new Customer("Name", "Prenom", false, 10, false),false},
				{new Customer("Name", "Prenom", false, 60, false),true},
				{new Customer("Name", "Prenom", true, 10, false),true},
				{new Customer("Name", "Prenom", true, 60, false),true}
		});
	}
	
	private Customer customer;
	
	private boolean expected;
	
	public CustomerEvaluatorTest(Customer customer,boolean expected) {
		this.customer=customer;
		this.expected=expected;
	}
	
	@Test
	public void testCustomerCreditCheck() 
	throws InterruptedException,ExecutionException{
		assertThat(new DroolsProvider().getService(CustomerEvaluator.class).checkCredit(customer),is(expected));
		assertThat(new DroolsProvider().getService(CustomerEvaluator.class).checkCreditAsync(customer).get(),is(Boolean.valueOf(expected)));
	}
}
