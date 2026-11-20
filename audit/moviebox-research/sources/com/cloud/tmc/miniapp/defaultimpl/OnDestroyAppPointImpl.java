package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.audio.recording.d;
import com.cloud.tmc.integration.bridge.AudioEffectBridge;
import com.cloud.tmc.integration.bridge.ForegroundAudioBridge;
import com.cloud.tmc.integration.bridge.KeyboardBridge;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.integration.bridge.WifiBridge;
import com.cloud.tmc.integration.model.AddToHomeScreenStore;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.model.FileCache;
import com.cloud.tmc.integration.model.TabReSelectedStore;
import com.cloud.tmc.integration.model.WebViewStore;
import com.cloud.tmc.integration.point.OnDestroyAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.bridge.PrefetchStrategyBridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OnDestroyAppPointImpl implements OnDestroyAppPoint {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyAppPoint
    public void onDestroy(App app, e eVar) {
        WeakHashMap<String, bc.a> pageCache;
        Iterator<Map.Entry<String, bc.a>> it;
        HashMap<String, bc.a> store;
        bc.a aVarRemove;
        bc.a aVarRemove2;
        Intrinsics.g(app, "app");
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG = eVar.g(app, "releaseAppAudio");
                if (bridgeExtensionG instanceof ForegroundAudioBridge) {
                    ((ForegroundAudioBridge) bridgeExtensionG).releaseAppAudio(app);
                }
                BridgeExtension bridgeExtensionG2 = eVar.g(app, "releaseAppAudioEffect");
                if (bridgeExtensionG2 instanceof AudioEffectBridge) {
                    ((AudioEffectBridge) bridgeExtensionG2).releaseAppAudioEffect(app);
                }
            } catch (Throwable th2) {
                TmcLogger.h("OnDestroyAppPoint", th2);
            }
        }
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG3 = eVar.g(app, "offKeyboardHeightChange");
                if (bridgeExtensionG3 instanceof KeyboardBridge) {
                    ((KeyboardBridge) bridgeExtensionG3).checkEventSubscriber(app, false);
                }
            } catch (Throwable th3) {
                TmcLogger.g("OnDestroyAppPointImpl", "releaseKeyboardBridge", th3);
            }
        }
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG4 = eVar.g(app, "destroyAppWifi");
                if (bridgeExtensionG4 instanceof WifiBridge) {
                    ((WifiBridge) bridgeExtensionG4).destroyAppWifi(app);
                }
            } catch (Throwable th4) {
                TmcLogger.g("OnDestroyAppPointImpl", "OnDestroyAppPoint", th4);
            }
        }
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG5 = eVar.g(app, "onNetworkStatusChange");
                if (bridgeExtensionG5 instanceof NetworkBridge) {
                    ((NetworkBridge) bridgeExtensionG5).clearNetworkChangeListenModel(app);
                }
            } catch (Throwable th5) {
                TmcLogger.g("OnDestroyAppPointImpl", "onNetworkStatusChange", th5);
            }
        }
        try {
            AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class);
            if (audioRecordCache != null) {
                bc.a aVarRemove3 = audioRecordCache.getOnStarts().remove(app.getAppId());
                if (aVarRemove3 != null) {
                    aVarRemove3.close();
                }
                bc.a aVarRemove4 = audioRecordCache.getOnStops().remove(app.getAppId());
                if (aVarRemove4 != null) {
                    aVarRemove4.close();
                }
                bc.a aVarRemove5 = audioRecordCache.getOnPauses().remove(app.getAppId());
                if (aVarRemove5 != null) {
                    aVarRemove5.close();
                }
                bc.a aVarRemove6 = audioRecordCache.getOnResumes().remove(app.getAppId());
                if (aVarRemove6 != null) {
                    aVarRemove6.close();
                }
                bc.a aVarRemove7 = audioRecordCache.getOnErrors().remove(app.getAppId());
                if (aVarRemove7 != null) {
                    aVarRemove7.close();
                }
                d dVarRemove = audioRecordCache.getRecorderClientCache().remove(app.getAppId());
                if (dVarRemove != null && !dVarRemove.k()) {
                    dVarRemove.v();
                }
            }
        } catch (Throwable th6) {
            TmcLogger.h("OnDestroyAppPointImpl", th6);
        }
        try {
            WebViewStore webViewStore = (WebViewStore) app.getData(WebViewStore.class);
            if (webViewStore != null && (aVarRemove2 = webViewStore.getOnDownloads().remove(app.getAppId())) != null) {
                aVarRemove2.close();
            }
        } catch (Throwable th7) {
            TmcLogger.h("OnDestroyAppPointImpl", th7);
        }
        try {
            FileCache fileCache = (FileCache) app.getData(FileCache.class);
            if (fileCache != null) {
                fileCache.getFileCache().clear();
                fileCache.getFlags().clear();
            }
        } catch (Throwable th8) {
            TmcLogger.h("OnDestroyAppPointImpl", th8);
        }
        AddToHomeScreenStore addToHomeScreenStore = (AddToHomeScreenStore) app.getData(AddToHomeScreenStore.class);
        if (addToHomeScreenStore != null && (store = addToHomeScreenStore.getStore()) != null && (aVarRemove = store.remove(app.getAppId())) != null) {
            aVarRemove.b();
        }
        TabReSelectedStore tabReSelectedStore = (TabReSelectedStore) app.getData(TabReSelectedStore.class);
        if (tabReSelectedStore != null && (pageCache = tabReSelectedStore.getPageCache()) != null && (it = pageCache.entrySet().iterator()) != null) {
            while (it.hasNext()) {
                it.next().getValue().close();
                it.remove();
            }
        }
        if (eVar != null) {
            try {
                BridgeExtension bridgeExtensionG6 = eVar.g(app, "changePrefetchStatus");
                if (bridgeExtensionG6 instanceof PrefetchStrategyBridge) {
                    ((PrefetchStrategyBridge) bridgeExtensionG6).changePrefetchStatus(app);
                }
            } catch (Throwable th9) {
                try {
                    TmcLogger.g("OnDestroyAppPointImpl", "releaseKeyboardBridge", th9);
                } catch (Throwable th10) {
                    TmcLogger.h("OnDestroyAppPointImpl", th10);
                }
            }
        }
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyAppPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("OnDestroyAppPointImpl", "onFinalized");
    }

    @Override // com.cloud.tmc.integration.point.OnDestroyAppPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("OnDestroyAppPointImpl", "onInitialized");
    }
}
