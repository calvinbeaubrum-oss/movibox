package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class k extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f36755d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Calendar f36756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36758c;

    static {
        f36755d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public k() {
        Calendar calendarS = y.s();
        this.f36756a = calendarS;
        this.f36757b = calendarS.getMaximum(7);
        this.f36758c = calendarS.getFirstDayOfWeek();
    }

    public k(int i11) {
        Calendar calendarS = y.s();
        this.f36756a = calendarS;
        this.f36757b = calendarS.getMaximum(7);
        this.f36758c = i11;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i11) {
        if (i11 >= this.f36757b) {
            return null;
        }
        return Integer.valueOf(b(i11));
    }

    public final int b(int i11) {
        int i12 = i11 + this.f36758c;
        int i13 = this.f36757b;
        return i12 > i13 ? i12 - i13 : i12;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f36757b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i11, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f36756a.set(7, b(i11));
        textView.setText(this.f36756a.getDisplayName(7, f36755d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f36756a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
