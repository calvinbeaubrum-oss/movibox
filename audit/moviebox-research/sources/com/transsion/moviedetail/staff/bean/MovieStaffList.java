package com.transsion.moviedetail.staff.bean;

import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.postdetail.bean.Pager;
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
public final class MovieStaffList implements Serializable {
    private List<? extends Staff> items;
    private Pager pager;

    public MovieStaffList(List<? extends Staff> list, Pager pager) {
        this.items = list;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovieStaffList copy$default(MovieStaffList movieStaffList, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = movieStaffList.items;
        }
        if ((i11 & 2) != 0) {
            pager = movieStaffList.pager;
        }
        return movieStaffList.copy(list, pager);
    }

    public final List<Staff> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final MovieStaffList copy(List<? extends Staff> list, Pager pager) {
        return new MovieStaffList(list, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MovieStaffList)) {
            return false;
        }
        MovieStaffList movieStaffList = (MovieStaffList) obj;
        return Intrinsics.b(this.items, movieStaffList.items) && Intrinsics.b(this.pager, movieStaffList.pager);
    }

    public final List<Staff> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        List<? extends Staff> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        return iHashCode + (pager != null ? pager.hashCode() : 0);
    }

    public final void setItems(List<? extends Staff> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "MovieStaffList(items=" + this.items + ", pager=" + this.pager + ")";
    }
}
