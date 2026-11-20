package ho;

import android.net.Network;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f66752b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(u uVar) {
        super(uVar);
        this.f66752b = uVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(u uVar, int i11) {
        super(uVar, 0);
        this.f66752b = uVar;
    }

    @Override // ho.t, android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Lock lockWriteLock = this.f66752b.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            this.f66752b.f66758g.remove(network);
            this.f66752b.f66759h = network;
            lockWriteLock.unlock();
            u uVar = this.f66752b;
            uVar.f66750a.k(uVar);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        Lock lockWriteLock = this.f66752b.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            u uVar = this.f66752b;
            Network network = uVar.f66759h;
            if (network != null) {
                uVar.f66758g.add(network);
                this.f66752b.f66759h = null;
            }
            lockWriteLock.unlock();
            u uVar2 = this.f66752b;
            uVar2.f66750a.k(uVar2);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }
}
