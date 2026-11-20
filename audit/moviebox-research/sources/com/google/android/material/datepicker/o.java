package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CalendarConstraints f36768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DateSelector<?> f36769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final DayViewDecorator f36770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MaterialCalendar.k f36771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f36772m;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f36773a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f36773a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            if (this.f36773a.getAdapter().r(i11)) {
                o.this.f36771l.a(this.f36773a.getAdapter().getItem(i11).longValue());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f36775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MaterialCalendarGridView f36776c;

        public b(@NonNull LinearLayout linearLayout, boolean z11) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f36775b = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f36776c = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z11) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public o(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator, MaterialCalendar.k kVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f36772m = (n.f36760h * MaterialCalendar.v0(context)) + (MaterialDatePicker.v0(context) ? MaterialCalendar.v0(context) : 0);
        this.f36768i = calendarConstraints;
        this.f36769j = dateSelector;
        this.f36770k = dayViewDecorator;
        this.f36771l = kVar;
        setHasStableIds(true);
    }

    @NonNull
    public Month e(int i11) {
        return this.f36768i.getStart().l(i11);
    }

    @NonNull
    public CharSequence f(int i11) {
        return e(i11).j();
    }

    public int g(@NonNull Month month) {
        return this.f36768i.getStart().m(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f36768i.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        return this.f36768i.getStart().l(i11).k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i11) {
        Month monthL = this.f36768i.getStart().l(i11);
        bVar.f36775b.setText(monthL.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f36776c.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthL.equals(materialCalendarGridView.getAdapter().f36762a)) {
            n nVar = new n(monthL, this.f36769j, this.f36768i, this.f36770k);
            materialCalendarGridView.setNumColumns(monthL.f36713c);
            materialCalendarGridView.setAdapter((ListAdapter) nVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.v0(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.f36772m));
        return new b(linearLayout, true);
    }
}
