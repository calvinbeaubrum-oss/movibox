package p014OoooO0O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class OooOOO implements Runnable {
    public final /* synthetic */ float OooO00o;
    public final /* synthetic */ int OooO0O0;
    public final /* synthetic */ boolean OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final /* synthetic */ OooOOO0 f277OooO0Oo;

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OooOOO0 oooOOO0 = OooOOO.this.f277OooO0Oo;
            if (oooOOO0.o00000O0 == null || oooOOO0.oo000o == null) {
                return;
            }
            ((OooOOO0.g) oooOOO0.o0ooOoO).b(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                OooOOO0 oooOOO0 = OooOOO.this.f277OooO0Oo;
                oooOOO0.o00000O0 = null;
                if (oooOOO0.oo000o == null) {
                    ((OooOOO0.g) oooOOO0.o0ooOoO).c(MiniRefreshState.NONE);
                } else {
                    MiniRefreshState miniRefreshState = oooOOO0.o0OOO0o;
                    MiniRefreshState miniRefreshState2 = MiniRefreshState.RELEASE_TO_REFRESH;
                    if (miniRefreshState != miniRefreshState2) {
                        ((OooOOO0.g) oooOOO0.o0ooOoO).c(miniRefreshState2);
                    }
                    OooOOO oooOOO = OooOOO.this;
                    oooOOO.f277OooO0Oo.setStateRefreshing(!oooOOO.OooO0OO);
                }
            }
        }
    }

    public OooOOO(OooOOO0 oooOOO0, float f11, int i11, boolean z11) {
        this.f277OooO0Oo = oooOOO0;
        this.OooO00o = f11;
        this.OooO0O0 = i11;
        this.OooO0OO = z11;
    }

    @Override // java.lang.Runnable
    public void run() {
        OooOOO0 oooOOO0 = this.f277OooO0Oo;
        if (oooOOO0.o0Oo0oo != MiniRefreshState.REFRESHING) {
            return;
        }
        ValueAnimator valueAnimator = oooOOO0.o00000O0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f277OooO0Oo.o00000O0.cancel();
            this.f277OooO0Oo.o00000O0 = null;
        }
        OooOOO0 oooOOO1 = this.f277OooO0Oo;
        oooOOO1.f285OooOO0 = oooOOO1.getMeasuredWidth() / 2.0f;
        ((OooOOO0.g) this.f277OooO0Oo.o0ooOoO).c(MiniRefreshState.PULL_DOWN_TO_REFRESH);
        OooOOO0 oooOOO2 = this.f277OooO0Oo;
        oooOOO2.o00000O0 = ValueAnimator.ofInt(oooOOO2.OooO0O0, (int) (oooOOO2.Oooooo * this.OooO00o));
        this.f277OooO0Oo.o00000O0.setDuration(this.OooO0O0);
        this.f277OooO0Oo.o00000O0.setInterpolator(new x0.b(0));
        this.f277OooO0Oo.o00000O0.addUpdateListener(new a());
        this.f277OooO0Oo.o00000O0.addListener(new b());
        this.f277OooO0Oo.o00000O0.start();
    }
}
