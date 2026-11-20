package com.transsion.push.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ToolbarNoticeConfig implements Serializable {
    private final int days;
    private final List<ToolbarNoticeItem> list;

    /* JADX WARN: Multi-variable type inference failed */
    public ToolbarNoticeConfig() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public ToolbarNoticeConfig(int i11, List<ToolbarNoticeItem> list) {
        this.days = i11;
        this.list = list;
    }

    public /* synthetic */ ToolbarNoticeConfig(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 3 : i11, (i12 & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolbarNoticeConfig copy$default(ToolbarNoticeConfig toolbarNoticeConfig, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = toolbarNoticeConfig.days;
        }
        if ((i12 & 2) != 0) {
            list = toolbarNoticeConfig.list;
        }
        return toolbarNoticeConfig.copy(i11, list);
    }

    public final int component1() {
        return this.days;
    }

    public final List<ToolbarNoticeItem> component2() {
        return this.list;
    }

    public final ToolbarNoticeConfig copy(int i11, List<ToolbarNoticeItem> list) {
        return new ToolbarNoticeConfig(i11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToolbarNoticeConfig)) {
            return false;
        }
        ToolbarNoticeConfig toolbarNoticeConfig = (ToolbarNoticeConfig) obj;
        return this.days == toolbarNoticeConfig.days && Intrinsics.b(this.list, toolbarNoticeConfig.list);
    }

    public final int getDays() {
        return this.days;
    }

    public final List<ToolbarNoticeItem> getList() {
        return this.list;
    }

    public int hashCode() {
        int i11 = this.days * 31;
        List<ToolbarNoticeItem> list = this.list;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "ToolbarNoticeConfig(days=" + this.days + ", list=" + this.list + ")";
    }
}
