package com.bytedance.sdk.openadsdk.component.reward;

import android.os.CountDownTimer;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import q8.b;
import t8.c;
import u8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements c {
    private boolean ExN;
    private com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc Qj;
    private final Sfl TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final a f27978qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f27979sc;
    private boolean pFF = true;
    private long zY = 0;
    private boolean We = false;

    /* JADX INFO: compiled from: source.java */
    public static class sc implements b {
        private c.InterfaceC0849c ExN;
        private final com.bytedance.sdk.openadsdk.We.qr Qj;
        private long TRI;
        private CountDownTimer We;
        private long pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private final a f27981qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final long f27982sc;
        private int zY = 0;

        public sc(long j11, a aVar, com.bytedance.sdk.openadsdk.We.qr qrVar) {
            this.f27982sc = j11;
            this.f27981qr = aVar;
            this.Qj = qrVar;
        }

        public long BT() {
            return this.TRI;
        }

        @Override // q8.b
        public int ExN() {
            return 0;
        }

        public void Ol() {
            if (this.zY == 1) {
                return;
            }
            this.zY = 1;
            final long jSR = SR();
            final long j11 = jSR - this.pFF;
            CountDownTimer countDownTimer = new CountDownTimer(j11, 200L) { // from class: com.bytedance.sdk.openadsdk.component.reward.zY.sc.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    sc.this.zY = 4;
                    sc.this.TRI = jSR;
                    if (sc.this.ExN != null) {
                        sc.this.ExN.sc(sc.this.BT(), 100);
                    }
                    BT.sc scVar = new BT.sc();
                    scVar.sc(jSR);
                    scVar.zY(jSR);
                    scVar.pFF(sc.this.Tf());
                    scVar.We(sc.this.Ql());
                    com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF(sc.this.f27981qr, scVar, sc.this.Qj);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j12) {
                    long j13 = (j11 - j12) + sc.this.pFF;
                    sc.this.TRI = j13;
                    if (sc.this.ExN != null) {
                        sc.this.ExN.sc(j13, jSR);
                    }
                }
            };
            this.We = countDownTimer;
            countDownTimer.start();
        }

        @Override // q8.b
        public boolean Qj() {
            return this.zY == 0;
        }

        public int Ql() {
            return 0;
        }

        public long SR() {
            return this.f27982sc;
        }

        @Override // q8.b
        public boolean TRI() {
            return this.zY == 1;
        }

        public long Tf() {
            return 0L;
        }

        public void UFX() {
            this.zY = 0;
            CountDownTimer countDownTimer = this.We;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.We = null;
            }
            if (this.ExN != null) {
                this.ExN = null;
            }
        }

        public void WH() {
            this.zY = 2;
            this.pFF = this.TRI;
            CountDownTimer countDownTimer = this.We;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.We = null;
            }
        }

        @Override // q8.b
        public int We() {
            return 0;
        }

        @Override // q8.b
        public boolean pFF() {
            return false;
        }

        @Override // q8.b
        public boolean qr() {
            return this.zY == 2;
        }

        public void sc(long j11) {
            this.pFF = j11;
        }

        public void sc(c.InterfaceC0849c interfaceC0849c) {
            this.ExN = interfaceC0849c;
        }

        @Override // q8.b
        public boolean sc() {
            return false;
        }

        @Override // q8.b
        public boolean zY() {
            return false;
        }
    }

    public zY(Sfl sfl, com.bytedance.sdk.openadsdk.We.qr qrVar) {
        a aVar = new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.zY.1
        };
        this.f27978qr = aVar;
        this.TRI = sfl;
        x8.a aVarGI = sfl.GI();
        long j11 = 10;
        long jM = aVarGI != null ? (long) aVarGI.m() : 10L;
        if (jM <= 0) {
            aVarGI.F(10.0d);
        } else {
            j11 = jM;
        }
        this.f27979sc = new sc(j11 * 1000, aVar, qrVar);
    }

    @Override // t8.c
    public boolean BT() {
        return this.ExN;
    }

    @Override // t8.c
    public long ExN() {
        return this.f27979sc.BT();
    }

    @Override // t8.c
    public void ExN(boolean z11) {
    }

    @Override // t8.c
    public long Ol() {
        return ExN();
    }

    @Override // t8.c
    public long Qj() {
        return this.f27979sc.SR();
    }

    @Override // t8.c
    public t8.a Ql() {
        return null;
    }

    @Override // t8.c
    public boolean SR() {
        return this.We;
    }

    @Override // t8.c
    public long TRI() {
        return 0L;
    }

    @Override // t8.c
    public b Tf() {
        return this.f27979sc;
    }

    @Override // t8.c
    public boolean UFX() {
        return false;
    }

    @Override // t8.c
    public int WH() {
        return k8.b.a(this.f27979sc.TRI, this.f27979sc.f27982sc);
    }

    @Override // t8.c
    public void We() {
        zY();
    }

    @Override // t8.c
    public void We(boolean z11) {
    }

    @Override // t8.c
    public boolean Xc() {
        return false;
    }

    @Override // t8.c
    public boolean dE() {
        return false;
    }

    @Override // t8.c
    public void pFF() {
        this.f27979sc.Ol();
        BT.sc scVar = new BT.sc();
        scVar.sc(ExN());
        scVar.zY(Qj());
        scVar.pFF(TRI());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.pFF(this.f27978qr, scVar);
        com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc = this.Qj;
        if (interfaceC0288sc != null) {
            interfaceC0288sc.sc(1);
        }
    }

    @Override // t8.c
    public void pFF(long j11) {
        this.zY = j11;
    }

    @Override // t8.c
    public void pFF(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
    }

    @Override // t8.c
    public void pFF(boolean z11) {
        this.We = z11;
    }

    @Override // t8.c
    public int qr() {
        return 0;
    }

    @Override // t8.c
    public void sc() {
        this.f27979sc.WH();
        BT.sc scVar = new BT.sc();
        scVar.sc(ExN());
        scVar.zY(Qj());
        scVar.pFF(TRI());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.f27978qr, scVar);
        com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc = this.Qj;
        if (interfaceC0288sc != null) {
            interfaceC0288sc.sc(2);
        }
    }

    @Override // t8.c
    public void sc(long j11) {
        this.f27979sc.sc(j11);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc) {
        this.Qj = interfaceC0288sc;
    }

    @Override // t8.c
    public void sc(c.a aVar) {
    }

    @Override // t8.c
    public void sc(c.b bVar) {
    }

    @Override // t8.c
    public void sc(c.InterfaceC0849c interfaceC0849c) {
        this.f27979sc.sc(interfaceC0849c);
    }

    @Override // t8.c
    public void sc(boolean z11) {
        this.pFF = z11;
    }

    @Override // t8.c
    public void sc(boolean z11, int i11) {
        zY();
    }

    @Override // t8.c
    public boolean sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar) {
        this.We = zYVar.Qj();
        if (zYVar.qr() > 0) {
            this.f27979sc.sc(zYVar.qr());
        }
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.TRI, this.f27978qr, zYVar);
        this.f27979sc.Ol();
        return true;
    }

    public a wjp() {
        return this.f27978qr;
    }

    @Override // t8.c
    public void zY() {
        this.f27979sc.UFX();
    }

    @Override // t8.c
    public void zY(long j11) {
    }

    @Override // t8.c
    public void zY(boolean z11) {
        this.ExN = z11;
    }
}
