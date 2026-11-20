package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public final class h extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f8887d;

    public h(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.f8887d = remoteUserInfo;
    }

    public h(String str, int i11, int i12) {
        super(str, i11, i12);
        this.f8887d = d.a(str, i11, i12);
    }

    public static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }
}
