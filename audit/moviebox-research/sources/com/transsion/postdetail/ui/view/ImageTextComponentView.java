package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class ImageTextComponentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatTextView f55957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f55958b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageTextComponentView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageTextComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTextComponentView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_image_text_component_layout, this);
        this.f55958b = (AppCompatImageView) findViewById(R$id.ivIcon);
        this.f55957a = (AppCompatTextView) findViewById(R$id.tvTitle);
    }

    public final void showData(int i11, String str) {
        AppCompatImageView appCompatImageView = this.f55958b;
        if (appCompatImageView != null) {
            appCompatImageView.setImageResource(i11);
        }
        AppCompatTextView appCompatTextView = this.f55957a;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(str);
    }
}
