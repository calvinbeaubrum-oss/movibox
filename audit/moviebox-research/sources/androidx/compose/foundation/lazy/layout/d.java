package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.node.a1;
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
public final class d extends androidx.compose.ui.f.c implements a1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.compose.animation.core.c0<Float> f2700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.compose.animation.core.c0<q2.p> f2701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.animation.core.c0<Float> f2702q;

    public final androidx.compose.animation.core.c0<Float> H1() {
        return this.f2700o;
    }

    public final androidx.compose.animation.core.c0<Float> I1() {
        return this.f2702q;
    }

    public final androidx.compose.animation.core.c0<q2.p> J1() {
        return this.f2701p;
    }

    @Override // androidx.compose.ui.node.a1
    public Object k(q2.e eVar, Object obj) {
        return this;
    }
}
