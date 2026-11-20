package com.transsion.home.bean;

import androidx.annotation.Keep;
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
public final class HonorBackground {
    public static final int $stable = 0;
    private final String center;
    private final String end;
    private final String start;

    public HonorBackground() {
        this(null, null, null, 7, null);
    }

    public HonorBackground(String str, String str2, String str3) {
        this.start = str;
        this.center = str2;
        this.end = str3;
    }

    public /* synthetic */ HonorBackground(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ HonorBackground copy$default(HonorBackground honorBackground, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = honorBackground.start;
        }
        if ((i11 & 2) != 0) {
            str2 = honorBackground.center;
        }
        if ((i11 & 4) != 0) {
            str3 = honorBackground.end;
        }
        return honorBackground.copy(str, str2, str3);
    }

    public final String component1() {
        return this.start;
    }

    public final String component2() {
        return this.center;
    }

    public final String component3() {
        return this.end;
    }

    public final HonorBackground copy(String str, String str2, String str3) {
        return new HonorBackground(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HonorBackground)) {
            return false;
        }
        HonorBackground honorBackground = (HonorBackground) obj;
        return Intrinsics.b(this.start, honorBackground.start) && Intrinsics.b(this.center, honorBackground.center) && Intrinsics.b(this.end, honorBackground.end);
    }

    public final String getCenter() {
        return this.center;
    }

    public final String getEnd() {
        return this.end;
    }

    public final String getStart() {
        return this.start;
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.center;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.end;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "HonorBackground(start=" + this.start + ", center=" + this.center + ", end=" + this.end + ")";
    }
}
