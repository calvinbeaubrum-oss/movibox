package com.transsion.publish.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.TnTextView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$styleable;
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
public final class CustomHeader extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f56637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TnTextView f56638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f56639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TnTextView f56640d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHeader(Context context, AttributeSet attributeSet) {
        int attributeResourceValue;
        int attributeResourceValue2;
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.common_layout_header, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.iv_back);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.iv_back)");
        this.f56637a = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.tv_title);
        Intrinsics.f(viewFindViewById2, "findViewById(R.id.tv_title)");
        this.f56638b = (TnTextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.iv_search);
        Intrinsics.f(viewFindViewById3, "findViewById(R.id.iv_search)");
        this.f56639c = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.tv_edit);
        Intrinsics.f(viewFindViewById4, "findViewById(R.id.tv_edit)");
        this.f56640d = (TnTextView) viewFindViewById4;
        if (attributeSet == null) {
            attributeResourceValue = 0;
            break;
        }
        int attributeCount = attributeSet.getAttributeCount();
        int i11 = 0;
        while (true) {
            if (i11 >= attributeCount) {
                attributeResourceValue = 0;
                break;
            } else {
                if (Intrinsics.b(attributeSet.getAttributeName(i11), "titleValue")) {
                    attributeResourceValue = attributeSet.getAttributeResourceValue(i11, 0);
                    break;
                }
                i11++;
            }
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomHeader);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.CustomHeader)");
        if (attributeResourceValue != 0) {
            this.f56638b.setTextById(attributeResourceValue);
        }
        if (attributeSet == null) {
            attributeResourceValue2 = 0;
            break;
        }
        int attributeCount2 = attributeSet.getAttributeCount();
        int i12 = 0;
        while (true) {
            if (i12 >= attributeCount2) {
                attributeResourceValue2 = 0;
                break;
            } else {
                if (Intrinsics.b(attributeSet.getAttributeName(i12), "rightValue")) {
                    attributeResourceValue2 = attributeSet.getAttributeResourceValue(i12, 0);
                    break;
                }
                i12++;
            }
        }
        this.f56640d.setTextColor(com.blankj.utilcode.util.h.a(R$color.cl01));
        this.f56640d.setTypeface(Typeface.DEFAULT_BOLD);
        if (attributeResourceValue2 != 0) {
            this.f56640d.setTextById(attributeResourceValue2);
        }
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CustomHeader_showSearch, false);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CustomHeader_showEdit, false);
        this.f56639c.setVisibility(z11 ? 0 : 8);
        this.f56640d.setVisibility(z12 ? 0 : 8);
        this.f56637a.setImageResource(typedArrayObtainStyledAttributes.getBoolean(R$styleable.CustomHeader_isBack, true) ? R$mipmap.libui_ic_back_black : R$mipmap.libui_ic_back_black);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void onSearchClick(View.OnClickListener onClickListener) {
        this.f56639c.setOnClickListener(onClickListener);
    }

    public final void setOnBackClick(View.OnClickListener onClickListener) {
        this.f56637a.setOnClickListener(onClickListener);
    }

    public final void setOnEditClick(View.OnClickListener onClickListener) {
        this.f56640d.setOnClickListener(onClickListener);
    }

    public final void setTitle(String str) {
        this.f56638b.setText(str);
    }
}
