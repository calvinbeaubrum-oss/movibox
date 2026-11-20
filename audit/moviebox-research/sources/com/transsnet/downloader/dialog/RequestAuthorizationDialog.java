package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.push.PushConstants;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RequestAuthorizationDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f60559h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f60560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f60561d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h00.o f60562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f60563g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RequestAuthorizationDialog a() {
            return new RequestAuthorizationDialog();
        }
    }

    public RequestAuthorizationDialog() {
        super(R$layout.dialog_request_authorization);
    }

    private final void o0(View view) {
        AppCompatImageView appCompatImageView;
        View view2;
        h00.o oVarA = h00.o.a(view);
        this.f60562f = oVarA;
        if (oVarA != null && (view2 = oVarA.f65966b) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    RequestAuthorizationDialog.p0(this.f60585a, view3);
                }
            });
        }
        h00.o oVar = this.f60562f;
        if (oVar == null || (appCompatImageView = oVar.f65967c) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                RequestAuthorizationDialog.q0(this.f60587a, view3);
            }
        });
    }

    public static final void p0(RequestAuthorizationDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f60561d;
        if (function0 != null) {
            function0.invoke();
        }
        HashMap map = new HashMap();
        map.put("type", "allow");
        this$0.r0(map);
        this$0.f60563g = true;
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(RequestAuthorizationDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        HashMap map = new HashMap();
        map.put("type", "back");
        this$0.r0(map);
        this$0.f60563g = true;
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
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
    public void onDestroyView() {
        super.onDestroyView();
        HashMap map = new HashMap();
        map.put("type", "others");
        r0(map);
        this.f60563g = false;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.f60560c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        o0(view);
    }

    public final void r0(Map<String, String> map) {
        Intrinsics.g(map, "map");
        if (this.f60563g) {
            return;
        }
        com.transsion.baselib.report.m.f51277a.m("download_authorization", "click", map);
    }

    public final void s0(Function0<Unit> call) {
        Intrinsics.g(call, "call");
        this.f60561d = call;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        super.show(manager, str);
        HashMap map = new HashMap();
        map.put("action", PushConstants.PUSH_SERVICE_TYPE_SHOW);
        com.transsion.baselib.report.m.f51277a.t("download_authorization", "browse", map);
        BatteryPermissionUtils.f61124a.b();
    }
}
