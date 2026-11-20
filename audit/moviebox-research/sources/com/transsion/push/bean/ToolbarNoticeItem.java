package com.transsion.push.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ToolbarNoticeItem implements Serializable {
    private final String cover;
    private final String deeplink;
    private transient boolean isDefault;
    private final String text;

    public ToolbarNoticeItem() {
        this(null, null, null, 7, null);
    }

    public ToolbarNoticeItem(String str, String str2, String str3) {
        this.cover = str;
        this.text = str2;
        this.deeplink = str3;
    }

    public /* synthetic */ ToolbarNoticeItem(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ ToolbarNoticeItem copy$default(ToolbarNoticeItem toolbarNoticeItem, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = toolbarNoticeItem.cover;
        }
        if ((i11 & 2) != 0) {
            str2 = toolbarNoticeItem.text;
        }
        if ((i11 & 4) != 0) {
            str3 = toolbarNoticeItem.deeplink;
        }
        return toolbarNoticeItem.copy(str, str2, str3);
    }

    public final String component1() {
        return this.cover;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.deeplink;
    }

    public final ToolbarNoticeItem copy(String str, String str2, String str3) {
        return new ToolbarNoticeItem(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToolbarNoticeItem)) {
            return false;
        }
        ToolbarNoticeItem toolbarNoticeItem = (ToolbarNoticeItem) obj;
        return Intrinsics.b(this.cover, toolbarNoticeItem.cover) && Intrinsics.b(this.text, toolbarNoticeItem.text) && Intrinsics.b(this.deeplink, toolbarNoticeItem.deeplink);
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.cover;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deeplink;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final void setDefault(boolean z11) {
        this.isDefault = z11;
    }

    public String toString() {
        return "ToolbarNoticeItem(cover=" + this.cover + ", text=" + this.text + ", deeplink=" + this.deeplink + ")";
    }
}
