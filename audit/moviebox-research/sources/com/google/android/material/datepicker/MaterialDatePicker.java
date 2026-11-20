package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final Object F = "CONFIRM_BUTTON_TAG";
    public static final Object G = "CANCEL_BUTTON_TAG";
    public static final Object H = "TOGGLE_BUTTON_TAG";

    @Nullable
    public yi.i A;
    public Button B;
    public boolean C;

    @Nullable
    public CharSequence D;

    @Nullable
    public CharSequence E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<m<? super S>> f36675a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f36676b = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f36677c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f36678d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f36680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q<S> f36681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f36682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public DayViewDecorator f36683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaterialCalendar<S> f36684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @StringRes
    public int f36685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f36686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36688o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @StringRes
    public int f36689p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f36690q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @StringRes
    public int f36691r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f36692s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @StringRes
    public int f36693t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CharSequence f36694u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @StringRes
    public int f36695v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f36696w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f36697x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f36698y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CheckableImageButton f36699z;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f36675a.iterator();
            while (it.hasNext()) {
                ((m) it.next()).a(MaterialDatePicker.this.s0());
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f36676b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f36702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f36703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f36704c;

        public c(int i11, View view, int i12) {
            this.f36702a = i11;
            this.f36703b = view;
            this.f36704c = i12;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i11 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).f14555b;
            if (this.f36702a >= 0) {
                this.f36703b.getLayoutParams().height = this.f36702a + i11;
                View view2 = this.f36703b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f36703b;
            view3.setPadding(view3.getPaddingLeft(), this.f36704c + i11, this.f36703b.getPaddingRight(), this.f36703b.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends p<S> {
        public d() {
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            MaterialDatePicker.this.B.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.p
        public void b(S s11) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.B0(materialDatePicker.q0());
            MaterialDatePicker.this.B.setEnabled(MaterialDatePicker.this.n0().isSelectionComplete());
        }
    }

    private void C0() {
        this.f36697x.setText((this.f36688o == 1 && w0()) ? this.E : this.D);
    }

    @NonNull
    public static Drawable l0(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, d1.a.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], d1.a.b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> n0() {
        if (this.f36680g == null) {
            this.f36680g = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f36680g;
    }

    @Nullable
    public static CharSequence o0(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    public static int r0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i11 = Month.d().f36713c;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i11) + ((i11 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    public static boolean v0(@NonNull Context context) {
        return z0(context, R.attr.windowFullscreen);
    }

    public static boolean x0(@NonNull Context context) {
        return z0(context, R$attr.nestedScrollable);
    }

    public static boolean z0(@NonNull Context context, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(vi.b.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i11});
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z11;
    }

    public final void A0() {
        int iT0 = t0(requireContext());
        MaterialTextInputPicker materialTextInputPickerY0 = MaterialCalendar.y0(n0(), iT0, this.f36682i, this.f36683j);
        this.f36684k = materialTextInputPickerY0;
        if (this.f36688o == 1) {
            materialTextInputPickerY0 = MaterialTextInputPicker.i0(n0(), iT0, this.f36682i);
        }
        this.f36681h = materialTextInputPickerY0;
        C0();
        B0(q0());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R$id.mtrl_calendar_frame, this.f36681h);
        fragmentTransactionBeginTransaction.commitNow();
        this.f36681h.g0(new d());
    }

    public void B0(String str) {
        this.f36698y.setContentDescription(p0());
        this.f36698y.setText(str);
    }

    public final void D0(@NonNull CheckableImageButton checkableImageButton) {
        this.f36699z.setContentDescription(this.f36688o == 1 ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    public final void m0(Window window) {
        if (this.C) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R$id.fullscreen_header);
        com.google.android.material.internal.e.a(window, true, f0.h(viewFindViewById), null);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.C = true;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f36677c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f36679f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f36680g = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f36682i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f36683j = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f36685l = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f36686m = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f36688o = bundle.getInt("INPUT_MODE_KEY");
        this.f36689p = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f36690q = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f36691r = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f36692s = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f36693t = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f36694u = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f36695v = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f36696w = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f36686m;
        if (text == null) {
            text = requireContext().getResources().getText(this.f36685l);
        }
        this.D = text;
        this.E = o0(text);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), t0(requireContext()));
        Context context = dialog.getContext();
        this.f36687n = v0(context);
        this.A = new yi.i(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialCalendar, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.A.S(context);
        this.A.d0(ColorStateList.valueOf(color));
        this.A.c0(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f36687n ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.f36683j;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.f36687n) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(r0(context), -2));
        } else {
            viewInflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(r0(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f36698y = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.f36699z = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        this.f36697x = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        u0(context);
        this.B = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (n0().isSelectionComplete()) {
            this.B.setEnabled(true);
        } else {
            this.B.setEnabled(false);
        }
        this.B.setTag(F);
        CharSequence charSequence = this.f36690q;
        if (charSequence != null) {
            this.B.setText(charSequence);
        } else {
            int i11 = this.f36689p;
            if (i11 != 0) {
                this.B.setText(i11);
            }
        }
        CharSequence charSequence2 = this.f36692s;
        if (charSequence2 != null) {
            this.B.setContentDescription(charSequence2);
        } else if (this.f36691r != 0) {
            this.B.setContentDescription(getContext().getResources().getText(this.f36691r));
        }
        this.B.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag(G);
        CharSequence charSequence3 = this.f36694u;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.f36693t;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        CharSequence charSequence4 = this.f36696w;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f36695v != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f36695v));
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f36678d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f36679f);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f36680g);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f36682i);
        MaterialCalendar<S> materialCalendar = this.f36684k;
        Month monthT0 = materialCalendar == null ? null : materialCalendar.t0();
        if (monthT0 != null) {
            bVar.b(monthT0.f36715f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f36683j);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f36685l);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f36686m);
        bundle.putInt("INPUT_MODE_KEY", this.f36688o);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f36689p);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f36690q);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f36691r);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f36692s);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f36693t);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f36694u);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f36695v);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f36696w);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f36687n) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.A);
            m0(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.A, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ni.a(requireDialog(), rect));
        }
        A0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f36681h.h0();
        super.onStop();
    }

    public final String p0() {
        return n0().getSelectionContentDescription(requireContext());
    }

    public String q0() {
        return n0().getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S s0() {
        return n0().getSelection();
    }

    public final int t0(Context context) {
        int i11 = this.f36679f;
        return i11 != 0 ? i11 : n0().getDefaultThemeResId(context);
    }

    public final void u0(Context context) {
        this.f36699z.setTag(H);
        this.f36699z.setImageDrawable(l0(context));
        this.f36699z.setChecked(this.f36688o != 0);
        ViewCompat.setAccessibilityDelegate(this.f36699z, null);
        D0(this.f36699z);
        this.f36699z.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f36759a.y0(view);
            }
        });
    }

    public final boolean w0() {
        return getResources().getConfiguration().orientation == 2;
    }

    public final /* synthetic */ void y0(View view) {
        this.B.setEnabled(n0().isSelectionComplete());
        this.f36699z.toggle();
        this.f36688o = this.f36688o == 1 ? 0 : 1;
        D0(this.f36699z);
        A0();
    }
}
