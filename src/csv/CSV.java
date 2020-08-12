package csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.*;

public class CSV {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		saveCSV();
		
	}
	
	public static void saveCSV() throws IOException {
		try (InputStream in = new FileInputStream(new File("E:\\Downloads\\inventorycsv.csv"))) {
		    CSVLib csv = new CSVLib(true, ',', in );
		    List < String > fieldNames = null;
		    if (csv.hasNext()) fieldNames = new ArrayList < > (csv.next());
		    
		    while (csv.hasNext()) {
		        List < String > x = csv.next();
		        Map < String, String > obj = new LinkedHashMap < > ();
		        for (int i = 0; i < fieldNames.size(); i++) {
		            obj.put(fieldNames.get(i), x.get(i));
		        }
		        
		        Gson gson = new Gson();
		        
		        HttpClient.post(gson.toJson(obj));
		    }
		 
		    System.out.println("All Done!");
		  
		}

	}

}
