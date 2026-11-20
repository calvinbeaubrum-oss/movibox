package com.transsion.usercenter.edit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ProfileEditBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f59339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f59340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f59341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f59342d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f59343f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProfileEditBar(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProfileEditBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProfileEditBar(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProfileEditBar(Context context, AttributeSet attributeSet, int i11, int i12) {
        int resourceId;
        TextView textView;
        int resourceId2;
        TextView textView2;
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_profile_edit_info_bar, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.profileEditView);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.profileEditView)");
        this.f59339a = (RelativeLayout) viewInflate.findViewById(R$id.rlLayout);
        this.f59340b = (TextView) viewInflate.findViewById(R$id.tv_profileleft);
        this.f59341c = (TextView) viewInflate.findViewById(R$id.tv_profileright);
        this.f59342d = (ImageView) viewInflate.findViewById(R$id.iv_profile_more);
        this.f59343f = viewInflate.findViewById(R$id.view_line);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.profileEditView_left_text) && (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.profileEditView_left_text, 0)) > 0 && (textView2 = this.f59340b) != null) {
            textView2.setText(resourceId2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.profileEditView_right_text) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.profileEditView_right_text, 0)) > 0 && (textView = this.f59341c) != null) {
            textView.setText(resourceId);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.profileEditView_right_icon)) {
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.profileEditView_right_icon, 0);
            if (resourceId3 <= 0) {
                ImageView imageView = this.f59342d;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f59342d;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.f59342d;
            if (imageView3 != null) {
                imageView3.setImageResource(resourceId3);
            }
        }
    }

    public /* synthetic */ ProfileEditBar(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final String getBtnTextValue() {
        TextView textView = this.f59341c;
        return String.valueOf(textView != null ? textView.getText() : null);
    }

    public final String getSetValue() {
        TextView textView = this.f59341c;
        String strValueOf = String.valueOf(textView != null ? textView.getText() : null);
        return TextUtils.equals(strValueOf, getContext().getString(R$string.profile_empty_select)) ? "" : strValueOf;
    }

    public final boolean isEmpty() {
        TextView textView = this.f59341c;
        String strValueOf = String.valueOf(textView != null ? textView.getText() : null);
        return TextUtils.isEmpty(strValueOf) || TextUtils.equals(strValueOf, getContext().getString(R$string.profile_empty_select));
    }

    public final void setBtnLeft(String text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f59340b;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setBtnRight(String text) {
        Intrinsics.g(text, "text");
        if (TextUtils.isEmpty(text)) {
            TextView textView = this.f59341c;
            if (textView == null) {
                return;
            }
            textView.setText(getContext().getString(R$string.profile_empty_select));
            return;
        }
        TextView textView2 = this.f59341c;
        if (textView2 == null) {
            return;
        }
        textView2.setText(text);
    }

    public final void setClickListener(View.OnClickListener listener) {
        Intrinsics.g(listener, "listener");
        RelativeLayout relativeLayout = this.f59339a;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(listener);
        }
    }

    public final void setRightIcon(int i11) {
        ImageView imageView = this.f59342d;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }
}
