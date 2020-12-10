package in.rkant.profileapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App  implements CommandLineRunner {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\WorkSpace\\jsontocsv.csv");
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ){
			String readLine = "";
			while((readLine = br.readLine()) != null) {
				System.out.println(readLine);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
