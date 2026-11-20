package androidx.compose.ui.text.font;

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
public final class c implements c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5817b;

    public c(int i11) {
        this.f5817b = i11;
    }

    @Override // androidx.compose.ui.text.font.c0
    public u a(u uVar) {
        int i11 = this.f5817b;
        return (i11 == 0 || i11 == Integer.MAX_VALUE) ? uVar : new u(kotlin.ranges.a.k(uVar.i() + this.f5817b, 1, 1000));
    }

    @Override // androidx.compose.ui.text.font.c0
    public /* synthetic */ int b(int i11) {
        return b0.b(this, i11);
    }

    @Override // androidx.compose.ui.text.font.c0
    public /* synthetic */ int c(int i11) {
        return b0.c(this, i11);
    }

    @Override // androidx.compose.ui.text.font.c0
    public /* synthetic */ i d(i iVar) {
        return b0.a(this, iVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f5817b == ((c) obj).f5817b;
    }

    public int hashCode() {
        return this.f5817b;
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.f5817b + ')';
    }
}
