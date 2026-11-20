package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.p;
import com.google.android.gms.common.api.Api;
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
public final class b {
    public static final long a(long j11, boolean z11, int i11, float f11) {
        return q2.b.f74225b.b(0, c(j11, z11, i11, f11), 0, q2.b.k(j11));
    }

    public static final int b(boolean z11, int i11, int i12) {
        if (z11 || !p.e(i11, p.f6143a.b())) {
            return kotlin.ranges.a.d(i12, 1);
        }
        return 1;
    }

    public static final int c(long j11, boolean z11, int i11, float f11) {
        int iL = ((z11 || p.e(i11, p.f6143a.b())) && q2.b.h(j11)) ? q2.b.l(j11) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        return q2.b.n(j11) == iL ? iL : kotlin.ranges.a.k(androidx.compose.foundation.text.b.a(f11), q2.b.n(j11), iL);
    }
}
