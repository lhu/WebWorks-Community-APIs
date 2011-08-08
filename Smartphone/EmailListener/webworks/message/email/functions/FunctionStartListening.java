package webworks.message.email.functions;

import webworks.message.email.impl.EmailListenerManager;
import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import net.rim.device.api.script.ScriptableFunction;

public class FunctionStartListening extends ScriptableFunctionBase {

	public static final String NAME = "startListening";
	
	private EmailListenerManager _manager;

	public FunctionStartListening(EmailListenerManager emailListenerManager) {
		_manager = emailListenerManager;
	}

//	public Object invoke(Object thiz, Object[] args) throws Exception {
//		if(isNullOrEmpty(args)) {
//			throw new IllegalArgumentException("Missing argument 1: expecting reference to callback.");
//		}
//		
//		if(!(args[0] instanceof ScriptableFunction)) {
//			throw new IllegalArgumentException("Invalid argument 1: expecting a callback function.");
//		}
//		
//		_manager.startListening((String)args[0], (ScriptableFunction)args[1]);
//		
//		return UNDEFINED;
//	}

    public Object execute( Object thiz, Object[] args ) throws Exception {
    	
    		if(isNullOrEmpty(args)) {
    			throw new IllegalArgumentException("Missing arguments: expecting reference to service name and callback.");
    		}
    		
    		if(!(args[1] instanceof ScriptableFunction)) {
    			throw new IllegalArgumentException("Invalid argument 1: expecting a callback function.");
    		}
    		

    		//((ScriptableFunction)args[1]).invoke(null, new Object[] { "calling _manager.startListening" });

    		
    		_manager.startListening((String)args[0], (ScriptableFunction)args[1]);
    		
    		//((ScriptableFunction)args[1]).invoke(null, new Object[] { "called _manager.startListening about to return" });

    	
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
