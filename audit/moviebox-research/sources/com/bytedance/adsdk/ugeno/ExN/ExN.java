package com.bytedance.adsdk.ugeno.ExN;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.qr.qr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends ViewGroup implements com.bytedance.adsdk.ugeno.ExN.sc {
    private We BT;
    private int ExN;
    private int Ol;
    private Drawable Qj;
    private int[] Ql;
    private SparseIntArray SR;
    private int TRI;
    private int Tf;
    private int UFX;
    private int WH;
    private int We;
    private com.bytedance.adsdk.ugeno.zY Xc;
    private List<zY> dE;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Drawable f26312qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26313sc;
    private We.sc wjp;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends ViewGroup.MarginLayoutParams implements pFF {
        public static final Parcelable.Creator<sc> CREATOR = new Parcelable.Creator<sc>() { // from class: com.bytedance.adsdk.ugeno.ExN.ExN.sc.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public sc createFromParcel(Parcel parcel) {
                return new sc(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public sc[] newArray(int i11) {
                return new sc[i11];
            }
        };
        private float ExN;
        private int Ol;
        private int Qj;
        private int TRI;
        private boolean WH;
        private int We;
        private float pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private int f26314qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private int f26315sc;
        private float zY;

        public sc(int i11, int i12) {
            super(new ViewGroup.LayoutParams(i11, i12));
            this.f26315sc = 1;
            this.pFF = 0.0f;
            this.zY = 0.0f;
            this.We = -1;
            this.ExN = -1.0f;
            this.TRI = -1;
            this.f26314qr = -1;
            this.Qj = 16777215;
            this.Ol = 16777215;
        }

        public sc(Parcel parcel) {
            super(0, 0);
            this.f26315sc = 1;
            this.pFF = 0.0f;
            this.zY = 0.0f;
            this.We = -1;
            this.ExN = -1.0f;
            this.TRI = -1;
            this.f26314qr = -1;
            this.Qj = 16777215;
            this.Ol = 16777215;
            this.f26315sc = parcel.readInt();
            this.pFF = parcel.readFloat();
            this.zY = parcel.readFloat();
            this.We = parcel.readInt();
            this.ExN = parcel.readFloat();
            this.TRI = parcel.readInt();
            this.f26314qr = parcel.readInt();
            this.Qj = parcel.readInt();
            this.Ol = parcel.readInt();
            this.WH = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public sc(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f26315sc = 1;
            this.pFF = 0.0f;
            this.zY = 0.0f;
            this.We = -1;
            this.ExN = -1.0f;
            this.TRI = -1;
            this.f26314qr = -1;
            this.Qj = 16777215;
            this.Ol = 16777215;
        }

        public sc(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f26315sc = 1;
            this.pFF = 0.0f;
            this.zY = 0.0f;
            this.We = -1;
            this.ExN = -1.0f;
            this.TRI = -1;
            this.f26314qr = -1;
            this.Qj = 16777215;
            this.Ol = 16777215;
        }

        public sc(sc scVar) {
            super((ViewGroup.MarginLayoutParams) scVar);
            this.f26315sc = 1;
            this.pFF = 0.0f;
            this.zY = 0.0f;
            this.We = -1;
            this.ExN = -1.0f;
            this.TRI = -1;
            this.f26314qr = -1;
            this.Qj = 16777215;
            this.Ol = 16777215;
            this.f26315sc = scVar.f26315sc;
            this.pFF = scVar.pFF;
            this.zY = scVar.zY;
            this.We = scVar.We;
            this.ExN = scVar.ExN;
            this.TRI = scVar.TRI;
            this.f26314qr = scVar.f26314qr;
            this.Qj = scVar.Qj;
            this.Ol = scVar.Ol;
            this.WH = scVar.WH;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int BT() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public float ExN() {
            return this.zY;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int Ol() {
            return this.Qj;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int Qj() {
            return this.f26314qr;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int Ql() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int SR() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int TRI() {
            return this.We;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public float Tf() {
            return this.ExN;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public boolean UFX() {
            return this.WH;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int WH() {
            return this.Ol;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public float We() {
            return this.pFF;
        }

        public void We(int i11) {
            this.We = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int dE() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int pFF() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        public void pFF(float f11) {
            this.zY = f11;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public void pFF(int i11) {
            this.f26314qr = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int qr() {
            return this.TRI;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int sc() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        public void sc(float f11) {
            this.pFF = f11;
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public void sc(int i11) {
            this.TRI = i11;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f26315sc);
            parcel.writeFloat(this.pFF);
            parcel.writeFloat(this.zY);
            parcel.writeInt(this.We);
            parcel.writeFloat(this.ExN);
            parcel.writeInt(this.TRI);
            parcel.writeInt(this.f26314qr);
            parcel.writeInt(this.Qj);
            parcel.writeInt(this.Ol);
            parcel.writeByte(this.WH ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.ExN.pFF
        public int zY() {
            return this.f26315sc;
        }

        public void zY(float f11) {
            this.ExN = f11;
        }

        public void zY(int i11) {
            this.f26315sc = i11;
        }
    }

    public ExN(Context context) {
        super(context, null);
        this.TRI = -1;
        this.BT = new We(this);
        this.dE = new ArrayList();
        this.wjp = new We.sc();
    }

    private boolean ExN(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.dE.get(i12).pFF() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean ExN(int i11, int i12) {
        for (int i13 = 1; i13 <= i12; i13++) {
            View viewZY = zY(i11 - i13);
            if (viewZY != null && viewZY.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean TRI(int i11) {
        if (i11 >= 0 && i11 < this.dE.size()) {
            for (int i12 = i11 + 1; i12 < this.dE.size(); i12++) {
                if (this.dE.get(i12).pFF() > 0) {
                    return false;
                }
            }
            if (sc()) {
                return (this.Ol & 4) != 0;
            }
            if ((this.WH & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean We(int i11) {
        if (i11 >= 0 && i11 < this.dE.size()) {
            if (ExN(i11)) {
                if (sc()) {
                    return (this.Ol & 1) != 0;
                }
                return (this.WH & 1) != 0;
            }
            if (sc()) {
                return (this.Ol & 2) != 0;
            }
            if ((this.WH & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean We(int i11, int i12) {
        if (ExN(i11, i12)) {
            if (sc()) {
                return (this.WH & 1) != 0;
            }
            return (this.Ol & 1) != 0;
        }
        if (sc()) {
            return (this.WH & 2) != 0;
        }
        return (this.Ol & 2) != 0;
    }

    private void pFF() {
        if (this.f26312qr == null && this.Qj == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private void pFF(int i11, int i12) {
        this.dE.clear();
        this.wjp.sc();
        this.BT.sc(this.wjp, i11, i12);
        this.dE = this.wjp.f26318sc;
        this.BT.sc(i11, i12);
        if (this.We == 3) {
            for (zY zYVar : this.dE) {
                int iMax = Integer.MIN_VALUE;
                for (int i13 = 0; i13 < zYVar.Qj; i13++) {
                    View viewZY = zY(zYVar.BT + i13);
                    if (viewZY != null && viewZY.getVisibility() != 8) {
                        sc scVar = (sc) viewZY.getLayoutParams();
                        iMax = this.pFF != 2 ? Math.max(iMax, viewZY.getMeasuredHeight() + Math.max(zYVar.Tf - viewZY.getBaseline(), ((ViewGroup.MarginLayoutParams) scVar).topMargin) + ((ViewGroup.MarginLayoutParams) scVar).bottomMargin) : Math.max(iMax, viewZY.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) scVar).topMargin + Math.max((zYVar.Tf - viewZY.getMeasuredHeight()) + viewZY.getBaseline(), ((ViewGroup.MarginLayoutParams) scVar).bottomMargin));
                    }
                }
                zYVar.f26319qr = iMax;
            }
        }
        this.BT.pFF(i11, i12, getPaddingTop() + getPaddingBottom());
        this.BT.sc();
        sc(this.f26313sc, i11, i12, this.wjp.pFF);
    }

    private void pFF(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.f26312qr;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, i13 + i11, this.UFX + i12);
        this.f26312qr.draw(canvas);
    }

    private void pFF(Canvas canvas, boolean z11, boolean z12) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.dE.size();
        for (int i11 = 0; i11 < size; i11++) {
            zY zYVar = this.dE.get(i11);
            for (int i12 = 0; i12 < zYVar.Qj; i12++) {
                int i13 = zYVar.BT + i12;
                View viewZY = zY(i13);
                if (viewZY != null && viewZY.getVisibility() != 8) {
                    sc scVar = (sc) viewZY.getLayoutParams();
                    if (We(i13, i12)) {
                        pFF(canvas, zYVar.f26320sc, z12 ? viewZY.getBottom() + ((ViewGroup.MarginLayoutParams) scVar).bottomMargin : (viewZY.getTop() - ((ViewGroup.MarginLayoutParams) scVar).topMargin) - this.UFX, zYVar.f26319qr);
                    }
                    if (i12 == zYVar.Qj - 1 && (this.Ol & 4) > 0) {
                        pFF(canvas, zYVar.f26320sc, z12 ? (viewZY.getTop() - ((ViewGroup.MarginLayoutParams) scVar).topMargin) - this.UFX : viewZY.getBottom() + ((ViewGroup.MarginLayoutParams) scVar).bottomMargin, zYVar.f26319qr);
                    }
                }
            }
            if (We(i11)) {
                sc(canvas, z11 ? zYVar.zY : zYVar.f26320sc - this.Tf, paddingTop, iMax);
            }
            if (TRI(i11) && (this.WH & 4) > 0) {
                sc(canvas, z11 ? zYVar.f26320sc - this.Tf : zYVar.zY, paddingTop, iMax);
            }
        }
    }

    private void sc(int i11, int i12) {
        if (this.SR == null) {
            this.SR = new SparseIntArray(getChildCount());
        }
        if (this.BT.pFF(this.SR)) {
            this.Ql = this.BT.sc(this.SR);
        }
        int i13 = this.f26313sc;
        if (i13 == 0 || i13 == 1) {
            pFF(i11, i12);
        } else if (i13 == 2 || i13 == 3) {
            zY(i11, i12);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f26313sc);
        }
    }

    private void sc(int i11, int i12, int i13, int i14) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        if (i11 == 0 || i11 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i11 != 2 && i11 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i11)));
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i12, i14);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
            }
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i13, i14);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
            }
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void sc(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.Qj;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, this.Tf + i11, i13 + i12);
        this.Qj.draw(canvas);
    }

    private void sc(Canvas canvas, boolean z11, boolean z12) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.dE.size();
        for (int i11 = 0; i11 < size; i11++) {
            zY zYVar = this.dE.get(i11);
            for (int i12 = 0; i12 < zYVar.Qj; i12++) {
                int i13 = zYVar.BT + i12;
                View viewZY = zY(i13);
                if (viewZY != null && viewZY.getVisibility() != 8) {
                    sc scVar = (sc) viewZY.getLayoutParams();
                    if (We(i13, i12)) {
                        sc(canvas, z11 ? viewZY.getRight() + ((ViewGroup.MarginLayoutParams) scVar).rightMargin : (viewZY.getLeft() - ((ViewGroup.MarginLayoutParams) scVar).leftMargin) - this.Tf, zYVar.pFF, zYVar.f26319qr);
                    }
                    if (i12 == zYVar.Qj - 1 && (this.WH & 4) > 0) {
                        sc(canvas, z11 ? (viewZY.getLeft() - ((ViewGroup.MarginLayoutParams) scVar).leftMargin) - this.Tf : viewZY.getRight() + ((ViewGroup.MarginLayoutParams) scVar).rightMargin, zYVar.pFF, zYVar.f26319qr);
                    }
                }
            }
            if (We(i11)) {
                pFF(canvas, paddingLeft, z12 ? zYVar.We : zYVar.pFF - this.UFX, iMax);
            }
            if (TRI(i11) && (this.Ol & 4) > 0) {
                pFF(canvas, paddingLeft, z12 ? zYVar.pFF - this.UFX : zYVar.We, iMax);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ff  */
    private void sc(boolean z11, int i11, int i12, int i13, int i14) {
        float measuredWidth;
        float f11;
        float f12;
        int i15;
        View viewZY;
        int i16;
        int i17;
        float f13;
        int i18;
        sc scVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i19 = i13 - i11;
        int paddingBottom = (i14 - i12) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.dE.size();
        int i21 = 0;
        while (i21 < size) {
            zY zYVar = this.dE.get(i21);
            if (We(i21)) {
                int i22 = this.UFX;
                paddingBottom -= i22;
                paddingTop += i22;
            }
            int i23 = this.zY;
            int i24 = 1;
            if (i23 == 0) {
                measuredWidth = paddingLeft;
                f11 = i19 - paddingRight;
            } else if (i23 != 1) {
                if (i23 == 2) {
                    int i25 = zYVar.ExN;
                    measuredWidth = paddingLeft + ((i19 - i25) / 2.0f);
                    f11 = (i19 - paddingRight) - ((i19 - i25) / 2.0f);
                } else if (i23 == 3) {
                    measuredWidth = paddingLeft;
                    int iPFF = zYVar.pFF();
                    f12 = (i19 - zYVar.ExN) / (iPFF != 1 ? iPFF - 1 : 1.0f);
                    f11 = i19 - paddingRight;
                } else if (i23 == 4) {
                    int iPFF2 = zYVar.pFF();
                    f12 = iPFF2 != 0 ? (i19 - zYVar.ExN) / iPFF2 : 0.0f;
                    float f14 = f12 / 2.0f;
                    measuredWidth = paddingLeft + f14;
                    f11 = (i19 - paddingRight) - f14;
                } else {
                    if (i23 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.zY);
                    }
                    int iPFF3 = zYVar.pFF();
                    f12 = iPFF3 != 0 ? (i19 - zYVar.ExN) / (iPFF3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f12;
                    f11 = (i19 - paddingRight) - f12;
                }
                float fMax = Math.max(f12, 0.0f);
                i15 = 0;
                while (i15 < zYVar.Qj) {
                    int i26 = zYVar.BT + i15;
                    viewZY = zY(i26);
                    if (viewZY != null || viewZY.getVisibility() == 8) {
                        i16 = paddingLeft;
                        i17 = i15;
                    } else {
                        sc scVar2 = (sc) viewZY.getLayoutParams();
                        float f15 = measuredWidth + ((ViewGroup.MarginLayoutParams) scVar2).leftMargin;
                        float f16 = f11 - ((ViewGroup.MarginLayoutParams) scVar2).rightMargin;
                        if (We(i26, i15)) {
                            int i27 = this.Tf;
                            float f17 = i27;
                            f15 += f17;
                            i18 = i27;
                            f13 = f16 - f17;
                        } else {
                            f13 = f16;
                            i18 = 0;
                        }
                        int i28 = (i15 != zYVar.Qj - i24 || (this.WH & 4) <= 0) ? 0 : this.Tf;
                        if (this.pFF != 2) {
                            i16 = paddingLeft;
                            i17 = i15;
                            scVar = scVar2;
                            if (z11) {
                                this.BT.sc(viewZY, zYVar, Math.round(f13) - viewZY.getMeasuredWidth(), paddingTop, Math.round(f13), paddingTop + viewZY.getMeasuredHeight());
                            } else {
                                this.BT.sc(viewZY, zYVar, Math.round(f15), paddingTop, Math.round(f15) + viewZY.getMeasuredWidth(), paddingTop + viewZY.getMeasuredHeight());
                            }
                        } else if (z11) {
                            i17 = i15;
                            i16 = paddingLeft;
                            scVar = scVar2;
                            this.BT.sc(viewZY, zYVar, Math.round(f13) - viewZY.getMeasuredWidth(), paddingBottom - viewZY.getMeasuredHeight(), Math.round(f13), paddingBottom);
                        } else {
                            i16 = paddingLeft;
                            i17 = i15;
                            scVar = scVar2;
                            this.BT.sc(viewZY, zYVar, Math.round(f15), paddingBottom - viewZY.getMeasuredHeight(), Math.round(f15) + viewZY.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f15 + viewZY.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) scVar).rightMargin;
                        float measuredWidth2 = f13 - ((viewZY.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) scVar).leftMargin);
                        if (z11) {
                            zYVar.sc(viewZY, i28, 0, i18, 0);
                        } else {
                            zYVar.sc(viewZY, i18, 0, i28, 0);
                        }
                        f11 = measuredWidth2;
                    }
                    i15 = i17 + 1;
                    paddingLeft = i16;
                    i24 = 1;
                }
                int i29 = paddingLeft;
                int i31 = zYVar.f26319qr;
                paddingTop += i31;
                paddingBottom -= i31;
                i21++;
                paddingLeft = i29;
            } else {
                int i32 = zYVar.ExN;
                f11 = i32 - paddingLeft;
                measuredWidth = (i19 - i32) + paddingRight;
            }
            f12 = 0.0f;
            float fMax2 = Math.max(f12, 0.0f);
            i15 = 0;
            while (i15 < zYVar.Qj) {
                int i210 = zYVar.BT + i15;
                viewZY = zY(i210);
                if (viewZY != null) {
                    i16 = paddingLeft;
                    i17 = i15;
                } else {
                    i16 = paddingLeft;
                    i17 = i15;
                }
                i15 = i17 + 1;
                paddingLeft = i16;
                i24 = 1;
            }
            int i211 = paddingLeft;
            int i33 = zYVar.f26319qr;
            paddingTop += i33;
            paddingBottom -= i33;
            i21++;
            paddingLeft = i211;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fb  */
    private void sc(boolean z11, boolean z12, int i11, int i12, int i13, int i14) {
        float f11;
        int i15;
        float f12;
        float f13;
        int i16;
        View viewZY;
        int i17;
        float f14;
        float f15;
        int i18;
        sc scVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i19 = i14 - i12;
        int i21 = (i13 - i11) - paddingRight;
        int size = this.dE.size();
        for (int i22 = 0; i22 < size; i22++) {
            zY zYVar = this.dE.get(i22);
            if (We(i22)) {
                int i23 = this.Tf;
                paddingLeft += i23;
                i21 -= i23;
            }
            int i24 = this.zY;
            if (i24 != 0) {
                if (i24 == 1) {
                    int i25 = zYVar.ExN;
                    f11 = (i19 - i25) + paddingBottom;
                    i15 = i25 - paddingTop;
                } else if (i24 == 2) {
                    int i26 = zYVar.ExN;
                    f12 = (i19 - paddingBottom) - ((i19 - i26) / 2.0f);
                    f11 = paddingTop + ((i19 - i26) / 2.0f);
                    f13 = 0.0f;
                } else if (i24 == 3) {
                    f11 = paddingTop;
                    int iPFF = zYVar.pFF();
                    f13 = (i19 - zYVar.ExN) / (iPFF != 1 ? iPFF - 1 : 1.0f);
                    f12 = i19 - paddingBottom;
                } else if (i24 == 4) {
                    int iPFF2 = zYVar.pFF();
                    f13 = iPFF2 != 0 ? (i19 - zYVar.ExN) / iPFF2 : 0.0f;
                    float f16 = f13 / 2.0f;
                    f11 = paddingTop + f16;
                    f12 = (i19 - paddingBottom) - f16;
                } else {
                    if (i24 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.zY);
                    }
                    int iPFF3 = zYVar.pFF();
                    f13 = iPFF3 != 0 ? (i19 - zYVar.ExN) / (iPFF3 + 1) : 0.0f;
                    f11 = paddingTop + f13;
                    f12 = (i19 - paddingBottom) - f13;
                }
                float fMax = Math.max(f13, 0.0f);
                i16 = 0;
                while (i16 < zYVar.Qj) {
                    int i27 = zYVar.BT + i16;
                    viewZY = zY(i27);
                    if (viewZY != null || viewZY.getVisibility() == 8) {
                        i17 = i16;
                    } else {
                        sc scVar2 = (sc) viewZY.getLayoutParams();
                        float f17 = f11 + ((ViewGroup.MarginLayoutParams) scVar2).topMargin;
                        float f18 = f12 - ((ViewGroup.MarginLayoutParams) scVar2).bottomMargin;
                        if (We(i27, i16)) {
                            int i28 = this.UFX;
                            float f19 = i28;
                            f14 = f17 + f19;
                            i18 = i28;
                            f15 = f18 - f19;
                        } else {
                            f14 = f17;
                            f15 = f18;
                            i18 = 0;
                        }
                        int i29 = (i16 != zYVar.Qj - 1 || (this.Ol & 4) <= 0) ? 0 : this.UFX;
                        if (!z11) {
                            i17 = i16;
                            scVar = scVar2;
                            if (z12) {
                                this.BT.sc(viewZY, zYVar, false, paddingLeft, Math.round(f15) - viewZY.getMeasuredHeight(), paddingLeft + viewZY.getMeasuredWidth(), Math.round(f15));
                            } else {
                                this.BT.sc(viewZY, zYVar, false, paddingLeft, Math.round(f14), paddingLeft + viewZY.getMeasuredWidth(), Math.round(f14) + viewZY.getMeasuredHeight());
                            }
                        } else if (z12) {
                            i17 = i16;
                            scVar = scVar2;
                            this.BT.sc(viewZY, zYVar, true, i21 - viewZY.getMeasuredWidth(), Math.round(f15) - viewZY.getMeasuredHeight(), i21, Math.round(f15));
                        } else {
                            i17 = i16;
                            scVar = scVar2;
                            this.BT.sc(viewZY, zYVar, true, i21 - viewZY.getMeasuredWidth(), Math.round(f14), i21, Math.round(f14) + viewZY.getMeasuredHeight());
                        }
                        sc scVar3 = scVar;
                        float measuredHeight = f14 + viewZY.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) scVar3).bottomMargin;
                        float measuredHeight2 = f15 - ((viewZY.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) scVar3).topMargin);
                        if (z12) {
                            zYVar.sc(viewZY, 0, i29, 0, i18);
                        } else {
                            zYVar.sc(viewZY, 0, i18, 0, i29);
                        }
                        f11 = measuredHeight;
                        f12 = measuredHeight2;
                    }
                    i16 = i17 + 1;
                }
                int i31 = zYVar.f26319qr;
                paddingLeft += i31;
                i21 -= i31;
            } else {
                f11 = paddingTop;
                i15 = i19 - paddingBottom;
            }
            f12 = i15;
            f13 = 0.0f;
            float fMax2 = Math.max(f13, 0.0f);
            i16 = 0;
            while (i16 < zYVar.Qj) {
                int i210 = zYVar.BT + i16;
                viewZY = zY(i210);
                if (viewZY != null) {
                    i17 = i16;
                } else {
                    i17 = i16;
                }
                i16 = i17 + 1;
            }
            int i32 = zYVar.f26319qr;
            paddingLeft += i32;
            i21 -= i32;
        }
    }

    private void zY(int i11, int i12) {
        this.dE.clear();
        this.wjp.sc();
        this.BT.pFF(this.wjp, i11, i12);
        this.dE = this.wjp.f26318sc;
        this.BT.sc(i11, i12);
        this.BT.pFF(i11, i12, getPaddingLeft() + getPaddingRight());
        this.BT.sc();
        sc(this.f26313sc, i11, i12, this.wjp.pFF);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.SR == null) {
            this.SR = new SparseIntArray(getChildCount());
        }
        this.Ql = this.BT.sc(view, i11, layoutParams, this.SR);
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof sc;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof sc) {
            return new sc((sc) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new sc((ViewGroup.MarginLayoutParams) layoutParams) : new sc(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getAlignContent() {
        return this.ExN;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getAlignItems() {
        return this.We;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f26312qr;
    }

    public Drawable getDividerDrawableVertical() {
        return this.Qj;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getFlexDirection() {
        return this.f26313sc;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<zY> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.dE.size());
        for (zY zYVar : this.dE) {
            if (zYVar.pFF() != 0) {
                arrayList.add(zYVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public List<zY> getFlexLinesInternal() {
        return this.dE;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getFlexWrap() {
        return this.pFF;
    }

    public int getJustifyContent() {
        return this.zY;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getLargestMainSize() {
        Iterator<zY> it = this.dE.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().ExN);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getMaxLine() {
        return this.TRI;
    }

    public int getShowDividerHorizontal() {
        return this.Ol;
    }

    public int getShowDividerVertical() {
        return this.WH;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int getSumOfCrossSize() {
        int size = this.dE.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            zY zYVar = this.dE.get(i12);
            if (We(i12)) {
                i11 += sc() ? this.UFX : this.Tf;
            }
            if (TRI(i12)) {
                i11 += sc() ? this.UFX : this.Tf;
            }
            i11 += zYVar.f26319qr;
        }
        return i11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.Xc;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.Xc;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Qj == null && this.f26312qr == null) {
            return;
        }
        if (this.Ol == 0 && this.WH == 0) {
            return;
        }
        int iSc = qr.sc(this);
        int i11 = this.f26313sc;
        if (i11 == 0) {
            sc(canvas, iSc == 1, this.pFF == 2);
            return;
        }
        if (i11 == 1) {
            sc(canvas, iSc != 1, this.pFF == 2);
            return;
        }
        if (i11 == 2) {
            boolean z11 = iSc == 1;
            if (this.pFF == 2) {
                z11 = !z11;
            }
            pFF(canvas, z11, false);
            return;
        }
        if (i11 != 3) {
            return;
        }
        boolean z12 = iSc == 1;
        if (this.pFF == 2) {
            z12 = !z12;
        }
        pFF(canvas, z12, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        com.bytedance.adsdk.ugeno.zY zYVar = this.Xc;
        if (zYVar != null) {
            zYVar.TRI();
        }
        int iSc = qr.sc(this);
        int i15 = this.f26313sc;
        if (i15 == 0) {
            sc(iSc == 1, i11, i12, i13, i14);
        } else if (i15 == 1) {
            sc(iSc != 1, i11, i12, i13, i14);
        } else if (i15 == 2) {
            z12 = iSc == 1;
            sc(this.pFF == 2 ? !z12 : z12, false, i11, i12, i13, i14);
        } else {
            if (i15 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.f26313sc);
            }
            z12 = iSc == 1;
            sc(this.pFF == 2 ? !z12 : z12, true, i11, i12, i13, i14);
        }
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.Xc;
        if (zYVar2 != null) {
            zYVar2.sc(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.Xc;
        if (zYVar != null) {
            int[] iArrSc = zYVar.sc(i11, i12);
            sc(iArrSc[0], iArrSc[1]);
        } else {
            sc(i11, i12);
        }
        com.bytedance.adsdk.ugeno.zY zYVar2 = this.Xc;
        if (zYVar2 != null) {
            zYVar2.ExN();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.zY zYVar = this.Xc;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int pFF(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public View pFF(int i11) {
        return zY(i11);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int sc(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int sc(View view) {
        return 0;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public int sc(View view, int i11, int i12) {
        int i13;
        int i14;
        if (sc()) {
            i13 = We(i11, i12) ? this.Tf : 0;
            if ((this.WH & 4) <= 0) {
                return i13;
            }
            i14 = this.Tf;
        } else {
            i13 = We(i11, i12) ? this.UFX : 0;
            if ((this.Ol & 4) <= 0) {
                return i13;
            }
            i14 = this.UFX;
        }
        return i13 + i14;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public View sc(int i11) {
        return getChildAt(i11);
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public void sc(View view, int i11, int i12, zY zYVar) {
        if (We(i11, i12)) {
            if (sc()) {
                int i13 = zYVar.ExN;
                int i14 = this.Tf;
                zYVar.ExN = i13 + i14;
                zYVar.TRI += i14;
                return;
            }
            int i15 = zYVar.ExN;
            int i16 = this.UFX;
            zYVar.ExN = i15 + i16;
            zYVar.TRI += i16;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public void sc(zY zYVar) {
        if (sc()) {
            if ((this.WH & 4) > 0) {
                int i11 = zYVar.ExN;
                int i12 = this.Tf;
                zYVar.ExN = i11 + i12;
                zYVar.TRI += i12;
                return;
            }
            return;
        }
        if ((this.Ol & 4) > 0) {
            int i13 = zYVar.ExN;
            int i14 = this.UFX;
            zYVar.ExN = i13 + i14;
            zYVar.TRI += i14;
        }
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.Xc = zYVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public boolean sc() {
        int i11 = this.f26313sc;
        return i11 == 0 || i11 == 1;
    }

    public void setAlignContent(int i11) {
        if (this.ExN != i11) {
            this.ExN = i11;
            requestLayout();
        }
    }

    public void setAlignItems(int i11) {
        if (this.We != i11) {
            this.We = i11;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f26312qr) {
            return;
        }
        this.f26312qr = drawable;
        if (drawable != null) {
            this.UFX = drawable.getIntrinsicHeight();
        } else {
            this.UFX = 0;
        }
        pFF();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.Qj) {
            return;
        }
        this.Qj = drawable;
        if (drawable != null) {
            this.Tf = drawable.getIntrinsicWidth();
        } else {
            this.Tf = 0;
        }
        pFF();
        requestLayout();
    }

    public void setFlexDirection(int i11) {
        if (this.f26313sc != i11) {
            this.f26313sc = i11;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ExN.sc
    public void setFlexLines(List<zY> list) {
        this.dE = list;
    }

    public void setFlexWrap(int i11) {
        if (this.pFF != i11) {
            this.pFF = i11;
            requestLayout();
        }
    }

    public void setJustifyContent(int i11) {
        if (this.zY != i11) {
            this.zY = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.TRI != i11) {
            this.TRI = i11;
            requestLayout();
        }
    }

    public void setShowDivider(int i11) {
        setShowDividerVertical(i11);
        setShowDividerHorizontal(i11);
    }

    public void setShowDividerHorizontal(int i11) {
        if (i11 != this.Ol) {
            this.Ol = i11;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i11) {
        if (i11 != this.WH) {
            this.WH = i11;
            requestLayout();
        }
    }

    public View zY(int i11) {
        if (i11 < 0) {
            return null;
        }
        int[] iArr = this.Ql;
        if (i11 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i11]);
    }
}
