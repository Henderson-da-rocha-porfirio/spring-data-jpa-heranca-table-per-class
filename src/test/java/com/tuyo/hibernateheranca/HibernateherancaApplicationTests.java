package com.tuyo.hibernateheranca;

import com.tuyo.hibernateheranca.entities.CartaoCredito;
import com.tuyo.hibernateheranca.entities.Cheque;
import com.tuyo.hibernateheranca.repository.PagamentoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateherancaApplicationTests {

	@Autowired
	PagamentoRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPagamento() {
		CartaoCredito cc = new CartaoCredito();
		cc.setId(123);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	}

	@Test
	public void createCheckPagamento() {
		Cheque ch = new Cheque();
		ch.setId(124);
		ch.setAmount(1000);
		ch.setChecknumber("1234567890");
		repository.save(ch);
	}

}

