package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f19761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f19762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19763c;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private iq() {
    }

    public static iq a(es esVar, iq iqVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (iqVar == null) {
            try {
                iqVar = new iq();
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("VastNonVideoResource", "Error occurred while initializing", th2);
                }
                jVar.E().a("VastNonVideoResource", th2);
                return null;
            }
        }
        if (iqVar.f19762b == null && !StringUtils.isValidString(iqVar.f19763c)) {
            String strA = a(esVar, "StaticResource");
            if (URLUtil.isValidUrl(strA)) {
                iqVar.f19762b = Uri.parse(strA);
                iqVar.f19761a = a.STATIC;
                return iqVar;
            }
            String strA2 = a(esVar, "IFrameResource");
            if (StringUtils.isValidString(strA2)) {
                iqVar.f19761a = a.IFRAME;
                if (URLUtil.isValidUrl(strA2)) {
                    iqVar.f19762b = Uri.parse(strA2);
                } else {
                    iqVar.f19763c = strA2;
                }
                return iqVar;
            }
            String strA3 = a(esVar, "HTMLResource");
            if (StringUtils.isValidString(strA3)) {
                iqVar.f19761a = a.HTML;
                if (URLUtil.isValidUrl(strA3)) {
                    iqVar.f19762b = Uri.parse(strA3);
                } else {
                    iqVar.f19763c = strA3;
                }
            }
        }
        return iqVar;
    }

    private static String a(es esVar, String str) {
        es esVarC = esVar.c(str);
        if (esVarC != null) {
            return esVarC.d();
        }
        return null;
    }

    public String a() {
        return this.f19763c;
    }

    public void a(Uri uri) {
        this.f19762b = uri;
    }

    public void a(String str) {
        this.f19763c = str;
    }

    public Uri b() {
        return this.f19762b;
    }

    public a c() {
        return this.f19761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iq)) {
            return false;
        }
        iq iqVar = (iq) obj;
        if (this.f19761a != iqVar.f19761a) {
            return false;
        }
        Uri uri = this.f19762b;
        if (uri == null ? iqVar.f19762b != null : !uri.equals(iqVar.f19762b)) {
            return false;
        }
        String str = this.f19763c;
        String str2 = iqVar.f19763c;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        a aVar = this.f19761a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f19762b;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f19763c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f19761a + ", resourceUri=" + this.f19762b + ", resourceContents='" + this.f19763c + "'}";
    }
}
