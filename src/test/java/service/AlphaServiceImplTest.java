package service;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import dto.Alpha;
import dto.FlattenAlpha;
import dto.SortedAlpha;

public class AlphaServiceImplTest {

	Alpha alpha;
	SortedAlpha sortedAlpha;
	FlattenAlpha flattenAlpha;

	@Before
	public void init() {
		alpha = new Alpha();
		alpha.setAnimal("zebra");
		alpha.setFruit("apple");
		alpha.setCityList(new String[] { "sunnyvale", "sanjose" });

		sortedAlpha = new SortedAlpha();
		sortedAlpha.setAnimal("zebra");
		sortedAlpha.setFruit("apple");
		sortedAlpha.setCityList(new String[] { "sunnyvale", "sanjose" });

		flattenAlpha = new FlattenAlpha();
		flattenAlpha.setAnimal("zebra");
		flattenAlpha.setFruit("apple");
		flattenAlpha.setCityList("sunnyvale,sanjose");

	}

	@Test
	public void testSortAlpha() {
		SortedAlpha actualSortedAlpha = new SortedAlpha();
		actualSortedAlpha.setAnimal(alpha.getAnimal());
		actualSortedAlpha.setCityList(alpha.getCityList());
		actualSortedAlpha.setFruit(alpha.getFruit());
		Assert.assertEquals(sortedAlpha.getAnimal(),
				actualSortedAlpha.getAnimal());
	}

	@Test
	public void testFlattenAlpha() {
		AlphaServiceImpl alphaServiceImpl = new AlphaServiceImpl();
		Response flattenAlphaRes = alphaServiceImpl.flattenAlpha(alpha);
		FlattenAlpha actualFlattenAlpha = (FlattenAlpha) flattenAlphaRes
				.getEntity();
		
		Assert.assertEquals(flattenAlpha.getCityList(),actualFlattenAlpha.getCityList());
	}

}
