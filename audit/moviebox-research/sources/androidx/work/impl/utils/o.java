package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f13540a;

    public o(@NonNull WorkDatabase workDatabase) {
        this.f13540a = workDatabase;
    }

    public static void d(@NonNull Context context, @NonNull g6.g gVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j11 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j12 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            gVar.A();
            try {
                gVar.J("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j11)});
                gVar.J("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j12)});
                sharedPreferences.edit().clear().apply();
                gVar.I();
            } finally {
                gVar.L();
            }
        }
    }

    public long a() {
        Long longValue = this.f13540a.I().getLongValue("last_cancel_all_time_ms");
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0L;
    }

    public long b() {
        Long longValue = this.f13540a.I().getLongValue("last_force_stop_ms");
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0L;
    }

    public boolean c() {
        Long longValue = this.f13540a.I().getLongValue("reschedule_needed");
        return longValue != null && longValue.longValue() == 1;
    }

    public void e(long j11) {
        this.f13540a.I().a(new s6.d("last_cancel_all_time_ms", Long.valueOf(j11)));
    }

    public void f(long j11) {
        this.f13540a.I().a(new s6.d("last_force_stop_ms", Long.valueOf(j11)));
    }

    public void g(boolean z11) {
        this.f13540a.I().a(new s6.d("reschedule_needed", z11));
    }
}
