package com.transsion.shorttv.source;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@Keep
@Metadata
public final class ShortTvInfoEpisodeList {
    private transient int endPosition;
    private final Subject info;
    private List<ShortTVItem> items;
    private final Pager pager;
    private transient int startPosition;

    public ShortTvInfoEpisodeList(Pager pager, List<ShortTVItem> list, Subject subject, int i11, int i12) {
        this.pager = pager;
        this.items = list;
        this.info = subject;
        this.startPosition = i11;
        this.endPosition = i12;
    }

    public /* synthetic */ ShortTvInfoEpisodeList(Pager pager, List list, Subject subject, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(pager, list, subject, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
    }

    public final int getEndPosition() {
        return this.endPosition;
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

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final void setEndPosition(int i11) {
        this.endPosition = i11;
    }

    public final void setItems(List<ShortTVItem> list) {
        this.items = list;
    }

    public final void setStartPosition(int i11) {
        this.startPosition = i11;
    }
}
