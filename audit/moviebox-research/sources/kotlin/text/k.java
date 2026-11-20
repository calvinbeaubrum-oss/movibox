package kotlin.text;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.Metadata;
import kotlin.SinceKotlin;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class k extends j {
    @SinceKotlin
    public static Integer l(String str) {
        Intrinsics.g(str, "<this>");
        return m(str, 10);
    }

    @SinceKotlin
    public static final Integer m(String str, int i11) {
        boolean z11;
        int i12;
        int i13;
        Intrinsics.g(str, "<this>");
        a.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i14 = 0;
        char cCharAt = str.charAt(0);
        int i15 = -2147483647;
        if (Intrinsics.i(cCharAt, 48) < 0) {
            i12 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i15 = Integer.MIN_VALUE;
                z11 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z11 = false;
            }
        } else {
            z11 = false;
            i12 = 0;
        }
        int i16 = -59652323;
        while (i12 < length) {
            int iB = a.b(str.charAt(i12), i11);
            if (iB < 0) {
                return null;
            }
            if ((i14 < i16 && (i16 != -59652323 || i14 < (i16 = i15 / i11))) || (i13 = i14 * i11) < i15 + iB) {
                return null;
            }
            i14 = i13 - iB;
            i12++;
        }
        return z11 ? Integer.valueOf(i14) : Integer.valueOf(-i14);
    }

    @SinceKotlin
    public static Long n(String str) {
        Intrinsics.g(str, "<this>");
        return o(str, 10);
    }

    @SinceKotlin
    public static final Long o(String str, int i11) {
        boolean z11;
        Intrinsics.g(str, "<this>");
        a.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        int i13 = Intrinsics.i(cCharAt, 48);
        long j11 = C.TIME_UNSET;
        if (i13 < 0) {
            z11 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j11 = Long.MIN_VALUE;
                i12 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i12 = 1;
                z11 = false;
            }
        } else {
            z11 = false;
        }
        long j12 = -256204778801521550L;
        long j13 = 0;
        long j14 = -256204778801521550L;
        while (i12 < length) {
            int iB = a.b(str.charAt(i12), i11);
            if (iB < 0) {
                return null;
            }
            if (j13 < j14) {
                if (j14 == j12) {
                    j14 = j11 / ((long) i11);
                    if (j13 < j14) {
                    }
                }
                return null;
            }
            long j15 = j13 * ((long) i11);
            long j16 = iB;
            if (j15 < j11 + j16) {
                return null;
            }
            j13 = j15 - j16;
            i12++;
            j12 = -256204778801521550L;
        }
        return z11 ? Long.valueOf(j13) : Long.valueOf(-j13);
    }
}
