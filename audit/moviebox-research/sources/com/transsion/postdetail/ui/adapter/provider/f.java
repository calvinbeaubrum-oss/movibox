package com.transsion.postdetail.ui.adapter.provider;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
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
public final class f extends d {
    public static final void B(NineGridVideoView this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.loadImage();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.IMAGE.ordinal();
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void w(AppCompatImageView ivCenterIcon, PostSubjectItem item) {
        Intrinsics.g(ivCenterIcon, "ivCenterIcon");
        Intrinsics.g(item, "item");
        ivCenterIcon.setVisibility(8);
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void x(final NineGridVideoView nineGridView, PostSubjectItem item) {
        List<Image> image;
        Intrinsics.g(nineGridView, "nineGridView");
        Intrinsics.g(item, "item");
        Media media = item.getMedia();
        if (media == null || (image = media.getImage()) == null) {
            return;
        }
        nineGridView.setAdapter(new NineGridVideoViewAdapter(image));
        nineGridView.post(new Runnable() { // from class: com.transsion.postdetail.ui.adapter.provider.e
            @Override // java.lang.Runnable
            public final void run() {
                f.B(nineGridView);
            }
        });
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void y(AppCompatTextView tvTime, PostSubjectItem item) {
        Intrinsics.g(tvTime, "tvTime");
        Intrinsics.g(item, "item");
        tvTime.setVisibility(8);
    }
}
