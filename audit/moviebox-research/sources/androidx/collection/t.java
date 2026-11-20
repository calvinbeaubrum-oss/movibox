package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public long[] f1987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public long[] f1988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public int f1989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public int f1990d;

    public t() {
        this.f1987a = t0.f1991a;
        this.f1988b = u.a();
    }

    public /* synthetic */ t(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ String d(t tVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        return tVar.c(charSequence, charSequence5, charSequence6, i13, charSequence4);
    }

    public final boolean a(long j11) {
        int iA = l.p.a(j11) * (-862048943);
        int i11 = iA ^ (iA << 16);
        int i12 = i11 & 127;
        int i13 = this.f1989c;
        int i14 = (i11 >>> 7) & i13;
        int i15 = 0;
        while (true) {
            long[] jArr = this.f1987a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j12 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j13 = (((long) i12) * 72340172838076673L) ^ j12;
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j14) >> 3) + i14) & i13;
                if (this.f1988b[iNumberOfTrailingZeros] == j11) {
                    return iNumberOfTrailingZeros >= 0;
                }
            }
            if ((j12 & ((~j12) << 6) & (-9187201950435737472L)) != 0) {
                return false;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
        }
    }

    public final int b() {
        return this.f1989c;
    }

    @JvmOverloads
    public final String c(CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated) {
        int i12;
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.f1988b;
        long[] jArr2 = this.f1987a;
        int length = jArr2.length - 2;
        if (length < 0) {
            sb2.append(postfix);
            break;
        }
        int i13 = 0;
        int i14 = 0;
        loop0: while (true) {
            long j11 = jArr2[i13];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i15 = 8 - ((~(i13 - length)) >>> 31);
                int i16 = 0;
                while (i16 < i15) {
                    if ((j11 & 255) < 128) {
                        long j12 = jArr[(i13 << 3) + i16];
                        if (i14 == i11) {
                            sb2.append(truncated);
                            break loop0;
                        }
                        if (i14 != 0) {
                            sb2.append(separator);
                        }
                        sb2.append(j12);
                        i14++;
                    }
                    j11 >>= 8;
                    i16++;
                    i13 = i13;
                }
                int i17 = i13;
                if (i15 == 8) {
                    i12 = i17;
                }
                sb2.append(postfix);
                break;
            }
            i12 = i13;
            if (i12 == length) {
                sb2.append(postfix);
                break;
            }
            i13 = i12 + 1;
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x005a A[LOOP:0: B:14:0x0021->B:26:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x005d A[SYNTHETIC] */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.f1990d != this.f1990d) {
            return false;
        }
        long[] jArr = this.f1988b;
        long[] jArr2 = this.f1987a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr2[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128 && !tVar.a(jArr[(i11 << 3) + i13])) {
                            return false;
                        }
                        j11 >>= 8;
                    }
                    if (i12 == 8) {
                        if (i11 != length) {
                            i11++;
                        }
                    }
                } else if (i11 != length) {
                    i11++;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        long[] jArr = this.f1988b;
        long[] jArr2 = this.f1987a;
        int length = jArr2.length - 2;
        int i11 = 0;
        if (length >= 0) {
            int i12 = 0;
            int iA = 0;
            while (true) {
                long j11 = jArr2[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            iA += l.p.a(jArr[(i12 << 3) + i14]);
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        return iA;
                    }
                }
                if (i12 != length) {
                    i12++;
                } else {
                    i11 = iA;
                }
            }
        }
        return i11;
    }

    public String toString() {
        return d(this, null, "[", "]", 0, null, 25, null);
    }
}
