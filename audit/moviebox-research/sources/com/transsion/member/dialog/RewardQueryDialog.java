package com.transsion.member.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$style;
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
public final class RewardQueryDialog extends BaseDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f53310f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f53311g = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qu.e f53312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53313d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RewardQueryDialog() {
        super(R$layout.dialog_fragment_reward_query);
    }

    public static final void o0(RewardQueryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void p0(RewardQueryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.member.a.f53220a.a(g0() + " --> onCreate()");
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(CampaignEx.JSON_KEY_TITLE, this.f53313d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
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
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        qu.e eVarA = qu.e.a(view);
        this.f53312c = eVarA;
        if (eVarA != null && (appCompatTextView2 = eVarA.f74925g) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RewardQueryDialog.o0(this.f53328a, view2);
                }
            });
        }
        qu.e eVar = this.f53312c;
        TextView textView = eVar != null ? eVar.f74926h : null;
        if (textView != null) {
            textView.setText(this.f53313d);
        }
        qu.e eVar2 = this.f53312c;
        if (eVar2 == null || (appCompatTextView = eVar2.f74923d) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RewardQueryDialog.p0(this.f53329a, view2);
            }
        });
    }
}
