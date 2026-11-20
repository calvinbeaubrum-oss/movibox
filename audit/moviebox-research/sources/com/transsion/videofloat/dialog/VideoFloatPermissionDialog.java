package com.transsion.videofloat.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.permissionx.guolindev.dialog.RationaleDialog;
import com.transsion.baseui.R$style;
import com.transsion.videofloat.R$layout;
import com.transsion.videofloat.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import wz.a;

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
public final class VideoFloatPermissionDialog extends RationaleDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f60028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f60029d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super View, Unit> f60030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super View, Unit> f60031g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoFloatPermissionDialog(boolean z11, List<String> permissions) {
        super(R$layout.dialog_video_float_permission);
        Intrinsics.g(permissions, "permissions");
        this.f60028c = z11;
        this.f60029d = permissions;
    }

    private final void p0(View view) {
        a aVarA = a.a(view);
        Intrinsics.f(aVarA, "bind(view)");
        aVarA.f79769f.setText(Utils.a().getString(this.f60028c ? R$string.video_float_tips_pip : R$string.video_float_tips_v2));
        Function1<? super View, Unit> function1 = this.f60030f;
        if (function1 != null) {
            function1.invoke(aVarA.f79768d);
        }
        Function1<? super View, Unit> function2 = this.f60031g;
        if (function2 != null) {
            function2.invoke(aVarA.f79766b);
        }
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public List<String> m0() {
        return this.f60029d;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void n0(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f60031g = callback;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void o0(Function1<? super View, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f60030f = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.NormalDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(c.f() ? com.tn.lib.widget.R$style.ActionSheetDialogLeft : com.tn.lib.widget.R$style.ActionSheetDialogRight);
            window.setGravity(c.f() ? GravityCompat.START : GravityCompat.END);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(null);
            window.setLayout(f0.a(360.0f), -1);
            ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
            immersionBarWith.hideBar(BarHide.FLAG_HIDE_BAR);
            immersionBarWith.init();
        }
        p0(view);
    }
}
