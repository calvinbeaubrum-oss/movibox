package com.cloud.tmc.ad.bean.response;

import java.io.Serializable;
import kotlin.Metadata;
import rc.b;

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
public final class ViewJson extends b {
    private DialogJson dialogJson;
    private Integer dialogType;
    private String formPath;
    private OfflineJson offline;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DialogJson implements Serializable {
        private String height;
        private String url;

        public final String getHeight() {
            return this.height;
        }

        public final String getUrl() {
            String str = this.url;
            return str == null ? "" : str;
        }

        public final void setHeight(String str) {
            this.height = str;
        }

        public final void setUrl(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class OfflineJson implements Serializable {
        private Integer maxShowPPPD;
        private String res;
        private String zipRes;

        public final Integer getMaxShowPPPD() {
            Integer num = this.maxShowPPPD;
            if (num == null) {
                return 0;
            }
            return num;
        }

        public final String getRes() {
            String str = this.res;
            return str == null ? "" : str;
        }

        public final String getZipRes() {
            String str = this.zipRes;
            return str == null ? "" : str;
        }

        public final void setMaxShowPPPD(Integer num) {
            this.maxShowPPPD = num;
        }

        public final void setRes(String str) {
            this.res = str;
        }

        public final void setZipRes(String str) {
            this.zipRes = str;
        }
    }

    public final DialogJson getDialogJson() {
        return this.dialogJson;
    }

    public final Integer getDialogType() {
        Integer num = this.dialogType;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public final String getFormPath() {
        return this.formPath;
    }

    public final OfflineJson getOffline() {
        return this.offline;
    }

    public final void setDialogJson(DialogJson dialogJson) {
        this.dialogJson = dialogJson;
    }

    public final void setDialogType(Integer num) {
        this.dialogType = num;
    }

    public final void setFormPath(String str) {
        this.formPath = str;
    }

    public final void setOffline(OfflineJson offlineJson) {
        this.offline = offlineJson;
    }
}
