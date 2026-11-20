package OooOoo0;

import c0.b;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooOOO0 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ String OooO00o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOOO0(String str) {
        super(1);
        this.OooO00o = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        ((CopyOnWriteArrayList) b.f14535b).remove(this.OooO00o);
        TmcLogger.f("PreOfflinePackageStrategy", "preOfflinePackage task finish. success =" + zBooleanValue + " current size = " + ((CopyOnWriteArrayList) b.f14535b).size());
        return Unit.f68710a;
    }
}
