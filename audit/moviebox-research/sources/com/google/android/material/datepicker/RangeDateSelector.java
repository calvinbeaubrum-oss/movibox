package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class RangeDateSelector implements DateSelector<androidx.core.util.e<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    @Nullable
    private CharSequence error;
    private String invalidRangeStartError;

    @Nullable
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = " ";

    @Nullable
    private Long selectedStartItem = null;

    @Nullable
    private Long selectedEndItem = null;

    @Nullable
    private Long proposedTextStart = null;

    @Nullable
    private Long proposedTextEnd = null;

    /* JADX INFO: compiled from: source.java */
    public class a extends e {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f36716j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f36717k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ p f36718l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f36716j = textInputLayout2;
            this.f36717k = textInputLayout3;
            this.f36718l = pVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f36716j, this.f36717k, this.f36718l);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(@Nullable Long l11) {
            RangeDateSelector.this.proposedTextStart = l11;
            RangeDateSelector.this.updateIfValidTextProposal(this.f36716j, this.f36717k, this.f36718l);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends e {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f36720j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f36721k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ p f36722l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, p pVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f36720j = textInputLayout2;
            this.f36721k = textInputLayout3;
            this.f36722l = pVar;
        }

        @Override // com.google.android.material.datepicker.e
        public void f() {
            RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f36720j, this.f36721k, this.f36722l);
        }

        @Override // com.google.android.material.datepicker.e
        public void g(@Nullable Long l11) {
            RangeDateSelector.this.proposedTextEnd = l11;
            RangeDateSelector.this.updateIfValidTextProposal(this.f36720j, this.f36721k, this.f36722l);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i11) {
            return new RangeDateSelector[i11];
        }
    }

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j11, long j12) {
        return j11 <= j12;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateError(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = null;
        } else {
            this.error = textInputLayout2.getError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull p<androidx.core.util.e<Long, Long>> pVar) {
        Long l11 = this.proposedTextStart;
        if (l11 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            pVar.a();
        } else if (isValidRange(l11.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            pVar.b(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            pVar.a();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return vi.b.d(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R$string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l11 = this.selectedStartItem;
        if (l11 != null) {
            arrayList.add(l11);
        }
        Long l12 = this.selectedEndItem;
        if (l12 != null) {
            arrayList.add(l12);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<androidx.core.util.e<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new androidx.core.util.e(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public androidx.core.util.e<Long, Long> getSelection() {
        return new androidx.core.util.e<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionContentDescription(@NonNull Context context) {
        Resources resources = context.getResources();
        androidx.core.util.e<String, String> eVarA = j.a(this.selectedStartItem, this.selectedEndItem);
        String str = eVarA.f7889a;
        String string = str == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : str;
        String str2 = eVarA.f7890b;
        return resources.getString(R$string.mtrl_picker_announce_current_range_selection, string, str2 == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : str2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l11 = this.selectedStartItem;
        if (l11 == null && this.selectedEndItem == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l12 = this.selectedEndItem;
        if (l12 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, j.c(l11.longValue()));
        }
        if (l11 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, j.c(l12.longValue()));
        }
        androidx.core.util.e<String, String> eVarA = j.a(l11, l12);
        return resources.getString(R$string.mtrl_picker_range_header_selected, eVarA.f7889a, eVarA.f7890b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l11 = this.selectedStartItem;
        return (l11 == null || this.selectedEndItem == null || !isValidRange(l11.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull p<androidx.core.util.e<Long, Long>> pVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.k.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatG = this.textInputFormat;
        boolean z11 = simpleDateFormatG != null;
        if (!z11) {
            simpleDateFormatG = y.g();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatG;
        Long l11 = this.selectedStartItem;
        if (l11 != null) {
            editText.setText(simpleDateFormat.format(l11));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l12 = this.selectedEndItem;
        if (l12 != null) {
            editText2.setText(simpleDateFormat.format(l12));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String pattern = z11 ? simpleDateFormat.toPattern() : y.h(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        editText.addTextChangedListener(new a(pattern, simpleDateFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, pVar));
        editText2.addTextChangedListener(new b(pattern, simpleDateFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, pVar));
        h.c(editText, editText2);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j11) {
        Long l11 = this.selectedStartItem;
        if (l11 == null) {
            this.selectedStartItem = Long.valueOf(j11);
        } else if (this.selectedEndItem == null && isValidRange(l11.longValue(), j11)) {
            this.selectedEndItem = Long.valueOf(j11);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j11);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull androidx.core.util.e<Long, Long> eVar) {
        Long l11 = eVar.f7889a;
        if (l11 != null && eVar.f7890b != null) {
            androidx.core.util.i.a(isValidRange(l11.longValue(), eVar.f7890b.longValue()));
        }
        Long l12 = eVar.f7889a;
        this.selectedStartItem = l12 == null ? null : Long.valueOf(y.a(l12.longValue()));
        Long l13 = eVar.f7890b;
        this.selectedEndItem = l13 != null ? Long.valueOf(y.a(l13.longValue())) : null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) y.n(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}
