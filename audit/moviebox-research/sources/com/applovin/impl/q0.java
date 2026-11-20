package com.applovin.impl;

import android.net.Uri;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements k8 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f21867r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f21870u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f21871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f21873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f21878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f21881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private m8 f21882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private qo f21883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ij f21884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f21885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final o8 f21865p = new o8() { // from class: com.applovin.impl.k10
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return q0.c();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f21866q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f21868s = xp.c("#!AMR\n");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f21869t = xp.c("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f21867r = iArr;
        f21870u = iArr[8];
    }

    public q0() {
        this(0);
    }

    public q0(int i11) {
        this.f21872b = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f21871a = new byte[1];
        this.f21879i = -1;
    }

    private int a(int i11) throws dh {
        if (c(i11)) {
            return this.f21873c ? f21867r[i11] : f21866q[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f21873c ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        throw dh.a(sb2.toString(), null);
    }

    private static int a(int i11, long j11) {
        return (int) ((((long) (i11 * 8)) * 1000000) / j11);
    }

    private ij a(long j11, boolean z11) {
        return new p4(j11, this.f21878h, a(this.f21879i, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT), this.f21879i, z11);
    }

    private void a(long j11, int i11) {
        int i12;
        if (this.f21877g) {
            return;
        }
        int i13 = this.f21872b;
        if ((i13 & 1) == 0 || j11 == -1 || !((i12 = this.f21879i) == -1 || i12 == this.f21875e)) {
            ij.b bVar = new ij.b(C.TIME_UNSET);
            this.f21884n = bVar;
            this.f21882l.a(bVar);
            this.f21877g = true;
            return;
        }
        if (this.f21880j >= 20 || i11 == -1) {
            ij ijVarA = a(j11, (i13 & 2) != 0);
            this.f21884n = ijVarA;
            this.f21882l.a(ijVarA);
            this.f21877g = true;
        }
    }

    private static boolean a(l8 l8Var, byte[] bArr) {
        l8Var.b();
        byte[] bArr2 = new byte[bArr.length];
        l8Var.c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int b(l8 l8Var) throws dh {
        l8Var.b();
        l8Var.c(this.f21871a, 0, 1);
        byte b11 = this.f21871a[0];
        if ((b11 & 131) <= 0) {
            return a((b11 >> 3) & 15);
        }
        throw dh.a("Invalid padding bits for frame header " + ((int) b11), null);
    }

    private void b() {
        b1.b(this.f21883m);
        xp.a(this.f21882l);
    }

    private boolean b(int i11) {
        return !this.f21873c && (i11 < 12 || i11 > 14);
    }

    private boolean c(int i11) {
        return i11 >= 0 && i11 <= 15 && (d(i11) || b(i11));
    }

    private boolean c(l8 l8Var) {
        byte[] bArr = f21868s;
        if (a(l8Var, bArr)) {
            this.f21873c = false;
            l8Var.a(bArr.length);
            return true;
        }
        byte[] bArr2 = f21869t;
        if (!a(l8Var, bArr2)) {
            return false;
        }
        this.f21873c = true;
        l8Var.a(bArr2.length);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] c() {
        return new k8[]{new q0()};
    }

    private int d(l8 l8Var) throws dh {
        if (this.f21876f == 0) {
            try {
                int iB = b(l8Var);
                this.f21875e = iB;
                this.f21876f = iB;
                if (this.f21879i == -1) {
                    this.f21878h = l8Var.f();
                    this.f21879i = this.f21875e;
                }
                if (this.f21879i == this.f21875e) {
                    this.f21880j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iA = this.f21883m.a((g5) l8Var, this.f21876f, true);
        if (iA == -1) {
            return -1;
        }
        int i11 = this.f21876f - iA;
        this.f21876f = i11;
        if (i11 > 0) {
            return 0;
        }
        this.f21883m.a(this.f21881k + this.f21874d, 1, this.f21875e, 0, null);
        this.f21874d += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    private void d() {
        if (this.f21885o) {
            return;
        }
        this.f21885o = true;
        boolean z11 = this.f21873c;
        this.f21883m.a(new f9.b().f(z11 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).i(f21870u).c(1).n(z11 ? 16000 : 8000).a());
    }

    private boolean d(int i11) {
        return this.f21873c && (i11 < 10 || i11 > 13);
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        b();
        if (l8Var.f() == 0 && !c(l8Var)) {
            throw dh.a("Could not find AMR header.", null);
        }
        d();
        int iD = d(l8Var);
        a(l8Var.a(), iD);
        return iD;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f21874d = 0L;
        this.f21875e = 0;
        this.f21876f = 0;
        if (j11 != 0) {
            ij ijVar = this.f21884n;
            if (ijVar instanceof p4) {
                this.f21881k = ((p4) ijVar).d(j11);
                return;
            }
        }
        this.f21881k = 0L;
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f21882l = m8Var;
        this.f21883m = m8Var.a(0, 1);
        m8Var.c();
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        return c(l8Var);
    }
}
