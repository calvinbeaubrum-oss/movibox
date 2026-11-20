package x5;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements m {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final double[] f80072q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f80073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r0 f80074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final k0 f80075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final z3.c0 f80076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final u f80077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f80078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f80079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f80080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f80081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f80082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f80083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f80084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f80085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f80086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f80087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f80088p;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte[] f80089e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f80090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f80091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f80092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f80093d;

        public a(int i11) {
            this.f80093d = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f80090a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f80093d;
                int length = bArr2.length;
                int i14 = this.f80091b;
                if (length < i14 + i13) {
                    this.f80093d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f80093d, this.f80091b, i13);
                this.f80091b += i13;
            }
        }

        public boolean b(int i11, int i12) {
            if (this.f80090a) {
                int i13 = this.f80091b - i12;
                this.f80091b = i13;
                if (this.f80092c != 0 || i11 != 181) {
                    this.f80090a = false;
                    return true;
                }
                this.f80092c = i13;
            } else if (i11 == 179) {
                this.f80090a = true;
            }
            byte[] bArr = f80089e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f80090a = false;
            this.f80091b = 0;
            this.f80092c = 0;
        }
    }

    public n() {
        this(null);
    }

    public n(@Nullable k0 k0Var) {
        this.f80075c = k0Var;
        this.f80078f = new boolean[4];
        this.f80079g = new a(128);
        if (k0Var != null) {
            this.f80077e = new u(178, 128);
            this.f80076d = new z3.c0();
        } else {
            this.f80077e = null;
            this.f80076d = null;
        }
        this.f80084l = C.TIME_UNSET;
        this.f80086n = C.TIME_UNSET;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    /* JADX WARN: Code duplicated, block: B:16:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    public static Pair<androidx.media3.common.y, Long> a(a aVar, String str) {
        float f11;
        int i11;
        float f12;
        int i12;
        long j11;
        double[] dArr;
        double d11;
        int i13;
        int i14;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f80093d, aVar.f80091b);
        int i15 = bArrCopyOf[4] & 255;
        byte b11 = bArrCopyOf[5];
        int i16 = (i15 << 4) | ((b11 & 255) >> 4);
        int i17 = ((b11 & Ascii.SI) << 8) | (bArrCopyOf[6] & 255);
        int i18 = (bArrCopyOf[7] & 240) >> 4;
        if (i18 == 2) {
            f11 = i17 * 4;
            i11 = i16 * 3;
        } else {
            if (i18 != 3) {
                if (i18 != 4) {
                    f12 = 1.0f;
                } else {
                    f11 = i17 * 121;
                    i11 = i16 * 100;
                }
                androidx.media3.common.y yVarI = new androidx.media3.common.y.b().X(str).k0(MimeTypes.VIDEO_MPEG2).r0(i16).V(i17).g0(f12).Y(Collections.singletonList(bArrCopyOf)).I();
                i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
                if (i12 >= 0) {
                    dArr = f80072q;
                    if (i12 < dArr.length) {
                        d11 = dArr[i12];
                        byte b12 = bArrCopyOf[aVar.f80092c + 9];
                        i13 = (b12 & 96) >> 5;
                        i14 = b12 & Ascii.US;
                        if (i13 != i14) {
                            d11 *= (((double) i13) + 1.0d) / ((double) (i14 + 1));
                        }
                        j11 = (long) (1000000.0d / d11);
                    } else {
                        j11 = 0;
                    }
                } else {
                    j11 = 0;
                }
                return Pair.create(yVarI, Long.valueOf(j11));
            }
            f11 = i17 * 16;
            i11 = i16 * 9;
        }
        f12 = f11 / i11;
        androidx.media3.common.y yVarI2 = new androidx.media3.common.y.b().X(str).k0(MimeTypes.VIDEO_MPEG2).r0(i16).V(i17).g0(f12).Y(Collections.singletonList(bArrCopyOf)).I();
        i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
        if (i12 >= 0) {
            dArr = f80072q;
            if (i12 < dArr.length) {
                d11 = dArr[i12];
                byte b13 = bArrCopyOf[aVar.f80092c + 9];
                i13 = (b13 & 96) >> 5;
                i14 = b13 & Ascii.US;
                if (i13 != i14) {
                    d11 *= (((double) i13) + 1.0d) / ((double) (i14 + 1));
                }
                j11 = (long) (1000000.0d / d11);
            } else {
                j11 = 0;
            }
        } else {
            j11 = 0;
        }
        return Pair.create(yVarI2, Long.valueOf(j11));
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0112  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // x5.m
    public void b(z3.c0 c0Var) {
        int i11;
        z3.a.i(this.f80074b);
        int iF = c0Var.f();
        int iG = c0Var.g();
        byte[] bArrE = c0Var.e();
        this.f80080h += (long) c0Var.a();
        this.f80074b.c(c0Var, c0Var.a());
        while (true) {
            int iC = a4.a.c(bArrE, iF, iG, this.f80078f);
            if (iC == iG) {
                break;
            }
            int i12 = iC + 3;
            int i13 = c0Var.e()[i12] & 255;
            int i14 = iC - iF;
            if (!this.f80082j) {
                if (i14 > 0) {
                    this.f80079g.a(bArrE, iF, iC);
                }
                if (this.f80079g.b(i13, i14 < 0 ? -i14 : 0)) {
                    Pair<androidx.media3.common.y, Long> pairA = a(this.f80079g, (String) z3.a.e(this.f80073a));
                    this.f80074b.b((androidx.media3.common.y) pairA.first);
                    this.f80083k = ((Long) pairA.second).longValue();
                    this.f80082j = true;
                }
            }
            u uVar = this.f80077e;
            if (uVar != null) {
                if (i14 > 0) {
                    uVar.a(bArrE, iF, iC);
                    i11 = 0;
                } else {
                    i11 = -i14;
                }
                if (this.f80077e.b(i11)) {
                    u uVar2 = this.f80077e;
                    ((z3.c0) u0.i(this.f80076d)).S(this.f80077e.f80241d, a4.a.q(uVar2.f80241d, uVar2.f80242e));
                    ((k0) u0.i(this.f80075c)).a(this.f80086n, this.f80076d);
                }
                if (i13 == 178 && c0Var.e()[iC + 2] == 1) {
                    this.f80077e.e(i13);
                }
            }
            if (i13 == 0 || i13 == 179) {
                int i15 = iG - iC;
                if (this.f80088p && this.f80082j) {
                    long j11 = this.f80086n;
                    if (j11 != C.TIME_UNSET) {
                        this.f80074b.f(j11, this.f80087o ? 1 : 0, ((int) (this.f80080h - this.f80085m)) - i15, i15, null);
                    }
                }
                if (!this.f80081i || this.f80088p) {
                    this.f80085m = this.f80080h - ((long) i15);
                    long j12 = this.f80084l;
                    if (j12 == C.TIME_UNSET) {
                        long j13 = this.f80086n;
                        j12 = j13 != C.TIME_UNSET ? j13 + this.f80083k : -9223372036854775807L;
                    }
                    this.f80086n = j12;
                    this.f80087o = false;
                    this.f80084l = C.TIME_UNSET;
                    this.f80081i = true;
                }
                this.f80088p = i13 == 0;
            } else if (i13 == 184) {
                this.f80087o = true;
            }
            iF = i12;
        }
        if (!this.f80082j) {
            this.f80079g.a(bArrE, iF, iG);
        }
        u uVar3 = this.f80077e;
        if (uVar3 != null) {
            uVar3.a(bArrE, iF, iG);
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80084l = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80073a = dVar.b();
        this.f80074b = uVar.track(dVar.c(), 2);
        k0 k0Var = this.f80075c;
        if (k0Var != null) {
            k0Var.b(uVar, dVar);
        }
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        a4.a.a(this.f80078f);
        this.f80079g.c();
        u uVar = this.f80077e;
        if (uVar != null) {
            uVar.d();
        }
        this.f80080h = 0L;
        this.f80081i = false;
        this.f80084l = C.TIME_UNSET;
        this.f80086n = C.TIME_UNSET;
    }
}
