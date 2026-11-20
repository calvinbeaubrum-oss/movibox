package com.transsnet.downloader.bean;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class HistoricalPlayRecordMultipleEntity implements Serializable, e9.a {
    public static final a Companion = new a(null);
    public static final int ITEM_TYPE_AD = 3;
    public static final int ITEM_TYPE_CONTENT = 2;
    public static final int ITEM_TYPE_HEADER = 1;
    private HistoricalPlayRecordBean historical;
    private boolean isCheck;
    private boolean isSeriesAllCheck;
    private c nonAdDelegate;
    private final List<HistoricalPlayRecordMultipleEntity> seriesList;
    private String title;
    private int type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HistoricalPlayRecordMultipleEntity(int i11, HistoricalPlayRecordBean historicalPlayRecordBean, String str, c cVar) {
        this.type = i11;
        this.historical = historicalPlayRecordBean;
        this.title = str;
        this.nonAdDelegate = cVar;
        this.isSeriesAllCheck = true;
        this.seriesList = new ArrayList();
    }

    public /* synthetic */ HistoricalPlayRecordMultipleEntity(int i11, HistoricalPlayRecordBean historicalPlayRecordBean, String str, c cVar, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : historicalPlayRecordBean, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? null : cVar);
    }

    public static /* synthetic */ HistoricalPlayRecordMultipleEntity copy$default(HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity, int i11, HistoricalPlayRecordBean historicalPlayRecordBean, String str, c cVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = historicalPlayRecordMultipleEntity.type;
        }
        if ((i12 & 2) != 0) {
            historicalPlayRecordBean = historicalPlayRecordMultipleEntity.historical;
        }
        if ((i12 & 4) != 0) {
            str = historicalPlayRecordMultipleEntity.title;
        }
        if ((i12 & 8) != 0) {
            cVar = historicalPlayRecordMultipleEntity.nonAdDelegate;
        }
        return historicalPlayRecordMultipleEntity.copy(i11, historicalPlayRecordBean, str, cVar);
    }

    public final int component1() {
        return this.type;
    }

    public final HistoricalPlayRecordBean component2() {
        return this.historical;
    }

    public final String component3() {
        return this.title;
    }

    public final c component4() {
        return this.nonAdDelegate;
    }

    public final HistoricalPlayRecordMultipleEntity copy(int i11, HistoricalPlayRecordBean historicalPlayRecordBean, String str, c cVar) {
        return new HistoricalPlayRecordMultipleEntity(i11, historicalPlayRecordBean, str, cVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoricalPlayRecordMultipleEntity)) {
            return false;
        }
        HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity = (HistoricalPlayRecordMultipleEntity) obj;
        return this.type == historicalPlayRecordMultipleEntity.type && Intrinsics.b(this.historical, historicalPlayRecordMultipleEntity.historical) && Intrinsics.b(this.title, historicalPlayRecordMultipleEntity.title) && Intrinsics.b(this.nonAdDelegate, historicalPlayRecordMultipleEntity.nonAdDelegate);
    }

    public final HistoricalPlayRecordBean getHistorical() {
        return this.historical;
    }

    @Override // e9.a
    public int getItemType() {
        return this.type;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final List<HistoricalPlayRecordMultipleEntity> getSeriesList() {
        return this.seriesList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i11 = this.type * 31;
        HistoricalPlayRecordBean historicalPlayRecordBean = this.historical;
        int iHashCode = (i11 + (historicalPlayRecordBean == null ? 0 : historicalPlayRecordBean.hashCode())) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        c cVar = this.nonAdDelegate;
        return iHashCode2 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final boolean isSeriesAllCheck() {
        return this.isSeriesAllCheck;
    }

    public final void setCheck(boolean z11) {
        this.isCheck = z11;
    }

    public final void setHistorical(HistoricalPlayRecordBean historicalPlayRecordBean) {
        this.historical = historicalPlayRecordBean;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setSeriesAllCheck(boolean z11) {
        this.isSeriesAllCheck = z11;
    }

    public final void setSeriesDownloadBean2Entity() {
        DownloadBean video;
        List<DownloadBean> seriesList;
        this.seriesList.clear();
        HistoricalPlayRecordBean historicalPlayRecordBean = this.historical;
        if (historicalPlayRecordBean == null || (video = historicalPlayRecordBean.getVideo()) == null || (seriesList = video.getSeriesList()) == null) {
            return;
        }
        for (DownloadBean downloadBean : seriesList) {
            this.seriesList.add(new HistoricalPlayRecordMultipleEntity(2, new HistoricalPlayRecordBean(downloadBean.getType(), Long.valueOf(downloadBean.getLastPlayTimeStamp()), TimeUtilKt.h(downloadBean.getLastPlayTimeStamp()), com.transsnet.downloader.viewmodel.c.f61276a.E(downloadBean.getLastPlayTimeStamp()), null, downloadBean, null, null, PsExtractor.AUDIO_STREAM, null), null, null, 12, null));
        }
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "HistoricalPlayRecordMultipleEntity(type=" + this.type + ", historical=" + this.historical + ", title=" + this.title + ", nonAdDelegate=" + this.nonAdDelegate + ")";
    }
}
