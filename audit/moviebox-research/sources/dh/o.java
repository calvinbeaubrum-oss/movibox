package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o implements m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f63241l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final k0 f63242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.util.c0 f63243b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final u f63246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f63247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f63248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f63249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public tg.e0 f63250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f63251j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f63244c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f63245d = new a(128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f63252k = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f63253f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f63254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f63255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f63256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f63257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f63258e;

        public a(int i11) {
            this.f63258e = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f63254a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f63258e;
                int length = bArr2.length;
                int i14 = this.f63256c;
                if (length < i14 + i13) {
                    this.f63258e = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f63258e, this.f63256c, i13);
                this.f63256c += i13;
            }
        }

        public boolean b(int i11, int i12) {
            int i13 = this.f63255b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i11 == 179 || i11 == 181) {
                                this.f63256c -= i12;
                                this.f63254a = false;
                                return true;
                            }
                        } else if ((i11 & 240) != 32) {
                            com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f63257d = this.f63256c;
                            this.f63255b = 4;
                        }
                    } else if (i11 > 31) {
                        com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f63255b = 3;
                    }
                } else if (i11 != 181) {
                    com.google.android.exoplayer2.util.s.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f63255b = 2;
                }
            } else if (i11 == 176) {
                this.f63255b = 1;
                this.f63254a = true;
            }
            byte[] bArr = f63253f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f63254a = false;
            this.f63256c = 0;
            this.f63255b = 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tg.e0 f63259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f63260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f63261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f63262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f63263e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f63264f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f63265g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f63266h;

        public b(tg.e0 e0Var) {
            this.f63259a = e0Var;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f63261c) {
                int i13 = this.f63264f;
                int i14 = (i11 + 1) - i13;
                if (i14 >= i12) {
                    this.f63264f = i13 + (i12 - i11);
                } else {
                    this.f63262d = ((bArr[i14] & 192) >> 6) == 0;
                    this.f63261c = false;
                }
            }
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
        public void b(long j11, int i11, boolean z11) {
            if (this.f63263e == 182 && z11 && this.f63260b) {
                long j12 = this.f63266h;
                if (j12 != C.TIME_UNSET) {
                    this.f63259a.d(j12, this.f63262d ? 1 : 0, (int) (j11 - this.f63265g), i11, null);
                }
            }
            if (this.f63263e != 179) {
                this.f63265g = j11;
            }
        }

        public void c(int i11, long j11) {
            this.f63263e = i11;
            this.f63262d = false;
            this.f63260b = i11 == 182 || i11 == 179;
            this.f63261c = i11 == 182;
            this.f63264f = 0;
            this.f63266h = j11;
        }

        public void d() {
            this.f63260b = false;
            this.f63261c = false;
            this.f63262d = false;
            this.f63263e = -1;
        }
    }

    public o(@Nullable k0 k0Var) {
        this.f63242a = k0Var;
        if (k0Var != null) {
            this.f63246e = new u(178, 128);
            this.f63243b = new com.google.android.exoplayer2.util.c0();
        } else {
            this.f63246e = null;
            this.f63243b = null;
        }
    }

    public static m1 a(a aVar, int i11, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f63258e, aVar.f63256c);
        com.google.android.exoplayer2.util.b0 b0Var = new com.google.android.exoplayer2.util.b0(bArrCopyOf);
        b0Var.s(i11);
        b0Var.s(4);
        b0Var.q();
        b0Var.r(8);
        if (b0Var.g()) {
            b0Var.r(4);
            b0Var.r(3);
        }
        int iH = b0Var.h(4);
        float f11 = 1.0f;
        if (iH == 15) {
            int iH2 = b0Var.h(8);
            int iH3 = b0Var.h(8);
            if (iH3 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            } else {
                f11 = iH2 / iH3;
            }
        } else {
            float[] fArr = f63241l;
            if (iH < fArr.length) {
                f11 = fArr[iH];
            } else {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (b0Var.g()) {
            b0Var.r(2);
            b0Var.r(1);
            if (b0Var.g()) {
                b0Var.r(15);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
                b0Var.r(3);
                b0Var.r(11);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
            }
        }
        if (b0Var.h(2) != 0) {
            com.google.android.exoplayer2.util.s.i("H263Reader", "Unhandled video object layer shape");
        }
        b0Var.q();
        int iH4 = b0Var.h(16);
        b0Var.q();
        if (b0Var.g()) {
            if (iH4 == 0) {
                com.google.android.exoplayer2.util.s.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i12 = 0;
                for (int i13 = iH4 - 1; i13 > 0; i13 >>= 1) {
                    i12++;
                }
                b0Var.r(i12);
            }
        }
        b0Var.q();
        int iH5 = b0Var.h(13);
        b0Var.q();
        int iH6 = b0Var.h(13);
        b0Var.q();
        b0Var.q();
        return new m1.b().S(str).e0(MimeTypes.VIDEO_MP4V).j0(iH5).Q(iH6).a0(f11).T(Collections.singletonList(bArrCopyOf)).E();
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63247f);
        com.google.android.exoplayer2.util.a.i(this.f63250i);
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f63248g += (long) c0Var.a();
        this.f63250i.c(c0Var, c0Var.a());
        while (true) {
            int iC = com.google.android.exoplayer2.util.x.c(bArrD, iE, iF, this.f63244c);
            if (iC == iF) {
                break;
            }
            int i11 = iC + 3;
            int i12 = c0Var.d()[i11] & 255;
            int i13 = iC - iE;
            int i14 = 0;
            if (!this.f63251j) {
                if (i13 > 0) {
                    this.f63245d.a(bArrD, iE, iC);
                }
                if (this.f63245d.b(i12, i13 < 0 ? -i13 : 0)) {
                    tg.e0 e0Var = this.f63250i;
                    a aVar = this.f63245d;
                    e0Var.e(a(aVar, aVar.f63257d, (String) com.google.android.exoplayer2.util.a.e(this.f63249h)));
                    this.f63251j = true;
                }
            }
            this.f63247f.a(bArrD, iE, iC);
            u uVar = this.f63246e;
            if (uVar != null) {
                if (i13 > 0) {
                    uVar.a(bArrD, iE, iC);
                } else {
                    i14 = -i13;
                }
                if (this.f63246e.b(i14)) {
                    u uVar2 = this.f63246e;
                    ((com.google.android.exoplayer2.util.c0) o0.j(this.f63243b)).N(this.f63246e.f63385d, com.google.android.exoplayer2.util.x.q(uVar2.f63385d, uVar2.f63386e));
                    ((k0) o0.j(this.f63242a)).a(this.f63252k, this.f63243b);
                }
                if (i12 == 178 && c0Var.d()[iC + 2] == 1) {
                    this.f63246e.e(i12);
                }
            }
            int i15 = iF - iC;
            this.f63247f.b(this.f63248g - ((long) i15), i15, this.f63251j);
            this.f63247f.c(i12, this.f63252k);
            iE = i11;
        }
        if (!this.f63251j) {
            this.f63245d.a(bArrD, iE, iF);
        }
        this.f63247f.a(bArrD, iE, iF);
        u uVar3 = this.f63246e;
        if (uVar3 != null) {
            uVar3.a(bArrD, iE, iF);
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63252k = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63249h = dVar.b();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f63250i = e0VarTrack;
        this.f63247f = new b(e0VarTrack);
        k0 k0Var = this.f63242a;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        com.google.android.exoplayer2.util.x.a(this.f63244c);
        this.f63245d.c();
        b bVar = this.f63247f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f63246e;
        if (uVar != null) {
            uVar.d();
        }
        this.f63248g = 0L;
        this.f63252k = C.TIME_UNSET;
    }
}
