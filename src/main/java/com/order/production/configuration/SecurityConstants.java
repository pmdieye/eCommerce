package com.order.production.configuration;

public final class SecurityConstants {
	public static final String SECRET_TOKEN_KEY = "Iho2o3rpa1otiSpn2na2Ua1scahs16faws";
	//public static final String SECRET_TOKEN_KEY = "dieyemamadou86gmailcom";
	public static final Long TOKEN_TTL = 12 * 60 * 60 * 1000L; // 12 hours
	public static final String HEADER_STRING="Authorisation";
	public static final String TOKEN_PREFIX="Bearer ";

	private SecurityConstants() {}
}
