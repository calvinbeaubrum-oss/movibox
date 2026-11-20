package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
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
public final class h0 {
    public static final d0 a() {
        return Build.VERSION.SDK_INT >= 28 ? new f0() : new g0();
    }

    public static final String b(String str, u uVar) {
        int i11 = uVar.i() / 100;
        if (i11 >= 0 && i11 < 2) {
            return str + "-thin";
        }
        if (2 <= i11 && i11 < 4) {
            return str + "-light";
        }
        if (i11 == 4) {
            return str;
        }
        if (i11 == 5) {
            return str + "-medium";
        }
        if ((6 <= i11 && i11 < 8) || 8 > i11 || i11 >= 11) {
            return str;
        }
        return str + "-black";
    }

    public static final Typeface c(Typeface typeface, t tVar, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? l0.f5834a.a(typeface, tVar, context) : typeface;
    }
}
