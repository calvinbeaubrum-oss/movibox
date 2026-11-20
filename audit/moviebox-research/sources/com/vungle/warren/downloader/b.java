package com.vungle.warren.downloader;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f61984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f61985b;

    public b(int i11, int i12) {
        this.f61984a = Integer.valueOf(i11);
        this.f61985b = Integer.valueOf(i12);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof b)) {
            return -1;
        }
        b bVar = (b) obj;
        int iCompareTo = this.f61984a.compareTo(bVar.f61984a);
        return iCompareTo == 0 ? this.f61985b.compareTo(bVar.f61985b) : iCompareTo;
    }

    @NonNull
    public String toString() {
        return "AssetPriority{firstPriority=" + this.f61984a + ", secondPriority=" + this.f61985b + '}';
    }
}
