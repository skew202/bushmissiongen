package bushmissiongen.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bushmissiongen.messages.ErrorMessage;
import bushmissiongen.messages.Message;

public class Runway {
	public String mName;
	private String mField;
	private String mString;

	public String icao = "";
	public String number = "";
	public String lat = "";
	public String lon = "";
	public String altitude = "";
	public String width = "";
	public String length = "";
	public String heading1 = "";
	public String heading2 = "";
	public String lat1 = "";
	public String lon1 = "";
	public String lat2 = "";
	public String lon2 = "";
	public String surface = "";

	public Runway() {
	}

	public Runway(String name, String field, String string) {
		mName = name;
		mField = field;
		mString = string;
	}

	public Message handle() {
		String[] split = mString.split("#");

		// Coordinate validation
		if (split.length == 11) {
			icao = split[0];
			number = split[1];
			String latlon = split[2];
			altitude = split[3];
			width = split[4];
			length = split[5];
			heading1 = split[6];
			heading2 = split[7];
			String latlon1 = split[8];
			String latlon2 = split[9];
			surface = split[10].toUpperCase();

			// Coordinate transformation
			{
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
			}
			{
				MissionEntry meTest = new MissionEntry();
				Message msgLatlon = meTest.setLatlon(latlon1);
				if (msgLatlon != null) {
					return msgLatlon;
				}
				String[] latlonDegrees = meTest.getLatLongDeg(meTest.latlon);
				if (latlonDegrees == null) {
					return new ErrorMessage("Could not handle the coordinate: " + meTest.latlon);
				}			

				lat1 = latlonDegrees[0];
				lon1 = latlonDegrees[1];
			}
			{
				MissionEntry meTest = new MissionEntry();
				Message msgLatlon = meTest.setLatlon(latlon2);
				if (msgLatlon != null) {
					return msgLatlon;
				}
				String[] latlonDegrees = meTest.getLatLongDeg(meTest.latlon);
				if (latlonDegrees == null) {
					return new ErrorMessage("Could not handle the coordinate: " + meTest.latlon);
				}			

				lat2 = latlonDegrees[0];
				lon2 = latlonDegrees[1];
			}

			Pattern pattern = Pattern.compile("^(\\d+\\.\\d{3})([A-Z]+)?$");
			Matcher matcher1 = pattern.matcher(altitude);
			if (matcher1.find()) {
				altitude = matcher1.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
			Matcher matcher2 = pattern.matcher(width);
			if (matcher2.find()) {
				width = matcher2.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
			Matcher matcher3 = pattern.matcher(length);
			if (matcher3.find()) {
				length = matcher3.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
			Matcher matcher4 = pattern.matcher(heading1);
			if (matcher4.find()) {
				heading1 = matcher4.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
			Matcher matcher5 = pattern.matcher(heading2);
			if (matcher5.find()) {
				heading2 = matcher5.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
			
			String[] RUNWAY_SURFACES = new String[] {
					"ASPHALT",
					"BITUMINOUS",
					"BRICK",
					"CLAY",
					"CEMENT",
					"CONCRETE",
					"CORAL",
					"DIRT",
					"GRASS",
					"GRAVEL",
					"ICE",
					"MACADAM",
					"OIL_TREATED, PLANKS",
					"SAND",
					"SHALE",
					"SNOW",
					"STEEL_MATS",
					"TARMAC",
					"UNKNOWN",
					"WATER"
			};
			Pattern patternSURFACE = Pattern.compile("^(" + String.join("|", RUNWAY_SURFACES) + ")$");
			Matcher matcherSURFACE = patternSURFACE.matcher(surface);
			if (matcherSURFACE.find()) {
				surface = matcherSURFACE.group(1);
			} else {
				return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
			}
		} else {
			return new ErrorMessage("Wrong format for addRunway:\n\n" + mField + "=" + mString);
		}

		return null;
	}
}
