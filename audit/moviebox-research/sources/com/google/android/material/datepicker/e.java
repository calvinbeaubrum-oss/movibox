package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import com.google.android.material.internal.a0;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f36745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DateFormat f36747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f36748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f36749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f36750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f36751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36752i = 0;

    public e(final String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f36746b = str;
        this.f36747c = dateFormat;
        this.f36745a = textInputLayout;
        this.f36748d = calendarConstraints;
        this.f36749f = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f36750g = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f36741a.e(str);
            }
        };
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NonNull Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f36746b.length() && editable.length() >= this.f36752i) {
            char cCharAt = this.f36746b.charAt(editable.length());
            if (Character.isLetterOrDigit(cCharAt)) {
                return;
            }
            editable.append(cCharAt);
        }
    }

    @Override // com.google.android.material.internal.a0, android.text.TextWatcher
    public void beforeTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
        this.f36752i = charSequence.length();
    }

    public final Runnable c(final long j11) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f36743a.d(j11);
            }
        };
    }

    public final /* synthetic */ void d(long j11) {
        this.f36745a.setError(String.format(this.f36749f, i(j.c(j11))));
        f();
    }

    public final /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f36745a;
        DateFormat dateFormat = this.f36747c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), i(str)) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), i(dateFormat.format(new Date(y.q().getTimeInMillis())))));
        f();
    }

    public abstract void f();

    public abstract void g(@Nullable Long l11);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    public final String i(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // com.google.android.material.internal.a0, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
        this.f36745a.removeCallbacks(this.f36750g);
        this.f36745a.removeCallbacks(this.f36751h);
        this.f36745a.setError(null);
        g(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f36746b.length()) {
            return;
        }
        try {
            Date date = this.f36747c.parse(charSequence.toString());
            this.f36745a.setError(null);
            long time = date.getTime();
            if (this.f36748d.getDateValidator().isValid(time) && this.f36748d.isWithinBounds(time)) {
                g(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableC = c(time);
            this.f36751h = runnableC;
            h(this.f36745a, runnableC);
        } catch (ParseException unused) {
            h(this.f36745a, this.f36750g);
        }
    }
}
