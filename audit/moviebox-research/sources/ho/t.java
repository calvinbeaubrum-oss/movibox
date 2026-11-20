package ho;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class t extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f66753a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar) {
        super(1);
        this.f66753a = uVar;
    }

    public t(u uVar, int i11) {
        this.f66753a = uVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Lock lockWriteLock = this.f66753a.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            this.f66753a.f66758g.remove(network);
            lockWriteLock.unlock();
            u uVar = this.f66753a;
            uVar.f66750a.k(uVar);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Lock lockWriteLock = this.f66753a.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            this.f66753a.f66757f.put(network, networkCapabilities);
            lockWriteLock.unlock();
            u uVar = this.f66753a;
            uVar.f66750a.k(uVar);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Lock lockWriteLock = this.f66753a.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            this.f66753a.f66756d.put(network, linkProperties);
            lockWriteLock.unlock();
            u uVar = this.f66753a;
            uVar.f66750a.k(uVar);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Lock lockWriteLock = this.f66753a.f66754b.writeLock();
        lockWriteLock.lock();
        try {
            this.f66753a.f66758g.add(network);
            lockWriteLock.unlock();
            u uVar = this.f66753a;
            uVar.f66750a.k(uVar);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }
}
