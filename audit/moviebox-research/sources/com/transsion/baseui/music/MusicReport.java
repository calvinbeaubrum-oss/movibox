package com.transsion.baseui.music;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class MusicReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MusicReport f51422a = new MusicReport();

    public final List<k> b() {
        String string = RoomAppMMKV.f51271a.a().getString("music_play_duration", "");
        if (TextUtils.isEmpty(string)) {
            return new ArrayList();
        }
        Type type = new TypeToken<List<k>>() { // from class: com.transsion.baseui.music.MusicReport$getLocalHistoryList$personListType$1
        }.getType();
        Intrinsics.f(type, "object : TypeToken<Mutab…yDurationBean>>() {}.type");
        Object objE = n.e(string, type);
        Intrinsics.f(objE, "{\n            val person…personListType)\n        }");
        return (List) objE;
    }

    public final void c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            List<k> listB = f51422a.b();
            if (listB.isEmpty()) {
                return;
            }
            for (k kVar : listB) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("subject_id", String.valueOf(kVar.h()));
                linkedHashMap.put("trace_id", String.valueOf(kVar.d()));
                linkedHashMap.put("ops", String.valueOf(kVar.e()));
                linkedHashMap.put("play_duration", String.valueOf(kVar.f()));
                linkedHashMap.put("total_duration", String.valueOf(kVar.i()));
                linkedHashMap.put("video_bitrate", String.valueOf(kVar.j()));
                linkedHashMap.put("audio_bitrate", String.valueOf(kVar.a()));
                linkedHashMap.put("float_play_duration", String.valueOf(kVar.b()));
                linkedHashMap.put("in_bg_play_duration", String.valueOf(kVar.c()));
                m.f51277a.w("music_play", "music_play", kVar.f(), linkedHashMap);
                com.transsion.player.mediasession.d.f54622a.a("MusicReport --> report() --> 上报播放时长 = " + linkedHashMap);
                RoomAppMMKV.f51271a.a().remove("music_play_duration");
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.player.mediasession.d.f54622a.b("MusicReport --> report() --> it = " + thM166exceptionOrNullimpl);
    }

    public final void d(k musicPlayDurationBean) {
        Intrinsics.g(musicPlayDurationBean, "musicPlayDurationBean");
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new MusicReport$saveLocal$1(musicPlayDurationBean, null), 3, null);
    }
}
