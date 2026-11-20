package com.applovin.impl;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fa implements q7 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double[] f18940q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f18942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final vp f18943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bh f18944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final yf f18945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f18946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f18947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f18952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f18953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f18954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f18955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18956p;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final byte[] f18957e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f18958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f18961d;

        public a(int i11) {
            this.f18961d = new byte[i11];
        }

        public void a() {
            this.f18958a = false;
            this.f18959b = 0;
            this.f18960c = 0;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f18958a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f18961d;
                int length = bArr2.length;
                int i14 = this.f18959b + i13;
                if (length < i14) {
                    this.f18961d = Arrays.copyOf(bArr2, i14 * 2);
                }
                System.arraycopy(bArr, i11, this.f18961d, this.f18959b, i13);
                this.f18959b += i13;
            }
        }

        public boolean a(int i11, int i12) {
            if (this.f18958a) {
                int i13 = this.f18959b - i12;
                this.f18959b = i13;
                if (this.f18960c != 0 || i11 != 181) {
                    this.f18958a = false;
                    return true;
                }
                this.f18960c = i13;
            } else if (i11 == 179) {
                this.f18958a = true;
            }
            byte[] bArr = f18957e;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    public fa() {
        this(null);
    }

    public fa(vp vpVar) {
        this.f18943c = vpVar;
        this.f18946f = new boolean[4];
        this.f18947g = new a(128);
        if (vpVar != null) {
            this.f18945e = new yf(178, 128);
            this.f18944d = new bh();
        } else {
            this.f18945e = null;
            this.f18944d = null;
        }
        this.f18952l = C.TIME_UNSET;
        this.f18954n = C.TIME_UNSET;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    /* JADX WARN: Code duplicated, block: B:16:0x0078  */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    private static Pair a(a aVar, String str) {
        float f11;
        int i11;
        float f12;
        int i12;
        long j11;
        double[] dArr;
        double d11;
        int i13;
        int i14;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f18961d, aVar.f18959b);
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
                f9 f9VarA = new f9.b().c(str).f(MimeTypes.VIDEO_MPEG2).q(i16).g(i17).b(f12).a(Collections.singletonList(bArrCopyOf)).a();
                i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
                if (i12 >= 0) {
                    dArr = f18940q;
                    if (i12 < dArr.length) {
                        d11 = dArr[i12];
                        byte b12 = bArrCopyOf[aVar.f18960c + 9];
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
                return Pair.create(f9VarA, Long.valueOf(j11));
            }
            f11 = i17 * 16;
            i11 = i16 * 9;
        }
        f12 = f11 / i11;
        f9 f9VarA2 = new f9.b().c(str).f(MimeTypes.VIDEO_MPEG2).q(i16).g(i17).b(f12).a(Collections.singletonList(bArrCopyOf)).a();
        i12 = (bArrCopyOf[7] & Ascii.SI) - 1;
        if (i12 >= 0) {
            dArr = f18940q;
            if (i12 < dArr.length) {
                d11 = dArr[i12];
                byte b13 = bArrCopyOf[aVar.f18960c + 9];
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
        return Pair.create(f9VarA2, Long.valueOf(j11));
    }

    @Override // com.applovin.impl.q7
    public void a() {
        zf.a(this.f18946f);
        this.f18947g.a();
        yf yfVar = this.f18945e;
        if (yfVar != null) {
            yfVar.b();
        }
        this.f18948h = 0L;
        this.f18949i = false;
        this.f18952l = C.TIME_UNSET;
        this.f18954n = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        this.f18952l = j11;
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
    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        int i11;
        b1.b(this.f18942b);
        int iD = bhVar.d();
        int iE = bhVar.e();
        byte[] bArrC = bhVar.c();
        this.f18948h += (long) bhVar.a();
        this.f18942b.a(bhVar, bhVar.a());
        while (true) {
            int iA = zf.a(bArrC, iD, iE, this.f18946f);
            if (iA == iE) {
                break;
            }
            int i12 = iA + 3;
            int i13 = bhVar.c()[i12] & 255;
            int i14 = iA - iD;
            if (!this.f18950j) {
                if (i14 > 0) {
                    this.f18947g.a(bArrC, iD, iA);
                }
                if (this.f18947g.a(i13, i14 < 0 ? -i14 : 0)) {
                    Pair pairA = a(this.f18947g, (String) b1.a((Object) this.f18941a));
                    this.f18942b.a((f9) pairA.first);
                    this.f18951k = ((Long) pairA.second).longValue();
                    this.f18950j = true;
                }
            }
            yf yfVar = this.f18945e;
            if (yfVar != null) {
                if (i14 > 0) {
                    yfVar.a(bArrC, iD, iA);
                    i11 = 0;
                } else {
                    i11 = -i14;
                }
                if (this.f18945e.a(i11)) {
                    yf yfVar2 = this.f18945e;
                    ((bh) xp.a(this.f18944d)).a(this.f18945e.f24665d, zf.c(yfVar2.f24665d, yfVar2.f24666e));
                    ((vp) xp.a(this.f18943c)).a(this.f18954n, this.f18944d);
                }
                if (i13 == 178 && bhVar.c()[iA + 2] == 1) {
                    this.f18945e.b(i13);
                }
            }
            if (i13 == 0 || i13 == 179) {
                int i15 = iE - iA;
                if (this.f18956p && this.f18950j) {
                    long j11 = this.f18954n;
                    if (j11 != C.TIME_UNSET) {
                        this.f18942b.a(j11, this.f18955o ? 1 : 0, ((int) (this.f18948h - this.f18953m)) - i15, i15, null);
                    }
                }
                if (!this.f18949i || this.f18956p) {
                    this.f18953m = this.f18948h - ((long) i15);
                    long j12 = this.f18952l;
                    if (j12 == C.TIME_UNSET) {
                        long j13 = this.f18954n;
                        j12 = j13 != C.TIME_UNSET ? j13 + this.f18951k : -9223372036854775807L;
                    }
                    this.f18954n = j12;
                    this.f18955o = false;
                    this.f18952l = C.TIME_UNSET;
                    this.f18949i = true;
                }
                this.f18956p = i13 == 0;
            } else if (i13 == 184) {
                this.f18955o = true;
            }
            iD = i12;
        }
        if (!this.f18950j) {
            this.f18947g.a(bArrC, iD, iE);
        }
        yf yfVar3 = this.f18945e;
        if (yfVar3 != null) {
            yfVar3.a(bArrC, iD, iE);
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f18941a = dVar.b();
        this.f18942b = m8Var.a(dVar.c(), 2);
        vp vpVar = this.f18943c;
        if (vpVar != null) {
            vpVar.a(m8Var, dVar);
        }
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
