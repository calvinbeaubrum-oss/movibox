package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import kotlin.Metadata;
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
public final class LabLaneDialog extends BaseDialog implements View.OnClickListener {
    public LabLaneDialog() {
        super(R$layout.dialog_lab_lane);
    }

    public static final void p0(LabLaneDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void q0(xy.r viewBinding, LabLaneDialog this$0, View view) {
        Intrinsics.g(viewBinding, "$viewBinding");
        Intrinsics.g(this$0, "this$0");
        Editable text = viewBinding.f80934d.getText();
        if (text == null || text.length() == 0) {
            zp.b.f82110a.e("text is null~");
        } else {
            this$0.s0(text.toString());
            this$0.dismiss();
        }
    }

    public static final void r0(LabLaneDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Toast.makeText(this$0.getContext(), "reset success", 1).show();
        fp.b.f65208a.b("x-md-global-color", "");
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("x-md-global-color", "");
        }
        this$0.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.e(view, "null cannot be cast to non-null type android.widget.TextView");
        s0(((TextView) view).getText().toString());
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        final xy.r rVarA = xy.r.a(view);
        Intrinsics.f(rVarA, "bind(view)");
        MMKV mmkvC = ip.a.f67589a.c();
        String str = "";
        if (mmkvC != null && (string = mmkvC.getString("x-md-global-color", "")) != null) {
            str = string;
        }
        rVarA.f80940k.setText(str);
        rVarA.f80932b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.p0(this.f59400a, view2);
            }
        });
        rVarA.f80933c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.q0(rVarA, this, view2);
            }
        });
        rVarA.f80935f.setOnClickListener(this);
        rVarA.f80936g.setOnClickListener(this);
        rVarA.f80937h.setOnClickListener(this);
        rVarA.f80938i.setOnClickListener(this);
        rVarA.f80939j.setOnClickListener(this);
        rVarA.f80941l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLaneDialog.r0(this.f59405a, view2);
            }
        });
    }

    public final void s0(String str) {
        Toast.makeText(getContext(), "set \"" + str + "\" success", 1).show();
        fp.b.f65208a.b("x-md-global-color", str);
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("x-md-global-color", str);
        }
    }
}
