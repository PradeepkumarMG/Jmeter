package com.jmeter.spring.test.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmeter.spring.entity.Account;
import com.jmeter.spring.repository.AccountRepository;
import com.jmeter.spring.service.AccountService;
import com.jmeter.spring.test.TestConfig;
import com.jmeter.spring.test.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class AccountServiceImplTest {

	@Autowired
	private AccountService classToTest;
	
	@Autowired
	private AccountRepository acctRepo;

	@Test
	public void findByUsername_not_found() {
		Account foundAcct = classToTest.findByUsername("testUser");
		assertNull(foundAcct);
	}

	@Test
	public void findByUsername_found() {
		
		acctRepo.save(TestData.createDummy("MaryZheng", "Mary", "Zheng"));
		Account foundAcct = classToTest.findByUsername("MaryZheng");
		assertNotNull(foundAcct);
		assertEquals(1, foundAcct.getId().intValue());
	}
}
