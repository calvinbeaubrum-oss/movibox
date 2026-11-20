package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.point.OnStopAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OnStopAppPointImpl implements OnStopAppPoint {
    @Override // com.cloud.tmc.integration.point.OnStopAppPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.integration.point.OnStopAppPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.integration.point.OnStopAppPoint
    public void onStop(App app, e eVar) {
        Intrinsics.g(app, "app");
        if (app.isDestroyed() || eVar == null) {
            return;
        }
        try {
            BridgeExtension bridgeExtensionG = eVar.g(app, "pauseAppAudio");
            if (bridgeExtensionG instanceof ForegroundAudioBridge) {
                ((ForegroundAudioBridge) bridgeExtensionG).pauseAppAudio(app);
            }
            BridgeExtension bridgeExtensionG2 = eVar.g(app, "stopAppAudioEffect");
            if (bridgeExtensionG2 instanceof AudioEffectBridge) {
                ((AudioEffectBridge) bridgeExtensionG2).stopAppAudioEffect(app);
            }
        } catch (Throwable th2) {
            TmcLogger.h("OnResumeAppPoint", th2);
        }
    }
}
