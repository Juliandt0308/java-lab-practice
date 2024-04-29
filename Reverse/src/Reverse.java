import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Reverse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream fis = new FileInputStream("input.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String data = br.readLine();
		String temp;
		while ((temp = br.readLine())!=null) {
			data = data.concat(" ");
			data = data.concat(temp);
		}
		fis.close(); isr.close(); br.close();
		
		FileOutputStream fos = new FileOutputStream("output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		int len = data.split(" ").length;
		for (int i = len-1; i>=0; i--) {
			String newData = data.split(" ")[i];
			bw.write(newData);
			bw.newLine();
		}
		bw.flush();
		fos.close(); osw.close(); bw.close();
	}
}
