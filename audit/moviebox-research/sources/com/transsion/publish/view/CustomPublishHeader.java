package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
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
public final class CustomPublishHeader extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f56641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TnTextView f56642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f56643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f56644d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomPublishHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.publish_layout_header, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.iv_back);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.iv_back)");
        this.f56641a = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_title);
        Intrinsics.f(viewFindViewById2, "findViewById(R.id.tv_title)");
        this.f56642b = (TnTextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.tv_publish);
        Intrinsics.f(viewFindViewById3, "findViewById(R.id.tv_publish)");
        this.f56643c = (AppCompatTextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.iv_title_image);
        Intrinsics.f(viewFindViewById4, "findViewById(R.id.iv_title_image)");
        this.f56644d = (ShapeableImageView) viewFindViewById4;
    }

    public final void onSearchClick(View.OnClickListener onClickListener) {
    }

    public final void setHeader(String str, String str2) {
        this.f56642b.setText(str);
        if (str2 != null) {
            this.f56644d.setVisibility(0);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            companion.r(context, this.f56644d, str2, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
    }

    public final void setOnBackClick(View.OnClickListener onClickListener) {
        this.f56641a.setOnClickListener(onClickListener);
    }

    public final void setOnEditClick(View.OnClickListener onClickListener) {
        this.f56643c.setOnClickListener(onClickListener);
    }

    public final void setPostEnable(boolean z11) {
        this.f56643c.setEnabled(z11);
    }

    public final void setTitle(String str) {
        this.f56642b.setText(str);
    }
}
