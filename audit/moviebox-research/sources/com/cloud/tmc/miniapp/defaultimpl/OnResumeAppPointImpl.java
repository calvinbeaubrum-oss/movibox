package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.point.OnResumeAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OnResumeAppPointImpl implements OnResumeAppPoint {
    @Override // com.cloud.tmc.integration.point.OnResumeAppPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.integration.point.OnResumeAppPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.integration.point.OnResumeAppPoint
    public void onResume(App app, e eVar) {
        Intrinsics.g(app, "app");
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG = eVar.g(app, "restoreAppAudio");
                if (bridgeExtensionG instanceof ForegroundAudioBridge) {
                    ((ForegroundAudioBridge) bridgeExtensionG).restoreAppAudio(app);
                }
                BridgeExtension bridgeExtensionG2 = eVar.g(app, "restoreAppAudioEffect");
                if (bridgeExtensionG2 instanceof AudioEffectBridge) {
                    ((AudioEffectBridge) bridgeExtensionG2).restoreAppAudioEffect(app);
                }
            } catch (Throwable th2) {
                TmcLogger.h("OnResumeAppPoint", th2);
            }
        }
    }
}
