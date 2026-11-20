package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class f<T, V extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0<T, V> f2067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f2068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f2070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f2071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public V f2072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2074h = Long.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i1 f2075i;

    public f(T t11, s0<T, V> s0Var, V v11, long j11, T t12, long j12, boolean z11, Function0<Unit> function0) {
        this.f2067a = s0Var;
        this.f2068b = t12;
        this.f2069c = j12;
        this.f2070d = function0;
        this.f2071e = u2.c(t11, null, 2, null);
        this.f2072f = (V) p.e(v11);
        this.f2073g = j11;
        this.f2075i = u2.c(Boolean.valueOf(z11), null, 2, null);
    }

    public final void a() {
        k(false);
        this.f2070d.invoke();
    }

    public final long b() {
        return this.f2074h;
    }

    public final long c() {
        return this.f2073g;
    }

    public final long d() {
        return this.f2069c;
    }

    public final T e() {
        return this.f2071e.getValue();
    }

    public final T f() {
        return this.f2067a.b().invoke(this.f2072f);
    }

    public final V g() {
        return this.f2072f;
    }

    public final boolean h() {
        return ((Boolean) this.f2075i.getValue()).booleanValue();
    }

    public final void i(long j11) {
        this.f2074h = j11;
    }

    public final void j(long j11) {
        this.f2073g = j11;
    }

    public final void k(boolean z11) {
        this.f2075i.setValue(Boolean.valueOf(z11));
    }

    public final void l(T t11) {
        this.f2071e.setValue(t11);
    }

    public final void m(V v11) {
        this.f2072f = v11;
    }
}
