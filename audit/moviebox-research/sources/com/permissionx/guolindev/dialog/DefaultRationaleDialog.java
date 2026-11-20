package com.permissionx.guolindev.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatTextView;
import co.a;
import com.google.android.material.bottomsheet.b;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLView;
import com.permissionx.guolindev.R$layout;
import com.transsion.baseui.R$style;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public final class DefaultRationaleDialog extends RationaleDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super View, Unit> f48643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super View, Unit> f48644d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f48645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f48646g;

    public DefaultRationaleDialog() {
        super(R$layout.permissionx_dialog_def);
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public List<String> m0() {
        List<String> list = this.f48645f;
        return list == null ? new ArrayList() : list;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void n0(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f48644d = callback;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void o0(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f48643c = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        b bVar = new b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.0f);
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Integer numC;
        Context context;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        bo.a aVarA = bo.a.a(view);
        Intrinsics.f(aVarA, "bind(view)");
        a aVar = this.f48646g;
        if ((aVar != null ? aVar.b() : null) != null && (context = getContext()) != null) {
            BLView bLView = aVarA.f14299h;
            DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(p0(context, 36.0f));
            Resources resources = context.getResources();
            a aVar2 = this.f48646g;
            Intrinsics.d(aVar2);
            Integer numB = aVar2.b();
            Intrinsics.d(numB);
            bLView.setBackground(cornersRadius.setSolidColor(resources.getColor(numB.intValue())).build());
        }
        a aVar3 = this.f48646g;
        if (aVar3 != null && (numC = aVar3.c()) != null) {
            aVarA.f14295c.setImageResource(numC.intValue());
        }
        AppCompatTextView appCompatTextView = aVarA.f14298g;
        Intrinsics.f(appCompatTextView, "viewBinding.tvTitle");
        a aVar4 = this.f48646g;
        String strE = aVar4 != null ? aVar4.e() : null;
        appCompatTextView.setVisibility((strE == null || strE.length() == 0) ^ true ? 0 : 8);
        AppCompatTextView appCompatTextView2 = aVarA.f14298g;
        a aVar5 = this.f48646g;
        appCompatTextView2.setText(aVar5 != null ? aVar5.e() : null);
        AppCompatTextView appCompatTextView3 = aVarA.f14297f;
        Intrinsics.f(appCompatTextView3, "viewBinding.tvSubtitle");
        a aVar6 = this.f48646g;
        String strD = aVar6 != null ? aVar6.d() : null;
        appCompatTextView3.setVisibility((strD == null || strD.length() == 0) ^ true ? 0 : 8);
        AppCompatTextView appCompatTextView4 = aVarA.f14297f;
        a aVar7 = this.f48646g;
        appCompatTextView4.setText(aVar7 != null ? aVar7.d() : null);
        AppCompatTextView appCompatTextView5 = aVarA.f14296d;
        a aVar8 = this.f48646g;
        appCompatTextView5.setText(aVar8 != null ? aVar8.a() : null);
        Function1<? super View, Unit> function1 = this.f48643c;
        if (function1 != null) {
            function1.invoke(aVarA.f14296d);
        }
        Function1<? super View, Unit> function2 = this.f48644d;
        if (function2 != null) {
            function2.invoke(aVarA.f14294b);
        }
    }

    public final int p0(Context context, float f11) {
        Intrinsics.g(context, "context");
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }

    public final void q0(List<String> permissions, a dialogInfo) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(dialogInfo, "dialogInfo");
        this.f48645f = permissions;
        this.f48646g = dialogInfo;
    }
}
