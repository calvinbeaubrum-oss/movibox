package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.d0;
import androidx.work.impl.utils.n;
import androidx.work.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13365a = j.i("ConstrntProxyUpdtRecvr");

    @NonNull
    public static Intent a(@NonNull Context context, boolean z11, boolean z12, boolean z13, boolean z14) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z11).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z12).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z13).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z14);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull final Context context, @Nullable final Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            d0.p(context).v().c(new Runnable() { // from class: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        j.e().a(ConstraintProxyUpdateReceiver.f13365a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                        n.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        n.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        n.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        n.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    } finally {
                        pendingResultGoAsync.finish();
                    }
                }
            });
            return;
        }
        j.e().a(f13365a, "Ignoring unknown action " + action);
    }
}
