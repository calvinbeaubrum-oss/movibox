package com.bykv.vk.openvk.preload.a.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<? super T> f25553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Type f25554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25555c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type typeA = com.bykv.vk.openvk.preload.a.b.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f25554b = typeA;
        this.f25553a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(typeA);
        this.f25555c = this.f25554b.hashCode();
    }

    private a(Type type) {
        Type typeA = com.bykv.vk.openvk.preload.a.b.a.a((Type) com.bykv.vk.openvk.preload.falconx.a.a.a(type));
        this.f25554b = typeA;
        this.f25553a = (Class<? super T>) com.bykv.vk.openvk.preload.a.b.a.b(typeA);
        this.f25555c = this.f25554b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final Class<? super T> a() {
        return this.f25553a;
    }

    public final Type b() {
        return this.f25554b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && com.bykv.vk.openvk.preload.a.b.a.a(this.f25554b, ((a) obj).f25554b);
    }

    public final int hashCode() {
        return this.f25555c;
    }

    public final String toString() {
        return com.bykv.vk.openvk.preload.a.b.a.c(this.f25554b);
    }
}
