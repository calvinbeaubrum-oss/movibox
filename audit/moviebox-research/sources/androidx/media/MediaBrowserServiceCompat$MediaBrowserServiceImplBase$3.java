package androidx.media;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.j this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    final /* synthetic */ b val$remoteUserInfo;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(MediaBrowserServiceCompat.j jVar, b bVar, String str, Bundle bundle) {
        this.val$remoteUserInfo = bVar;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i11 = 0; i11 < this.this$1.f8877a.f8833f.size(); i11++) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecordValueAt = this.this$1.f8877a.f8833f.valueAt(i11);
            if (connectionRecordValueAt.f8840d.equals(this.val$remoteUserInfo)) {
                this.this$1.b(connectionRecordValueAt, this.val$parentId, this.val$options);
                return;
            }
        }
    }
}
