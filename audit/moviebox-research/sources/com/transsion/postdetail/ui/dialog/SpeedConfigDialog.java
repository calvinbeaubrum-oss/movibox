package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.R$style;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SpeedConfigDialog extends BaseDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55617d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f55616c = FragmentViewModelLazyKt.a(this, Reflection.b(j.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.dialog.SpeedConfigDialog$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.dialog.SpeedConfigDialog$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float[] f55618f = {Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(2.0f)};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Float, GradientTextView> f55619g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f55620h = LocalVideoPlayerConfigMmkv.f51172a.c();

    private final j n0() {
        return (j) this.f55616c.getValue();
    }

    public static final void o0(SpeedConfigDialog this$0, float f11, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.q0(f11);
    }

    private final void q0(float f11) {
        float f12 = this.f55620h;
        if (f12 == f11) {
            return;
        }
        GradientTextView gradientTextView = this.f55619g.get(Float.valueOf(f12));
        if (gradientTextView != null) {
            gradientTextView.setTextColor(-1);
        }
        GradientTextView gradientTextView2 = this.f55619g.get(Float.valueOf(f11));
        if (gradientTextView2 != null) {
            gradientTextView2.setGradientColors(z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_center), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end));
        }
        this.f55620h = f11;
        n0().c(f11);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.DownloadBottomDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_speed_config, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_root);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.blankj.utilcode.util.i.e(48.0f));
        for (Float f11 : this.f55618f) {
            final float fFloatValue = f11.floatValue();
            Context context = view.getContext();
            Intrinsics.f(context, "view.context");
            GradientTextView gradientTextView = new GradientTextView(context, null, 0, 6, null);
            gradientTextView.setGravity(17);
            if (this.f55620h == fFloatValue) {
                gradientTextView.setGradientColors(z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_center), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end));
            } else {
                gradientTextView.setGradientColors(z2.a.getColor(Utils.a(), R$color.white), z2.a.getColor(Utils.a(), R$color.white), z2.a.getColor(Utils.a(), R$color.white));
            }
            gradientTextView.setTextSize(16.0f);
            Context context2 = view.getContext();
            Intrinsics.f(context2, "view.context");
            gradientTextView.setTypeface(so.a.c(context2));
            int i11 = (int) fFloatValue;
            gradientTextView.setText(i11 == fFloatValue ? i11 + "x" : fFloatValue + "x");
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SpeedConfigDialog.o0(this.f55630a, fFloatValue, view2);
                }
            });
            linearLayout.addView(gradientTextView, layoutParams);
            this.f55619g.put(Float.valueOf(fFloatValue), gradientTextView);
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(null);
        if (this.f55617d) {
            window.setWindowAnimations(com.tn.lib.widget.R$style.bottom_dialog_animation);
            window.setGravity(80);
            window.setLayout(-1, -2);
        } else {
            window.setWindowAnimations(com.tn.lib.widget.R$style.ActionSheetDialogRight);
            window.setGravity(GravityCompat.END);
            window.setLayout(f0.a(140.0f), -1);
        }
        ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
        immersionBarWith.hideBar(BarHide.FLAG_HIDE_BAR);
        immersionBarWith.init();
    }

    public final void p0(boolean z11) {
        this.f55617d = z11;
    }
}
