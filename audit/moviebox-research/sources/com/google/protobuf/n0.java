package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface n0 extends o0 {

    /* JADX INFO: compiled from: source.java */
    public interface a extends o0, Cloneable {
        n0 build();

        a i(n0 n0Var);

        n0 u();

        a w(byte[] bArr) throws InvalidProtocolBufferException;
    }

    a b();

    ByteString c();

    int g();

    byte[] h();

    a j();

    void l(CodedOutputStream codedOutputStream) throws IOException;

    v0<? extends n0> p();
}
