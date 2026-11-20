package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class g extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f37950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yi.i f37952c;

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, b());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i11, 0);
        this.f37951b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f37950a = new Runnable() { // from class: com.google.android.material.timepicker.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f37949a.h();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    public static boolean g(View view) {
        return "skip".equals(view.getTag());
    }

    public final void a(List<View> list, androidx.constraintlayout.widget.b bVar, int i11) {
        Iterator<View> it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            bVar.t(it.next().getId(), R$id.circle_center, i11, size);
            size += 360.0f / list.size();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        i();
    }

    public final Drawable b() {
        yi.i iVar = new yi.i();
        this.f37952c = iVar;
        iVar.b0(new yi.l(0.5f));
        this.f37952c.d0(ColorStateList.valueOf(-1));
        return this.f37952c;
    }

    public int c(int i11) {
        return i11 == 2 ? Math.round(this.f37951b * 0.66f) : this.f37951b;
    }

    public int e() {
        return this.f37951b;
    }

    public void f(int i11) {
        this.f37951b = i11;
        h();
    }

    public void h() {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.p(this);
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getId() != R$id.circle_center && !g(childAt)) {
                int i12 = (Integer) childAt.getTag(R$id.material_clock_level);
                if (i12 == null) {
                    i12 = 1;
                }
                if (!map.containsKey(i12)) {
                    map.put(i12, new ArrayList());
                }
                ((List) map.get(i12)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            a((List) entry.getValue(), bVar, c(((Integer) entry.getKey()).intValue()));
        }
        bVar.i(this);
    }

    public final void i() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f37950a);
            handler.post(this.f37950a);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        i();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        this.f37952c.d0(ColorStateList.valueOf(i11));
    }
}
