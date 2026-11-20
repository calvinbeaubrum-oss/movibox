package com.amazonaws.services.s3.model;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class CORSRule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<AllowedMethods> f15998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f15999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f16001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f16002f;

    /* JADX INFO: compiled from: source.java */
    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String string = allowedMethods.toString();
                if (string == null && str == null) {
                    return allowedMethods;
                }
                if (string != null && string.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.AllowedMethod;
        }
    }

    public void a(List<String> list) {
        this.f16002f = list;
    }

    public void b(List<AllowedMethods> list) {
        this.f15998b = list;
    }

    public void c(List<String> list) {
        this.f15999c = list;
    }

    public void d(List<String> list) {
        this.f16001e = list;
    }

    public void e(String str) {
        this.f15997a = str;
    }

    public void f(int i11) {
        this.f16000d = i11;
    }
}
