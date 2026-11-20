package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.f0;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class l implements TimePickerView.f, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f37968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeModel f37969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextWatcher f37970c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f37971d = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChipTextInputComboView f37972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ChipTextInputComboView f37973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f37974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final EditText f37975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EditText f37976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaterialButtonToggleGroup f37977k;

    /* JADX INFO: compiled from: source.java */
    public class a extends a0 {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    l.this.f37969b.i(0);
                } else {
                    l.this.f37969b.i(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends a0 {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    l.this.f37969b.h(0);
                } else {
                    l.this.f37969b.h(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.c(((Integer) view.getTag(R$id.selection_type)).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends com.google.android.material.timepicker.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimeModel f37981b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, int i11, TimeModel timeModel) {
            super(context, i11);
            this.f37981b = timeModel;
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(this.f37981b.c(), String.valueOf(this.f37981b.d())));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends com.google.android.material.timepicker.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimeModel f37983b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, int i11, TimeModel timeModel) {
            super(context, i11);
            this.f37983b = timeModel;
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(this.f37983b.f37929c)));
        }
    }

    public l(LinearLayout linearLayout, TimeModel timeModel) {
        this.f37968a = linearLayout;
        this.f37969b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_minute_text_input);
        this.f37972f = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_hour_text_input);
        this.f37973g = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R$id.material_label);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R$id.material_label);
        textView.setText(resources.getString(R$string.material_timepicker_minute));
        textView2.setText(resources.getString(R$string.material_timepicker_hour));
        chipTextInputComboView.setTag(R$id.selection_type, 12);
        chipTextInputComboView2.setTag(R$id.selection_type, 10);
        if (timeModel.f37927a == 0) {
            k();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.e());
        chipTextInputComboView.c(timeModel.f());
        this.f37975i = chipTextInputComboView2.e().getEditText();
        this.f37976j = chipTextInputComboView.e().getEditText();
        this.f37974h = new j(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new d(linearLayout.getContext(), R$string.material_hour_selection, timeModel));
        chipTextInputComboView.f(new e(linearLayout.getContext(), R$string.material_minute_selection, timeModel));
        f();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void c(int i11) {
        this.f37969b.f37930d = i11;
        this.f37972f.setChecked(i11 == 12);
        this.f37973g.setChecked(i11 == 10);
        l();
    }

    public final void d() {
        this.f37975i.addTextChangedListener(this.f37971d);
        this.f37976j.addTextChangedListener(this.f37970c);
    }

    public void e() {
        this.f37972f.setChecked(false);
        this.f37973g.setChecked(false);
    }

    public void f() {
        d();
        j(this.f37969b);
        this.f37974h.a();
    }

    public final /* synthetic */ void g(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z11) {
        if (z11) {
            this.f37969b.j(i11 == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public final void h() {
        this.f37975i.removeTextChangedListener(this.f37971d);
        this.f37976j.removeTextChangedListener(this.f37970c);
    }

    @Override // com.google.android.material.timepicker.i
    public void hide() {
        View focusedChild = this.f37968a.getFocusedChild();
        if (focusedChild != null) {
            f0.o(focusedChild, false);
        }
        this.f37968a.setVisibility(8);
    }

    public void i() {
        this.f37972f.setChecked(this.f37969b.f37930d == 12);
        this.f37973g.setChecked(this.f37969b.f37930d == 10);
    }

    @Override // com.google.android.material.timepicker.i
    public void invalidate() {
        j(this.f37969b);
    }

    public final void j(TimeModel timeModel) {
        h();
        Locale locale = this.f37968a.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.f37929c));
        String str2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.d()));
        this.f37972f.g(str);
        this.f37973g.g(str2);
        d();
        l();
    }

    public final void k() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f37968a.findViewById(R$id.material_clock_period_toggle);
        this.f37977k = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.c() { // from class: com.google.android.material.timepicker.k
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z11) {
                this.f37967a.g(materialButtonToggleGroup2, i11, z11);
            }
        });
        this.f37977k.setVisibility(0);
        l();
    }

    public final void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f37977k;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.check(this.f37969b.f37931f == 0 ? R$id.material_clock_period_am_button : R$id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.i
    public void show() {
        this.f37968a.setVisibility(0);
        c(this.f37969b.f37930d);
    }
}
