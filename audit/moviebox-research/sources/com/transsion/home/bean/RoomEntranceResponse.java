package com.transsion.home.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
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
@Keep
@Metadata
public final class RoomEntranceResponse {
    public static final int $stable = 8;
    private List<RoomItem> groups;
    private Pager pager;
    private List<PostSubjectItem> posts;
    private String title;

    public RoomEntranceResponse() {
        this(null, null, null, null, 15, null);
    }

    public RoomEntranceResponse(List<RoomItem> list, String str, List<PostSubjectItem> list2, Pager pager) {
        this.groups = list;
        this.title = str;
        this.posts = list2;
        this.pager = pager;
    }

    public /* synthetic */ RoomEntranceResponse(List list, String str, List list2, Pager pager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? null : pager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomEntranceResponse copy$default(RoomEntranceResponse roomEntranceResponse, List list, String str, List list2, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = roomEntranceResponse.groups;
        }
        if ((i11 & 2) != 0) {
            str = roomEntranceResponse.title;
        }
        if ((i11 & 4) != 0) {
            list2 = roomEntranceResponse.posts;
        }
        if ((i11 & 8) != 0) {
            pager = roomEntranceResponse.pager;
        }
        return roomEntranceResponse.copy(list, str, list2, pager);
    }

    public final List<RoomItem> component1() {
        return this.groups;
    }

    public final String component2() {
        return this.title;
    }

    public final List<PostSubjectItem> component3() {
        return this.posts;
    }

    public final Pager component4() {
        return this.pager;
    }

    public final RoomEntranceResponse copy(List<RoomItem> list, String str, List<PostSubjectItem> list2, Pager pager) {
        return new RoomEntranceResponse(list, str, list2, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomEntranceResponse)) {
            return false;
        }
        RoomEntranceResponse roomEntranceResponse = (RoomEntranceResponse) obj;
        return Intrinsics.b(this.groups, roomEntranceResponse.groups) && Intrinsics.b(this.title, roomEntranceResponse.title) && Intrinsics.b(this.posts, roomEntranceResponse.posts) && Intrinsics.b(this.pager, roomEntranceResponse.pager);
    }

    public final List<RoomItem> getGroups() {
        return this.groups;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final List<PostSubjectItem> getPosts() {
        return this.posts;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        List<RoomItem> list = this.groups;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<PostSubjectItem> list2 = this.posts;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Pager pager = this.pager;
        return iHashCode3 + (pager != null ? pager.hashCode() : 0);
    }

    public final void setGroups(List<RoomItem> list) {
        this.groups = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setPosts(List<PostSubjectItem> list) {
        this.posts = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "RoomEntranceResponse(groups=" + this.groups + ", title=" + this.title + ", posts=" + this.posts + ", pager=" + this.pager + ")";
    }
}
