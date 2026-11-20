package ho;

import android.telephony.TelephonyCallback;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m1 extends TelephonyCallback implements TelephonyCallback.ActiveDataSubscriptionIdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f66736a;

    public m1(n1 n1Var) {
        this.f66736a = n1Var;
    }

    @Override // android.telephony.TelephonyCallback.ActiveDataSubscriptionIdListener
    public final void onActiveDataSubscriptionIdChanged(int i11) {
        n1 n1Var = this.f66736a;
        n1Var.f66749a.k(n1Var);
    }
}
