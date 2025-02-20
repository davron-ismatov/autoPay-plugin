package com.example.autopayplugin.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DynamicDtoGenerator {

    public static <T> T generateDefaultObject(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            processFields(instance, clazz);

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate default object for class: " + clazz.getName() + " " + e.getMessage());
        }
    }

    private static <T> void processFields(T instance, Class<?> clazz) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();

            Object defaultValue = getDefaultValueForType(fieldType);
            if (defaultValue != null) {
                field.set(instance, defaultValue);
            }
        }

        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            processFields(instance, superclass);
        }
    }

    private static Object getDefaultValueForType(Class<?> type) {
        if (type.isArray()) {
            return Array.newInstance(type.getComponentType(), 0);
        }

        if (type == Boolean.class || type == boolean.class) {
            return false;
        } else if (type == Integer.class || type == int.class) {
            return 0;
        } else if (type == Long.class || type == long.class) {
            return 0L;
        } else if (type == Double.class || type == double.class) {
            return 0.0;
        } else if (type == Float.class || type == float.class) {
            return 0.0f;
        } else if (type == Character.class || type == char.class) {
            return '\u0000';
        } else if (type == String.class) {
            return "test";
        } else if (type == Instant.class) {
            return Instant.now();
        } else if (type == List.class) {
            return new ArrayList<>();
        } else if (type == Set.class) {
            return new HashSet<>();
        } else if (type == Map.class) {
            return new HashMap<>();
        }

        if (!type.isEnum() && !type.isPrimitive()) {
            return generateDefaultObject(type);
        }

        return null;
    }
}