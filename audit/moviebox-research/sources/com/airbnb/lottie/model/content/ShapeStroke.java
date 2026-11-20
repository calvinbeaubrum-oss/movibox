package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import b7.b;
import b7.d;
import c7.c;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.List;
import x6.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeStroke implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f15176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f15177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.a f15178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f15179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f15180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LineCapType f15181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LineJoinType f15182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f15183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f15184j;

    /* JADX INFO: compiled from: source.java */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i11 = a.f15185a[ordinal()];
            if (i11 != 1) {
                return i11 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i11 = a.f15186b[ordinal()];
            if (i11 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i11 == 2) {
                return Paint.Join.MITER;
            }
            if (i11 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15186b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f15186b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15186b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15186b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f15185a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15185a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15185a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable b bVar, List<b> list, b7.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f11, boolean z11) {
        this.f15175a = str;
        this.f15176b = bVar;
        this.f15177c = list;
        this.f15178d = aVar;
        this.f15179e = dVar;
        this.f15180f = bVar2;
        this.f15181g = lineCapType;
        this.f15182h = lineJoinType;
        this.f15183i = f11;
        this.f15184j = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new t(lottieDrawable, aVar, this);
    }

    public LineCapType b() {
        return this.f15181g;
    }

    public b7.a c() {
        return this.f15178d;
    }

    public b d() {
        return this.f15176b;
    }

    public LineJoinType e() {
        return this.f15182h;
    }

    public List<b> f() {
        return this.f15177c;
    }

    public float g() {
        return this.f15183i;
    }

    public String h() {
        return this.f15175a;
    }

    public d i() {
        return this.f15179e;
    }

    public b j() {
        return this.f15180f;
    }

    public boolean k() {
        return this.f15184j;
    }
}
