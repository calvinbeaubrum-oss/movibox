package androidx.compose.foundation.layout;

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
public final class s extends androidx.compose.ui.f.c implements a1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2523p;

    public s(float f11, boolean z11) {
        this.f2522o = f11;
        this.f2523p = z11;
    }

    @Override // androidx.compose.ui.node.a1
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public z k(q2.e eVar, Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar == null) {
            zVar = new z(0.0f, false, null, null, 15, null);
        }
        zVar.g(this.f2522o);
        zVar.f(this.f2523p);
        return zVar;
    }

    public final void I1(boolean z11) {
        this.f2523p = z11;
    }

    public final void J1(float f11) {
        this.f2522o = f11;
    }
}
