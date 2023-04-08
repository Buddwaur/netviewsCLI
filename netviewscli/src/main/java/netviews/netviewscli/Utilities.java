package netviews.netviewscli;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import models.NVWrapper;

public class Utilities {
	Gson gson = new Gson();

	FileReader fileReader = null;
	
	FileWriter fileWriter = null;

	public Utilities() {
		
	}
	
	public NVWrapper deserialize() {
		NVWrapper object = null;
		
		try {
			fileReader = new FileReader("C:\\fileName.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fileReader != null) {
			object = gson.fromJson(fileReader, NVWrapper.class);
		}
		
		return object;
		
	}

	public void serialize(NVWrapper obj) {
		String output = gson.toJson(obj);
		
		try {
			fileWriter = new FileWriter("C:\\fileName.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fileWriter != null) {
			try {
				fileWriter.write(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
