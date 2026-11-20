package com.transsion.audio.adapter.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$style;
import com.transsion.audio.adapter.dialog.ClearTipsDialog;
import com.transsion.baseui.dialog.BaseDialog;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ClearTipsDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f50770h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public er.a f50771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50772d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50774g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClearTipsDialog a() {
            return new ClearTipsDialog();
        }
    }

    public ClearTipsDialog() {
        super(R$layout.clear_dialog_check);
        this.f50772d = "";
        this.f50773f = "";
        this.f50774g = "";
    }

    private final void o0(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View viewFindViewById = view.findViewById(R$id.btn_left);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: er.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ClearTipsDialog.p0(this.f64346a, view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R$id.btn_yes);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: er.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ClearTipsDialog.q0(this.f64347a, view2);
                }
            });
        }
        if (!TextUtils.isEmpty(this.f50772d) && (textView3 = (TextView) view.findViewById(R$id.tv_tips)) != null) {
            textView3.setText(this.f50772d);
        }
        if (!TextUtils.isEmpty(this.f50773f) && (textView2 = (TextView) view.findViewById(R$id.btn_yes)) != null) {
            textView2.setText(this.f50773f);
        }
        if (TextUtils.isEmpty(this.f50774g) || (textView = (TextView) view.findViewById(R$id.btn_left)) == null) {
            return;
        }
        textView.setText(this.f50774g);
    }

    public static final void p0(ClearTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        er.a aVar = this$0.f50771c;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void q0(ClearTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        er.a aVar = this$0.f50771c;
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

    public final void r0(er.a listener) {
        Intrinsics.g(listener, "listener");
        this.f50771c = listener;
    }
}
