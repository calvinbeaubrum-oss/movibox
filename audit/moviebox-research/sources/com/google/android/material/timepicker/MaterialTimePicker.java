package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TimePickerView f37906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewStub f37907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public h f37908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public l f37909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public i f37910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f37912l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f37914n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f37916p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f37918r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MaterialButton f37919s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f37920t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TimeModel f37922v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<View.OnClickListener> f37902a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<View.OnClickListener> f37903b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<DialogInterface.OnCancelListener> f37904c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<DialogInterface.OnDismissListener> f37905d = new LinkedHashSet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @StringRes
    public int f37913m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @StringRes
    public int f37915o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @StringRes
    public int f37917q = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37921u = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37923w = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.f37902a.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.f37903b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.f37921u = materialTimePicker.f37921u == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.t0(materialTimePicker2.f37919s);
        }
    }

    public final Pair<Integer, Integer> n0(int i11) {
        if (i11 == 0) {
            return new Pair<>(Integer.valueOf(this.f37911k), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        }
        if (i11 == 1) {
            return new Pair<>(Integer.valueOf(this.f37912l), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i11);
    }

    public final int o0() {
        int i11 = this.f37923w;
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValueA = vi.b.a(requireContext(), R$attr.materialTimePickerTheme);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f37904c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        r0(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), o0());
        Context context = dialog.getContext();
        yi.i iVar = new yi.i(context, null, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        this.f37912l = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.f37911k = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialTimePicker_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        iVar.S(context);
        iVar.d0(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(iVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        iVar.c0(ViewCompat.getElevation(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.f37906f = timePickerView;
        timePickerView.o(this);
        this.f37907g = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.f37919s = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        int i11 = this.f37913m;
        if (i11 != 0) {
            textView.setText(i11);
        } else if (!TextUtils.isEmpty(this.f37914n)) {
            textView.setText(this.f37914n);
        }
        t0(this.f37919s);
        Button button = (Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button);
        button.setOnClickListener(new a());
        int i12 = this.f37915o;
        if (i12 != 0) {
            button.setText(i12);
        } else if (!TextUtils.isEmpty(this.f37916p)) {
            button.setText(this.f37916p);
        }
        Button button2 = (Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button);
        this.f37920t = button2;
        button2.setOnClickListener(new b());
        int i13 = this.f37917q;
        if (i13 != 0) {
            this.f37920t.setText(i13);
        } else if (!TextUtils.isEmpty(this.f37918r)) {
            this.f37920t.setText(this.f37918r);
        }
        s0();
        this.f37919s.setOnClickListener(new c());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f37910j = null;
        this.f37908h = null;
        this.f37909i = null;
        TimePickerView timePickerView = this.f37906f;
        if (timePickerView != null) {
            timePickerView.o(null);
            this.f37906f = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f37905d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f37922v);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f37921u);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f37913m);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.f37914n);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.f37915o);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.f37916p);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.f37917q);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.f37918r);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.f37923w);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f37910j instanceof l) {
            view.postDelayed(new Runnable() { // from class: com.google.android.material.timepicker.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f37947a.q0();
                }
            }, 100L);
        }
    }

    public final i p0(int i11, @NonNull TimePickerView timePickerView, @NonNull ViewStub viewStub) {
        if (i11 != 0) {
            if (this.f37909i == null) {
                this.f37909i = new l((LinearLayout) viewStub.inflate(), this.f37922v);
            }
            this.f37909i.e();
            return this.f37909i;
        }
        h hVar = this.f37908h;
        if (hVar == null) {
            hVar = new h(timePickerView, this.f37922v);
        }
        this.f37908h = hVar;
        return hVar;
    }

    public final /* synthetic */ void q0() {
        i iVar = this.f37910j;
        if (iVar instanceof l) {
            ((l) iVar).i();
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void r() {
        this.f37921u = 1;
        t0(this.f37919s);
        this.f37909i.i();
    }

    public final void r0(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.f37922v = timeModel;
        if (timeModel == null) {
            this.f37922v = new TimeModel();
        }
        this.f37921u = bundle.getInt("TIME_PICKER_INPUT_MODE", this.f37922v.f37927a != 1 ? 0 : 1);
        this.f37913m = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.f37914n = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.f37915o = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.f37916p = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.f37917q = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.f37918r = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.f37923w = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    public final void s0() {
        Button button = this.f37920t;
        if (button != null) {
            button.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z11) {
        super.setCancelable(z11);
        s0();
    }

    public final void t0(MaterialButton materialButton) {
        if (materialButton == null || this.f37906f == null || this.f37907g == null) {
            return;
        }
        i iVar = this.f37910j;
        if (iVar != null) {
            iVar.hide();
        }
        i iVarP0 = p0(this.f37921u, this.f37906f, this.f37907g);
        this.f37910j = iVarP0;
        iVarP0.show();
        this.f37910j.invalidate();
        Pair<Integer, Integer> pairN0 = n0(this.f37921u);
        materialButton.setIconResource(((Integer) pairN0.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairN0.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }
}
