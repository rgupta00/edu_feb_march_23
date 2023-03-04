package com.demo;
//When magician is showing the maginc then Audiance must do clapping after 

import org.springframework.stereotype.Component;

//JP (Joint point ) and PC(point cut)

@Component(value = "magician")
public class Magician {

	public String doMagic() {
		System.out.println("abra ka dabra...");

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (1 == 1)
//			throw new MagicianHeartAttack("call the dr now..");

		return "rabbit out of Hat";

	}

	
	public String doEating() {
		System.out.println("opening the LB...");

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (1 == 1)
//			throw new MagicianHeartAttack("call the dr now..");

		return "rabbit out of Hat";

	}
	
}
