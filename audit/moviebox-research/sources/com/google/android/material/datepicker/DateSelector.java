package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.text.SimpleDateFormat;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId(Context context);

    @StringRes
    int getDefaultTitleResId();

    @Nullable
    String getError();

    @NonNull
    Collection<Long> getSelectedDays();

    @NonNull
    Collection<androidx.core.util.e<Long, Long>> getSelectedRanges();

    @Nullable
    S getSelection();

    @NonNull
    String getSelectionContentDescription(@NonNull Context context);

    @NonNull
    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    @NonNull
    View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull p<S> pVar);

    void select(long j11);

    void setSelection(@NonNull S s11);

    void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat);
}
