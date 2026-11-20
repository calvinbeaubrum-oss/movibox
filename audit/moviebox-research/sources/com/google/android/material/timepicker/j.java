package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChipTextInputComboView f37963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChipTextInputComboView f37964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeModel f37965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f37966d = false;

    public j(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f37963a = chipTextInputComboView;
        this.f37964b = chipTextInputComboView2;
        this.f37965c = timeModel;
    }

    public void a() {
        TextInputLayout textInputLayoutE = this.f37963a.e();
        TextInputLayout textInputLayoutE2 = this.f37964b.e();
        EditText editText = textInputLayoutE.getEditText();
        EditText editText2 = textInputLayoutE2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public final void b(EditText editText) {
        if (editText.getSelectionStart() == 0 && editText.length() == 2) {
            editText.getText().clear();
        }
    }

    public final void c(int i11) {
        this.f37964b.setChecked(i11 == 12);
        this.f37963a.setChecked(i11 == 10);
        this.f37965c.f37930d = i11;
    }

    public final boolean d(int i11, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i11 >= 7 && i11 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            c(12);
            return true;
        }
        b(editText);
        return false;
    }

    public final boolean e(int i11, KeyEvent keyEvent, EditText editText) {
        if (i11 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            c(10);
            return true;
        }
        b(editText);
        return false;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        boolean z11 = i11 == 5;
        if (z11) {
            c(12);
        }
        return z11;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (this.f37966d) {
            return false;
        }
        this.f37966d = true;
        EditText editText = (EditText) view;
        boolean zE = this.f37965c.f37930d == 12 ? e(i11, keyEvent, editText) : d(i11, keyEvent, editText);
        this.f37966d = false;
        return zE;
    }
}
