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
public final class s extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<w> f41662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f41663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41664c;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f41665a = new s();
    }

    public s() {
        super(new Handler(Looper.getMainLooper()));
        this.f41664c = false;
    }

    public static s b() {
        return b.f41665a;
    }

    public void a(w wVar) {
        if (wVar == null) {
            return;
        }
        if (this.f41662a == null) {
            this.f41662a = new ArrayList<>();
        }
        if (this.f41662a.contains(wVar)) {
            return;
        }
        this.f41662a.add(wVar);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    public void c(Application application) {
        Uri uriFor;
        Uri uriFor2;
        this.f41663b = application;
        if (application == null || application.getContentResolver() == null || this.f41664c) {
            return;
        }
        Uri uriFor3 = null;
        if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
            if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
                uriFor2 = null;
                uriFor3 = Settings.Global.getUriFor("hide_gesture_line");
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                uriFor = Settings.Secure.getUriFor("navigation_gesture_on");
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                uriFor = Settings.Secure.getUriFor("hide_navigationbar_enable");
            } else if (!OSUtils.isSamsung()) {
                uriFor = Settings.Secure.getUriFor("navigation_mode");
            } else if (Settings.Global.getInt(this.f41663b.getContentResolver(), "navigationbar_hide_bar_enabled", -1) == -1) {
                uriFor = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
                uriFor3 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
                uriFor2 = Settings.Global.getUriFor("navigation_bar_gesture_hint");
            } else {
                uriFor = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
            }
            if (uriFor != null) {
                this.f41663b.getContentResolver().registerContentObserver(uriFor, true, this);
                this.f41664c = true;
            }
            if (uriFor3 != null) {
                this.f41663b.getContentResolver().registerContentObserver(uriFor3, true, this);
            }
            if (uriFor2 != null) {
                this.f41663b.getContentResolver().registerContentObserver(uriFor2, true, this);
            }
        }
        uriFor = !OSUtils.isEMUI3_x() ? Settings.Global.getUriFor("navigationbar_is_min") : Settings.System.getUriFor("navigationbar_is_min");
        uriFor2 = null;
        if (uriFor != null) {
            this.f41663b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f41664c = true;
        }
        if (uriFor3 != null) {
            this.f41663b.getContentResolver().registerContentObserver(uriFor3, true, this);
        }
        if (uriFor2 != null) {
            this.f41663b.getContentResolver().registerContentObserver(uriFor2, true, this);
        }
    }

    public void d(w wVar) {
        ArrayList<w> arrayList;
        if (wVar == null || (arrayList = this.f41662a) == null) {
            return;
        }
        arrayList.remove(wVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        ArrayList<w> arrayList = this.f41662a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g.a aVarA = g.a(this.f41663b);
        boolean z12 = true;
        if (aVarA.f41657a && (!aVarA.f41658b || com.gyf.immersionbar.a.f(this.f41663b) <= 0)) {
            z12 = false;
        }
        Iterator<w> it = this.f41662a.iterator();
        while (it.hasNext()) {
            it.next().onNavigationBarChange(z12, aVarA.f41659c);
        }
    }
}
