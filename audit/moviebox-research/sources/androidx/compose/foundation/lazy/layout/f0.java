package androidx.compose.foundation.lazy.layout;

import androidx.collection.r0;
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
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.k0<Object> f2719a = r0.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.k0<Object> f2720b = r0.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2722d;

    public final long d(long j11, long j12) {
        if (j12 == 0) {
            return j11;
        }
        long j13 = 4;
        return (j11 / j13) + ((j12 / j13) * ((long) 3));
    }

    public final long e() {
        return this.f2721c;
    }

    public final androidx.collection.k0<Object> f() {
        return this.f2719a;
    }

    public final long g() {
        return this.f2722d;
    }

    public final androidx.collection.k0<Object> h() {
        return this.f2720b;
    }
}
