package com.transsion.baseui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.report.e;
import com.transsion.baselib.report.h;
import com.transsion.baseui.R$style;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
public abstract class BaseDialogFragment<VB extends n6.a> extends DialogFragment implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<LayoutInflater, ViewGroup, Boolean, VB> f51343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VB f51344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f51345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f51346d;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseDialogFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> bindingInflater) {
        Intrinsics.g(bindingInflater, "bindingInflater");
        this.f51343a = bindingInflater;
        this.f51345c = LazyKt__LazyJVMKt.b(new Function0<VB>(this) { // from class: com.transsion.baseui.dialog.BaseDialogFragment$mViewBinding$2
            final /* synthetic */ BaseDialogFragment<VB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            @Override // kotlin.jvm.functions.Function0
            public final n6.a invoke() {
                n6.a aVar = this.this$0.f51344b;
                Intrinsics.d(aVar);
                return aVar;
            }
        });
        this.f51346d = LazyKt__LazyJVMKt.b(new Function0<h>(this) { // from class: com.transsion.baseui.dialog.BaseDialogFragment$logViewConfig$2
            final /* synthetic */ BaseDialogFragment<VB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return this.this$0.newLogViewConfig();
            }
        });
    }

    @Override // com.transsion.baselib.report.e
    public h getLogViewConfig() {
        return (h) this.f51346d.getValue();
    }

    public final VB getMViewBinding() {
        return (VB) this.f51345c.getValue();
    }

    public boolean h0() {
        return true;
    }

    public final void i0() {
        try {
            dismissAllowingStateLoss();
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public abstract void initView();

    public String j0() {
        return null;
    }

    public abstract void k0();

    public void l0(Window window) {
        Intrinsics.g(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = -2;
        window.setGravity(17);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(h0());
        }
        window.setAttributes(attributes);
    }

    public h newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.NormalDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        this.f51344b = this.f51343a.invoke(inflater, viewGroup, Boolean.FALSE);
        initView();
        View root = getMViewBinding().getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a.f51348a.a(j0());
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        k0();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        l0(window);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        try {
            manager.executePendingTransactions();
            if (!isAdded() && manager.findFragmentByTag(str) == null) {
                super.show(manager, str);
                a.f51348a.b(j0());
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }
}
