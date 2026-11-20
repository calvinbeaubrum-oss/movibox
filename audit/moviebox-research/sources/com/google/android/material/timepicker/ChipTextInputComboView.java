package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.f0;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chip f37857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f37858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f37859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextWatcher f37860d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f37861f;

    /* JADX INFO: compiled from: source.java */
    public class b extends a0 {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f37857a.setText(ChipTextInputComboView.this.d("00"));
                return;
            }
            String strD = ChipTextInputComboView.this.d(editable);
            Chip chip = ChipTextInputComboView.this.f37857a;
            if (TextUtils.isEmpty(strD)) {
                strD = ChipTextInputComboView.this.d("00");
            }
            chip.setText(strD);
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f37857a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f37858b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f37859c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f37860d = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f37861f = (TextView) findViewById(R$id.material_label);
        editText.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.f37861f, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f37859c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f37859c.setFilters(inputFilterArr);
    }

    public final String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    public TextInputLayout e() {
        return this.f37858b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f37857a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        String strD = d(charSequence);
        this.f37857a.setText(strD);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        this.f37859c.removeTextChangedListener(this.f37860d);
        this.f37859c.setText(strD);
        this.f37859c.addTextChangedListener(this.f37860d);
    }

    public final void h() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f37859c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f37857a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z11) {
        this.f37857a.setChecked(z11);
        this.f37859c.setVisibility(z11 ? 0 : 4);
        this.f37857a.setVisibility(z11 ? 8 : 0);
        if (isChecked()) {
            f0.t(this.f37859c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f37857a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i11, Object obj) {
        this.f37857a.setTag(i11, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f37857a.toggle();
    }
}
