package com.google.protobuf;

import com.google.protobuf.u.b;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class q<T extends u.b<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(p pVar, n0 n0Var, int i11);

    public abstract u<T> c(Object obj);

    public abstract u<T> d(Object obj);

    public abstract boolean e(n0 n0Var);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(a1 a1Var, Object obj, p pVar, u<T> uVar, UB ub2, h1<UT, UB> h1Var) throws IOException;

    public abstract void h(a1 a1Var, Object obj, p pVar, u<T> uVar) throws IOException;

    public abstract void i(ByteString byteString, Object obj, p pVar, u<T> uVar) throws IOException;

    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
