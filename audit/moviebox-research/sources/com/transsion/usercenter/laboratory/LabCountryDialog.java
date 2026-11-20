package com.transsion.usercenter.laboratory;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class LabCountryDialog extends BaseDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xy.n f59347d;

    public LabCountryDialog() {
        super(R$layout.dialog_lab_country);
        this.f59346c = LazyKt__LazyJVMKt.b(new Function0<qq.a>() { // from class: com.transsion.usercenter.laboratory.LabCountryDialog$localMccDao$2
            @Override // kotlin.jvm.functions.Function0
            public final qq.a invoke() {
                MbAdDatabase.e eVar = MbAdDatabase.f50387p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return eVar.b(applicationA).M();
            }
        });
    }

    public static final void v0(LabCountryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void w0(LabCountryDialog this$0, View view) {
        EditTextWithClear editTextWithClear;
        Intrinsics.g(this$0, "this$0");
        xy.n nVar = this$0.f59347d;
        this$0.u0(String.valueOf((nVar == null || (editTextWithClear = nVar.f80872d) == null) ? null : editTextWithClear.getText()));
    }

    public static final void x0(LabCountryDialog this$0, View view) {
        AppCompatTextView appCompatTextView;
        CharSequence text;
        Intrinsics.g(this$0, "this$0");
        xy.n nVar = this$0.f59347d;
        this$0.u0((nVar == null || (appCompatTextView = nVar.f80875h) == null || (text = appCompatTextView.getText()) == null) ? null : text.toString());
    }

    public static final void y0(LabCountryDialog this$0, View view) {
        AppCompatTextView appCompatTextView;
        CharSequence text;
        Intrinsics.g(this$0, "this$0");
        xy.n nVar = this$0.f59347d;
        this$0.u0((nVar == null || (appCompatTextView = nVar.f80874g) == null || (text = appCompatTextView.getText()) == null) ? null : text.toString());
    }

    public static final void z0(LabCountryDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Toast.makeText(this$0.getContext(), "reset success", 1).show();
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("sp_code", "");
        }
        this$0.dismiss();
    }

    public final void A0(String str, String str2) {
        Toast.makeText(getContext(), "set value:" + str + " mcc: \"" + str2 + "\" success", 1).show();
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null) {
            mmkvC.putString("sp_code", str2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strValueOf;
        EditTextWithClear editTextWithClear;
        if (view instanceof AppCompatTextView) {
            strValueOf = ((AppCompatTextView) view).getText().toString();
        } else {
            xy.n nVar = this.f59347d;
            strValueOf = String.valueOf((nVar == null || (editTextWithClear = nVar.f80872d) == null) ? null : editTextWithClear.getText());
        }
        u0(strValueOf);
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
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f59347d = xy.n.a(view);
        MMKV mmkvC = ip.a.f67589a.c();
        String string = mmkvC != null ? mmkvC.getString("sp_code", "") : null;
        xy.n nVar = this.f59347d;
        AppCompatTextView appCompatTextView6 = nVar != null ? nVar.f80873f : null;
        if (appCompatTextView6 != null) {
            appCompatTextView6.setText(string);
        }
        xy.n nVar2 = this.f59347d;
        if (nVar2 != null && (appCompatTextView5 = nVar2.f80870b) != null) {
            appCompatTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabCountryDialog.v0(this.f59373a, view2);
                }
            });
        }
        xy.n nVar3 = this.f59347d;
        if (nVar3 != null && (appCompatTextView4 = nVar3.f80871c) != null) {
            appCompatTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabCountryDialog.w0(this.f59375a, view2);
                }
            });
        }
        xy.n nVar4 = this.f59347d;
        if (nVar4 != null && (appCompatTextView3 = nVar4.f80875h) != null) {
            appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabCountryDialog.x0(this.f59377a, view2);
                }
            });
        }
        xy.n nVar5 = this.f59347d;
        if (nVar5 != null && (appCompatTextView2 = nVar5.f80874g) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabCountryDialog.y0(this.f59380a, view2);
                }
            });
        }
        xy.n nVar6 = this.f59347d;
        if (nVar6 == null || (appCompatTextView = nVar6.f80876i) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabCountryDialog.z0(this.f59382a, view2);
            }
        });
    }

    public final qq.a t0() {
        return (qq.a) this.f59346c.getValue();
    }

    public final void u0(String str) {
        if (str == null || str.length() == 0) {
            zp.b.f82110a.e("text is null~");
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new LabCountryDialog$handleMcc$1(this, str, null), 3, null);
        }
    }
}
