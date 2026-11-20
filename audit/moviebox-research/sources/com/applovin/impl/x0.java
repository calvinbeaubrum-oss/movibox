package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f24196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f24198g;

    public x0(String str) {
        this(str, -1);
    }

    public x0(String str, int i11) {
        this.f24196e = str;
        this.f24197f = i11;
        String[] strArrSplit = str.split(",");
        boolean z11 = strArrSplit.length == 3 || strArrSplit.length == 4;
        this.f24198g = z11;
        if (z11) {
            this.f24192a = a(strArrSplit[0]);
            this.f24193b = a(strArrSplit[1]);
            this.f24194c = a(strArrSplit[2]);
            this.f24195d = strArrSplit.length == 4 ? a(strArrSplit[3]) : "";
            return;
        }
        this.f24192a = "";
        this.f24193b = "";
        this.f24194c = "";
        this.f24195d = "";
    }

    private String a(String str) {
        return str.replace((char) 173, ' ').trim();
    }

    public String a() {
        return this.f24195d;
    }

    public boolean a(Object obj) {
        return obj instanceof x0;
    }

    public String b() {
        return this.f24192a;
    }

    public String c() {
        return this.f24193b;
    }

    public String d() {
        return this.f24196e;
    }

    public String e() {
        return this.f24194c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        if (!x0Var.a(this)) {
            return false;
        }
        String strB = b();
        String strB2 = x0Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = x0Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = x0Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strA = a();
        String strA2 = x0Var.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int f() {
        return this.f24197f;
    }

    public boolean g() {
        return this.f24192a.equals("applovin.com");
    }

    public boolean h() {
        return this.f24198g;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        String strC = c();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strC == null ? 43 : strC.hashCode());
        String strE = e();
        int iHashCode3 = (iHashCode2 * 59) + (strE == null ? 43 : strE.hashCode());
        String strA = a();
        return (iHashCode3 * 59) + (strA != null ? strA.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + b() + ", publisherId=" + c() + ", relationship=" + e() + ", certificateAuthorityId=" + a() + ", rawValue=" + d() + ", rowNumber=" + f() + ", valid=" + h() + ")";
    }
}
