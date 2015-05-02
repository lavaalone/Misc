package misc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import org.json.*;

/**
 * Created by thinhnguyen on 5/1/15.
 */
public class Misc {

	private String _imei;
	private String _androidId;
	private String _serial;
	private String _macAddress;
	private String _googleAdv;
	private String _googleAcc;
	private boolean _isLAT;
	private String _locale;
	private String _model;
	private String _brand;
	private String _name;
	private String _device;
	private String _incremental;
	private String _board;
	private String _manufacturer;
	private String _fingerprint;
	private String _buildID;
	private String _release;
	private String _kernel;
	private String _installSource;
	private String _uid;
	private String _deviceID;
	private String _osVersion;
	private String _version;


	public void CubicRegister() {
		try {
//			JSONObject object = new JSONObject();
//			object.put("imei", get_imei());
//			object.put("android_id", get_androidId());
//			object.put("serial", get_serial());
//			object.put("mac_address", get_macAddress());
//			object.put("google_adv", get_googleAdv());
//			object.put("google_account", get_googleAcc());
//			object.put("isLAT", get_isLAT());
//			object.put("locale", get_locale());
//			object.put("model", get_model());
//			object.put("brand", get_brand());
//			object.put("name", get_name());
//			object.put("device", get_device());
//			object.put("incremental", get_incremental());
//			object.put("board", get_board());
//			object.put("manufacturer", get_manufacturer());
//			object.put("fingerprint", get_fingerprint());
//			object.put("buildid", get_buildID());
//			object.put("releases", get_release());
//			object.put("kernel", get_kernel());
//			object.put("install_source", get_installSource());

			StringBuilder output = new StringBuilder();
			output.append("imei=").append(get_imei());
			output.append("&android_id=").append(get_androidId());
			output.append("&serial=").append(get_serial());
			output.append("&mac_address=").append(get_macAddress());
			output.append("&google_adv=").append(get_googleAdv());
			output.append("&google_account=").append(get_googleAcc());
			output.append("&isLAT=").append(get_isLAT());
			output.append("&locale=").append(get_locale());
			output.append("&model=").append(get_model());
			output.append("&brand=").append(get_brand());
			output.append("&name=").append(get_name());
			output.append("&device=").append(get_device());
			output.append("&incremental=").append(get_incremental());
			output.append("&board=").append(get_board());
			output.append("&manufacturer=").append(get_manufacturer());
			output.append("&fingerprint=").append(get_fingerprint());
			output.append("&buildid=").append(get_buildID());
			output.append("&releases=").append(get_release());
			output.append("&kernel=").append(get_kernel());
			output.append("&install_source=").append(get_installSource());

			URL url = new URL("http://android.cubiccash.com/register.process.php");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection(); // able to use proxy here Proxy
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Host", "android.cubiccash.com");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(output.toString().getBytes().length));
			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			connection.setRequestProperty("Origin", "http://android.cubiccash.com");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 4.4.2; GT-N7200 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencod ed");
			connection.setRequestProperty("Referer", "http://android.cubiccash.com/register2.php");
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Accept-Language", "en-US");
			connection.setRequestProperty("Cookie", "version=11");
			connection.setRequestProperty("X-Requested-With", "com.cubic.cash");
			connection.setDoOutput(true);

//			System.out.println("json content := " + object.toString());
			System.out.println("json content := " + output.toString());
			DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
			dataOutputStream.writeBytes(output.toString());
			dataOutputStream.flush();
			dataOutputStream.close();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String respone = "";
			while ((respone = bufferedReader.readLine()) != null) {
				System.out.println(respone);
			}
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get_imei() {
		_imei = "58525507507127";
		return _imei;
	}

	public String get_androidId() {
		_androidId = "2c78531972d9127";
		return _androidId;
	}

	public String get_serial() {
		_serial = "5852550172d9127";
		return _serial;
	}

	public String get_macAddress() {
		_macAddress = "22:91:F4:B4:B4:C7";
		return _macAddress;
	}

	public String get_googleAdv() {
		_googleAdv = "9ac2f37-69f6-45b4-a477-149b0874b3";
		return _googleAdv;
	}

	public String get_googleAcc() {
		try {
			JSONObject inner = new JSONObject();
			inner.put("type", "com.google");
			inner.put("name", "someguys201501@gmail.com");
			JSONObject outmost = new JSONObject();
			outmost.put("accounts", inner);
//			_googleAcc = outmost.toString();
			_googleAcc = "{\"accounts\":[{\"type\":\"com.google\",\"name\":\"someguys221501@gmail.com\"},{\"type\":\"com.dena.mj.syncadapter\",\"name\":\"MangaBox\"}]}";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return _googleAcc;
	}

	public boolean get_isLAT() {
		_isLAT = true;
		return _isLAT;
	}

	public String get_locale() {
		_locale = "en";
		return _locale;
	}

	public String get_model() {
		_model = "GT-N7200";
		return _model;
	}

	public String get_brand() {
		_brand = "samsung";
		return _brand;
	}

	public String get_name() {
		_name = "t02gxx";
		return _name;
	}

	public String get_device() {
		_device = "t02g";
		return _device;
	}

	public String get_incremental() {
		_incremental = "N7200XXUFND3";
		return _incremental;
	}

	public String get_board() {
		_board = "smdk4x12";
		return _board;
	}

	public String get_manufacturer() {
		_manufacturer = "samsung";
		return _manufacturer;
	}

	public String get_fingerprint() {
		_fingerprint = "samsung/t02gxx/t02g:4.4.2/KOT49H/N7200XXUFND3:user/release-keys";
		return _fingerprint;
	}

	public String get_buildID() {
		_buildID = "KOT49H";
		return _buildID;
	}

	public String get_release() {
		_release = "4.4.2";
		return _release;
	}

	public String get_kernel() {
		_kernel = "3.10.30-android-x86-hd+";
		return _kernel;
	}

	public String get_installSource() {
		_installSource = "com.android.vending";
		return _installSource;
	}

	public String get_uid() {
		_uid = "09e8beb7e53cb35ba54bc126b205ab7";
		return _uid;
	}

	public String get_deviceID() {
		_deviceID = "45256345746574577";
		return _deviceID;
	}

	public String get_osVersion() {
		_osVersion = "4.4.2";
		return _osVersion;
	}

	public String get_version() {
		_version = "11";
		return _version;
	}
}
