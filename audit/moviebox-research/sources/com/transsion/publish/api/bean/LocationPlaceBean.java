package com.transsion.publish.api.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.room.api.bean.LocationPlace;
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
@Keep
@Metadata
public final class LocationPlaceBean implements Serializable {
    private List<LocationPlace> items;
    private Pager pager;

    public LocationPlaceBean(List<LocationPlace> list, Pager pager) {
        this.items = list;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocationPlaceBean copy$default(LocationPlaceBean locationPlaceBean, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = locationPlaceBean.items;
        }
        if ((i11 & 2) != 0) {
            pager = locationPlaceBean.pager;
        }
        return locationPlaceBean.copy(list, pager);
    }

    public final List<LocationPlace> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final LocationPlaceBean copy(List<LocationPlace> list, Pager pager) {
        return new LocationPlaceBean(list, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationPlaceBean)) {
            return false;
        }
        LocationPlaceBean locationPlaceBean = (LocationPlaceBean) obj;
        return Intrinsics.b(this.items, locationPlaceBean.items) && Intrinsics.b(this.pager, locationPlaceBean.pager);
    }

    public final List<LocationPlace> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        List<LocationPlace> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        return iHashCode + (pager != null ? pager.hashCode() : 0);
    }

    public final void setItems(List<LocationPlace> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "LocationPlaceBean(items=" + this.items + ", pager=" + this.pager + ")";
    }
}
