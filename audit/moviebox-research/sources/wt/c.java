package wt;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile h f79595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f79596b;

    public c(Context context) {
        this.f79596b = context;
    }

    public h a(long j11, long j12) {
        if (this.f79595a == null) {
            synchronized (this) {
                try {
                    if (this.f79595a == null) {
                        this.f79595a = new g(this.f79596b, j11, j12).a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f79595a;
    }
}
