package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.memberapi.IMemberApi;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
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
public final class AdCountDownView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tv.n0 f55950a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f55950a = tv.n0.a(LayoutInflater.from(getContext()).inflate(R$layout.view_ad_count_down_layout, this));
    }

    public final tv.n0 getBind() {
        return this.f55950a;
    }

    public final void refreshCountDown(int i11) {
        TextView textView;
        if (i11 < 0) {
            if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1()) {
                tv.n0 n0Var = this.f55950a;
                View view = n0Var != null ? n0Var.f77875g : null;
                if (view != null) {
                    view.setVisibility(8);
                }
                tv.n0 n0Var2 = this.f55950a;
                TextView textView2 = n0Var2 != null ? n0Var2.f77874f : null;
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R$string.post_count_down_get_ad_free));
                }
            } else {
                tv.n0 n0Var3 = this.f55950a;
                LinearLayout linearLayout = n0Var3 != null ? n0Var3.f77872c : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
            tv.n0 n0Var4 = this.f55950a;
            textView = n0Var4 != null ? n0Var4.f77873d : null;
            if (textView == null) {
                return;
            }
            textView.setText("");
            return;
        }
        if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1()) {
            tv.n0 n0Var5 = this.f55950a;
            View view2 = n0Var5 != null ? n0Var5.f77875g : null;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            tv.n0 n0Var6 = this.f55950a;
            TextView textView3 = n0Var6 != null ? n0Var6.f77874f : null;
            if (textView3 != null) {
                textView3.setText(getContext().getString(R$string.post_count_down_get_ad_free));
            }
        } else {
            tv.n0 n0Var7 = this.f55950a;
            View view3 = n0Var7 != null ? n0Var7.f77875g : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            tv.n0 n0Var8 = this.f55950a;
            TextView textView4 = n0Var8 != null ? n0Var8.f77874f : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            tv.n0 n0Var9 = this.f55950a;
            ImageView imageView = n0Var9 != null ? n0Var9.f77871b : null;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        tv.n0 n0Var10 = this.f55950a;
        textView = n0Var10 != null ? n0Var10.f77873d : null;
        if (textView == null) {
            return;
        }
        textView.setText(i11 + "s");
    }

    public final void setBind(tv.n0 n0Var) {
        this.f55950a = n0Var;
    }
}
