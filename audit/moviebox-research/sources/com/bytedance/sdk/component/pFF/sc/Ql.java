package com.bytedance.sdk.component.pFF.sc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Ql {
    public com.bytedance.sdk.component.zY.sc.sc pFF = new com.bytedance.sdk.component.zY.sc.sc();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public UFX f26928sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        Object ExN;
        String Qj;
        SR TRI;
        String We;
        Map<String, List<String>> pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        int f26929qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        com.bytedance.sdk.component.pFF.sc.sc f26930sc;
        qr zY;

        public sc() {
            this.pFF = new HashMap();
        }

        public sc(Ql ql2) {
            this.zY = ql2.pFF();
            this.We = ql2.zY();
            this.pFF = ql2.We();
            this.ExN = ql2.sc();
            this.TRI = ql2.Qj();
            this.f26930sc = ql2.ExN();
            this.f26929qr = ql2.qr();
            this.Qj = ql2.TRI();
        }

        private sc sc(String str, SR sr2) {
            this.We = str;
            this.TRI = sr2;
            return this;
        }

        public sc pFF(String str) {
            return sc(qr.zY(str));
        }

        public sc pFF(String str, String str2) {
            if (!this.pFF.containsKey(str)) {
                this.pFF.put(str, new ArrayList());
            }
            this.pFF.get(str).add(str2);
            return this;
        }

        public Ql pFF() {
            return new Ql() { // from class: com.bytedance.sdk.component.pFF.sc.Ql.sc.1
                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public com.bytedance.sdk.component.pFF.sc.sc ExN() {
                    return sc.this.f26930sc;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public SR Qj() {
                    return sc.this.TRI;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public String TRI() {
                    return sc.this.Qj;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public Map We() {
                    return sc.this.pFF;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public qr pFF() {
                    return sc.this.zY;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public int qr() {
                    return sc.this.f26929qr;
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public Object sc() {
                    return sc.this.ExN;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.pFF.sc.Ql
                public String zY() {
                    return sc.this.We;
                }
            };
        }

        public sc sc() {
            return sc("GET", (SR) null);
        }

        public sc sc(int i11) {
            this.f26929qr = i11;
            return this;
        }

        public sc sc(SR sr2) {
            return sc("POST", sr2);
        }

        public sc sc(qr qrVar) {
            this.zY = qrVar;
            return this;
        }

        public sc sc(com.bytedance.sdk.component.pFF.sc.sc scVar) {
            this.f26930sc = scVar;
            return this;
        }

        public sc sc(Object obj) {
            this.ExN = obj;
            return this;
        }

        public sc sc(String str) {
            this.Qj = str;
            return this;
        }

        public sc sc(String str, String str2) {
            return pFF(str, str2);
        }
    }

    public abstract com.bytedance.sdk.component.pFF.sc.sc ExN();

    public sc Ol() {
        return new sc(this);
    }

    public SR Qj() {
        return null;
    }

    public abstract String TRI();

    public abstract Map<String, List<String>> We();

    public abstract qr pFF();

    public abstract int qr();

    public abstract Object sc();

    public void sc(UFX ufx) {
        this.f26928sc = ufx;
    }

    public abstract String zY();
}
