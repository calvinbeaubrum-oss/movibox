package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.KeyboardBridge;
import com.cloud.tmc.integration.point.OnDestroyPagePoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OnDestroyPagePointImpl implements OnDestroyPagePoint {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyPagePoint
    public void onDestroy(App app, Page page, e eVar) {
        Intrinsics.g(page, "page");
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG = eVar.g(page, "offKeyboardHeightChange");
                if (bridgeExtensionG instanceof KeyboardBridge) {
                    ((KeyboardBridge) bridgeExtensionG).offKeyboardHeightChange(app, page, null);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyPagePoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.k("OnDestroyPagePointImpl", "onFinalized");
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyPagePoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.k("OnDestroyPagePointImpl", "onInitialized");
    }
}
