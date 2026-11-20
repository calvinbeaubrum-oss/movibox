package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ParameterizedTypeImpl implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type[] f15499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f15501c;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.f15499a = typeArr;
        this.f15500b = type;
        this.f15501c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
        if (!Arrays.equals(this.f15499a, parameterizedTypeImpl.f15499a)) {
            return false;
        }
        Type type = this.f15500b;
        if (type == null ? parameterizedTypeImpl.f15500b != null : !type.equals(parameterizedTypeImpl.f15500b)) {
            return false;
        }
        Type type2 = this.f15501c;
        Type type3 = parameterizedTypeImpl.f15501c;
        if (type2 != null) {
            return type2.equals(type3);
        }
        return type3 == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f15499a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f15500b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f15501c;
    }

    public int hashCode() {
        Type[] typeArr = this.f15499a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f15500b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f15501c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
