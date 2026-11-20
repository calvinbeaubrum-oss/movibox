package ho;

import android.telephony.SubscriptionManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r0 extends SubscriptionManager.OnSubscriptionsChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f66751a;

    public r0(l1 l1Var) {
        this.f66751a = l1Var;
    }

    @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
    public final void onSubscriptionsChanged() {
        l1 l1Var = this.f66751a;
        l1Var.f66749a.k(l1Var);
    }
}
