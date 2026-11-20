package androidx.compose.runtime.snapshots;

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
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3658a = SnapshotKt.H().f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f3659b;

    public abstract void c(e0 e0Var);

    public abstract e0 d();

    public final e0 e() {
        return this.f3659b;
    }

    public final int f() {
        return this.f3658a;
    }

    public final void g(e0 e0Var) {
        this.f3659b = e0Var;
    }

    public final void h(int i11) {
        this.f3658a = i11;
    }
}
