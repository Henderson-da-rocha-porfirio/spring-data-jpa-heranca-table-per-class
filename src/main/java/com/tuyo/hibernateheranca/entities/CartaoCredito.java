package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Table(name="cartao")
/*@PrimaryKeyJoinColumn(name="id")*/
public class CartaoCredito extends Pagamento {

	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}



}
