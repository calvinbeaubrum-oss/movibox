package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PostMessageService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0.d.a f1820a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends z0.d.a {
        public a() {
        }

        @Override // z0.d
        public void b(@NonNull z0.a aVar, @Nullable Bundle bundle) throws RemoteException {
            aVar.Y(bundle);
        }

        @Override // z0.d
        public void f(@NonNull z0.a aVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            aVar.X(str, bundle);
        }
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.f1820a;
    }
}
