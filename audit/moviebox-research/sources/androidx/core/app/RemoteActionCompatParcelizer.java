package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f7687a = (IconCompat) versionedParcel.v(remoteActionCompat.f7687a, 1);
        remoteActionCompat.f7688b = versionedParcel.l(remoteActionCompat.f7688b, 2);
        remoteActionCompat.f7689c = versionedParcel.l(remoteActionCompat.f7689c, 3);
        remoteActionCompat.f7690d = (PendingIntent) versionedParcel.r(remoteActionCompat.f7690d, 4);
        remoteActionCompat.f7691e = versionedParcel.h(remoteActionCompat.f7691e, 5);
        remoteActionCompat.f7692f = versionedParcel.h(remoteActionCompat.f7692f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f7687a, 1);
        versionedParcel.D(remoteActionCompat.f7688b, 2);
        versionedParcel.D(remoteActionCompat.f7689c, 3);
        versionedParcel.H(remoteActionCompat.f7690d, 4);
        versionedParcel.z(remoteActionCompat.f7691e, 5);
        versionedParcel.z(remoteActionCompat.f7692f, 6);
    }
}
