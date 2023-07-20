package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class Endpoints {

	public static Response getTimeline(String city, String token, String unitGroup) {

		HashMap<String, String> hm = new HashMap<>();
		hm.put("unitGroup", unitGroup);
		hm.put("key", token);

//		Response response = given().contentType(ContentType.JSON).pathParam("cityname", city)
//				.queryParam("key", token).queryParam ("unitGroup", unitGroup)
//				.when()
//				.get(UrlHelper.get_timeline_url);
//		return response;
		
		Response response = given().contentType(ContentType.JSON).pathParam("cityname", city)
				.queryParams(hm)
				.when()
				.get(UrlHelper.get_timeline_url);
		return response;

	}

}
