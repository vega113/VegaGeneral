package com.vegalabs.general.client.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.Window;

public class VegaUtilsImpl implements VegaUtils {
	private static Map<String,String> state = new HashMap<String, String>();
	private static Map<String,String> privateState = new HashMap<String, String>();
	@Override
	public void adjustHeight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alert(String msg) {
		Window.alert(msg);

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAllStaticMessages() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissStaticMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void putToPrivateSate(String key, String value) {
		privateState.put(key, value);

	}

	@Override
	public void reportEvent(String string, String string2, String projectId,
			int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reportPageview(String typeOfrecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestNavigateTo(String view, String optParams) {
		// TODO Auto-generated method stub

	}

	@Override
	public String retrFromPrivateSate(String key) {
		return privateState.get(key);
	}

	@Override
	public String retrFromState(String key) {
		return state.get(key);
	}

	@Override
	public String retrHostId() {
		return "vega113@googlewave.com";
	}

	@Override
	public String retrUserId() {
		return "vega113@googlewave.com";
	}

	@Override
	public String retrUserName() {
		return "Yuri";
	}

	@Override
	public void showStaticMessage(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showSuccessMessage(String msg, int seconds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showTimerMessage(String msg, int seconds) {
		// TODO Auto-generated method stub

	}

}
