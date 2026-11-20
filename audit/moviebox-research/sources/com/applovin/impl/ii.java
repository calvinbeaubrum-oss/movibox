package com.applovin.impl;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ii implements k8 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o8 f19709l = new o8() { // from class: com.applovin.impl.oy
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return ii.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho f19710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f19711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f19712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final hi f19713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f19717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private gi f19718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private m8 f19719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f19720k;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q7 f19721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ho f19722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ah f19723c = new ah(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f19724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f19725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f19726f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f19728h;

        public a(q7 q7Var, ho hoVar) {
            this.f19721a = q7Var;
            this.f19722b = hoVar;
        }

        private void a() {
            this.f19723c.d(8);
            this.f19724d = this.f19723c.f();
            this.f19725e = this.f19723c.f();
            this.f19723c.d(6);
            this.f19727g = this.f19723c.a(8);
        }

        private void b() {
            this.f19728h = 0L;
            if (this.f19724d) {
                this.f19723c.d(4);
                long jA = ((long) this.f19723c.a(3)) << 30;
                this.f19723c.d(1);
                long jA2 = jA | ((long) (this.f19723c.a(15) << 15));
                this.f19723c.d(1);
                long jA3 = jA2 | ((long) this.f19723c.a(15));
                this.f19723c.d(1);
                if (!this.f19726f && this.f19725e) {
                    this.f19723c.d(4);
                    long jA4 = ((long) this.f19723c.a(3)) << 30;
                    this.f19723c.d(1);
                    long jA5 = jA4 | ((long) (this.f19723c.a(15) << 15));
                    this.f19723c.d(1);
                    long jA6 = jA5 | ((long) this.f19723c.a(15));
                    this.f19723c.d(1);
                    this.f19722b.b(jA6);
                    this.f19726f = true;
                }
                this.f19728h = this.f19722b.b(jA3);
            }
        }

        public void a(bh bhVar) {
            bhVar.a(this.f19723c.f17657a, 0, 3);
            this.f19723c.c(0);
            a();
            bhVar.a(this.f19723c.f17657a, 0, this.f19727g);
            this.f19723c.c(0);
            b();
            this.f19721a.a(this.f19728h, 4);
            this.f19721a.a(bhVar);
            this.f19721a.b();
        }

        public void c() {
            this.f19726f = false;
            this.f19721a.a();
        }
    }

    public ii() {
        this(new ho(0L));
    }

    public ii(ho hoVar) {
        this.f19710a = hoVar;
        this.f19712c = new bh(4096);
        this.f19711b = new SparseArray();
        this.f19713d = new hi();
    }

    private void a(long j11) {
        if (this.f19720k) {
            return;
        }
        this.f19720k = true;
        if (this.f19713d.a() == C.TIME_UNSET) {
            this.f19719j.a(new ij.b(this.f19713d.a()));
            return;
        }
        gi giVar = new gi(this.f19713d.b(), this.f19713d.a(), j11);
        this.f19718i = giVar;
        this.f19719j.a(giVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new ii()};
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        q7 faVar;
        b1.b(this.f19719j);
        long jA = l8Var.a();
        if (jA != -1 && !this.f19713d.c()) {
            return this.f19713d.a(l8Var, thVar);
        }
        a(jA);
        gi giVar = this.f19718i;
        if (giVar != null && giVar.b()) {
            return this.f19718i.a(l8Var, thVar);
        }
        l8Var.b();
        long jD = jA != -1 ? jA - l8Var.d() : -1L;
        if ((jD != -1 && jD < 4) || !l8Var.b(this.f19712c.c(), 0, 4, true)) {
            return -1;
        }
        this.f19712c.f(0);
        int iJ = this.f19712c.j();
        if (iJ == 441) {
            return -1;
        }
        if (iJ == 442) {
            l8Var.c(this.f19712c.c(), 0, 10);
            this.f19712c.f(9);
            l8Var.a((this.f19712c.w() & 7) + 14);
            return 0;
        }
        if (iJ == 443) {
            l8Var.c(this.f19712c.c(), 0, 2);
            this.f19712c.f(0);
            l8Var.a(this.f19712c.C() + 6);
            return 0;
        }
        if (((iJ & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            l8Var.a(1);
            return 0;
        }
        int i11 = iJ & 255;
        a aVar = (a) this.f19711b.get(i11);
        if (!this.f19714e) {
            if (aVar == null) {
                if (i11 == 189) {
                    faVar = new j();
                    this.f19715f = true;
                    this.f19717h = l8Var.f();
                } else if ((iJ & 224) == 192) {
                    faVar = new sf();
                    this.f19715f = true;
                    this.f19717h = l8Var.f();
                } else if ((iJ & 240) == 224) {
                    faVar = new fa();
                    this.f19716g = true;
                    this.f19717h = l8Var.f();
                } else {
                    faVar = null;
                }
                if (faVar != null) {
                    faVar.a(this.f19719j, new dp.d(i11, 256));
                    aVar = new a(faVar, this.f19710a);
                    this.f19711b.put(i11, aVar);
                }
            }
            if (l8Var.f() > ((this.f19715f && this.f19716g) ? this.f19717h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.f19714e = true;
                this.f19719j.c();
            }
        }
        l8Var.c(this.f19712c.c(), 0, 2);
        this.f19712c.f(0);
        int iC = this.f19712c.C() + 6;
        if (aVar == null) {
            l8Var.a(iC);
        } else {
            this.f19712c.d(iC);
            l8Var.d(this.f19712c.c(), 0, iC);
            this.f19712c.f(6);
            aVar.a(this.f19712c);
            bh bhVar = this.f19712c;
            bhVar.e(bhVar.b());
        }
        return 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        boolean z11 = this.f19710a.c() == C.TIME_UNSET;
        if (!z11) {
            long jA = this.f19710a.a();
            if (jA != C.TIME_UNSET && jA != 0 && jA != j12) {
                this.f19710a.d(j12);
            }
        } else if (z11) {
            this.f19710a.d(j12);
        }
        gi giVar = this.f19718i;
        if (giVar != null) {
            giVar.b(j12);
        }
        for (int i11 = 0; i11 < this.f19711b.size(); i11++) {
            ((a) this.f19711b.valueAt(i11)).c();
        }
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f19719j = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        byte[] bArr = new byte[14];
        l8Var.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        l8Var.c(bArr[13] & 7);
        l8Var.c(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }
}
