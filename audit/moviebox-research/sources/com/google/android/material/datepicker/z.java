package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class z extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MaterialCalendar<?> f36783i;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f36784a;

        public a(int i11) {
            this.f36784a = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.this.f36783i.A0(z.this.f36783i.r0().clamp(Month.b(this.f36784a, z.this.f36783i.t0().f36711a)));
            z.this.f36783i.B0(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f36786b;

        public b(TextView textView) {
            super(textView);
            this.f36786b = textView;
        }
    }

    public z(MaterialCalendar<?> materialCalendar) {
        this.f36783i = materialCalendar;
    }

    @NonNull
    public final View.OnClickListener e(int i11) {
        return new a(i11);
    }

    public int f(int i11) {
        return i11 - this.f36783i.r0().getStart().f36712b;
    }

    public int g(int i11) {
        return this.f36783i.r0().getStart().f36712b + i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f36783i.r0().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i11) {
        int iG = g(i11);
        bVar.f36786b.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(iG)));
        TextView textView = bVar.f36786b;
        textView.setContentDescription(j.k(textView.getContext(), iG));
        com.google.android.material.datepicker.b bVarS0 = this.f36783i.s0();
        Calendar calendarQ = y.q();
        com.google.android.material.datepicker.a aVar = calendarQ.get(1) == iG ? bVarS0.f36738f : bVarS0.f36736d;
        Iterator<Long> it = this.f36783i.u0().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarQ.setTimeInMillis(it.next().longValue());
            if (calendarQ.get(1) == iG) {
                aVar = bVarS0.f36737e;
            }
        }
        aVar.d(bVar.f36786b);
        bVar.f36786b.setOnClickListener(e(iG));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
