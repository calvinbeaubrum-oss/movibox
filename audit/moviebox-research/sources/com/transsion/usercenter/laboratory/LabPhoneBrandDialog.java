package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.EditTextWithClear;
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
public final class LabPhoneBrandDialog extends BaseDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xy.l f59351c;

    public LabPhoneBrandDialog() {
        super(R$layout.dialog_lab_brand);
    }

    public static final void q0(LabPhoneBrandDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void r0(LabPhoneBrandDialog this$0, View view) {
        EditTextWithClear editTextWithClear;
        Intrinsics.g(this$0, "this$0");
        xy.l lVar = this$0.f59351c;
        this$0.p0(String.valueOf((lVar == null || (editTextWithClear = lVar.f80849d) == null) ? null : editTextWithClear.getText()));
        this$0.dismiss();
    }

    public static final void s0(LabPhoneBrandDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Toast.makeText(this$0.getContext(), "reset success", 1).show();
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("phone_brand", "");
        }
        this$0.dismiss();
    }

    private final void t0(String str) {
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("phone_brand", str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p0(view instanceof TextView ? ((TextView) view).getText().toString() : "");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59351c = xy.l.a(view);
        MMKV mmkvC = ip.a.f67589a.c();
        String string = mmkvC != null ? mmkvC.getString("phone_brand", "") : null;
        xy.l lVar = this.f59351c;
        AppCompatTextView appCompatTextView8 = lVar != null ? lVar.f80850f : null;
        if (appCompatTextView8 != null) {
            appCompatTextView8.setText(string);
        }
        xy.l lVar2 = this.f59351c;
        if (lVar2 != null && (appCompatTextView7 = lVar2.f80847b) != null) {
            appCompatTextView7.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabPhoneBrandDialog.q0(this.f59415a, view2);
                }
            });
        }
        xy.l lVar3 = this.f59351c;
        if (lVar3 != null && (appCompatTextView6 = lVar3.f80848c) != null) {
            appCompatTextView6.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabPhoneBrandDialog.r0(this.f59417a, view2);
                }
            });
        }
        xy.l lVar4 = this.f59351c;
        if (lVar4 != null && (appCompatTextView5 = lVar4.f80854j) != null) {
            appCompatTextView5.setOnClickListener(this);
        }
        xy.l lVar5 = this.f59351c;
        if (lVar5 != null && (appCompatTextView4 = lVar5.f80851g) != null) {
            appCompatTextView4.setOnClickListener(this);
        }
        xy.l lVar6 = this.f59351c;
        if (lVar6 != null && (appCompatTextView3 = lVar6.f80852h) != null) {
            appCompatTextView3.setOnClickListener(this);
        }
        xy.l lVar7 = this.f59351c;
        if (lVar7 != null && (appCompatTextView2 = lVar7.f80853i) != null) {
            appCompatTextView2.setOnClickListener(this);
        }
        xy.l lVar8 = this.f59351c;
        if (lVar8 == null || (appCompatTextView = lVar8.f80855k) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabPhoneBrandDialog.s0(this.f59419a, view2);
            }
        });
    }

    public final void p0(String str) {
        if (str == null || str.length() == 0) {
            zp.b.f82110a.e("text is null~");
            return;
        }
        t0(str);
        Toast.makeText(getContext(), "set brand:" + str + " success", 1).show();
        dismiss();
    }
}
