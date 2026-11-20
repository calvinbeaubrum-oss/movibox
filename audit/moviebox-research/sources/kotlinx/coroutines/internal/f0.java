package kotlinx.coroutines.internal;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final /* synthetic */ class f0 {
    public static final int a(String str, int i11, int i12, int i13) {
        return (int) d0.c(str, i11, i12, i13);
    }

    public static final long b(String str, long j11, long j12, long j13) {
        String strD = d0.d(str);
        if (strD == null) {
            return j11;
        }
        Long lN = kotlin.text.k.n(strD);
        if (lN == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lN.longValue();
        if (j12 <= jLongValue && jLongValue <= j13) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j12 + ".." + j13 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = d0.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z11) {
        String strD = d0.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z11;
    }

    public static /* synthetic */ int e(String str, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i12 = 1;
        }
        if ((i14 & 8) != 0) {
            i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return d0.b(str, i11, i12, i13);
    }

    public static /* synthetic */ long f(String str, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j12 = 1;
        }
        long j14 = j12;
        if ((i11 & 8) != 0) {
            j13 = Long.MAX_VALUE;
        }
        return d0.c(str, j11, j14, j13);
    }
}
