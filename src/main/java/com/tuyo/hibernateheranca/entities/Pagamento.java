package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Exemplo com TABLE_PER_CLASS
public abstract class Pagamento { // abstract porque não será utilizado diretamente este Pagamento. É uma classe genérica.

	@Id
	private int id;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
