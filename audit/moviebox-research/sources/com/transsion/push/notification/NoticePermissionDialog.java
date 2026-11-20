package com.transsion.push.notification;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.blankj.utilcode.util.i;
import com.tn.lib.dialog.BaseDialog;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.util.n;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
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
public final class NoticePermissionDialog extends BaseDialog {
    public static final void j0(NoticePermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.i0();
    }

    public static final void k0(NoticePermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.l0();
    }

    public final void i0() {
        dismiss();
    }

    public final void l0() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.e(baseContext, "null cannot be cast to non-null type android.app.Activity");
            activity = (Activity) baseContext;
        } else {
            activity = null;
        }
        if (activity != null) {
            NoticePermissionUtils.b(NoticePermissionUtils.f56924a, activity, 0, 2, null);
        }
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.push_dialog_notice_permission, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
        }
        window.setBackgroundDrawableResource(R$color.transparent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R$id.cl_content);
        Intrinsics.f(viewFindViewById, "view.findViewById<TextView>(R.id.cl_content)");
        n.a(viewFindViewById, i.e(8.0f));
        TextView onViewCreated$lambda$1 = (TextView) view.findViewById(R$id.tv_later);
        Intrinsics.f(onViewCreated$lambda$1, "onViewCreated$lambda$1");
        n.a(onViewCreated$lambda$1, i.e(8.0f));
        onViewCreated$lambda$1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.notification.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoticePermissionDialog.j0(this.f56971a, view2);
            }
        });
        ((TextView) view.findViewById(R$id.tv_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.notification.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NoticePermissionDialog.k0(this.f56972a, view2);
            }
        });
    }
}
