package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class MaterialTextInputPicker<S> extends q<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public DateSelector<S> f36708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public CalendarConstraints f36709d;

    /* JADX INFO: compiled from: source.java */
    public class a extends p<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            Iterator<p<S>> it = MaterialTextInputPicker.this.f36777a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.p
        public void b(S s11) {
            Iterator<p<S>> it = MaterialTextInputPicker.this.f36777a.iterator();
            while (it.hasNext()) {
                it.next().b(s11);
            }
        }
    }

    @NonNull
    public static <T> MaterialTextInputPicker<T> i0(DateSelector<T> dateSelector, int i11, @NonNull CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i11);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f36707b = bundle.getInt("THEME_RES_ID_KEY");
        this.f36708c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f36709d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f36708c.onCreateTextInputView(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f36707b)), viewGroup, bundle, this.f36709d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f36707b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f36708c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f36709d);
    }
}
