package androidx.compose.ui.input.pointer.util;

import f2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.a0;
import q2.z;
import y1.g;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VelocityTracker1D.Strategy f4760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VelocityTracker1D f4761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VelocityTracker1D f4762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4764e;

    public a() {
        VelocityTracker1D.Strategy strategy = c.h() ? VelocityTracker1D.Strategy.Impulse : VelocityTracker1D.Strategy.Lsq2;
        this.f4760a = strategy;
        boolean z11 = false;
        int i11 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.f4761b = new VelocityTracker1D(z11, strategy, i11, defaultConstructorMarker);
        this.f4762c = new VelocityTracker1D(z11, strategy, i11, defaultConstructorMarker);
        this.f4763d = g.f81070b.c();
    }

    public final void a(long j11, long j12) {
        this.f4761b.a(j11, g.m(j12));
        this.f4762c.a(j11, g.n(j12));
    }

    public final long b(long j11) {
        if (!(z.h(j11) > 0.0f && z.i(j11) > 0.0f)) {
            h2.a.b("maximumVelocity should be a positive value. You specified=" + ((Object) z.m(j11)));
        }
        return a0.a(this.f4761b.d(z.h(j11)), this.f4762c.d(z.i(j11)));
    }

    public final long c() {
        return this.f4763d;
    }

    public final long d() {
        return this.f4764e;
    }

    public final void e() {
        this.f4761b.e();
        this.f4762c.e();
        this.f4764e = 0L;
    }

    public final void f(long j11) {
        this.f4763d = j11;
    }

    public final void g(long j11) {
        this.f4764e = j11;
    }
}
