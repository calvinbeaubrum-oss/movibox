package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c extends com.google.android.material.circularreveal.b.a {

    /* JADX INFO: compiled from: source.java */
    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f36621b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f36622a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f11, @NonNull e eVar, @NonNull e eVar2) {
            this.f36622a.b(si.a.d(eVar.f36625a, eVar2.f36625a, f11), si.a.d(eVar.f36626b, eVar2.f36626b, f11), si.a.d(eVar.f36627c, eVar2.f36627c, f11));
            return this.f36622a;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0382c extends Property<c, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f36623a = new C0382c("circularReveal");

        public C0382c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@NonNull c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull c cVar, @Nullable e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends Property<c, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f36624a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@NonNull c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull c cVar, @NonNull Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f36625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f36626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f36627c;

        public e() {
        }

        public e(float f11, float f12, float f13) {
            this.f36625a = f11;
            this.f36626b = f12;
            this.f36627c = f13;
        }

        public e(@NonNull e eVar) {
            this(eVar.f36625a, eVar.f36626b, eVar.f36627c);
        }

        public boolean a() {
            return this.f36627c == Float.MAX_VALUE;
        }

        public void b(float f11, float f12, float f13) {
            this.f36625a = f11;
            this.f36626b = f12;
            this.f36627c = f13;
        }

        public void c(@NonNull e eVar) {
            b(eVar.f36625a, eVar.f36626b, eVar.f36627c);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(int i11);

    void setRevealInfo(@Nullable e eVar);
}
