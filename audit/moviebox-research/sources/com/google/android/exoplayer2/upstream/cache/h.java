package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h implements Comparable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f35324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f35325d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final File f35326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f35327g;

    public h(String str, long j11, long j12, long j13, @Nullable File file) {
        this.f35322a = str;
        this.f35323b = j11;
        this.f35324c = j12;
        this.f35325d = file != null;
        this.f35326f = file;
        this.f35327g = j13;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (!this.f35322a.equals(hVar.f35322a)) {
            return this.f35322a.compareTo(hVar.f35322a);
        }
        long j11 = this.f35323b - hVar.f35323b;
        if (j11 == 0) {
            return 0;
        }
        return j11 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f35325d;
    }

    public boolean c() {
        return this.f35324c == -1;
    }

    public String toString() {
        return "[" + this.f35323b + ", " + this.f35324c + "]";
    }
}
