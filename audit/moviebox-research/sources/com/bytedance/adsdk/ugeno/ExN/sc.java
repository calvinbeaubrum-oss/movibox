package com.bytedance.adsdk.ugeno.ExN;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
interface sc {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<zY> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int pFF(int i11, int i12, int i13);

    View pFF(int i11);

    int sc(int i11, int i12, int i13);

    int sc(View view);

    int sc(View view, int i11, int i12);

    View sc(int i11);

    void sc(View view, int i11, int i12, zY zYVar);

    void sc(zY zYVar);

    boolean sc();

    void setFlexLines(List<zY> list);
}
