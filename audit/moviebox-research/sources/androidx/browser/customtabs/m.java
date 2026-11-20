package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0.c f1865a;

    public m(@NonNull z0.c cVar) {
        this.f1865a = cVar;
    }

    @NonNull
    public static m a(@NonNull IBinder iBinder) {
        return new m(z0.c.a.e0(iBinder));
    }

    @Override // androidx.browser.customtabs.l
    public void onGreatestScrollPercentageIncreased(int i11, @NonNull Bundle bundle) {
        try {
            this.f1865a.onGreatestScrollPercentageIncreased(i11, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onSessionEnded(boolean z11, @NonNull Bundle bundle) {
        try {
            this.f1865a.onSessionEnded(z11, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.l
    public void onVerticalScrollEvent(boolean z11, @NonNull Bundle bundle) {
        try {
            this.f1865a.onVerticalScrollEvent(z11, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
