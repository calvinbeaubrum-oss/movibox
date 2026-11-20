package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.postdetail.R$layout;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NoSubtitleTipDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f55611g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f55612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tv.f f55613d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55614f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NoSubtitleTipDialog() {
        super(R$layout.dialog_no_subtitle_tip_layout);
    }

    public static final void p0(NoSubtitleTipDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(NoSubtitleTipDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function0<Unit> function0 = this$0.f55612c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void r0(NoSubtitleTipDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        tv.f fVar = this$0.f55613d;
        ImageView imageView = fVar != null ? fVar.f77732b : null;
        if (imageView != null) {
            imageView.setSelected(!this$0.f55614f);
        }
        this$0.f55614f = !this$0.f55614f;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
        setStyle(0, R$style.NormalDialogThemeTrans);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.f55614f) {
            RoomAppMMKV.f51271a.a().putBoolean("no_subtitle_tip_again", false);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("no_subtitle_tip_again", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        LinearLayoutCompat linearLayoutCompat;
        TextView textView;
        TextView textView2;
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f55613d = tv.f.a(view);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-2, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        tv.f fVar = this.f55613d;
        if (fVar != null && (textView2 = fVar.f77734d) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipDialog.p0(this.f55625a, view2);
                }
            });
        }
        tv.f fVar2 = this.f55613d;
        if (fVar2 != null && (textView = fVar2.f77735f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipDialog.q0(this.f55626a, view2);
                }
            });
        }
        tv.f fVar3 = this.f55613d;
        if (fVar3 == null || (linearLayoutCompat = fVar3.f77733c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoSubtitleTipDialog.r0(this.f55627a, view2);
            }
        });
    }
}
