package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$style;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PostConfirmDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f55615c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a();
    }

    public PostConfirmDialog() {
        super(R$layout.dialog_post_confirm);
    }

    public static final void o0(PostConfirmDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f55615c;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismiss();
    }

    public static final void p0(PostConfirmDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(com.transsion.baseui.R$style.bottom_dialog_animations);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = -2;
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        tv.g gVarA = tv.g.a(view);
        Intrinsics.f(gVarA, "bind(view)");
        gVarA.f77744c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostConfirmDialog.o0(this.f55628a, view2);
            }
        });
        gVarA.f77743b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostConfirmDialog.p0(this.f55629a, view2);
            }
        });
    }

    public final void q0(a aVar) {
        this.f55615c = aVar;
    }
}
