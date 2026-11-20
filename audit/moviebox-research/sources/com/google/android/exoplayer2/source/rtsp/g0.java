package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<String, String> f34513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList<com.google.android.exoplayer2.source.rtsp.a> f34514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f34515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f34516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f34517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f34518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Uri f34519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f34520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f34521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f34522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f34523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final String f34524l;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f34525a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList.a<com.google.android.exoplayer2.source.rtsp.a> f34526b = new ImmutableList.a<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f34527c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f34528d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public String f34529e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public String f34530f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public Uri f34531g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f34532h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public String f34533i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public String f34534j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public String f34535k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public String f34536l;

        public b m(String str, String str2) {
            this.f34525a.put(str, str2);
            return this;
        }

        public b n(com.google.android.exoplayer2.source.rtsp.a aVar) {
            this.f34526b.a(aVar);
            return this;
        }

        public g0 o() {
            return new g0(this);
        }

        public b p(int i11) {
            this.f34527c = i11;
            return this;
        }

        public b q(String str) {
            this.f34532h = str;
            return this;
        }

        public b r(String str) {
            this.f34535k = str;
            return this;
        }

        public b s(String str) {
            this.f34533i = str;
            return this;
        }

        public b t(String str) {
            this.f34529e = str;
            return this;
        }

        public b u(String str) {
            this.f34536l = str;
            return this;
        }

        public b v(String str) {
            this.f34534j = str;
            return this;
        }

        public b w(String str) {
            this.f34528d = str;
            return this;
        }

        public b x(String str) {
            this.f34530f = str;
            return this;
        }

        public b y(Uri uri) {
            this.f34531g = uri;
            return this;
        }
    }

    public g0(b bVar) {
        this.f34513a = ImmutableMap.copyOf((Map) bVar.f34525a);
        this.f34514b = bVar.f34526b.m();
        this.f34515c = (String) o0.j(bVar.f34528d);
        this.f34516d = (String) o0.j(bVar.f34529e);
        this.f34517e = (String) o0.j(bVar.f34530f);
        this.f34519g = bVar.f34531g;
        this.f34520h = bVar.f34532h;
        this.f34518f = bVar.f34527c;
        this.f34521i = bVar.f34533i;
        this.f34522j = bVar.f34535k;
        this.f34523k = bVar.f34536l;
        this.f34524l = bVar.f34534j;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f34518f == g0Var.f34518f && this.f34513a.equals(g0Var.f34513a) && this.f34514b.equals(g0Var.f34514b) && o0.c(this.f34516d, g0Var.f34516d) && o0.c(this.f34515c, g0Var.f34515c) && o0.c(this.f34517e, g0Var.f34517e) && o0.c(this.f34524l, g0Var.f34524l) && o0.c(this.f34519g, g0Var.f34519g) && o0.c(this.f34522j, g0Var.f34522j) && o0.c(this.f34523k, g0Var.f34523k) && o0.c(this.f34520h, g0Var.f34520h) && o0.c(this.f34521i, g0Var.f34521i);
    }

    public int hashCode() {
        int iHashCode = (((217 + this.f34513a.hashCode()) * 31) + this.f34514b.hashCode()) * 31;
        String str = this.f34516d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f34515c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f34517e;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f34518f) * 31;
        String str4 = this.f34524l;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri = this.f34519g;
        int iHashCode6 = (iHashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str5 = this.f34522j;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f34523k;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f34520h;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f34521i;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }
}
