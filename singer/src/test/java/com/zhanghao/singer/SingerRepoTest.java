package com.zhanghao.singer;

import com.zhanghao.singer.entity.Singer;
import com.zhanghao.singer.repos.SingerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by iuliana.cosmina on 7/23/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SingerRepoTest {

	private SingerRepository singerRepository;

	@Autowired
	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	@Test
	public void testSaveSinger(){
		Singer singer = new Singer();
		singer.setFirstName("Angus");
		singer.setLastName("Young");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1991, 2, 17)).getTime().getTime()));
		singerRepository.save(singer);

		//get all singers, list should only have one
		Iterable<Singer> singers = singerRepository.findAll();
		int count = 0;

		for(Singer s : singers){
			count++;
		}
		assertEquals(count, 15);
	}

	@Test
	public void testDeleteSinger() {
		singerRepository.deleteById(13L);
		//get all singers, list should only have one
		Iterable<Singer> singers = singerRepository.findAll();
		int count = 0;

		for(Singer s : singers){
			count++;
		}
		assertEquals(count, 13);


	}
}
