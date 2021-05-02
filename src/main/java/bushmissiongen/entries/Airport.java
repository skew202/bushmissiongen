package bushmissiongen.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bushmissiongen.messages.ErrorMessage;
import bushmissiongen.messages.Message;

public class Airport {
	public String mName;
	private String mField;
	private String mString;

	public String icao = "";
	public String name = "";
	public String city = "";
	public String lat = "";
	public String lon = "";
	public String altitude = "";
	public String radius = "";

	public Airport() {
	}

	public Airport(String name, String field, String string) {
		mName = name;
		mField = field;
		mString = string;
	}

	public Message handle() {
		String[] split = mString.split("#");

		// Coordinate validation
		if (split.length == 6) {
			icao = split[0];
			name = split[1];
			city = split[2];
			String latlon = split[3];
			altitude = split[4];
			radius = split[5];

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
			Matcher matcher2 = pattern.matcher(radius);
			if (matcher2.find()) {
				radius = matcher2.group(1);
			} else {
				return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
			}
		} else {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		return null;
	}
}
