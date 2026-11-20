package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class DubsInfo implements Serializable {
    private transient boolean isSelected;
    private transient boolean isSubtitle;
    private final String lanCode;
    private final String lanName;
    private final boolean original;
    private final String subjectId;

    public DubsInfo() {
        this(null, null, null, false, 15, null);
    }

    public DubsInfo(String str, String str2, String str3, boolean z11) {
        this.subjectId = str;
        this.lanName = str2;
        this.lanCode = str3;
        this.original = z11;
    }

    public /* synthetic */ DubsInfo(String str, String str2, String str3, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? false : z11);
    }

    public static /* synthetic */ DubsInfo copy$default(DubsInfo dubsInfo, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dubsInfo.subjectId;
        }
        if ((i11 & 2) != 0) {
            str2 = dubsInfo.lanName;
        }
        if ((i11 & 4) != 0) {
            str3 = dubsInfo.lanCode;
        }
        if ((i11 & 8) != 0) {
            z11 = dubsInfo.original;
        }
        return dubsInfo.copy(str, str2, str3, z11);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component2() {
        return this.lanName;
    }

    public final String component3() {
        return this.lanCode;
    }

    public final boolean component4() {
        return this.original;
    }

    public final DubsInfo copy(String str, String str2, String str3, boolean z11) {
        return new DubsInfo(str, str2, str3, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DubsInfo)) {
            return false;
        }
        DubsInfo dubsInfo = (DubsInfo) obj;
        return Intrinsics.b(this.subjectId, dubsInfo.subjectId) && Intrinsics.b(this.lanName, dubsInfo.lanName) && Intrinsics.b(this.lanCode, dubsInfo.lanCode) && this.original == dubsInfo.original;
    }

    public final String getLanCode() {
        return this.lanCode;
    }

    public final String getLanName() {
        return this.lanName;
    }

    public final boolean getOriginal() {
        return this.original;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lanName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lanCode;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z11 = this.original;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode3 + r11;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isSubtitle() {
        return this.isSubtitle;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public final void setSubtitle(boolean z11) {
        this.isSubtitle = z11;
    }

    public String toString() {
        return "DubsInfo(subjectId=" + this.subjectId + ", lanName=" + this.lanName + ", lanCode=" + this.lanCode + ", original=" + this.original + ")";
    }
}
