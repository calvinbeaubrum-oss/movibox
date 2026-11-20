package com.transsion.usercenter.edit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.KeyboardUtils;
import com.tn.lib.widget.dialog.TRBaseDialog;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.edit.dialog.EditNameDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import tp.f;

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
@SourceDebugExtension
public final class EditNameDialog extends TRBaseDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditText f59314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f59315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f59316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f59317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f59318k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59319l = 50;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f59320m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void onDialogConfirm(String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f59321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59323c;

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable) || (editable != null && editable.length() == 0)) {
                TextView textView = EditNameDialog.this.f59316i;
                if (textView != null) {
                    textView.setBackgroundResource(R$drawable.bg_selector_edit_btn);
                }
            } else {
                TextView textView2 = EditNameDialog.this.f59316i;
                if (textView2 != null) {
                    textView2.setBackgroundResource(R$drawable.bg_btn_right_selector);
                }
            }
            EditText editText = EditNameDialog.this.f59314g;
            Integer numValueOf = editText != null ? Integer.valueOf(editText.getSelectionStart()) : null;
            Intrinsics.d(numValueOf);
            this.f59322b = numValueOf.intValue();
            EditText editText2 = EditNameDialog.this.f59314g;
            Integer numValueOf2 = editText2 != null ? Integer.valueOf(editText2.getSelectionEnd()) : null;
            Intrinsics.d(numValueOf2);
            this.f59323c = numValueOf2.intValue();
            CharSequence charSequence = this.f59321a;
            Integer numValueOf3 = charSequence != null ? Integer.valueOf(charSequence.length()) : null;
            Intrinsics.d(numValueOf3);
            if (numValueOf3.intValue() < EditNameDialog.this.f59319l) {
                EditNameDialog.this.f59320m = false;
                return;
            }
            if (EditNameDialog.this.f59320m) {
                EditNameDialog.this.f59320m = false;
                return;
            }
            zp.b.f82110a.d(R$string.profile_entre_limit);
            CharSequence charSequence2 = this.f59321a;
            Integer numValueOf4 = charSequence2 != null ? Integer.valueOf(charSequence2.length()) : null;
            Intrinsics.d(numValueOf4);
            if (numValueOf4.intValue() > EditNameDialog.this.f59319l) {
                if (editable != null) {
                    editable.delete(this.f59322b - 1, this.f59323c);
                }
                int i11 = this.f59323c;
                EditText editText3 = EditNameDialog.this.f59314g;
                if (editText3 != null) {
                    editText3.setText(editable);
                }
                EditText editText4 = EditNameDialog.this.f59314g;
                if (editText4 != null) {
                    editText4.setSelection(i11);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f59321a = charSequence;
        }
    }

    public static final void u0(EditNameDialog this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f59320m = true;
        EditText editText = this$0.f59314g;
        if (editText != null) {
            editText.setText(this$0.f59318k);
        }
        EditText editText2 = this$0.f59314g;
        if (editText2 != null) {
            editText2.setSelection(this$0.f59318k.length());
        }
    }

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public int h0() {
        return R$layout.dialog_edit_nickname_layout;
    }

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public void i0(View view) {
        EditText editText;
        Intrinsics.g(view, "view");
        this.f59314g = (EditText) view.findViewById(R$id.ed_msg);
        this.f59315h = (TextView) view.findViewById(R$id.tv_left);
        this.f59316i = (TextView) view.findViewById(R$id.tv_right);
        TextView textView = this.f59315h;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.f59316i;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        EditText editText2 = this.f59314g;
        if (editText2 != null) {
            editText2.requestFocus();
        }
        EditText editText3 = this.f59314g;
        if (editText3 != null) {
            editText3.addTextChangedListener(new b());
        }
        if (!TextUtils.isEmpty(this.f59318k) && (editText = this.f59314g) != null) {
            editText.postDelayed(new Runnable() { // from class: bz.a
                @Override // java.lang.Runnable
                public final void run() {
                    EditNameDialog.u0(this.f14522a);
                }
            }, 200L);
        }
        KeyboardUtils.h();
    }

    @Override // androidx.fragment.app.DialogFragment
    public boolean isCancelable() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Editable text;
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.tv_left;
        if (numValueOf == null || numValueOf.intValue() != i11) {
            int i12 = R$id.tv_right;
            if (numValueOf != null && numValueOf.intValue() == i12) {
                t0(view);
                return;
            }
            return;
        }
        EditText editText = this.f59314g;
        if (editText != null && (text = editText.getText()) != null) {
            text.clear();
        }
        KeyboardUtils.e(view);
        g0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Dialog dialog;
        Window window;
        Context context = getContext();
        if (context != null && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setLayout(f.f77260a.a(context, 280.0f), -2);
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        TextView textView = this.f59315h;
        Intrinsics.d(textView);
        KeyboardUtils.e(textView);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyboardUtils.d(activity);
        }
        a aVar = this.f59317j;
        if (aVar != null) {
            aVar.onDialogConfirm("");
        }
    }

    public final void t0(View view) {
        EditText editText = this.f59314g;
        String string = StringsKt__StringsKt.Z0(String.valueOf(editText != null ? editText.getText() : null)).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (TextUtils.equals(this.f59318k, string)) {
            g0();
            return;
        }
        String strF = l.F(l.F(string, "\\n", "", false, 4, null), "\\t", "", false, 4, null);
        this.f59318k = strF;
        a aVar = this.f59317j;
        if (aVar != null) {
            aVar.onDialogConfirm(strF);
        }
        g0();
    }

    public final void v0(Context context, a listener, String text) {
        Intrinsics.g(context, "context");
        Intrinsics.g(listener, "listener");
        Intrinsics.g(text, "text");
        this.f59317j = listener;
        this.f59318k = text;
        l0(context, "");
    }
}
