package com.tuyo.hibernateheranca.entities;

import javax.persistence.*;

@Entity
@Table(name = "cheque")
/*@PrimaryKeyJoinColumn(name = "id")*/
public class Cheque extends Pagamento {

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

}
