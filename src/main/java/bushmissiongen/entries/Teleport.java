package bushmissiongen.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bushmissiongen.messages.ErrorMessage;
import bushmissiongen.messages.Message;

public class Teleport {
	public String mName;
	private String mField;
	private String mString;

	public String latlon = "";
	public String heading = "0.000";
	public String length = "3500.000";
	public String width = "3500.000";
	public String height = "10000.000";
	public String agl = "";

	public String latlontele = "";
	public String altitude = "";
	public String agltele = "";

	public String activated = "";
	public boolean exit = false;

	public String triggerId = "";
	public String triggerGUID = "";

	public Teleport() {
	}

	public Teleport(String name, String field, String string) {
		mName = name;
		mField = field;
		mString = string;
	}

	public Message handle() {
		String[] split = mString.split("#");

		if (split.length == 7) {
			latlon = split[0];
			heading = split[1];
			length = split[2];
			width = split[3];
			height = split[4];
			latlontele = split[5];
			altitude = split[6];
		} else {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		// Coordinate transformation
		MissionEntry meTest = new MissionEntry();
		Message msgLatlon = meTest.setLatlon(latlon);
		if (msgLatlon != null) {
			return msgLatlon;
		}
		latlon = meTest.latlon;

		Pattern pattern1 = Pattern.compile("^\\d+(\\.\\d{3})$");

		boolean res2 = pattern1.matcher(heading).find();
		boolean res3 = pattern1.matcher(length).find();
		boolean res4 = pattern1.matcher(width).find();
		if (!res2 || !res3 || !res4) {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		Pattern pattern5 = Pattern.compile("^(\\d+\\.\\d{3})([A-Z]+)?$");
		Matcher matcher5 = pattern5.matcher(height);
		if (matcher5.find()) {
			height = matcher5.group(1);
			if (matcher5.group(2) != null) {
				String altMode = matcher5.group(2);
				if (altMode.equals("AGL")) {
					agl = "True";
				} else if (altMode.equals("AMSL")) {
					agl = "False";
				}
			}
		}

		MissionEntry meTestTele = new MissionEntry();
		Message msgLatlonTele = meTestTele.setLatlon(latlontele);
		if (msgLatlonTele != null) {
			return msgLatlonTele;
		}
		latlontele = meTestTele.latlon;

		Matcher matcher5tp = pattern5.matcher(altitude);
		if (matcher5tp.find()) {
			altitude = matcher5tp.group(1);
			if (matcher5tp.group(2) != null) {
				String altMode = matcher5tp.group(2);
				if (altMode.equals("AGL")) {
					agltele = "True";
				} else if (altMode.equals("AMSL")) {
					agltele = "False";
				}
			}
		}

		exit = mField.toLowerCase().contains("exit");

		return null;
	}
}
