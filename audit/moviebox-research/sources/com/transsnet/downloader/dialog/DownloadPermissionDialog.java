package com.transsnet.downloader.dialog;

import android.os.Bundle;
import android.view.View;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadPermissionDialog extends BaseDialog {
    public DownloadPermissionDialog() {
        super(R$layout.dialog_download_permission_tips);
    }

    private final void o0(View view) {
        h00.j jVarA = h00.j.a(view);
        Intrinsics.f(jVarA, "bind(view)");
        jVarA.f65908b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadPermissionDialog.p0(this.f60594a, view2);
            }
        });
        jVarA.f65910d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadPermissionDialog.q0(this.f60595a, view2);
            }
        });
    }

    public static final void p0(DownloadPermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void q0(DownloadPermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsnet.downloader.viewmodel.c.f61276a.C();
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.NormalDialogTheme);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        o0(view);
    }
}
