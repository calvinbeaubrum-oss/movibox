package androidx.lifecycle;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class n0 implements r, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f8757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8758c;

    public n0(String key, l0 handle) {
        Intrinsics.g(key, "key");
        Intrinsics.g(handle, "handle");
        this.f8756a = key;
        this.f8757b = handle;
    }

    public final void a(f6.c registry, Lifecycle lifecycle) {
        Intrinsics.g(registry, "registry");
        Intrinsics.g(lifecycle, "lifecycle");
        if (!(!this.f8758c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f8758c = true;
        lifecycle.a(this);
        registry.h(this.f8756a, this.f8757b.c());
    }

    public final l0 b() {
        return this.f8757b;
    }

    public final boolean c() {
        return this.f8758c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f8758c = false;
            source.getLifecycle().d(this);
        }
    }
}
