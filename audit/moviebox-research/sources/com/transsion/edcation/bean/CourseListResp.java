package com.transsion.edcation.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CourseListResp implements Serializable {
    private List<CourseBean> items;
    private final Pager pager;

    public CourseListResp(List<CourseBean> items, Pager pager) {
        Intrinsics.g(items, "items");
        this.items = items;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourseListResp copy$default(CourseListResp courseListResp, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = courseListResp.items;
        }
        if ((i11 & 2) != 0) {
            pager = courseListResp.pager;
        }
        return courseListResp.copy(list, pager);
    }

    public final List<CourseBean> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final CourseListResp copy(List<CourseBean> items, Pager pager) {
        Intrinsics.g(items, "items");
        return new CourseListResp(items, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseListResp)) {
            return false;
        }
        CourseListResp courseListResp = (CourseListResp) obj;
        return Intrinsics.b(this.items, courseListResp.items) && Intrinsics.b(this.pager, courseListResp.pager);
    }

    public final List<CourseBean> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        Pager pager = this.pager;
        return iHashCode + (pager == null ? 0 : pager.hashCode());
    }

    public final void setItems(List<CourseBean> list) {
        Intrinsics.g(list, "<set-?>");
        this.items = list;
    }

    public String toString() {
        return "CourseListResp(items=" + this.items + ", pager=" + this.pager + ")";
    }
}
