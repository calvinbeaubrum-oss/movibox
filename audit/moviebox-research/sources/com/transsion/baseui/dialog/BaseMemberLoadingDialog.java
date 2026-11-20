package com.transsion.baseui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
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
public class BaseMemberLoadingDialog extends BaseDialog {
    public BaseMemberLoadingDialog() {
        super(R$layout.member_dialog_loading);
    }

    public void m0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 == null || (window = dialog3.getWindow()) == null) {
            return;
        }
        window.setGravity(17);
    }

    public void n0(View view, ProgressBar viewLoad, TextView tvLoading) {
        Intrinsics.g(viewLoad, "viewLoad");
        Intrinsics.g(tvLoading, "tvLoading");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        m0();
        View viewFindViewById = view.findViewById(R$id.viewBg);
        View viewFindViewById2 = view.findViewById(R$id.viewLoad);
        Intrinsics.f(viewFindViewById2, "view.findViewById(R.id.viewLoad)");
        View viewFindViewById3 = view.findViewById(R$id.tvLoading);
        Intrinsics.f(viewFindViewById3, "view.findViewById(R.id.tvLoading)");
        n0(viewFindViewById, (ProgressBar) viewFindViewById2, (TextView) viewFindViewById3);
    }
}
