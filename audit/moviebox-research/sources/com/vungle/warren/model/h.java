package com.vungle.warren.model;

import androidx.annotation.RequiresApi;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("id")
    String f62168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("timestamp_bust_end")
    long f62169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f62170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f62171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("timestamp_processed")
    long f62172e;

    public String a() {
        return this.f62168a + ":" + this.f62169b;
    }

    public String[] b() {
        return this.f62171d;
    }

    public String c() {
        return this.f62168a;
    }

    public int d() {
        return this.f62170c;
    }

    public long e() {
        return this.f62169b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f62170c == hVar.f62170c && this.f62172e == hVar.f62172e && this.f62168a.equals(hVar.f62168a) && this.f62169b == hVar.f62169b && Arrays.equals(this.f62171d, hVar.f62171d);
    }

    public long f() {
        return this.f62172e;
    }

    public void g(String[] strArr) {
        this.f62171d = strArr;
    }

    public void h(int i11) {
        this.f62170c = i11;
    }

    @RequiresApi(api = 19)
    public int hashCode() {
        return (Objects.hash(this.f62168a, Long.valueOf(this.f62169b), Integer.valueOf(this.f62170c), Long.valueOf(this.f62172e)) * 31) + Arrays.hashCode(this.f62171d);
    }

    public void i(long j11) {
        this.f62169b = j11;
    }

    public void j(long j11) {
        this.f62172e = j11;
    }

    public String toString() {
        return "CacheBust{id='" + this.f62168a + "', timeWindowEnd=" + this.f62169b + ", idType=" + this.f62170c + ", eventIds=" + Arrays.toString(this.f62171d) + ", timestampProcessed=" + this.f62172e + '}';
    }
}
