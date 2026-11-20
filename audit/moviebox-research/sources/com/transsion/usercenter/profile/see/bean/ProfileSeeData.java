package com.transsion.usercenter.profile.see.bean;

import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.bean.Pager;
import java.io.Serializable;
import java.util.List;
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
@Metadata
public final class ProfileSeeData implements Serializable {

    @SerializedName("items")
    private final List<ProfileSeeItem> items;

    @SerializedName("pager")
    private final Pager pager;

    public ProfileSeeData(Pager pager, List<ProfileSeeItem> list) {
        this.pager = pager;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileSeeData copy$default(ProfileSeeData profileSeeData, Pager pager, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pager = profileSeeData.pager;
        }
        if ((i11 & 2) != 0) {
            list = profileSeeData.items;
        }
        return profileSeeData.copy(pager, list);
    }

    public final Pager component1() {
        return this.pager;
    }

    public final List<ProfileSeeItem> component2() {
        return this.items;
    }

    public final ProfileSeeData copy(Pager pager, List<ProfileSeeItem> list) {
        return new ProfileSeeData(pager, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSeeData)) {
            return false;
        }
        ProfileSeeData profileSeeData = (ProfileSeeData) obj;
        return Intrinsics.b(this.pager, profileSeeData.pager) && Intrinsics.b(this.items, profileSeeData.items);
    }

    public final List<ProfileSeeItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        Pager pager = this.pager;
        int iHashCode = (pager == null ? 0 : pager.hashCode()) * 31;
        List<ProfileSeeItem> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ProfileSeeData(pager=" + this.pager + ", items=" + this.items + ")";
    }
}
