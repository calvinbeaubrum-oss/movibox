package com.cloud.tmc.miniapp;

import android.content.Context;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.UpgradeImpl;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.proxy.platform.IUpgradeProxy;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class UpgradeImpl implements IUpgradeProxy {
    public static final void b(Context context, c0 prepareCallback, String str) {
        Intrinsics.g(prepareCallback, "$prepareCallback");
        if (l.v(context.getPackageName(), "com.transsion.hilauncher.upgrade", true) || l.v(context.getPackageName(), "com.transsion.XOSLauncher.upgrade", true)) {
            MiniAppLaunch.Z(context);
        } else {
            prepareCallback.a(str);
        }
    }

    @Override // com.cloud.tmc.miniapp.proxy.platform.IUpgradeProxy
    public void showFwUpdateTipsDialog(final Context context, final String str, final c0 prepareCallback) {
        Intrinsics.g(prepareCallback, "prepareCallback");
        if (context == null) {
            return;
        }
        e.f(new Runnable() { // from class: hd.o
            @Override // java.lang.Runnable
            public final void run() {
                UpgradeImpl.b(context, prepareCallback, str);
            }
        });
    }
}
