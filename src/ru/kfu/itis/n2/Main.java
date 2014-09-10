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

		// for (int i = 2; i < 100; i += 4) {
		// returning += "|";
		// returning += (i / 10 == 0) ? ("(..0" + i + ")") : ("(.." + i + ")");
		// }
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
		// (0000)|(..04)|(..08)|(..12)|(..16)|(..20)|(..24)|(..28)|(..32)|(..36)|(..40)|(..44)|(..48)|(..52)|(..56)|(..60)|(..64)|(..68)|(..72)|(..76)|(..80)|(..84)|(..88)|(..92)|(..96)|(0400)|(0800)|(1200)|(1600)|(2000)|(2400)|(2800)|(3200)|(3600)|(4000)|(4400)|(4800)|(5200)|(5600)|(6000)|(6400)|(6800)|(7200)|(7600)|(8000)|(8400)|(8800)|(9200)|(9600)
		// System.out.println(returning);
		return returning;
	}

	public static String leapYears() {
		String returning = "";
		returning += "(..[02468][48])|(..[13579][26])";
		// for (int i = 4; i < 100; i += 4) {
		// returning += "|";
		// returning += (i / 10 == 0) ? ("(..0" + i + ")") : ("(.." + i + ")");
		// }

		// for (int i = 400; i < 10000; i += 400) {
		//
		// returning += "|";
		// returning += (i / 1000 == 0) ? ("(0" + i + ")") : ("(" + i + ")");
		// // //([0,2,4,6,8][48]00)|([1,3,5,7,9][26]00)
		//
		// }
		returning += "|([02468][048]00)|([13579][26]00)";
		// System.out.println(returning);
		return returning;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// a
			System.out.println("a:");
			Pattern p = Pattern.compile("(([01][0-9])|(2[0-3])):[0-5][0-9]");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			Matcher m = p.matcher("asvasv23:00ascasc25:003312:510");
			while (m.find() != false) {
				System.out.println(m.group());
			}
			// end a

			// b
			System.out.println("\nb:");
			String regexForMonthsWith31Days = "((0[1-9])|([1-2][0-9])|(3[01]))-((01)|(03)|(05)|(07)|(08)|(10)|(12))-([0-9]{4})";
			String regexForMonthsWith30Days = "((0[1-9])|([1-2][0-9])|(30))-((04)|(06)|(09)|(11))-([0-9]{4})";
			String regexForFebruaryInNotLeapYear = "((0[1-9])|(1[0-9])|(2[0-8]))-02-("
					+ notLeapYears() + ")";
			String regexForFebruaryInLeapYear = "((0[1-9])|([1-2][0-9]))-02-("
					+ leapYears() + ")";

			p = Pattern.compile("(" + regexForMonthsWith31Days + ")|("
					+ regexForMonthsWith30Days + ")|("
					+ regexForFebruaryInNotLeapYear + ")|("
					+ regexForFebruaryInLeapYear + ")");
			m = p.matcher("asdasca06-03-2012ascas06-06-2006asdcvz29-02-201229-02-2014");
			while (m.find()) {
				System.out.println(m.group());
			}
			// System.out.println(p.pattern());
			// end b

			// c
			System.out.println("\nc:");
			p = Pattern.compile("[^./:*?\"<>|\\\\]*[.]((txt)|(csv))"); // Áðåä.
																		// Ñ \\
																		// èñêëþ÷åíèå,
																		// ñ
																		// \\\\
																		// - íåò
			m = p.matcher("ascascasc.ascasc.as\"cacs.txtascasasc.dcssdc.csvascasadsc?s.txt");
			while (m.find()) {
				System.out.println(m.group());
			}
			// end c

			// d
			System.out.println("\nd:");
			String newRegexForMonthsWith31Days = "(([Jj]anuary)|([Mm]arch)|([Mm]ay)|([Jj]uly)|([Aa]ugust)|([Oo]ctober)|([Dd]ecember)) ((0[1-9])|([1-2][0-9])|(3[01])), ([0-9]{4})";
			String newRegexForMonthsWith30Days = "(([Aa]pril)|([Jj]uny)|([Ss]eptember)|([Nn]ovember)) ((0[1-9])|([1-2][0-9])|(30)), ([0-9]{4})";
			String newRegexForFebruaryInNotLeapYear = "[Ff]ebruary ((0[1-9])|(1[0-9])|(2[0-8])), ("
					+ notLeapYears() + ")";
			String newRegexForFebruaryInLeapYear = "[Ff]ebruary ((0[1-9])|([1-2][0-9])), ("
					+ leapYears() + ")";
			p = Pattern.compile("(" + newRegexForMonthsWith31Days + ")|("
					+ newRegexForMonthsWith30Days + ")|("
					+ newRegexForFebruaryInNotLeapYear + ")|("
					+ newRegexForFebruaryInLeapYear + ")");
			m = p.matcher("asdascaMarch 06, 2012ascasjuny 06, 2006asdcvzfebruary 29, 2012february 29, 2014");
			while (m.find()) {
				System.out.println(m.group());
			}
			// end d

			// e
			System.out.println("\ne:");
			p = Pattern.compile("[+]7[0-9]{10}");
			m = p.matcher("ascascasc.ascasc+79053776175qwdqwd+7554wefwe654561315555+79051168767");
			while (m.find()) {
				System.out.println(m.group());
			}

			// end e

			// f
			System.out.println("\nf:");
			p = Pattern
					.compile("([\\w]|[.-]){3,}[@]([a-z0-9]){3,}[.]([a-z]){2,}");
			m = p.matcher("qqw.dMas-ter_gip@gmail.comsadasd.ascas.asaasdcas.ascas@asc.sr");//
			while (m.find()) {
				System.out.println(m.group());
			}

			// end f

			// g
			System.out.println("\ng:");
			p = Pattern
					.compile("((([1-9])|([1-9][0-9])|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([1-9])|([1-9][0-9])|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))");
			m = p.matcher("ascascaxx128.s14.12.255.222256.198.78.1.255.248");// ðàáîòàåò
																				// ñòðàííî
			while (m.find()) {
				System.out.println(m.group());
			}

			// end g

			// h
			System.out.println("\ng:");
			p = Pattern
					.compile("[ÀÂÅÊÌÍÎÐÑÒÓÕ](\\d){3}[ÀÂÅÊÌÍÎÐÑÒÓÕ]{2}((\\d){2}|1(02|16|18|21|25|38|50|52|54|59|61|63|64|73|74|77|97|99))");
			m = p.matcher("ôûñôñ÷Ô888ÎÎ16À256ÐÐ16");// À,
													// Â,
													// Å,
													// Ê,
													// Ì,
													// Í,
													// Î,
													// Ð,
													// Ñ,
													// Ò,
													// Ó,
													// Õ
			while (m.find()) {
				System.out.println(m.group());
			}

			// end h

			// System.out.println(m.find());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
