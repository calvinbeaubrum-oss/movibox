package com.transsion.ninegridview.video;

import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.d;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public class NineGridVideoViewAdapter implements Serializable {
    private final List<Image> imageList;
    private int statusHeight;

    public NineGridVideoViewAdapter(List<Image> imageList) {
        Intrinsics.g(imageList, "imageList");
        this.imageList = imageList;
        this.statusHeight = d.c();
    }

    public final NineGridItemView generateItemView(Context context) {
        Intrinsics.g(context, "context");
        return new NineGridItemView(context);
    }

    public final List<Image> getImageList() {
        return this.imageList;
    }

    public final void onItemClick(Context context, NineGridVideoView nineGridVideoView, int i11, List<Image> list) {
        Intrinsics.g(context, "context");
        Intrinsics.g(nineGridVideoView, "nineGridVideoView");
        Intent intent = new Intent(context, (Class<?>) GifImagePreviewActivity.class);
        if (list != null) {
            for (Image image : list) {
                int[] iArr = new int[2];
                nineGridVideoView.getLocationInWindow(iArr);
                image.setImageViewX(iArr[0]);
                image.setImageViewY(iArr[1] - this.statusHeight);
                image.setImageViewHeight(nineGridVideoView.getHeight());
                image.setImageViewWidth(nineGridVideoView.getWidth());
            }
        }
        Intrinsics.e(list, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) list);
        intent.putExtra("CURRENT_ITEM", i11);
        context.startActivity(intent);
    }
}
