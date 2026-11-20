package com.amazonaws.services.s3.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SSECustomerKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16109c;

    private SSECustomerKey() {
    }

    public static SSECustomerKey a(String str) {
        if (str != null) {
            return new SSECustomerKey().f(str);
        }
        throw new IllegalArgumentException();
    }

    public String b() {
        return this.f16109c;
    }

    public String c() {
        return this.f16107a;
    }

    public String d() {
        return this.f16108b;
    }

    public void e(String str) {
        this.f16109c = str;
    }

    public SSECustomerKey f(String str) {
        e(str);
        return this;
    }
}
