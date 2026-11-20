package com.transsion.member.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tn.lib.view.StateView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.R$drawable;
import com.transsion.core.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yp.b;

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
public final class HistoryStateView extends StateView {
    public static final int $stable = 0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryStateView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    @Override // com.tn.lib.view.StateView
    public void b(Context context, AttributeSet attributeSet) {
        Intrinsics.g(context, "context");
        super.b(context, attributeSet);
        b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f81581g.setBackgroundResource(R$drawable.bg_radius_8_color_white_10p);
            mViewBinding.f81581g.setTextColor(getResources().getColor(R$color.common_white));
            ViewGroup.LayoutParams layoutParams = mViewBinding.f81581g.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = e.a(40.0f);
            mViewBinding.f81581g.setLayoutParams(layoutParams);
            int iA = e.a(20.0f);
            mViewBinding.f81581g.setTypeface(Typeface.defaultFromStyle(1));
            mViewBinding.f81581g.setPadding(iA, 0, iA, 0);
            mViewBinding.f81580f.setTextColor(getResources().getColor(R$color.gray_dark_40));
        }
    }

    @Override // com.tn.lib.view.StateView
    public int getNoContentResId() {
        return R$mipmap.ic_no_content_dark;
    }

    @Override // com.tn.lib.view.StateView
    public void setNoContentResId(int i11) {
        super.setNoContentResId(i11);
    }
}
