package com.google.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface a1 {
    void A(List<Long> list) throws IOException;

    void B(List<Integer> list) throws IOException;

    void C(List<Integer> list) throws IOException;

    long D() throws IOException;

    String E() throws IOException;

    int F() throws IOException;

    void G(List<String> list) throws IOException;

    <T> T H(b1<T> b1Var, p pVar) throws IOException;

    void I(List<Float> list) throws IOException;

    boolean J() throws IOException;

    int K() throws IOException;

    void L(List<ByteString> list) throws IOException;

    void M(List<Double> list) throws IOException;

    long N() throws IOException;

    String O() throws IOException;

    long a() throws IOException;

    void b(List<Integer> list) throws IOException;

    void c(List<Long> list) throws IOException;

    @Deprecated
    <T> void d(List<T> list, b1<T> b1Var, p pVar) throws IOException;

    boolean e() throws IOException;

    <T> void f(List<T> list, b1<T> b1Var, p pVar) throws IOException;

    long g() throws IOException;

    int getTag();

    void h(List<Long> list) throws IOException;

    int i() throws IOException;

    void j(List<Long> list) throws IOException;

    void k(List<Integer> list) throws IOException;

    int l() throws IOException;

    int m() throws IOException;

    void n(List<Boolean> list) throws IOException;

    @Deprecated
    <T> T o(Class<T> cls, p pVar) throws IOException;

    <K, V> void p(Map<K, V> map, h0.a<K, V> aVar, p pVar) throws IOException;

    void q(List<String> list) throws IOException;

    ByteString r() throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    int s() throws IOException;

    void t(List<Long> list) throws IOException;

    void u(List<Integer> list) throws IOException;

    long v() throws IOException;

    void w(List<Integer> list) throws IOException;

    <T> T x(Class<T> cls, p pVar) throws IOException;

    int y() throws IOException;

    @Deprecated
    <T> T z(b1<T> b1Var, p pVar) throws IOException;
}
