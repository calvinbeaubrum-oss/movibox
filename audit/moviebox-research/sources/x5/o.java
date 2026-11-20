package x5;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f80094l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final k0 f80095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final z3.c0 f80096b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final u f80099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f80100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f80101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f80102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0 f80103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f80104j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f80097c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f80098d = new a(128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f80105k = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f80106f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f80107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f80108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f80109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f80110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f80111e;

        public a(int i11) {
            this.f80111e = new byte[i11];
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f80107a) {
                int i13 = i12 - i11;
                byte[] bArr2 = this.f80111e;
                int length = bArr2.length;
                int i14 = this.f80109c;
                if (length < i14 + i13) {
                    this.f80111e = Arrays.copyOf(bArr2, (i14 + i13) * 2);
                }
                System.arraycopy(bArr, i11, this.f80111e, this.f80109c, i13);
                this.f80109c += i13;
            }
        }

        public boolean b(int i11, int i12) {
            int i13 = this.f80108b;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i11 == 179 || i11 == 181) {
                                this.f80109c -= i12;
                                this.f80107a = false;
                                return true;
                            }
                        } else if ((i11 & 240) != 32) {
                            z3.o.h("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f80110d = this.f80109c;
                            this.f80108b = 4;
                        }
                    } else if (i11 > 31) {
                        z3.o.h("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f80108b = 3;
                    }
                } else if (i11 != 181) {
                    z3.o.h("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f80108b = 2;
                }
            } else if (i11 == 176) {
                this.f80108b = 1;
                this.f80107a = true;
            }
            byte[] bArr = f80106f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f80107a = false;
            this.f80109c = 0;
            this.f80108b = 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0 f80112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f80113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f80114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f80115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f80116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f80117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f80118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f80119h;

        public b(r0 r0Var) {
            this.f80112a = r0Var;
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f80114c) {
                int i13 = this.f80117f;
                int i14 = (i11 + 1) - i13;
                if (i14 >= i12) {
                    this.f80117f = i13 + (i12 - i11);
                } else {
                    this.f80115d = ((bArr[i14] & 192) >> 6) == 0;
                    this.f80114c = false;
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
            z3.a.g(this.f80119h != C.TIME_UNSET);
            if (this.f80116e == 182 && z11 && this.f80113b) {
                this.f80112a.f(this.f80119h, this.f80115d ? 1 : 0, (int) (j11 - this.f80118g), i11, null);
            }
            if (this.f80116e != 179) {
                this.f80118g = j11;
            }
        }

        public void c(int i11, long j11) {
            this.f80116e = i11;
            this.f80115d = false;
            this.f80113b = i11 == 182 || i11 == 179;
            this.f80114c = i11 == 182;
            this.f80117f = 0;
            this.f80119h = j11;
        }

        public void d() {
            this.f80113b = false;
            this.f80114c = false;
            this.f80115d = false;
            this.f80116e = -1;
        }
    }

    public o(@Nullable k0 k0Var) {
        this.f80095a = k0Var;
        if (k0Var != null) {
            this.f80099e = new u(178, 128);
            this.f80096b = new z3.c0();
        } else {
            this.f80099e = null;
            this.f80096b = null;
        }
    }

    public static androidx.media3.common.y a(a aVar, int i11, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f80111e, aVar.f80109c);
        z3.b0 b0Var = new z3.b0(bArrCopyOf);
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
                z3.o.h("H263Reader", "Invalid aspect ratio");
            } else {
                f11 = iH2 / iH3;
            }
        } else {
            float[] fArr = f80094l;
            if (iH < fArr.length) {
                f11 = fArr[iH];
            } else {
                z3.o.h("H263Reader", "Invalid aspect ratio");
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
            z3.o.h("H263Reader", "Unhandled video object layer shape");
        }
        b0Var.q();
        int iH4 = b0Var.h(16);
        b0Var.q();
        if (b0Var.g()) {
            if (iH4 == 0) {
                z3.o.h("H263Reader", "Invalid vop_increment_time_resolution");
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
        return new androidx.media3.common.y.b().X(str).k0(MimeTypes.VIDEO_MP4V).r0(iH5).V(iH6).g0(f11).Y(Collections.singletonList(bArrCopyOf)).I();
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        z3.a.i(this.f80100f);
        z3.a.i(this.f80103i);
        int iF = c0Var.f();
        int iG = c0Var.g();
        byte[] bArrE = c0Var.e();
        this.f80101g += (long) c0Var.a();
        this.f80103i.c(c0Var, c0Var.a());
        while (true) {
            int iC = a4.a.c(bArrE, iF, iG, this.f80097c);
            if (iC == iG) {
                break;
            }
            int i11 = iC + 3;
            int i12 = c0Var.e()[i11] & 255;
            int i13 = iC - iF;
            int i14 = 0;
            if (!this.f80104j) {
                if (i13 > 0) {
                    this.f80098d.a(bArrE, iF, iC);
                }
                if (this.f80098d.b(i12, i13 < 0 ? -i13 : 0)) {
                    r0 r0Var = this.f80103i;
                    a aVar = this.f80098d;
                    r0Var.b(a(aVar, aVar.f80110d, (String) z3.a.e(this.f80102h)));
                    this.f80104j = true;
                }
            }
            this.f80100f.a(bArrE, iF, iC);
            u uVar = this.f80099e;
            if (uVar != null) {
                if (i13 > 0) {
                    uVar.a(bArrE, iF, iC);
                } else {
                    i14 = -i13;
                }
                if (this.f80099e.b(i14)) {
                    u uVar2 = this.f80099e;
                    ((z3.c0) u0.i(this.f80096b)).S(this.f80099e.f80241d, a4.a.q(uVar2.f80241d, uVar2.f80242e));
                    ((k0) u0.i(this.f80095a)).a(this.f80105k, this.f80096b);
                }
                if (i12 == 178 && c0Var.e()[iC + 2] == 1) {
                    this.f80099e.e(i12);
                }
            }
            int i15 = iG - iC;
            this.f80100f.b(this.f80101g - ((long) i15), i15, this.f80104j);
            this.f80100f.c(i12, this.f80105k);
            iF = i11;
        }
        if (!this.f80104j) {
            this.f80098d.a(bArrE, iF, iG);
        }
        this.f80100f.a(bArrE, iF, iG);
        u uVar3 = this.f80099e;
        if (uVar3 != null) {
            uVar3.a(bArrE, iF, iG);
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80105k = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80102h = dVar.b();
        r0 r0VarTrack = uVar.track(dVar.c(), 2);
        this.f80103i = r0VarTrack;
        this.f80100f = new b(r0VarTrack);
        k0 k0Var = this.f80095a;
        if (k0Var != null) {
            k0Var.b(uVar, dVar);
        }
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        a4.a.a(this.f80097c);
        this.f80098d.c();
        b bVar = this.f80100f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f80099e;
        if (uVar != null) {
            uVar.d();
        }
        this.f80101g = 0L;
        this.f80105k = C.TIME_UNSET;
    }
}
