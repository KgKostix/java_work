package lib;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Konstantin Goncharov
 */
public class JsonHttpClient {
	public JsonHttpClient() {
		httpClient = new DefaultHttpClient();
	}

	public JsonReader exequteRequest(HttpUriRequest request){
		HttpResponse response = null;
		JsonReader jsonReader = null;
		try {
			response = httpClient.execute(request);

		} catch (IOException e) {

		} finally {
			request.abort();
		}
		if (response != null) {
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				try {
					InputStream is = entity.getContent();
					jsonReader = new JsonReader(new InputStreamReader(is));
				} catch (Exception e) {
				}
			} else {
				//вызвать исключение
			}
		}
		return jsonReader;
	}

	private HttpClient httpClient = null;
}
