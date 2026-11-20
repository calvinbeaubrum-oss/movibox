package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.util.Date;
import yl.g;
import yl.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Date f41094d = new Date(-1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Date f41095e = new Date(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f41096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f41097b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f41098c = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f41100b;

        public a(int i11, Date date) {
            this.f41099a = i11;
            this.f41100b = date;
        }

        public Date a() {
            return this.f41100b;
        }

        public int b() {
            return this.f41099a;
        }
    }

    public c(SharedPreferences sharedPreferences) {
        this.f41096a = sharedPreferences;
    }

    public a a() {
        a aVar;
        synchronized (this.f41098c) {
            aVar = new a(this.f41096a.getInt("num_failed_fetches", 0), new Date(this.f41096a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return aVar;
    }

    public long b() {
        return this.f41096a.getLong("fetch_timeout_in_seconds", 60L);
    }

    public g c() {
        d dVarA;
        synchronized (this.f41097b) {
            long j11 = this.f41096a.getLong("last_fetch_time_in_millis", -1L);
            int i11 = this.f41096a.getInt("last_fetch_status", 0);
            dVarA = d.b().c(i11).d(j11).b(new h.b().d(this.f41096a.getLong("fetch_timeout_in_seconds", 60L)).e(this.f41096a.getLong("minimum_fetch_interval_in_seconds", b.f41079j)).c()).a();
        }
        return dVarA;
    }

    @Nullable
    public String d() {
        return this.f41096a.getString("last_fetch_etag", null);
    }

    public Date e() {
        return new Date(this.f41096a.getLong("last_fetch_time_in_millis", -1L));
    }

    public long f() {
        return this.f41096a.getLong("minimum_fetch_interval_in_seconds", b.f41079j);
    }

    public void g() {
        h(0, f41095e);
    }

    public void h(int i11, Date date) {
        synchronized (this.f41098c) {
            this.f41096a.edit().putInt("num_failed_fetches", i11).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void i(h hVar) {
        synchronized (this.f41097b) {
            this.f41096a.edit().putLong("fetch_timeout_in_seconds", hVar.a()).putLong("minimum_fetch_interval_in_seconds", hVar.b()).commit();
        }
    }

    public void j(String str) {
        synchronized (this.f41097b) {
            this.f41096a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    public void k() {
        synchronized (this.f41097b) {
            this.f41096a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public void l(Date date) {
        synchronized (this.f41097b) {
            this.f41096a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    public void m() {
        synchronized (this.f41097b) {
            this.f41096a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
