package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import y2.b;
import z2.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.a f7765a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends b.a {
        public a() {
        }

        @Override // y2.b
        public void E(@Nullable y2.a aVar) throws RemoteException {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new g(aVar));
        }
    }

    public abstract void a(@NonNull g gVar);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.f7765a;
    }
}
