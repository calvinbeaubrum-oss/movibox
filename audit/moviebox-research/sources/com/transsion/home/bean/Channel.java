package com.transsion.home.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Channel implements Serializable {
    public static final int $stable = 8;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("items")
    private final List<Item> items;
    private LayoutStyle style;

    @SerializedName("subjectType")
    private final int subjectType;

    public Channel(List<Item> list, int i11, String str, String str2, LayoutStyle layoutStyle) {
        this.items = list;
        this.subjectType = i11;
        this.channelId = str;
        this.channelName = str2;
        this.style = layoutStyle;
    }

    public /* synthetic */ Channel(List list, int i11, String str, String str2, LayoutStyle layoutStyle, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i11, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : layoutStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Channel copy$default(Channel channel, List list, int i11, String str, String str2, LayoutStyle layoutStyle, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = channel.items;
        }
        if ((i12 & 2) != 0) {
            i11 = channel.subjectType;
        }
        int i13 = i11;
        if ((i12 & 4) != 0) {
            str = channel.channelId;
        }
        String str3 = str;
        if ((i12 & 8) != 0) {
            str2 = channel.channelName;
        }
        String str4 = str2;
        if ((i12 & 16) != 0) {
            layoutStyle = channel.style;
        }
        return channel.copy(list, i13, str3, str4, layoutStyle);
    }

    public final List<Item> component1() {
        return this.items;
    }

    public final int component2() {
        return this.subjectType;
    }

    public final String component3() {
        return this.channelId;
    }

    public final String component4() {
        return this.channelName;
    }

    public final LayoutStyle component5() {
        return this.style;
    }

    public final Channel copy(List<Item> list, int i11, String str, String str2, LayoutStyle layoutStyle) {
        return new Channel(list, i11, str, str2, layoutStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) obj;
        return Intrinsics.b(this.items, channel.items) && this.subjectType == channel.subjectType && Intrinsics.b(this.channelId, channel.channelId) && Intrinsics.b(this.channelName, channel.channelName) && Intrinsics.b(this.style, channel.style);
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final LayoutStyle getStyle() {
        return this.style;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        List<Item> list = this.items;
        int iHashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.subjectType) * 31;
        String str = this.channelId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        LayoutStyle layoutStyle = this.style;
        return iHashCode3 + (layoutStyle != null ? layoutStyle.hashCode() : 0);
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final void setStyle(LayoutStyle layoutStyle) {
        this.style = layoutStyle;
    }

    public String toString() {
        return "Channel(items=" + this.items + ", subjectType=" + this.subjectType + ", channelId=" + this.channelId + ", channelName=" + this.channelName + ", style=" + this.style + ")";
    }
}
