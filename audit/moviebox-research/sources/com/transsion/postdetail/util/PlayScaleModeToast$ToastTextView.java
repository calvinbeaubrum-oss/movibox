package com.transsion.postdetail.util;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class PlayScaleModeToast$ToastTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f56200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f56201b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayScaleModeToast$ToastTextView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f56200a = 1000L;
        this.f56201b = new Runnable() { // from class: com.transsion.postdetail.util.g
            @Override // java.lang.Runnable
            public final void run() {
                PlayScaleModeToast$ToastTextView.b(this.f56212a);
            }
        };
    }

    public static final void b(PlayScaleModeToast$ToastTextView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.setVisibility(0);
        ViewParent parent = this$0.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this$0);
        }
    }

    public final long getDelayTime() {
        return this.f56200a;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f56201b);
    }

    public final void setDelayTime(long j11) {
        this.f56200a = j11;
    }

    public final void toast(String msg) {
        Intrinsics.g(msg, "msg");
        setText(msg);
        removeCallbacks(this.f56201b);
        setVisibility(0);
        postDelayed(this.f56201b, this.f56200a);
    }
}
