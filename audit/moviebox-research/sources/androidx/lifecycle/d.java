package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k[] f8716a;

    public d(k[] generatedAdapters) {
        Intrinsics.g(generatedAdapters, "generatedAdapters");
        this.f8716a = generatedAdapters;
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        b0 b0Var = new b0();
        for (k kVar : this.f8716a) {
            kVar.a(source, event, false, b0Var);
        }
        for (k kVar2 : this.f8716a) {
            kVar2.a(source, event, true, b0Var);
        }
    }
}
