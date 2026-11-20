package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class ExplainBean implements Serializable {
    private final String color;
    private final String deeplink;
    private final String text;
    private final String type;

    public ExplainBean(String str, String str2, String str3, String str4) {
        this.text = str;
        this.color = str2;
        this.type = str3;
        this.deeplink = str4;
    }

    public static /* synthetic */ ExplainBean copy$default(ExplainBean explainBean, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = explainBean.text;
        }
        if ((i11 & 2) != 0) {
            str2 = explainBean.color;
        }
        if ((i11 & 4) != 0) {
            str3 = explainBean.type;
        }
        if ((i11 & 8) != 0) {
            str4 = explainBean.deeplink;
        }
        return explainBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.color;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.deeplink;
    }

    public final ExplainBean copy(String str, String str2, String str3, String str4) {
        return new ExplainBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExplainBean)) {
            return false;
        }
        ExplainBean explainBean = (ExplainBean) obj;
        return Intrinsics.b(this.text, explainBean.text) && Intrinsics.b(this.color, explainBean.color) && Intrinsics.b(this.type, explainBean.type) && Intrinsics.b(this.deeplink, explainBean.deeplink);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.color;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deeplink;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ExplainBean(text=" + this.text + ", color=" + this.color + ", type=" + this.type + ", deeplink=" + this.deeplink + ")";
    }
}
