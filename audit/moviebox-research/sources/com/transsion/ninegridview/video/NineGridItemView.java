package com.transsion.ninegridview.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zu.d;

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
public final class NineGridItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f54007a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.nine_grid_item_view, (ViewGroup) this, true);
        this.f54007a = d.a(this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final FrameLayout getContainer() {
        d dVar = this.f54007a;
        if (dVar != null) {
            return dVar.f82181c;
        }
        return null;
    }

    public final ShapeableImageView getImageView() {
        d dVar = this.f54007a;
        if (dVar != null) {
            return dVar.f82182d;
        }
        return null;
    }
}
