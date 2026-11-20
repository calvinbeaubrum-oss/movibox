package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f40196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nk.e f40197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.crashlytics.internal.send.b f40198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jk.c f40199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jk.i f40200e;

    public e0(i iVar, nk.e eVar, com.google.firebase.crashlytics.internal.send.b bVar, jk.c cVar, jk.i iVar2) {
        this.f40196a = iVar;
        this.f40197b = eVar;
        this.f40198c = bVar;
        this.f40199d = cVar;
        this.f40200e = iVar2;
    }

    @RequiresApi(api = 30)
    public static CrashlyticsReport.a e(ApplicationExitInfo applicationExitInfo) {
        String strF = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strF = f(traceInputStream);
            }
        } catch (IOException e11) {
            gk.f.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e11);
        }
        return CrashlyticsReport.a.a().b(applicationExitInfo.getImportance()).d(applicationExitInfo.getProcessName()).f(applicationExitInfo.getReason()).h(applicationExitInfo.getTimestamp()).c(applicationExitInfo.getPid()).e(applicationExitInfo.getPss()).g(applicationExitInfo.getRss()).i(strF).a();
    }

    @RequiresApi(api = 19)
    public static String f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    public static e0 g(Context context, o oVar, nk.f fVar, a aVar, jk.c cVar, jk.i iVar, pk.d dVar, ok.g gVar, t tVar) {
        return new e0(new i(context, oVar, aVar, dVar), new nk.e(fVar, gVar), com.google.firebase.crashlytics.internal.send.b.b(context, gVar, tVar), cVar, iVar);
    }

    @NonNull
    public static List<CrashlyticsReport.c> k(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.c.a().b(entry.getKey()).c(entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.c0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e0.m((CrashlyticsReport.c) obj, (CrashlyticsReport.c) obj2);
            }
        });
        return arrayList;
    }

    public static /* synthetic */ int m(CrashlyticsReport.c cVar, CrashlyticsReport.c cVar2) {
        return cVar.b().compareTo(cVar2.b());
    }

    public final CrashlyticsReport.e.d c(CrashlyticsReport.e.d dVar) {
        return d(dVar, this.f40199d, this.f40200e);
    }

    public final CrashlyticsReport.e.d d(CrashlyticsReport.e.d dVar, jk.c cVar, jk.i iVar) {
        CrashlyticsReport.e.d.b bVarG = dVar.g();
        String strC = cVar.c();
        if (strC != null) {
            bVarG.d(CrashlyticsReport.e.d.AbstractC0438d.a().b(strC).a());
        } else {
            gk.f.f().i("No log data to include with this event.");
        }
        List<CrashlyticsReport.c> listK = k(iVar.e());
        List<CrashlyticsReport.c> listK2 = k(iVar.f());
        if (!listK.isEmpty() || !listK2.isEmpty()) {
            bVarG.b(dVar.b().g().c(kk.e.a(listK)).e(kk.e.a(listK2)).a());
        }
        return bVarG.a();
    }

    public void h(@NonNull String str, @NonNull List<r> list) {
        gk.f.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator<r> it = list.iterator();
        while (it.hasNext()) {
            CrashlyticsReport.d.b bVarA = it.next().a();
            if (bVarA != null) {
                arrayList.add(bVarA);
            }
        }
        this.f40197b.l(str, CrashlyticsReport.d.a().b(kk.e.a(arrayList)).a());
    }

    public void i(long j11, @Nullable String str) {
        this.f40197b.k(str, j11);
    }

    @Nullable
    @RequiresApi(api = 30)
    public final ApplicationExitInfo j(String str, List<ApplicationExitInfo> list) {
        long jQ = this.f40197b.q(str);
        Iterator<ApplicationExitInfo> it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo applicationExitInfoA = com.applovin.impl.sdk.s.a(it.next());
            if (applicationExitInfoA.getTimestamp() < jQ) {
                return null;
            }
            if (applicationExitInfoA.getReason() == 6) {
                return applicationExitInfoA;
            }
        }
        return null;
    }

    public boolean l() {
        return this.f40197b.r();
    }

    public SortedSet<String> n() {
        return this.f40197b.p();
    }

    public void o(@NonNull String str, long j11) {
        this.f40197b.z(this.f40196a.d(str, j11));
    }

    public final boolean p(@NonNull Task<j> task) {
        if (!task.isSuccessful()) {
            gk.f.f().l("Crashlytics report could not be enqueued to DataTransport", task.getException());
            return false;
        }
        j result = task.getResult();
        gk.f.f().b("Crashlytics report successfully enqueued to DataTransport: " + result.d());
        File fileC = result.c();
        if (fileC.delete()) {
            gk.f.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        gk.f.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    public final void q(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j11, boolean z11) {
        this.f40197b.y(c(this.f40196a.c(th2, thread, str2, j11, 4, 8, z11)), str, str2.equals(AppMeasurement.CRASH_ORIGIN));
    }

    public void r(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, long j11) {
        gk.f.f().i("Persisting fatal event for session " + str);
        q(th2, thread, str, AppMeasurement.CRASH_ORIGIN, j11, true);
    }

    public void s(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, long j11) {
        gk.f.f().i("Persisting non-fatal event for session " + str);
        q(th2, thread, str, "error", j11, false);
    }

    @RequiresApi(api = 30)
    public void t(String str, List<ApplicationExitInfo> list, jk.c cVar, jk.i iVar) {
        ApplicationExitInfo applicationExitInfoJ = j(str, list);
        if (applicationExitInfoJ == null) {
            gk.f.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.e.d dVarB = this.f40196a.b(e(applicationExitInfoJ));
        gk.f.f().b("Persisting anr for session " + str);
        this.f40197b.y(d(dVarB, cVar, iVar), str, true);
    }

    public void u() {
        this.f40197b.i();
    }

    public Task<Void> v(@NonNull Executor executor) {
        return w(executor, null);
    }

    public Task<Void> w(@NonNull Executor executor, @Nullable String str) {
        List<j> listW = this.f40197b.w();
        ArrayList arrayList = new ArrayList();
        for (j jVar : listW) {
            if (str == null || str.equals(jVar.d())) {
                arrayList.add(this.f40198c.c(jVar, str != null).continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.d0
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return Boolean.valueOf(this.f40193a.p(task));
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
