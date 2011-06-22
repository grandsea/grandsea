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
package com.grandsea.classes;

import org.boretti.drools.integration.drools5.annotations.DroolsService;
import org.boretti.drools.integration.drools5.annotations.DroolsGenerated;
import org.boretti.drools.integration.drools5.annotations.DroolsIgnored;

@DroolsService(resourceName="/Customer-class.cdrl")
public class Customer {
	@DroolsIgnored
	private String name;
	
	@DroolsIgnored
	private String prenom;
	
	private boolean sexe;
	
	private int age;
	
	private boolean chomeur;
	
	@DroolsGenerated
	private boolean creditAllowed;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Customer(String name, String prenom, boolean sexe, int age,
			boolean chomeur) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
		this.chomeur = chomeur;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the sexe
	 */
	public boolean isSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the chomeur
	 */
	public boolean isChomeur() {
		return chomeur;
	}

	/**
	 * @param chomeur the chomeur to set
	 */
	public void setChomeur(boolean chomeur) {
		this.chomeur = chomeur;
	}

	/**
	 * @return the creditAllowed
	 */
	public boolean isCreditAllowed() {
		return creditAllowed;
	}

	/**
	 * @param creditAllowed the creditAllowed to set
	 */
	public void setCreditAllowed(boolean creditAllowed) {
		this.creditAllowed = creditAllowed;
	}
	
}