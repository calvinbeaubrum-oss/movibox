package com.applovin.impl;

import android.net.Uri;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class lr implements k8 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o8 f20506f = new o8() { // from class: com.applovin.impl.mz
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return lr.c();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m8 f20507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f20508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f20509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20510d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20511e = -1;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int[] f20512m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int[] f20513n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m8 f20514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final qo f20515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final mr f20516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f20517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f20518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final bh f20519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final f9 f20521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20522i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f20523j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20524k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f20525l;

        public a(m8 m8Var, qo qoVar, mr mrVar) throws dh {
            this.f20514a = m8Var;
            this.f20515b = qoVar;
            this.f20516c = mrVar;
            int iMax = Math.max(1, mrVar.f21195c / 10);
            this.f20520g = iMax;
            bh bhVar = new bh(mrVar.f21199g);
            bhVar.r();
            int iR = bhVar.r();
            this.f20517d = iR;
            int i11 = mrVar.f21194b;
            int i12 = (((mrVar.f21197e - (i11 * 4)) * 8) / (mrVar.f21198f * i11)) + 1;
            if (iR == i12) {
                int iA = xp.a(iMax, iR);
                this.f20518e = new byte[mrVar.f21197e * iA];
                this.f20519f = new bh(iA * a(iR, i11));
                int i13 = ((mrVar.f21195c * mrVar.f21197e) * 8) / iR;
                this.f20521h = new f9.b().f(MimeTypes.AUDIO_RAW).b(i13).k(i13).i(a(iMax, i11)).c(mrVar.f21194b).n(mrVar.f21195c).j(2).a();
                return;
            }
            throw dh.a("Expected frames per block: " + i12 + "; got: " + iR, null);
        }

        private int a(int i11) {
            return i11 / (this.f20516c.f21194b * 2);
        }

        private static int a(int i11, int i12) {
            return i11 * 2 * i12;
        }

        private void a(byte[] bArr, int i11, int i12, byte[] bArr2) {
            mr mrVar = this.f20516c;
            int i13 = mrVar.f21197e;
            int i14 = mrVar.f21194b;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int iA = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int iMin = Math.min(bArr[i15 + 2] & 255, 88);
            int i18 = f20513n[iMin];
            int i19 = ((i11 * this.f20517d * i14) + i12) * 2;
            bArr2[i19] = (byte) (iA & 255);
            bArr2[i19 + 1] = (byte) (iA >> 8);
            for (int i21 = 0; i21 < i17 * 2; i21++) {
                byte b11 = bArr[((i21 / 8) * i14 * 4) + i16 + ((i21 / 2) % 4)];
                int i22 = i21 % 2 == 0 ? b11 & Ascii.SI : (b11 & 255) >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i18) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                iA = xp.a(iA + i23, -32768, 32767);
                i19 += i14 * 2;
                bArr2[i19] = (byte) (iA & 255);
                bArr2[i19 + 1] = (byte) (iA >> 8);
                int i24 = iMin + f20512m[i22];
                int[] iArr = f20513n;
                iMin = xp.a(i24, 0, iArr.length - 1);
                i18 = iArr[iMin];
            }
        }

        private void a(byte[] bArr, int i11, bh bhVar) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.f20516c.f21194b; i13++) {
                    a(bArr, i12, i13, bhVar.c());
                }
            }
            int iB = b(this.f20517d * i11);
            bhVar.f(0);
            bhVar.e(iB);
        }

        private int b(int i11) {
            return a(i11, this.f20516c.f21194b);
        }

        private void c(int i11) {
            long jC = this.f20523j + xp.c(this.f20525l, 1000000L, this.f20516c.f21195c);
            int iB = b(i11);
            this.f20515b.a(jC, 1, iB, this.f20524k - iB, null);
            this.f20525l += (long) i11;
            this.f20524k -= iB;
        }

        @Override // com.applovin.impl.lr.b
        public void a(int i11, long j11) {
            this.f20514a.a(new or(this.f20516c, this.f20517d, i11, j11));
            this.f20515b.a(this.f20521h);
        }

        @Override // com.applovin.impl.lr.b
        public void a(long j11) {
            this.f20522i = 0;
            this.f20523j = j11;
            this.f20524k = 0;
            this.f20525l = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x003a A[LOOP:0: B:6:0x001f->B:12:0x003a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x0040 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x0038 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0021  */
        /* JADX WARN: Code duplicated, block: B:9:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:11:0x0038). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.applovin.impl.lr.b
        public boolean a(com.applovin.impl.l8 r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.f20520g
                int r1 = r6.f20524k
                int r1 = r6.a(r1)
                int r0 = r0 - r1
                int r1 = r6.f20517d
                int r0 = com.applovin.impl.xp.a(r0, r1)
                com.applovin.impl.mr r1 = r6.f20516c
                int r1 = r1.f21197e
                int r0 = r0 * r1
                r1 = 0
                int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r3 != 0) goto L1d
                r2 = r6
                goto L38
            L1d:
                r1 = 0
                r2 = r6
            L1f:
                if (r1 != 0) goto L40
                int r3 = r2.f20522i
                if (r3 >= r0) goto L40
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r4 = (int) r3
                byte[] r3 = r2.f20518e
                int r5 = r2.f20522i
                int r3 = r7.a(r3, r5, r4)
                r4 = -1
                if (r3 != r4) goto L3a
            L38:
                r1 = 1
                goto L1f
            L3a:
                int r4 = r2.f20522i
                int r4 = r4 + r3
                r2.f20522i = r4
                goto L1f
            L40:
                int r7 = r2.f20522i
                com.applovin.impl.mr r8 = r2.f20516c
                int r8 = r8.f21197e
                int r7 = r7 / r8
                if (r7 <= 0) goto L78
                byte[] r8 = r2.f20518e
                com.applovin.impl.bh r9 = r2.f20519f
                r2.a(r8, r7, r9)
                int r8 = r2.f20522i
                com.applovin.impl.mr r9 = r2.f20516c
                int r9 = r9.f21197e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r2.f20522i = r8
                com.applovin.impl.bh r7 = r2.f20519f
                int r7 = r7.e()
                com.applovin.impl.qo r8 = r2.f20515b
                com.applovin.impl.bh r9 = r2.f20519f
                r8.a(r9, r7)
                int r8 = r2.f20524k
                int r8 = r8 + r7
                r2.f20524k = r8
                int r7 = r2.a(r8)
                int r8 = r2.f20520g
                if (r7 < r8) goto L78
                r2.c(r8)
            L78:
                if (r1 == 0) goto L85
                int r7 = r2.f20524k
                int r7 = r2.a(r7)
                if (r7 <= 0) goto L85
                r2.c(r7)
            L85:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.lr.a.a(com.applovin.impl.l8, long):boolean");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11, long j11);

        void a(long j11);

        boolean a(l8 l8Var, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m8 f20526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final qo f20527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final mr f20528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final f9 f20529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f20530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f20531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f20533h;

        public c(m8 m8Var, qo qoVar, mr mrVar, String str, int i11) throws dh {
            this.f20526a = m8Var;
            this.f20527b = qoVar;
            this.f20528c = mrVar;
            int i12 = (mrVar.f21194b * mrVar.f21198f) / 8;
            if (mrVar.f21197e == i12) {
                int i13 = mrVar.f21195c * i12;
                int i14 = i13 * 8;
                int iMax = Math.max(i12, i13 / 10);
                this.f20530e = iMax;
                this.f20529d = new f9.b().f(str).b(i14).k(i14).i(iMax).c(mrVar.f21194b).n(mrVar.f21195c).j(i11).a();
                return;
            }
            throw dh.a("Expected block size: " + i12 + "; got: " + mrVar.f21197e, null);
        }

        @Override // com.applovin.impl.lr.b
        public void a(int i11, long j11) {
            this.f20526a.a(new or(this.f20528c, 1, i11, j11));
            this.f20527b.a(this.f20529d);
        }

        @Override // com.applovin.impl.lr.b
        public void a(long j11) {
            this.f20531f = j11;
            this.f20532g = 0;
            this.f20533h = 0L;
        }

        @Override // com.applovin.impl.lr.b
        public boolean a(l8 l8Var, long j11) {
            int i11;
            int i12;
            long j12 = j11;
            while (j12 > 0 && (i11 = this.f20532g) < (i12 = this.f20530e)) {
                int iA = this.f20527b.a((g5) l8Var, (int) Math.min(i12 - i11, j12), true);
                if (iA == -1) {
                    j12 = 0;
                } else {
                    this.f20532g += iA;
                    j12 -= (long) iA;
                }
            }
            mr mrVar = this.f20528c;
            int i13 = mrVar.f21197e;
            int i14 = this.f20532g / i13;
            if (i14 > 0) {
                long jC = this.f20531f + xp.c(this.f20533h, 1000000L, mrVar.f21195c);
                int i15 = i14 * i13;
                int i16 = this.f20532g - i15;
                this.f20527b.a(jC, 1, i15, i16, null);
                this.f20533h += (long) i14;
                this.f20532g = i16;
            }
            return j12 <= 0;
        }
    }

    private void b() {
        b1.b(this.f20508b);
        xp.a(this.f20507a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] c() {
        return new k8[]{new lr()};
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        b();
        if (this.f20509c == null) {
            mr mrVarA = nr.a(l8Var);
            if (mrVarA == null) {
                throw dh.a("Unsupported or unrecognized wav header.", null);
            }
            int i11 = mrVarA.f21193a;
            if (i11 == 17) {
                this.f20509c = new a(this.f20507a, this.f20508b, mrVarA);
            } else if (i11 == 6) {
                this.f20509c = new c(this.f20507a, this.f20508b, mrVarA, MimeTypes.AUDIO_ALAW, -1);
            } else if (i11 == 7) {
                this.f20509c = new c(this.f20507a, this.f20508b, mrVarA, MimeTypes.AUDIO_MLAW, -1);
            } else {
                int iA = pr.a(i11, mrVarA.f21198f);
                if (iA == 0) {
                    throw dh.a("Unsupported WAV format type: " + mrVarA.f21193a);
                }
                this.f20509c = new c(this.f20507a, this.f20508b, mrVarA, MimeTypes.AUDIO_RAW, iA);
            }
        }
        if (this.f20510d == -1) {
            Pair pairB = nr.b(l8Var);
            this.f20510d = ((Long) pairB.first).intValue();
            long jLongValue = ((Long) pairB.second).longValue();
            this.f20511e = jLongValue;
            this.f20509c.a(this.f20510d, jLongValue);
        } else if (l8Var.f() == 0) {
            l8Var.a(this.f20510d);
        }
        b1.b(this.f20511e != -1);
        return this.f20509c.a(l8Var, this.f20511e - l8Var.f()) ? -1 : 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        b bVar = this.f20509c;
        if (bVar != null) {
            bVar.a(j12);
        }
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f20507a = m8Var;
        this.f20508b = m8Var.a(0, 1);
        m8Var.c();
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        return nr.a(l8Var) != null;
    }
}
