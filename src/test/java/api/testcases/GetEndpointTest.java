package api.testcases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.endpoints.Endpoints;
import api.pojos.Day;
import api.pojos.WeatherResponse;
import io.restassured.response.Response;
import vc.base.TestBase;
import vc.util.Util;

public class GetEndpointTest extends TestBase {
	
	

	public GetEndpointTest() {
		super();
	}

	
	String sheetName = "APIData";
	final String DATE_FORMAT_NOW = "yyyy-MM-dd";

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	String currDate =  sdf.format(cal.getTime());
	

	@DataProvider
	   public Object[][] getVCDataFromExcel() {
		   
		   Object data[][]= Util.getDataFromExcel(sheetName);
		   return data;
	   }
		
	
	
	@Test(priority = 1, dataProvider = "getVCDataFromExcel")
	public void testGetEndpoint(String city, String latitude, String longitude) {
		Response response = Endpoints.getTimeline(city,prop.getProperty("token"),prop.getProperty("unitGroup"));
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weatherResp = new WeatherResponse();
		try {
			weatherResp = mapper.readValue(response.getBody().asString(),WeatherResponse.class);
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Day> list = weatherResp.days;
		
		
		for(Day d:list) {
			if (d.datetime.equals(currDate)) {
			 System.out.println("The returned list has current date temperature");
			 break;
			}
		}
		
	   
		String location = weatherResp.address;
		Double latitudeval = weatherResp.latitude;
		String latString = latitudeval.toString();
		
		System.out.println(latitude);
		Double longitudeval = weatherResp.longitude;
		String longString = longitudeval.toString();
		
		System.out.println(longitude);
		
		Assert.assertEquals(location, city);
		Assert.assertEquals(latString,latitude);
		Assert.assertEquals(longString,longitude);
		

		

	}

}
