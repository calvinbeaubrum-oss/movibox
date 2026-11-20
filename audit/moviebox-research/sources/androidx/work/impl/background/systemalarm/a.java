package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.work.impl.WorkDatabase;
import androidx.work.j;
import org.mvel2.ast.ASTNode;
import s6.i;
import s6.l;
import s6.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13381a = j.i("Alarms");

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class C0126a {
        public static void a(AlarmManager alarmManager, int i11, long j11, PendingIntent pendingIntent) {
            alarmManager.setExact(i11, j11, pendingIntent);
        }
    }

    public static void a(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull m mVar) {
        s6.j jVarK = workDatabase.K();
        i iVarE = jVarK.e(mVar);
        if (iVarE != null) {
            b(context, mVar, iVarE.f76172c);
            j.e().a(f13381a, "Removing SystemIdInfo for workSpecId (" + mVar + ")");
            jVarK.a(mVar);
        }
    }

    public static void b(@NonNull Context context, @NonNull m mVar, int i11) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i11, b.b(context, mVar), Build.VERSION.SDK_INT >= 23 ? 603979776 : ASTNode.DISCARD);
        if (service == null || alarmManager == null) {
            return;
        }
        j.e().a(f13381a, "Cancelling existing alarm with (workSpecId, systemId) (" + mVar + ", " + i11 + ")");
        alarmManager.cancel(service);
    }

    public static void c(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull m mVar, long j11) {
        s6.j jVarK = workDatabase.K();
        i iVarE = jVarK.e(mVar);
        if (iVarE != null) {
            b(context, mVar, iVarE.f76172c);
            d(context, mVar, iVarE.f76172c, j11);
        } else {
            int iC = new androidx.work.impl.utils.i(workDatabase).c();
            jVarK.d(l.a(mVar, iC));
            d(context, mVar, iC, j11);
        }
    }

    public static void d(@NonNull Context context, @NonNull m mVar, int i11, long j11) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i11, b.b(context, mVar), Build.VERSION.SDK_INT >= 23 ? 201326592 : ASTNode.NOJIT);
        if (alarmManager != null) {
            C0126a.a(alarmManager, 0, j11, service);
        }
    }
}
