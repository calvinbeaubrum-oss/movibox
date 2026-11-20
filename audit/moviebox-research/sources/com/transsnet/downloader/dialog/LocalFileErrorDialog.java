package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$style;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class LocalFileErrorDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f60554h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f60555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f60556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h00.n f60557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f60558g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LocalFileErrorDialog() {
        super(R$layout.dialog_local_file_error);
    }

    private final void p0(View view) {
        AppCompatImageView appCompatImageView;
        BLTextView bLTextView;
        View view2;
        h00.n nVarA = h00.n.a(view);
        this.f60557f = nVarA;
        if (nVarA != null && (view2 = nVarA.f65959c) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LocalFileErrorDialog.q0(this.f60579a, view3);
                }
            });
        }
        h00.n nVar = this.f60557f;
        if (nVar != null && (bLTextView = nVar.f65958b) != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LocalFileErrorDialog.r0(this.f60581a, view3);
                }
            });
        }
        h00.n nVar2 = this.f60557f;
        if (nVar2 == null || (appCompatImageView = nVar2.f65960d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LocalFileErrorDialog.s0(this.f60583a, view3);
            }
        });
    }

    public static final void q0(LocalFileErrorDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.f60556d;
        if (function1 != null) {
            function1.invoke(1);
        }
        HashMap map = new HashMap();
        map.put("type", DownloadBaseRunnable.TAG);
        this$0.t0(map);
        this$0.f60558g = true;
        this$0.dismissAllowingStateLoss();
    }

    public static final void r0(LocalFileErrorDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.f60556d;
        if (function1 != null) {
            function1.invoke(2);
        }
        HashMap map = new HashMap();
        map.put("type", RequestParameters.SUBRESOURCE_DELETE);
        this$0.t0(map);
        this$0.f60558g = true;
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(LocalFileErrorDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        HashMap map = new HashMap();
        map.put("type", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        this$0.t0(map);
        this$0.f60558g = true;
        this$0.dismissAllowingStateLoss();
    }

    private final void t0(Map<String, String> map) {
        if (this.f60558g) {
            return;
        }
        com.transsion.baselib.report.m.f51277a.m("local_file_do_not_exist", "click", map);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        androidx.appcompat.app.w wVar = new androidx.appcompat.app.w(contextRequireContext, getTheme());
        Window window = wVar.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        wVar.setCancelable(false);
        wVar.setCanceledOnTouchOutside(false);
        return wVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HashMap map = new HashMap();
        map.put("type", "others");
        t0(map);
        this.f60558g = false;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.f60555c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        p0(view);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        super.show(manager, str);
        com.transsion.baselib.report.m.f51277a.t("local_file_do_not_exist", "browse", new HashMap());
    }

    public final void u0(Function1<? super Integer, Unit> call) {
        Intrinsics.g(call, "call");
        this.f60556d = call;
    }
}
