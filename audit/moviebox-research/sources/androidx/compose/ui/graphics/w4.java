package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Deprecated;
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
public final class w4 {
    public static final Rect a(q2.r rVar) {
        return new Rect(rVar.f(), rVar.h(), rVar.g(), rVar.d());
    }

    @Deprecated
    public static final Rect b(y1.i iVar) {
        return new Rect((int) iVar.f(), (int) iVar.i(), (int) iVar.g(), (int) iVar.c());
    }

    public static final RectF c(y1.i iVar) {
        return new RectF(iVar.f(), iVar.i(), iVar.g(), iVar.c());
    }

    public static final q2.r d(Rect rect) {
        return new q2.r(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static final y1.i e(Rect rect) {
        return new y1.i(rect.left, rect.top, rect.right, rect.bottom);
    }
}
