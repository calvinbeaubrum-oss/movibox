package com.transsion.usercenter.laboratory;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseViewBindingDialog;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$style;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class LabLocationDialog extends BaseViewBindingDialog<xy.s> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59349d = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void q0(LabLocationDialog this$0, View view) {
        EditTextWithClear editTextWithClear;
        Editable text;
        EditTextWithClear editTextWithClear2;
        Editable text2;
        EditTextWithClear editTextWithClear3;
        Editable text3;
        EditTextWithClear editTextWithClear4;
        Editable text4;
        Intrinsics.g(this$0, "this$0");
        xy.s sVarN0 = this$0.n0();
        String string = null;
        String string2 = (sVarN0 == null || (editTextWithClear4 = sVarN0.f80956f) == null || (text4 = editTextWithClear4.getText()) == null) ? null : text4.toString();
        xy.s sVarN1 = this$0.n0();
        String string3 = (sVarN1 == null || (editTextWithClear3 = sVarN1.f80957g) == null || (text3 = editTextWithClear3.getText()) == null) ? null : text3.toString();
        xy.s sVarN2 = this$0.n0();
        String string4 = (sVarN2 == null || (editTextWithClear2 = sVarN2.f80958h) == null || (text2 = editTextWithClear2.getText()) == null) ? null : text2.toString();
        xy.s sVarN3 = this$0.n0();
        if (sVarN3 != null && (editTextWithClear = sVarN3.f80955d) != null && (text = editTextWithClear.getText()) != null) {
            string = text.toString();
        }
        if (string2 == null || string2.length() == 0) {
            Toast.makeText(this$0.getContext(), "lat is empty", 1).show();
            return;
        }
        if (string3 == null || string3.length() == 0) {
            Toast.makeText(this$0.getContext(), "lon is empty", 1).show();
            return;
        }
        if (string4 == null || string4.length() == 0) {
            Toast.makeText(this$0.getContext(), "name is empty", 1).show();
            return;
        }
        if (string == null || string.length() == 0) {
            Toast.makeText(this$0.getContext(), "address is empty", 1).show();
            return;
        }
        RoomAppMMKV.f51271a.a().putString("key_lo_mock_test_lab_lat", string2 + "|" + string3 + "|" + string4 + "|" + string);
        this$0.dismiss();
    }

    public static final void r0(LabLocationDialog this$0, View view) {
        EditTextWithClear editTextWithClear;
        EditTextWithClear editTextWithClear2;
        EditTextWithClear editTextWithClear3;
        EditTextWithClear editTextWithClear4;
        Intrinsics.g(this$0, "this$0");
        RoomAppMMKV.f51271a.a().putString("key_lo_mock_test_lab_lat", "");
        xy.s sVarN0 = this$0.n0();
        if (sVarN0 != null && (editTextWithClear4 = sVarN0.f80956f) != null) {
            editTextWithClear4.setText("");
        }
        xy.s sVarN1 = this$0.n0();
        if (sVarN1 != null && (editTextWithClear3 = sVarN1.f80957g) != null) {
            editTextWithClear3.setText("");
        }
        xy.s sVarN2 = this$0.n0();
        if (sVarN2 != null && (editTextWithClear2 = sVarN2.f80958h) != null) {
            editTextWithClear2.setText("");
        }
        xy.s sVarN3 = this$0.n0();
        if (sVarN3 != null && (editTextWithClear = sVarN3.f80955d) != null) {
            editTextWithClear.setText("");
        }
        this$0.dismiss();
    }

    @Override // com.transsion.baseui.dialog.BaseViewBindingDialog
    public Function3<LayoutInflater, ViewGroup, Boolean, xy.s> m0() {
        return LabLocationDialog$bindingInflater$1.INSTANCE;
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
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        String string = RoomAppMMKV.f51271a.a().getString("key_lo_mock_test_lab_lat", "");
        if (string != null && string.length() != 0 && StringsKt__StringsKt.Q(string, "|", false, 2, null)) {
            List listE0 = StringsKt__StringsKt.E0(string, new String[]{"|"}, false, 0, 6, null);
            xy.s sVarN0 = n0();
            if (sVarN0 != null) {
                sVarN0.f80956f.setText((CharSequence) listE0.get(0));
                sVarN0.f80957g.setText((CharSequence) listE0.get(1));
                sVarN0.f80958h.setText((CharSequence) listE0.get(2));
                sVarN0.f80955d.setText((CharSequence) listE0.get(3));
            }
        }
        xy.s sVarN1 = n0();
        if (sVarN1 != null && (appCompatTextView2 = sVarN1.f80953b) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LabLocationDialog.q0(this.f59407a, view2);
                }
            });
        }
        xy.s sVarN2 = n0();
        if (sVarN2 == null || (appCompatTextView = sVarN2.f80954c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabLocationDialog.r0(this.f59409a, view2);
            }
        });
    }
}
