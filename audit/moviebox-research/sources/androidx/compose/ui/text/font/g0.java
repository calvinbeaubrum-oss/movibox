package androidx.compose.ui.text.font;

import android.graphics.Typeface;
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
public final class g0 implements d0 {
    @Override // androidx.compose.ui.text.font.d0
    public Typeface a(x xVar, u uVar, int i11) {
        Typeface typefaceD = d(h0.b(xVar.f(), uVar), uVar, i11);
        return typefaceD == null ? c(xVar.f(), uVar, i11) : typefaceD;
    }

    @Override // androidx.compose.ui.text.font.d0
    public Typeface b(u uVar, int i11) {
        return c(null, uVar, i11);
    }

    public final Typeface c(String str, u uVar, int i11) {
        if (q.f(i11, q.f5850b.b()) && Intrinsics.b(uVar, u.f5860b.a()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        int iC = e.c(uVar, i11);
        return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(iC) : Typeface.create(str, iC);
    }

    public final Typeface d(String str, u uVar, int i11) {
        if (str.length() == 0) {
            return null;
        }
        Typeface typefaceC = c(str, uVar, i11);
        if (Intrinsics.b(typefaceC, Typeface.create(Typeface.DEFAULT, e.c(uVar, i11))) || Intrinsics.b(typefaceC, c(null, uVar, i11))) {
            return null;
        }
        return typefaceC;
    }
}
