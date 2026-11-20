package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateFormat f21191a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Random f21192b = new Random(System.currentTimeMillis());

    public static Uri a(String str, long j11, Uri uri, fq fqVar, com.applovin.impl.sdk.j jVar) {
        if (!URLUtil.isValidUrl(str)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastUtils", "Unable to replace macros in invalid URL string.");
            }
            return null;
        }
        try {
            String string = Integer.toString(fqVar.b());
            String strReplace = str.replace("[ERRORCODE]", string).replace("[REASON]", string);
            if (j11 >= 0) {
                strReplace = strReplace.replace("[CONTENTPLAYHEAD]", a(j11));
            }
            if (uri != null) {
                strReplace = strReplace.replace("[ASSETURI]", uri.toString());
            }
            return Uri.parse(strReplace.replace("[CACHEBUSTING]", a()).replace("[TIMESTAMP]", b()));
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastUtils", "Unable to replace macros in URL string " + str, th2);
            }
            jVar.E().a("VastUtils", th2);
            return null;
        }
    }

    private static String a() {
        return Integer.toString(f21192b.nextInt(89999999) + 10000000);
    }

    private static String a(long j11) {
        if (j11 <= 0) {
            return "00:00:00.000";
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j11);
        long minutes = timeUnit.toMinutes(j11);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(hours), Long.valueOf(minutes % timeUnit2.toSeconds(1L)), Long.valueOf(j11 % timeUnit2.toSeconds(1L)));
    }

    public static String a(eq eqVar) {
        es esVarB;
        if (eqVar == null) {
            throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
        }
        List listA = eqVar.a();
        int size = eqVar.a().size();
        if (size <= 0 || (esVarB = ((es) listA.get(size - 1)).b("VASTAdTagURI")) == null) {
            return null;
        }
        return esVarB.d();
    }

    public static String a(es esVar, String str, String str2) {
        es esVarC = esVar.c(str);
        if (esVarC != null) {
            String strD = esVarC.d();
            if (StringUtils.isValidString(strD)) {
                return strD;
            }
        }
        return str2;
    }

    private static Set a(eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (eqVar == null) {
            return null;
        }
        List<es> listA = eqVar.a();
        Set hashSet = new HashSet(listA.size());
        for (es esVar : listA) {
            es esVarB = esVar.b("Wrapper");
            if (esVarB == null) {
                esVarB = esVar.b("InLine");
            }
            hashSet = esVarB != null ? a(hashSet, esVarB.a("Error"), eqVar, jVar) : a(hashSet, esVar.a("Error"), eqVar, jVar);
        }
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().a("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        }
        return hashSet;
    }

    private static Set a(Set set, List list, eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kq kqVarA = kq.a((es) it.next(), eqVar, jVar);
                if (kqVarA != null) {
                    set.add(kqVarA);
                }
            }
        }
        return set;
    }

    public static void a(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, fq fqVar, int i11, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i11);
        }
        a(a(eqVar, jVar), fqVar, jVar);
    }

    public static void a(es esVar, Map map, eq eqVar, com.applovin.impl.sdk.j jVar) {
        List<es> listA;
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (esVar == null) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastUtils", "Unable to render event trackers; null node provided");
                return;
            }
            return;
        }
        if (map == null) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastUtils", "Unable to render event trackers; null event trackers provided");
                return;
            }
            return;
        }
        es esVarC = esVar.c("TrackingEvents");
        if (esVarC == null || (listA = esVarC.a("Tracking")) == null) {
            return;
        }
        for (es esVar2 : listA) {
            String str = (String) esVar2.a().get(NotificationCompat.CATEGORY_EVENT);
            if (StringUtils.isValidString(str)) {
                kq kqVarA = kq.a(esVar2, eqVar, jVar);
                if (kqVarA != null) {
                    Set set = (Set) map.get(str);
                    if (set != null) {
                        set.add(kqVarA);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(kqVarA);
                        map.put(str, hashSet);
                    }
                }
            } else {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().b("VastUtils", "Could not find event for tracking node = " + esVar2);
                }
            }
        }
    }

    public static void a(List list, Set set, eq eqVar, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastUtils", "Unable to render trackers; null nodes provided");
                return;
            }
            return;
        }
        if (set == null) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("VastUtils", "Unable to render trackers; null trackers provided");
                return;
            }
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kq kqVarA = kq.a((es) it.next(), eqVar, jVar);
            if (kqVarA != null) {
                set.add(kqVarA);
            }
        }
    }

    public static void a(Set set, long j11, Uri uri, fq fqVar, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        }
        if (set == null || set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Uri uriA = a(((kq) it.next()).b(), j11, uri, fqVar, jVar);
            if (uriA != null) {
                jVar.X().a(com.applovin.impl.sdk.network.d.b().d(uriA.toString()).a(false).a(), false);
            }
        }
    }

    public static void a(Set set, fq fqVar, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, fqVar, jVar);
    }

    public static void a(Set set, com.applovin.impl.sdk.j jVar) {
        a(set, -1L, (Uri) null, fq.UNSPECIFIED, jVar);
    }

    public static boolean a(aq aqVar) {
        dq dqVarH1;
        iq iqVarD;
        if (aqVar == null || (dqVarH1 = aqVar.h1()) == null || (iqVarD = dqVarH1.d()) == null) {
            return false;
        }
        return iqVarD.b() != null || StringUtils.isValidString(iqVarD.a());
    }

    public static boolean a(es esVar) {
        if (esVar != null) {
            return esVar.b("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    private static String b() {
        DateFormat dateFormat = f21191a;
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(new Date());
    }

    public static boolean b(aq aqVar) {
        nq nqVarR1;
        List listF;
        return (aqVar == null || (nqVarR1 = aqVar.r1()) == null || (listF = nqVarR1.f()) == null || listF.isEmpty()) ? false : true;
    }

    public static boolean b(es esVar) {
        if (esVar != null) {
            return esVar.b("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    public static fq c(aq aqVar) {
        if (b(aqVar) || a(aqVar)) {
            return null;
        }
        return fq.GENERAL_WRAPPER_ERROR;
    }
}
