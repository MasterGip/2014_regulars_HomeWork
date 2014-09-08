package ru.kfu.itis.n1.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			Pattern p = Pattern.compile(".*[Jj]ava.*");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String s = br.readLine();
			System.out.println(s.matches(p.pattern()));
			
			p = Pattern.compile("(.{2}0.*)");
			Pattern p2 = Pattern.compile("((.*[0-9].*){3})");
			s = br.readLine();
			if(s.matches(p.pattern()) && s.matches(p2.pattern())){
				System.out.println(true);
			}else{
				System.out.println(false);
			}
					
			p = Pattern.compile("([^0]*0[^0]*){10}");
			System.out.println(br.readLine().matches(p.pattern()));
			
			p = Pattern.compile(".{1,3}");
			System.out.println(br.readLine().matches(p.pattern()));
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
		

	}

}
