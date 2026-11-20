package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
@SourceDebugExtension
public final class w1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4564b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f4565c = y1.d(4278190080L);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f4566d = y1.d(4282664004L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f4567e = y1.d(4287137928L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f4568f = y1.d(4291611852L);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f4569g = y1.d(4294967295L);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f4570h = y1.d(4294901760L);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f4571i = y1.d(4278255360L);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f4572j = y1.d(4278190335L);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f4573k = y1.d(4294967040L);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f4574l = y1.d(4278255615L);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f4575m = y1.d(4294902015L);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f4576n = y1.b(0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f4577o = y1.a(0.0f, 0.0f, 0.0f, 0.0f, androidx.compose.ui.graphics.colorspace.g.f4027a.y());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4578a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return w1.f4565c;
        }

        public final long b() {
            return w1.f4572j;
        }

        public final long c() {
            return w1.f4570h;
        }

        public final long d() {
            return w1.f4576n;
        }

        public final long e() {
            return w1.f4577o;
        }

        public final long f() {
            return w1.f4569g;
        }
    }

    public /* synthetic */ w1(long j11) {
        this.f4578a = j11;
    }

    public static final /* synthetic */ w1 g(long j11) {
        return new w1(j11);
    }

    public static long h(long j11) {
        return j11;
    }

    public static final long i(long j11, androidx.compose.ui.graphics.colorspace.c cVar) {
        return androidx.compose.ui.graphics.colorspace.d.i(p(j11), cVar, 0, 2, null).a(j11);
    }

    public static final long j(long j11, float f11, float f12, float f13, float f14) {
        return y1.a(f12, f13, f14, f11, p(j11));
    }

    public static /* synthetic */ long k(long j11, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = n(j11);
        }
        float f15 = f11;
        if ((i11 & 2) != 0) {
            f12 = r(j11);
        }
        float f16 = f12;
        if ((i11 & 4) != 0) {
            f13 = q(j11);
        }
        float f17 = f13;
        if ((i11 & 8) != 0) {
            f14 = o(j11);
        }
        return j(j11, f15, f16, f17, f14);
    }

    public static boolean l(long j11, Object obj) {
        return (obj instanceof w1) && j11 == ((w1) obj).u();
    }

    public static final boolean m(long j11, long j12) {
        return ULong.d(j11, j12);
    }

    public static final float n(long j11) {
        float fC;
        float f11;
        if (ULong.b(63 & j11) == 0) {
            fC = (float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 56) & 255));
            f11 = 255.0f;
        } else {
            fC = (float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 6) & 1023));
            f11 = 1023.0f;
        }
        return fC / f11;
    }

    public static final float o(long j11) {
        int i11;
        int i12;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 32) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j11 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i13 = Short.MIN_VALUE & sB;
        int i14 = ((65535 & sB) >>> 10) & 31;
        int i15 = sB & 1023;
        if (i14 != 0) {
            int i16 = i15 << 13;
            if (i14 == 31) {
                if (i16 != 0) {
                    i16 |= 4194304;
                }
                i11 = i16;
                i12 = 255;
            } else {
                int i17 = i14 + 112;
                i11 = i16;
                i12 = i17;
            }
        } else {
            if (i15 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i15 + 1056964608) - b4.f3989c;
                return i13 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i12 = 0;
            i11 = 0;
        }
        return Float.intBitsToFloat((i12 << 23) | (i13 << 16) | i11);
    }

    public static final androidx.compose.ui.graphics.colorspace.c p(long j11) {
        androidx.compose.ui.graphics.colorspace.g gVar = androidx.compose.ui.graphics.colorspace.g.f4027a;
        return gVar.l()[(int) ULong.b(j11 & 63)];
    }

    public static final float q(long j11) {
        int i11;
        int i12;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 40) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j11 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i13 = Short.MIN_VALUE & sB;
        int i14 = ((65535 & sB) >>> 10) & 31;
        int i15 = sB & 1023;
        if (i14 != 0) {
            int i16 = i15 << 13;
            if (i14 == 31) {
                if (i16 != 0) {
                    i16 |= 4194304;
                }
                i11 = i16;
                i12 = 255;
            } else {
                int i17 = i14 + 112;
                i11 = i16;
                i12 = i17;
            }
        } else {
            if (i15 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i15 + 1056964608) - b4.f3989c;
                return i13 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i12 = 0;
            i11 = 0;
        }
        return Float.intBitsToFloat((i12 << 23) | (i13 << 16) | i11);
    }

    public static final float r(long j11) {
        int i11;
        int i12;
        if (ULong.b(63 & j11) == 0) {
            return ((float) UnsignedKt.c(ULong.b(ULong.b(j11 >>> 48) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j11 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i13 = Short.MIN_VALUE & sB;
        int i14 = ((65535 & sB) >>> 10) & 31;
        int i15 = sB & 1023;
        if (i14 != 0) {
            int i16 = i15 << 13;
            if (i14 == 31) {
                if (i16 != 0) {
                    i16 |= 4194304;
                }
                i11 = i16;
                i12 = 255;
            } else {
                int i17 = i14 + 112;
                i11 = i16;
                i12 = i17;
            }
        } else {
            if (i15 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i15 + 1056964608) - b4.f3989c;
                return i13 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i12 = 0;
            i11 = 0;
        }
        return Float.intBitsToFloat((i12 << 23) | (i13 << 16) | i11);
    }

    public static int s(long j11) {
        return ULong.e(j11);
    }

    public static String t(long j11) {
        return "Color(" + r(j11) + ", " + q(j11) + ", " + o(j11) + ", " + n(j11) + ", " + p(j11).h() + ')';
    }

    public boolean equals(Object obj) {
        return l(this.f4578a, obj);
    }

    public int hashCode() {
        return s(this.f4578a);
    }

    public String toString() {
        return t(this.f4578a);
    }

    public final /* synthetic */ long u() {
        return this.f4578a;
    }
}
