package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t11, Type type, JsonSerializationContext jsonSerializationContext);
}
