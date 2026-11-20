package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f40206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f40207f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f40209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f40210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pk.d f40211d;

    static {
        HashMap map = new HashMap();
        f40206e = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f40207f = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.3.2");
    }

    public i(Context context, o oVar, a aVar, pk.d dVar) {
        this.f40208a = context;
        this.f40209b = oVar;
        this.f40210c = aVar;
        this.f40211d = dVar;
    }

    public static int e() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f40206e.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    public final CrashlyticsReport.b a() {
        return CrashlyticsReport.b().h("18.3.2").d(this.f40210c.f40178a).e(this.f40209b.a()).b(this.f40210c.f40182e).c(this.f40210c.f40183f).g(4);
    }

    public CrashlyticsReport.e.d b(CrashlyticsReport.a aVar) {
        int i11 = this.f40208a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.e.d.a().f("anr").e(aVar.h()).b(h(i11, aVar)).c(j(i11)).a();
    }

    public CrashlyticsReport.e.d c(Throwable th2, Thread thread, String str, long j11, int i11, int i12, boolean z11) {
        int i13 = this.f40208a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.e.d.a().f(str).e(j11).b(i(i13, new pk.e(th2, this.f40211d), thread, i11, i12, z11)).c(j(i13)).a();
    }

    public CrashlyticsReport d(String str, long j11) {
        return a().i(r(str, j11)).a();
    }

    public final CrashlyticsReport.e.d.a.b.AbstractC0428a f() {
        return CrashlyticsReport.e.d.a.b.AbstractC0428a.a().b(0L).d(0L).c(this.f40210c.f40181d).e(this.f40210c.f40179b).a();
    }

    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0428a> g() {
        return kk.e.b(f());
    }

    public final CrashlyticsReport.e.d.a h(int i11, CrashlyticsReport.a aVar) {
        return CrashlyticsReport.e.d.a.a().b(Boolean.valueOf(aVar.b() != 100)).f(i11).d(m(aVar)).a();
    }

    public final CrashlyticsReport.e.d.a i(int i11, pk.e eVar, Thread thread, int i12, int i13, boolean z11) {
        Boolean boolValueOf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoJ = CommonUtils.j(this.f40210c.f40181d, this.f40208a);
        if (runningAppProcessInfoJ != null) {
            boolValueOf = Boolean.valueOf(runningAppProcessInfoJ.importance != 100);
        } else {
            boolValueOf = null;
        }
        return CrashlyticsReport.e.d.a.a().b(boolValueOf).f(i11).d(n(eVar, thread, i12, i13, z11)).a();
    }

    public final CrashlyticsReport.e.d.c j(int i11) {
        c cVarA = c.a(this.f40208a);
        Float fB = cVarA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = cVarA.c();
        boolean zO = CommonUtils.o(this.f40208a);
        return CrashlyticsReport.e.d.c.a().b(dValueOf).c(iC).f(zO).e(i11).g(CommonUtils.s() - CommonUtils.a(this.f40208a)).d(CommonUtils.b(Environment.getDataDirectory().getPath())).a();
    }

    public final CrashlyticsReport.e.d.a.b.c k(pk.e eVar, int i11, int i12) {
        return l(eVar, i11, i12, 0);
    }

    public final CrashlyticsReport.e.d.a.b.c l(pk.e eVar, int i11, int i12, int i13) {
        String str = eVar.f73878b;
        String str2 = eVar.f73877a;
        StackTraceElement[] stackTraceElementArr = eVar.f73879c;
        int i14 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        pk.e eVar2 = eVar.f73880d;
        if (i13 >= i12) {
            pk.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f73880d;
                i14++;
            }
        }
        CrashlyticsReport.e.d.a.b.c.AbstractC0431a abstractC0431aD = CrashlyticsReport.e.d.a.b.c.a().f(str).e(str2).c(kk.e.a(p(stackTraceElementArr, i11))).d(i14);
        if (eVar2 != null && i14 == 0) {
            abstractC0431aD.b(l(eVar2, i11, i12, i13 + 1));
        }
        return abstractC0431aD.a();
    }

    public final CrashlyticsReport.e.d.a.b m(CrashlyticsReport.a aVar) {
        return CrashlyticsReport.e.d.a.b.a().b(aVar).e(u()).c(g()).a();
    }

    public final CrashlyticsReport.e.d.a.b n(pk.e eVar, Thread thread, int i11, int i12, boolean z11) {
        return CrashlyticsReport.e.d.a.b.a().f(x(eVar, thread, i11, z11)).d(k(eVar, i11, i12)).e(u()).c(g()).a();
    }

    public final CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b o(StackTraceElement stackTraceElement, CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a abstractC0437a) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return abstractC0437a.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> p(StackTraceElement[] stackTraceElementArr, int i11) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(o(stackTraceElement, CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.a().c(i11)));
        }
        return kk.e.a(arrayList);
    }

    public final CrashlyticsReport.e.a q() {
        return CrashlyticsReport.e.a.a().e(this.f40209b.f()).g(this.f40210c.f40182e).d(this.f40210c.f40183f).f(this.f40209b.a()).b(this.f40210c.f40184g.d()).c(this.f40210c.f40184g.e()).a();
    }

    public final CrashlyticsReport.e r(String str, long j11) {
        return CrashlyticsReport.e.a().l(j11).i(str).g(f40207f).b(q()).k(t()).d(s()).h(3).a();
    }

    public final CrashlyticsReport.e.c s() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iE = e();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jS = CommonUtils.s();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zY = CommonUtils.y();
        int iM = CommonUtils.m();
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.e.c.a().b(iE).f(Build.MODEL).c(iAvailableProcessors).h(jS).d(blockCount).i(zY).j(iM).e(str).g(Build.PRODUCT).a();
    }

    public final CrashlyticsReport.e.AbstractC0439e t() {
        return CrashlyticsReport.e.AbstractC0439e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.z()).a();
    }

    public final CrashlyticsReport.e.d.a.b.AbstractC0432d u() {
        return CrashlyticsReport.e.d.a.b.AbstractC0432d.a().d("0").c("0").b(0L).a();
    }

    public final CrashlyticsReport.e.d.a.b.AbstractC0434e v(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return w(thread, stackTraceElementArr, 0);
    }

    public final CrashlyticsReport.e.d.a.b.AbstractC0434e w(Thread thread, StackTraceElement[] stackTraceElementArr, int i11) {
        return CrashlyticsReport.e.d.a.b.AbstractC0434e.a().d(thread.getName()).c(i11).b(kk.e.a(p(stackTraceElementArr, i11))).a();
    }

    public final kk.e<CrashlyticsReport.e.d.a.b.AbstractC0434e> x(pk.e eVar, Thread thread, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w(thread, eVar.f73879c, i11));
        if (z11) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(v(key, this.f40211d.a(entry.getValue())));
                }
            }
        }
        return kk.e.a(arrayList);
    }
}
