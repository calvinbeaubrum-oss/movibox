package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ClearHistoryDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f60496g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f60497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60498d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h00.q f60499f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClearHistoryDialog() {
        super(R$layout.download_clear_history_dialog_layout);
        this.f60498d = "clear";
    }

    public static final void o0(ClearHistoryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void p0(ClearHistoryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f60497c;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismissAllowingStateLoss();
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatTextView appCompatTextView;
        String string;
        AppCompatTextView appCompatTextView2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        h00.q qVarA = h00.q.a(view);
        this.f60499f = qVarA;
        if (qVarA != null && (appCompatTextView2 = qVarA.f65992b) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ClearHistoryDialog.o0(this.f60571a, view2);
                }
            });
        }
        h00.q qVar = this.f60499f;
        AppCompatTextView appCompatTextView3 = qVar != null ? qVar.f65993c : null;
        if (appCompatTextView3 != null) {
            String str = this.f60498d;
            if (Intrinsics.b(str, "clear_all")) {
                string = getString(R$string.clear_all_history);
            } else {
                string = Intrinsics.b(str, RequestParameters.SUBRESOURCE_DELETE) ? getString(R$string.delete) : getString(R$string.clear);
            }
            appCompatTextView3.setText(string);
        }
        h00.q qVar2 = this.f60499f;
        if (qVar2 == null || (appCompatTextView = qVar2.f65993c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClearHistoryDialog.p0(this.f60573a, view2);
            }
        });
    }

    public final void q0(FragmentManager manager, String str, String btnType, Function0<Unit> callback) {
        Intrinsics.g(manager, "manager");
        Intrinsics.g(btnType, "btnType");
        Intrinsics.g(callback, "callback");
        this.f60498d = btnType;
        this.f60497c = callback;
        show(manager, str);
    }
}
