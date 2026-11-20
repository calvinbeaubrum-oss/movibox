package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ImmersionCallback> f41642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f41643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f41644c;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f41645a = new e();
    }

    public e() {
        super(new Handler(Looper.getMainLooper()));
        this.f41644c = Boolean.FALSE;
    }

    public static e b() {
        return b.f41645a;
    }

    public void a(ImmersionCallback immersionCallback) {
        if (immersionCallback == null) {
            return;
        }
        if (this.f41642a == null) {
            this.f41642a = new ArrayList<>();
        }
        if (this.f41642a.contains(immersionCallback)) {
            return;
        }
        this.f41642a.add(immersionCallback);
    }

    public void c(Application application) {
        Uri uriFor;
        this.f41643b = application;
        if (application == null || application.getContentResolver() == null || this.f41644c.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.f41643b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f41644c = Boolean.TRUE;
    }

    public void d(ImmersionCallback immersionCallback) {
        ArrayList<ImmersionCallback> arrayList;
        if (immersionCallback == null || (arrayList = this.f41642a) == null) {
            return;
        }
        arrayList.remove(immersionCallback);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        ArrayList<ImmersionCallback> arrayList;
        super.onChange(z11);
        Application application = this.f41643b;
        if (application == null || application.getContentResolver() == null || (arrayList = this.f41642a) == null || arrayList.isEmpty()) {
            return;
        }
        int i11 = Settings.System.getInt(this.f41643b.getContentResolver(), "navigationbar_is_min", 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i11 == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator<ImmersionCallback> it = this.f41642a.iterator();
        while (it.hasNext()) {
            it.next().onNavigationBarChange(i11 == 0, navigationBarType);
        }
    }
}
