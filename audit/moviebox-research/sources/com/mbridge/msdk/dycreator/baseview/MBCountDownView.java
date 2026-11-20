package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.f.a.a;
import com.mbridge.msdk.f.a.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBCountDownView extends MBTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f43310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MBCountDownView f43311b;

    public MBCountDownView(Context context) {
        super(context);
        this.f43311b = this;
    }

    public MBCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43311b = this;
    }

    public MBCountDownView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43311b = this;
    }

    public void initView(final String str, final String str2, int i11) {
        this.f43310a = new b().b(i11 * 1000).a(1000L).a(new a() { // from class: com.mbridge.msdk.dycreator.baseview.MBCountDownView.1
            @Override // com.mbridge.msdk.f.a.a
            public void onFinish() {
                MBCountDownView.this.f43310a.a();
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }

            @Override // com.mbridge.msdk.f.a.a
            public void onTick(long j11) {
                if (str2.startsWith("zh")) {
                    MBCountDownView.this.f43311b.setText((j11 / 1000) + "s" + str);
                    return;
                }
                MBCountDownView.this.f43311b.setText(MBCountDownView.this.f43311b + " " + (j11 / 1000) + "s");
            }
        });
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f43310a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f43310a;
        if (bVar != null) {
            bVar.a();
        }
    }
}
