package webworks.message.email.functions;

import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import webworks.message.email.impl.EmailListenerManager;
import net.rim.device.api.script.ScriptableFunction;

public class FunctionStopListening extends ScriptableFunctionBase {
	
	public static final String NAME = "stopListening";
	
	private EmailListenerManager _manager;

	public FunctionStopListening(EmailListenerManager emailListenerManager) {
		_manager = emailListenerManager;
	}
	
//	public Object invoke(Object thiz, Object[] args) throws Exception {
//		_manager.stopListening();
//		
//		return UNDEFINED;
//	}
	
	 public Object execute( Object thiz, Object[] args ) throws Exception {
	    	
 		if(isNullOrEmpty(args)) {
 			throw new IllegalArgumentException("Missing arguments: expecting reference to service name and callback.");
 		}
 		
 		_manager.stopListening((String)args[0], (ScriptableFunction)args[1]);
 		
 		
 	
 	return UNDEFINED;
 }
	 private boolean isNullOrEmpty(Object[] args) {
			return args == null || args.length == 0;
		}
		
	    /**
	     * @see net.rim.device.api.web.jse.base.ScriptableFunctionBase
	     */
	    protected FunctionSignature[] getFunctionSignatures() {
	        FunctionSignature fs = new FunctionSignature(2);
	        fs.addParam(String.class, true);
	        fs.addParam(ScriptableFunction.class, false);
	        return new FunctionSignature[] { fs };
	    } 

}
