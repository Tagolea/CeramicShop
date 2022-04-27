package api;

import java.util.Random;

public class RandomKey {
	
	public static String createKey() {
		
		Random rand=new Random();
		char ch=' ';
		String randPW="";
		int num=rand.nextInt(99999)+10000;
		
		for(int i=0; i<3; i++) {
			ch=(char) ((char)rand.nextInt(26)+65);
			randPW+=ch;
		}
		
		return randPW+=num;
	}
}
