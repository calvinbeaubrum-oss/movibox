package com.transsion.usercenter.profile.see.bean;

import com.transsion.moviedetailapi.bean.Pager;
import e9.a;
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
public final class ProfileSeeMultiItemData implements Serializable {
    private final List<a> items;
    private final Pager pager;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileSeeMultiItemData(Pager pager, List<? extends a> items) {
        Intrinsics.g(items, "items");
        this.pager = pager;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileSeeMultiItemData copy$default(ProfileSeeMultiItemData profileSeeMultiItemData, Pager pager, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pager = profileSeeMultiItemData.pager;
        }
        if ((i11 & 2) != 0) {
            list = profileSeeMultiItemData.items;
        }
        return profileSeeMultiItemData.copy(pager, list);
    }

    public final Pager component1() {
        return this.pager;
    }

    public final List<a> component2() {
        return this.items;
    }

    public final ProfileSeeMultiItemData copy(Pager pager, List<? extends a> items) {
        Intrinsics.g(items, "items");
        return new ProfileSeeMultiItemData(pager, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSeeMultiItemData)) {
            return false;
        }
        ProfileSeeMultiItemData profileSeeMultiItemData = (ProfileSeeMultiItemData) obj;
        return Intrinsics.b(this.pager, profileSeeMultiItemData.pager) && Intrinsics.b(this.items, profileSeeMultiItemData.items);
    }

    public final List<a> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        Pager pager = this.pager;
        return ((pager == null ? 0 : pager.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "ProfileSeeMultiItemData(pager=" + this.pager + ", items=" + this.items + ")";
    }
}
