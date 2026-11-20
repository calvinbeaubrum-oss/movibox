package com.transsion.transfer.wifi.connect;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.Glide;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.R$string;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ky.g;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TransferWifiConnectDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f59117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qy.a f59118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f59119f;

    public TransferWifiConnectDialog() {
        super(R$layout.dialog_transfer_wifi_connect_layout);
    }

    public static final void n0(TransferWifiConnectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f59119f;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismissAllowingStateLoss();
    }

    public final void o0(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f59119f = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, g0() + " --> onCreate() --> 连接弹窗", false, 2, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        com.transsion.transfer.wifi.util.g.b(com.transsion.transfer.wifi.util.g.f59252a, g0() + " --> onDismiss() --> 弹窗关闭", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        Context context;
        AppCompatImageView appCompatImageView2;
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(false);
        }
        g gVarA = g.a(view);
        this.f59117c = gVarA;
        if (gVarA != null && (appCompatImageView2 = gVarA.f69697b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.connect.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TransferWifiConnectDialog.n0(this.f59130a, view2);
                }
            });
        }
        g gVar = this.f59117c;
        if (gVar != null && (appCompatImageView = gVar.f69698c) != null && (context = getContext()) != null) {
            Glide.with(context).load2(Integer.valueOf(R$mipmap.ic_loading_transfer)).into(appCompatImageView);
        }
        g gVar2 = this.f59117c;
        AppCompatTextView appCompatTextView = gVar2 != null ? gVar2.f69700f : null;
        if (appCompatTextView != null) {
            qy.a aVar = this.f59118d;
            appCompatTextView.setText(aVar != null ? aVar.p() : null);
        }
        String string = getResources().getString(R$string.transfer_wifi_connect_dialog_tip);
        qy.a aVar2 = this.f59118d;
        String str = string + " " + (aVar2 != null ? aVar2.e() : null);
        g gVar3 = this.f59117c;
        AppCompatTextView appCompatTextView2 = gVar3 != null ? gVar3.f69699d : null;
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setText(str);
    }

    public final void p0(qy.a aVar) {
        this.f59118d = aVar;
    }
}
