package OooO;

import android.os.Bundle;
import android.os.RemoteException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import pd.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO0o extends Lambda implements Function2<a, String, Unit> {
    public final /* synthetic */ String OooO00o;
    public final /* synthetic */ String OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0o(String str, String str2) {
        super(2);
        this.OooO00o = str;
        this.OooO0O0 = str2;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(a aVar, String str) throws RemoteException {
        a aVar2 = aVar;
        if (aVar2 != null) {
            String str2 = this.OooO00o;
            Bundle bundle = new Bundle();
            bundle.putString("resultJsonData", this.OooO0O0);
            Unit unit = Unit.f68710a;
            aVar2.G("typeMiniAppAllStorage", str2, bundle);
        }
        return Unit.f68710a;
    }
}
