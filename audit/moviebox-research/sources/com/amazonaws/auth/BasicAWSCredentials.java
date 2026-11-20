package com.amazonaws.auth;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BasicAWSCredentials implements AWSCredentials {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15686b;

    public BasicAWSCredentials(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        this.f15685a = str;
        this.f15686b = str2;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String a() {
        return this.f15685a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.f15686b;
    }
}
