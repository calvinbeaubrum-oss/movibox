package com.transsion.push.tracker;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FirebaseTracker f57012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ITracker f57013b;

    public static FirebaseTracker getInstance() {
        if (f57012a == null) {
            f57012a = new FirebaseTracker();
        }
        return f57012a;
    }

    public void a(Tracker.KEY key, Bundle bundle) {
        ITracker iTracker;
        if (bundle == null || (iTracker = f57013b) == null) {
            return;
        }
        iTracker.track(key, bundle);
    }

    public void setListener(ITracker iTracker) {
        f57013b = iTracker;
    }
}
