package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43088a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f43089b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashSet<String> f43092e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f43093f = System.currentTimeMillis();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CampaignEx f43094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f43095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f43099l;

    public b(String str, String str2) {
        this.f43090c = str;
        b(str2);
    }

    public final void a(int i11) {
        this.f43099l = i11;
    }

    public final void a(CampaignEx campaignEx) {
        this.f43094g = campaignEx;
    }

    public final void a(String str) {
        this.f43095h = str;
    }

    public final void a(boolean z11) {
        this.f43097j = z11;
    }

    public final boolean a() {
        return this.f43097j;
    }

    public final void b(int i11) {
        this.f43096i = i11;
    }

    public final void b(String str) {
        this.f43091d++;
        this.f43092e.add(str);
    }

    public final void b(boolean z11) {
        this.f43098k = z11;
    }

    public final boolean b() {
        return this.f43098k;
    }

    public final int c() {
        return this.f43099l;
    }

    public final int d() {
        return this.f43096i;
    }

    public final String e() {
        return this.f43095h;
    }

    public final CampaignEx f() {
        return this.f43094g;
    }

    public final String g() {
        return this.f43090c;
    }

    public final int h() {
        return this.f43091d;
    }

    public final HashSet<String> i() {
        return this.f43092e;
    }

    public final long j() {
        return this.f43093f;
    }
}
