package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R$layout;
import h00.p0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class DownloadDialogTransferGuideView extends FrameLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f61294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f61295b;

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
    public DownloadDialogTransferGuideView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadDialogTransferGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDialogTransferGuideView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.layout_download_dialog_transfer_guide, this);
        p0 p0VarA = p0.a(this);
        Intrinsics.f(p0VarA, "bind(this)");
        this.f61294a = p0VarA;
        b();
    }

    public static final void c(DownloadDialogTransferGuideView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f61295b;
        if (function0 != null) {
            function0.invoke();
        }
        so.c.g(this$0);
    }

    public final void b() {
        this.f61294a.f65989c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadDialogTransferGuideView.c(this.f61371a, view);
            }
        });
        this.f61294a.f65990d.setMax(15);
    }

    public final void setCloseCallback(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61295b = callback;
    }

    public final void startCountdown() {
        TimeUtilKt.a(15, l0.a(w0.c()), new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.DownloadDialogTransferGuideView.startCountdown.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                DownloadDialogTransferGuideView.this.f61294a.f65990d.setProgress(i11);
            }
        }, new Function0<Unit>() { // from class: com.transsnet.downloader.widget.DownloadDialogTransferGuideView.startCountdown.2
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
                DownloadDialogTransferGuideView.this.f61294a.f65990d.setProgress(15);
                Function0 function0 = DownloadDialogTransferGuideView.this.f61295b;
                if (function0 != null) {
                    function0.invoke();
                }
                so.c.g(DownloadDialogTransferGuideView.this);
            }
        });
    }
}
