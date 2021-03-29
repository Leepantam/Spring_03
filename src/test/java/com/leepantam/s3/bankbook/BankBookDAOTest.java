package com.leepantam.s3.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leepantam.s3.MyAbstractTest;



public class BankBookDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;

	//	@Test
	public void setUpdateTest() throws Exception{
		BankBookDTO bDto = new BankBookDTO();
		bDto.setAccount_number(1);

		bDto = bankBookDAO.getSelect(bDto);


		bDto.setAccount_name("account01test0323");
		//		bDto.setInterest_rate(1.542);
		//		bDto.setCan_make("Y");

		int retult = bankBookDAO.setUpdate(bDto);
		assertEquals(1, retult);
	}

	//	@Test
	public void setDeleteTest() throws Exception{
		BankBookDTO bDto = new BankBookDTO();
		bDto.setAccount_number(7);
		int result = bankBookDAO.setDelete(bDto);

		assertEquals(1, result);
	}

	//	@Test
	public void getListTest() throws Exception{
//		List<BankBookDTO> ar=bankBookDAO.getList();

//		assertNotEquals(0, ar.size());
	}

//	@Test
	public void getSelectTest() throws Exception{
		BankBookDTO bDto = bankBookDAO.getSelect(null);

		assertNotNull(bDto);
	}


//	@Test
	public void setWriteTest() throws Exception {
		for(int i=0;i<200;i++) {

			BankBookDTO bDto = new BankBookDTO();
			bDto.setAccount_name("Leepantam"+i);
			bDto.setInterest_rate(1.0);
			bDto.setCan_make("N");

			int result = bankBookDAO.setWrite(bDto);
			if(i%10==0){
				Thread.sleep(500);
			}
		}

		//		assertEquals(1, result);
	}

}
