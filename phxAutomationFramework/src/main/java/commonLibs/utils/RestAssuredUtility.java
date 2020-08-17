package commonLibs.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtility {

	private RequestSpecification request;

	public String triggerRestRequest(String url, String requestBody, String apiName) {
		String responseString = null;
		Response response;
		String filePath = System.getProperty("user.dir") + "/" + Variables.excel_fileName;
		ReadDataFromExcelFile reader = new ReadDataFromExcelFile(filePath);
		String content = "application/json";
		String auther = "";
		String key = "";
		String env = "";

		request = RestAssured.given().header("Content-Type", content).header("authorization", auther).header("key", key)
				.header("env", env).body(requestBody);
		response = request.when().post(url);
		
		if (response.statusCode() != 200) {
			System.out.println("REquest got faile retry");
			response = request.when().post(url);

		}

		return responseString;
	}

}
