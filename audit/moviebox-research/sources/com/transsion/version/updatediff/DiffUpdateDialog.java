package com.transsion.version.updatediff;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.version.diffupdate.R$layout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DiffUpdateDialog extends BaseDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f59771f = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public oz.a f59772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f59773d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiffUpdateDialog a(Function1<? super Boolean, Unit> callback) {
            Intrinsics.g(callback, "callback");
            DiffUpdateDialog diffUpdateDialog = new DiffUpdateDialog();
            diffUpdateDialog.q0(callback);
            return diffUpdateDialog;
        }
    }

    public DiffUpdateDialog() {
        super(R$layout.dialog_diff_update_hint);
    }

    public static final void o0(DiffUpdateDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f59773d;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public static final void p0(DiffUpdateDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f59773d;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        bVar.setCanceledOnTouchOutside(false);
        Window window = bVar.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatButton appCompatButton;
        AppCompatButton appCompatButton2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59772c = oz.a.a(view);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        oz.a aVar = this.f59772c;
        if (aVar != null && (appCompatButton2 = aVar.f73462n) != null) {
            appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.version.updatediff.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiffUpdateDialog.o0(this.f59777a, view2);
                }
            });
        }
        oz.a aVar2 = this.f59772c;
        if (aVar2 == null || (appCompatButton = aVar2.f73463o) == null) {
            return;
        }
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.version.updatediff.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DiffUpdateDialog.p0(this.f59778a, view2);
            }
        });
    }

    public final void q0(Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f59773d = callback;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        super.show(manager, str);
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        roomAppMMKV.a().putLong("diff_update_dialog_show_timestamp", System.currentTimeMillis());
        roomAppMMKV.a().putInt("diff_dialog_showed", roomAppMMKV.a().getInt("diff_dialog_showed", 0) + 1);
    }
}
