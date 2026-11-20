package com.transsion.ninegridview;

import android.content.Context;
import android.widget.ImageView;
import com.blankj.utilcode.util.d0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.video.NineGridItemView;
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
@Metadata
public final class c implements av.b {
    @Override // av.b
    public void a(Context context, ImageView imageView, String str, int i11, int i12, String str2) {
        if (context == null || imageView == null || str == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.getLayoutParams().width = i11;
        imageView.getLayoutParams().height = i12;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.o(context, imageView, str, (32704 & 8) != 0 ? com.tn.lib.widget.R$color.skeleton : R$color.ic_default_bg_color, (32704 & 16) != 0 ? companion.d() : i11, (32704 & 32) != 0 ? companion.c() : i12, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : str2 == null ? "" : str2, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    @Override // av.b
    public void b(Context context, NineGridItemView nineGridItemView, Image image, int i11, int i12) {
        String thumbnail;
        GifBean gifBean;
        String url = null;
        ShapeableImageView imageView = nineGridItemView != null ? nineGridItemView.getImageView() : null;
        if (((image == null || (gifBean = image.getGifBean()) == null) ? null : gifBean.getVideoUrl()) != null) {
            GifBean gifBean2 = image.getGifBean();
            if (gifBean2 != null) {
                url = gifBean2.getFirstFrameUrl();
            }
        } else if (image != null) {
            url = image.getUrl();
        }
        int iE = i11 <= 0 ? d0.e() : i11;
        if (context == null || imageView == null) {
            return;
        }
        imageView.getLayoutParams().width = iE;
        imageView.getLayoutParams().height = i12;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.o(context, imageView, url == null ? "" : url, (32704 & 8) != 0 ? com.tn.lib.widget.R$color.skeleton : R$color.ic_default_bg_color, (32704 & 16) != 0 ? companion.d() : iE, (32704 & 32) != 0 ? companion.c() : i12, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : (image == null || (thumbnail = image.getThumbnail()) == null) ? "" : thumbnail, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }
}
