package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.j this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(MediaBrowserServiceCompat.j jVar, String str, Bundle bundle) {
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<IBinder> it = this.this$1.f8877a.f8833f.keySet().iterator();
        while (it.hasNext()) {
            this.this$1.b(this.this$1.f8877a.f8833f.get(it.next()), this.val$parentId, this.val$options);
        }
    }
}
