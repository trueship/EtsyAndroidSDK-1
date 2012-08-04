package com.etsy.etsyandroid.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.scribe.model.Token;

import com.etsy.etsyCore.MapStorage;

public class MapStorageTest {
	MapStorage mapStorage;
	
	@Before
	public void setup(){
		mapStorage = new MapStorage();
	}

	@Test
	public void testPutGetToken() {
		Token token = new Token("Test Token", "Test Secret");
		mapStorage.putToken("Test", token);
		assertEquals(mapStorage.getToken("Test"), token);
	}
	
	@Test
	public void testGetMap() {
		Token token = new Token("Test Token", "Test Secret");
		mapStorage.putToken("Test", token);
		Map<String, Token> map = mapStorage.getMap();
		
		assertEquals(map.containsKey("Test"), true);
	}

}
