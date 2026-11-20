package androidx.compose.foundation;

import androidx.compose.ui.platform.CompositionLocalsKt;
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
public final class q extends androidx.compose.ui.f.c implements androidx.compose.ui.node.d, androidx.compose.ui.focus.o {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2827o;

    private final d2.b H1() {
        return (d2.b) androidx.compose.ui.node.e.a(this, CompositionLocalsKt.f());
    }

    @Override // androidx.compose.ui.focus.o
    public void A0(androidx.compose.ui.focus.m mVar) {
        mVar.r(!d2.a.f(H1().a(), d2.a.f62868b.b()));
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2827o;
    }
}
