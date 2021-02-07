package bushmissiongen.misc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimData {
	public Object[] weatherTypes = new Object[] {
			"custom - use the Weather.WPR file",
			"live - Everything is configured inside the game",
			".\\WeatherPresets\\BrokenClouds.WPR",
			".\\WeatherPresets\\ClearSky.WPR",
			".\\WeatherPresets\\FewClouds.WPR",
			".\\WeatherPresets\\HighLevelClouds.WPR",
			".\\WeatherPresets\\Overcast.WPR",
			".\\WeatherPresets\\Rain.WPR",
			".\\WeatherPresets\\ScatteredClouds.WPR",
			".\\WeatherPresets\\Snow.WPR",
			".\\WeatherPresets\\Storm.WPR"
	};

	public Object[] planes = new Object[] {
			"Airbus A320 Neo Asobo",
			"Asobo Savage Cub",
			"Asobo XCub",
			"Beechcraft King Air 350i Asobo",
			"Boeing 747-8i Asobo",
			"Bonanza G36 Asobo",
			"Cessna 152 Asobo",
			"Cessna 208B Grand Caravan EX",
			"Cessna CJ4 Citation Asobo",
			"Cessna Skyhawk G1000 Asobo",
			"DA40-NG Asobo",
			"DA62 Asobo",
			"DR400 Asobo",
			"Extra 330 Asobo",
			"FlightDesignCT Asobo",
			"Icon A5 Asobo",
			"Mudry Cap 10 C",
			"Pitts Asobo",
			"TBM 930 Asobo",
			"VL3 Asobo"
	};

	public List<String> encryptedOfficial = new ArrayList<>();

	public List<String> airliners = new ArrayList<>();

	public List<String> systemsList = new ArrayList<>();

	public Map<String, String> systemToFailureCodeMap = new HashMap<>();

	public Object[] missionTypeList = {"Bush trip", "Landing challenge"};
	public Object[] challengeTypeList = {"Famous", "Epic", "StrongWind"};

	public SimData() {
		// Deluxe
		encryptedOfficial.add("Asobo Baron G58");
		encryptedOfficial.add("Cessna 152 Aero Asobo");
		encryptedOfficial.add("Cessna Skyhawk Asobo");
		encryptedOfficial.add("DA40 TDI Asobo");
		encryptedOfficial.add("DV20 Asobo");

		// Premium
		encryptedOfficial.add("Boeing 787-10 Asobo");
		encryptedOfficial.add("Cessna Longitude Asobo");
		encryptedOfficial.add("SR22 Asobo");
		encryptedOfficial.add("Pipistrel Alpha Electro Asobo");
		encryptedOfficial.add("Savage Shock Ultra Asobo");

		airliners.add("Airbus A320 Neo Asobo");
		airliners.add("Boeing 747-8i Asobo");
		airliners.add("Boeing 787-10 Asobo");

		systemsList.add("Engine");
		systemsList.add("EngineFire");
		systemsList.add("Cylinder");
		systemsList.add("Coolant");
		systemsList.add("OilSystem");
		systemsList.add("OilLeak");
		systemsList.add("VacuumSystem");
		systemsList.add("Pitot");
		systemsList.add("Static");
		systemsList.add("ElectricalSystem");
		systemsList.add("Generator");
		systemsList.add("FuelPump");
		systemsList.add("FuelLeak");
		systemsList.add("APU");
		systemsList.add("APUFire");
		systemsList.add("TurbineIgnition");
		systemsList.add("HydraulicPump");
		systemsList.add("HydraulicLeak");
		systemsList.add("LeftMagneto");
		systemsList.add("RightMagneto");
		systemsList.add("Elevator");
		systemsList.add("LeftAileron");
		systemsList.add("RightAileron");
		systemsList.add("Rudder");
		systemsList.add("RearTail");
		systemsList.add("LeftFlap");
		systemsList.add("RightFlap");
		systemsList.add("LeftWing");
		systemsList.add("LeftWingTip");
		systemsList.add("RightWing");
		systemsList.add("RightWingTip");
		systemsList.add("CenterGear");
		systemsList.add("RightGear");
		systemsList.add("LeftGear");
		systemsList.add("AuxGear");
		systemsList.add("LeftBrake");
		systemsList.add("RightBrake");
		systemsList.add("BrakeSystemHydraulicSource");
		systemsList.add("AttitudeIndicator");
		systemsList.add("AirspeedIndicator");
		systemsList.add("Altimeter");
		systemsList.add("DirectionalGyro");
		systemsList.add("Compass");
		systemsList.add("TurnCoordinator");
		systemsList.add("VSI");
		systemsList.add("COMRadios");
		systemsList.add("NavRadios");
		systemsList.add("ADFRadios");
		systemsList.add("Transponder");

		systemToFailureCodeMap.put("EngineSystem",	"D8E878B03ED5314E80CD7F7C8E88914D");
		systemToFailureCodeMap.put("EngineFire", "7560338230229542B1FDD38DC1C66E16");
		systemToFailureCodeMap.put("ApuFire", "6DE7E05C3EC8A44FB7DC30B258355CCF");
		systemToFailureCodeMap.put("ApuSystem", "EA5CCD0C0F952A48B6BCF40820FA77FC");
		systemToFailureCodeMap.put("PitotSystem", "EFCDD611FE9E20458D492844093EFF9A");
		systemToFailureCodeMap.put("VacuumSystem", "68C7173F8652AC40B080EA160D38A554");
		systemToFailureCodeMap.put("NavSystem", "B23C937B4B84A64F9D06416007ED4AF7");
		systemToFailureCodeMap.put("ComSystem", "6415DB341282EE46A3B2CB3B3E95AC4E");
		systemToFailureCodeMap.put("ADFSystem", "A55DB93B35664A4B90D6801273934018");
		systemToFailureCodeMap.put("TransponderSystem", "1234B6A9747D1144B0E842E32C5AD3B0");
		systemToFailureCodeMap.put("GPSSystem", "AE5F6115E438D90D3A839CA92B6DC3");
		systemToFailureCodeMap.put("LeftAileronSystem", "6D2CE23C4D3B0449AA2815BDF9169527");
		systemToFailureCodeMap.put("RightAileronSystem", "1E612FE63C9FC740A0BD756DCF8A86A2");
		systemToFailureCodeMap.put("ElevatorSystem", "30DDFE695CBB8040A58489B8954F7C17");
		systemToFailureCodeMap.put("RudderSystem", "912F51490DC40243BFB1655CD031E35A");
		systemToFailureCodeMap.put("LeftWingSystem", "3B9EC4840BC0E44D826A81E1AF7A11CD");
		systemToFailureCodeMap.put("LeftFlapSystem", "61F24A643F60154FA7D301B40C4F2686");
		systemToFailureCodeMap.put("LeftWingTipSystem", "30CB57184BB48F409CE378797CC1F934");
		systemToFailureCodeMap.put("RightWingSystem", "6089EA6411A7504C84C4C981FBDEFE9");
		systemToFailureCodeMap.put("RightFlapSystem", "138575C0ADB52240A04B797FD6A12135");
		systemToFailureCodeMap.put("RightWingTipSystem", "09DE7461A56C8442AC0B735C5B1F0B1");
		systemToFailureCodeMap.put("RearTailSystem", "3DF24F6BC22BC74FAEB0EFADF7915EC");
		systemToFailureCodeMap.put("ElectricalSystem", "8DBAC47552B96545BACC76849A654616");
		systemToFailureCodeMap.put("Generator", "BFADE0210473CBFF23012EB6AAF749");
		systemToFailureCodeMap.put("EngineFuelPump", "9A3FD510474C9943BECA62624C95FA7E");
		systemToFailureCodeMap.put("FuelLeak", "91CF40E7685C8941AFEAAC3CDAF7B223");
		systemToFailureCodeMap.put("OilSystem", "83461181C2F8224DBAE0BE528D890A1E");
		systemToFailureCodeMap.put("OilLeak", "1113B63BDD3B92498A98CD2E9F0C19E5");
		systemToFailureCodeMap.put("TurbineIgnition", "C2C18DC111DB124DAA194AD938471C2");
		systemToFailureCodeMap.put("LeftBrakeSystem", "599A3810A48BA14090B52156EF4A35C5");
		systemToFailureCodeMap.put("RightBrakeSystem", "73E8072D9A94AA40A18F2CC189A6601E");
		systemToFailureCodeMap.put("BrakeSystemHydraulicSource", "BF9751430FA5FF47ABC538816080489B");
		systemToFailureCodeMap.put("CenterGearSystem", "368B8A9CA2DBB942B509DDE8B9AD59FA");
		systemToFailureCodeMap.put("LeftGearSystem", "0345E01CF415081ADFEEABE5B63C44B");
		systemToFailureCodeMap.put("RightGearSystem", "0D617D2B58966A4184FD3476918977");
		systemToFailureCodeMap.put("AuxGearSystem", "B303FBA304A32A8418295218B15FB");
		systemToFailureCodeMap.put("HydraulicPumpFailure", "F9CB7A7FB2A52E4E9D7D8F30FBF262C2");
		systemToFailureCodeMap.put("HydraulicLeak", "8B5B1849E34DFE47834EA03564E3621C");
		systemToFailureCodeMap.put("CoolantSystem", "35B690B4859EAD49ACDB01DBEECFF237");
		systemToFailureCodeMap.put("LeftMagneto", "9A313BA594DB2A4DA3DC38DFBD9091A4");
		systemToFailureCodeMap.put("RightMagneto", "23B5CD11E4C51A068A3DFF2E6858AC");
		systemToFailureCodeMap.put("StaticSystem", "2C4143A26D954447929028EFD0634A8B");
		systemToFailureCodeMap.put("FlyByWire_ELAC", "E5F9A2BD86B3FE4B89D3E1E61E48B6C");
		systemToFailureCodeMap.put("FlyByWire_FAC", "783497C19E53FB48AEB881FA2B5710AB");
		systemToFailureCodeMap.put("FlyByWire_SEC", "C539839D9022484CA7AF4575B49EAD3A");
		systemToFailureCodeMap.put("HoistMotor", "F4FE39AD7630E6418C7791D08B1C660");
		systemToFailureCodeMap.put("SlingCable", "F4637D4668470A4A96BF87BED627811D");
		systemToFailureCodeMap.put("Cylinder", "C37D80E3C7DEEC4CA53E8B2FD2FF9F21");
		systemToFailureCodeMap.put("AirspeedGauge", "816DCB2925F98B44AE0AE496E8217BC3");
		systemToFailureCodeMap.put("AltimeterGauge", "0FE25A6F5BC75E4CA45A02DF04AE01A0");
		systemToFailureCodeMap.put("AttitudeGauge", "F3C0CD056C26AE43B92BA50816ECDB23");
		systemToFailureCodeMap.put("FuelGauge", "40E80DE5C3B34A4381B1D50060EF7D23");
		systemToFailureCodeMap.put("DGGauge", "5D7C0C1B7E910D46BCEB6A60EDE60B59");
		systemToFailureCodeMap.put("CompassGauge", "DD4CC891F18BE04AB46BD2702DA4D460");
		systemToFailureCodeMap.put("TurncoordGauge", "61A7C72937FD9F4AB0607041F1AE0561");
		systemToFailureCodeMap.put("VSIGauge", "B877841ED460654AAC060D81AA4A1A57");
	}

	public String[] getPaths() {
		String appDataLocal = System.getProperty("user.home") + File.separator + "AppData\\Local";
		String appDataRoaming = System.getProperty("user.home") + File.separator + "AppData\\Roaming";
		List<String> userCfgDirs = new ArrayList<>();

		// Roaming
		userCfgDirs.add(appDataRoaming + File.separator + "FlightSimulator\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "Flight Simulator\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "Microsoft Flight Simulator\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "Microsoft FlightSimulator\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "MicrosoftFlightSimulator\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "FlightSimulator_8wekyb3d8bbwe\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "FlightSimulatorKHAlpha_8wekyb3d8bbwe\\UserCfg.opt");
		userCfgDirs.add(appDataRoaming + File.separator + "FlightSimulatorFlightSimDisc_8wekyb3d8bbwe\\UserCfg.opt");

		// Local
		userCfgDirs.add(appDataLocal + File.separator + "Packages\\Microsoft.FlightSimulator_8wekyb3d8bbwe\\LocalCache\\UserCfg.opt");
		userCfgDirs.add(appDataLocal + File.separator + "Packages\\Microsoft.FlightSimulatorKHAlpha_8wekyb3d8bbwe\\LocalCache\\UserCfg.opt");
		userCfgDirs.add(appDataLocal + File.separator + "Packages\\Microsoft.KHAlpha_8wekyb3d8bbwe\\LocalCache\\UserCfg.opt");
		userCfgDirs.add(appDataLocal + File.separator + "Packages\\Microsoft.FlightSimulatorFlightSimDisc_8wekyb3d8bbwe\\LocalCache\\UserCfg.opt");

		// Now look for it!
		for (String path : userCfgDirs) {
			File f = new File(path);
			if (f.exists()) {
				String foundPath = findPackagesPath(f);
				if (foundPath != null)  {
					return new String[] {foundPath + File.separator + "Community",
							foundPath + File.separator + "Official"};
				}
			}
		}
		return null;
	}

	private static String findPackagesPath(File f) {
		String foundPath = null;
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(f));
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String lineNoSpaces = line.replace(" " ,  "");

				if (lineNoSpaces.indexOf("InstalledPackagesPath\"") == 0) {
					String[] split = line.split("\"");
					foundPath = split[1].trim();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();      
		}
		finally {
			try { in.close() ; } catch(Exception e) { /* ignore */ }  
		}
		return foundPath;
	}
}
