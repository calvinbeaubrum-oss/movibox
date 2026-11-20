package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.audio.recording.d;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.point.OnPauseAppPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.j0;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OnPauseAppPointImpl implements OnPauseAppPoint {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    @Override // com.cloud.tmc.integration.point.OnPauseAppPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("OnPauseAppPointImpl", "onFinalized");
    }

    @Override // com.cloud.tmc.integration.point.OnPauseAppPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("OnPauseAppPointImpl", "onInitialized");
    }

    @Override // com.cloud.tmc.integration.point.OnPauseAppPoint
    public void onPause(App app, e eVar) {
        HashMap<String, d> recorderClientCache;
        d dVar;
        Intrinsics.g(app, "app");
        try {
            AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class);
            if (audioRecordCache != null && (recorderClientCache = audioRecordCache.getRecorderClientCache()) != null && (dVar = recorderClientCache.get(app.getAppId())) != null && !dVar.k() && (!dVar.j() || !dVar.i())) {
                dVar.q();
            }
            j0.f31066a.b();
        } catch (Throwable th2) {
            TmcLogger.h("OnPauseAppPointImpl", th2);
        }
    }
}
