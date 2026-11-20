package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
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
public final class ToolBarCheckInAnimationView extends CheckInAnimationView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f49662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f49663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConstraintLayout f49664h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolBarCheckInAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
    }

    public final void a(int i11) {
        if (this.f49663g != null) {
            CenterInside centerInside = new CenterInside();
            RequestBuilder requestBuilderOptionalTransform = Glide.with(getContext().getApplicationContext()).load2(Integer.valueOf(i11)).optionalTransform(centerInside).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(centerInside));
            ImageView imageView = this.f49663g;
            Intrinsics.d(imageView);
            requestBuilderOptionalTransform.into(imageView);
        }
    }

    @Override // com.tn.lib.view.CheckInAnimationView
    public void initView() {
        LayoutInflater.from(getContext()).inflate(R$layout.tool_bar_view_check_in_layout, this);
        this.f49662f = (TextView) findViewById(R$id.tvTitle);
        this.f49663g = (ImageView) findViewById(R$id.ivLoading);
        this.f49664h = (ConstraintLayout) findViewById(R$id.rootView);
        TextView textView = this.f49662f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (com.transsion.baselib.utils.o.f51321a.a()) {
            a(R$mipmap.loading_green_dark);
        } else {
            a(R$mipmap.loading_green_light);
        }
    }

    @Override // com.tn.lib.view.CheckInAnimationView
    public void upDateState(int i11) {
        setCurrentState(i11);
        if (i11 == 1) {
            TextView textView = this.f49662f;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f49662f;
            if (textView2 != null) {
                textView2.setText(getResources().getString(R$string.Join));
            }
            TextView textView3 = this.f49662f;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(R$color.brand));
            }
            ImageView imageView = this.f49663g;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ConstraintLayout constraintLayout = this.f49664h;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R$drawable.libui_join_3);
                return;
            }
            return;
        }
        if (i11 == 2) {
            TextView textView4 = this.f49662f;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            ImageView imageView2 = this.f49663g;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = this.f49664h;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundResource(R$drawable.libui_join_3);
            }
            if (com.transsion.baselib.utils.o.f51321a.a()) {
                a(R$mipmap.loading_green_dark);
                return;
            } else {
                a(R$mipmap.loading_green_light);
                return;
            }
        }
        if (i11 != 3) {
            if (i11 != 4) {
                return;
            }
            TextView textView5 = this.f49662f;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            ImageView imageView3 = this.f49663g;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ConstraintLayout constraintLayout3 = this.f49664h;
            if (constraintLayout3 != null) {
                constraintLayout3.setBackgroundResource(R$drawable.libui_join_4);
            }
            a(R$mipmap.loading_3_gray);
            return;
        }
        TextView textView6 = this.f49662f;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        TextView textView7 = this.f49662f;
        if (textView7 != null) {
            textView7.setText(getResources().getString(R$string.Joined));
        }
        TextView textView8 = this.f49662f;
        if (textView8 != null) {
            textView8.setTextColor(getResources().getColor(R$color.text_08));
        }
        ImageView imageView4 = this.f49663g;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
        ConstraintLayout constraintLayout4 = this.f49664h;
        if (constraintLayout4 != null) {
            constraintLayout4.setBackgroundResource(R$drawable.libui_join_4);
        }
    }
}
