package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class MaterialCalendar<S> extends q<S> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f36638p = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f36639q = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f36640r = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Object f36641s = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f36643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f36644d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public DayViewDecorator f36645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Month f36646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarSelector f36647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.android.material.datepicker.b f36648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f36649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f36650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f36651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f36652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f36653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f36654o;

    /* JADX INFO: compiled from: source.java */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f36655a;

        public a(o oVar) {
            this.f36655a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = MaterialCalendar.this.x0().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.A0(this.f36655a.e(iFindLastVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f36658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i11, boolean z11, int i12) {
            super(context, i11, z11);
            this.f36658a = i12;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.x xVar, @NonNull int[] iArr) {
            if (this.f36658a == 0) {
                iArr[0] = MaterialCalendar.this.f36650k.getWidth();
                iArr[1] = MaterialCalendar.this.f36650k.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f36650k.getHeight();
                iArr[1] = MaterialCalendar.this.f36650k.getHeight();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements k {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j11) {
            if (MaterialCalendar.this.f36644d.getDateValidator().isValid(j11)) {
                MaterialCalendar.this.f36643c.select(j11);
                Iterator<p<S>> it = MaterialCalendar.this.f36777a.iterator();
                while (it.hasNext()) {
                    it.next().b(MaterialCalendar.this.f36643c.getSelection());
                }
                MaterialCalendar.this.f36650k.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f36649j != null) {
                    MaterialCalendar.this.f36649j.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AccessibilityDelegateCompat {
        public e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Calendar f36662a = y.s();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Calendar f36663b = y.s();

        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.x xVar) {
            if ((recyclerView.getAdapter() instanceof z) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                z zVar = (z) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.e<Long, Long> eVar : MaterialCalendar.this.f36643c.getSelectedRanges()) {
                    Long l11 = eVar.f7889a;
                    if (l11 != null && eVar.f7890b != null) {
                        this.f36662a.setTimeInMillis(l11.longValue());
                        this.f36663b.setTimeInMillis(eVar.f7890b.longValue());
                        int iF = zVar.f(this.f36662a.get(1));
                        int iF2 = zVar.f(this.f36663b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iF);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iF2);
                        int spanCount = iF / gridLayoutManager.getSpanCount();
                        int spanCount2 = iF2 / gridLayoutManager.getSpanCount();
                        int i11 = spanCount;
                        while (i11 <= spanCount2) {
                            View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i11);
                            if (viewFindViewByPosition3 != null) {
                                canvas.drawRect((i11 != spanCount || viewFindViewByPosition == null) ? 0 : viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2), viewFindViewByPosition3.getTop() + MaterialCalendar.this.f36648i.f36736d.c(), (i11 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2), viewFindViewByPosition3.getBottom() - MaterialCalendar.this.f36648i.f36736d.b(), MaterialCalendar.this.f36648i.f36740h);
                            }
                            i11++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AccessibilityDelegateCompat {
        public g() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(MaterialCalendar.this.f36654o.getVisibility() == 0 ? MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f36666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialButton f36667b;

        public h(o oVar, MaterialButton materialButton) {
            this.f36666a = oVar;
            this.f36667b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i11) {
            if (i11 == 0) {
                recyclerView.announceForAccessibility(this.f36667b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(@NonNull RecyclerView recyclerView, int i11, int i12) {
            int iFindFirstVisibleItemPosition = i11 < 0 ? MaterialCalendar.this.x0().findFirstVisibleItemPosition() : MaterialCalendar.this.x0().findLastVisibleItemPosition();
            MaterialCalendar.this.f36646g = this.f36666a.e(iFindFirstVisibleItemPosition);
            this.f36667b.setText(this.f36666a.f(iFindFirstVisibleItemPosition));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.D0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f36670a;

        public j(o oVar) {
            this.f36670a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = MaterialCalendar.this.x0().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < MaterialCalendar.this.f36650k.getAdapter().getItemCount()) {
                MaterialCalendar.this.A0(this.f36670a.e(iFindFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface k {
        void a(long j11);
    }

    public static int v0(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    public static int w0(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i11 = n.f36760h;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i11) + ((i11 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> y0(@NonNull DateSelector<T> dateSelector, int i11, @NonNull CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i11);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    public void A0(Month month) {
        o oVar = (o) this.f36650k.getAdapter();
        int iG = oVar.g(month);
        int iG2 = iG - oVar.g(this.f36646g);
        boolean z11 = Math.abs(iG2) > 3;
        boolean z12 = iG2 > 0;
        this.f36646g = month;
        if (z11 && z12) {
            this.f36650k.scrollToPosition(iG - 3);
            z0(iG);
        } else if (!z11) {
            z0(iG);
        } else {
            this.f36650k.scrollToPosition(iG + 3);
            z0(iG);
        }
    }

    public void B0(CalendarSelector calendarSelector) {
        this.f36647h = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f36649j.getLayoutManager().scrollToPosition(((z) this.f36649j.getAdapter()).f(this.f36646g.f36712b));
            this.f36653n.setVisibility(0);
            this.f36654o.setVisibility(8);
            this.f36651l.setVisibility(8);
            this.f36652m.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f36653n.setVisibility(8);
            this.f36654o.setVisibility(0);
            this.f36651l.setVisibility(0);
            this.f36652m.setVisibility(0);
            A0(this.f36646g);
        }
    }

    public final void C0() {
        ViewCompat.setAccessibilityDelegate(this.f36650k, new e());
    }

    public void D0() {
        CalendarSelector calendarSelector = this.f36647h;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            B0(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            B0(calendarSelector2);
        }
    }

    @Override // com.google.android.material.datepicker.q
    public boolean g0(@NonNull p<S> pVar) {
        return super.g0(pVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f36642b = bundle.getInt("THEME_RES_ID_KEY");
        this.f36643c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f36644d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f36645f = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f36646g = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i11;
        int i12;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f36642b);
        this.f36648i = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.f36644d.getStart();
        if (MaterialDatePicker.v0(contextThemeWrapper)) {
            i11 = R$layout.mtrl_calendar_vertical;
            i12 = 1;
        } else {
            i11 = R$layout.mtrl_calendar_horizontal;
            i12 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i11, viewGroup, false);
        viewInflate.setMinimumHeight(w0(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b());
        int firstDayOfWeek = this.f36644d.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new com.google.android.material.datepicker.k(firstDayOfWeek) : new com.google.android.material.datepicker.k()));
        gridView.setNumColumns(start.f36713c);
        gridView.setEnabled(false);
        this.f36650k = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.f36650k.setLayoutManager(new c(getContext(), i12, false, i12));
        this.f36650k.setTag(f36638p);
        o oVar = new o(contextThemeWrapper, this.f36643c, this.f36644d, this.f36645f, new d());
        this.f36650k.setAdapter(oVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f36649j = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f36649j.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f36649j.setAdapter(new z(this));
            this.f36649j.addItemDecoration(q0());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            p0(viewInflate, oVar);
        }
        if (!MaterialDatePicker.v0(contextThemeWrapper)) {
            new androidx.recyclerview.widget.m().attachToRecyclerView(this.f36650k);
        }
        this.f36650k.scrollToPosition(oVar.g(this.f36646g));
        C0();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f36642b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f36643c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f36644d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f36645f);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f36646g);
    }

    public final void p0(@NonNull View view, @NonNull o oVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(f36641s);
        ViewCompat.setAccessibilityDelegate(materialButton, new g());
        View viewFindViewById = view.findViewById(R$id.month_navigation_previous);
        this.f36651l = viewFindViewById;
        viewFindViewById.setTag(f36639q);
        View viewFindViewById2 = view.findViewById(R$id.month_navigation_next);
        this.f36652m = viewFindViewById2;
        viewFindViewById2.setTag(f36640r);
        this.f36653n = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f36654o = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        B0(CalendarSelector.DAY);
        materialButton.setText(this.f36646g.j());
        this.f36650k.addOnScrollListener(new h(oVar, materialButton));
        materialButton.setOnClickListener(new i());
        this.f36652m.setOnClickListener(new j(oVar));
        this.f36651l.setOnClickListener(new a(oVar));
    }

    @NonNull
    public final RecyclerView.l q0() {
        return new f();
    }

    @Nullable
    public CalendarConstraints r0() {
        return this.f36644d;
    }

    public com.google.android.material.datepicker.b s0() {
        return this.f36648i;
    }

    @Nullable
    public Month t0() {
        return this.f36646g;
    }

    @Nullable
    public DateSelector<S> u0() {
        return this.f36643c;
    }

    @NonNull
    public LinearLayoutManager x0() {
        return (LinearLayoutManager) this.f36650k.getLayoutManager();
    }

    public final void z0(final int i11) {
        this.f36650k.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.f36650k.smoothScrollToPosition(i11);
            }
        });
    }
}
