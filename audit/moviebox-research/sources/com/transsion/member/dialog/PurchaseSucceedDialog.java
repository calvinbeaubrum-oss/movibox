package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.R$layout;
import kotlin.Metadata;
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
public final class PurchaseSucceedDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f53304h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f53305i = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qu.d f53306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53307d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public su.g f53309g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PurchaseSucceedDialog() {
        super(R$layout.dialog_fragment_purchase_succeed);
    }

    public PurchaseSucceedDialog(String str, String str2, su.g gVar) {
        this();
        this.f53307d = str;
        this.f53308f = str2;
        this.f53309g = gVar;
    }

    public static final void o0(PurchaseSucceedDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void p0(PurchaseSucceedDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        su.g gVar = this$0.f53309g;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        com.transsion.member.a.f53220a.a(g0() + " --> onCreate()");
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
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
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(CampaignEx.JSON_KEY_TITLE, this.f53307d);
        outState.putString("buttonTitle", this.f53308f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        LinearLayoutCompat linearLayoutCompat;
        ImageView imageView;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        qu.d dVarA = qu.d.a(view);
        this.f53306c = dVarA;
        if (dVarA != null && (imageView = dVarA.f74916f) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PurchaseSucceedDialog.o0(this.f53326a, view2);
                }
            });
        }
        qu.d dVar = this.f53306c;
        TextView textView = dVar != null ? dVar.f74919i : null;
        if (textView != null) {
            textView.setText(this.f53307d);
        }
        qu.d dVar2 = this.f53306c;
        AppCompatTextView appCompatTextView = dVar2 != null ? dVar2.f74915d : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.f53308f);
        }
        qu.d dVar3 = this.f53306c;
        if (dVar3 == null || (linearLayoutCompat = dVar3.f74914c) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PurchaseSucceedDialog.p0(this.f53327a, view2);
            }
        });
    }

    public final void q0(String str) {
        this.f53308f = str;
    }

    public final void r0(su.g gVar) {
        this.f53309g = gVar;
    }

    public final void s0(String str) {
        this.f53307d = str;
    }
}
