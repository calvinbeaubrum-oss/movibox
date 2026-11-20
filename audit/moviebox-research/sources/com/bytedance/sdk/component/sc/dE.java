package com.bytedance.sdk.component.sc;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE {
    public final String ExN;
    public final String Qj;
    public final String TRI;
    public final String We;
    public final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public final String f27006qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final int f27007sc;
    public final String zY;

    /* JADX INFO: compiled from: source.java */
    public static final class sc {
        private String ExN;
        private String TRI;
        private String We;
        private String pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private String f27008qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f27009sc;
        private String zY;

        private sc() {
        }

        public sc ExN(String str) {
            this.ExN = str;
            return this;
        }

        public sc TRI(String str) {
            this.TRI = str;
            return this;
        }

        public sc We(String str) {
            this.We = str;
            return this;
        }

        public sc pFF(String str) {
            this.pFF = str;
            return this;
        }

        public sc qr(String str) {
            this.f27008qr = str;
            return this;
        }

        public sc sc(String str) {
            this.f27009sc = str;
            return this;
        }

        public dE sc() {
            return new dE(this);
        }

        public sc zY(String str) {
            this.zY = str;
            return this;
        }
    }

    private dE(sc scVar) {
        this.pFF = scVar.f27009sc;
        this.zY = scVar.pFF;
        this.We = scVar.zY;
        this.ExN = scVar.We;
        this.TRI = scVar.ExN;
        this.f27006qr = scVar.TRI;
        this.f27007sc = 1;
        this.Qj = scVar.f27008qr;
    }

    private dE(String str, int i11) {
        this.pFF = null;
        this.zY = null;
        this.We = null;
        this.ExN = null;
        this.TRI = str;
        this.f27006qr = null;
        this.f27007sc = i11;
        this.Qj = null;
    }

    public static sc sc() {
        return new sc();
    }

    public static dE sc(String str, int i11) {
        return new dE(str, i11);
    }

    public static boolean sc(dE dEVar) {
        return dEVar == null || dEVar.f27007sc != 1 || TextUtils.isEmpty(dEVar.We) || TextUtils.isEmpty(dEVar.ExN);
    }

    public String toString() {
        return "methodName: " + this.We + ", params: " + this.ExN + ", callbackId: " + this.TRI + ", type: " + this.zY + ", version: " + this.pFF + ", ";
    }
}
