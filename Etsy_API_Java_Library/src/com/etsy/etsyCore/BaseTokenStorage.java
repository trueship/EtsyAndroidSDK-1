package com.etsy.etsyCore;

import org.scribe.model.Token;

/**
 * 
 * Abstract class to extend to create storage classes for tokens.
 */

public abstract class BaseTokenStorage {
	
	/**
	 * Retrieve a token from storage.
	 * @param key The key that the token was stored with.
	 * @return The token if it exists, otherwise null.
	 */
	public abstract Token getToken(String key);
	
	/**
	 * Stores a token with a provided key.
	 * @param key The key to store token with.
	 * @param token The token to store.
	 */
	public abstract void putToken(String key, Token token);
	
	/**
	 * Deletes a token from storage.
	 * @param key The key that the token was stored with.
	 * @return True if token existed and deleted, false if the token was not found.
	 */
	public abstract boolean deleteToken(String key);
}
