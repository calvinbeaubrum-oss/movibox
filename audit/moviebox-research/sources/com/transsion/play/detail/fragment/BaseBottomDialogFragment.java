package com.transsion.play.detail.fragment;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.u;
import com.tn.lib.widget.R$anim;
import com.transsion.baseui.fragment.PageStatusFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n6.a;

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
@SourceDebugExtension
public abstract class BaseBottomDialogFragment<T extends a> extends PageStatusFragment<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f54200k = true;

    public static /* synthetic */ void S0(BaseBottomDialogFragment baseBottomDialogFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeFragment");
        }
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        baseBottomDialogFragment.R0(z11);
    }

    public final boolean Q0() {
        return this.f54200k;
    }

    public final void R0(boolean z11) {
        if (!this.f54200k || z11) {
            this.f54200k = true;
            try {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                parentFragmentManager.popBackStack();
                FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                fragmentTransactionBeginTransaction.remove(this);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }

    public final void T0(Fragment fragment, int i11) {
        Intrinsics.g(fragment, "fragment");
        if (this.f54200k) {
            this.f54200k = false;
            try {
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.f(childFragmentManager, "fragment.childFragmentManager");
                FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
                Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
                fragmentTransactionBeginTransaction.replace(i11, this, getClass().getSimpleName());
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getParentFragment() instanceof hv.a) {
            u parentFragment = getParentFragment();
            Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.play.detail.view.IDialogFragmentView");
            ((hv.a) parentFragment).e0(new Function0<Boolean>(this) { // from class: com.transsion.play.detail.fragment.BaseBottomDialogFragment.onCreate.1
                final /* synthetic */ BaseBottomDialogFragment<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    boolean z11 = false;
                    if (!this.this$0.Q0()) {
                        BaseBottomDialogFragment.S0(this.this$0, false, 1, null);
                        z11 = true;
                    }
                    return Boolean.valueOf(z11);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        return z11 ? AnimationUtils.loadAnimation(getActivity(), R$anim.libui_base_dialog_in_vertical) : AnimationUtils.loadAnimation(getActivity(), R$anim.libui_base_dialog_out_vertical);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getParentFragment() instanceof hv.a) {
            u parentFragment = getParentFragment();
            Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.play.detail.view.IDialogFragmentView");
            ((hv.a) parentFragment).e0(null);
        }
    }
}
