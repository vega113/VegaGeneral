package com.vegalabs.general.client.objects;

public class GoogleAnalyticsId {
	String analyticsId;

	public GoogleAnalyticsId(String analyticsId) {
		this.analyticsId = analyticsId;
	}

	public String getAnalyticsId() {
		return analyticsId;
	}

	@Override
	public String toString() {
		return "AnalyticsId [analyticsId=" + analyticsId + "]";
	}
}
