package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ia implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nj f19654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qo f19656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f19657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19658e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f19665l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f19659f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final yf f19660g = new yf(32, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final yf f19661h = new yf(33, 128);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final yf f19662i = new yf(34, 128);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final yf f19663j = new yf(39, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final yf f19664k = new yf(40, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f19666m = C.TIME_UNSET;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final bh f19667n = new bh();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f19668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f19669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f19670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f19671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f19672e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f19673f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f19674g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f19675h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f19676i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f19677j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f19678k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f19679l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f19680m;

        public a(qo qoVar) {
            this.f19668a = qoVar;
        }

        private static boolean a(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        private static boolean b(int i11) {
            return i11 < 32 || i11 == 40;
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
        private void c(int i11) {
            long j11 = this.f19679l;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f19680m;
            this.f19668a.a(j11, z11 ? 1 : 0, (int) (this.f19669b - this.f19678k), i11, null);
        }

        public void a() {
            this.f19673f = false;
            this.f19674g = false;
            this.f19675h = false;
            this.f19676i = false;
            this.f19677j = false;
        }

        public void a(long j11, int i11, int i12, long j12, boolean z11) {
            this.f19674g = false;
            this.f19675h = false;
            this.f19672e = j12;
            this.f19671d = 0;
            this.f19669b = j11;
            if (!b(i12)) {
                if (this.f19676i && !this.f19677j) {
                    if (z11) {
                        c(i11);
                    }
                    this.f19676i = false;
                }
                if (a(i12)) {
                    this.f19675h = !this.f19677j;
                    this.f19677j = true;
                }
            }
            boolean z12 = i12 >= 16 && i12 <= 21;
            this.f19670c = z12;
            this.f19673f = z12 || i12 <= 9;
        }

        public void a(long j11, int i11, boolean z11) {
            if (this.f19677j && this.f19674g) {
                this.f19680m = this.f19670c;
                this.f19677j = false;
            } else if (this.f19675h || this.f19674g) {
                if (z11 && this.f19676i) {
                    c(i11 + ((int) (j11 - this.f19669b)));
                }
                this.f19678k = this.f19669b;
                this.f19679l = this.f19672e;
                this.f19680m = this.f19670c;
                this.f19676i = true;
            }
        }

        public void a(byte[] bArr, int i11, int i12) {
            if (this.f19673f) {
                int i13 = this.f19671d;
                int i14 = (i11 + 2) - i13;
                if (i14 >= i12) {
                    this.f19671d = i13 + (i12 - i11);
                } else {
                    this.f19674g = (bArr[i14] & 128) != 0;
                    this.f19673f = false;
                }
            }
        }
    }

    public ia(nj njVar) {
        this.f19654a = njVar;
    }

    private static f9 a(String str, yf yfVar, yf yfVar2, yf yfVar3) {
        int i11 = yfVar.f24666e;
        byte[] bArr = new byte[yfVar2.f24666e + i11 + yfVar3.f24666e];
        System.arraycopy(yfVar.f24665d, 0, bArr, 0, i11);
        System.arraycopy(yfVar2.f24665d, 0, bArr, yfVar.f24666e, yfVar2.f24666e);
        System.arraycopy(yfVar3.f24665d, 0, bArr, yfVar.f24666e + yfVar2.f24666e, yfVar3.f24666e);
        ch chVar = new ch(yfVar2.f24665d, 0, yfVar2.f24666e);
        chVar.d(44);
        int iB = chVar.b(3);
        chVar.g();
        chVar.d(88);
        chVar.d(8);
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (chVar.c()) {
                i12 += 89;
            }
            if (chVar.c()) {
                i12 += 8;
            }
        }
        chVar.d(i12);
        if (iB > 0) {
            chVar.d((8 - iB) * 2);
        }
        chVar.f();
        int iF = chVar.f();
        if (iF == 3) {
            chVar.g();
        }
        int iF2 = chVar.f();
        int iF3 = chVar.f();
        if (chVar.c()) {
            int iF4 = chVar.f();
            int iF5 = chVar.f();
            int iF6 = chVar.f();
            int iF7 = chVar.f();
            iF2 -= ((iF == 1 || iF == 2) ? 2 : 1) * (iF4 + iF5);
            iF3 -= (iF == 1 ? 2 : 1) * (iF6 + iF7);
        }
        chVar.f();
        chVar.f();
        int iF8 = chVar.f();
        for (int i14 = chVar.c() ? 0 : iB; i14 <= iB; i14++) {
            chVar.f();
            chVar.f();
            chVar.f();
        }
        chVar.f();
        chVar.f();
        chVar.f();
        chVar.f();
        chVar.f();
        chVar.f();
        if (chVar.c() && chVar.c()) {
            a(chVar);
        }
        chVar.d(2);
        if (chVar.c()) {
            chVar.d(8);
            chVar.f();
            chVar.f();
            chVar.g();
        }
        b(chVar);
        if (chVar.c()) {
            for (int i15 = 0; i15 < chVar.f(); i15++) {
                chVar.d(iF8 + 5);
            }
        }
        chVar.d(2);
        float f11 = 1.0f;
        if (chVar.c()) {
            if (chVar.c()) {
                int iB2 = chVar.b(8);
                if (iB2 == 255) {
                    int iB3 = chVar.b(16);
                    int iB4 = chVar.b(16);
                    if (iB3 != 0 && iB4 != 0) {
                        f11 = iB3 / iB4;
                    }
                } else {
                    float[] fArr = zf.f24846b;
                    if (iB2 < fArr.length) {
                        f11 = fArr[iB2];
                    } else {
                        pc.d("H265Reader", "Unexpected aspect_ratio_idc value: " + iB2);
                    }
                }
            }
            if (chVar.c()) {
                chVar.g();
            }
            if (chVar.c()) {
                chVar.d(4);
                if (chVar.c()) {
                    chVar.d(24);
                }
            }
            if (chVar.c()) {
                chVar.f();
                chVar.f();
            }
            chVar.g();
            if (chVar.c()) {
                iF3 *= 2;
            }
        }
        chVar.a(yfVar2.f24665d, 0, yfVar2.f24666e);
        chVar.d(24);
        return new f9.b().c(str).f(MimeTypes.VIDEO_H265).a(o3.a(chVar)).q(iF2).g(iF3).b(f11).a(Collections.singletonList(bArr)).a();
    }

    private void a(long j11, int i11, int i12, long j12) {
        this.f19657d.a(j11, i11, this.f19658e);
        if (!this.f19658e) {
            this.f19660g.a(i12);
            this.f19661h.a(i12);
            this.f19662i.a(i12);
            if (this.f19660g.a() && this.f19661h.a() && this.f19662i.a()) {
                this.f19656c.a(a(this.f19655b, this.f19660g, this.f19661h, this.f19662i));
                this.f19658e = true;
            }
        }
        if (this.f19663j.a(i12)) {
            yf yfVar = this.f19663j;
            this.f19667n.a(this.f19663j.f24665d, zf.c(yfVar.f24665d, yfVar.f24666e));
            this.f19667n.g(5);
            this.f19654a.a(j12, this.f19667n);
        }
        if (this.f19664k.a(i12)) {
            yf yfVar2 = this.f19664k;
            this.f19667n.a(this.f19664k.f24665d, zf.c(yfVar2.f24665d, yfVar2.f24666e));
            this.f19667n.g(5);
            this.f19654a.a(j12, this.f19667n);
        }
    }

    private static void a(ch chVar) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (chVar.c()) {
                    int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        chVar.e();
                    }
                    for (int i14 = 0; i14 < iMin; i14++) {
                        chVar.e();
                    }
                } else {
                    chVar.f();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private void a(byte[] bArr, int i11, int i12) {
        this.f19657d.a(bArr, i11, i12);
        if (!this.f19658e) {
            this.f19660g.a(bArr, i11, i12);
            this.f19661h.a(bArr, i11, i12);
            this.f19662i.a(bArr, i11, i12);
        }
        this.f19663j.a(bArr, i11, i12);
        this.f19664k.a(bArr, i11, i12);
    }

    private void b(long j11, int i11, int i12, long j12) {
        this.f19657d.a(j11, i11, i12, j12, this.f19658e);
        if (!this.f19658e) {
            this.f19660g.b(i12);
            this.f19661h.b(i12);
            this.f19662i.b(i12);
        }
        this.f19663j.b(i12);
        this.f19664k.b(i12);
    }

    private static void b(ch chVar) {
        int iF = chVar.f();
        boolean zC = false;
        int i11 = 0;
        for (int i12 = 0; i12 < iF; i12++) {
            if (i12 != 0) {
                zC = chVar.c();
            }
            if (zC) {
                chVar.g();
                chVar.f();
                for (int i13 = 0; i13 <= i11; i13++) {
                    if (chVar.c()) {
                        chVar.g();
                    }
                }
            } else {
                int iF2 = chVar.f();
                int iF3 = chVar.f();
                int i14 = iF2 + iF3;
                for (int i15 = 0; i15 < iF2; i15++) {
                    chVar.f();
                    chVar.g();
                }
                for (int i16 = 0; i16 < iF3; i16++) {
                    chVar.f();
                    chVar.g();
                }
                i11 = i14;
            }
        }
    }

    private void c() {
        b1.b(this.f19656c);
        xp.a(this.f19657d);
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f19665l = 0L;
        this.f19666m = C.TIME_UNSET;
        zf.a(this.f19659f);
        this.f19660g.b();
        this.f19661h.b();
        this.f19662i.b();
        this.f19663j.b();
        this.f19664k.b();
        a aVar = this.f19657d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f19666m = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        c();
        while (bhVar.a() > 0) {
            int iD = bhVar.d();
            int iE = bhVar.e();
            byte[] bArrC = bhVar.c();
            this.f19665l += (long) bhVar.a();
            this.f19656c.a(bhVar, bhVar.a());
            while (iD < iE) {
                int iA = zf.a(bArrC, iD, iE, this.f19659f);
                if (iA == iE) {
                    a(bArrC, iD, iE);
                    return;
                }
                int iA2 = zf.a(bArrC, iA);
                int i11 = iA - iD;
                if (i11 > 0) {
                    a(bArrC, iD, iA);
                }
                int i12 = iE - iA;
                long j11 = this.f19665l - ((long) i12);
                a(j11, i12, i11 < 0 ? -i11 : 0, this.f19666m);
                b(j11, i12, iA2, this.f19666m);
                iD = iA + 3;
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f19655b = dVar.b();
        qo qoVarA = m8Var.a(dVar.c(), 2);
        this.f19656c = qoVarA;
        this.f19657d = new a(qoVarA);
        this.f19654a.a(m8Var, dVar);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
