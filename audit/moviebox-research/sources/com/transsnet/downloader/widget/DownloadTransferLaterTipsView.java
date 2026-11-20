package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.f0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R$layout;
import h00.x0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadTransferLaterTipsView extends BLFrameLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f61339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f61340b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTransferLaterTipsView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTransferLaterTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTransferLaterTipsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.layout_download_transfer_later_tips, this);
        x0 x0VarA = x0.a(this);
        Intrinsics.f(x0VarA, "bind(this)");
        this.f61339a = x0VarA;
        b();
    }

    public static final void c(DownloadTransferLaterTipsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f61340b;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.setVisibility(8);
    }

    public final void b() {
        setBackground(new DrawableCreator.Builder().setCornersRadius(f0.a(8.0f)).setSolidColor(getContext().getResources().getColor(R$color.module_dark_80)).build());
        this.f61339a.f66094b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadTransferLaterTipsView.c(this.f61395a, view);
            }
        });
        this.f61339a.f66095c.setMax(15);
    }

    public final void setCloseCallback(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61340b = callback;
    }

    public final void startCountdown() {
        TimeUtilKt.a(15, l0.a(w0.c()), new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.DownloadTransferLaterTipsView.startCountdown.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                DownloadTransferLaterTipsView.this.f61339a.f66095c.setProgress(i11);
            }
        }, new Function0<Unit>() { // from class: com.transsnet.downloader.widget.DownloadTransferLaterTipsView.startCountdown.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DownloadTransferLaterTipsView.this.f61339a.f66095c.setProgress(15);
                DownloadTransferLaterTipsView.this.setVisibility(8);
                Function0 function0 = DownloadTransferLaterTipsView.this.f61340b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }
}
