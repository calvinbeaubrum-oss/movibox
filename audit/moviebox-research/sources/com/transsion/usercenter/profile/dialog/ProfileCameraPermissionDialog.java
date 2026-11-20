package com.transsion.usercenter.profile.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.usercenter.R$style;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import xy.x;

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
public final class ProfileCameraPermissionDialog extends BaseViewBindingDialog<x> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f59578d;

    private final void q0(View view) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        x xVarN0 = n0();
        if (xVarN0 != null && (appCompatTextView2 = xVarN0.f80983b) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ProfileCameraPermissionDialog.r0(this.f59581a, view2);
                }
            });
        }
        x xVarN1 = n0();
        if (xVarN1 == null || (appCompatTextView = xVarN1.f80984c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileCameraPermissionDialog.s0(this.f59582a, view2);
            }
        });
    }

    public static final void r0(ProfileCameraPermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.f59578d;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(ProfileCameraPermissionDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.f59578d;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // com.transsion.baseui.dialog.BaseViewBindingDialog
    public Function3<LayoutInflater, ViewGroup, Boolean, x> m0() {
        return ProfileCameraPermissionDialog$bindingInflater$1.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        q0(view);
    }

    public final void t0(Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f59578d = callback;
    }
}
