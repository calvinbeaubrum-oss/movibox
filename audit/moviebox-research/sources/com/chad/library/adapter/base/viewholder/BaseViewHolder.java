package com.chad.library.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.StringRes;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import z2.a;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
@SourceDebugExtension
public class BaseViewHolder extends RecyclerView.a0 {
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
        this.views = new SparseArray<>();
    }

    public <T extends View> T findView(int i11) {
        return (T) this.itemView.findViewById(i11);
    }

    @Deprecated
    public <B extends ViewDataBinding> B getBinding() {
        return (B) g.c(this.itemView);
    }

    public <T extends View> T getView(int i11) {
        T t11 = (T) getViewOrNull(i11);
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException(("No view found with id " + i11).toString());
    }

    public <T extends View> T getViewOrNull(int i11) {
        T t11;
        T t12 = (T) this.views.get(i11);
        if (t12 == null && (t11 = (T) this.itemView.findViewById(i11)) != null) {
            this.views.put(i11, t11);
            return t11;
        }
        if (t12 == null) {
            return null;
        }
        return t12;
    }

    public BaseViewHolder setBackgroundColor(int i11, int i12) {
        getView(i11).setBackgroundColor(i12);
        return this;
    }

    public BaseViewHolder setBackgroundResource(int i11, int i12) {
        getView(i11).setBackgroundResource(i12);
        return this;
    }

    public BaseViewHolder setEnabled(int i11, boolean z11) {
        getView(i11).setEnabled(z11);
        return this;
    }

    public BaseViewHolder setGone(int i11, boolean z11) {
        getView(i11).setVisibility(z11 ? 8 : 0);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i11, Bitmap bitmap) {
        ((ImageView) getView(i11)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i11, Drawable drawable) {
        ((ImageView) getView(i11)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(int i11, int i12) {
        ((ImageView) getView(i11)).setImageResource(i12);
        return this;
    }

    public BaseViewHolder setText(int i11, @StringRes int i12) {
        ((TextView) getView(i11)).setText(i12);
        return this;
    }

    public BaseViewHolder setText(int i11, CharSequence charSequence) {
        ((TextView) getView(i11)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int i11, int i12) {
        ((TextView) getView(i11)).setTextColor(i12);
        return this;
    }

    public BaseViewHolder setTextColorRes(int i11, int i12) {
        ((TextView) getView(i11)).setTextColor(a.getColor(this.itemView.getContext(), i12));
        return this;
    }

    public BaseViewHolder setVisible(int i11, boolean z11) {
        getView(i11).setVisibility(z11 ? 0 : 4);
        return this;
    }
}
