package com.demo.backup;

import com.demo.AudianceAspect;
import com.demo.Magician;

//When magician is showing the maginc then Audiance must do clapping after 
public class MagicianProxy extends Magician {

	private AudianceAspect audiance=new AudianceAspect();
	
	
	public void doMagic() {
		super.doMagic();
		audiance.clapping();
	}
}
