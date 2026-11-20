package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class i<T, V extends o> implements a3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0<T, V> f2091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f2092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V f2093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2094d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2096g;

    public i(s0<T, V> s0Var, T t11, V v11, long j11, long j12, boolean z11) {
        V v12;
        this.f2091a = s0Var;
        this.f2092b = u2.c(t11, null, 2, null);
        this.f2093c = (v11 == null || (v12 = (V) p.e(v11)) == null) ? (V) j.i(s0Var, t11) : v12;
        this.f2094d = j11;
        this.f2095f = j12;
        this.f2096g = z11;
    }

    public /* synthetic */ i(s0 s0Var, Object obj, o oVar, long j11, long j12, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(s0Var, obj, (i11 & 4) != 0 ? null : oVar, (i11 & 8) != 0 ? Long.MIN_VALUE : j11, (i11 & 16) != 0 ? Long.MIN_VALUE : j12, (i11 & 32) != 0 ? false : z11);
    }

    public final long a() {
        return this.f2095f;
    }

    public final long b() {
        return this.f2094d;
    }

    public final s0<T, V> e() {
        return this.f2091a;
    }

    public final T f() {
        return this.f2091a.b().invoke(this.f2093c);
    }

    public final V g() {
        return this.f2093c;
    }

    @Override // androidx.compose.runtime.a3
    public T getValue() {
        return this.f2092b.getValue();
    }

    public final boolean h() {
        return this.f2096g;
    }

    public final void i(long j11) {
        this.f2095f = j11;
    }

    public final void j(long j11) {
        this.f2094d = j11;
    }

    public final void k(boolean z11) {
        this.f2096g = z11;
    }

    public void l(T t11) {
        this.f2092b.setValue(t11);
    }

    public final void m(V v11) {
        this.f2093c = v11;
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + f() + ", isRunning=" + this.f2096g + ", lastFrameTimeNanos=" + this.f2094d + ", finishedTimeNanos=" + this.f2095f + ')';
    }
}
