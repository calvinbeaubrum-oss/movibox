package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
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
public final class HorizontalRecyclerview extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49548b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
    }

    private final void a(boolean z11) {
        getParent().requestDisallowInterceptTouchEvent(z11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.f49547a = (int) motionEvent.getX();
            this.f49548b = (int) motionEvent.getY();
            a(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
