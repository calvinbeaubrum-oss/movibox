package com.transsion.usercenter.profile.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ButtonInfo implements Serializable {
    private String link;
    private String text;
    private String type;

    public ButtonInfo(String str, String str2, String str3) {
        this.type = str;
        this.text = str2;
        this.link = str3;
    }

    public static /* synthetic */ ButtonInfo copy$default(ButtonInfo buttonInfo, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = buttonInfo.type;
        }
        if ((i11 & 2) != 0) {
            str2 = buttonInfo.text;
        }
        if ((i11 & 4) != 0) {
            str3 = buttonInfo.link;
        }
        return buttonInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.link;
    }

    public final ButtonInfo copy(String str, String str2, String str3) {
        return new ButtonInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonInfo)) {
            return false;
        }
        ButtonInfo buttonInfo = (ButtonInfo) obj;
        return Intrinsics.b(this.type, buttonInfo.type) && Intrinsics.b(this.text, buttonInfo.text) && Intrinsics.b(this.link, buttonInfo.link);
    }

    public final String getLink() {
        return this.link;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ButtonInfo(type=" + this.type + ", text=" + this.text + ", link=" + this.link + ")";
    }
}
