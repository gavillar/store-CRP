package com.example.store.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static <T> T toJson(final Object value, Class<T> valueType) {
		try {
			final ObjectMapper objectMapper = new ObjectMapper();
			final String json = objectMapper.writeValueAsString(value);
			return objectMapper.readValue(json, valueType);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
