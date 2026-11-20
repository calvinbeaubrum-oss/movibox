package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final a f36733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final a f36734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final a f36735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final a f36736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final a f36737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final a f36738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final a f36739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Paint f36740h;

    public b(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(vi.b.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f36733a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f36739g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f36734b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f36735c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f36736d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f36737e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f36738f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f36740h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
