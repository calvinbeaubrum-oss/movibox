package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.s;
import androidx.work.j;
import s6.u;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13407b = j.i("SystemAlarmScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13408a;

    public g(@NonNull Context context) {
        this.f13408a = context.getApplicationContext();
    }

    @Override // androidx.work.impl.s
    public void a(@NonNull String str) {
        this.f13408a.startService(b.g(this.f13408a, str));
    }

    public final void b(@NonNull u uVar) {
        j.e().a(f13407b, "Scheduling work with workSpecId " + uVar.f76199a);
        this.f13408a.startService(b.f(this.f13408a, x.a(uVar)));
    }

    @Override // androidx.work.impl.s
    public boolean d() {
        return true;
    }

    @Override // androidx.work.impl.s
    public void f(@NonNull u... uVarArr) {
        for (u uVar : uVarArr) {
            b(uVar);
        }
    }
}
