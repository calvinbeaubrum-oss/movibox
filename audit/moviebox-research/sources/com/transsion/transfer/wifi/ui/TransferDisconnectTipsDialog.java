package com.transsion.transfer.wifi.ui;

import android.os.Bundle;
import android.view.View;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.R$style;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class TransferDisconnectTipsDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f59203c;

    public TransferDisconnectTipsDialog() {
        super(R$layout.dialog_transfer_disconnect);
    }

    public static final void o0(TransferDisconnectTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f59203c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public static final void p0(TransferDisconnectTipsDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        Function1<? super Boolean, Unit> function1 = this$0.f59203c;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
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
        ky.f fVarA = ky.f.a(view);
        Intrinsics.f(fVarA, "bind(view)");
        fVarA.f69691b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TransferDisconnectTipsDialog.o0(this.f59228a, view2);
            }
        });
        fVarA.f69692c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.wifi.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TransferDisconnectTipsDialog.p0(this.f59229a, view2);
            }
        });
    }

    public final void q0(Function1<? super Boolean, Unit> call) {
        Intrinsics.g(call, "call");
        this.f59203c = call;
    }
}
