package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xu.c;

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
public final class ShortTVFavInfo implements Serializable {
    private String favoriteNum;
    private final String favoriteTime;
    private boolean hasFavorite;

    public ShortTVFavInfo() {
        this(null, false, null, 7, null);
    }

    public ShortTVFavInfo(String str, boolean z11, String str2) {
        this.favoriteNum = str;
        this.hasFavorite = z11;
        this.favoriteTime = str2;
    }

    public /* synthetic */ ShortTVFavInfo(String str, boolean z11, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ ShortTVFavInfo copy$default(ShortTVFavInfo shortTVFavInfo, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shortTVFavInfo.favoriteNum;
        }
        if ((i11 & 2) != 0) {
            z11 = shortTVFavInfo.hasFavorite;
        }
        if ((i11 & 4) != 0) {
            str2 = shortTVFavInfo.favoriteTime;
        }
        return shortTVFavInfo.copy(str, z11, str2);
    }

    public final String component1() {
        return this.favoriteNum;
    }

    public final boolean component2() {
        return this.hasFavorite;
    }

    public final String component3() {
        return this.favoriteTime;
    }

    public final ShortTVFavInfo copy(String str, boolean z11, String str2) {
        return new ShortTVFavInfo(str, z11, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(ShortTVFavInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.ShortTVFavInfo");
        ShortTVFavInfo shortTVFavInfo = (ShortTVFavInfo) obj;
        return Intrinsics.b(this.favoriteNum, shortTVFavInfo.favoriteNum) && this.hasFavorite == shortTVFavInfo.hasFavorite && Intrinsics.b(this.favoriteTime, shortTVFavInfo.favoriteTime);
    }

    public final String getFavoriteNum() {
        return this.favoriteNum;
    }

    public final String getFavoriteTime() {
        return this.favoriteTime;
    }

    public final boolean getHasFavorite() {
        return this.hasFavorite;
    }

    public int hashCode() {
        String str = this.favoriteNum;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + c.a(this.hasFavorite)) * 31;
        String str2 = this.favoriteTime;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setFavoriteNum(String str) {
        this.favoriteNum = str;
    }

    public final void setHasFavorite(boolean z11) {
        this.hasFavorite = z11;
    }

    public String toString() {
        return "ShortTVFavInfo(favoriteNum=" + this.favoriteNum + ", hasFavorite=" + this.hasFavorite + ", favoriteTime=" + this.favoriteTime + ")";
    }

    public final void update(j00.c cVar) {
        int i11;
        if (cVar == null) {
            return;
        }
        String strB = cVar.b();
        try {
            String str = this.favoriteNum;
            i11 = str != null ? Integer.parseInt(str) : 0;
        } catch (Exception unused) {
        }
        if (strB == null) {
            if (!cVar.a() || this.hasFavorite) {
                strB = (cVar.a() || !this.hasFavorite) ? this.favoriteNum : String.valueOf(Math.max(0, i11 - 1));
            } else {
                strB = String.valueOf(i11 + 1);
            }
        }
        this.favoriteNum = strB;
        this.hasFavorite = cVar.a();
    }
}
