package ru.kfu.itis.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			//a
			Pattern p = Pattern.compile("(([01][0-9])|(2[0-3])):[0-5][0-9]");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Matcher m = p.matcher("asvasv23:00ascasc25:003312:510");
			while(m.find()!=false){
				System.out.println(m.group());
			}
			//end a
			
			//b
			
			//end b
			//System.out.println(m.group(2));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
