package com.transsion.ad.middle.intercept.video;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$style;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
@Deprecated
@Metadata
public final class CloseAdDialog extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f50458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f50459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatTextView f50460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatTextView f50461d;

    public CloseAdDialog() {
        super(R$layout.dialog_video_cloase_ad_layout);
    }

    public static final void j0(CloseAdDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f50459b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void k0(CloseAdDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function0<Unit> function0 = this$0.f50458a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void n0(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.executePendingTransactions();
            if (!isAdded() && fragmentManager.findFragmentByTag(str) == null) {
                show(fragmentManager, str);
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final String i0() {
        String simpleName = CloseAdDialog.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final CloseAdDialog l0(Function0<Unit> closeAdCallback, Function0<Unit> resumeAdCallback) {
        Intrinsics.g(closeAdCallback, "closeAdCallback");
        Intrinsics.g(resumeAdCallback, "resumeAdCallback");
        this.f50459b = closeAdCallback;
        this.f50458a = resumeAdCallback;
        return this;
    }

    public final void m0(Context context, String str) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "context.supportFragmentManager");
                n0(supportFragmentManager, str);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.ad_center_DialogStyle);
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, i0() + " --> onCreate() --> 观看广告弹窗", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
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
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tvCloseAd);
        this.f50461d = appCompatTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CloseAdDialog.j0(this.f50470a, view2);
                }
            });
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R$id.tvResumeAd);
        this.f50460c = appCompatTextView2;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CloseAdDialog.k0(this.f50471a, view2);
                }
            });
        }
    }
}
