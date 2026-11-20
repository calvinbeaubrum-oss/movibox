package hn;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.OnSkipListener;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.hisavana.common.interfacz.TInnerAdListener;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.CloudControlConfigSync;
import com.hisavana.mediation.config.ConfigContentHelper;
import w9.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class s extends TInnerAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public in.b f66646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TAdListener f66647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnSkipListener f66648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TAdditionalListener f66649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f66650e;

    public s(@NonNull in.b bVar) {
        this.f66646a = bVar;
    }

    public TAdditionalListener a() {
        return this.f66649d;
    }

    public void b(int i11) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> source --> " + i11);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onClosed(i11);
        }
    }

    public void c(AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onLoadSuccess(additionalInfo);
        }
    }

    public void d(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + tAdErrorCode + "\n>>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    public void e(TAdNativeInfo tAdNativeInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> NativeInfo -->" + tAdNativeInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onClosed(tAdNativeInfo);
        }
    }

    public void f(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> NativeInfo -->" + tAdNativeInfo + "\n>>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onClick(tAdNativeInfo, additionalInfo);
        }
    }

    public void g(OnSkipListener onSkipListener) {
        this.f66648c = onSkipListener;
    }

    public void h(TAdListener tAdListener) {
        this.f66647b = tAdListener;
    }

    public void i(TAdditionalListener tAdditionalListener) {
        this.f66649d = tAdditionalListener;
    }

    public final void j(String str) {
        CloudControlConfig.CodeSeat codeSeatB;
        in.b bVar = this.f66646a;
        if (bVar == null || TextUtils.isEmpty(bVar.f67233a) || (codeSeatB = h.b(this.f66646a.f67233a, str, true)) == null) {
            return;
        }
        ConfigContentHelper.g().j(codeSeatB);
    }

    public TAdListener k() {
        return this.f66647b;
    }

    public void l(int i11) {
        this.f66650e = i11;
    }

    public void m(AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onShowed(additionalInfo);
        }
    }

    public void n(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + tAdErrorCode + "\n>>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onShowError(tAdErrorCode, additionalInfo);
        }
    }

    public void o(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> NativeInfo -->" + tAdNativeInfo + "\n>>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onShow(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onClicked(int i11) {
        AdLogUtil.Log().d("TAdListenerAdapter", "onClicked");
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onClosed(int i11) {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on close");
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onClosed()");
            this.f66647b.onClosed(i11);
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(false);
        }
        b(i11);
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onClosed(TAdNativeInfo tAdNativeInfo) {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on close");
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onClosed()");
            this.f66647b.onClosed(tAdNativeInfo);
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(false);
        }
        e(tAdNativeInfo);
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        if (this.f66646a == null) {
            return;
        }
        int errorCode = tAdErrorCode != null ? tAdErrorCode.getErrorCode() : -1;
        String errorMessage = tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : "";
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on alliance error: " + errorMessage);
        this.f66646a.stopTimer();
        this.f66646a.setLoading(false);
        this.f66646a.setLoaded(false);
        this.f66646a.trackingAdLoaded(errorCode, errorMessage, this.f66650e);
        TAdListener tAdListener = this.f66647b;
        if (tAdListener != null) {
            tAdListener.onError(tAdErrorCode);
        }
        this.f66646a.c(tAdErrorCode);
        if (errorCode == 20001) {
            CloudControlConfigSync.b(3);
        }
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onLoad() {
        TAdListener tAdListener = this.f66647b;
        if (tAdListener != null) {
            tAdListener.onLoad();
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setLoaded(true);
            this.f66646a.l();
            this.f66646a.q();
        }
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onNativeFeedClicked(int i11, TAdNativeInfo tAdNativeInfo, @NonNull AdditionalInfo additionalInfo) {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on click");
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onClicked()");
            if (tAdNativeInfo == null) {
                this.f66647b.onClicked(i11);
            } else {
                this.f66647b.onNativeFeedClicked(i11, tAdNativeInfo);
            }
        }
        f(tAdNativeInfo, additionalInfo);
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onNativeFeedShow(int i11, TAdNativeInfo tAdNativeInfo, @NonNull AdditionalInfo additionalInfo) {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on show");
        t();
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onShow()");
            if (tAdNativeInfo == null) {
                this.f66647b.onShow(i11);
            } else {
                this.f66647b.onNativeFeedShow(i11, tAdNativeInfo);
            }
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(true);
        }
        o(tAdNativeInfo, additionalInfo);
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onRewarded() {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> on rewarded");
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onRewarded()");
            this.f66647b.onRewarded();
        }
        r();
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onShow(int i11) {
        AdLogUtil.Log().d("TAdListenerAdapter", "onShow");
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onShowError(TAdErrorCode tAdErrorCode) {
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TAdListenerAdapter --> on onAdShowError，errorCode");
        sb2.append(tAdErrorCode);
        adLogUtilLog.d(ComConstants.AD_FLOW, sb2.toString() != null ? tAdErrorCode.getErrorMessage() : "");
        if (this.f66647b != null) {
            com.cloud.sdk.commonutil.util.c.Log().d(ComConstants.AD_FLOW, "TAdListenerAdapter --> >>> onAdShowError()");
            this.f66647b.onShowError(tAdErrorCode);
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(false);
            this.f66646a.d(tAdErrorCode);
        }
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onShowed(@NonNull AdditionalInfo additionalInfo) {
        j(additionalInfo.getCodeSeatId());
        m(additionalInfo);
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onSkipClick() {
        OnSkipListener onSkipListener = this.f66648c;
        if (onSkipListener != null) {
            onSkipListener.onClick();
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(false);
        }
    }

    @Override // com.hisavana.common.interfacz.TInnerAdListener
    public void onTimeReach() {
        OnSkipListener onSkipListener = this.f66648c;
        if (onSkipListener != null) {
            onSkipListener.onTimeReach();
        }
        in.b bVar = this.f66646a;
        if (bVar != null) {
            bVar.setIsShowing(false);
        }
    }

    public void p() {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "*----> TAdListenerAdapter --> on alliance ad load");
        if (this.f66646a == null) {
            return;
        }
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "*----> TAdListenerAdapter --> >>> onLoad()");
        this.f66646a.stopTimer();
        this.f66646a.setLoading(false);
        in.b bVar = this.f66646a;
        int i11 = this.f66650e;
        bVar.mFillSource = i11;
        bVar.trackingAdLoaded(0, "", i11);
        onLoad();
        CloudControlConfigSync.b(3);
    }

    public void q(AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onTrigger(additionalInfo);
        }
    }

    public void r() {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> rewarded");
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onRewarded();
        }
    }

    public void s(AdditionalInfo additionalInfo) {
        AdLogUtil.Log().w(ComConstants.AD_FLOW, ">>>>> " + additionalInfo);
        TAdditionalListener tAdditionalListener = this.f66649d;
        if (tAdditionalListener != null) {
            tAdditionalListener.onTriggerShow(additionalInfo);
        }
    }

    public final void t() {
        in.b bVar = this.f66646a;
        if (bVar == null || TextUtils.isEmpty(bVar.f67233a)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        CloudControlConfig.CodeSeat codeSeatA = h.a(this.f66646a.f67233a);
        if (codeSeatA == null) {
            return;
        }
        codeSeatA.setLastShowTime(jCurrentTimeMillis);
        long jC = y.c(jCurrentTimeMillis);
        long jB = y.b(jCurrentTimeMillis);
        if (codeSeatA.getCurrentHourZeroClock() == jB) {
            codeSeatA.setCurrentHourShowTimes(codeSeatA.getCurrentHourShowTimes() + 1);
        } else {
            codeSeatA.setCurrentHourShowTimes(1);
            codeSeatA.setCurrentHourZeroClock(jB);
        }
        if (codeSeatA.getTodayZeroClock() == jC) {
            codeSeatA.setTodayShowTimes(codeSeatA.getTodayShowTimes() + 1);
        } else {
            codeSeatA.setTodayShowTimes(1);
            codeSeatA.setTodayZeroClock(jC);
        }
        ConfigContentHelper.g().j(codeSeatA);
    }
}
