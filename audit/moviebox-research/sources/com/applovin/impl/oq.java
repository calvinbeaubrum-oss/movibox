package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f21602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f21603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f21604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f21605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f21608g;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        Progressive,
        Streaming
    }

    private oq() {
    }

    private static long a(es esVar) {
        Map mapA = esVar.a();
        long j11 = StringUtils.parseLong((String) mapA.get("bitrate"), 0L);
        return j11 != 0 ? j11 : (StringUtils.parseLong((String) mapA.get("minBitrate"), 0L) + StringUtils.parseLong((String) mapA.get("maxBitrate"), 0L)) / 2;
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    public static oq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = esVar.d();
            if (!URLUtil.isValidUrl(strD)) {
                jVar.J();
                if (!com.applovin.impl.sdk.n.a()) {
                    return null;
                }
                jVar.J().b("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            }
            Uri uri = Uri.parse(strD);
            oq oqVar = new oq();
            oqVar.f21602a = uri;
            oqVar.f21603b = uri;
            oqVar.f21608g = a(esVar);
            oqVar.f21604c = a((String) esVar.a().get("delivery"));
            oqVar.f21607f = StringUtils.parseInt((String) esVar.a().get("height"));
            oqVar.f21606e = StringUtils.parseInt((String) esVar.a().get("width"));
            oqVar.f21605d = ((String) esVar.a().get("type")).toLowerCase(Locale.ENGLISH);
            return oqVar;
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastVideoFile", "Error occurred while initializing", th2);
            }
            jVar.E().a("VastVideoFile", th2);
            return null;
        }
    }

    public long a() {
        return this.f21608g;
    }

    public void a(Uri uri) {
        this.f21603b = uri;
    }

    public String b() {
        return this.f21605d;
    }

    public Uri c() {
        return this.f21602a;
    }

    public Uri d() {
        return this.f21603b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oq)) {
            return false;
        }
        oq oqVar = (oq) obj;
        if (this.f21606e != oqVar.f21606e || this.f21607f != oqVar.f21607f || this.f21608g != oqVar.f21608g) {
            return false;
        }
        Uri uri = this.f21602a;
        if (uri == null ? oqVar.f21602a != null : !uri.equals(oqVar.f21602a)) {
            return false;
        }
        Uri uri2 = this.f21603b;
        if (uri2 == null ? oqVar.f21603b != null : !uri2.equals(oqVar.f21603b)) {
            return false;
        }
        if (this.f21604c != oqVar.f21604c) {
            return false;
        }
        String str = this.f21605d;
        String str2 = oqVar.f21605d;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f21602a;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f21603b;
        int iHashCode2 = (iHashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.f21604c;
        int iHashCode3 = (iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f21605d;
        return ((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.f21606e) * 31) + this.f21607f) * 31) + Long.valueOf(this.f21608g).hashCode();
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f21602a + ", videoUri=" + this.f21603b + ", deliveryType=" + this.f21604c + ", fileType='" + this.f21605d + "', width=" + this.f21606e + ", height=" + this.f21607f + ", bitrate=" + this.f21608g + '}';
    }
}
