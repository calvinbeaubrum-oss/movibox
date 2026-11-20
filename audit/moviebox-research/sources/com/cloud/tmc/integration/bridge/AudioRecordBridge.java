package com.cloud.tmc.integration.bridge;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class AudioRecordBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cloud.tmc.integration.audio.recording.d f30443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ App f30445c;

        public b(com.cloud.tmc.integration.audio.recording.d dVar, bc.a aVar, App app) {
            this.f30443a = dVar;
            this.f30444b = aVar;
            this.f30445c = app;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30444b;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Audio failed with permission denied : A10011");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(this.f30445c, jsonObject);
            aVar.e(jsonObject);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            this.f30443a.q();
            this.f30444b.g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cloud.tmc.integration.audio.recording.d f30446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ App f30448c;

        public c(com.cloud.tmc.integration.audio.recording.d dVar, bc.a aVar, App app) {
            this.f30446a = dVar;
            this.f30447b = aVar;
            this.f30448c = app;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30447b;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Audio failed with permission denied : A10011");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(this.f30448c, jsonObject);
            aVar.e(jsonObject);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            this.f30446a.r();
            this.f30447b.g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cloud.tmc.integration.audio.recording.d f30449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f30450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f30452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f30453e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f30454f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ bc.a f30455g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ App f30456h;

        public d(com.cloud.tmc.integration.audio.recording.d dVar, File file, String str, int i11, int i12, int i13, bc.a aVar, App app) {
            this.f30449a = dVar;
            this.f30450b = file;
            this.f30451c = str;
            this.f30452d = i11;
            this.f30453e = i12;
            this.f30454f = i13;
            this.f30455g = aVar;
            this.f30456h = app;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            xb.b.b(this.f30450b);
            bc.a aVar = this.f30455g;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Audio failed with permission denied : A10011");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(this.f30456h, jsonObject);
            aVar.e(jsonObject);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            com.cloud.tmc.integration.audio.recording.d dVar = this.f30449a;
            String absolutePath = this.f30450b.getAbsolutePath();
            Intrinsics.f(absolutePath, "recordFile.absolutePath");
            dVar.u(absolutePath, com.cloud.tmc.integration.audio.recording.h.f30441a.f(this.f30451c), this.f30452d, this.f30453e, this.f30454f);
            this.f30455g.g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cloud.tmc.integration.audio.recording.d f30457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ App f30459c;

        public e(com.cloud.tmc.integration.audio.recording.d dVar, bc.a aVar, App app) {
            this.f30457a = dVar;
            this.f30458b = aVar;
            this.f30459c = app;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30458b;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Audio failed with permission denied : A10011");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(this.f30459c, jsonObject);
            aVar.e(jsonObject);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            this.f30457a.v();
            this.f30458b.g();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void getAvailableAudioSources(@cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Iterator<T> it = com.cloud.tmc.integration.audio.recording.h.f30441a.p().iterator();
        while (it.hasNext()) {
            jsonArray.add((String) it.next());
        }
        Unit unit = Unit.f68710a;
        jsonObject.add("audioSources", jsonArray);
        callback.d(jsonObject);
    }

    @zb.a("audioRecordOffError")
    @zb.e(ExecutorType.NORMAL)
    public final void offError(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
        } else {
            bc.a aVarRemove = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnErrors().remove(app.getAppId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @zb.a("audioRecordOffPause")
    @zb.e(ExecutorType.NORMAL)
    public final void offPause(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
        } else {
            bc.a aVarRemove = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnPauses().remove(app.getAppId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @zb.a("audioRecordOffResume")
    @zb.e(ExecutorType.NORMAL)
    public final void offResume(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
        } else {
            bc.a aVarRemove = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnResumes().remove(app.getAppId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @zb.a("audioRecordOffStart")
    @zb.e(ExecutorType.NORMAL)
    public final void offStart(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
        } else {
            bc.a aVarRemove = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnStarts().remove(app.getAppId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @zb.a("audioRecordOffStop")
    @zb.e(ExecutorType.NORMAL)
    public final void offStop(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
        } else {
            bc.a aVarRemove = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnStops().remove(app.getAppId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            callback.g();
        }
    }

    @zb.a("audioRecordOnError")
    @zb.e(ExecutorType.NORMAL)
    public final void onError(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class, true);
        bc.a aVar = audioRecordCache.getOnErrors().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onErrors = audioRecordCache.getOnErrors();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onErrors.put(appId, callback);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("AudioRecordBridge", "onFinalized: ");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("AudioRecordBridge", "onInitialized: ");
    }

    @zb.a("audioRecordOnPause")
    @zb.e(ExecutorType.NORMAL)
    public final void onPause(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class, true);
        bc.a aVar = audioRecordCache.getOnPauses().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onPauses = audioRecordCache.getOnPauses();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onPauses.put(appId, callback);
    }

    @zb.a("audioRecordOnResume")
    @zb.e(ExecutorType.NORMAL)
    public final void onResume(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class, true);
        bc.a aVar = audioRecordCache.getOnResumes().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onResumes = audioRecordCache.getOnResumes();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onResumes.put(appId, callback);
    }

    @zb.a("audioRecordOnStart")
    @zb.e(ExecutorType.NORMAL)
    public final void onStart(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class, true);
        bc.a aVar = audioRecordCache.getOnStarts().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onStarts = audioRecordCache.getOnStarts();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onStarts.put(appId, callback);
    }

    @zb.a("audioRecordOnStop")
    @zb.e(ExecutorType.NORMAL)
    public final void onStop(@cc.f(App.class) App app, @cc.c(isSticky = true) bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) app.getData(AudioRecordCache.class, true);
        bc.a aVar = audioRecordCache.getOnStops().get(app.getAppId());
        if (aVar != null) {
            aVar.close();
        }
        HashMap<String, bc.a> onStops = audioRecordCache.getOnStops();
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        onStops.put(appId, callback);
    }

    @zb.a("audioRecordPause")
    @zb.e(ExecutorType.UI)
    public final void pause(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        com.cloud.tmc.integration.audio.recording.d dVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getRecorderClientCache().get(app.getAppId());
        if (dVar == null || dVar.k()) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "Audio is stop, don't stop record again : A10012");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(app, jsonObject2);
            callback.e(jsonObject2);
            return;
        }
        if (!dVar.i()) {
            PermissionUtils.y("MICROPHONE").m(new b(dVar, callback, app)).z();
            return;
        }
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("errMsg", "Audio is paused, pause record fail : A10009");
        com.cloud.tmc.integration.audio.recording.h.f30441a.h(app, jsonObject3);
        callback.e(jsonObject3);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a("audioRecordResume")
    @zb.e(ExecutorType.UI)
    public final void resume(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        com.cloud.tmc.integration.audio.recording.d dVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getRecorderClientCache().get(app.getAppId());
        if (dVar == null || dVar.k()) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "Audio is stop, don't stop record again : A10012");
            com.cloud.tmc.integration.audio.recording.h.f30441a.h(app, jsonObject2);
            callback.e(jsonObject2);
            return;
        }
        if (!dVar.j()) {
            PermissionUtils.y("MICROPHONE").m(new c(dVar, callback, app)).z();
            return;
        }
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("errMsg", "Audio is recording, don't start record again : A10008");
        com.cloud.tmc.integration.audio.recording.h.f30441a.h(app, jsonObject3);
        callback.e(jsonObject3);
    }

    @zb.a("audioRecordStart")
    @zb.e(ExecutorType.UI)
    public final void start(@cc.f(App.class) App app, @cc.g(longDefault = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, value = {"duration"}) long j11, @cc.g(intDefault = 8000, value = {"sampleRate"}) int i11, @cc.g(intDefault = 2, value = {"numberOfChannels"}) int i12, @cc.g(intDefault = 48000, value = {"encodeBitRate"}) int i13, @cc.g(stringDefault = "aac", value = {"format"}) String format, @cc.g(stringDefault = "auto", value = {"audioSource"}) String audioSource, @cc.c bc.a callback) {
        Intrinsics.g(format, "format");
        Intrinsics.g(audioSource, "audioSource");
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        com.cloud.tmc.integration.audio.recording.h hVar = com.cloud.tmc.integration.audio.recording.h.f30441a;
        if (!hVar.e(i11)) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "Invalid sampleRate \"" + i11 + "\", sampleRate should be one of " + com.cloud.tmc.kernel.utils.o.a(hVar.s()) + ": A10002");
            hVar.h(app, jsonObject2);
            callback.e(jsonObject2);
            return;
        }
        if (!hVar.b(i12)) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("errMsg", "Invalid numberOfChannels \"" + i12 + "\", numberOfChannels should be one of " + com.cloud.tmc.kernel.utils.o.a(hVar.q()) + ": A10003");
            hVar.h(app, jsonObject3);
            callback.e(jsonObject3);
            return;
        }
        if (!hVar.c(i11, i13)) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("errMsg", "Invalid encodeBitRate \"" + i13 + "\", encodeBitRate should be greater than " + hVar.u(i11) + " and less than " + hVar.t(i11) + " : A10004");
            hVar.h(app, jsonObject4);
            callback.e(jsonObject4);
            return;
        }
        if (!hVar.d(format)) {
            JsonObject jsonObject5 = new JsonObject();
            jsonObject5.addProperty("errMsg", "Invalid format \"" + format + "\", format should be one of " + com.cloud.tmc.kernel.utils.o.a(hVar.r()) + " : A10005");
            hVar.h(app, jsonObject5);
            callback.e(jsonObject5);
            return;
        }
        if (!hVar.a(audioSource)) {
            JsonObject jsonObject6 = new JsonObject();
            jsonObject6.addProperty("errMsg", "Invalid audioSource \"" + audioSource + "\", audioSource should be one of " + com.cloud.tmc.kernel.utils.o.a(hVar.p()) + " : A10006");
            hVar.h(app, jsonObject6);
            callback.e(jsonObject6);
            return;
        }
        if (j11 < 0 || j11 > TTAdConstant.AD_MAX_EVENT_TIME) {
            JsonObject jsonObject7 = new JsonObject();
            jsonObject7.addProperty("errMsg", "Invalid duration " + j11 + ", duration should be between 0 and 600000 : A10007");
            hVar.h(app, jsonObject7);
            callback.e(jsonObject7);
            return;
        }
        HashMap<String, com.cloud.tmc.integration.audio.recording.d> recorderClientCache = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getRecorderClientCache();
        com.cloud.tmc.integration.audio.recording.d dVarG = recorderClientCache.get(app.getAppId());
        if (dVarG == null) {
            dVarG = hVar.g(app, format);
            String appId = app.getAppId();
            Intrinsics.f(appId, "app.appId");
            recorderClientCache.put(appId, dVarG);
        }
        Intrinsics.f(dVarG, "recorderClientCache[app.… = this\n                }");
        dVarG.s(j11);
        if (!dVarG.k()) {
            JsonObject jsonObject8 = new JsonObject();
            jsonObject8.addProperty("errMsg", "Audio is recording, don't start record again : A10008");
            hVar.h(app, jsonObject8);
            callback.e(jsonObject8);
            return;
        }
        File fileX = hVar.x(app, format);
        if (fileX != null) {
            PermissionUtils.y("MICROPHONE").m(new d(dVarG, fileX, audioSource, i12, i11, i13, callback, app)).z();
            return;
        }
        JsonObject jsonObject9 = new JsonObject();
        jsonObject9.addProperty("errMsg", "create record file fail : A10010");
        hVar.h(app, jsonObject9);
        callback.e(jsonObject9);
    }

    @zb.a("audioRecordStop")
    @zb.e(ExecutorType.UI)
    public final void stop(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app == null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: A10001");
            callback.e(jsonObject);
            return;
        }
        com.cloud.tmc.integration.audio.recording.d dVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getRecorderClientCache().get(app.getAppId());
        if (dVar != null && !dVar.k()) {
            PermissionUtils.y("MICROPHONE").m(new e(dVar, callback, app)).z();
            return;
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("errMsg", "Audio is stop, don't stop record again : A10012");
        com.cloud.tmc.integration.audio.recording.h.f30441a.h(app, jsonObject2);
        callback.e(jsonObject2);
    }
}
