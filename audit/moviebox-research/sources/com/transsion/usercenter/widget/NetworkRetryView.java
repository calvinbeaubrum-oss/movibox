package com.transsion.usercenter.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
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
public final class NetworkRetryView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f59760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f59761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f59762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f59763d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetworkRetryView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetworkRetryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetworkRetryView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetworkRetryView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_network_fail_layout, this);
        this.f59760a = (ImageView) viewInflate.findViewById(R$id.ivNetwork);
        this.f59761b = (TextView) viewInflate.findViewById(R$id.tvNetworkTips);
        this.f59762c = (TextView) viewInflate.findViewById(R$id.tvRetry);
        this.f59763d = (LinearLayout) viewInflate.findViewById(R$id.retry_ll);
    }

    public /* synthetic */ NetworkRetryView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final void setRetryListener(View.OnClickListener onClickListener) {
        TextView textView = this.f59762c;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        LinearLayout linearLayout = this.f59763d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public final void textMode() {
        ImageView imageView = this.f59760a;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.f59762c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        LinearLayout linearLayout = this.f59763d;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }
}
