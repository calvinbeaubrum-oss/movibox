package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ga implements q7 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f19167l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vp f19168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19169b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final yf f19172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f19173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f19175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private qo f19176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f19177j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f19170c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f19171d = new a(128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19178k = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f19179f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f19180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f19181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f19184e;

        public a(int i11) {
            this.f19184e = new byte[i11];
        }

        public void a() {
            this.f19180a = false;
            this.f19182c = 0;
            this.f19181b = 0;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f19180a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f19184e;
                int length = bArr2.length;
                int i14 = this.f19182c + i13;
                if (length < i14) {
                    this.f19184e = Arrays.copyOf(bArr2, i14 * 2);
                }
                System.arraycopy(bArr, i11, this.f19184e, this.f19182c, i13);
                this.f19182c += i13;
            }
        }

        public boolean a(int i11, int i12) {
            int i13 = this.f19181b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i11 == 179 || i11 == 181) {
                                this.f19182c -= i12;
                                this.f19180a = false;
                                return true;
                            }
                        } else if ((i11 & 240) != 32) {
                            pc.d("H263Reader", "Unexpected start code value");
                            a();
                        } else {
                            this.f19183d = this.f19182c;
                            this.f19181b = 4;
                        }
                    } else if (i11 > 31) {
                        pc.d("H263Reader", "Unexpected start code value");
                        a();
                    } else {
                        this.f19181b = 3;
                    }
                } else if (i11 != 181) {
                    pc.d("H263Reader", "Unexpected start code value");
                    a();
                } else {
                    this.f19181b = 2;
                }
            } else if (i11 == 176) {
                this.f19181b = 1;
                this.f19180a = true;
            }
            byte[] bArr = f19179f;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f19185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f19186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f19187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f19188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19189e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f19190f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f19191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f19192h;

        public b(qo qoVar) {
            this.f19185a = qoVar;
        }

        public void a() {
            this.f19186b = false;
            this.f19187c = false;
            this.f19188d = false;
            this.f19189e = -1;
        }

        public void a(int i11, long j11) {
            this.f19189e = i11;
            this.f19188d = false;
            this.f19186b = i11 == 182 || i11 == 179;
            this.f19187c = i11 == 182;
            this.f19190f = 0;
            this.f19192h = j11;
        }

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
        public void a(long j11, int i11, boolean z11) {
            if (this.f19189e == 182 && z11 && this.f19186b) {
                long j12 = this.f19192h;
                if (j12 != C.TIME_UNSET) {
                    this.f19185a.a(j12, this.f19188d ? 1 : 0, (int) (j11 - this.f19191g), i11, null);
                }
            }
            if (this.f19189e != 179) {
                this.f19191g = j11;
            }
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f19187c) {
                int i13 = this.f19190f;
                int i14 = (i11 + 1) - i13;
                if (i14 >= i12) {
                    this.f19190f = i13 + (i12 - i11);
                } else {
                    this.f19188d = ((bArr[i14] & 192) >> 6) == 0;
                    this.f19187c = false;
                }
            }
        }
    }

    public ga(vp vpVar) {
        this.f19168a = vpVar;
        if (vpVar != null) {
            this.f19172e = new yf(178, 128);
            this.f19169b = new bh();
        } else {
            this.f19172e = null;
            this.f19169b = null;
        }
    }

    private static f9 a(a aVar, int i11, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f19184e, aVar.f19182c);
        ah ahVar = new ah(bArrCopyOf);
        ahVar.e(i11);
        ahVar.e(4);
        ahVar.g();
        ahVar.d(8);
        if (ahVar.f()) {
            ahVar.d(4);
            ahVar.d(3);
        }
        int iA = ahVar.a(4);
        float f11 = 1.0f;
        if (iA == 15) {
            int iA2 = ahVar.a(8);
            int iA3 = ahVar.a(8);
            if (iA3 == 0) {
                pc.d("H263Reader", "Invalid aspect ratio");
            } else {
                f11 = iA2 / iA3;
            }
        } else {
            float[] fArr = f19167l;
            if (iA < fArr.length) {
                f11 = fArr[iA];
            } else {
                pc.d("H263Reader", "Invalid aspect ratio");
            }
        }
        if (ahVar.f()) {
            ahVar.d(2);
            ahVar.d(1);
            if (ahVar.f()) {
                ahVar.d(15);
                ahVar.g();
                ahVar.d(15);
                ahVar.g();
                ahVar.d(15);
                ahVar.g();
                ahVar.d(3);
                ahVar.d(11);
                ahVar.g();
                ahVar.d(15);
                ahVar.g();
            }
        }
        if (ahVar.a(2) != 0) {
            pc.d("H263Reader", "Unhandled video object layer shape");
        }
        ahVar.g();
        int iA4 = ahVar.a(16);
        ahVar.g();
        if (ahVar.f()) {
            if (iA4 == 0) {
                pc.d("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i12 = 0;
                for (int i13 = iA4 - 1; i13 > 0; i13 >>= 1) {
                    i12++;
                }
                ahVar.d(i12);
            }
        }
        ahVar.g();
        int iA5 = ahVar.a(13);
        ahVar.g();
        int iA6 = ahVar.a(13);
        ahVar.g();
        ahVar.g();
        return new f9.b().c(str).f(MimeTypes.VIDEO_MP4V).q(iA5).g(iA6).b(f11).a(Collections.singletonList(bArrCopyOf)).a();
    }

    @Override // com.applovin.impl.q7
    public void a() {
        zf.a(this.f19170c);
        this.f19171d.a();
        b bVar = this.f19173f;
        if (bVar != null) {
            bVar.a();
        }
        yf yfVar = this.f19172e;
        if (yfVar != null) {
            yfVar.b();
        }
        this.f19174g = 0L;
        this.f19178k = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f19178k = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        b1.b(this.f19173f);
        b1.b(this.f19176i);
        int iD = bhVar.d();
        int iE = bhVar.e();
        byte[] bArrC = bhVar.c();
        this.f19174g += (long) bhVar.a();
        this.f19176i.a(bhVar, bhVar.a());
        while (true) {
            int iA = zf.a(bArrC, iD, iE, this.f19170c);
            if (iA == iE) {
                break;
            }
            int i11 = iA + 3;
            int i12 = bhVar.c()[i11] & 255;
            int i13 = iA - iD;
            int i14 = 0;
            if (!this.f19177j) {
                if (i13 > 0) {
                    this.f19171d.a(bArrC, iD, iA);
                }
                if (this.f19171d.a(i12, i13 < 0 ? -i13 : 0)) {
                    qo qoVar = this.f19176i;
                    a aVar = this.f19171d;
                    qoVar.a(a(aVar, aVar.f19183d, (String) b1.a((Object) this.f19175h)));
                    this.f19177j = true;
                }
            }
            this.f19173f.a(bArrC, iD, iA);
            yf yfVar = this.f19172e;
            if (yfVar != null) {
                if (i13 > 0) {
                    yfVar.a(bArrC, iD, iA);
                } else {
                    i14 = -i13;
                }
                if (this.f19172e.a(i14)) {
                    yf yfVar2 = this.f19172e;
                    ((bh) xp.a(this.f19169b)).a(this.f19172e.f24665d, zf.c(yfVar2.f24665d, yfVar2.f24666e));
                    ((vp) xp.a(this.f19168a)).a(this.f19178k, this.f19169b);
                }
                if (i12 == 178 && bhVar.c()[iA + 2] == 1) {
                    this.f19172e.b(i12);
                }
            }
            int i15 = iE - iA;
            this.f19173f.a(this.f19174g - ((long) i15), i15, this.f19177j);
            this.f19173f.a(i12, this.f19178k);
            iD = i11;
        }
        if (!this.f19177j) {
            this.f19171d.a(bArrC, iD, iE);
        }
        this.f19173f.a(bArrC, iD, iE);
        yf yfVar3 = this.f19172e;
        if (yfVar3 != null) {
            yfVar3.a(bArrC, iD, iE);
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f19175h = dVar.b();
        qo qoVarA = m8Var.a(dVar.c(), 2);
        this.f19176i = qoVarA;
        this.f19173f = new b(qoVarA);
        vp vpVar = this.f19168a;
        if (vpVar != null) {
            vpVar.a(m8Var, dVar);
        }
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
