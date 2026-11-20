package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.node.m1;
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
public final class l0 extends androidx.compose.ui.f.c implements m1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public x f2726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f2727p = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";

    public l0(x xVar) {
        this.f2726o = xVar;
    }

    public final x H1() {
        return this.f2726o;
    }

    @Override // androidx.compose.ui.node.m1
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public String I() {
        return this.f2727p;
    }

    public final void J1(x xVar) {
        this.f2726o = xVar;
    }
}
