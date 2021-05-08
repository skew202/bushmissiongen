package bushmissiongen.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bushmissiongen.messages.ErrorMessage;
import bushmissiongen.messages.Message;

public class Landmark {
	public String mName;
	private String mField;
	private String mString;

	public String value = "";
	public String lat = "";
	public String lon = "";
	public String altitude = "";
	public String offset = "";
	public String type = "";

	public Landmark() {
	}

	public Landmark(String name, String field, String string) {
		mName = name;
		mField = field;
		mString = string;
	}

	public Message handle() {
		String[] split = mString.split("#");

		// Coordinate validation
		if (split.length == 5) {
			value = split[0];
			String latlon = split[1];
			altitude = split[2];
			offset = split[3];
			type = split[4];

			// Replace bad chars in values
			value = value.replace("–", "-");
			value = value.replace("&", "&amp;");
			value = value.replace("'", "&#39;");
			value = value.replace("\"", "&quot;");
			value = value.replace("\r\n", "<br>");
			value = value.replace("\n", "<br>");

			// Coordinate transformation
			MissionEntry meTest = new MissionEntry();
			Message msgLatlon = meTest.setLatlon(latlon);
			if (msgLatlon != null) {
				return msgLatlon;
			}
			String[] latlonDegrees = meTest.getLatLongDeg(meTest.latlon);
			if (latlonDegrees == null) {
				return new ErrorMessage("Could not handle the coordinate: " + meTest.latlon);
			}			

			lat = latlonDegrees[0];
			lon = latlonDegrees[1];

			Pattern pattern = Pattern.compile("^(\\d+\\.\\d{3})([A-Z]+)?$");
			Matcher matcher1 = pattern.matcher(altitude);
			if (matcher1.find()) {
				altitude = matcher1.group(1);
			} else {
				return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
			}
			Matcher matcher2 = pattern.matcher(offset);
			if (matcher2.find()) {
				offset = matcher2.group(1);
			} else {
				return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
			}

			String[] LANDMARK_TYPES = new String[] {
					"POI",
					"City",
					"Fauna"
			};
			Pattern patternType = Pattern.compile("^(" + String.join("|", LANDMARK_TYPES) + ")$");
			Matcher matcher3 = patternType.matcher(type);
			if (matcher3.find()) {
				type = matcher3.group(1);
			} else {
				return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
			}
		} else {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		return null;
	}
}
