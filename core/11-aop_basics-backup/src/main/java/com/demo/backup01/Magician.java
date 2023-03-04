package com.demo.backup01;
//When magician is showing the maginc then Audiance must do clapping after 

import org.springframework.stereotype.Component;

@Component(value = "magician")
public class Magician {

	public void doMagic() {
		System.out.println("abra ka dabra...");
	}
}
