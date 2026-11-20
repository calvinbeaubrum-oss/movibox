package com.transsion.baselib.db.consume;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
@Keep
@Metadata
public final class ConsumeBean implements Serializable {
    private int appVersion;
    private String consumeJson;
    private int dataType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f51067id;
    private long updateTimeStamp;

    public ConsumeBean(int i11, long j11, int i12, int i13, String str) {
        this.f51067id = i11;
        this.updateTimeStamp = j11;
        this.dataType = i12;
        this.appVersion = i13;
        this.consumeJson = str;
    }

    public /* synthetic */ ConsumeBean(int i11, long j11, int i12, int i13, String str, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : i11, j11, i12, i13, (i14 & 16) != 0 ? "" : str);
    }

    public static /* synthetic */ ConsumeBean copy$default(ConsumeBean consumeBean, int i11, long j11, int i12, int i13, String str, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = consumeBean.f51067id;
        }
        if ((i14 & 2) != 0) {
            j11 = consumeBean.updateTimeStamp;
        }
        long j12 = j11;
        if ((i14 & 4) != 0) {
            i12 = consumeBean.dataType;
        }
        int i15 = i12;
        if ((i14 & 8) != 0) {
            i13 = consumeBean.appVersion;
        }
        int i16 = i13;
        if ((i14 & 16) != 0) {
            str = consumeBean.consumeJson;
        }
        return consumeBean.copy(i11, j12, i15, i16, str);
    }

    public final int component1() {
        return this.f51067id;
    }

    public final long component2() {
        return this.updateTimeStamp;
    }

    public final int component3() {
        return this.dataType;
    }

    public final int component4() {
        return this.appVersion;
    }

    public final String component5() {
        return this.consumeJson;
    }

    public final ConsumeBean copy(int i11, long j11, int i12, int i13, String str) {
        return new ConsumeBean(i11, j11, i12, i13, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsumeBean)) {
            return false;
        }
        ConsumeBean consumeBean = (ConsumeBean) obj;
        return this.f51067id == consumeBean.f51067id && this.updateTimeStamp == consumeBean.updateTimeStamp && this.dataType == consumeBean.dataType && this.appVersion == consumeBean.appVersion && Intrinsics.b(this.consumeJson, consumeBean.consumeJson);
    }

    public final int getAppVersion() {
        return this.appVersion;
    }

    public final String getConsumeJson() {
        return this.consumeJson;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final int getId() {
        return this.f51067id;
    }

    public final long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public int hashCode() {
        int iA = ((((((this.f51067id * 31) + p.a(this.updateTimeStamp)) * 31) + this.dataType) * 31) + this.appVersion) * 31;
        String str = this.consumeJson;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final void setAppVersion(int i11) {
        this.appVersion = i11;
    }

    public final void setConsumeJson(String str) {
        this.consumeJson = str;
    }

    public final void setDataType(int i11) {
        this.dataType = i11;
    }

    public final void setId(int i11) {
        this.f51067id = i11;
    }

    public final void setUpdateTimeStamp(long j11) {
        this.updateTimeStamp = j11;
    }

    public String toString() {
        return "ConsumeBean(id=" + this.f51067id + ", updateTimeStamp=" + this.updateTimeStamp + ", dataType=" + this.dataType + ", appVersion=" + this.appVersion + ", consumeJson=" + this.consumeJson + ")";
    }
}
