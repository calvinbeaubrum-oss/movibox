package com.cloud.tmc.integration.audio.recording;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f30433g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final App f30434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f30435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f30436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f30437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f30438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f30439f;

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
    @SourceDebugExtension
    public static final class b implements g {
        public b() {
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void a(File output) {
            Intrinsics.g(output, "output");
            TmcLogger.c("RecorderClient", "Recorder onStartRecord");
            d.this.o(output);
            h.n(h.f30441a, d.this.g(), null, 2, null);
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void b(File file, long j11) {
            String strA0;
            TmcLogger.c("RecorderClient", "Recorder onStopRecord");
            d.this.p(file);
            h hVar = h.f30441a;
            App appG = d.this.g();
            JsonObject jsonObject = new JsonObject();
            d dVar = d.this;
            if (file != null) {
                String appId = dVar.g().getAppId();
                Intrinsics.f(appId, "app.appId");
                strA0 = FileUtil.a0(appId, null, file, null, 8, null);
            } else {
                strA0 = null;
            }
            jsonObject.addProperty(NativeRequestBridge.KEY_TEMP_FILE_PATH, strA0);
            jsonObject.addProperty("duration", Long.valueOf(j11));
            jsonObject.addProperty("fileSize", file != null ? Long.valueOf(xb.b.d(file)) : null);
            Unit unit = Unit.f68710a;
            hVar.o(appG, jsonObject);
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void c() {
            TmcLogger.c("RecorderClient", "Recorder onResumeRecord");
            d.this.n();
            h.l(h.f30441a, d.this.g(), null, 2, null);
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void d() {
            TmcLogger.c("RecorderClient", "Recorder onPauseRecord");
            d.this.m();
            h.j(h.f30441a, d.this.g(), null, 2, null);
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void e(long j11, int i11) {
            TmcLogger.c("RecorderClient", "Recording onRecordProgress: mills: " + j11 + " amp: " + i11);
            if (j11 >= d.this.f30436c) {
                TmcLogger.c("RecorderClient", "Recording mills >= maxDuration: mills: " + j11 + " maxDuration: " + d.this.f30436c);
                d.this.v();
            }
        }

        @Override // com.cloud.tmc.integration.audio.recording.g
        public void onError(int i11, String str) {
            TmcLogger.c("RecorderClient", "Recorder onError: errorCode: " + i11 + " errorMsg: " + str);
            d.this.l(i11, str);
            h hVar = h.f30441a;
            App appG = d.this.g();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", str);
            Unit unit = Unit.f68710a;
            hVar.h(appG, jsonObject);
        }
    }

    public d(App app) {
        Intrinsics.g(app, "app");
        this.f30434a = app;
        this.f30435b = new ArrayList();
        this.f30436c = TTAdConstant.AD_MAX_EVENT_TIME;
        this.f30439f = new b();
    }

    public final App g() {
        return this.f30434a;
    }

    public final boolean h() {
        tb.b appContext = this.f30434a.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            return false;
        }
        boolean zV = h.f30441a.v(context, "android.permission.RECORD_AUDIO");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Recording audio permission is ");
        sb2.append(zV ? "granted" : "denied");
        TmcLogger.c("RecorderClient", sb2.toString());
        return zV;
    }

    public final boolean i() {
        f fVar = this.f30438e;
        return fVar != null && fVar.e();
    }

    public final boolean j() {
        f fVar = this.f30438e;
        return fVar != null && fVar.j();
    }

    public final boolean k() {
        f fVar = this.f30438e;
        return fVar != null && fVar.a();
    }

    public final void l(int i11, String str) {
        int size;
        if (!(!this.f30435b.isEmpty()) || (size = this.f30435b.size() - 1) < 0) {
            return;
        }
        while (true) {
            int i12 = size - 1;
            this.f30435b.get(size).onError(i11, str);
            if (i12 < 0) {
                return;
            } else {
                size = i12;
            }
        }
    }

    public final void m() {
        int size;
        if (!(!this.f30435b.isEmpty()) || (size = this.f30435b.size() - 1) < 0) {
            return;
        }
        while (true) {
            int i11 = size - 1;
            this.f30435b.get(size).b();
            if (i11 < 0) {
                return;
            } else {
                size = i11;
            }
        }
    }

    public final void n() {
        int size;
        if (!(!this.f30435b.isEmpty()) || (size = this.f30435b.size() - 1) < 0) {
            return;
        }
        while (true) {
            int i11 = size - 1;
            this.f30435b.get(size).c();
            if (i11 < 0) {
                return;
            } else {
                size = i11;
            }
        }
    }

    public final void o(File file) {
        int size;
        if (!(!this.f30435b.isEmpty()) || (size = this.f30435b.size() - 1) < 0) {
            return;
        }
        while (true) {
            int i11 = size - 1;
            this.f30435b.get(size).a(file);
            if (i11 < 0) {
                return;
            } else {
                size = i11;
            }
        }
    }

    public final void p(File file) {
        int size;
        if (!(!this.f30435b.isEmpty()) || (size = this.f30435b.size() - 1) < 0) {
            return;
        }
        while (true) {
            int i11 = size - 1;
            this.f30435b.get(size).d(file);
            if (i11 < 0) {
                return;
            } else {
                size = i11;
            }
        }
    }

    public final synchronized void q() {
        f fVar;
        if (!h()) {
            TmcLogger.c("RecorderClient", "pauseRecording: permission denied");
            return;
        }
        if (j() && (fVar = this.f30438e) != null) {
            fVar.g();
        }
    }

    public final synchronized void r() {
        f fVar;
        if (!h()) {
            TmcLogger.c("RecorderClient", "resumeRecording: permission denied");
            return;
        }
        if (i() && (fVar = this.f30438e) != null) {
            fVar.k();
        }
    }

    public final void s(long j11) {
        this.f30436c = j11;
    }

    public final void t(f fVar) {
        this.f30438e = fVar;
        if (fVar != null) {
            fVar.h(this.f30439f);
        }
    }

    public final synchronized void u(String filePath, int i11, int i12, int i13, int i14) {
        Intrinsics.g(filePath, "filePath");
        if (!h()) {
            TmcLogger.c("RecorderClient", "startRecording: permission denied");
            return;
        }
        if (k()) {
            this.f30437d = filePath;
            f fVar = this.f30438e;
            if (fVar != null) {
                fVar.i(filePath, i11, i12, i13, i14);
            }
        }
    }

    public final synchronized void v() {
        f fVar;
        if (!h()) {
            TmcLogger.c("RecorderClient", "stopRecording: permission denied");
            return;
        }
        if (!k() && (fVar = this.f30438e) != null) {
            fVar.f();
        }
    }
}
