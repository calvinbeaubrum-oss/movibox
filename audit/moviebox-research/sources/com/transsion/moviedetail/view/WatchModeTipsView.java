package com.transsion.moviedetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetail.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tu.y;

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
public final class WatchModeTipsView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f53820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f53821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f53822c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchModeTipsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f53821b = RoomAppMMKV.f51271a.a().getBoolean("watch_mode_tips", false);
        a();
        this.f53822c = LazyKt__LazyJVMKt.b(new WatchModeTipsView$delayShow$2(this));
    }

    private final void a() {
        y yVarA = y.a(View.inflate(getContext(), R$layout.layout_watch_mode_tips, this));
        this.f53820a = yVarA;
        if (yVarA != null) {
            AppCompatTextView appCompatTextView = yVarA.f77655c;
            Intrinsics.f(appCompatTextView, "it.goWatchTv");
            so.c.c(appCompatTextView, 0L, new Function1<View, Unit>() { // from class: com.transsion.moviedetail.view.WatchModeTipsView$initView$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    com.alibaba.android.arouter.launcher.a.d().b("/profile/watch_option").navigation();
                    so.c.g(this.this$0);
                }
            }, 1, null);
            ImageView imageView = yVarA.f77654b;
            Intrinsics.f(imageView, "it.closeWatchTv");
            so.c.c(imageView, 0L, new Function1<View, Unit>() { // from class: com.transsion.moviedetail.view.WatchModeTipsView$initView$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    so.c.g(this.this$0);
                }
            }, 1, null);
        }
    }

    private final Runnable getDelayShow() {
        return (Runnable) this.f53822c.getValue();
    }

    public final void checkShow() {
        if (this.f53821b || com.transsion.baselib.utils.m.f51320a.b()) {
            so.c.g(this);
        } else {
            removeCallbacks(getDelayShow());
            post(getDelayShow());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(getDelayShow());
    }
}
