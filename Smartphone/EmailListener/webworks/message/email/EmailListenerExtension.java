package webworks.message.email;

import org.w3c.dom.Document;

import webworks.message.email.impl.EmailListenerManager;
import webworks.message.email.namespace.EmailListenerNamespace;


import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.script.ScriptEngine;
import net.rim.device.api.web.WidgetConfig;
import net.rim.device.api.web.WidgetExtension;



public class EmailListenerExtension implements WidgetExtension {

    
	public String[] getFeatureList() {
		return new String[] { EmailListenerNamespace.NAME };
	}

	public void loadFeature(String feature, String version, Document doc, ScriptEngine scriptEngine) throws Exception {
		if(scriptEngine == null) {
			throw new IllegalArgumentException("scriptEngine should not be null");
		}
		
		if(EmailListenerNamespace.NAME.equals(feature)) {
			scriptEngine.addExtension(EmailListenerNamespace.NAME, new EmailListenerNamespace(new EmailListenerManager()));
		}

	}

	public void register(WidgetConfig widgetConfig, BrowserField browserField) {
		//Nothing to do here...
	}

	public void unloadFeatures(Document doc) {
		//Nothing to do here either...
	}

}
