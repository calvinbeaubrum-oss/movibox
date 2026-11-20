package com.alibaba.fastjson.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GenericArrayTypeImpl implements GenericArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f15498a;

    public GenericArrayTypeImpl(Type type) {
        this.f15498a = type;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return this.f15498a.equals(((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f15498a;
    }

    public int hashCode() {
        return this.f15498a.hashCode();
    }

    public String toString() {
        Type genericComponentType = getGenericComponentType();
        StringBuilder sb2 = new StringBuilder();
        if (genericComponentType instanceof Class) {
            sb2.append(((Class) genericComponentType).getName());
        } else {
            sb2.append(genericComponentType.toString());
        }
        sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb2.toString();
    }
}
