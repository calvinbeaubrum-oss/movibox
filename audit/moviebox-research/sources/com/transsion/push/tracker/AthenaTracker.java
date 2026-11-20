package com.transsion.push.tracker;

import android.os.Bundle;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushManager;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.utils.PushLogUtils;
import ws.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
class AthenaTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AthenaTracker f57011a;

    public static AthenaTracker getInstance() {
        if (f57011a == null) {
            f57011a = new AthenaTracker();
        }
        return f57011a;
    }

    public final TrackData a(Bundle bundle) {
        TrackData trackData = new TrackData();
        if (bundle == null) {
            return trackData;
        }
        for (String str : bundle.keySet()) {
            trackData.add(str, bundle.get(str) + "");
        }
        return trackData;
    }

    public void b() {
        if (e()) {
            AthenaAnalytics.E(a.a().getApplicationContext(), MsgStyle.SOURCE_PUSH, 1041, false);
        }
    }

    public final void c(Tracker.KEY key, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb2.append(str);
            sb2.append(":");
            sb2.append(bundle.get(str));
            sb2.append(", ");
        }
        PushLogUtils.LOG.g("Athena track event:" + key.event + ", tid:" + key.tid + ", " + sb2.toString());
    }

    public void d(Tracker.KEY key, Bundle bundle) {
        if (e()) {
            if (!PushManager.getInstance().getIsSdkInitFinished()) {
                AthenaAnalytics.E(a.a().getApplicationContext(), MsgStyle.SOURCE_PUSH, 1041, false);
            }
            try {
                c(key, bundle);
                AthenaAnalytics.z(key.tid).Q(key.event, a(bundle), key.tid);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean e() {
        try {
            AthenaAnalytics.f fVar = AthenaAnalytics.f51922e;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
