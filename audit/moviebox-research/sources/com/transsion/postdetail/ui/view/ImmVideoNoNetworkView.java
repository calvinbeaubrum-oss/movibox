package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.NetworkUtils;
import com.transsion.postdetail.R$mipmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ImmVideoNoNetworkView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tv.o0 f56011a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoNoNetworkView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoNoNetworkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoNoNetworkView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        tv.o0 o0VarB = tv.o0.b(LayoutInflater.from(context), this);
        Intrinsics.f(o0VarB, "inflate(LayoutInflater.from(context), this)");
        this.f56011a = o0VarB;
        setLayoutParams(new ConstraintLayout.b(-1, -1));
        setBackgroundResource(R$mipmap.post_detail_local_video_bg);
    }

    public static final void c(Function0 setting, View view) {
        Intrinsics.g(setting, "$setting");
        NetworkUtils.w();
        setting.invoke();
    }

    public static final void e(Function0 retryListener, View view) {
        Intrinsics.g(retryListener, "$retryListener");
        retryListener.invoke();
    }

    public final void goToSetting(final Function0<Unit> setting) {
        Intrinsics.g(setting, "setting");
        this.f56011a.f77883b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmVideoNoNetworkView.c(setting, view);
            }
        });
    }

    public final void retry(final Function0<Unit> retryListener) {
        Intrinsics.g(retryListener, "retryListener");
        this.f56011a.f77885d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmVideoNoNetworkView.e(retryListener, view);
            }
        });
    }
}
