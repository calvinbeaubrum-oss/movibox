package com.google.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface Writer {

    /* JADX INFO: compiled from: source.java */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void A(int i11, boolean z11) throws IOException;

    void B(int i11, int i12) throws IOException;

    @Deprecated
    void C(int i11) throws IOException;

    void D(int i11, List<Long> list, boolean z11) throws IOException;

    void E(int i11, List<Integer> list, boolean z11) throws IOException;

    void F(int i11, List<Boolean> list, boolean z11) throws IOException;

    <K, V> void G(int i11, h0.a<K, V> aVar, Map<K, V> map) throws IOException;

    void H(int i11, float f11) throws IOException;

    @Deprecated
    void I(int i11) throws IOException;

    void J(int i11, List<Integer> list, boolean z11) throws IOException;

    void K(int i11, int i12) throws IOException;

    void L(int i11, List<Long> list, boolean z11) throws IOException;

    void M(int i11, List<Double> list, boolean z11) throws IOException;

    void N(int i11, int i12) throws IOException;

    void O(int i11, List<ByteString> list) throws IOException;

    void a(int i11, List<?> list, b1 b1Var) throws IOException;

    void b(int i11, List<Float> list, boolean z11) throws IOException;

    void c(int i11, Object obj) throws IOException;

    void d(int i11, int i12) throws IOException;

    void e(int i11, List<String> list) throws IOException;

    void f(int i11, String str) throws IOException;

    void g(int i11, long j11) throws IOException;

    void h(int i11, List<Integer> list, boolean z11) throws IOException;

    @Deprecated
    void i(int i11, Object obj, b1 b1Var) throws IOException;

    void j(int i11, ByteString byteString) throws IOException;

    void k(int i11, int i12) throws IOException;

    void l(int i11, long j11) throws IOException;

    void m(int i11, List<Integer> list, boolean z11) throws IOException;

    void n(int i11, List<Integer> list, boolean z11) throws IOException;

    void o(int i11, List<Long> list, boolean z11) throws IOException;

    void p(int i11, long j11) throws IOException;

    void q(int i11, List<Integer> list, boolean z11) throws IOException;

    @Deprecated
    void r(int i11, List<?> list, b1 b1Var) throws IOException;

    void s(int i11, int i12) throws IOException;

    void t(int i11, double d11) throws IOException;

    void u(int i11, List<Long> list, boolean z11) throws IOException;

    void v(int i11, List<Long> list, boolean z11) throws IOException;

    void w(int i11, Object obj, b1 b1Var) throws IOException;

    void x(int i11, long j11) throws IOException;

    FieldOrder y();

    void z(int i11, long j11) throws IOException;
}
