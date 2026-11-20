package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements Comparable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final File f9686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9687g;

    public h(String str, long j11, long j12, long j13, @Nullable File file) {
        this.f9682a = str;
        this.f9683b = j11;
        this.f9684c = j12;
        this.f9685d = file != null;
        this.f9686f = file;
        this.f9687g = j13;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (!this.f9682a.equals(hVar.f9682a)) {
            return this.f9682a.compareTo(hVar.f9682a);
        }
        long j11 = this.f9683b - hVar.f9683b;
        if (j11 == 0) {
            return 0;
        }
        return j11 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f9685d;
    }

    public boolean c() {
        return this.f9684c == -1;
    }

    public String toString() {
        return "[" + this.f9683b + ", " + this.f9684c + "]";
    }
}
