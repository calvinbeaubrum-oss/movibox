package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.utils.s;
import androidx.work.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13378d = j.i("SystemAlarmService");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SystemAlarmDispatcher f13379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13380c;

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.a
    public void b() {
        this.f13380c = true;
        j.e().a(f13378d, "All commands completed in dispatcher");
        s.a();
        stopSelf();
    }

    public final void e() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f13379b = systemAlarmDispatcher;
        systemAlarmDispatcher.l(this);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f13380c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f13380c = true;
        this.f13379b.j();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        super.onStartCommand(intent, i11, i12);
        if (this.f13380c) {
            j.e().f(f13378d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            this.f13379b.j();
            e();
            this.f13380c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f13379b.a(intent, i12);
        return 3;
    }
}
