package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class n extends BaseAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f36760h = y.s().getMaximum(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f36761i = (y.s().getMaximum(5) + y.s().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f36762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f36763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Collection<Long> f36764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f36765d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CalendarConstraints f36766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final DayViewDecorator f36767g;

    public n(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator) {
        this.f36762a = month;
        this.f36763b = dateSelector;
        this.f36766f = calendarConstraints;
        this.f36767g = dayViewDecorator;
        this.f36764c = dateSelector.getSelectedDays();
    }

    public int a(int i11) {
        return b() + (i11 - 1);
    }

    public int b() {
        return this.f36762a.e(this.f36766f.getFirstDayOfWeek());
    }

    public final String c(Context context, long j11) {
        return j.e(context, j11, l(j11), k(j11), g(j11));
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i11) {
        if (i11 < b() || i11 > m()) {
            return null;
        }
        return Long.valueOf(this.f36762a.h(n(i11)));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0054  */
    @Override // android.widget.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i11, @Nullable View view, @NonNull ViewGroup viewGroup) {
        int i12;
        f(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i11 - b();
        if (iB >= 0) {
            Month month = this.f36762a;
            if (iB >= month.f36714d) {
                textView.setVisibility(8);
                textView.setEnabled(false);
                i12 = -1;
            } else {
                i12 = iB + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, Integer.valueOf(i12)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
            i12 = -1;
        }
        Long item = getItem(i11);
        if (item == null) {
            return textView;
        }
        o(textView, item.longValue(), i12);
        return textView;
    }

    public final void f(Context context) {
        if (this.f36765d == null) {
            this.f36765d = new b(context);
        }
    }

    public boolean g(long j11) {
        Iterator<androidx.core.util.e<Long, Long>> it = this.f36763b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l11 = it.next().f7890b;
            if (l11 != null && l11.longValue() == j11) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f36761i;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11 / this.f36762a.f36713c;
    }

    public boolean h(int i11) {
        return i11 % this.f36762a.f36713c == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean i(int i11) {
        return (i11 + 1) % this.f36762a.f36713c == 0;
    }

    public final boolean j(long j11) {
        Iterator<Long> it = this.f36763b.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (y.a(j11) == y.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean k(long j11) {
        Iterator<androidx.core.util.e<Long, Long>> it = this.f36763b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l11 = it.next().f7889a;
            if (l11 != null && l11.longValue() == j11) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(long j11) {
        return y.q().getTimeInMillis() == j11;
    }

    public int m() {
        return (b() + this.f36762a.f36714d) - 1;
    }

    public int n(int i11) {
        return (i11 - b()) + 1;
    }

    public final void o(@Nullable TextView textView, long j11, int i11) {
        a aVar;
        boolean z11;
        a aVar2;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j11);
        textView.setContentDescription(strC);
        boolean zIsValid = this.f36766f.getDateValidator().isValid(j11);
        if (zIsValid) {
            textView.setEnabled(true);
            boolean zJ = j(j11);
            textView.setSelected(zJ);
            if (zJ) {
                aVar2 = this.f36765d.f36734b;
            } else {
                aVar2 = l(j11) ? this.f36765d.f36735c : this.f36765d.f36733a;
            }
            aVar = aVar2;
            z11 = zJ;
        } else {
            textView.setEnabled(false);
            aVar = this.f36765d.f36739g;
            z11 = false;
        }
        DayViewDecorator dayViewDecorator = this.f36767g;
        if (dayViewDecorator == null || i11 == -1) {
            aVar.d(textView);
            return;
        }
        Month month = this.f36762a;
        int i12 = month.f36712b;
        int i13 = month.f36711a;
        ColorStateList backgroundColor = dayViewDecorator.getBackgroundColor(context, i12, i13, i11, zIsValid, z11);
        boolean z12 = z11;
        aVar.e(textView, backgroundColor, this.f36767g.getTextColor(context, i12, i13, i11, zIsValid, z12));
        Drawable compoundDrawableLeft = this.f36767g.getCompoundDrawableLeft(context, i12, i13, i11, zIsValid, z12);
        Drawable compoundDrawableTop = this.f36767g.getCompoundDrawableTop(context, i12, i13, i11, zIsValid, z12);
        Drawable compoundDrawableRight = this.f36767g.getCompoundDrawableRight(context, i12, i13, i11, zIsValid, z12);
        boolean z13 = z11;
        textView.setCompoundDrawables(compoundDrawableLeft, compoundDrawableTop, compoundDrawableRight, this.f36767g.getCompoundDrawableBottom(context, i12, i13, i11, zIsValid, z13));
        textView.setContentDescription(this.f36767g.getContentDescription(context, i12, i13, i11, zIsValid, z13, strC));
    }

    public final void p(MaterialCalendarGridView materialCalendarGridView, long j11) {
        if (Month.c(j11).equals(this.f36762a)) {
            int i11 = this.f36762a.i(j11);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(i11) - materialCalendarGridView.getFirstVisiblePosition()), j11, i11);
        }
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f36764c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f36763b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f36764c = this.f36763b.getSelectedDays();
        }
    }

    public boolean r(int i11) {
        return i11 >= b() && i11 <= m();
    }
}
