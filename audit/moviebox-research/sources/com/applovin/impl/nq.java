package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class nq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f21413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f21415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private gq f21417f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f21412a = Collections.emptyList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f21416e = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f21418g = new HashMap();

    private nq(eq eqVar) {
        this.f21413b = Collections.emptyList();
        this.f21413b = eqVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(oq oqVar, oq oqVar2) {
        return Long.compare(oqVar.a(), oqVar2.a());
    }

    private static int a(String str, com.applovin.impl.sdk.j jVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, ":");
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    public static nq a(es esVar, nq nqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        es esVarC;
        gq gqVarA;
        List listA;
        es esVarC2;
        List listA2;
        es esVarC3;
        int iA;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (eqVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (nqVar == null) {
            try {
                nqVar = new nq(eqVar);
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("VastVideoCreative", "Error occurred while initializing", th2);
                }
                jVar.E().a("VastVideoCreative", th2);
                return null;
            }
        }
        if (nqVar.f21414c == 0 && (esVarC3 = esVar.c("Duration")) != null && (iA = a(esVarC3.d(), jVar)) > 0) {
            nqVar.f21414c = iA;
        }
        es esVarC4 = esVar.c("MediaFiles");
        if (esVarC4 != null && (listA2 = a(esVarC4, jVar)) != null && listA2.size() > 0) {
            List list = nqVar.f21412a;
            if (list != null) {
                listA2.addAll(list);
            }
            nqVar.f21412a = listA2;
        }
        es esVarC5 = esVar.c("VideoClicks");
        if (esVarC5 != null) {
            if (nqVar.f21415d == null && (esVarC2 = esVarC5.c("ClickThrough")) != null) {
                String strD = esVarC2.d();
                if (StringUtils.isValidString(strD)) {
                    nqVar.f21415d = Uri.parse(strD);
                }
            }
            mq.a(esVarC5.a("ClickTracking"), nqVar.f21416e, eqVar, jVar);
        }
        es esVarC6 = esVar.c("Icons");
        if (esVarC6 != null && (gqVarA = gq.a((esVarC = esVarC6.c("Icon")), jVar)) != null) {
            es esVarC7 = esVarC.c("IconClicks");
            if (esVarC7 != null && (listA = esVarC7.a("IconClickTracking")) != null) {
                mq.a(listA, gqVarA.f19290a, eqVar, jVar);
            }
            List listA3 = esVarC.a("IconViewTracking");
            if (listA3 != null) {
                mq.a(listA3, gqVarA.f19291b, eqVar, jVar);
            }
            nqVar.f21417f = gqVarA;
        }
        mq.a(esVar, nqVar.f21418g, eqVar, jVar);
        return nqVar;
    }

    private static List a(es esVar, com.applovin.impl.sdk.j jVar) {
        List listA = esVar.a("MediaFile");
        ArrayList arrayList = new ArrayList(listA.size());
        List<String> listExplode = CollectionUtils.explode((String) jVar.a(sj.P4));
        List<String> listExplode2 = CollectionUtils.explode((String) jVar.a(sj.O4));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            oq oqVarA = oq.a((es) it.next(), jVar);
            if (oqVarA != null) {
                try {
                    String strB = oqVarA.b();
                    if (!StringUtils.isValidString(strB) || listExplode.contains(strB)) {
                        if (((Boolean) jVar.a(sj.Q4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(oqVarA.d().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(oqVarA);
                            }
                        }
                        jVar.J();
                        if (com.applovin.impl.sdk.n.a()) {
                            jVar.J().k("VastVideoCreative", "Video file not supported: " + oqVarA);
                        }
                    } else {
                        arrayList.add(oqVarA);
                    }
                } catch (Throwable th2) {
                    jVar.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.J().a("VastVideoCreative", "Failed to validate video file: " + oqVarA, th2);
                    }
                }
            }
        }
        return arrayList;
    }

    public oq a(long j11) {
        List list = this.f21412a;
        oq oqVar = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<oq> arrayList = new ArrayList(3);
        for (String str : this.f21413b) {
            for (oq oqVar2 : this.f21412a) {
                String strB = oqVar2.b();
                if (StringUtils.isValidString(strB) && str.equalsIgnoreCase(strB)) {
                    arrayList.add(oqVar2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f21412a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.n00
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return nq.a((oq) obj, (oq) obj2);
            }
        });
        for (oq oqVar3 : arrayList) {
            if (oqVar3.a() > j11) {
                break;
            }
            oqVar = oqVar3;
        }
        return oqVar != null ? oqVar : (oq) arrayList.get(0);
    }

    public Set a() {
        return this.f21416e;
    }

    public Uri b() {
        return this.f21415d;
    }

    public int c() {
        return this.f21414c;
    }

    public Map d() {
        return this.f21418g;
    }

    public gq e() {
        return this.f21417f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nq)) {
            return false;
        }
        nq nqVar = (nq) obj;
        if (this.f21414c != nqVar.f21414c) {
            return false;
        }
        List list = this.f21412a;
        if (list == null ? nqVar.f21412a != null : !list.equals(nqVar.f21412a)) {
            return false;
        }
        Uri uri = this.f21415d;
        if (uri == null ? nqVar.f21415d != null : !uri.equals(nqVar.f21415d)) {
            return false;
        }
        Set set = this.f21416e;
        if (set == null ? nqVar.f21416e != null : !set.equals(nqVar.f21416e)) {
            return false;
        }
        Map map = this.f21418g;
        Map map2 = nqVar.f21418g;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public List f() {
        return this.f21412a;
    }

    public int hashCode() {
        List list = this.f21412a;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f21414c) * 31;
        Uri uri = this.f21415d;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.f21416e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f21418g;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f21412a + ", durationSeconds=" + this.f21414c + ", destinationUri=" + this.f21415d + ", clickTrackers=" + this.f21416e + ", eventTrackers=" + this.f21418g + ", industryIcon=" + this.f21417f + '}';
    }
}
