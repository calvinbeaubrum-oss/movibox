package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class s0 implements o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f4337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f4339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x1 f4340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r4 f4341e;

    public s0() {
        this(t0.j());
    }

    public s0(Paint paint) {
        this.f4337a = paint;
        this.f4338b = e1.f4102a.B();
    }

    @Override // androidx.compose.ui.graphics.o4
    public void A(x1 x1Var) {
        this.f4340d = x1Var;
        t0.n(this.f4337a, x1Var);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void B(float f11) {
        t0.t(this.f4337a, f11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public int C() {
        return t0.e(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void D(int i11) {
        t0.v(this.f4337a, i11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public long a() {
        return t0.d(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public float getAlpha() {
        return t0.c(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public float getStrokeWidth() {
        return t0.i(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public x1 i() {
        return this.f4340d;
    }

    @Override // androidx.compose.ui.graphics.o4
    public int m() {
        return this.f4338b;
    }

    @Override // androidx.compose.ui.graphics.o4
    public void n(int i11) {
        t0.r(this.f4337a, i11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void o(int i11) {
        if (e1.E(this.f4338b, i11)) {
            return;
        }
        this.f4338b = i11;
        t0.l(this.f4337a, i11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void p(int i11) {
        t0.o(this.f4337a, i11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public int q() {
        return t0.f(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void r(r4 r4Var) {
        t0.p(this.f4337a, r4Var);
        this.f4341e = r4Var;
    }

    @Override // androidx.compose.ui.graphics.o4
    public void s(int i11) {
        t0.s(this.f4337a, i11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void setAlpha(float f11) {
        t0.k(this.f4337a, f11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void setStrokeWidth(float f11) {
        t0.u(this.f4337a, f11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public void t(long j11) {
        t0.m(this.f4337a, j11);
    }

    @Override // androidx.compose.ui.graphics.o4
    public r4 u() {
        return this.f4341e;
    }

    @Override // androidx.compose.ui.graphics.o4
    public int v() {
        return t0.g(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public float w() {
        return t0.h(this.f4337a);
    }

    @Override // androidx.compose.ui.graphics.o4
    public Paint x() {
        return this.f4337a;
    }

    @Override // androidx.compose.ui.graphics.o4
    public void y(Shader shader) {
        this.f4339c = shader;
        t0.q(this.f4337a, shader);
    }

    @Override // androidx.compose.ui.graphics.o4
    public Shader z() {
        return this.f4339c;
    }
}
