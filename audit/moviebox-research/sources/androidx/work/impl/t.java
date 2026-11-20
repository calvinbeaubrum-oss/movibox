package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13484a = androidx.work.j.i("Schedulers");

    @NonNull
    public static s a(@NonNull Context context, @NonNull d0 d0Var) {
        if (Build.VERSION.SDK_INT >= 23) {
            o6.l lVar = new o6.l(context, d0Var);
            androidx.work.impl.utils.n.a(context, SystemJobService.class, true);
            androidx.work.j.e().a(f13484a, "Created SystemJobScheduler and enabled SystemJobService");
            return lVar;
        }
        s sVarC = c(context);
        if (sVarC != null) {
            return sVarC;
        }
        androidx.work.impl.background.systemalarm.g gVar = new androidx.work.impl.background.systemalarm.g(context);
        androidx.work.impl.utils.n.a(context, SystemAlarmService.class, true);
        androidx.work.j.e().a(f13484a, "Created SystemAlarmScheduler");
        return gVar;
    }

    public static void b(@NonNull androidx.work.a aVar, @NonNull WorkDatabase workDatabase, @Nullable List<s> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        s6.v vVarN = workDatabase.N();
        workDatabase.e();
        try {
            List<s6.u> listT = vVarN.t(aVar.h());
            List<s6.u> listO = vVarN.o(200);
            if (listT != null && listT.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<s6.u> it = listT.iterator();
                while (it.hasNext()) {
                    vVarN.r(it.next().f76199a, jCurrentTimeMillis);
                }
            }
            workDatabase.E();
            workDatabase.i();
            if (listT != null && listT.size() > 0) {
                s6.u[] uVarArr = (s6.u[]) listT.toArray(new s6.u[listT.size()]);
                for (s sVar : list) {
                    if (sVar.d()) {
                        sVar.f(uVarArr);
                    }
                }
            }
            if (listO == null || listO.size() <= 0) {
                return;
            }
            s6.u[] uVarArr2 = (s6.u[]) listO.toArray(new s6.u[listO.size()]);
            for (s sVar2 : list) {
                if (!sVar2.d()) {
                    sVar2.f(uVarArr2);
                }
            }
        } catch (Throwable th2) {
            workDatabase.i();
            throw th2;
        }
    }

    @Nullable
    public static s c(@NonNull Context context) {
        try {
            s sVar = (s) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            androidx.work.j.e().a(f13484a, "Created androidx.work.impl.background.gcm.GcmScheduler");
            return sVar;
        } catch (Throwable th2) {
            androidx.work.j.e().b(f13484a, "Unable to create GCM Scheduler", th2);
            return null;
        }
    }
}
