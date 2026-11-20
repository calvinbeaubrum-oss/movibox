package androidx.media;

import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.j this$1;
    final /* synthetic */ MediaSessionCompat.Token val$token;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(MediaBrowserServiceCompat.j jVar, MediaSessionCompat.Token token) {
        this.val$token = token;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<MediaBrowserServiceCompat.ConnectionRecord> it = this.this$1.f8877a.f8833f.values().iterator();
        while (it.hasNext()) {
            MediaBrowserServiceCompat.ConnectionRecord next = it.next();
            try {
                next.f8842f.c(next.f8844h.d(), this.val$token, next.f8844h.c());
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Connection for " + next.f8837a + " is no longer valid.");
                it.remove();
            }
        }
    }
}
