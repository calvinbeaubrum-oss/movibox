package q2;

import com.google.android.gms.common.api.Api;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
public final class c {
    public static final long a(int i11, int i12, int i13, int i14) {
        boolean z11 = false;
        if (!(i12 >= i11)) {
            o.a("maxWidth(" + i12 + ") must be >= than minWidth(" + i11 + ')');
        }
        if (!(i14 >= i13)) {
            o.a("maxHeight(" + i14 + ") must be >= than minHeight(" + i13 + ')');
        }
        if (i11 >= 0 && i13 >= 0) {
            z11 = true;
        }
        if (!z11) {
            o.a("minWidth(" + i11 + ") and minHeight(" + i13 + ") must be >= 0");
        }
        return j(i11, i12, i13, i14);
    }

    public static /* synthetic */ long b(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = 0;
        }
        if ((i15 & 2) != 0) {
            i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if ((i15 & 4) != 0) {
            i13 = 0;
        }
        if ((i15 & 8) != 0) {
            i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return a(i11, i12, i13, i14);
    }

    public static final int d(int i11, int i12) {
        return i11 == Integer.MAX_VALUE ? i11 : kotlin.ranges.a.d(i11 + i12, 0);
    }

    public static final int e(int i11) {
        if (i11 < 8191) {
            return 13;
        }
        if (i11 < 32767) {
            return 15;
        }
        if (i11 < 65535) {
            return 16;
        }
        return i11 < 262143 ? 18 : 255;
    }

    public static final long f(long j11, long j12) {
        return u.a(kotlin.ranges.a.k(t.g(j12), b.n(j11), b.l(j11)), kotlin.ranges.a.k(t.f(j12), b.m(j11), b.k(j11)));
    }

    public static final long g(long j11, long j12) {
        return a(kotlin.ranges.a.k(b.n(j12), b.n(j11), b.l(j11)), kotlin.ranges.a.k(b.l(j12), b.n(j11), b.l(j11)), kotlin.ranges.a.k(b.m(j12), b.m(j11), b.k(j11)), kotlin.ranges.a.k(b.k(j12), b.m(j11), b.k(j11)));
    }

    public static final int h(long j11, int i11) {
        return kotlin.ranges.a.k(i11, b.m(j11), b.k(j11));
    }

    public static final int i(long j11, int i11) {
        return kotlin.ranges.a.k(i11, b.n(j11), b.l(j11));
    }

    public static final long j(int i11, int i12, int i13, int i14) {
        int i15 = i14 == Integer.MAX_VALUE ? i13 : i14;
        int iE = e(i15);
        int i16 = i12 == Integer.MAX_VALUE ? i11 : i12;
        int iE2 = e(i16);
        if (iE + iE2 > 31) {
            k(i16, i15);
        }
        int i17 = i12 + 1;
        int i18 = i17 & (~(i17 >> 31));
        int i19 = i14 + 1;
        int i21 = i19 & (~(i19 >> 31));
        int i22 = 0;
        if (iE2 != 13) {
            if (iE2 == 18) {
                i22 = 3;
            } else if (iE2 == 15) {
                i22 = 1;
            } else if (iE2 == 16) {
                i22 = 2;
            }
        }
        int i23 = ((i22 & 1) << 1) + (((i22 & 2) >> 1) * 3);
        return b.b((((long) i18) << 33) | ((long) i22) | (((long) i11) << 2) | (((long) i13) << (i23 + 15)) | (((long) i21) << (i23 + 46)));
    }

    public static final void k(int i11, int i12) {
        throw new IllegalArgumentException("Can't represent a width of " + i11 + " and height of " + i12 + " in Constraints");
    }

    public static final Void l(int i11) {
        throw new IllegalArgumentException("Can't represent a size of " + i11 + " in Constraints");
    }

    public static final int m(int i11) {
        if (i11 < 8191) {
            return 262142;
        }
        if (i11 < 32767) {
            return 65534;
        }
        if (i11 < 65535) {
            return 32766;
        }
        if (i11 < 262143) {
            return 8190;
        }
        l(i11);
        throw new KotlinNothingValueException();
    }

    public static final long n(long j11, int i11, int i12) {
        return a(kotlin.ranges.a.d(b.n(j11) + i11, 0), d(b.l(j11), i11), kotlin.ranges.a.d(b.m(j11) + i12, 0), d(b.k(j11), i12));
    }
}
