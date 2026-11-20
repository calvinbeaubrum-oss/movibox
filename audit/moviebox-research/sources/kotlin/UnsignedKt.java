package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.a;

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
@JvmName
public final class UnsignedKt {
    @PublishedApi
    public static final int a(int i11, int i12) {
        return Intrinsics.i(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int b(long j11, long j12) {
        return Intrinsics.j(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    public static final double c(long j11) {
        return ((j11 >>> 11) * ((double) 2048)) + (j11 & 2047);
    }

    public static final String d(long j11) {
        return e(j11, 10);
    }

    public static final String e(long j11, int i11) {
        if (j11 >= 0) {
            String string = Long.toString(j11, a.a(i11));
            Intrinsics.f(string, "toString(...)");
            return string;
        }
        long j12 = i11;
        long j13 = ((j11 >>> 1) / j12) << 1;
        long j14 = j11 - (j13 * j12);
        if (j14 >= j12) {
            j14 -= j12;
            j13++;
        }
        StringBuilder sb2 = new StringBuilder();
        String string2 = Long.toString(j13, a.a(i11));
        Intrinsics.f(string2, "toString(...)");
        sb2.append(string2);
        String string3 = Long.toString(j14, a.a(i11));
        Intrinsics.f(string3, "toString(...)");
        sb2.append(string3);
        return sb2.toString();
    }
}
