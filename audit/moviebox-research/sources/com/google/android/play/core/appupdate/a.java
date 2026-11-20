package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f38018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Integer f38022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f38023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f38024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f38025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f38026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f38027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final PendingIntent f38028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final PendingIntent f38029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final PendingIntent f38030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final PendingIntent f38031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f38032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f38033p = false;

    public a(@NonNull String str, int i11, int i12, int i13, @Nullable Integer num, int i14, long j11, long j12, long j13, long j14, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        this.f38018a = str;
        this.f38019b = i11;
        this.f38020c = i12;
        this.f38021d = i13;
        this.f38022e = num;
        this.f38023f = i14;
        this.f38024g = j11;
        this.f38025h = j12;
        this.f38026i = j13;
        this.f38027j = j14;
        this.f38028k = pendingIntent;
        this.f38029l = pendingIntent2;
        this.f38030m = pendingIntent3;
        this.f38031n = pendingIntent4;
        this.f38032o = map;
    }

    public static a f(@NonNull String str, int i11, int i12, int i13, @Nullable Integer num, int i14, long j11, long j12, long j13, long j14, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        return new a(str, i11, i12, i13, num, i14, j11, j12, j13, j14, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    public int a() {
        return this.f38021d;
    }

    public boolean b(int i11) {
        return e(d.c(i11)) != null;
    }

    public boolean c(@NonNull d dVar) {
        return e(dVar) != null;
    }

    public int d() {
        return this.f38020c;
    }

    @Nullable
    public final PendingIntent e(d dVar) {
        if (dVar.b() == 0) {
            PendingIntent pendingIntent = this.f38029l;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (i(dVar)) {
                return this.f38031n;
            }
            return null;
        }
        if (dVar.b() == 1) {
            PendingIntent pendingIntent2 = this.f38028k;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (i(dVar)) {
                return this.f38030m;
            }
        }
        return null;
    }

    public final void g() {
        this.f38033p = true;
    }

    public final boolean h() {
        return this.f38033p;
    }

    public final boolean i(d dVar) {
        return dVar.a() && this.f38026i <= this.f38027j;
    }
}
