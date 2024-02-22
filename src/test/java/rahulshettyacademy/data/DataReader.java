package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
	
import org.apache.commons.io.FileUtils;

public class DataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to String
	String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"));
	
	//String to HashMap Jackson Databind
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});
	return data;
	}
	

}
