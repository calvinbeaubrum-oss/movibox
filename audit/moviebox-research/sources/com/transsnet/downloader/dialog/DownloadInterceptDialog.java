package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$style;
import com.transsnet.downloader.manager.DownloadInterceptManager;
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
public final class DownloadInterceptDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f60512h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f60513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f60514d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h00.h f60515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f60516g;

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

    public DownloadInterceptDialog() {
        super(R$layout.dialog_download_intercept);
    }

    private final void p0(View view) {
        AppCompatImageView appCompatImageView;
        TextView textView;
        View view2;
        h00.h hVarA = h00.h.a(view);
        this.f60515f = hVarA;
        if (hVarA != null && (view2 = hVarA.f65880c) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DownloadInterceptDialog.q0(this.f60584a, view3);
                }
            });
        }
        h00.h hVar = this.f60515f;
        if (hVar != null && (textView = hVar.f65879b) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DownloadInterceptDialog.r0(this.f60586a, view3);
                }
            });
        }
        h00.h hVar2 = this.f60515f;
        if (hVar2 == null || (appCompatImageView = hVar2.f65883g) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DownloadInterceptDialog.s0(this.f60588a, view3);
            }
        });
    }

    public static final void q0(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.f60514d;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(DownloadInterceptManager.f61008a.d()));
        }
        HashMap map = new HashMap();
        map.put("type", "watch_ad");
        this$0.t0(map);
        this$0.f60516g = true;
    }

    public static final void r0(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.f60514d;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(DownloadInterceptManager.f61008a.c()));
        }
        HashMap map = new HashMap();
        map.put("type", AppLovinEventTypes.USER_SHARED_LINK);
        this$0.t0(map);
        this$0.f60516g = true;
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        HashMap map = new HashMap();
        map.put("type", "back");
        this$0.t0(map);
        this$0.f60516g = true;
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
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
        this.f60516g = false;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.f60513c;
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
        com.transsion.baselib.report.m.f51277a.t("download_intercept", "browse", new HashMap());
    }

    public final void t0(Map<String, String> map) {
        Intrinsics.g(map, "map");
        if (this.f60516g) {
            return;
        }
        com.transsion.baselib.report.m.f51277a.m("download_intercept", "click", map);
    }
}
