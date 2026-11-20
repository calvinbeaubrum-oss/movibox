package com.transsion.search.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$style;
import com.transsion.search.dialog.CheckTipsDialog;
import kotlin.Metadata;
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
public final class CheckTipsDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f57442h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cx.a f57443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f57444d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f57446g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckTipsDialog a() {
            return new CheckTipsDialog();
        }
    }

    public CheckTipsDialog() {
        super(R$layout.dialog_check);
        this.f57444d = "";
        this.f57445f = "";
        this.f57446g = "";
    }

    private final void o0(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View viewFindViewById = view.findViewById(R$id.btn_left);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: cx.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CheckTipsDialog.p0(this.f62832a, view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R$id.btn_yes);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: cx.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CheckTipsDialog.q0(this.f62833a, view2);
                }
            });
        }
        if (!TextUtils.isEmpty(this.f57444d) && (textView3 = (TextView) view.findViewById(R$id.tv_tips)) != null) {
            textView3.setText(this.f57444d);
        }
        if (!TextUtils.isEmpty(this.f57445f) && (textView2 = (TextView) view.findViewById(R$id.btn_yes)) != null) {
            textView2.setText(this.f57445f);
        }
        if (TextUtils.isEmpty(this.f57446g) || (textView = (TextView) view.findViewById(R$id.btn_left)) == null) {
            return;
        }
        textView.setText(this.f57446g);
    }

    public static final void p0(CheckTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        cx.a aVar = this$0.f57443c;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(CheckTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        cx.a aVar = this$0.f57443c;
        if (aVar != null) {
            aVar.b();
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        o0(view);
    }

    public final void r0(cx.a listener) {
        Intrinsics.g(listener, "listener");
        this.f57443c = listener;
    }
}
