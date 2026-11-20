package com.applovin.impl;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Function;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f20072a = xp.c("OpusHead");

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f20076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f20077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final bh f20078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final bh f20079g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20080h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20081i;

        public a(bh bhVar, bh bhVar2, boolean z11) throws dh {
            this.f20079g = bhVar;
            this.f20078f = bhVar2;
            this.f20077e = z11;
            bhVar2.f(12);
            this.f20073a = bhVar2.A();
            bhVar.f(12);
            this.f20081i = bhVar.A();
            n8.a(bhVar.j() == 1, "first_chunk must be 1");
            this.f20074b = -1;
        }

        public boolean a() {
            int i11 = this.f20074b + 1;
            this.f20074b = i11;
            if (i11 == this.f20073a) {
                return false;
            }
            this.f20076d = this.f20077e ? this.f20078f.B() : this.f20078f.y();
            if (this.f20074b == this.f20080h) {
                this.f20075c = this.f20079g.A();
                this.f20079g.g(4);
                int i12 = this.f20081i - 1;
                this.f20081i = i12;
                this.f20080h = i12 > 0 ? this.f20079g.A() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mo[] f20082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f9 f20083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20085d = 0;

        public c(int i11) {
            this.f20082a = new mo[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f20086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final bh f20088c;

        public d(j1.b bVar, f9 f9Var) {
            bh bhVar = bVar.f19811b;
            this.f20088c = bhVar;
            bhVar.f(12);
            int iA = bhVar.A();
            if (MimeTypes.AUDIO_RAW.equals(f9Var.f18900m)) {
                int iB = xp.b(f9Var.B, f9Var.f18913z);
                if (iA == 0 || iA % iB != 0) {
                    pc.d("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iB + ", stsz sample size: " + iA);
                    iA = iB;
                }
            }
            this.f20086a = iA == 0 ? -1 : iA;
            this.f20087b = bhVar.A();
        }

        @Override // com.applovin.impl.k1.b
        public int a() {
            return this.f20086a;
        }

        @Override // com.applovin.impl.k1.b
        public int b() {
            return this.f20087b;
        }

        @Override // com.applovin.impl.k1.b
        public int c() {
            int i11 = this.f20086a;
            return i11 == -1 ? this.f20088c.A() : i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bh f20089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f20091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20093e;

        public e(j1.b bVar) {
            bh bhVar = bVar.f19811b;
            this.f20089a = bhVar;
            bhVar.f(12);
            this.f20091c = bhVar.A() & 255;
            this.f20090b = bhVar.A();
        }

        @Override // com.applovin.impl.k1.b
        public int a() {
            return -1;
        }

        @Override // com.applovin.impl.k1.b
        public int b() {
            return this.f20090b;
        }

        @Override // com.applovin.impl.k1.b
        public int c() {
            int i11 = this.f20091c;
            if (i11 == 8) {
                return this.f20089a.w();
            }
            if (i11 == 16) {
                return this.f20089a.C();
            }
            int i12 = this.f20092d;
            this.f20092d = i12 + 1;
            if (i12 % 2 != 0) {
                return this.f20093e & 15;
            }
            int iW = this.f20089a.w();
            this.f20093e = iW;
            return (iW & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f20094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f20095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f20096c;

        public f(int i11, long j11, int i12) {
            this.f20094a = i11;
            this.f20095b = j11;
            this.f20096c = i12;
        }
    }

    private static int a(int i11) {
        if (i11 == 1936684398) {
            return 1;
        }
        if (i11 == 1986618469) {
            return 2;
        }
        if (i11 == 1952807028 || i11 == 1935832172 || i11 == 1937072756 || i11 == 1668047728) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    private static int a(bh bhVar, int i11, int i12) throws dh {
        int iD = bhVar.d();
        while (iD - i11 < i12) {
            bhVar.f(iD);
            int iJ = bhVar.j();
            n8.a(iJ > 0, "childAtomSize must be positive");
            if (bhVar.j() == 1702061171) {
                return iD;
            }
            iD += iJ;
        }
        return -1;
    }

    private static Pair a(bh bhVar, int i11) {
        bhVar.f(i11 + 12);
        bhVar.g(1);
        b(bhVar);
        bhVar.g(2);
        int iW = bhVar.w();
        if ((iW & 128) != 0) {
            bhVar.g(2);
        }
        if ((iW & 64) != 0) {
            bhVar.g(bhVar.C());
        }
        if ((iW & 32) != 0) {
            bhVar.g(2);
        }
        bhVar.g(1);
        b(bhVar);
        String strA = Cif.a(bhVar.w());
        if (MimeTypes.AUDIO_MPEG.equals(strA) || MimeTypes.AUDIO_DTS.equals(strA) || MimeTypes.AUDIO_DTS_HD.equals(strA)) {
            return Pair.create(strA, null);
        }
        bhVar.g(12);
        bhVar.g(1);
        int iB = b(bhVar);
        byte[] bArr = new byte[iB];
        bhVar.a(bArr, 0, iB);
        return Pair.create(strA, bArr);
    }

    private static Pair a(j1.a aVar) {
        j1.b bVarE = aVar.e(1701606260);
        if (bVarE == null) {
            return null;
        }
        bh bhVar = bVarE.f19811b;
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        int iA = bhVar.A();
        long[] jArr = new long[iA];
        long[] jArr2 = new long[iA];
        for (int i11 = 0; i11 < iA; i11++) {
            jArr[i11] = iC == 1 ? bhVar.B() : bhVar.y();
            jArr2[i11] = iC == 1 ? bhVar.s() : bhVar.j();
            if (bhVar.u() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            bhVar.g(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair a(j1.b bVar) {
        bh bhVar = bVar.f19811b;
        bhVar.f(8);
        bf bfVarE = null;
        bf bfVarD = null;
        while (bhVar.a() >= 8) {
            int iD = bhVar.d();
            int iJ = bhVar.j();
            int iJ2 = bhVar.j();
            if (iJ2 == 1835365473) {
                bhVar.f(iD);
                bfVarE = e(bhVar, iD + iJ);
            } else if (iJ2 == 1936553057) {
                bhVar.f(iD);
                bfVarD = d(bhVar, iD + iJ);
            }
            bhVar.f(iD + iJ);
        }
        return Pair.create(bfVarE, bfVarD);
    }

    private static c a(bh bhVar, int i11, int i12, String str, y6 y6Var, boolean z11) throws dh {
        int i13;
        bhVar.f(12);
        int iJ = bhVar.j();
        c cVar = new c(iJ);
        for (int i14 = 0; i14 < iJ; i14++) {
            int iD = bhVar.d();
            int iJ2 = bhVar.j();
            n8.a(iJ2 > 0, "childAtomSize must be positive");
            int iJ3 = bhVar.j();
            if (iJ3 == 1635148593 || iJ3 == 1635148595 || iJ3 == 1701733238 || iJ3 == 1831958048 || iJ3 == 1836070006 || iJ3 == 1752589105 || iJ3 == 1751479857 || iJ3 == 1932670515 || iJ3 == 1211250227 || iJ3 == 1987063864 || iJ3 == 1987063865 || iJ3 == 1635135537 || iJ3 == 1685479798 || iJ3 == 1685479729 || iJ3 == 1685481573 || iJ3 == 1685481521) {
                i13 = iD;
                a(bhVar, iJ3, i13, iJ2, i11, i12, y6Var, cVar, i14);
            } else if (iJ3 == 1836069985 || iJ3 == 1701733217 || iJ3 == 1633889587 || iJ3 == 1700998451 || iJ3 == 1633889588 || iJ3 == 1685353315 || iJ3 == 1685353317 || iJ3 == 1685353320 || iJ3 == 1685353324 || iJ3 == 1685353336 || iJ3 == 1935764850 || iJ3 == 1935767394 || iJ3 == 1819304813 || iJ3 == 1936684916 || iJ3 == 1953984371 || iJ3 == 778924082 || iJ3 == 778924083 || iJ3 == 1835557169 || iJ3 == 1835560241 || iJ3 == 1634492771 || iJ3 == 1634492791 || iJ3 == 1970037111 || iJ3 == 1332770163 || iJ3 == 1716281667) {
                i13 = iD;
                a(bhVar, iJ3, iD, iJ2, i11, str, z11, y6Var, cVar, i14);
            } else {
                if (iJ3 == 1414810956 || iJ3 == 1954034535 || iJ3 == 2004251764 || iJ3 == 1937010800 || iJ3 == 1664495672) {
                    a(bhVar, iJ3, iD, iJ2, i11, str, cVar);
                } else if (iJ3 == 1835365492) {
                    a(bhVar, iJ3, iD, i11, cVar);
                } else if (iJ3 == 1667329389) {
                    cVar.f20083b = new f9.b().h(i11).f(MimeTypes.APPLICATION_CAMERA_MOTION).a();
                }
                i13 = iD;
            }
            bhVar.f(i13 + iJ2);
        }
        return cVar;
    }

    private static lo a(j1.a aVar, j1.b bVar, long j11, y6 y6Var, boolean z11, boolean z12) throws dh {
        long[] jArr;
        long[] jArr2;
        j1.a aVarD;
        Pair pairA;
        j1.a aVar2 = (j1.a) b1.a(aVar.d(1835297121));
        int iA = a(c(((j1.b) b1.a(aVar2.e(1751411826))).f19811b));
        if (iA == -1) {
            return null;
        }
        f fVarF = f(((j1.b) b1.a(aVar.e(1953196132))).f19811b);
        long jC = C.TIME_UNSET;
        long j12 = j11 == C.TIME_UNSET ? fVarF.f20095b : j11;
        long jE = e(bVar.f19811b);
        if (j12 != C.TIME_UNSET) {
            jC = xp.c(j12, 1000000L, jE);
        }
        long j13 = jC;
        j1.a aVar3 = (j1.a) b1.a(((j1.a) b1.a(aVar2.d(1835626086))).d(1937007212));
        Pair pairD = d(((j1.b) b1.a(aVar2.e(1835296868))).f19811b);
        c cVarA = a(((j1.b) b1.a(aVar3.e(1937011556))).f19811b, fVarF.f20094a, fVarF.f20096c, (String) pairD.second, y6Var, z12);
        if (z11 || (aVarD = aVar.d(1701082227)) == null || (pairA = a(aVarD)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairA.first;
            jArr2 = (long[]) pairA.second;
            jArr = jArr3;
        }
        if (cVarA.f20083b == null) {
            return null;
        }
        return new lo(fVarF.f20094a, iA, ((Long) pairD.first).longValue(), jE, j13, cVarA.f20083b, cVarA.f20085d, cVarA.f20082a, cVarA.f20084c, jArr, jArr2);
    }

    private static mo a(bh bhVar, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            bhVar.f(i15);
            int iJ = bhVar.j();
            if (bhVar.j() == 1952804451) {
                int iC = j1.c(bhVar.j());
                bhVar.g(1);
                if (iC == 0) {
                    bhVar.g(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int iW = bhVar.w();
                    i13 = iW & 15;
                    i14 = (iW & 240) >> 4;
                }
                boolean z11 = bhVar.w() == 1;
                int iW2 = bhVar.w();
                byte[] bArr2 = new byte[16];
                bhVar.a(bArr2, 0, 16);
                if (z11 && iW2 == 0) {
                    int iW3 = bhVar.w();
                    bArr = new byte[iW3];
                    bhVar.a(bArr, 0, iW3);
                }
                return new mo(z11, str, iW2, bArr2, i14, i13, bArr);
            }
            i15 += iJ;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0247  */
    /* JADX WARN: Code duplicated, block: B:111:0x0288  */
    /* JADX WARN: Code duplicated, block: B:112:0x028b  */
    /* JADX WARN: Code duplicated, block: B:117:0x02af  */
    /* JADX WARN: Code duplicated, block: B:119:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:138:0x035f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0368  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:152:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:156:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:158:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:161:0x0402  */
    /* JADX WARN: Code duplicated, block: B:166:0x0413  */
    /* JADX WARN: Code duplicated, block: B:167:0x0415  */
    /* JADX WARN: Code duplicated, block: B:169:0x0419  */
    /* JADX WARN: Code duplicated, block: B:173:0x0434  */
    /* JADX WARN: Code duplicated, block: B:174:0x0436  */
    /* JADX WARN: Code duplicated, block: B:177:0x043b  */
    /* JADX WARN: Code duplicated, block: B:178:0x043e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0441  */
    /* JADX WARN: Code duplicated, block: B:181:0x0444  */
    /* JADX WARN: Code duplicated, block: B:183:0x0447  */
    /* JADX WARN: Code duplicated, block: B:184:0x0449  */
    /* JADX WARN: Code duplicated, block: B:186:0x044d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0450  */
    /* JADX WARN: Code duplicated, block: B:191:0x045f  */
    /* JADX WARN: Code duplicated, block: B:193:0x046d  */
    /* JADX WARN: Code duplicated, block: B:194:0x047d  */
    /* JADX WARN: Code duplicated, block: B:197:0x0485  */
    /* JADX WARN: Code duplicated, block: B:199:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:210:0x042a A[EDGE_INSN: B:210:0x042a->B:171:0x042a BREAK  A[LOOP:2: B:154:0x03c7->B:170:0x0422], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x040c A[ADDED_TO_REGION, EDGE_INSN: B:213:0x040c->B:164:0x040c BREAK  A[LOOP:3: B:159:0x03fc->B:163:0x0407], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x04bc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x017b A[EDGE_INSN: B:223:0x017b->B:63:0x017b BREAK  A[LOOP:7: B:59:0x015e->B:62:0x0166], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x022c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:50:0x0100  */
    /* JADX WARN: Code duplicated, block: B:53:0x010c A[LOOP:0: B:51:0x0106->B:53:0x010c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0132  */
    /* JADX WARN: Code duplicated, block: B:58:0x0158  */
    /* JADX WARN: Code duplicated, block: B:60:0x0160  */
    /* JADX WARN: Code duplicated, block: B:62:0x0166 A[LOOP:7: B:59:0x015e->B:62:0x0166, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x019f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x01a1 A[ADDED_TO_REGION, LOOP:8: B:67:0x01a1->B:69:0x01a5, LOOP_START, PHI: r16 r21 r24
  0x01a1: PHI (r16v7 int) = (r16v3 int), (r16v8 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r21v5 int) = (r21v1 int), (r21v6 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r24v3 int) = (r24v1 int), (r24v5 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x01be  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:93:0x0224 A[DONT_INVERT, LOOP:9: B:93:0x0224->B:97:0x022e, LOOP_START, PHI: r16
  0x0224: PHI (r16v4 int) = (r16v3 int), (r16v5 int) binds: [B:92:0x0222, B:97:0x022e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0226  */
    /* JADX WARN: Code duplicated, block: B:97:0x022e A[LOOP:9: B:93:0x0224->B:97:0x022e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x0234 A[EDGE_INSN: B:98:0x0234->B:99:0x0235 BREAK  A[LOOP:9: B:93:0x0224->B:97:0x022e]] */
    private static ro a(lo loVar, j1.a aVar, z9 z9Var) throws dh {
        b eVar;
        boolean z11;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        boolean z12;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int iA5;
        int i11;
        int i12;
        int iJ;
        int i13;
        int iA6;
        long j11;
        long j12;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        boolean z13;
        int i23;
        lo loVar2;
        String str;
        int i24;
        long[] jArr;
        int[] iArr;
        int i25;
        long j13;
        long[] jArr2;
        int[] iArr2;
        long j14;
        int i26;
        boolean zA;
        int i27;
        int i28;
        int iC;
        int i29;
        int iA7;
        int iJ2;
        int i31;
        long jC;
        long[] jArr3;
        int i32;
        int i33;
        long[] jArr4;
        boolean z14;
        int[] iArr3;
        int[] iArr4;
        long[] jArr5;
        int i34;
        int i35;
        boolean z15;
        int i36;
        long[] jArr6;
        long[] jArr7;
        int[] iArr5;
        int i37;
        boolean z16;
        boolean z17;
        long[] jArr8;
        int[] iArr6;
        int i38;
        int[] iArr7;
        long[] jArr9;
        int i39;
        int[] iArr8;
        long j15;
        int i40;
        long j16;
        int i41;
        int i42;
        int[] iArr9;
        long j17;
        boolean z18;
        boolean z19;
        int i43;
        int i44;
        int i45;
        boolean z21;
        long[] jArr10;
        int[] iArr10;
        j1.b bVarE = aVar.e(1937011578);
        if (bVarE != null) {
            eVar = new d(bVarE, loVar.f20492f);
        } else {
            j1.b bVarE2 = aVar.e(1937013298);
            if (bVarE2 == null) {
                throw dh.a("Track has no sample table size information", null);
            }
            eVar = new e(bVarE2);
        }
        int iB = eVar.b();
        if (iB == 0) {
            return new ro(loVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        j1.b bVarE3 = aVar.e(1937007471);
        if (bVarE3 == null) {
            bVarE3 = (j1.b) b1.a(aVar.e(1668232756));
            z11 = true;
        } else {
            z11 = false;
        }
        bh bhVar = bVarE3.f19811b;
        bh bhVar2 = ((j1.b) b1.a(aVar.e(1937011555))).f19811b;
        bh bhVar3 = ((j1.b) b1.a(aVar.e(1937011827))).f19811b;
        j1.b bVarE4 = aVar.e(1937011571);
        bh bhVar4 = bVarE4 != null ? bVarE4.f19811b : null;
        j1.b bVarE5 = aVar.e(1668576371);
        bh bhVar5 = bVarE5 != null ? bVarE5.f19811b : null;
        a aVar2 = new a(bhVar2, bhVar, z11);
        bhVar3.f(12);
        int iA8 = bhVar3.A() - 1;
        int iA9 = bhVar3.A();
        int iA10 = bhVar3.A();
        if (bhVar5 != null) {
            bhVar5.f(12);
            iA = bhVar5.A();
        } else {
            iA = 0;
        }
        if (bhVar4 != null) {
            bhVar4.f(12);
            iA2 = bhVar4.A();
            if (iA2 > 0) {
                iA3 = bhVar4.A() - 1;
            } else {
                bhVar4 = null;
            }
            iA4 = eVar.a();
            String str2 = loVar.f20492f.f18900m;
            if (iA4 == -1 && ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && iA8 == 0 && iA == 0 && iA2 == 0)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i46 = aVar2.f20073a;
                jArr10 = new long[i46];
                iArr10 = new int[i46];
                while (aVar2.a()) {
                    int i47 = aVar2.f20074b;
                    jArr10[i47] = aVar2.f20076d;
                    iArr10[i47] = aVar2.f20075c;
                }
                s8.b bVarA = s8.a(iA4, jArr10, iArr10, iA10);
                long[] jArr11 = bVarA.f22305a;
                int[] iArr11 = bVarA.f22306b;
                int i48 = bVarA.f22307c;
                long[] jArr12 = bVarA.f22308d;
                int[] iArr12 = bVarA.f22309e;
                long j18 = bVarA.f22310f;
                loVar2 = loVar;
                i24 = iB;
                jArr = jArr11;
                iArr = iArr11;
                i25 = i48;
                iArr2 = iArr12;
                j13 = j18;
                jArr2 = jArr12;
            } else {
                jArrCopyOf = new long[iB];
                iArrCopyOf = new int[iB];
                jArrCopyOf2 = new long[iB];
                iArrCopyOf2 = new int[iB];
                iA5 = iA3;
                i11 = 0;
                i12 = 0;
                iJ = 0;
                i13 = 0;
                iA6 = 0;
                j11 = 0;
                j12 = 0;
                i14 = iA;
                i15 = iA10;
                i16 = iA9;
                i17 = iA8;
                i18 = iA2;
                while (true) {
                    i19 = i17;
                    if (i11 < iB) {
                        i21 = i16;
                        i22 = i13;
                        break;
                    }
                    j14 = j12;
                    i26 = i13;
                    zA = true;
                    while (i26 == 0) {
                        zA = aVar2.a();
                        if (zA) {
                            break;
                        }
                        int i49 = i16;
                        long j19 = aVar2.f20076d;
                        i26 = aVar2.f20075c;
                        j14 = j19;
                        i16 = i49;
                        i15 = i15;
                        iB = iB;
                    }
                    i27 = iB;
                    i21 = i16;
                    i28 = i15;
                    if (!zA) {
                        pc.d("AtomParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                        iB = i11;
                        i22 = i26;
                        break;
                    }
                    if (bhVar5 != null) {
                        while (iA6 == 0 && i14 > 0) {
                            iA6 = bhVar5.A();
                            iJ = bhVar5.j();
                            i14--;
                        }
                        iA6--;
                    }
                    int i50 = iJ;
                    jArrCopyOf[i11] = j14;
                    iC = eVar.c();
                    iArrCopyOf[i11] = iC;
                    if (iC > i12) {
                        i12 = iC;
                    }
                    jArrCopyOf2[i11] = j11 + ((long) i50);
                    if (bhVar4 == null) {
                        i29 = 1;
                    } else {
                        i29 = 0;
                    }
                    iArrCopyOf2[i11] = i29;
                    if (i11 == iA5) {
                        iArrCopyOf2[i11] = 1;
                        i18--;
                        if (i18 > 0) {
                            iA5 = ((bh) b1.a(bhVar4)).A() - 1;
                        }
                    }
                    int i51 = iA5;
                    j11 += (long) i28;
                    iA7 = i21 - 1;
                    if (iA7 == 0 || i19 <= 0) {
                        iJ2 = i28;
                        i31 = i19;
                    } else {
                        iA7 = bhVar3.A();
                        iJ2 = bhVar3.j();
                        i31 = i19 - 1;
                    }
                    int i52 = iA7;
                    long j21 = j14 + ((long) iArrCopyOf[i11]);
                    i13 = i26 - 1;
                    i11++;
                    j12 = j21;
                    iA5 = i51;
                    i15 = iJ2;
                    iB = i27;
                    iJ = i50;
                    i17 = i31;
                    i16 = i52;
                }
                long j22 = j11 + ((long) iJ);
                if (bhVar5 != null) {
                    z13 = true;
                    break;
                }
                while (true) {
                    if (i14 > 0) {
                        z13 = true;
                        break;
                    }
                    if (bhVar5.A() != 0) {
                        z13 = false;
                        break;
                    }
                    bhVar5.j();
                    i14--;
                }
                if (i18 != 0 && i21 == 0 && i22 == 0 && i19 == 0) {
                    i23 = iA6;
                    if (i23 == 0 && z13) {
                        loVar2 = loVar;
                    }
                    i24 = iB;
                    jArr = jArrCopyOf;
                    iArr = iArrCopyOf;
                    i25 = i12;
                    j13 = j22;
                    jArr2 = jArrCopyOf2;
                    iArr2 = iArrCopyOf2;
                } else {
                    i23 = iA6;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Inconsistent stbl box for track ");
                loVar2 = loVar;
                sb2.append(loVar2.f20487a);
                sb2.append(": remainingSynchronizationSamples ");
                sb2.append(i18);
                sb2.append(", remainingSamplesAtTimestampDelta ");
                sb2.append(i21);
                sb2.append(", remainingSamplesInChunk ");
                sb2.append(i22);
                sb2.append(", remainingTimestampDeltaChanges ");
                sb2.append(i19);
                sb2.append(", remainingSamplesAtTimestampOffset ");
                sb2.append(i23);
                if (z13) {
                    str = "";
                } else {
                    str = ", ctts invalid";
                }
                sb2.append(str);
                pc.d("AtomParsers", sb2.toString());
                i24 = iB;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i25 = i12;
                j13 = j22;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            }
            jC = xp.c(j13, 1000000L, loVar2.f20489c);
            jArr3 = loVar2.f20494h;
            if (jArr3 == null) {
                xp.a(jArr2, 1000000L, loVar2.f20489c);
                return new ro(loVar, jArr, iArr, i25, jArr2, iArr2, jC);
            }
            if (jArr3.length != 1 && loVar2.f20488b == 1 && jArr2.length >= 2) {
                long j23 = ((long[]) b1.a(loVar2.f20495i))[0];
                long jC2 = j23 + xp.c(loVar2.f20494h[0], loVar2.f20489c, loVar2.f20490d);
                i32 = i24;
                if (a(jArr2, j13, j23, jC2)) {
                    long jC3 = xp.c(j23 - jArr2[0], loVar2.f20492f.A, loVar2.f20489c);
                    i33 = i25;
                    long jC4 = xp.c(j13 - jC2, loVar2.f20492f.A, loVar2.f20489c);
                    if ((jC3 != 0 || jC4 != 0) && jC3 <= 2147483647L && jC4 <= 2147483647L) {
                        z9Var.f24824a = (int) jC3;
                        z9Var.f24825b = (int) jC4;
                        xp.a(jArr2, 1000000L, loVar2.f20489c);
                        return new ro(loVar, jArr, iArr, i33, jArr2, iArr2, xp.c(loVar2.f20494h[0], 1000000L, loVar2.f20490d));
                    }
                }
                jArr4 = loVar2.f20494h;
                if (jArr4.length != 1 && jArr4[0] == 0) {
                    long j24 = ((long[]) b1.a(loVar2.f20495i))[0];
                    for (int i53 = 0; i53 < jArr2.length; i53++) {
                        jArr2[i53] = xp.c(jArr2[i53] - j24, 1000000L, loVar2.f20489c);
                    }
                    return new ro(loVar, jArr, iArr, i33, jArr2, iArr2, xp.c(j13 - j24, 1000000L, loVar2.f20489c));
                }
                if (loVar2.f20488b == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                iArr3 = new int[jArr4.length];
                iArr4 = new int[jArr4.length];
                jArr5 = (long[]) b1.a(loVar2.f20495i);
                i34 = 0;
                i35 = 0;
                z15 = false;
                i36 = 0;
                while (true) {
                    jArr6 = loVar2.f20494h;
                    if (i34 >= jArr6.length) {
                        break;
                    }
                    long[] jArr13 = jArr;
                    int[] iArr13 = iArr;
                    j17 = jArr5[i34];
                    if (j17 != -1) {
                        long j25 = jArr6[i34];
                        boolean z22 = z15;
                        i44 = i36;
                        long jC5 = xp.c(j25, loVar2.f20489c, loVar2.f20490d);
                        iArr3[i34] = xp.b(jArr2, j17, true, true);
                        z18 = z14;
                        iArr4[i34] = xp.a(jArr2, j17 + jC5, z18, false);
                        while (true) {
                            i45 = iArr3[i34];
                            i43 = iArr4[i34];
                            if (i45 < i43 || (iArr2[i45] & 1) != 0) {
                                break;
                            }
                            iArr3[i34] = i45 + 1;
                        }
                        i35 += i43 - i45;
                        if (i44 != i45) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        z19 = z22 | z21;
                    } else {
                        int i54 = i36;
                        z18 = z14;
                        z19 = z15;
                        i43 = i54;
                    }
                    i34++;
                    z15 = z19;
                    z14 = z18;
                    jArr = jArr13;
                    i36 = i43;
                    iArr = iArr13;
                }
                jArr7 = jArr;
                iArr5 = iArr;
                boolean z23 = z15;
                i37 = 0;
                if (i35 != i32) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z23 | z16;
                if (z17) {
                    jArr8 = new long[i35];
                } else {
                    jArr8 = jArr7;
                }
                if (z17) {
                    iArr6 = new int[i35];
                } else {
                    iArr6 = iArr5;
                }
                if (z17) {
                    i38 = 0;
                } else {
                    i38 = i33;
                }
                if (z17) {
                    iArr7 = new int[i35];
                } else {
                    iArr7 = iArr2;
                }
                jArr9 = new long[i35];
                i39 = i38;
                iArr8 = iArr5;
                j15 = 0;
                i40 = 0;
                while (i37 < loVar2.f20494h.length) {
                    j16 = loVar2.f20495i[i37];
                    i41 = iArr3[i37];
                    int[] iArr14 = iArr3;
                    i42 = iArr4[i37];
                    int[] iArr15 = iArr4;
                    if (z17) {
                        int i55 = i42 - i41;
                        System.arraycopy(jArr7, i41, jArr8, i40, i55);
                        iArr9 = iArr8;
                        System.arraycopy(iArr9, i41, iArr6, i40, i55);
                        System.arraycopy(iArr2, i41, iArr7, i40, i55);
                    } else {
                        iArr9 = iArr8;
                    }
                    int i56 = i39;
                    while (i41 < i42) {
                        int i57 = i37;
                        int[] iArr16 = iArr7;
                        long[] jArr14 = jArr2;
                        int[] iArr17 = iArr2;
                        long j26 = j15;
                        jArr9[i40] = xp.c(j15, 1000000L, loVar2.f20490d) + xp.c(Math.max(0L, jArr2[i41] - j16), 1000000L, loVar2.f20489c);
                        if (!z17 && iArr6[i40] > i56) {
                            i56 = iArr9[i41];
                        }
                        i40++;
                        i41++;
                        iArr2 = iArr17;
                        j15 = j26;
                        jArr2 = jArr14;
                        iArr7 = iArr16;
                        i37 = i57;
                    }
                    int i58 = i37;
                    i39 = i56;
                    j15 += loVar2.f20494h[i58];
                    iArr8 = iArr9;
                    iArr4 = iArr15;
                    jArr7 = jArr7;
                    iArr7 = iArr7;
                    i37 = i58 + 1;
                    iArr3 = iArr14;
                }
                return new ro(loVar, jArr8, iArr6, i39, jArr9, iArr7, xp.c(j15, 1000000L, loVar2.f20490d));
            }
            i32 = i24;
            i33 = i25;
            jArr4 = loVar2.f20494h;
            if (jArr4.length != 1) {
            }
            if (loVar2.f20488b == 1) {
                z14 = true;
            } else {
                z14 = false;
            }
            iArr3 = new int[jArr4.length];
            iArr4 = new int[jArr4.length];
            jArr5 = (long[]) b1.a(loVar2.f20495i);
            i34 = 0;
            i35 = 0;
            z15 = false;
            i36 = 0;
            while (true) {
                jArr6 = loVar2.f20494h;
                if (i34 >= jArr6.length) {
                    break;
                    break;
                }
                long[] jArr15 = jArr;
                int[] iArr18 = iArr;
                j17 = jArr5[i34];
                if (j17 != -1) {
                    long j27 = jArr6[i34];
                    boolean z24 = z15;
                    i44 = i36;
                    long jC6 = xp.c(j27, loVar2.f20489c, loVar2.f20490d);
                    iArr3[i34] = xp.b(jArr2, j17, true, true);
                    z18 = z14;
                    iArr4[i34] = xp.a(jArr2, j17 + jC6, z18, false);
                    while (true) {
                        i45 = iArr3[i34];
                        i43 = iArr4[i34];
                        if (i45 < i43) {
                            break;
                        }
                        break;
                        break;
                        iArr3[i34] = i45 + 1;
                    }
                    i35 += i43 - i45;
                    if (i44 != i45) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    z19 = z24 | z21;
                } else {
                    int i59 = i36;
                    z18 = z14;
                    z19 = z15;
                    i43 = i59;
                }
                i34++;
                z15 = z19;
                z14 = z18;
                jArr = jArr15;
                i36 = i43;
                iArr = iArr18;
            }
            jArr7 = jArr;
            iArr5 = iArr;
            boolean z25 = z15;
            i37 = 0;
            if (i35 != i32) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 = z25 | z16;
            if (z17) {
                jArr8 = new long[i35];
            } else {
                jArr8 = jArr7;
            }
            if (z17) {
                iArr6 = new int[i35];
            } else {
                iArr6 = iArr5;
            }
            if (z17) {
                i38 = 0;
            } else {
                i38 = i33;
            }
            if (z17) {
                iArr7 = new int[i35];
            } else {
                iArr7 = iArr2;
            }
            jArr9 = new long[i35];
            i39 = i38;
            iArr8 = iArr5;
            j15 = 0;
            i40 = 0;
            while (i37 < loVar2.f20494h.length) {
                j16 = loVar2.f20495i[i37];
                i41 = iArr3[i37];
                int[] iArr19 = iArr3;
                i42 = iArr4[i37];
                int[] iArr110 = iArr4;
                if (z17) {
                    int i510 = i42 - i41;
                    System.arraycopy(jArr7, i41, jArr8, i40, i510);
                    iArr9 = iArr8;
                    System.arraycopy(iArr9, i41, iArr6, i40, i510);
                    System.arraycopy(iArr2, i41, iArr7, i40, i510);
                } else {
                    iArr9 = iArr8;
                }
                int i511 = i39;
                while (i41 < i42) {
                    int i512 = i37;
                    int[] iArr111 = iArr7;
                    long[] jArr16 = jArr2;
                    int[] iArr112 = iArr2;
                    long j28 = j15;
                    jArr9[i40] = xp.c(j15, 1000000L, loVar2.f20490d) + xp.c(Math.max(0L, jArr2[i41] - j16), 1000000L, loVar2.f20489c);
                    if (!z17) {
                    }
                    i40++;
                    i41++;
                    iArr2 = iArr112;
                    j15 = j28;
                    jArr2 = jArr16;
                    iArr7 = iArr111;
                    i37 = i512;
                }
                int i513 = i37;
                i39 = i511;
                j15 += loVar2.f20494h[i513];
                iArr8 = iArr9;
                iArr4 = iArr110;
                jArr7 = jArr7;
                iArr7 = iArr7;
                i37 = i513 + 1;
                iArr3 = iArr19;
            }
            return new ro(loVar, jArr8, iArr6, i39, jArr9, iArr7, xp.c(j15, 1000000L, loVar2.f20490d));
        }
        iA2 = 0;
        iA3 = -1;
        iA4 = eVar.a();
        String str3 = loVar.f20492f.f18900m;
        if (iA4 == -1) {
            z12 = false;
        } else {
            z12 = false;
        }
        if (z12) {
            int i410 = aVar2.f20073a;
            jArr10 = new long[i410];
            iArr10 = new int[i410];
            while (aVar2.a()) {
                int i411 = aVar2.f20074b;
                jArr10[i411] = aVar2.f20076d;
                iArr10[i411] = aVar2.f20075c;
            }
            s8.b bVarA2 = s8.a(iA4, jArr10, iArr10, iA10);
            long[] jArr17 = bVarA2.f22305a;
            int[] iArr113 = bVarA2.f22306b;
            int i412 = bVarA2.f22307c;
            long[] jArr18 = bVarA2.f22308d;
            int[] iArr114 = bVarA2.f22309e;
            long j110 = bVarA2.f22310f;
            loVar2 = loVar;
            i24 = iB;
            jArr = jArr17;
            iArr = iArr113;
            i25 = i412;
            iArr2 = iArr114;
            j13 = j110;
            jArr2 = jArr18;
        } else {
            jArrCopyOf = new long[iB];
            iArrCopyOf = new int[iB];
            jArrCopyOf2 = new long[iB];
            iArrCopyOf2 = new int[iB];
            iA5 = iA3;
            i11 = 0;
            i12 = 0;
            iJ = 0;
            i13 = 0;
            iA6 = 0;
            j11 = 0;
            j12 = 0;
            i14 = iA;
            i15 = iA10;
            i16 = iA9;
            i17 = iA8;
            i18 = iA2;
            while (true) {
                i19 = i17;
                if (i11 < iB) {
                    i21 = i16;
                    i22 = i13;
                    break;
                }
                j14 = j12;
                i26 = i13;
                zA = true;
                while (i26 == 0) {
                    zA = aVar2.a();
                    if (zA) {
                        break;
                        break;
                    }
                    int i413 = i16;
                    long j111 = aVar2.f20076d;
                    i26 = aVar2.f20075c;
                    j14 = j111;
                    i16 = i413;
                    i15 = i15;
                    iB = iB;
                }
                i27 = iB;
                i21 = i16;
                i28 = i15;
                if (!zA) {
                    pc.d("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                    iB = i11;
                    i22 = i26;
                    break;
                }
                if (bhVar5 != null) {
                    while (iA6 == 0) {
                        iA6 = bhVar5.A();
                        iJ = bhVar5.j();
                        i14--;
                    }
                    iA6--;
                }
                int i514 = iJ;
                jArrCopyOf[i11] = j14;
                iC = eVar.c();
                iArrCopyOf[i11] = iC;
                if (iC > i12) {
                    i12 = iC;
                }
                jArrCopyOf2[i11] = j11 + ((long) i514);
                if (bhVar4 == null) {
                    i29 = 1;
                } else {
                    i29 = 0;
                }
                iArrCopyOf2[i11] = i29;
                if (i11 == iA5) {
                    iArrCopyOf2[i11] = 1;
                    i18--;
                    if (i18 > 0) {
                        iA5 = ((bh) b1.a(bhVar4)).A() - 1;
                    }
                }
                int i515 = iA5;
                j11 += (long) i28;
                iA7 = i21 - 1;
                if (iA7 == 0) {
                    iJ2 = i28;
                    i31 = i19;
                } else {
                    iJ2 = i28;
                    i31 = i19;
                }
                int i516 = iA7;
                long j29 = j14 + ((long) iArrCopyOf[i11]);
                i13 = i26 - 1;
                i11++;
                j12 = j29;
                iA5 = i515;
                i15 = iJ2;
                iB = i27;
                iJ = i514;
                i17 = i31;
                i16 = i516;
            }
            long j210 = j11 + ((long) iJ);
            if (bhVar5 != null) {
                z13 = true;
                break;
            }
            while (true) {
                if (i14 > 0) {
                    z13 = true;
                    break;
                }
                if (bhVar5.A() != 0) {
                    z13 = false;
                    break;
                }
                bhVar5.j();
                i14--;
            }
            if (i18 != 0) {
                i23 = iA6;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Inconsistent stbl box for track ");
                loVar2 = loVar;
                sb3.append(loVar2.f20487a);
                sb3.append(": remainingSynchronizationSamples ");
                sb3.append(i18);
                sb3.append(", remainingSamplesAtTimestampDelta ");
                sb3.append(i21);
                sb3.append(", remainingSamplesInChunk ");
                sb3.append(i22);
                sb3.append(", remainingTimestampDeltaChanges ");
                sb3.append(i19);
                sb3.append(", remainingSamplesAtTimestampOffset ");
                sb3.append(i23);
                if (z13) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb3.append(str);
                pc.d("AtomParsers", sb3.toString());
            } else {
                i23 = iA6;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Inconsistent stbl box for track ");
                loVar2 = loVar;
                sb4.append(loVar2.f20487a);
                sb4.append(": remainingSynchronizationSamples ");
                sb4.append(i18);
                sb4.append(", remainingSamplesAtTimestampDelta ");
                sb4.append(i21);
                sb4.append(", remainingSamplesInChunk ");
                sb4.append(i22);
                sb4.append(", remainingTimestampDeltaChanges ");
                sb4.append(i19);
                sb4.append(", remainingSamplesAtTimestampOffset ");
                sb4.append(i23);
                if (z13) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb4.append(str);
                pc.d("AtomParsers", sb4.toString());
            }
            i24 = iB;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i25 = i12;
            j13 = j210;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        jC = xp.c(j13, 1000000L, loVar2.f20489c);
        jArr3 = loVar2.f20494h;
        if (jArr3 == null) {
            xp.a(jArr2, 1000000L, loVar2.f20489c);
            return new ro(loVar, jArr, iArr, i25, jArr2, iArr2, jC);
        }
        if (jArr3.length != 1) {
            i32 = i24;
            i33 = i25;
        } else {
            i32 = i24;
            i33 = i25;
        }
        jArr4 = loVar2.f20494h;
        if (jArr4.length != 1) {
        }
        if (loVar2.f20488b == 1) {
            z14 = true;
        } else {
            z14 = false;
        }
        iArr3 = new int[jArr4.length];
        iArr4 = new int[jArr4.length];
        jArr5 = (long[]) b1.a(loVar2.f20495i);
        i34 = 0;
        i35 = 0;
        z15 = false;
        i36 = 0;
        while (true) {
            jArr6 = loVar2.f20494h;
            if (i34 >= jArr6.length) {
                break;
                break;
            }
            long[] jArr19 = jArr;
            int[] iArr115 = iArr;
            j17 = jArr5[i34];
            if (j17 != -1) {
                long j211 = jArr6[i34];
                boolean z26 = z15;
                i44 = i36;
                long jC7 = xp.c(j211, loVar2.f20489c, loVar2.f20490d);
                iArr3[i34] = xp.b(jArr2, j17, true, true);
                z18 = z14;
                iArr4[i34] = xp.a(jArr2, j17 + jC7, z18, false);
                while (true) {
                    i45 = iArr3[i34];
                    i43 = iArr4[i34];
                    if (i45 < i43) {
                        break;
                        break;
                    }
                    break;
                    break;
                    iArr3[i34] = i45 + 1;
                }
                i35 += i43 - i45;
                if (i44 != i45) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                z19 = z26 | z21;
            } else {
                int i517 = i36;
                z18 = z14;
                z19 = z15;
                i43 = i517;
            }
            i34++;
            z15 = z19;
            z14 = z18;
            jArr = jArr19;
            i36 = i43;
            iArr = iArr115;
        }
        jArr7 = jArr;
        iArr5 = iArr;
        boolean z27 = z15;
        i37 = 0;
        if (i35 != i32) {
            z16 = true;
        } else {
            z16 = false;
        }
        z17 = z27 | z16;
        if (z17) {
            jArr8 = new long[i35];
        } else {
            jArr8 = jArr7;
        }
        if (z17) {
            iArr6 = new int[i35];
        } else {
            iArr6 = iArr5;
        }
        if (z17) {
            i38 = 0;
        } else {
            i38 = i33;
        }
        if (z17) {
            iArr7 = new int[i35];
        } else {
            iArr7 = iArr2;
        }
        jArr9 = new long[i35];
        i39 = i38;
        iArr8 = iArr5;
        j15 = 0;
        i40 = 0;
        while (i37 < loVar2.f20494h.length) {
            j16 = loVar2.f20495i[i37];
            i41 = iArr3[i37];
            int[] iArr116 = iArr3;
            i42 = iArr4[i37];
            int[] iArr117 = iArr4;
            if (z17) {
                int i518 = i42 - i41;
                System.arraycopy(jArr7, i41, jArr8, i40, i518);
                iArr9 = iArr8;
                System.arraycopy(iArr9, i41, iArr6, i40, i518);
                System.arraycopy(iArr2, i41, iArr7, i40, i518);
            } else {
                iArr9 = iArr8;
            }
            int i519 = i39;
            while (i41 < i42) {
                int i5110 = i37;
                int[] iArr118 = iArr7;
                long[] jArr110 = jArr2;
                int[] iArr119 = iArr2;
                long j212 = j15;
                jArr9[i40] = xp.c(j15, 1000000L, loVar2.f20490d) + xp.c(Math.max(0L, jArr2[i41] - j16), 1000000L, loVar2.f20489c);
                if (!z17) {
                }
                i40++;
                i41++;
                iArr2 = iArr119;
                j15 = j212;
                jArr2 = jArr110;
                iArr7 = iArr118;
                i37 = i5110;
            }
            int i5111 = i37;
            i39 = i519;
            j15 += loVar2.f20494h[i5111];
            iArr8 = iArr9;
            iArr4 = iArr117;
            jArr7 = jArr7;
            iArr7 = iArr7;
            i37 = i5111 + 1;
            iArr3 = iArr116;
        }
        return new ro(loVar, jArr8, iArr6, i39, jArr9, iArr7, xp.c(j15, 1000000L, loVar2.f20490d));
    }

    public static List a(j1.a aVar, z9 z9Var, long j11, y6 y6Var, boolean z11, boolean z12, Function function) {
        lo loVar;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < aVar.f19810d.size(); i11++) {
            j1.a aVar2 = (j1.a) aVar.f19810d.get(i11);
            if (aVar2.f19807a == 1953653099 && (loVar = (lo) function.apply(a(aVar2, (j1.b) b1.a(aVar.e(1836476516)), j11, y6Var, z11, z12))) != null) {
                arrayList.add(a(loVar, (j1.a) b1.a(((j1.a) b1.a(((j1.a) b1.a(aVar2.d(1835297121))).d(1835626086))).d(1937007212)), z9Var));
            }
        }
        return arrayList;
    }

    public static void a(bh bhVar) {
        int iD = bhVar.d();
        bhVar.g(4);
        if (bhVar.j() != 1751411826) {
            iD += 4;
        }
        bhVar.f(iD);
    }

    private static void a(bh bhVar, int i11, int i12, int i13, int i14, int i15, y6 y6Var, c cVar, int i16) throws dh {
        String str;
        y6 y6Var2;
        String str2;
        bh bhVar2 = bhVar;
        int i17 = i12;
        int i18 = i13;
        y6 y6VarA = y6Var;
        bhVar2.f(i17 + 16);
        bhVar2.g(16);
        int iC = bhVar.C();
        int iC2 = bhVar.C();
        bhVar2.g(50);
        int iD = bhVar.d();
        int iIntValue = i11;
        if (iIntValue == 1701733238) {
            Pair pairD = d(bhVar2, i17, i18);
            if (pairD != null) {
                iIntValue = ((Integer) pairD.first).intValue();
                y6VarA = y6VarA == null ? null : y6VarA.a(((mo) pairD.second).f21185b);
                cVar.f20082a[i16] = (mo) pairD.second;
            }
            bhVar2.f(iD);
        }
        String str3 = MimeTypes.VIDEO_H263;
        if (iIntValue == 1831958048) {
            str = MimeTypes.VIDEO_MPEG;
        } else {
            str = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        }
        float fC = 1.0f;
        int i19 = -1;
        String str4 = null;
        List listA = null;
        byte[] bArrC = null;
        r3 r3Var = null;
        boolean z11 = false;
        while (true) {
            if (iD - i17 >= i18) {
                y6Var2 = y6VarA;
                break;
            }
            bhVar2.f(iD);
            int iD2 = bhVar.d();
            String str5 = str3;
            int iJ = bhVar.j();
            if (iJ == 0) {
                y6Var2 = y6VarA;
                if (bhVar.d() - i17 == i18) {
                    break;
                }
            } else {
                y6Var2 = y6VarA;
            }
            n8.a(iJ > 0, "childAtomSize must be positive");
            int iJ2 = bhVar.j();
            if (iJ2 == 1635148611) {
                n8.a(str == null, (String) null);
                bhVar2.f(iD2 + 8);
                w1 w1VarB = w1.b(bhVar);
                listA = w1VarB.f24005a;
                cVar.f20084c = w1VarB.f24006b;
                if (!z11) {
                    fC = w1VarB.f24009e;
                }
                str4 = w1VarB.f24010f;
                str2 = MimeTypes.VIDEO_H264;
            } else if (iJ2 == 1752589123) {
                n8.a(str == null, (String) null);
                bhVar2.f(iD2 + 8);
                oa oaVarA = oa.a(bhVar);
                listA = oaVarA.f21477a;
                cVar.f20084c = oaVarA.f21478b;
                str4 = oaVarA.f21479c;
                str2 = MimeTypes.VIDEO_H265;
            } else {
                if (iJ2 == 1685480259 || iJ2 == 1685485123) {
                    x6 x6VarA = x6.a(bhVar);
                    if (x6VarA != null) {
                        str4 = x6VarA.f24264c;
                        str = "video/dolby-vision";
                    }
                } else if (iJ2 == 1987076931) {
                    n8.a(str == null, (String) null);
                    str2 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                } else if (iJ2 == 1635135811) {
                    n8.a(str == null, (String) null);
                    str = "video/av01";
                } else if (iJ2 == 1681012275) {
                    n8.a(str == null, (String) null);
                    str = str5;
                } else if (iJ2 == 1702061171) {
                    n8.a(str == null, (String) null);
                    Pair pairA = a(bhVar2, iD2);
                    String str6 = (String) pairA.first;
                    byte[] bArr = (byte[]) pairA.second;
                    if (bArr != null) {
                        listA = eb.a(bArr);
                    }
                    str = str6;
                } else if (iJ2 == 1885434736) {
                    fC = c(bhVar2, iD2);
                    z11 = true;
                } else if (iJ2 == 1937126244) {
                    bArrC = c(bhVar2, iD2, iJ);
                } else if (iJ2 == 1936995172) {
                    int iW = bhVar.w();
                    bhVar2.g(3);
                    if (iW == 0) {
                        int iW2 = bhVar.w();
                        if (iW2 == 0) {
                            i19 = 0;
                        } else if (iW2 == 1) {
                            i19 = 1;
                        } else if (iW2 == 2) {
                            i19 = 2;
                        } else if (iW2 == 3) {
                            i19 = 3;
                        }
                    }
                } else if (iJ2 == 1668246642) {
                    int iJ3 = bhVar.j();
                    boolean z12 = iJ3 == 1852009592;
                    if (z12 || iJ3 == 1852009571) {
                        int iC3 = bhVar.C();
                        int iC4 = bhVar.C();
                        bhVar2.g(2);
                        r3Var = new r3(r3.a(iC3), z12 && (bhVar.w() & 128) != 0 ? 1 : 2, r3.b(iC4), null);
                    } else {
                        pc.d("AtomParsers", "Unsupported color type: " + j1.a(iJ3));
                    }
                }
                iD += iJ;
                bhVar2 = bhVar;
                i17 = i12;
                i18 = i13;
                str3 = str5;
                y6VarA = y6Var2;
            }
            str = str2;
            iD += iJ;
            bhVar2 = bhVar;
            i17 = i12;
            i18 = i13;
            str3 = str5;
            y6VarA = y6Var2;
        }
        if (str == null) {
            return;
        }
        cVar.f20083b = new f9.b().h(i14).f(str).a(str4).q(iC).g(iC2).b(fC).m(i15).a(bArrC).p(i19).a(listA).a(y6Var2).a(r3Var).a();
    }

    private static void a(bh bhVar, int i11, int i12, int i13, int i14, String str, c cVar) {
        bhVar.f(i12 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        eb ebVarA = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = i13 - 16;
                byte[] bArr = new byte[i15];
                bhVar.a(bArr, 0, i15);
                ebVarA = eb.a(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == 1937010800) {
                j11 = 0;
            } else {
                if (i11 != 1664495672) {
                    throw new IllegalStateException();
                }
                cVar.f20085d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        cVar.f20083b = new f9.b().h(i14).f(str2).e(str).a(j11).a(ebVarA).a();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x015b  */
    /* JADX WARN: Code duplicated, block: B:105:0x016a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0185  */
    /* JADX WARN: Code duplicated, block: B:114:0x0191  */
    /* JADX WARN: Code duplicated, block: B:138:0x028b  */
    /* JADX WARN: Code duplicated, block: B:140:0x028e  */
    /* JADX WARN: Code duplicated, block: B:142:0x0295  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:158:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0151  */
    private static void a(bh bhVar, int i11, int i12, int i13, int i14, String str, boolean z11, y6 y6Var, c cVar, int i15) throws dh {
        int iC;
        int iX;
        int iA;
        y6 y6VarA;
        String str2;
        String str3;
        int i16;
        String str4;
        String str5;
        List listA;
        int iJ;
        int iJ2;
        int iA2;
        byte[] bArr;
        List listA2;
        int i17 = i12;
        int i18 = i13;
        bhVar.f(i17 + 16);
        if (z11) {
            iC = bhVar.C();
            bhVar.g(6);
        } else {
            bhVar.g(8);
            iC = 0;
        }
        boolean z12 = true;
        if (iC == 0 || iC == 1) {
            int iC2 = bhVar.C();
            bhVar.g(6);
            iX = bhVar.x();
            if (iC == 1) {
                bhVar.g(16);
            }
            iA = iC2;
        } else {
            if (iC != 2) {
                return;
            }
            bhVar.g(16);
            iX = (int) Math.round(bhVar.h());
            iA = bhVar.A();
            bhVar.g(20);
        }
        int iD = bhVar.d();
        int iIntValue = i11;
        if (iIntValue == 1701733217) {
            Pair pairD = d(bhVar, i17, i18);
            if (pairD != null) {
                iIntValue = ((Integer) pairD.first).intValue();
                y6VarA = y6Var == null ? null : y6Var.a(((mo) pairD.second).f21185b);
                cVar.f20082a[i15] = (mo) pairD.second;
            } else {
                y6VarA = y6Var;
            }
            bhVar.f(iD);
        } else {
            y6VarA = y6Var;
        }
        if (iIntValue == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else {
            if (iIntValue != 1935767394) {
                str3 = MimeTypes.AUDIO_RAW;
                if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                    i16 = 2;
                } else if (iIntValue == 1953984371) {
                    i16 = ASTNode.DEOP;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (iIntValue == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (iIntValue == 1634492771) {
                    str2 = MimeTypes.AUDIO_ALAC;
                } else if (iIntValue == 1634492791) {
                    str2 = MimeTypes.AUDIO_ALAW;
                } else if (iIntValue == 1970037111) {
                    str2 = MimeTypes.AUDIO_MLAW;
                } else if (iIntValue == 1332770163) {
                    str2 = MimeTypes.AUDIO_OPUS;
                } else if (iIntValue == 1716281667) {
                    str2 = MimeTypes.AUDIO_FLAC;
                } else {
                    i16 = -1;
                    str3 = null;
                }
                str4 = str3;
                str5 = null;
                listA = null;
                while (iD - i17 < i18) {
                    bhVar.f(iD);
                    iJ = bhVar.j();
                    if (iJ <= 0) {
                        z12 = false;
                    }
                    n8.a(z12, "childAtomSize must be positive");
                    iJ2 = bhVar.j();
                    if (iJ2 == 1835557187) {
                        int i19 = iJ - 13;
                        byte[] bArr2 = new byte[i19];
                        bhVar.f(iD + 13);
                        bhVar.a(bArr2, 0, i19);
                        listA2 = eb.a(bArr2);
                    } else {
                        if (iJ2 != 1702061171 || (z11 && iJ2 == 2002876005)) {
                            z12 = true;
                            if (iJ2 == 1702061171) {
                                iA2 = iD;
                            } else {
                                iA2 = a(bhVar, iD, iJ);
                            }
                            if (iA2 != -1) {
                                Pair pairA = a(bhVar, iA2);
                                str4 = (String) pairA.first;
                                bArr = (byte[]) pairA.second;
                                if (bArr != null) {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        com.applovin.impl.a.b bVarA = com.applovin.impl.a.a(bArr);
                                        iX = bVarA.f17404a;
                                        iA = bVarA.f17405b;
                                        str5 = bVarA.f17406c;
                                    }
                                    listA = eb.a(bArr);
                                }
                            }
                        } else {
                            if (iJ2 == 1684103987) {
                                bhVar.f(iD + 8);
                                cVar.f20083b = k.a(bhVar, Integer.toString(i14), str, y6VarA);
                            } else if (iJ2 == 1684366131) {
                                bhVar.f(iD + 8);
                                cVar.f20083b = k.b(bhVar, Integer.toString(i14), str, y6VarA);
                            } else if (iJ2 == 1684103988) {
                                bhVar.f(iD + 8);
                                cVar.f20083b = n.a(bhVar, Integer.toString(i14), str, y6VarA);
                            } else if (iJ2 == 1684305011) {
                                cVar.f20083b = new f9.b().h(i14).f(str4).c(iA).n(iX).a(y6VarA).e(str).a();
                            } else if (iJ2 == 1682927731) {
                                int i21 = iJ - 8;
                                byte[] bArr3 = f20072a;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i21);
                                bhVar.f(iD + 8);
                                bhVar.a(bArrCopyOf, bArr3.length, i21);
                                listA2 = ug.a(bArrCopyOf);
                            } else if (iJ2 == 1684425825) {
                                byte[] bArr4 = new byte[iJ - 8];
                                bArr4[0] = 102;
                                z12 = true;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                bhVar.f(iD + 12);
                                bhVar.a(bArr4, 4, iJ - 12);
                                listA = eb.a(bArr4);
                            } else {
                                z12 = true;
                                if (iJ2 == 1634492771) {
                                    int i22 = iJ - 12;
                                    byte[] bArr5 = new byte[i22];
                                    bhVar.f(iD + 12);
                                    bhVar.a(bArr5, 0, i22);
                                    Pair pairA2 = o3.a(bArr5);
                                    int iIntValue2 = ((Integer) pairA2.first).intValue();
                                    int iIntValue3 = ((Integer) pairA2.second).intValue();
                                    listA = eb.a(bArr5);
                                    iX = iIntValue2;
                                    iA = iIntValue3;
                                }
                            }
                            z12 = true;
                        }
                        iD += iJ;
                        i17 = i12;
                        i18 = i13;
                    }
                    listA = listA2;
                    z12 = true;
                    iD += iJ;
                    i17 = i12;
                    i18 = i13;
                }
                if (cVar.f20083b == null || str4 == null) {
                }
                cVar.f20083b = new f9.b().h(i14).f(str4).a(str5).c(iA).n(iX).j(i16).a(listA).a(y6VarA).e(str).a();
                return;
            }
            str2 = MimeTypes.AUDIO_AMR_WB;
        }
        str3 = str2;
        i16 = -1;
        str4 = str3;
        str5 = null;
        listA = null;
        while (iD - i17 < i18) {
            bhVar.f(iD);
            iJ = bhVar.j();
            if (iJ <= 0) {
                z12 = false;
            }
            n8.a(z12, "childAtomSize must be positive");
            iJ2 = bhVar.j();
            if (iJ2 == 1835557187) {
                int i110 = iJ - 13;
                byte[] bArr6 = new byte[i110];
                bhVar.f(iD + 13);
                bhVar.a(bArr6, 0, i110);
                listA2 = eb.a(bArr6);
            } else {
                if (iJ2 != 1702061171) {
                    z12 = true;
                    if (iJ2 == 1702061171) {
                        iA2 = iD;
                    } else {
                        iA2 = a(bhVar, iD, iJ);
                    }
                    if (iA2 != -1) {
                        Pair pairA3 = a(bhVar, iA2);
                        str4 = (String) pairA3.first;
                        bArr = (byte[]) pairA3.second;
                        if (bArr != null) {
                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                com.applovin.impl.a.b bVarA2 = com.applovin.impl.a.a(bArr);
                                iX = bVarA2.f17404a;
                                iA = bVarA2.f17405b;
                                str5 = bVarA2.f17406c;
                            }
                            listA = eb.a(bArr);
                        }
                    }
                } else {
                    z12 = true;
                    if (iJ2 == 1702061171) {
                        iA2 = iD;
                    } else {
                        iA2 = a(bhVar, iD, iJ);
                    }
                    if (iA2 != -1) {
                        Pair pairA4 = a(bhVar, iA2);
                        str4 = (String) pairA4.first;
                        bArr = (byte[]) pairA4.second;
                        if (bArr != null) {
                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                com.applovin.impl.a.b bVarA3 = com.applovin.impl.a.a(bArr);
                                iX = bVarA3.f17404a;
                                iA = bVarA3.f17405b;
                                str5 = bVarA3.f17406c;
                            }
                            listA = eb.a(bArr);
                        }
                    }
                }
                iD += iJ;
                i17 = i12;
                i18 = i13;
            }
            listA = listA2;
            z12 = true;
            iD += iJ;
            i17 = i12;
            i18 = i13;
        }
        if (cVar.f20083b == null) {
        }
    }

    private static void a(bh bhVar, int i11, int i12, int i13, c cVar) {
        bhVar.f(i12 + 16);
        if (i11 == 1835365492) {
            bhVar.t();
            String strT = bhVar.t();
            if (strT != null) {
                cVar.f20083b = new f9.b().h(i13).f(strT).a();
            }
        }
    }

    private static boolean a(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[xp.a(4, 0, length)] && jArr[xp.a(jArr.length - 4, 0, length)] < j13 && j13 <= j11;
    }

    private static int b(bh bhVar) {
        int iW = bhVar.w();
        int i11 = iW & 127;
        while ((iW & 128) == 128) {
            iW = bhVar.w();
            i11 = (i11 << 7) | (iW & 127);
        }
        return i11;
    }

    public static Pair b(bh bhVar, int i11, int i12) throws dh {
        int i13 = i11 + 8;
        String strC = null;
        Integer numValueOf = null;
        int i14 = -1;
        int i15 = 0;
        while (i13 - i11 < i12) {
            bhVar.f(i13);
            int iJ = bhVar.j();
            int iJ2 = bhVar.j();
            if (iJ2 == 1718775137) {
                numValueOf = Integer.valueOf(bhVar.j());
            } else if (iJ2 == 1935894637) {
                bhVar.g(4);
                strC = bhVar.c(4);
            } else if (iJ2 == 1935894633) {
                i14 = i13;
                i15 = iJ;
            }
            i13 += iJ;
        }
        if (!C.CENC_TYPE_cenc.equals(strC) && !C.CENC_TYPE_cbc1.equals(strC) && !C.CENC_TYPE_cens.equals(strC) && !C.CENC_TYPE_cbcs.equals(strC)) {
            return null;
        }
        n8.a(numValueOf != null, "frma atom is mandatory");
        n8.a(i14 != -1, "schi atom is mandatory");
        mo moVarA = a(bhVar, i14, i15, strC);
        n8.a(moVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (mo) xp.a(moVarA));
    }

    private static bf b(bh bhVar, int i11) {
        bhVar.g(8);
        ArrayList arrayList = new ArrayList();
        while (bhVar.d() < i11) {
            bf.b bVarB = hf.b(bhVar);
            if (bVarB != null) {
                arrayList.add(bVarB);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new bf(arrayList);
    }

    public static bf b(j1.a aVar) {
        j1.b bVarE = aVar.e(1751411826);
        j1.b bVarE2 = aVar.e(1801812339);
        j1.b bVarE3 = aVar.e(1768715124);
        if (bVarE == null || bVarE2 == null || bVarE3 == null || c(bVarE.f19811b) != 1835299937) {
            return null;
        }
        bh bhVar = bVarE2.f19811b;
        bhVar.f(12);
        int iJ = bhVar.j();
        String[] strArr = new String[iJ];
        for (int i11 = 0; i11 < iJ; i11++) {
            int iJ2 = bhVar.j();
            bhVar.g(4);
            strArr[i11] = bhVar.c(iJ2 - 8);
        }
        bh bhVar2 = bVarE3.f19811b;
        bhVar2.f(8);
        ArrayList arrayList = new ArrayList();
        while (bhVar2.a() > 8) {
            int iD = bhVar2.d();
            int iJ3 = bhVar2.j();
            int iJ4 = bhVar2.j() - 1;
            if (iJ4 < 0 || iJ4 >= iJ) {
                pc.d("AtomParsers", "Skipped metadata with unknown key index: " + iJ4);
            } else {
                fd fdVarA = hf.a(bhVar2, iD + iJ3, strArr[iJ4]);
                if (fdVarA != null) {
                    arrayList.add(fdVarA);
                }
            }
            bhVar2.f(iD + iJ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new bf(arrayList);
    }

    private static float c(bh bhVar, int i11) {
        bhVar.f(i11 + 8);
        return bhVar.A() / bhVar.A();
    }

    private static int c(bh bhVar) {
        bhVar.f(16);
        return bhVar.j();
    }

    private static byte[] c(bh bhVar, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            bhVar.f(i13);
            int iJ = bhVar.j();
            if (bhVar.j() == 1886547818) {
                return Arrays.copyOfRange(bhVar.c(), i13, iJ + i13);
            }
            i13 += iJ;
        }
        return null;
    }

    private static Pair d(bh bhVar) {
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        bhVar.g(iC == 0 ? 8 : 16);
        long jY = bhVar.y();
        bhVar.g(iC == 0 ? 4 : 8);
        int iC2 = bhVar.C();
        return Pair.create(Long.valueOf(jY), "" + ((char) (((iC2 >> 10) & 31) + 96)) + ((char) (((iC2 >> 5) & 31) + 96)) + ((char) ((iC2 & 31) + 96)));
    }

    private static Pair d(bh bhVar, int i11, int i12) throws dh {
        Pair pairB;
        int iD = bhVar.d();
        while (iD - i11 < i12) {
            bhVar.f(iD);
            int iJ = bhVar.j();
            n8.a(iJ > 0, "childAtomSize must be positive");
            if (bhVar.j() == 1936289382 && (pairB = b(bhVar, iD, iJ)) != null) {
                return pairB;
            }
            iD += iJ;
        }
        return null;
    }

    private static bf d(bh bhVar, int i11) {
        bhVar.g(12);
        while (bhVar.d() < i11) {
            int iD = bhVar.d();
            int iJ = bhVar.j();
            if (bhVar.j() == 1935766900) {
                if (iJ < 14) {
                    return null;
                }
                bhVar.g(5);
                int iW = bhVar.w();
                if (iW != 12 && iW != 13) {
                    return null;
                }
                float f11 = iW == 12 ? 240.0f : 120.0f;
                bhVar.g(1);
                return new bf(new kk(f11, bhVar.w()));
            }
            bhVar.f(iD + iJ);
        }
        return null;
    }

    private static long e(bh bhVar) {
        bhVar.f(8);
        bhVar.g(j1.c(bhVar.j()) != 0 ? 16 : 8);
        return bhVar.y();
    }

    private static bf e(bh bhVar, int i11) {
        bhVar.g(8);
        a(bhVar);
        while (bhVar.d() < i11) {
            int iD = bhVar.d();
            int iJ = bhVar.j();
            if (bhVar.j() == 1768715124) {
                bhVar.f(iD);
                return b(bhVar, iD + iJ);
            }
            bhVar.f(iD + iJ);
        }
        return null;
    }

    private static f f(bh bhVar) {
        long j11;
        bhVar.f(8);
        int iC = j1.c(bhVar.j());
        bhVar.g(iC == 0 ? 8 : 16);
        int iJ = bhVar.j();
        bhVar.g(4);
        int iD = bhVar.d();
        int i11 = iC == 0 ? 4 : 8;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i13 >= i11) {
                bhVar.g(i11);
                break;
            }
            if (bhVar.c()[iD + i13] != -1) {
                long jY = iC == 0 ? bhVar.y() : bhVar.B();
                if (jY == 0) {
                    break;
                }
                j11 = jY;
                break;
            }
            i13++;
        }
        bhVar.g(16);
        int iJ2 = bhVar.j();
        int iJ3 = bhVar.j();
        bhVar.g(4);
        int iJ4 = bhVar.j();
        int iJ5 = bhVar.j();
        if (iJ2 == 0 && iJ3 == 65536 && iJ4 == -65536 && iJ5 == 0) {
            i12 = 90;
        } else if (iJ2 == 0 && iJ3 == -65536 && iJ4 == 65536 && iJ5 == 0) {
            i12 = 270;
        } else if (iJ2 == -65536 && iJ3 == 0 && iJ4 == 0 && iJ5 == -65536) {
            i12 = 180;
        }
        return new f(iJ, j11, i12);
    }
}
