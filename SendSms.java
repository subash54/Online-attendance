package spreadsheet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class SendSms {

	public static String API_KEY="fQD2D47X2j8-wLGjIoR18xaojKqjhLU7PgC4mWvL3b";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	}
	public static String sendSms(String phno) {
		try {
			// Construct data
			String apiKey = "apikey=" + API_KEY;
			String message = "&message=" + "This is the message from subash";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" +phno;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
