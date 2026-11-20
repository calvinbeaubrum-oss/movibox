package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.v;
import androidx.work.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s6.m;
import s6.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements androidx.work.impl.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13382f = j.i("CommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<m, f> f13384b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13385c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f13386d;

    public b(@NonNull Context context, @NonNull v vVar) {
        this.f13383a = context;
        this.f13386d = vVar;
    }

    public static Intent a(@NonNull Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        return s(intent, mVar);
    }

    public static Intent d(@NonNull Context context, @NonNull m mVar, boolean z11) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z11);
        return s(intent, mVar);
    }

    public static Intent e(@NonNull Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    public static Intent f(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        return s(intent, mVar);
    }

    public static Intent g(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent h(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        return s(intent, mVar);
    }

    public static boolean o(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public static m r(@NonNull Intent intent) {
        return new m(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static Intent s(@NonNull Intent intent, @NonNull m mVar) {
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_WORKSPEC_GENERATION", mVar.a());
        return intent;
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c */
    public void l(@NonNull m mVar, boolean z11) {
        synchronized (this.f13385c) {
            try {
                f fVarRemove = this.f13384b.remove(mVar);
                this.f13386d.b(mVar);
                if (fVarRemove != null) {
                    fVarRemove.h(z11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        j.e().a(f13382f, "Handling constraints changed " + intent);
        new c(this.f13383a, i11, systemAlarmDispatcher).a();
    }

    public final void j(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        synchronized (this.f13385c) {
            try {
                m mVarR = r(intent);
                j jVarE = j.e();
                String str = f13382f;
                jVarE.a(str, "Handing delay met for " + mVarR);
                if (this.f13384b.containsKey(mVarR)) {
                    j.e().a(str, "WorkSpec " + mVarR + " is is already being handled for ACTION_DELAY_MET");
                } else {
                    f fVar = new f(this.f13383a, i11, systemAlarmDispatcher, this.f13386d.d(mVarR));
                    this.f13384b.put(mVarR, fVar);
                    fVar.g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k(@NonNull Intent intent, int i11) {
        m mVarR = r(intent);
        boolean z11 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        j.e().a(f13382f, "Handling onExecutionCompleted " + intent + ", " + i11);
        l(mVarR, z11);
    }

    public final void l(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        j.e().a(f13382f, "Handling reschedule " + intent + ", " + i11);
        systemAlarmDispatcher.g().y();
    }

    public final void m(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        m mVarR = r(intent);
        j jVarE = j.e();
        String str = f13382f;
        jVarE.a(str, "Handling schedule work for " + mVarR);
        WorkDatabase workDatabaseU = systemAlarmDispatcher.g().u();
        workDatabaseU.e();
        try {
            u uVarJ = workDatabaseU.N().j(mVarR.b());
            if (uVarJ == null) {
                j.e().k(str, "Skipping scheduling " + mVarR + " because it's no longer in the DB");
                return;
            }
            if (uVarJ.f76200b.isFinished()) {
                j.e().k(str, "Skipping scheduling " + mVarR + "because it is finished.");
                return;
            }
            long jC = uVarJ.c();
            if (uVarJ.h()) {
                j.e().a(str, "Opportunistically setting an alarm for " + mVarR + "at " + jC);
                a.c(this.f13383a, workDatabaseU, mVarR, jC);
                systemAlarmDispatcher.f().a().execute(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.f13383a), i11));
            } else {
                j.e().a(str, "Setting up Alarms for " + mVarR + "at " + jC);
                a.c(this.f13383a, workDatabaseU, mVarR, jC);
            }
            workDatabaseU.E();
        } finally {
            workDatabaseU.i();
        }
    }

    public final void n(@NonNull Intent intent, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        List<androidx.work.impl.u> listC;
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        if (extras.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i11 = extras.getInt("KEY_WORKSPEC_GENERATION");
            listC = new ArrayList<>(1);
            androidx.work.impl.u uVarB = this.f13386d.b(new m(string, i11));
            if (uVarB != null) {
                listC.add(uVarB);
            }
        } else {
            listC = this.f13386d.c(string);
        }
        for (androidx.work.impl.u uVar : listC) {
            j.e().a(f13382f, "Handing stopWork work for " + string);
            systemAlarmDispatcher.g().D(uVar);
            a.a(this.f13383a, systemAlarmDispatcher.g().u(), uVar.a());
            systemAlarmDispatcher.l(uVar.a(), false);
        }
    }

    public boolean p() {
        boolean z11;
        synchronized (this.f13385c) {
            z11 = !this.f13384b.isEmpty();
        }
        return z11;
    }

    public void q(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            i(intent, i11, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            l(intent, i11, systemAlarmDispatcher);
            return;
        }
        if (!o(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            j.e().c(f13382f, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            m(intent, i11, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            j(intent, i11, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            n(intent, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            k(intent, i11);
            return;
        }
        j.e().k(f13382f, "Ignoring intent " + intent);
    }
}
