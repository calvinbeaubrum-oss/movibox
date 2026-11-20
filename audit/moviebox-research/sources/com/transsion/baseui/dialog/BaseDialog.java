package com.transsion.baseui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
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
@Metadata
public abstract class BaseDialog extends DialogFragment implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnDismissListener f51341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51342b;

    public BaseDialog() {
        this.f51342b = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsion.baseui.dialog.BaseDialog$logViewConfig$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return this.this$0.newLogViewConfig();
            }
        });
    }

    public BaseDialog(int i11) {
        super(i11);
        this.f51342b = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsion.baseui.dialog.BaseDialog$logViewConfig$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return this.this$0.newLogViewConfig();
            }
        });
    }

    public final String g0() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.f51342b.getValue();
    }

    public String h0() {
        return null;
    }

    public void i0(DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.g(dismissListener, "dismissListener");
        this.f51341a = dismissListener;
    }

    public final void j0(Context context, String str) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.f(supportFragmentManager, "context.supportFragmentManager");
                l0(supportFragmentManager, str);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public final void k0(Fragment fragment, String str) {
        Intrinsics.g(fragment, "fragment");
        try {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "fragment.childFragmentManager");
            show(childFragmentManager, str);
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final void l0(FragmentManager fragmentManager, String str) {
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

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a.f51348a.a(h0());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.f51341a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e.a.c(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        try {
            manager.executePendingTransactions();
            if (!isAdded() && manager.findFragmentByTag(str) == null) {
                super.show(manager, str);
                a.f51348a.b(h0());
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }
}
