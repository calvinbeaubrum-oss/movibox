package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class CheckInAnimationView extends FrameLayout {
    public static final int BUTTON_STATE_EXIT_ING = 4;
    public static final int BUTTON_STATE_JOINED = 3;
    public static final int BUTTON_STATE_JOIN_ING = 2;
    public static final int BUTTON_STATE_NOT_TO_JOIN = 1;
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f49493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f49494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f49495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49496d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckInAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f49496d = 2;
        initView();
    }

    public final int getCurrentState() {
        return this.f49496d;
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(R$layout.view_check_in_layout, this);
        this.f49493a = (TextView) findViewById(R$id.tvTitle);
        this.f49494b = (ImageView) findViewById(R$id.ivLoading);
        this.f49495c = (ConstraintLayout) findViewById(R$id.rootView);
        TextView textView = this.f49493a;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (this.f49494b != null) {
            CenterInside centerInside = new CenterInside();
            RequestBuilder requestBuilderOptionalTransform = Glide.with(getContext().getApplicationContext()).load2(Integer.valueOf(R$mipmap.loading_1_whit)).optionalTransform(centerInside).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(centerInside));
            ImageView imageView = this.f49494b;
            Intrinsics.d(imageView);
            requestBuilderOptionalTransform.into(imageView);
        }
    }

    public final void setCurrentState(int i11) {
        this.f49496d = i11;
    }

    public void upDateState(int i11) {
        this.f49496d = i11;
        if (i11 == 1) {
            TextView textView = this.f49493a;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f49493a;
            if (textView2 != null) {
                textView2.setText(getResources().getString(R$string.Join));
            }
            TextView textView3 = this.f49493a;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(R$color.white));
            }
            ImageView imageView = this.f49494b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ConstraintLayout constraintLayout = this.f49495c;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R$drawable.libui_join_1);
                return;
            }
            return;
        }
        if (i11 == 2) {
            TextView textView4 = this.f49493a;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            ImageView imageView2 = this.f49494b;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = this.f49495c;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundResource(R$drawable.libui_join_1);
                return;
            }
            return;
        }
        if (i11 != 3) {
            if (i11 != 4) {
                return;
            }
            TextView textView5 = this.f49493a;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            ImageView imageView3 = this.f49494b;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ConstraintLayout constraintLayout3 = this.f49495c;
            if (constraintLayout3 != null) {
                constraintLayout3.setBackgroundResource(R$drawable.libui_join_2);
                return;
            }
            return;
        }
        TextView textView6 = this.f49493a;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        TextView textView7 = this.f49493a;
        if (textView7 != null) {
            textView7.setText(getResources().getString(R$string.Joined));
        }
        TextView textView8 = this.f49493a;
        if (textView8 != null) {
            textView8.setTextColor(getResources().getColor(R$color.white));
        }
        ImageView imageView4 = this.f49494b;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
        ConstraintLayout constraintLayout4 = this.f49495c;
        if (constraintLayout4 != null) {
            constraintLayout4.setBackgroundResource(R$drawable.libui_join_2);
        }
    }
}
