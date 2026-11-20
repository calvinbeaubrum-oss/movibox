package o6;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import s6.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 23)
@SuppressLint({"ClassVerificationFailure"})
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f72374b = androidx.work.j.i("SystemJobInfoConverter");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f72375a;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f72376a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f72376a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72376a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72376a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72376a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f72376a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(@NonNull Context context) {
        this.f72375a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    @RequiresApi(24)
    public static JobInfo.TriggerContentUri b(androidx.work.b.c cVar) {
        boolean zB = cVar.b();
        i.a();
        return h.a(cVar.a(), zB ? 1 : 0);
    }

    public static int c(NetworkType networkType) {
        int i11 = a.f72376a[networkType.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 3) {
            return 2;
        }
        if (i11 != 4) {
            if (i11 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        androidx.work.j.e().a(f72374b, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    public static void d(@NonNull JobInfo.Builder builder, @NonNull NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    public JobInfo a(u uVar, int i11) {
        androidx.work.b bVar = uVar.f76208j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", uVar.f76199a);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", uVar.f());
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", uVar.j());
        JobInfo.Builder extras = new JobInfo.Builder(i11, this.f72375a).setRequiresCharging(bVar.g()).setRequiresDeviceIdle(bVar.h()).setExtras(persistableBundle);
        d(extras, bVar.d());
        if (!bVar.h()) {
            extras.setBackoffCriteria(uVar.f76211m, uVar.f76210l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(uVar.c() - System.currentTimeMillis(), 0L);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!uVar.f76215q) {
            extras.setImportantWhileForeground(true);
        }
        if (i12 >= 24 && bVar.e()) {
            Iterator<androidx.work.b.c> it = bVar.c().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b(it.next()));
            }
            extras.setTriggerContentUpdateDelay(bVar.b());
            extras.setTriggerContentMaxDelay(bVar.a());
        }
        extras.setPersisted(false);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26) {
            extras.setRequiresBatteryNotLow(bVar.f());
            extras.setRequiresStorageNotLow(bVar.i());
        }
        boolean z11 = uVar.f76209k > 0;
        boolean z12 = jMax > 0;
        if (i13 >= 31 && uVar.f76215q && !z11 && !z12) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
