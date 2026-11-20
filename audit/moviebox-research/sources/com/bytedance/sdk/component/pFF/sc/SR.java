package com.bytedance.sdk.component.pFF.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR {
    public byte[] ExN;
    public sc TRI;
    public String We;
    public Ol zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public SR() {
    }

    public SR(Ol ol2, String str, sc scVar) {
        this.zY = ol2;
        this.We = str;
        this.TRI = scVar;
    }

    public SR(Ol ol2, byte[] bArr, sc scVar) {
        this.zY = ol2;
        this.ExN = bArr;
        this.TRI = scVar;
    }

    public static SR sc(Ol ol2, String str) {
        return new SR(ol2, str, sc.STRING_TYPE);
    }

    public static SR sc(Ol ol2, byte[] bArr) {
        return new SR(ol2, bArr, sc.BYTE_ARRAY_TYPE);
    }

    public String sc() {
        return this.We;
    }
}
