package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class MeHistoryInfo implements Serializable {
    private List<VideoDetailPlayBean> list;

    public MeHistoryInfo(List<VideoDetailPlayBean> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MeHistoryInfo copy$default(MeHistoryInfo meHistoryInfo, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = meHistoryInfo.list;
        }
        return meHistoryInfo.copy(list);
    }

    public final List<VideoDetailPlayBean> component1() {
        return this.list;
    }

    public final MeHistoryInfo copy(List<VideoDetailPlayBean> list) {
        return new MeHistoryInfo(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MeHistoryInfo) && Intrinsics.b(this.list, ((MeHistoryInfo) obj).list);
    }

    public final List<VideoDetailPlayBean> getList() {
        return this.list;
    }

    public int hashCode() {
        List<VideoDetailPlayBean> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setList(List<VideoDetailPlayBean> list) {
        this.list = list;
    }

    public String toString() {
        return "MeHistoryInfo(list=" + this.list + ")";
    }
}
