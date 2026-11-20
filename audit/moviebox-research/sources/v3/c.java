package v3;

import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends NotificationCompat.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f78705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f78706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PendingIntent f78708i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f78704e = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f78709j = false;

    @Override // androidx.core.app.NotificationCompat.p
    public void b(n nVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            a.d(nVar.a(), a.b(b.a(a.a(), this.f78706g, this.f78707h, this.f78708i, Boolean.valueOf(this.f78709j)), this.f78704e, this.f78705f));
        } else {
            a.d(nVar.a(), a.b(a.a(), this.f78704e, this.f78705f));
        }
    }

    @Override // androidx.core.app.NotificationCompat.p
    public RemoteViews m(n nVar) {
        return null;
    }

    @Override // androidx.core.app.NotificationCompat.p
    public RemoteViews n(n nVar) {
        return null;
    }

    public c q(MediaSessionCompat.Token token) {
        this.f78705f = token;
        return this;
    }

    public c r(int... iArr) {
        this.f78704e = iArr;
        return this;
    }
}
