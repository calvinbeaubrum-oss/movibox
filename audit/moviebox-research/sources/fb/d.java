package fb;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.point.BridgeAccessPoint;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements dd.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f64760d = "TmcKernel:" + d.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeCallContext f64761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mc.a f64762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BridgeAccessPoint f64763c;

    public d(NativeCallContext nativeCallContext, mc.a aVar, com.cloud.tmc.kernel.extension.e eVar) {
        this.f64761a = nativeCallContext;
        this.f64762b = aVar;
        this.f64763c = (BridgeAccessPoint) ib.a.b(BridgeAccessPoint.class).e(eVar).g(nativeCallContext.getNode()).d();
    }
}
