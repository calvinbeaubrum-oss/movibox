package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f40918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40920c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f40922e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<String> f40921d = new ArrayDeque<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f40923f = false;

    public s0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f40918a = sharedPreferences;
        this.f40919b = str;
        this.f40920c = str2;
        this.f40922e = executor;
    }

    public static s0 c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        s0 s0Var = new s0(sharedPreferences, str, str2, executor);
        s0Var.d();
        return s0Var;
    }

    public final boolean b(boolean z11) {
        if (z11 && !this.f40923f) {
            i();
        }
        return z11;
    }

    public final void d() {
        synchronized (this.f40921d) {
            try {
                this.f40921d.clear();
                String string = this.f40918a.getString(this.f40919b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f40920c)) {
                    String[] strArrSplit = string.split(this.f40920c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f40921d.add(str);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public String e() {
        String strPeek;
        synchronized (this.f40921d) {
            strPeek = this.f40921d.peek();
        }
        return strPeek;
    }

    public boolean f(@Nullable Object obj) {
        boolean zB;
        synchronized (this.f40921d) {
            zB = b(this.f40921d.remove(obj));
        }
        return zB;
    }

    @NonNull
    public String g() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f40921d.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(this.f40920c);
        }
        return sb2.toString();
    }

    public final void h() {
        synchronized (this.f40921d) {
            this.f40918a.edit().putString(this.f40919b, g()).commit();
        }
    }

    public final void i() {
        this.f40922e.execute(new Runnable() { // from class: com.google.firebase.messaging.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f40885a.h();
            }
        });
    }
}
