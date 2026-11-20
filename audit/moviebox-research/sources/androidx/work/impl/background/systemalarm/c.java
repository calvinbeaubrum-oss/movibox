package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.j;
import java.util.ArrayList;
import java.util.List;
import s6.u;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13387e = j.i("ConstraintsCmdHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SystemAlarmDispatcher f13390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p6.e f13391d;

    public c(@NonNull Context context, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f13388a = context;
        this.f13389b = i11;
        this.f13390c = systemAlarmDispatcher;
        this.f13391d = new p6.e(systemAlarmDispatcher.g().t(), (p6.c) null);
    }

    public void a() {
        List<u> listF = this.f13390c.g().u().N().f();
        ConstraintProxy.a(this.f13388a, listF);
        this.f13391d.a(listF);
        ArrayList<u> arrayList = new ArrayList(listF.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (u uVar : listF) {
            String str = uVar.f76199a;
            if (jCurrentTimeMillis >= uVar.c() && (!uVar.h() || this.f13391d.d(str))) {
                arrayList.add(uVar);
            }
        }
        for (u uVar2 : arrayList) {
            String str2 = uVar2.f76199a;
            Intent intentB = b.b(this.f13388a, x.a(uVar2));
            j.e().a(f13387e, "Creating a delay_met command for workSpec with id (" + str2 + ")");
            this.f13390c.f().a().execute(new SystemAlarmDispatcher.AddRunnable(this.f13390c, intentB, this.f13389b));
        }
        this.f13391d.reset();
    }
}
