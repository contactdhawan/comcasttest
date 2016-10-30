package service;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import dto.Alpha;
import dto.FlattenAlpha;
import dto.SortedAlpha;

public class AlphaServiceImpl implements AlphaService {

	Alpha alpha;

	AlphaServiceImpl() {
		init();
	}

	public void init() {
		alpha = new Alpha();
		alpha.setAnimal("zebra");
		alpha.setFruit("apple");
		alpha.setCityList(new String[] { "sunnyvale", "sanjose" });
	}

	public Alpha getAlpha() {
		return alpha;
	}

	public Response sortAlpha(Alpha alpha) {
		SortedAlpha sortedalpha = new SortedAlpha();
		sortedalpha.setAnimal(alpha.getAnimal());
		sortedalpha.setCityList(alpha.getCityList());
		sortedalpha.setFruit(alpha.getFruit());
		return Response.ok(sortedalpha).build();
	}

	public Response flattenAlpha(Alpha alpha) {
		FlattenAlpha flattenAlpha = new FlattenAlpha();
		flattenAlpha.setAnimal(alpha.getAnimal());
		flattenAlpha.setCityList(Arrays.toString(alpha.getCityList()).replaceAll("\\[|\\]|\\s", ""));
		flattenAlpha.setFruit(alpha.getFruit());
		return Response.ok(flattenAlpha).build();
	}

}
