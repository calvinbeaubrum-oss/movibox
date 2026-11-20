package com.avery.subtitle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.avery.subtitle.DefaultSubtitleEngine;
import com.avery.subtitle.b;
import y7.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleSubtitleView extends AppCompatTextView implements b, b.a, b.InterfaceC0209b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f25155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BgBubbleDrawable f25158d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f25162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25163j;

    public SimpleSubtitleView(Context context) {
        super(context);
        this.f25159f = false;
        this.f25160g = false;
        this.f25161h = 0;
        this.f25162i = 0;
        this.f25163j = 0;
        a();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25159f = false;
        this.f25160g = false;
        this.f25161h = 0;
        this.f25162i = 0;
        this.f25163j = 0;
        a();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f25159f = false;
        this.f25160g = false;
        this.f25161h = 0;
        this.f25162i = 0;
        this.f25163j = 0;
        a();
    }

    private void a() {
        DefaultSubtitleEngine defaultSubtitleEngine = new DefaultSubtitleEngine();
        this.f25155a = defaultSubtitleEngine;
        defaultSubtitleEngine.setOnSubtitlePreparedListener(this);
        this.f25155a.setOnSubtitleChangeListener(this);
    }

    public final void b() {
        c(getWidth(), getHeight());
    }

    public final void c(int i11, int i12) {
        d(0, i11, 0, i12);
    }

    public void closeBg() {
        this.f25159f = false;
        this.f25160g = true;
        this.f25161h = 0;
        this.f25162i = 0;
        this.f25163j = 0;
        requestLayout();
    }

    public final void d(int i11, int i12, int i13, int i14) {
        if (this.f25159f || this.f25160g) {
            this.f25160g = false;
            BgBubbleDrawable bgBubbleDrawableT = new BgBubbleDrawable.b().u(new RectF(i11, i13, i12, i14)).s(BgBubbleDrawable.BubbleType.COLOR).p(this.f25163j).q(BgBubbleDrawable.ArrowLocation.NONE).r(this.f25161h).t();
            this.f25158d = bgBubbleDrawableT;
            bgBubbleDrawableT.setAlpha(this.f25162i);
        }
    }

    @Override // com.avery.subtitle.b
    public void destroy() {
        this.f25155a.destroy();
    }

    @Override // com.avery.subtitle.b
    public void initSubtitle(a aVar, boolean z11) {
        this.f25155a.initSubtitle(aVar, z11);
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        b();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        BgBubbleDrawable bgBubbleDrawable = this.f25158d;
        if (bgBubbleDrawable != null) {
            bgBubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // com.avery.subtitle.b.InterfaceC0209b
    public void onRefreshSubtitle() {
        refreshImmediately();
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        c(i11, i12);
    }

    @Override // com.avery.subtitle.b.a
    public void onSubtitleChanged(@Nullable a8.b bVar) {
        if (this.f25157c) {
            return;
        }
        if (bVar == null || TextUtils.isEmpty(bVar.f453d)) {
            setText("");
            setVisibility(4);
        } else {
            if (TextUtils.equals(this.f25156b, bVar.f453d)) {
                return;
            }
            setVisibility(0);
            String strReplace = bVar.f453d.replace("\\N", "\n");
            bVar.f453d = strReplace;
            this.f25156b = strReplace;
            if (b8.b.b(strReplace).booleanValue()) {
                setText(Html.fromHtml(bVar.f453d));
            } else {
                setText(bVar.f453d);
            }
        }
    }

    @Override // com.avery.subtitle.b.InterfaceC0209b
    public void onSubtitlePrepared() {
        start();
    }

    public void openBg() {
        this.f25159f = true;
        requestLayout();
    }

    @Override // com.avery.subtitle.b
    public void pause() {
        this.f25155a.pause();
    }

    @Override // com.avery.subtitle.b
    public void refreshImmediately() {
        this.f25155a.refreshImmediately();
    }

    @Override // com.avery.subtitle.b
    public void reset() {
        this.f25155a.reset();
    }

    @Override // com.avery.subtitle.b
    public void resume() {
        this.f25155a.resume();
    }

    @Override // com.avery.subtitle.b
    public void selectSubtitle(String str, String str2, y7.b bVar) {
        this.f25155a.selectSubtitle(str, str2, bVar);
    }

    public void setBgAlpha(int i11) {
        if (this.f25159f) {
            this.f25162i = i11;
            requestLayout();
        }
    }

    public void setBgColor(int i11) {
        if (this.f25159f) {
            this.f25161h = i11;
            requestLayout();
        }
    }

    public void setBgdRadius(int i11) {
        if (this.f25159f) {
            this.f25163j = i11;
            requestLayout();
        }
    }

    @Override // com.avery.subtitle.b
    public void setDefaultSubtitle(String str) {
        this.f25155a.setDefaultSubtitle(str);
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitleChangeListener(b.a aVar) {
        this.f25155a.setOnSubtitleChangeListener(aVar);
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitlePreparedListener(b.InterfaceC0209b interfaceC0209b) {
        this.f25155a.setOnSubtitlePreparedListener(interfaceC0209b);
    }

    @Override // com.avery.subtitle.b
    public void setSubtitlePath(String str, String str2) {
        this.f25155a.setSubtitlePath(str, str2);
    }

    @Override // com.avery.subtitle.b
    public void start() {
        this.f25155a.start();
    }

    @Override // com.avery.subtitle.b
    public void stop() {
        this.f25155a.stop();
    }

    @Override // com.avery.subtitle.b
    public void subtitleDelay(long j11) {
        this.f25155a.subtitleDelay(j11);
    }

    public void turnOff(boolean z11) {
        this.f25157c = z11;
        setText("");
        setVisibility(4);
    }
}
