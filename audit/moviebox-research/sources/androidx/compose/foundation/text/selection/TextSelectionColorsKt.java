package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class TextSelectionColorsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<m> f3001a = CompositionLocalKt.d(null, new Function0<m>() { // from class: androidx.compose.foundation.text.selection.TextSelectionColorsKt$LocalTextSelectionColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final m invoke() {
            return TextSelectionColorsKt.f3003c;
        }
    }, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f3003c;

    static {
        long jD = y1.d(4282550004L);
        f3002b = jD;
        f3003c = new m(jD, w1.k(jD, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    public static final s1<m> b() {
        return f3001a;
    }
}
