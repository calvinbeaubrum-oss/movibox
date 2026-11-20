package androidx.core.util;

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
public class h<T> extends g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7893c;

    public h(int i11) {
        super(i11);
        this.f7893c = new Object();
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public T acquire() {
        T t11;
        synchronized (this.f7893c) {
            t11 = (T) super.acquire();
        }
        return t11;
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public boolean release(T instance) {
        boolean zRelease;
        Intrinsics.g(instance, "instance");
        synchronized (this.f7893c) {
            zRelease = super.release(instance);
        }
        return zRelease;
    }
}
