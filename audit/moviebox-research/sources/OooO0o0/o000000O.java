package OooO0o0;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000000O extends OooO0o0.OooO0OO.OooO00o<o000000O> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AnimatorSet f114u;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) o000000O.this.findViewById(R$id.iv_loading);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000000O.this.findViewById(R$id.tv_wait_message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0o0.OooO0OO.j {
        public a() {
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0o0.OooO0OO oooO0OO) {
            o000000O o000000o = o000000O.this;
            o000000o.getClass();
            try {
                AppCompatImageView appCompatImageView = (AppCompatImageView) o000000o.f113t.getValue();
                if (appCompatImageView != null) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatImageView, "rotation", 0.0f, 360.0f);
                    Intrinsics.f(objectAnimatorOfFloat, "ofFloat(it, \"rotation\", 0F, 360F)");
                    objectAnimatorOfFloat.setDuration(800L);
                    objectAnimatorOfFloat.setRepeatCount(-1);
                    o000000o.f114u.play(objectAnimatorOfFloat);
                    o000000o.f114u.start();
                }
            } catch (Exception e11) {
                TmcLogger.e(e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0o0.OooO0OO.h {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0o0.OooO0OO oooO0OO) {
            o000000O o000000o = o000000O.this;
            o000000o.getClass();
            try {
                o000000o.f114u.cancel();
            } catch (Exception e11) {
                TmcLogger.e(e11.getMessage());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000000O(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        LazyKt__LazyJVMKt.b(new OooO0o());
        this.f113t = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f114u = new AnimatorSet();
        j(R$layout.layout_mini_waiting_dialog);
        b(0);
        g(false);
        k(false);
        e(new a());
        d(new b());
    }
}
