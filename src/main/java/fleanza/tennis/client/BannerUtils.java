package fleanza.tennis.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author fleanza
 */
public class BannerUtils {

	private static final int BUFFER_SIZE = 4096;

	public static String copyToString(InputStream in) throws IOException {

		Charset charset = Charset.forName("UTF-8");
		StringBuilder out = new StringBuilder();
		InputStreamReader reader = new InputStreamReader(in,charset);
		char[] buffer = new char[BUFFER_SIZE];
		int bytesRead = -1;
		while((bytesRead = reader.read(buffer)) != -1) {
			out.append(buffer,0,bytesRead);
		}
		return out.toString();
	}

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/dvlp/workspace/eclipse-mars/tennis/src/main/resources/banner.txt");
			String banner = copyToString(fis);
			System.out.println(AnsiOutput.toString(AnsiElement.GREEN,banner));
			System.out.println();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
