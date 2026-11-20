package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j1 extends h1<i1, i1> {
    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public i1 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(i1 i1Var) {
        return i1Var.d();
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(i1 i1Var) {
        return i1Var.e();
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public i1 k(i1 i1Var, i1 i1Var2) {
        return i1Var2.equals(i1.c()) ? i1Var : i1.i(i1Var, i1Var2);
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public i1 n() {
        return i1.j();
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, i1 i1Var) {
        p(obj, i1Var);
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, i1 i1Var) {
        ((GeneratedMessageLite) obj).unknownFields = i1Var;
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public i1 r(i1 i1Var) {
        i1Var.h();
        return i1Var;
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(i1 i1Var, Writer writer) throws IOException {
        i1Var.o(writer);
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(i1 i1Var, Writer writer) throws IOException {
        i1Var.q(writer);
    }

    @Override // com.google.protobuf.h1
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.protobuf.h1
    public boolean q(a1 a1Var) {
        return false;
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(i1 i1Var, int i11, int i12) {
        i1Var.m(WireFormat.c(i11, 5), Integer.valueOf(i12));
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(i1 i1Var, int i11, long j11) {
        i1Var.m(WireFormat.c(i11, 1), Long.valueOf(j11));
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(i1 i1Var, int i11, i1 i1Var2) {
        i1Var.m(WireFormat.c(i11, 3), i1Var2);
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(i1 i1Var, int i11, ByteString byteString) {
        i1Var.m(WireFormat.c(i11, 2), byteString);
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(i1 i1Var, int i11, long j11) {
        i1Var.m(WireFormat.c(i11, 0), Long.valueOf(j11));
    }

    @Override // com.google.protobuf.h1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public i1 f(Object obj) {
        i1 i1VarG = g(obj);
        if (i1VarG != i1.c()) {
            return i1VarG;
        }
        i1 i1VarJ = i1.j();
        p(obj, i1VarJ);
        return i1VarJ;
    }
}
