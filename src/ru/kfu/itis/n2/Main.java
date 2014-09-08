package ru.kfu.itis.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static String notLeapYears() {
		String returning = "(...[13579])";
		returning += "|(..[02468][26])|(..[13579][048])";
		
//		for (int i = 2; i < 100; i += 4) {
//			returning += "|";
//			returning += (i / 10 == 0) ? ("(..0" + i + ")") : ("(.." + i + ")");
//		}
		// for (int i = 100; i < 10000; i += 100) {
		//
		// if (i % 400 != 0) {
		// returning += "|";
		// returning += (i / 1000 == 0) ? ("(0" + i + ")")
		// : ("(" + i + ")");
		// }
		// //([0,2,4,6,8][1,2,3,5,6,7,9]00)|([1,3,5,7,9][0,1,3,4,5,7,8,9]00)
		//
		// }
		returning += "|([02468][1235679]00)|([13579][01345789]00)";
		// (...[13579])|(..02)|(..06)|(..10)|(..14)|(..18)|(..22)|(..26)|(..30)|(..34)|(..38)|(..42)|(..46)|(..50)|(..54)|(..58)|(..62)|(..66)|(..70)|(..74)|(..78)|(..82)|(..86)|(..90)|(..94)|(..98)|(0100)|(0200)|(0300)|(0500)|(0600)|(0700)|(0900)|(1000)|(1100)|(1300)|(1400)|(1500)|(1700)|(1800)|(1900)|(2100)|(2200)|(2300)|(2500)|(2600)|(2700)|(2900)|(3000)|(3100)|(3300)|(3400)|(3500)|(3700)|(3800)|(3900)|(4100)|(4200)|(4300)|(4500)|(4600)|(4700)|(4900)|(5000)|(5100)|(5300)|(5400)|(5500)|(5700)|(5800)|(5900)|(6100)|(6200)|(6300)|(6500)|(6600)|(6700)|(6900)|(7000)|(7100)|(7300)|(7400)|(7500)|(7700)|(7800)|(7900)|(8100)|(8200)|(8300)|(8500)|(8600)|(8700)|(8900)|(9000)|(9100)|(9300)|(9400)|(9500)|(9700)|(9800)|(9900)
		//(0000)|(..04)|(..08)|(..12)|(..16)|(..20)|(..24)|(..28)|(..32)|(..36)|(..40)|(..44)|(..48)|(..52)|(..56)|(..60)|(..64)|(..68)|(..72)|(..76)|(..80)|(..84)|(..88)|(..92)|(..96)|(0400)|(0800)|(1200)|(1600)|(2000)|(2400)|(2800)|(3200)|(3600)|(4000)|(4400)|(4800)|(5200)|(5600)|(6000)|(6400)|(6800)|(7200)|(7600)|(8000)|(8400)|(8800)|(9200)|(9600)
		System.out.println(returning);
		return returning;
	}

	public static String leapYears() {
		String returning = "";
		returning +="(..[02468][48])|(..[13579][26])";
//		for (int i = 4; i < 100; i += 4) {
//			returning += "|";
//			returning += (i / 10 == 0) ? ("(..0" + i + ")") : ("(.." + i + ")");
//		}

//		for (int i = 400; i < 10000; i += 400) {
//
//			returning += "|";
//			returning += (i / 1000 == 0) ? ("(0" + i + ")") : ("(" + i + ")");
//			// //([0,2,4,6,8][48]00)|([1,3,5,7,9][26]00)
//
//		}
		returning += "|([02468][048]00)|([13579][26]00)";
		System.out.println(returning);
		return returning;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// a
			Pattern p = Pattern.compile("(([01][0-9])|(2[0-3])):[0-5][0-9]");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			Matcher m = p.matcher("asvasv23:00ascasc25:003312:510");
			while (m.find() != false) {
				System.out.println(m.group());
			}
			// end a

			// b
			String regexForMonthsWith31Days = "((0[1-9])|([1-2][0-9])|(3[01]))-((01)|(03)|(05)|(07)|(08)|(10)|(12))-([0-9]{4})";
			String regexForMonthsWith30Days = "((0[1-9])|([1-2][0-9])|(30))-((04)|(06)|(09)|(11))-([0-9]{4})";
			String regexForFebruaryInNotLeapYear = "((0[1-9])|(1[0-9])|(2[0-8]))-02-("
					+ notLeapYears() + ")";
			String regexForFebruaryInLeapYear = "((0[1-9])|([1-2][0-9]))-02-("
					+ leapYears() + ")";

			p = Pattern.compile("(" + regexForMonthsWith31Days + ")|(" + regexForMonthsWith30Days + ")|(" + regexForFebruaryInNotLeapYear + ")|(" + regexForFebruaryInLeapYear + ")");
			m = p.matcher("asdasca66-03-2012ascas");
			System.out.println(p.pattern());
			// end b

			 System.out.println(m.find());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
