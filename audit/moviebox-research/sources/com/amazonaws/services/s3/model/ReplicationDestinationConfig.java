package com.amazonaws.services.s3.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReplicationDestinationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16083b;

    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Bucket name cannot be null");
        }
        this.f16082a = str;
    }

    public void b(String str) {
        this.f16083b = str;
    }
}
