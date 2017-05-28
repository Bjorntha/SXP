package protocol.impl;


import java.util.HashMap;

import model.entity.ElGamalKey;
import protocol.impl.sigma.ProtocolSignFailer;

/**
 * 
 * @author Nathanaël Eon
 *
 * Hack of SigmaEstablisher to produce fails
 */
public class SigmaEstablisherFailer extends SigmaEstablisher{

	public int failingRound;
	
	public SigmaEstablisherFailer(ElGamalKey k, HashMap<ElGamalKey, String> uris, int f, boolean liar) {
		super(k, uris);
		this.failingRound = f;
	}
	
	@Override
	protected void sign(){
		sigmaEstablisherData.setProtocolStep(new ProtocolSignFailer(this, senderK, this.establisherService, peer, uris, this.contract));
		sigmaEstablisherData.getProtocolStep().setupListener();
		sigmaEstablisherData.getProtocolStep().sendMessage();
	}
}
