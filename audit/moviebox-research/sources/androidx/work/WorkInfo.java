package androidx.work;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public UUID f13233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public State f13234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public d f13235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public Set<String> f13236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public d f13237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13239g;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull d dVar, @NonNull List<String> list, @NonNull d dVar2, int i11, int i12) {
        this.f13233a = uuid;
        this.f13234b = state;
        this.f13235c = dVar;
        this.f13236d = new HashSet(list);
        this.f13237e = dVar2;
        this.f13238f = i11;
        this.f13239g = i12;
    }

    @NonNull
    public State a() {
        return this.f13234b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f13238f == workInfo.f13238f && this.f13239g == workInfo.f13239g && this.f13233a.equals(workInfo.f13233a) && this.f13234b == workInfo.f13234b && this.f13235c.equals(workInfo.f13235c) && this.f13236d.equals(workInfo.f13236d)) {
            return this.f13237e.equals(workInfo.f13237e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f13233a.hashCode() * 31) + this.f13234b.hashCode()) * 31) + this.f13235c.hashCode()) * 31) + this.f13236d.hashCode()) * 31) + this.f13237e.hashCode()) * 31) + this.f13238f) * 31) + this.f13239g;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f13233a + "', mState=" + this.f13234b + ", mOutputData=" + this.f13235c + ", mTags=" + this.f13236d + ", mProgress=" + this.f13237e + '}';
    }
}
