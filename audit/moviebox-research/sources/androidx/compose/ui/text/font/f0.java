package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
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
@RequiresApi(28)
@Metadata
public final class f0 implements d0 {
    @Override // androidx.compose.ui.text.font.d0
    public Typeface a(x xVar, u uVar, int i11) {
        return c(xVar.f(), uVar, i11);
    }

    @Override // androidx.compose.ui.text.font.d0
    public Typeface b(u uVar, int i11) {
        return c(null, uVar, i11);
    }

    public final Typeface c(String str, u uVar, int i11) {
        q.a aVar = q.f5850b;
        if (q.f(i11, aVar.b()) && Intrinsics.b(uVar, u.f5860b.a()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), uVar.i(), q.f(i11, aVar.a()));
    }
}
