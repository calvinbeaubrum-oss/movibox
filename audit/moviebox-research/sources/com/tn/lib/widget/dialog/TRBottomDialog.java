package com.tn.lib.widget.dialog;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
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
public final class TRBottomDialog extends TRBaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f49954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f49955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f49956i;

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public int h0() {
        return R$layout.libui_dialog_bottom_shadow;
    }

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public void i0(View view) {
        Intrinsics.g(view, "view");
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.root);
        constraintLayout.setBackgroundResource(this.f49955h);
        View view2 = this.f49954g;
        if (view2 != null) {
            constraintLayout.addView(view2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        Window window2;
        if (getContext() != null) {
            Dialog dialog = getDialog();
            if (dialog != null && (window2 = dialog.getWindow()) != null) {
                window2.setLayout(-1, -2);
            }
            Dialog dialog2 = getDialog();
            if (dialog2 != null && (window = dialog2.getWindow()) != null) {
                window.setGravity(80);
            }
            j0(this.f49956i);
        }
        super.onResume();
    }
}
