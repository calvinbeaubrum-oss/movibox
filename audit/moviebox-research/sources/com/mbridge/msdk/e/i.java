package com.mbridge.msdk.e;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f43873a = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_count INTEGER)";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f43874b = "DROP TABLE IF EXISTS %s";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f43875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f43878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f43879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f43880h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f43881i = false;

    public i(e eVar) {
        this.f43875c = eVar;
        this.f43878f = eVar.e();
    }

    public final void a(int i11) {
        this.f43876d = i11;
    }

    public final void a(long j11) {
        this.f43879g = j11;
    }

    public final void a(boolean z11) {
        this.f43880h = z11;
    }

    public final boolean a() {
        return this.f43880h;
    }

    public final void b(int i11) {
        this.f43877e = i11;
    }

    public final void b(boolean z11) {
        this.f43881i = z11;
    }

    public final boolean b() {
        return this.f43881i;
    }

    public final e c() {
        return this.f43875c;
    }

    public final int d() {
        return this.f43876d;
    }

    public final int e() {
        return this.f43877e;
    }

    public final String f() {
        return this.f43878f;
    }

    public final long g() {
        return this.f43879g;
    }
}
