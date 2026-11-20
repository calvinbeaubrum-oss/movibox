package com.pgl.ssdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i0 f48780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f48781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Integer> f48782c = new ArrayList();

    private i0(Context context) {
        this.f48781b = null;
        this.f48781b = context;
    }

    public static i0 a(Context context) {
        if (f48780a == null) {
            synchronized (i0.class) {
                try {
                    if (f48780a == null) {
                        f48780a = new i0(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48780a;
    }

    public void a() {
        int iF = f();
        if (iF == -1) {
            return;
        }
        this.f48782c.add(Integer.valueOf(iF));
        try {
            int size = this.f48782c.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f48782c.subList(size - 10, size));
                this.f48782c.clear();
                this.f48782c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public int b() {
        Intent intentRegisterReceiver = this.f48781b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return 0;
        }
        return intentRegisterReceiver.getIntExtra("plugged", 0);
    }

    public int c() {
        Intent intentRegisterReceiver = this.f48781b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return 0;
        }
        return Math.round(((intentRegisterReceiver.getIntExtra("level", 0) / intentRegisterReceiver.getIntExtra("scale", 0)) * 100.0f) * 10.0f) / 10;
    }

    public synchronized String d() {
        if (this.f48782c.size() <= 0) {
            return "-1";
        }
        List<Integer> list = this.f48782c;
        return String.valueOf(list.get(list.size() - 1).intValue() % 10000);
    }

    public synchronized String e() {
        return new JSONArray((Collection) this.f48782c).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public int f() {
        int iC;
        int iB = 0;
        try {
            synchronized (this) {
                iB = b();
                iC = c();
            }
            return (iB * 10000) + iC;
        } catch (Exception unused) {
            return iB * 10000;
        }
    }
}
