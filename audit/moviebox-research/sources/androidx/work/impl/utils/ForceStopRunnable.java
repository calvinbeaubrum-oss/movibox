package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d0;
import androidx.work.impl.z;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.mvel2.ast.ASTNode;
import s6.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = androidx.work.j.i("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private final o mPreferenceUtils;
    private int mRetryCount = 0;
    private final d0 mWorkManager;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f13486a = androidx.work.j.i("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, @Nullable Intent intent) {
            if (intent == null || !ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                return;
            }
            androidx.work.j.e().j(f13486a, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.setAlarm(context);
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull d0 d0Var) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = d0Var;
        this.mPreferenceUtils = d0Var.q();
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i11) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i11);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = getPendingIntent(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : ASTNode.NOJIT);
        long jCurrentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntent);
        }
    }

    public boolean cleanUp() {
        boolean zI = Build.VERSION.SDK_INT >= 23 ? o6.l.i(this.mContext, this.mWorkManager) : false;
        WorkDatabase workDatabaseU = this.mWorkManager.u();
        v vVarN = workDatabaseU.N();
        s6.r rVarM = workDatabaseU.M();
        workDatabaseU.e();
        try {
            List<s6.u> listW = vVarN.w();
            boolean z11 = (listW == null || listW.isEmpty()) ? false : true;
            if (z11) {
                for (s6.u uVar : listW) {
                    vVarN.u(WorkInfo.State.ENQUEUED, uVar.f76199a);
                    vVarN.r(uVar.f76199a, -1L);
                }
            }
            rVarM.c();
            workDatabaseU.E();
            workDatabaseU.i();
            return z11 || zI;
        } catch (Throwable th2) {
            workDatabaseU.i();
            throw th2;
        }
    }

    public void forceStopRunnable() {
        boolean zCleanUp = cleanUp();
        if (shouldRescheduleWorkers()) {
            androidx.work.j.e().a(TAG, "Rescheduling Workers.");
            this.mWorkManager.y();
            this.mWorkManager.q().g(false);
        } else if (isForceStopped()) {
            androidx.work.j.e().a(TAG, "Application was force-stopped, rescheduling.");
            this.mWorkManager.y();
            this.mPreferenceUtils.f(System.currentTimeMillis());
        } else if (zCleanUp) {
            androidx.work.j.e().a(TAG, "Found unfinished work, scheduling it.");
            androidx.work.impl.t.b(this.mWorkManager.n(), this.mWorkManager.u(), this.mWorkManager.s());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        try {
            int i11 = Build.VERSION.SDK_INT;
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i11 >= 31 ? 570425344 : ASTNode.DISCARD);
            if (i11 >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long jB = this.mPreferenceUtils.b();
                    for (int i12 = 0; i12 < historicalProcessExitReasons.size(); i12++) {
                        ApplicationExitInfo applicationExitInfoA = d.a(historicalProcessExitReasons.get(i12));
                        if (applicationExitInfoA.getReason() == 10 && applicationExitInfoA.getTimestamp() >= jB) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntent == null) {
                setAlarm(this.mContext);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e11) {
            e = e11;
            androidx.work.j.e().l(TAG, "Ignoring exception", e);
            return true;
        } catch (SecurityException e12) {
            e = e12;
            androidx.work.j.e().l(TAG, "Ignoring exception", e);
            return true;
        }
    }

    public boolean multiProcessChecks() {
        androidx.work.a aVarN = this.mWorkManager.n();
        if (TextUtils.isEmpty(aVarN.c())) {
            androidx.work.j.e().a(TAG, "The default process name was not specified.");
            return true;
        }
        boolean zB = p.b(this.mContext, aVarN);
        androidx.work.j.e().a(TAG, "Is default app process = " + zB);
        return zB;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i11;
        try {
            if (!multiProcessChecks()) {
                this.mWorkManager.x();
                return;
            }
            while (true) {
                try {
                    z.d(this.mContext);
                    androidx.work.j.e().a(TAG, "Performing cleanup operations.");
                    try {
                        forceStopRunnable();
                        break;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e11) {
                        i11 = this.mRetryCount + 1;
                        this.mRetryCount = i11;
                        if (i11 >= 3) {
                            androidx.work.j jVarE = androidx.work.j.e();
                            String str = TAG;
                            jVarE.d(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e11);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e11);
                            androidx.core.util.a<Throwable> aVarE = this.mWorkManager.n().e();
                            if (aVarE == null) {
                                throw illegalStateException;
                            }
                            androidx.work.j.e().b(str, "Routing exception to the specified exception handler", illegalStateException);
                            aVarE.accept(illegalStateException);
                            break;
                        }
                        long j11 = ((long) i11) * BACKOFF_DURATION_MS;
                        androidx.work.j.e().b(TAG, "Retrying after " + j11, e11);
                        sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                    }
                    long j12 = ((long) i11) * BACKOFF_DURATION_MS;
                    androidx.work.j.e().b(TAG, "Retrying after " + j12, e11);
                    sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                } catch (SQLiteException e12) {
                    androidx.work.j.e().c(TAG, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e12);
                    androidx.core.util.a<Throwable> aVarE2 = this.mWorkManager.n().e();
                    if (aVarE2 == null) {
                        throw illegalStateException2;
                    }
                    aVarE2.accept(illegalStateException2);
                }
            }
            this.mWorkManager.x();
        } catch (Throwable th2) {
            this.mWorkManager.x();
            throw th2;
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.q().c();
    }

    public void sleep(long j11) {
        try {
            Thread.sleep(j11);
        } catch (InterruptedException unused) {
        }
    }
}
