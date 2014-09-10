package ru.kfu.itis.truehomework;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern;
		Matcher matcher;

		// 1
		System.out.println("1:");
		pattern = Pattern.compile("1+(1*01{1,}){2,}[01]");
		matcher = pattern.matcher("111110101111010110");
		System.out.println(matcher.matches());

		// end 1

		// 2a
		System.out.println("\n2a:");
		pattern = Pattern.compile("[0-9A-Fa-f]*");
		matcher = pattern.matcher("a1F85");
		System.out.println(matcher.matches());

		// end 2a

		// 2b
		System.out.println("\n2b:");
		pattern = Pattern.compile("[1-9&&[^5]]\\d{5}");
		matcher = pattern.matcher("752525");
		System.out.println(matcher.matches());

		// end 2b

		// 2c
		System.out.println("\n2c:");
		pattern = Pattern
				.compile("[a-z0-9.]{1,}://([a-z0-9A-Z]{1,}.[a-z0-9A-Z]{1,}){1,}[.][\\w]{2,}([/][a-z0-9A-Z_.?=-]{1,})*");
		matcher = pattern.matcher("http://www.google.com/it/just/works");
		System.out.println(matcher.matches());

		// end 2c

		// 3
		System.out.println("\n3:");
		
		
		LinkedList<Pattern> p = new LinkedList<Pattern>();
		p.add(Pattern.compile(".{8,32}"));
		p.add(Pattern.compile(".*[A-Z].*"));
		p.add(Pattern.compile(".*[a-z].*"));
		p.add(Pattern.compile(".*[0-9].*"));
		p.add(Pattern.compile(".*[.].*"));
		String s = "WDVWDVSWDVVWEVWV125.h";
		boolean b = true;
		for(int i = 0; i<p.size() && b;i++){
			if(!p.get(i).matcher(s).matches()){
				b = false;
			}
		}
		
		System.out.println(b);
		// end 3

	}

}
