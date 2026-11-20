package androidx.compose.runtime;

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
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecomposeScopeImpl f3544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3546c;

    public o0(RecomposeScopeImpl recomposeScopeImpl, int i11, Object obj) {
        this.f3544a = recomposeScopeImpl;
        this.f3545b = i11;
        this.f3546c = obj;
    }

    public final Object a() {
        return this.f3546c;
    }

    public final int b() {
        return this.f3545b;
    }

    public final RecomposeScopeImpl c() {
        return this.f3544a;
    }

    public final boolean d() {
        return this.f3544a.u(this.f3546c);
    }

    public final void e(Object obj) {
        this.f3546c = obj;
    }
}
