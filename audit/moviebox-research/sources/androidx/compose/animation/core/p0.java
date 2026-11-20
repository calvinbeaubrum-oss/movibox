package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class p0<T, V extends o> implements c<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<V> f2122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0<T, V> f2123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f2124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f2125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public V f2126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public V f2127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V f2128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public V f2130i;

    public p0(g<T> gVar, s0<T, V> s0Var, T t11, T t12, V v11) {
        this(gVar.a(s0Var), s0Var, t11, t12, v11);
    }

    public p0(v0<V> v0Var, s0<T, V> s0Var, T t11, T t12, V v11) {
        V v12;
        this.f2122a = v0Var;
        this.f2123b = s0Var;
        this.f2124c = t12;
        this.f2125d = t11;
        this.f2126e = e().a().invoke(t11);
        this.f2127f = e().a().invoke(t12);
        this.f2128g = (v11 == null || (v12 = (V) p.e(v11)) == null) ? (V) p.g(e().a().invoke(t11)) : v12;
        this.f2129h = -1L;
    }

    @Override // androidx.compose.animation.core.c
    public boolean a() {
        return this.f2122a.a();
    }

    @Override // androidx.compose.animation.core.c
    public V b(long j11) {
        return !c(j11) ? (V) this.f2122a.e(j11, this.f2126e, this.f2127f, this.f2128g) : (V) h();
    }

    @Override // androidx.compose.animation.core.c
    public /* synthetic */ boolean c(long j11) {
        return b.a(this, j11);
    }

    @Override // androidx.compose.animation.core.c
    public long d() {
        if (this.f2129h < 0) {
            this.f2129h = this.f2122a.f(this.f2126e, this.f2127f, this.f2128g);
        }
        return this.f2129h;
    }

    @Override // androidx.compose.animation.core.c
    public s0<T, V> e() {
        return this.f2123b;
    }

    @Override // androidx.compose.animation.core.c
    public T f(long j11) {
        if (c(j11)) {
            return g();
        }
        o oVarG = this.f2122a.g(j11, this.f2126e, this.f2127f, this.f2128g);
        int iB = oVarG.b();
        for (int i11 = 0; i11 < iB; i11++) {
            if (!(!Float.isNaN(oVarG.a(i11)))) {
                k0.b("AnimationVector cannot contain a NaN. " + oVarG + ". Animation: " + this + ", playTimeNanos: " + j11);
            }
        }
        return (T) e().b().invoke(oVarG);
    }

    @Override // androidx.compose.animation.core.c
    public T g() {
        return this.f2124c;
    }

    public final V h() {
        V v11 = this.f2130i;
        if (v11 != null) {
            return v11;
        }
        V v12 = (V) this.f2122a.c(this.f2126e, this.f2127f, this.f2128g);
        this.f2130i = v12;
        return v12;
    }

    public final T i() {
        return this.f2125d;
    }

    public String toString() {
        return "TargetBasedAnimation: " + i() + " -> " + g() + ",initial velocity: " + this.f2128g + ", duration: " + d.b(this) + " ms,animationSpec: " + this.f2122a;
    }
}
