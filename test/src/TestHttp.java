import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class TestHttp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			//byte[] bytes = EntityUtils.toByteArray(entity);
			//String result = new String(bytes,"utf-8");
			String rusult2 = EntityUtils.toString(entity, "utf-8");
			System.out.println(rusult2);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
