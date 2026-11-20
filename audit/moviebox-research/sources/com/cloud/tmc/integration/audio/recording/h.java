package com.cloud.tmc.integration.audio.recording;

import android.content.Context;
import com.cloud.tmc.integration.model.AudioRecordCache;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.miniutils.util.j;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f30441a = new h();

    public static /* synthetic */ void j(h hVar, App app, JsonObject jsonObject, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jsonObject = new JsonObject();
        }
        hVar.i(app, jsonObject);
    }

    public static /* synthetic */ void l(h hVar, App app, JsonObject jsonObject, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jsonObject = new JsonObject();
        }
        hVar.k(app, jsonObject);
    }

    public static /* synthetic */ void n(h hVar, App app, JsonObject jsonObject, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jsonObject = new JsonObject();
        }
        hVar.m(app, jsonObject);
    }

    public final boolean a(String key) {
        Intrinsics.g(key, "key");
        return p().contains(key);
    }

    public final boolean b(int i11) {
        return q().contains(Integer.valueOf(i11));
    }

    public final boolean c(int i11, int i12) {
        return i12 <= t(i11) && u(i11) <= i12;
    }

    public final boolean d(String recordingFormat) {
        Intrinsics.g(recordingFormat, "recordingFormat");
        return r().contains(recordingFormat);
    }

    public final boolean e(int i11) {
        return s().contains(Integer.valueOf(i11));
    }

    public final int f(String key) {
        Intrinsics.g(key, "key");
        return Intrinsics.b(key, "camcorder") ? 5 : 1;
    }

    public final d g(App app, String recordingFormat) throws IllegalArgumentException {
        Intrinsics.g(app, "app");
        Intrinsics.g(recordingFormat, "recordingFormat");
        f fVarW = w(recordingFormat);
        d dVar = new d(app);
        dVar.t(fVarW);
        return dVar;
    }

    public final void h(App app, JsonObject jsonObject) {
        Intrinsics.g(app, "app");
        Intrinsics.g(jsonObject, "jsonObject");
        bc.a aVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnErrors().get(app.getAppId());
        if (aVar != null) {
            aVar.a(jsonObject);
        }
    }

    public final void i(App app, JsonObject jsonObject) {
        Intrinsics.g(app, "app");
        Intrinsics.g(jsonObject, "jsonObject");
        bc.a aVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnPauses().get(app.getAppId());
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    public final void k(App app, JsonObject jsonObject) {
        Intrinsics.g(app, "app");
        Intrinsics.g(jsonObject, "jsonObject");
        bc.a aVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnResumes().get(app.getAppId());
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    public final void m(App app, JsonObject jsonObject) {
        Intrinsics.g(app, "app");
        Intrinsics.g(jsonObject, "jsonObject");
        bc.a aVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnStarts().get(app.getAppId());
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    public final void o(App app, JsonObject jsonObject) {
        Intrinsics.g(app, "app");
        Intrinsics.g(jsonObject, "jsonObject");
        bc.a aVar = ((AudioRecordCache) app.getData(AudioRecordCache.class, true)).getOnStops().get(app.getAppId());
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    public final List<String> p() {
        return kotlin.collections.g.q("auto", "mic", "camcorder");
    }

    public final List<Integer> q() {
        return kotlin.collections.g.q(1, 2);
    }

    public final List<String> r() {
        return kotlin.collections.g.q("aac");
    }

    public final List<Integer> s() {
        return kotlin.collections.g.q(8000, 11025, 12000, 16000, 22050, 24000, 32000, 44100, 48000);
    }

    public final int t(int i11) {
        if (i11 == 8000 || i11 == 11025) {
            return 48000;
        }
        if (i11 == 12000) {
            return 64000;
        }
        if (i11 == 16000) {
            return 96000;
        }
        if (i11 == 22050 || i11 == 24000) {
            return 128000;
        }
        if (i11 != 32000) {
            return (i11 == 44100 || i11 == 48000) ? 320000 : 0;
        }
        return 192000;
    }

    public final int u(int i11) {
        if (i11 == 8000 || i11 == 11025) {
            return 16000;
        }
        if (i11 == 12000 || i11 == 16000) {
            return 24000;
        }
        if (i11 == 22050 || i11 == 24000) {
            return 32000;
        }
        if (i11 != 32000) {
            return (i11 == 44100 || i11 == 48000) ? 64000 : 0;
        }
        return 48000;
    }

    public final boolean v(Context context, String permission) {
        Intrinsics.g(context, "context");
        Intrinsics.g(permission, "permission");
        return z2.a.checkSelfPermission(context, permission) == 0;
    }

    public final f w(String str) throws IllegalArgumentException {
        if (Intrinsics.b(str, "aac") || Intrinsics.b(str, "m4a")) {
            return new c();
        }
        throw new IllegalArgumentException("Unknown recording format");
    }

    public final File x(App app, String recordingFormat) throws IllegalArgumentException {
        Intrinsics.g(app, "app");
        Intrinsics.g(recordingFormat, "recordingFormat");
        if (!Intrinsics.b(recordingFormat, "aac") && !Intrinsics.b(recordingFormat, "m4a")) {
            throw new IllegalArgumentException("Unknown recording format");
        }
        File fileW = FileUtil.w(app, "recorder" + File.separator + FileUtil.f(FileUtil.y(), "m4a"));
        if (!j.g(fileW)) {
            return null;
        }
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        FileUtil.a0(appId, null, fileW, null, 8, null);
        return fileW;
    }
}
