package com.amazonaws.auth;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BasicSessionCredentials implements AWSSessionCredentials {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15689c;

    public BasicSessionCredentials(String str, String str2, String str3) {
        this.f15687a = str;
        this.f15688b = str2;
        this.f15689c = str3;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String a() {
        return this.f15687a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.f15688b;
    }

    @Override // com.amazonaws.auth.AWSSessionCredentials
    public String getSessionToken() {
        return this.f15689c;
    }
}
