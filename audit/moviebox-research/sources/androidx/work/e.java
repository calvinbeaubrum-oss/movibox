package androidx.work;

import android.app.Notification;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Notification f13310c;

    public e(int i11, @NonNull Notification notification, int i12) {
        this.f13308a = i11;
        this.f13310c = notification;
        this.f13309b = i12;
    }

    public int a() {
        return this.f13309b;
    }

    @NonNull
    public Notification b() {
        return this.f13310c;
    }

    public int c() {
        return this.f13308a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f13308a == eVar.f13308a && this.f13309b == eVar.f13309b) {
            return this.f13310c.equals(eVar.f13310c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f13308a * 31) + this.f13309b) * 31) + this.f13310c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f13308a + ", mForegroundServiceType=" + this.f13309b + ", mNotification=" + this.f13310c + '}';
    }
}
