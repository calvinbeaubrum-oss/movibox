package com.tn.lib.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tn.lib.widget.R$style;
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
public abstract class TRBaseDialog extends DialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f49949f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49950a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f49951b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49952c = R$style.TNDialogAnimation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49953d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void g0() {
        try {
            dismissAllowingStateLoss();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public abstract int h0();

    public abstract void i0(View view);

    public final boolean isShow() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.d(dialog);
            if (dialog.isShowing()) {
                return true;
            }
        }
        return false;
    }

    public final void j0(float f11) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(f11);
    }

    public final void k0(boolean z11) {
        this.f49950a = z11;
    }

    public final void l0(Context context, String str) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                if (isAdded() || this.f49953d) {
                    return;
                }
                this.f49953d = true;
                show(((FragmentActivity) context).getSupportFragmentManager(), str);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public final void m0(Fragment fragment, String str) {
        Intrinsics.g(fragment, "fragment");
        try {
            if (isAdded() || this.f49953d) {
                return;
            }
            this.f49953d = true;
            show(fragment.getChildFragmentManager(), str);
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        setStyle(2, R$style.TNDialog);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.f(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        View viewInflate = inflater.inflate(h0(), viewGroup, false);
        Intrinsics.f(viewInflate, "inflater.inflate(getLayoutId(), container, false)");
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null && this.f49950a) {
            window.setWindowAnimations(this.f49952c);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(isCancelable());
        }
        i0(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        this.f49953d = false;
    }
}
