package THMedia;

import lib.MediaInfo;
import lib.JsonHttpClient;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.stylesheets.MediaList;

/**
 *
 * @author Konstantin Goncharov
 */
public class JsonMediaParser {
	public void JsonMediaParser() {
	}

	public static String GetToken(JsonReader jsonReader) {
		String token = null;
		 try {
			 while (jsonReader.hasNext()) {
				 jsonReader.beginObject();
				 while (jsonReader.hasNext()) {
					 String name = jsonReader.nextName();
					 if (name.equals("error")) {
						 int errorCount = jsonReader.nextInt();
						 if (errorCount > 0) {
						 }
					 } else if (name.equals("token")) {
						 token = jsonReader.nextString();
					 } else {
						 jsonReader.skipValue();
					 }
				 }
			 }
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		return token;
	}

	public static LinkedList <MediaInfo> GetMediaList(JsonReader jsonReader) {
		LinkedList<MediaInfo> mediaList = new LinkedList<MediaInfo>();
		try {
			while (jsonReader.hasNext()) {
				jsonReader.beginObject();
				while (jsonReader.hasNext()) {
					String name = jsonReader.nextName();
					if (name.equals("error")) {
						int errorCount = jsonReader.nextInt();
						if (errorCount > 0){

						}
					} else if (name.equals("list")) {
						jsonReader.beginArray();
						while (jsonReader.hasNext()) {
							jsonReader.beginObject();
							MediaInfo mediaInfo = new MediaInfo();
							while (jsonReader.hasNext()) {
								String infoItemName = jsonReader.nextName();
								switch (infoItemName) {
									case "aurl":
										mediaInfo.setAurl(jsonReader.nextString());
										break;
									case "iurl":
										mediaInfo.setIurl(jsonReader.nextString());
										break;
									case "genre":
										mediaInfo.setGenre(jsonReader.nextString());
										break;
									case "artist":
										mediaInfo.setArtist(jsonReader.nextString());
										break;
									case "title":
										mediaInfo.setTitle(jsonReader.nextString());
										break;
								}
							}
							mediaList.add(mediaInfo);
							jsonReader.endObject();
						}
					} else {
						jsonReader.skipValue();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mediaList;
	}

	public LinkedList<MediaInfo> GetUserMediaList(String login, String pasword) {
		JsonHttpClient jsonHttpClient = new JsonHttpClient();
		String request = "http://vacancy.dev.telehouse-ua.net/auth/login?login="
				+ login + "&password=" + pasword;
		HttpGet getMethod = new HttpGet(request);
		getMethod.setHeader("Content-Type", "application/json");
		JsonReader jsonReader = jsonHttpClient.exequteRequest(getMethod);
		String token = JsonMediaParser.GetToken(jsonReader);
		String requestMediaList = "http://vacancy.dev.telehouse-ua.net/media/list";
		getMethod = new HttpGet(requestMediaList);
		getMethod.setHeader("Content-Type", "application/json");
		getMethod.addHeader("X-Auth-Token", token);
		jsonReader = jsonHttpClient.exequteRequest(getMethod);
		return JsonMediaParser.GetMediaList(jsonReader);
	}
}
