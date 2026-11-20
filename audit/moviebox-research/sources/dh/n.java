package dh;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n implements m {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final double[] f63219q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f63220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tg.e0 f63221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final k0 f63222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.util.c0 f63223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final u f63224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f63225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f63226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f63227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f63228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f63229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f63230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f63231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f63232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f63233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f63234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f63235p;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte[] f63236e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f63237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f63238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f63239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f63240d;

        public a(int i11) {
            this.f63240d = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f63237a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f63240d;
                int length = bArr2.length;
                int i14 = this.f63238b;
                if (length < i14 + i13) {
                    this.f63240d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f63240d, this.f63238b, i13);
                this.f63238b += i13;
            }
        }

        public boolean b(int i11, int i12) {
            if (this.f63237a) {
                int i13 = this.f63238b - i12;
                this.f63238b = i13;
                if (this.f63239c != 0 || i11 != 181) {
                    this.f63237a = false;
                    return true;
                }
                this.f63239c = i13;
            } else if (i11 == 179) {
                this.f63237a = true;
            }
            byte[] bArr = f63236e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f63237a = false;
            this.f63238b = 0;
            this.f63239c = 0;
        }
    }

    public n() {
        this(null);
    }

    public n(@Nullable k0 k0Var) {
        this.f63222c = k0Var;
        this.f63225f = new boolean[4];
        this.f63226g = new a(128);
        if (k0Var != null) {
            this.f63224e = new u(178, 128);
            this.f63223d = new com.google.android.exoplayer2.util.c0();
        } else {
            this.f63224e = null;
            this.f63223d = null;
        }
        this.f63231l = C.TIME_UNSET;
        this.f63233n = C.TIME_UNSET;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    /* JADX WARN: Code duplicated, block: B:16:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    public static Pair<m1, Long> a(a aVar, String str) {
        float f11;
        int i11;
        float f12;
        int i12;
        long j11;
        double[] dArr;
        double d11;
        int i13;
        int i14;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f63240d, aVar.f63238b);
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
                m1 m1VarE = new m1.b().S(str).e0(MimeTypes.VIDEO_MPEG2).j0(i16).Q(i17).a0(f12).T(Collections.singletonList(bArrCopyOf)).E();
                i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
                if (i12 >= 0) {
                    dArr = f63219q;
                    if (i12 < dArr.length) {
                        d11 = dArr[i12];
                        byte b12 = bArrCopyOf[aVar.f63239c + 9];
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
                return Pair.create(m1VarE, Long.valueOf(j11));
            }
            f11 = i17 * 16;
            i11 = i16 * 9;
        }
        f12 = f11 / i11;
        m1 m1VarE2 = new m1.b().S(str).e0(MimeTypes.VIDEO_MPEG2).j0(i16).Q(i17).a0(f12).T(Collections.singletonList(bArrCopyOf)).E();
        i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
        if (i12 >= 0) {
            dArr = f63219q;
            if (i12 < dArr.length) {
                d11 = dArr[i12];
                byte b13 = bArrCopyOf[aVar.f63239c + 9];
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
        return Pair.create(m1VarE2, Long.valueOf(j11));
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
    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        int i11;
        com.google.android.exoplayer2.util.a.i(this.f63221b);
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f63227h += (long) c0Var.a();
        this.f63221b.c(c0Var, c0Var.a());
        while (true) {
            int iC = com.google.android.exoplayer2.util.x.c(bArrD, iE, iF, this.f63225f);
            if (iC == iF) {
                break;
            }
            int i12 = iC + 3;
            int i13 = c0Var.d()[i12] & 255;
            int i14 = iC - iE;
            if (!this.f63229j) {
                if (i14 > 0) {
                    this.f63226g.a(bArrD, iE, iC);
                }
                if (this.f63226g.b(i13, i14 < 0 ? -i14 : 0)) {
                    Pair<m1, Long> pairA = a(this.f63226g, (String) com.google.android.exoplayer2.util.a.e(this.f63220a));
                    this.f63221b.e((m1) pairA.first);
                    this.f63230k = ((Long) pairA.second).longValue();
                    this.f63229j = true;
                }
            }
            u uVar = this.f63224e;
            if (uVar != null) {
                if (i14 > 0) {
                    uVar.a(bArrD, iE, iC);
                    i11 = 0;
                } else {
                    i11 = -i14;
                }
                if (this.f63224e.b(i11)) {
                    u uVar2 = this.f63224e;
                    ((com.google.android.exoplayer2.util.c0) o0.j(this.f63223d)).N(this.f63224e.f63385d, com.google.android.exoplayer2.util.x.q(uVar2.f63385d, uVar2.f63386e));
                    ((k0) o0.j(this.f63222c)).a(this.f63233n, this.f63223d);
                }
                if (i13 == 178 && c0Var.d()[iC + 2] == 1) {
                    this.f63224e.e(i13);
                }
            }
            if (i13 == 0 || i13 == 179) {
                int i15 = iF - iC;
                if (this.f63235p && this.f63229j) {
                    long j11 = this.f63233n;
                    if (j11 != C.TIME_UNSET) {
                        this.f63221b.d(j11, this.f63234o ? 1 : 0, ((int) (this.f63227h - this.f63232m)) - i15, i15, null);
                    }
                }
                if (!this.f63228i || this.f63235p) {
                    this.f63232m = this.f63227h - ((long) i15);
                    long j12 = this.f63231l;
                    if (j12 == C.TIME_UNSET) {
                        long j13 = this.f63233n;
                        j12 = j13 != C.TIME_UNSET ? j13 + this.f63230k : -9223372036854775807L;
                    }
                    this.f63233n = j12;
                    this.f63234o = false;
                    this.f63231l = C.TIME_UNSET;
                    this.f63228i = true;
                }
                this.f63235p = i13 == 0;
            } else if (i13 == 184) {
                this.f63234o = true;
            }
            iE = i12;
        }
        if (!this.f63229j) {
            this.f63226g.a(bArrD, iE, iF);
        }
        u uVar3 = this.f63224e;
        if (uVar3 != null) {
            uVar3.a(bArrD, iE, iF);
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        this.f63231l = j11;
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63220a = dVar.b();
        this.f63221b = nVar.track(dVar.c(), 2);
        k0 k0Var = this.f63222c;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.f63225f);
        this.f63226g.c();
        u uVar = this.f63224e;
        if (uVar != null) {
            uVar.d();
        }
        this.f63227h = 0L;
        this.f63228i = false;
        this.f63231l = C.TIME_UNSET;
        this.f63233n = C.TIME_UNSET;
    }
}
