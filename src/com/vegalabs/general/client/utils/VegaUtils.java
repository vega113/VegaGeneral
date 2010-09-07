package com.vegalabs.general.client.utils;




public interface VegaUtils {

	/**
	 * show new static message
	 * @param msg
	 */
	public abstract void showStaticMessage(String msg);
	/**
	 * dismiss the last shown static message 
	 */
	public abstract void dismissStaticMessage();
	/**
	 * dismiss all shown static message 
	 */
	public abstract void dismissAllStaticMessages();

	public abstract void showSuccessMessage(String msg, int seconds);

	public abstract void reportPageview(String typeOfrecord);

	public abstract String retrUserId();

	public abstract String retrUserName();

	public abstract void adjustHeight();

	public abstract void alert(String msg);

	public abstract void dismissAlert();

	
	public abstract void putToPrivateSate(String key, String value);
	
	public abstract String retrFromPrivateSate(String key);
	
	public abstract String retrHostId();

	public abstract void showTimerMessage(String msg, int seconds);

	public abstract void requestNavigateTo(String view, String optParams);
	public abstract String retrFromState(String stringValue);
	public abstract void reportEvent(String eventName, String action, String label, int value);
	public abstract void putToState(String key, String value);
	public abstract String retrUserThumbnailUrl();

}