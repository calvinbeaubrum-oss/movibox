package com.transsnet.downloader.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.t0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import java.util.concurrent.CopyOnWriteArrayList;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class a extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f61271a = new CopyOnWriteArrayList<>();

    public final DownloadBean b(d video) {
        Intrinsics.g(video, "video");
        c cVar = c.f61276a;
        String strK = cVar.k(video);
        if (TextUtils.isEmpty(strK)) {
            this.f61271a.add(video);
        }
        String strE = video.e();
        String str = strE == null ? "" : strE;
        String strE2 = video.e();
        String strD = video.d();
        String strE3 = video.e();
        if (strE3 == null) {
            strE3 = "";
        }
        long jG = cVar.g(strE3);
        String strE4 = video.e();
        Long lA = video.a();
        String strE5 = video.e();
        return new DownloadBean(str, strE2, strD, strK, Long.valueOf(jG), null, null, strE4, lA, Long.valueOf(cVar.f(strE5 != null ? strE5 : "")), 0L, 0, 0, 2, 0L, 0L, 1, 0, 0, 0, 0, 0, 0, video.f(), video.b(), 0, 0, null, null, null, null, 0L, 2, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 108789760, 1073741822, null);
    }

    public final HistoricalPlayRecordBean c(DownloadBean createDownload) {
        Intrinsics.g(createDownload, "createDownload");
        Long updateTimeStamp = createDownload.getUpdateTimeStamp();
        Long updateTimeStamp2 = createDownload.getUpdateTimeStamp();
        String strH = TimeUtilKt.h(updateTimeStamp2 != null ? updateTimeStamp2.longValue() : 0L);
        c cVar = c.f61276a;
        Long updateTimeStamp3 = createDownload.getUpdateTimeStamp();
        return new HistoricalPlayRecordBean(2, updateTimeStamp, strH, cVar.E(updateTimeStamp3 != null ? updateTimeStamp3.longValue() : 0L), null, createDownload, null, null, PsExtractor.AUDIO_STREAM, null);
    }

    public final CopyOnWriteArrayList<d> d() {
        return this.f61271a;
    }
}
