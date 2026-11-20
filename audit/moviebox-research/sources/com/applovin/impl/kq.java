package com.applovin.impl;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class kq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f20274d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20275e = -1;

    private kq() {
    }

    private static int a(String str, eq eqVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT.equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equalsIgnoreCase(str)) {
            return -1;
        }
        if (eqVar != null) {
            return eqVar.g();
        }
        return 95;
    }

    public static kq a(es esVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        List<String> listExplode;
        int size;
        long seconds;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = esVar.d();
            if (!StringUtils.isValidString(strD)) {
                jVar.J();
                if (!com.applovin.impl.sdk.n.a()) {
                    return null;
                }
                jVar.J().b("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            }
            kq kqVar = new kq();
            kqVar.f20273c = strD;
            kqVar.f20271a = (String) esVar.a().get("id");
            kqVar.f20272b = (String) esVar.a().get(NotificationCompat.CATEGORY_EVENT);
            kqVar.f20275e = a(kqVar.a(), eqVar);
            String str = (String) esVar.a().get("offset");
            if (StringUtils.isValidString(str)) {
                String strTrim = str.trim();
                if (strTrim.contains("%")) {
                    kqVar.f20275e = StringUtils.parseInt(strTrim.substring(0, strTrim.length() - 1));
                } else if (strTrim.contains(":") && (size = (listExplode = CollectionUtils.explode(strTrim, ":")).size()) > 0) {
                    int i11 = size - 1;
                    long j11 = 0;
                    for (int i12 = i11; i12 >= 0; i12--) {
                        String str2 = listExplode.get(i12);
                        if (StringUtils.isNumeric(str2)) {
                            int i13 = Integer.parseInt(str2);
                            if (i12 == i11) {
                                seconds = i13;
                            } else if (i12 == size - 2) {
                                seconds = TimeUnit.MINUTES.toSeconds(i13);
                            } else if (i12 == size - 3) {
                                seconds = TimeUnit.HOURS.toSeconds(i13);
                            }
                            j11 += seconds;
                        }
                    }
                    kqVar.f20274d = j11;
                    kqVar.f20275e = -1;
                }
            }
            return kqVar;
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastTracker", "Error occurred while initializing", th2);
            }
            jVar.E().a("VastTracker", th2);
            return null;
        }
    }

    public String a() {
        return this.f20272b;
    }

    public boolean a(long j11, int i11) {
        long j12 = this.f20274d;
        boolean z11 = j12 >= 0;
        boolean z12 = j11 >= j12;
        int i12 = this.f20275e;
        return (z11 && z12) || ((i12 >= 0) && (i11 >= i12));
    }

    public String b() {
        return this.f20273c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kq)) {
            return false;
        }
        kq kqVar = (kq) obj;
        if (this.f20274d != kqVar.f20274d || this.f20275e != kqVar.f20275e) {
            return false;
        }
        String str = this.f20271a;
        if (str == null ? kqVar.f20271a != null : !str.equals(kqVar.f20271a)) {
            return false;
        }
        String str2 = this.f20272b;
        if (str2 == null ? kqVar.f20272b == null : str2.equals(kqVar.f20272b)) {
            return this.f20273c.equals(kqVar.f20273c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f20271a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20272b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f20273c.hashCode()) * 31;
        long j11 = this.f20274d;
        return ((iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f20275e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f20271a + "', event='" + this.f20272b + "', uriString='" + this.f20273c + "', offsetSeconds=" + this.f20274d + ", offsetPercent=" + this.f20275e + '}';
    }
}
