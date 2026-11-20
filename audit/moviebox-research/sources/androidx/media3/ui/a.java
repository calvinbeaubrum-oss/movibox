package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k0> f12004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<y3.a> f12005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12007d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f12008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12009g;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12004a = new ArrayList();
        this.f12005b = Collections.emptyList();
        this.f12006c = 0;
        this.f12007d = 0.0533f;
        this.f12008f = b.f12011g;
        this.f12009g = 0.08f;
    }

    public static y3.a b(y3.a aVar) {
        y3.a.b bVarP = aVar.a().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (aVar.f81114f == 0) {
            bVarP.h(1.0f - aVar.f81113e, 0);
        } else {
            bVarP.h((-aVar.f81113e) - 1.0f, 1);
        }
        int i11 = aVar.f81115g;
        if (i11 == 0) {
            bVarP.i(2);
        } else if (i11 == 2) {
            bVarP.i(0);
        }
        return bVarP.a();
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List<y3.a> list, b bVar, float f11, int i11, float f12) {
        this.f12005b = list;
        this.f12008f = bVar;
        this.f12007d = f11;
        this.f12006c = i11;
        this.f12009g = f12;
        while (this.f12004a.size() < list.size()) {
            this.f12004a.add(new k0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<y3.a> list = this.f12005b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i11 = paddingBottom - paddingTop;
        float fH = n0.h(this.f12006c, this.f12007d, height, i11);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            y3.a aVarB = list.get(i12);
            if (aVarB.f81124p != Integer.MIN_VALUE) {
                aVarB = b(aVarB);
            }
            y3.a aVar = aVarB;
            int i13 = paddingBottom;
            this.f12004a.get(i12).b(aVar, this.f12008f, fH, n0.h(aVar.f81122n, aVar.f81123o, height, i11), this.f12009g, canvas, paddingLeft, paddingTop, width, i13);
            i12++;
            size = size;
            i11 = i11;
            paddingBottom = i13;
            width = width;
        }
    }
}
