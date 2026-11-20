package com.transsion.postdetail.shorttv.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.bean.Pager;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

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
@Deprecated
@Keep
@Metadata
public final class ShortTvInfoEpisodeList {
    private final Subject info;
    private List<ShortTVItem> items;
    private final Pager pager;

    public ShortTvInfoEpisodeList(Pager pager, List<ShortTVItem> list, Subject subject) {
        this.pager = pager;
        this.items = list;
        this.info = subject;
    }

    public final Subject getInfo() {
        return this.info;
    }

    public final List<ShortTVItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final void setItems(List<ShortTVItem> list) {
        this.items = list;
    }
}
