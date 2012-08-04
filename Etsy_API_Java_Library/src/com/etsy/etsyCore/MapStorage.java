package com.etsy.etsyCore;

import java.util.HashMap;
import java.util.Map;

import org.scribe.model.Token;

/**
 * Token storage that uses a Map object to hold the tokens.
 */
public class MapStorage extends BaseTokenStorage{
	
	private HashMap<String, Token> map;
	
	/**
	 * Constructor.
	 */
	public MapStorage(){
		map = new HashMap<String, Token>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Token getToken(String key) {
		return map.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putToken(String key, Token token) {
		map.put(key, token);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteToken(String key){
		return map.remove(key) != null;
	}
	
	/**
	 * Returns the map used by this class.
	 * @return The map containing the tokens and keys.
	 */
	public Map<String, Token> getMap(){
		return map;
	}
}
