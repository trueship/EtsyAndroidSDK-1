package com.etsy.etsyAndroid;

import org.scribe.model.Token;

import com.etsy.etsyCore.BaseTokenStorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * A storage class for tokens that uses Android Shared Preferences.
 */
public class SharedPreferencesStorage extends BaseTokenStorage{
	private final String PREFS_NAME = "EtsyApiPrefs";
	private final String TOKEN_KEY_SUFFIX = "etsyAndroidLibraryAccessToken";
	private final String SECRET_KEY_SUFFIX = "etsyAndroidLibraryAccessSecret";
	private SharedPreferences prefs;
	/**
	 * Constructor.
	*/
	public SharedPreferencesStorage(Activity activity){
		prefs = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Token getToken(String key) {
		String tokenString = prefs.getString(key + TOKEN_KEY_SUFFIX, "");
		String secretString = prefs.getString(key + SECRET_KEY_SUFFIX, "");
		
		if(!tokenString.equals("") && !secretString.equals("")){
			return new Token(tokenString, secretString);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putToken(String key, Token token) {
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(key + TOKEN_KEY_SUFFIX, token.getToken());
		editor.putString(key + SECRET_KEY_SUFFIX, token.getSecret());
		editor.commit();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteToken(String key){
		boolean containsTokens = false;
		if(prefs.contains(key + TOKEN_KEY_SUFFIX) && prefs.contains(key + TOKEN_KEY_SUFFIX)){
			containsTokens = true;
		}
		
		SharedPreferences.Editor editor = prefs.edit();
		editor.remove(key + TOKEN_KEY_SUFFIX);
		editor.remove(key + TOKEN_KEY_SUFFIX);
		editor.commit();
		return containsTokens;
	}
}
