package CodenameFrozenOmega;

import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;

public class Listening implements TickListener{
	int counting=0;
	public Listening(){
		
	}

	@Override
	public void onTick(float deltaTime) {
		System.out.println("Object age: "+counting);
		counting++;
	}
}
