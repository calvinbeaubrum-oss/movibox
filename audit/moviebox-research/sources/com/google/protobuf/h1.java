package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class h1<T, B> {
    public abstract void a(B b11, int i11, int i12);

    public abstract void b(B b11, int i11, long j11);

    public abstract void c(B b11, int i11, T t11);

    public abstract void d(B b11, int i11, ByteString byteString);

    public abstract void e(B b11, int i11, long j11);

    public abstract B f(Object obj);

    public abstract T g(Object obj);

    public abstract int h(T t11);

    public abstract int i(T t11);

    public abstract void j(Object obj);

    public abstract T k(T t11, T t12);

    public final void l(B b11, a1 a1Var) throws IOException {
        while (a1Var.F() != Integer.MAX_VALUE && m(b11, a1Var)) {
        }
    }

    public final boolean m(B b11, a1 a1Var) throws IOException {
        int tag = a1Var.getTag();
        int iA = WireFormat.a(tag);
        int iB = WireFormat.b(tag);
        if (iB == 0) {
            e(b11, iA, a1Var.N());
            return true;
        }
        if (iB == 1) {
            b(b11, iA, a1Var.a());
            return true;
        }
        if (iB == 2) {
            d(b11, iA, a1Var.r());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            a(b11, iA, a1Var.y());
            return true;
        }
        B bN = n();
        int iC = WireFormat.c(iA, 4);
        l(bN, a1Var);
        if (iC != a1Var.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        c(b11, iA, r(bN));
        return true;
    }

    public abstract B n();

    public abstract void o(Object obj, B b11);

    public abstract void p(Object obj, T t11);

    public abstract boolean q(a1 a1Var);

    public abstract T r(B b11);

    public abstract void s(T t11, Writer writer) throws IOException;

    public abstract void t(T t11, Writer writer) throws IOException;
}
