package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
