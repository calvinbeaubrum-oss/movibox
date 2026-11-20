package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
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
public final class b implements aq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ToastImpl f50017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f50018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f50019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f50021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f50024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f50025i;

    public b(Activity activity) {
        this.f50017a = new ToastImpl(activity, this);
    }

    @Override // aq.a
    public boolean a() {
        return this.f50019c == null;
    }

    public TextView b(View view) {
        return aq.a.C0130a.a(this, view);
    }

    public final void c(View view) {
        Intrinsics.g(view, "view");
        this.f50018b = view;
    }

    @Override // aq.a
    public void cancel() {
        ToastImpl toastImpl = this.f50017a;
        if (toastImpl != null) {
            toastImpl.e();
        }
    }

    @Override // aq.a
    public int getDuration() {
        return this.f50021e;
    }

    @Override // aq.a
    public int getGravity() {
        return this.f50020d;
    }

    @Override // aq.a
    public float getHorizontalMargin() {
        return this.f50024h;
    }

    @Override // aq.a
    public float getVerticalMargin() {
        return this.f50025i;
    }

    @Override // aq.a
    public View getView() {
        return this.f50018b;
    }

    @Override // aq.a
    public int getXOffset() {
        return this.f50022f;
    }

    @Override // aq.a
    public int getYOffset() {
        return this.f50023g;
    }

    @Override // aq.a
    public void setDuration(int i11) {
        this.f50021e = i11;
    }

    @Override // aq.a
    public void setGravity(int i11, int i12, int i13) {
        this.f50020d = i11;
        this.f50022f = i12;
        this.f50023g = i13;
    }

    @Override // aq.a
    public void setMargin(float f11, float f12) {
        this.f50024h = f11;
        this.f50025i = f12;
    }

    @Override // aq.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.f50019c;
        if (textView == null) {
            return;
        }
        Intrinsics.d(textView);
        textView.setText(charSequence);
    }

    @Override // aq.a
    public void setView(View view) {
        this.f50018b = view;
        if (view == null) {
            this.f50019c = null;
        } else {
            Intrinsics.d(view);
            this.f50019c = b(view);
        }
    }

    @Override // aq.a
    public void show() {
        ToastImpl toastImpl = this.f50017a;
        if (toastImpl != null) {
            toastImpl.h();
        }
    }
}
