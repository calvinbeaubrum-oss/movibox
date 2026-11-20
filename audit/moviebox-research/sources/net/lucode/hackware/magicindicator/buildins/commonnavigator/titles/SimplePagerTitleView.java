package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;
import h20.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class SimplePagerTitleView extends TextView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71885b;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        a(context);
    }

    private void a(Context context) {
        setGravity(17);
        int iA = g20.b.a(context, 10.0d);
        setPadding(iA, 0, iA, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // h20.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // h20.b
    public int getContentLeft() {
        String string;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            string = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentRight() {
        String string;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            string = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f71885b;
    }

    public int getSelectedColor() {
        return this.f71884a;
    }

    public void onDeselected(int i11, int i12) {
        setTextColor(this.f71885b);
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        setTextColor(this.f71884a);
    }

    public void setNormalColor(int i11) {
        this.f71885b = i11;
    }

    public void setSelectedColor(int i11) {
        this.f71884a = i11;
    }
}
