package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.v1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f8658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f8659b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.g(lifecycle, "lifecycle");
        Intrinsics.g(coroutineContext, "coroutineContext");
        this.f8658a = lifecycle;
        this.f8659b = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            v1.e(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle a() {
        return this.f8658a;
    }

    public final void c() {
        kotlinx.coroutines.j.d(this, kotlinx.coroutines.w0.c().q(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // kotlinx.coroutines.k0
    public CoroutineContext getCoroutineContext() {
        return this.f8659b;
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            v1.e(getCoroutineContext(), null, 1, null);
        }
    }
}
