package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cl.g;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.m;
import com.google.firebase.crashlytics.internal.common.o;
import gk.d;
import gk.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import jj.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseCrashlytics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashlyticsCore f39025a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements Continuation<Void, Object> {
        @Override // com.google.android.gms.tasks.Continuation
        public Object then(@NonNull Task<Void> task) throws Exception {
            if (task.isSuccessful()) {
                return null;
            }
            f.f().e("Error fetching settings.", task.getException());
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f39026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CrashlyticsCore f39027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.internal.settings.a f39028c;

        public b(boolean z11, CrashlyticsCore crashlyticsCore, com.google.firebase.crashlytics.internal.settings.a aVar) {
            this.f39026a = z11;
            this.f39027b = crashlyticsCore;
            this.f39028c = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (!this.f39026a) {
                return null;
            }
            this.f39027b.j(this.f39028c);
            return null;
        }
    }

    public FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.f39025a = crashlyticsCore;
    }

    @Nullable
    public static FirebaseCrashlytics a(@NonNull e eVar, @NonNull g gVar, @NonNull bl.a<gk.a> aVar, @NonNull bl.a<nj.a> aVar2) {
        Context contextJ = eVar.j();
        String packageName = contextJ.getPackageName();
        f.f().g("Initializing Firebase Crashlytics " + CrashlyticsCore.l() + " for " + packageName);
        nk.f fVar = new nk.f(contextJ);
        m mVar = new m(eVar);
        o oVar = new o(contextJ, packageName, gVar, mVar);
        d dVar = new d(aVar);
        sj.d dVar2 = new sj.d(aVar2);
        CrashlyticsCore crashlyticsCore = new CrashlyticsCore(eVar, oVar, dVar, mVar, dVar2.e(), dVar2.d(), fVar, ExecutorUtils.c("Crashlytics Exception Handler"));
        String strC = eVar.m().c();
        String strN = CommonUtils.n(contextJ);
        f.f().b("Mapping file ID is: " + strN);
        try {
            com.google.firebase.crashlytics.internal.common.a aVarA = com.google.firebase.crashlytics.internal.common.a.a(contextJ, oVar, strC, strN, new gk.e(contextJ));
            f.f().i("Installer package name is: " + aVarA.f40180c);
            ExecutorService executorServiceC = ExecutorUtils.c("com.google.firebase.crashlytics.startup");
            com.google.firebase.crashlytics.internal.settings.a aVarL = com.google.firebase.crashlytics.internal.settings.a.l(contextJ, strC, oVar, new mk.b(), aVarA.f40182e, aVarA.f40183f, fVar, mVar);
            aVarL.p(executorServiceC).continueWith(executorServiceC, new a());
            Tasks.call(executorServiceC, new b(crashlyticsCore.r(aVarA, aVarL), crashlyticsCore, aVarL));
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e11) {
            f.f().e("Error retrieving app package info.", e11);
            return null;
        }
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) e.k().i(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f39025a.e();
    }

    public void deleteUnsentReports() {
        this.f39025a.f();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f39025a.g();
    }

    public void log(@NonNull String str) {
        this.f39025a.n(str);
    }

    public void recordException(@NonNull Throwable th2) {
        if (th2 == null) {
            f.f().k("A null value was passed to recordException. Ignoring.");
        } else {
            this.f39025a.o(th2);
        }
    }

    public void sendUnsentReports() {
        this.f39025a.s();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f39025a.t(bool);
    }

    public void setCrashlyticsCollectionEnabled(boolean z11) {
        this.f39025a.t(Boolean.valueOf(z11));
    }

    public void setCustomKey(@NonNull String str, double d11) {
        this.f39025a.u(str, Double.toString(d11));
    }

    public void setCustomKey(@NonNull String str, float f11) {
        this.f39025a.u(str, Float.toString(f11));
    }

    public void setCustomKey(@NonNull String str, int i11) {
        this.f39025a.u(str, Integer.toString(i11));
    }

    public void setCustomKey(@NonNull String str, long j11) {
        this.f39025a.u(str, Long.toString(j11));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.f39025a.u(str, str2);
    }

    public void setCustomKey(@NonNull String str, boolean z11) {
        this.f39025a.u(str, Boolean.toString(z11));
    }

    public void setCustomKeys(@NonNull sj.g gVar) {
        throw null;
    }

    public void setUserId(@NonNull String str) {
        this.f39025a.v(str);
    }
}
