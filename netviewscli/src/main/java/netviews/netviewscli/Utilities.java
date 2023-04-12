package netviews.netviewscli;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import models.NVWrapper;

public class Utilities {
	static Gson gson = new Gson();

	static FileReader fileReader = null;

	static FileWriter fileWriter = null;

	public Utilities() {

	}

	public static NVWrapper deserialize() {
		NVWrapper object = null;

		try {
			fileReader = new FileReader("netviewscli\\src\\main\\java\\test_files\\med-topo-policy.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fileReader != null) {
			object = gson.fromJson(fileReader, NVWrapper.class);
			System.out.println(object);
		} else {
			System.out.println("Mikey said so");
		}

		if (object == null) {
			System.out.println("Fuck");
		}

		return object;

	}

	public static void serialize(NVWrapper obj) {
		String output = gson.toJson(obj);
		System.out.println(output);
		try {
			fileWriter = new FileWriter("netviewscli\\src\\main\\java\\test_files\\test.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (fileWriter != null) {
			try {
				fileWriter.write(output);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
