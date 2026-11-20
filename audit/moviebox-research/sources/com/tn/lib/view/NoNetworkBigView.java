package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NoNetworkBigView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yp.c f49558a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context, AttributeSet attributeSet, int i11, boolean z11) {
        TitleLayout titleLayout;
        TitleLayout titleLayout2;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f49558a = yp.c.b(LayoutInflater.from(context), this);
        setLayoutParams(new ConstraintLayout.b(-1, -1));
        setPadding(0, 0, 0, f0.a(14.0f));
        setBackgroundResource(R$color.bg_01);
        if (z11) {
            yp.c cVar = this.f49558a;
            if (cVar == null || (titleLayout2 = cVar.f81586f) == null) {
                return;
            }
            so.c.k(titleLayout2);
            return;
        }
        yp.c cVar2 = this.f49558a;
        if (cVar2 == null || (titleLayout = cVar2.f81586f) == null) {
            return;
        }
        so.c.h(titleLayout);
    }

    public /* synthetic */ NoNetworkBigView(Context context, AttributeSet attributeSet, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, i11, (i12 & 8) != 0 ? true : z11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoNetworkBigView(Context context, boolean z11) {
        this(context, null, 0, z11);
        Intrinsics.g(context, "context");
    }

    public static final void c(Function0 setting, View view) {
        Intrinsics.g(setting, "$setting");
        try {
            NetworkUtils.w();
            setting.invoke();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static final void e(Function0 retryListener, View view) {
        Intrinsics.g(retryListener, "$retryListener");
        retryListener.invoke();
    }

    public static /* synthetic */ void showTitle$default(NoNetworkBigView noNetworkBigView, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "";
        }
        noNetworkBigView.showTitle(z11, str);
    }

    public final void goToSetting(final Function0<Unit> setting) {
        TnTextView tnTextView;
        Intrinsics.g(setting, "setting");
        yp.c cVar = this.f49558a;
        if (cVar == null || (tnTextView = cVar.f81584c) == null) {
            return;
        }
        tnTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkBigView.c(setting, view);
            }
        });
    }

    public final void retry(final Function0<Unit> retryListener) {
        TnTextView tnTextView;
        Intrinsics.g(retryListener, "retryListener");
        yp.c cVar = this.f49558a;
        if (cVar == null || (tnTextView = cVar.f81588h) == null) {
            return;
        }
        tnTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoNetworkBigView.e(retryListener, view);
            }
        });
    }

    public final void showTitle(boolean z11, String title) {
        TitleLayout titleLayout;
        Intrinsics.g(title, "title");
        yp.c cVar = this.f49558a;
        if (cVar == null || (titleLayout = cVar.f81586f) == null) {
            return;
        }
        if (z11) {
            so.c.k(titleLayout);
        } else {
            so.c.g(titleLayout);
        }
        titleLayout.setTitleText(title);
    }
}
