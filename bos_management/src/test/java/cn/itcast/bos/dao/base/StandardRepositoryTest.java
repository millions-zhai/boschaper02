package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.base.Standard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StandardRepositoryTest {
	@Autowired
	private StandardRepository standardRepository;

	@Test
	public void testQuery(){
		System.out.println(standardRepository.queryName("10-20公斤"));

	}

	@Test
    @Transactional
    public void testSave(){
        Standard standard=new Standard();
        standard.setName("haha");
        standard.setMaxLength(20);
        standard.setMinLength(2);
        standard.setMaxWeight(20);
        standard.setMinWeight(2);
        standard.setOperatingCompany("company");
        standard.setOperatingTime(new Date());
	    standardRepository.save(standard);
    }

	@Test
	@Transactional
	@Rollback(false)
	public void testUpdate(){
		standardRepository.updateMinLength(1, 15);
	}
}
