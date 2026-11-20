package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
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
public final class v<T, V extends o> implements c<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0<V> f2144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0<T, V> f2145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f2146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V f2147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V f2148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final V f2149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final T f2150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f2151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2152i;

    public v(w<T> wVar, s0<T, V> s0Var, T t11, V v11) {
        this(wVar.a(s0Var), s0Var, t11, v11);
    }

    public v(x0<V> x0Var, s0<T, V> s0Var, T t11, V v11) {
        this.f2144a = x0Var;
        this.f2145b = s0Var;
        this.f2146c = t11;
        V vInvoke = e().a().invoke(t11);
        this.f2147d = vInvoke;
        this.f2148e = (V) p.e(v11);
        this.f2150g = (T) e().b().invoke(x0Var.d(vInvoke, v11));
        this.f2151h = x0Var.c(vInvoke, v11);
        V v12 = (V) p.e(x0Var.b(d(), vInvoke, v11));
        this.f2149f = v12;
        int iB = v12.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v13 = this.f2149f;
            v13.e(i11, kotlin.ranges.a.j(v13.a(i11), -this.f2144a.a(), this.f2144a.a()));
        }
    }

    @Override // androidx.compose.animation.core.c
    public boolean a() {
        return this.f2152i;
    }

    @Override // androidx.compose.animation.core.c
    public V b(long j11) {
        return !c(j11) ? (V) this.f2144a.b(j11, this.f2147d, this.f2148e) : this.f2149f;
    }

    @Override // androidx.compose.animation.core.c
    public /* synthetic */ boolean c(long j11) {
        return b.a(this, j11);
    }

    @Override // androidx.compose.animation.core.c
    public long d() {
        return this.f2151h;
    }

    @Override // androidx.compose.animation.core.c
    public s0<T, V> e() {
        return this.f2145b;
    }

    @Override // androidx.compose.animation.core.c
    public T f(long j11) {
        return !c(j11) ? (T) e().b().invoke(this.f2144a.e(j11, this.f2147d, this.f2148e)) : g();
    }

    @Override // androidx.compose.animation.core.c
    public T g() {
        return this.f2150g;
    }
}
