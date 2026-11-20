package nj;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import jj.e;
import oj.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements nj.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile nj.a f72012c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final AppMeasurementSdk f72013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final Map f72014b;

    /* JADX INFO: compiled from: source.java */
    public class a implements nj.a.InterfaceC0771a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f72015a;

        public a(String str) {
            this.f72015a = str;
        }
    }

    public b(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f72013a = appMeasurementSdk;
        this.f72014b = new ConcurrentHashMap();
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static nj.a h(@NonNull e eVar, @NonNull Context context, @NonNull yk.d dVar) {
        Preconditions.checkNotNull(eVar);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f72012c == null) {
            synchronized (b.class) {
                try {
                    if (f72012c == null) {
                        Bundle bundle = new Bundle(1);
                        if (eVar.t()) {
                            dVar.b(jj.b.class, new Executor() { // from class: nj.c
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new yk.b() { // from class: nj.d
                                @Override // yk.b
                                public final void a(yk.a aVar) {
                                    b.i(aVar);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", eVar.s());
                        }
                        f72012c = new b(zzef.zzg(context, null, null, null, bundle).zzd());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f72012c;
    }

    public static /* synthetic */ void i(yk.a aVar) {
        boolean z11 = ((jj.b) aVar.a()).f68008a;
        synchronized (b.class) {
            ((b) Preconditions.checkNotNull(f72012c)).f72013a.zza(z11);
        }
    }

    @Override // nj.a
    @KeepForSdk
    public void a(@NonNull nj.a.c cVar) {
        if (oj.b.f(cVar)) {
            this.f72013a.setConditionalUserProperty(oj.b.a(cVar));
        }
    }

    @Override // nj.a
    @KeepForSdk
    public void b(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (oj.b.i(str) && oj.b.g(str2, bundle) && oj.b.e(str, str2, bundle)) {
            oj.b.d(str, str2, bundle);
            this.f72013a.logEvent(str, str2, bundle);
        }
    }

    @Override // nj.a
    @NonNull
    @KeepForSdk
    public nj.a.InterfaceC0771a c(@NonNull String str, @NonNull nj.a.b bVar) {
        Object fVar;
        Preconditions.checkNotNull(bVar);
        if (!oj.b.i(str) || j(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.f72013a;
        if (AppMeasurement.FIAM_ORIGIN.equals(str)) {
            fVar = new oj.d(appMeasurementSdk, bVar);
        } else {
            fVar = "clx".equals(str) ? new f(appMeasurementSdk, bVar) : null;
        }
        if (fVar == null) {
            return null;
        }
        this.f72014b.put(str, fVar);
        return new a(str);
    }

    @Override // nj.a
    @KeepForSdk
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 == null || oj.b.g(str2, bundle)) {
            this.f72013a.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // nj.a
    @KeepForSdk
    public void d(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (oj.b.i(str) && oj.b.j(str, str2)) {
            this.f72013a.setUserProperty(str, str2, obj);
        }
    }

    @Override // nj.a
    @NonNull
    @KeepForSdk
    public Map<String, Object> e(boolean z11) {
        return this.f72013a.getUserProperties(null, null, z11);
    }

    @Override // nj.a
    @KeepForSdk
    public int f(@NonNull String str) {
        return this.f72013a.getMaxUserProperties(str);
    }

    @Override // nj.a
    @NonNull
    @KeepForSdk
    public List<nj.a.c> g(@NonNull String str, @NonNull String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it = this.f72013a.getConditionalUserProperties(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(oj.b.b(it.next()));
        }
        return arrayList;
    }

    public final boolean j(@NonNull String str) {
        return (str.isEmpty() || !this.f72014b.containsKey(str) || this.f72014b.get(str) == null) ? false : true;
    }
}
