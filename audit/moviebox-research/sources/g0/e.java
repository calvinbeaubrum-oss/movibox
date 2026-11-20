package g0;

import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniapp.defaultimpl.AthenaReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.f;
import kd.k;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f65310a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f65311b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f65312c;

    static {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
    }

    public static final void f(List dataCaches) {
        Intrinsics.g(dataCaches, "$dataCaches");
        Iterator it = dataCaches.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(l.c());
            sb2.append(":mfah report -> cache, post, athenaAppId = ");
            sb2.append(aVar.f65301a);
            sb2.append(", tag = ");
            k.a(sb2, aVar.f65302b, "AthenaUtil");
            f65310a.d(aVar.f65302b, aVar.f65301a, aVar.f65303c);
        }
    }

    public static final void h(List dataCaches) {
        Intrinsics.g(dataCaches, "$dataCaches");
        Iterator it = dataCaches.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(l.c());
            sb2.append(":report -> cache, post, athenaAppId = ");
            sb2.append(aVar.f65301a);
            sb2.append(", tag = ");
            k.a(sb2, aVar.f65302b, "AthenaUtil");
            f65310a.d(aVar.f65302b, aVar.f65301a, aVar.f65303c);
        }
    }

    public final j0.a a(String str, boolean z11) {
        if (!l.e()) {
            if (l.d()) {
                return null;
            }
            return new j0.a(false, false, false);
        }
        if (!z11) {
            Application application = f65312c;
            ArrayList steps = g.h(new k0.a(), new k0.c(), new f(), new k0.d());
            Intrinsics.g(steps, "steps");
            j0.a athenaReportBean = new j0.a(false, false, false);
            Intrinsics.g(steps, "steps");
            Intrinsics.g(athenaReportBean, "athenaReportBean");
            if (steps.size() > 0) {
                ((k0.e) steps.get(0)).a(new j0.b(application, str, steps, 1, athenaReportBean));
            }
            return athenaReportBean;
        }
        Application application2 = f65312c;
        ArrayList steps2 = g.h(new k0.a(), new k0.b(), new k0.c(), new f(), new k0.d());
        Intrinsics.g(steps2, "steps");
        j0.a athenaReportBean2 = new j0.a(false, false, false);
        Intrinsics.g(steps2, "steps");
        Intrinsics.g(athenaReportBean2, "athenaReportBean");
        if (steps2.size() <= 0) {
            return athenaReportBean2;
        }
        ((k0.e) steps2.get(0)).a(new j0.b(application2, str, steps2, 1, athenaReportBean2));
        return athenaReportBean2;
    }

    public final void b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("miniProcessAppOrPageReady -> delay:");
        sb2.append(false);
        sb2.append(", isMiniProcess:");
        sb2.append(l.e());
        sb2.append(", mainProcessInitAthenaFlag:");
        AthenaReport.Companion.getClass();
        sb2.append(AthenaReport.OooO0OO.get());
        sb2.append(", miniProcessInitAthenaFlag:");
        sb2.append(AthenaReport.f31503OooO0Oo.get());
        sb2.append(", zeroProcessInitAthenaFlag:");
        sb2.append(AthenaReport.f31504OooO0o0.get());
        TmcLogger.c("AthenaUtil", sb2.toString());
    }

    public final void c(String appId) {
        final ArrayList<a> arrayList;
        Intrinsics.g(appId, "appId");
        try {
            b bVar = b.f65304a;
            try {
                arrayList = new ArrayList();
                ConcurrentLinkedQueue<a> concurrentLinkedQueue = b.f65307d.get(appId);
                if (concurrentLinkedQueue != null && (!concurrentLinkedQueue.isEmpty())) {
                    arrayList.addAll(concurrentLinkedQueue);
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            TmcLogger.c("AthenaUtil", "appId: ->" + appId + ",->mfah report -> report all cache :" + arrayList.size());
            try {
                ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> concurrentHashMap = b.f65307d;
                ConcurrentLinkedQueue<a> concurrentLinkedQueue2 = concurrentHashMap.get(appId);
                if (concurrentLinkedQueue2 != null) {
                    concurrentLinkedQueue2.clear();
                }
                TypeIntrinsics.d(concurrentHashMap).remove(appId);
            } catch (Throwable th2) {
                TmcLogger.g("AthenaUtil", "clearAthenaDataForId", th2);
            }
            if (!arrayList.isEmpty()) {
                TmcLogger.c("AthenaUtil", l.c() + ":mfah report -> exist cache, post all size = " + arrayList.size());
                if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                    com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: g0.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.f(arrayList);
                        }
                    });
                    return;
                }
                for (a aVar : arrayList) {
                    TmcLogger.c("AthenaUtil", l.c() + ":report -> cache, post, athenaAppId = " + aVar.f65301a + ", tag = " + aVar.f65302b);
                    f65310a.d(aVar.f65302b, aVar.f65301a, aVar.f65303c);
                }
            }
        } catch (Throwable th3) {
            TmcLogger.g("AthenaUtil", "athena cache report ", th3);
        }
    }

    public final void d(String str, int i11, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new dr.a(str, i11).c(bundle, null).b();
    }

    public final void e(String tag, int i11, Bundle data, String appId) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(data, "data");
        try {
            j0.a aVarA = a(appId, true);
            if (aVarA == null) {
                return;
            }
            TmcLogger.c("AthenaUtil", l.c() + ":getAthenaStrategyResult -> setCache = " + aVarA.f67800a + ", clearCache = " + aVarA.f67801b + ",isMfah = " + aVarA.f67802c);
            if (aVarA.f67802c && aVarA.f67800a) {
                TmcLogger.c("AthenaUtil", l.c() + ": mfah report -> save cache, athenaAppId = " + i11 + ", tag = " + tag);
                if (appId != null && appId.length() != 0) {
                    b bVar = b.f65304a;
                    a athenaDataBean = new a(i11, tag, data);
                    Intrinsics.g(appId, "appId");
                    Intrinsics.g(athenaDataBean, "athenaDataBean");
                    try {
                        ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> concurrentHashMap = b.f65307d;
                        ConcurrentLinkedQueue<a> concurrentLinkedQueue = concurrentHashMap.get(appId);
                        if (concurrentLinkedQueue == null) {
                            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                            concurrentHashMap.put(appId, concurrentLinkedQueue);
                        }
                        concurrentLinkedQueue.add(athenaDataBean);
                        return;
                    } catch (Throwable th2) {
                        TmcLogger.g("AthenaUtil", "setAthenaDataForId", th2);
                        return;
                    }
                }
                b bVar2 = b.f65304a;
                a athenaDataBean2 = new a(i11, tag, data);
                Intrinsics.g(athenaDataBean2, "athenaDataBean");
                bVar2.a();
                b.f65306c.add(athenaDataBean2);
                return;
            }
            if (aVarA.f67800a) {
                TmcLogger.c("AthenaUtil", l.c() + ":report -> save cache, athenaAppId = " + i11 + ", tag = " + tag);
                b bVar3 = b.f65304a;
                a athenaDataBean3 = new a(i11, tag, data);
                Intrinsics.g(athenaDataBean3, "athenaDataBean");
                bVar3.a();
                b.f65306c.add(athenaDataBean3);
                return;
            }
            if (!aVarA.f67801b) {
                TmcLogger.c("AthenaUtil", l.c() + ":report -> no cache, post only current, athenaAppId = " + i11 + ", tag = " + tag);
                d(tag, i11, data);
                return;
            }
            b bVar4 = b.f65304a;
            final ArrayList<a> arrayList = new ArrayList();
            ConcurrentLinkedQueue<a> concurrentLinkedQueue2 = b.f65306c;
            arrayList.addAll(concurrentLinkedQueue2);
            concurrentLinkedQueue2.clear();
            if (!(true ^ arrayList.isEmpty())) {
                TmcLogger.c("AthenaUtil", l.c() + ":report -> no cache, post only current, athenaAppId = " + i11 + ", tag = " + tag);
                d(tag, i11, data);
                return;
            }
            TmcLogger.c("AthenaUtil", l.c() + ":report -> exist cache, post all size = " + arrayList.size());
            arrayList.add(new a(i11, tag, data));
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: g0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.h(arrayList);
                    }
                });
                return;
            }
            for (a aVar : arrayList) {
                TmcLogger.c("AthenaUtil", l.c() + ":report -> cache, post, athenaAppId = " + aVar.f65301a + ", tag = " + aVar.f65302b);
                f65310a.d(aVar.f65302b, aVar.f65301a, aVar.f65303c);
            }
        } catch (Throwable unused) {
        }
    }

    public final void g(String tag, int i11, Bundle bundle) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(bundle, "bundle");
        try {
            d(tag, i11, bundle);
        } catch (Throwable th2) {
            TmcLogger.g("AthenaUtil", "forceAthenaReport", th2);
        }
    }
}
