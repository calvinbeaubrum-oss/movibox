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
public final class e extends androidx.compose.ui.f.c implements a1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.compose.ui.b f2492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2493p;

    public e(androidx.compose.ui.b bVar, boolean z11) {
        this.f2492o = bVar;
        this.f2493p = z11;
    }

    public final androidx.compose.ui.b H1() {
        return this.f2492o;
    }

    public final boolean I1() {
        return this.f2493p;
    }

    @Override // androidx.compose.ui.node.a1
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public e k(q2.e eVar, Object obj) {
        return this;
    }

    public final void K1(androidx.compose.ui.b bVar) {
        this.f2492o = bVar;
    }

    public final void L1(boolean z11) {
        this.f2493p = z11;
    }
}
