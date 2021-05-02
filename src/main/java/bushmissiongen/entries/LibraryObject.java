package bushmissiongen.entries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bushmissiongen.messages.ErrorMessage;
import bushmissiongen.messages.Message;

public class LibraryObject {
	public String mName;
	private String mField;
	private String mString;

	public String mdlGUID = "";
	public String latlon = "";
	public String altitude = "";
	public String heading = "0.000";
	public String pitch = "0.000";
	public String bank = "0.000";
	public String snapToGround = "False";
	public String scale = "1.000";
	public String agl = "";

	public String activated = "";

	public String triggerId = "";
	public String triggerGUID = "";

	public LibraryObject() {
	}

	public LibraryObject(String name, String field, String string) {
		mName = name;
		mField = field;
		mString = string;
	}

	public Message handle() {
		String[] split = mString.split("#");

		// Coordinate validation
		if (split.length == 5) {
			mdlGUID = split[0];
			latlon = split[1];
			altitude = split[2];
			heading = split[3];
			scale = split[4];
		} else if (split.length == 6) {
			mdlGUID = split[0];
			latlon = split[1];
			altitude = split[2];
			heading = split[3];
			scale = split[4];
			activated = split[5].trim();
		} else if (split.length == 9) {
			mdlGUID = split[0];
			latlon = split[1];
			altitude = split[2];
			heading = split[3];
			pitch = split[4];
			bank = split[5];
			snapToGround = split[6];
			scale = split[7];
			activated = split[8].trim();
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

		Pattern pattern5 = Pattern.compile("^(\\d+\\.\\d{3})([A-Z]+)?$");
		Matcher matcher5 = pattern5.matcher(altitude);
		if (matcher5.find()) {
			altitude = matcher5.group(1);
			if (matcher5.group(2) != null) {
				String altMode = matcher5.group(2);
				if (altMode.equals("AGL")) {
					agl = "True";
				} else if (altMode.equals("AMSL")) {
					agl = "False";
				}
			}
		} else {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		Pattern pattern1 = Pattern.compile("^\\d+(\\.\\d{3})$");

		boolean res2 = pattern1.matcher(heading).find();
		boolean res3 = pattern1.matcher(pitch).find();
		boolean res4 = pattern1.matcher(bank).find();
		boolean res5 = pattern1.matcher(scale).find();
		if (!res2 || !res3 || !res4 || !res5) {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		String[] TRUE_FALSE = new String[] {
				"True",
				"False"
		};
		Pattern patternSNAP = Pattern.compile("^(" + String.join("|", TRUE_FALSE) + ")$");
		Matcher matcherSNAP = patternSNAP.matcher(snapToGround);
		if (matcherSNAP.find()) {
			snapToGround = matcherSNAP.group(1);
		} else {
			return new ErrorMessage("Wrong format for " + mField + ":\n\n" + mField + "=" + mString);
		}

		return null;
	}
}
