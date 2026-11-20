package com.amazonaws.auth;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum SignatureVersion {
    V1("1"),
    V2("2");

    private String value;

    SignatureVersion(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
