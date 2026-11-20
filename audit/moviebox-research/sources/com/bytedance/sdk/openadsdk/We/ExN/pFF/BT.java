package com.bytedance.sdk.openadsdk.We.ExN.pFF;

import com.bytedance.sdk.openadsdk.core.model.Sfl;
import x8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT {
    private Sfl ExN;
    private com.bykv.vk.openvk.sc.sc.sc.zY.zY We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27304sc;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private int ExN;
        private int Ol;
        private int Qj;
        private int TRI;
        private b UFX;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private int f27305qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private long f27306sc = 0;
        private long pFF = 0;
        private long zY = 0;
        private boolean We = false;
        private boolean WH = false;

        private void Ql() {
            long j11 = this.zY;
            if (j11 > 0) {
                long j12 = this.f27306sc;
                if (j12 > j11) {
                    long j13 = j12 % j11;
                    this.f27306sc = j13;
                    if (j13 == 0) {
                        this.f27306sc = j11;
                    }
                }
            }
        }

        public int ExN() {
            return this.TRI;
        }

        public int Ol() {
            return this.Ol;
        }

        public int Qj() {
            return this.Qj;
        }

        public int TRI() {
            long j11 = this.zY;
            if (j11 <= 0) {
                return 0;
            }
            return Math.min((int) ((this.f27306sc * 100) / j11), 100);
        }

        public b Tf() {
            return this.UFX;
        }

        public boolean UFX() {
            return this.We;
        }

        public boolean WH() {
            return this.WH;
        }

        public int We() {
            return this.ExN;
        }

        public void We(int i11) {
            this.Ol = i11;
        }

        public long pFF() {
            return this.pFF;
        }

        public void pFF(int i11) {
            this.TRI = i11;
        }

        public void pFF(long j11) {
            this.pFF = j11;
        }

        public int qr() {
            return this.f27305qr;
        }

        public long sc() {
            return this.f27306sc;
        }

        public void sc(int i11) {
            this.ExN = i11;
        }

        public void sc(long j11) {
            this.f27306sc = j11;
            Ql();
        }

        public void sc(b bVar) {
            this.UFX = bVar;
        }

        public void sc(boolean z11) {
            this.We = z11;
        }

        public long zY() {
            return this.zY;
        }

        public void zY(int i11) {
            this.f27305qr = i11;
        }

        public void zY(long j11) {
            this.zY = j11;
            Ql();
        }
    }

    public BT(long j11, String str, int i11, com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, Sfl sfl) {
        this.f27304sc = j11;
        this.pFF = str;
        this.zY = i11;
        this.We = zYVar;
        this.ExN = sfl;
    }

    public Sfl ExN() {
        return this.ExN;
    }

    public com.bykv.vk.openvk.sc.sc.sc.zY.zY We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public long sc() {
        return this.f27304sc;
    }

    public int zY() {
        return this.zY;
    }
}
