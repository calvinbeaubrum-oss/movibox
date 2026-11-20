package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import cg.f;
import cg.h;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.j;
import com.google.firebase.crashlytics.internal.common.t;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;
import lk.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f40563c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f40564d = e("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f40565e = e("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f<CrashlyticsReport, byte[]> f40566f = new f() { // from class: com.google.firebase.crashlytics.internal.send.a
        @Override // cg.f
        public final Object apply(Object obj) {
            return b.d((CrashlyticsReport) obj);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReportQueue f40567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<CrashlyticsReport, byte[]> f40568b;

    public b(ReportQueue reportQueue, f<CrashlyticsReport, byte[]> fVar) {
        this.f40567a = reportQueue;
        this.f40568b = fVar;
    }

    public static b b(Context context, ok.g gVar, t tVar) {
        com.google.android.datatransport.runtime.t.f(context);
        h hVarG = com.google.android.datatransport.runtime.t.c().g(new dg.a(f40564d, f40565e));
        cg.c cVarB = cg.c.b("json");
        f<CrashlyticsReport, byte[]> fVar = f40566f;
        return new b(new ReportQueue(hVarG.b("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, cVarB, fVar), gVar.b(), tVar), fVar);
    }

    public static /* synthetic */ byte[] d(CrashlyticsReport crashlyticsReport) {
        return f40563c.E(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }

    public static String e(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            sb2.append(str.charAt(i11));
            if (str2.length() > i11) {
                sb2.append(str2.charAt(i11));
            }
        }
        return sb2.toString();
    }

    @NonNull
    public Task<j> c(@NonNull j jVar, boolean z11) {
        return this.f40567a.i(jVar, z11).getTask();
    }
}
