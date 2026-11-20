package com.google.firebase.encoders.proto;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public @interface Protobuf {

    /* JADX INFO: compiled from: source.java */
    public enum IntEncoding {
        DEFAULT,
        SIGNED,
        FIXED
    }

    IntEncoding intEncoding() default IntEncoding.DEFAULT;

    int tag();
}
