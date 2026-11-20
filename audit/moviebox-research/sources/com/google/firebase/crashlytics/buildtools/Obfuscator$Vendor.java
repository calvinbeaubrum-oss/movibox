package com.google.firebase.crashlytics.buildtools;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum Obfuscator$Vendor {
    PROGUARD("proguard"),
    DEXGUARD("dexguard"),
    R8("R8");

    private final String name;

    Obfuscator$Vendor(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
