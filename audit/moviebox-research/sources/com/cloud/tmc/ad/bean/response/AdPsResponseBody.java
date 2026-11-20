package com.cloud.tmc.ad.bean.response;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cloud.tmc.ad.bean.AdImage;
import java.io.Serializable;
import java.math.BigDecimal;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdPsResponseBody implements Serializable {
    private int code;
    private DataDTO data;
    private String message;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DataDTO implements Serializable {
        private List<String> gpLinkList;
        private List<PsLinkListDTO> psLinkList;

        public final List<String> getGpLinkList() {
            return this.gpLinkList;
        }

        public final List<PsLinkListDTO> getPsLinkList() {
            return this.psLinkList;
        }

        public final void setGpLinkList(List<String> list) {
            this.gpLinkList = list;
        }

        public final void setPsLinkList(List<PsLinkListDTO> list) {
            this.psLinkList = list;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class PsLinkListDTO implements Serializable {
        private String appName;
        private String dpLink;
        private String icon;
        private final AdImage image;
        private long size;
        private String star;

        public final String getAppName() {
            return this.appName;
        }

        public final String getDpLink() {
            return this.dpLink;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getSize() {
            BigDecimal bigDecimalDivide = new BigDecimal(this.size).divide(BigDecimal.valueOf(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED), 1, 4);
            Intrinsics.f(bigDecimalDivide, "size_new.divide(BigDecim…BigDecimal.ROUND_HALF_UP)");
            return bigDecimalDivide.toString() + "MB";
        }

        public final String getStar() {
            return this.star;
        }

        public final void setAppName(String str) {
            this.appName = str;
        }

        public final void setDpLink(String str) {
            this.dpLink = str;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final void setSize(long j11) {
            this.size = j11;
        }

        public final void setStar(String str) {
            this.star = str;
        }
    }

    public final int getCode() {
        return this.code;
    }

    public final DataDTO getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(int i11) {
        this.code = i11;
    }

    public final void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
