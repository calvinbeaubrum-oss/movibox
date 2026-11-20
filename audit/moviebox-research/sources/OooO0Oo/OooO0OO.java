package OooO0Oo;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import h.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class OooO0OO implements Runnable {
    public final /* synthetic */ String OooO00o;
    public final /* synthetic */ String OooO0O0;
    public final /* synthetic */ AppModel OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final /* synthetic */ b f4OooO0Oo;

    public OooO0OO(b bVar, String str, String str2, AppModel appModel) {
        this.f4OooO0Oo = bVar;
        this.OooO00o = str;
        this.OooO0O0 = str2;
        this.OooO0OO = appModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ScopeUtils scopeUtils = ScopeUtils.f31808a;
            if (scopeUtils.i(this.f4OooO0Oo.f65653a, this.OooO00o, this.OooO0O0)) {
                Context context = this.f4OooO0Oo.f65653a;
                String scopeName = this.OooO00o;
                String appId = this.OooO0O0;
                String name = this.OooO0OO.getName();
                String logo = this.OooO0OO.getLogo();
                Intrinsics.g(context, "context");
                Intrinsics.g(scopeName, "scopeName");
                Intrinsics.g(appId, "appId");
                scopeUtils.f(context, scopeName, appId, false, name, logo, false, false);
            }
        } catch (Throwable th2) {
            TmcLogger.h("Tmcintegration:LocalAuthPermissionManager", th2);
        }
    }
}
