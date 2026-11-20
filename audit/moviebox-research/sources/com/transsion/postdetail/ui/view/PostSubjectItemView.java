package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
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
public final class PostSubjectItemView extends PostBaseItemView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostSubjectItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostSubjectItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostSubjectItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setHeaderData(PostSubjectItem item) {
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = getViewBinding().f77933g;
        Intrinsics.f(shapeableImageView, "viewBinding.ivRoomCover");
        so.c.g(shapeableImageView);
        ShapeableImageView shapeableImageView2 = getViewBinding().f77934h;
        Intrinsics.f(shapeableImageView2, "viewBinding.ivUserAvatar");
        so.c.g(shapeableImageView2);
        BLView bLView = getViewBinding().f77950x;
        if (bLView != null) {
            so.c.g(bLView);
        }
        ShapeableImageView shapeableImageView3 = getViewBinding().f77935i;
        Intrinsics.f(shapeableImageView3, "viewBinding.ivUserAvatar2");
        so.c.k(shapeableImageView3);
        BLView bLView2 = getViewBinding().f77951y;
        if (bLView2 != null) {
            so.c.k(bLView2);
        }
        PostBaseItemView.setHeaderPostData$default(this, item, false, 2, null);
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setSubjectAndRoomContent(PostSubjectItem item) {
        Intrinsics.g(item, "item");
        if (item.getGroup() != null) {
            Group group = item.getGroup();
            String name = group != null ? group.getName() : null;
            if (name != null && name.length() != 0) {
                setBottomSubjectAndRoomVisibility(false, true);
                setBottomRoomModuleData(item);
                return;
            }
        }
        setBottomSubjectAndRoomVisibility(false, false);
    }
}
