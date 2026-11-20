package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class x extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public EditText f37845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f37846g;

    public x(@NonNull r rVar, int i11) {
        super(rVar);
        this.f37844e = R$drawable.design_password_eye;
        this.f37846g = new View.OnClickListener() { // from class: com.google.android.material.textfield.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f37843a.y(view);
            }
        };
        if (i11 != 0) {
            this.f37844e = i11;
        }
    }

    public static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f37845f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f37845f.setTransformationMethod(null);
        } else {
            this.f37845f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f37845f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void b(CharSequence charSequence, int i11, int i12, int i13) {
        r();
    }

    @Override // com.google.android.material.textfield.s
    @StringRes
    public int c() {
        return R$string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return this.f37844e;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f37846g;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.s
    public void n(@Nullable EditText editText) {
        this.f37845f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        if (x(this.f37845f)) {
            this.f37845f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f37845f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f37845f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
