import java.io.*;

public class EasyQuestions {
	public static void main(String[] args) {
		String file = "src\\easyQuestions.csv";
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] easyq = line.split(",");
				
				for(String index : easyq) {
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
