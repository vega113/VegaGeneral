package com.vegalabs.general.client.objects;

/**
 * the entry point gadget should implement provider interface for this class
 * set the app domain id - it is needed for proxy
 * @author vega
 *
 */
public class AppDomainId {
	
	String id = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppDomainId [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	

}
