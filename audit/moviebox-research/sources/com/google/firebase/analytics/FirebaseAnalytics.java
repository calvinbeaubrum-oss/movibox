package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import mj.a;
import mj.b;
import mj.c;
import mj.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile FirebaseAnalytics f38963c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzef f38964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f38965b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public enum ConsentStatus {
        GRANTED,
        DENIED
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes5.dex */
    public enum ConsentType {
        AD_STORAGE,
        ANALYTICS_STORAGE
    }

    public FirebaseAnalytics(zzef zzefVar) {
        Preconditions.checkNotNull(zzefVar);
        this.f38964a = zzefVar;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f38963c == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f38963c == null) {
                        f38963c = new FirebaseAnalytics(zzef.zzg(context, null, null, null, null));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f38963c;
    }

    @Nullable
    @Keep
    public static zzhy getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        zzef zzefVarZzg = zzef.zzg(context, null, null, null, bundle);
        if (zzefVarZzg == null) {
            return null;
        }
        return new d(zzefVarZzg);
    }

    public final ExecutorService b() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            try {
                if (this.f38965b == null) {
                    this.f38965b = new a(this, 0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.f38965b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return executorService;
    }

    @NonNull
    public Task<String> getAppInstanceId() {
        try {
            return Tasks.call(b(), new b(this));
        } catch (RuntimeException e11) {
            this.f38964a.zzB(5, "Failed to schedule task for getAppInstanceId", null, null, null);
            return Tasks.forException(e11);
        }
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(com.google.firebase.installations.a.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            throw new IllegalStateException(e11);
        } catch (ExecutionException e12) {
            throw new IllegalStateException(e12.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @NonNull
    public Task<Long> getSessionId() {
        try {
            return Tasks.call(b(), new c(this));
        } catch (RuntimeException e11) {
            this.f38964a.zzB(5, "Failed to schedule task for getSessionId", null, null, null);
            return Tasks.forException(e11);
        }
    }

    public void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        this.f38964a.zzy(str, bundle);
    }

    public void resetAnalyticsData() {
        this.f38964a.zzD();
    }

    public void setAnalyticsCollectionEnabled(boolean z11) {
        this.f38964a.zzL(Boolean.valueOf(z11));
    }

    public void setConsent(@NonNull Map<ConsentType, ConsentStatus> map) {
        Bundle bundle = new Bundle();
        ConsentStatus consentStatus = map.get(ConsentType.AD_STORAGE);
        if (consentStatus != null) {
            int iOrdinal = consentStatus.ordinal();
            if (iOrdinal == 0) {
                bundle.putString("ad_storage", "granted");
            } else if (iOrdinal == 1) {
                bundle.putString("ad_storage", "denied");
            }
        }
        ConsentStatus consentStatus2 = map.get(ConsentType.ANALYTICS_STORAGE);
        if (consentStatus2 != null) {
            int iOrdinal2 = consentStatus2.ordinal();
            if (iOrdinal2 == 0) {
                bundle.putString("analytics_storage", "granted");
            } else if (iOrdinal2 == 1) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        this.f38964a.zzG(bundle);
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(@NonNull Activity activity, @Nullable String str, @Nullable String str2) {
        this.f38964a.zzH(activity, str, str2);
    }

    public void setDefaultEventParameters(@Nullable Bundle bundle) {
        this.f38964a.zzJ(bundle);
    }

    public void setSessionTimeoutDuration(long j11) {
        this.f38964a.zzM(j11);
    }

    public void setUserId(@Nullable String str) {
        this.f38964a.zzN(str);
    }

    public void setUserProperty(@NonNull String str, @Nullable String str2) {
        this.f38964a.zzO(null, str, str2, false);
    }
}
