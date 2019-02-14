package com.qa.util;

import com.owlike.genson.*;

public class JSONUtil {

	private Genson gen;

	public JSONUtil() {
		this.gen = new Genson();
	}

	public String getJSONForObject(Object obj) {
		return gen.serialize(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gen.deserialize(jsonString, clazz);
	}
}