package com.cloud.tmc.miniapp.widget;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LoadingTextView extends AppCompatTextView {
    public final String OooO00o;
    public LoadingAnimationModel OooO0O0;
    public int OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public int f31827OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public ObjectAnimator f31828OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public ObjectAnimator f31829OooO0o0;

    /* JADX INFO: compiled from: source.java */
    public static final class LoadingAnimationModel extends rc.b {
        private int creatRender;
        private int decompress;
        private int download;
        private long finishAnimationDuration;
        private long firstDuration;
        private int firstProgress;
        private int loadRender;
        private long secondDuration;

        public LoadingAnimationModel() {
            this(0, 0L, 0, 0, 0, 0, 0L, 0L, 255, null);
        }

        public LoadingAnimationModel(int i11, long j11, int i12, int i13, int i14, int i15, long j12, long j13) {
            this.firstProgress = i11;
            this.firstDuration = j11;
            this.download = i12;
            this.decompress = i13;
            this.creatRender = i14;
            this.loadRender = i15;
            this.secondDuration = j12;
            this.finishAnimationDuration = j13;
        }

        public /* synthetic */ LoadingAnimationModel(int i11, long j11, int i12, int i13, int i14, int i15, long j12, long j13, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 90 : i11, (i16 & 2) != 0 ? 3000L : j11, (i16 & 4) != 0 ? 93 : i12, (i16 & 8) != 0 ? 95 : i13, (i16 & 16) != 0 ? 97 : i14, (i16 & 32) != 0 ? 99 : i15, (i16 & 64) != 0 ? 1000L : j12, (i16 & 128) != 0 ? 100L : j13);
        }

        public final int component1() {
            return this.firstProgress;
        }

        public final long component2() {
            return this.firstDuration;
        }

        public final int component3() {
            return this.download;
        }

        public final int component4() {
            return this.decompress;
        }

        public final int component5() {
            return this.creatRender;
        }

        public final int component6() {
            return this.loadRender;
        }

        public final long component7() {
            return this.secondDuration;
        }

        public final long component8() {
            return this.finishAnimationDuration;
        }

        public final LoadingAnimationModel copy(int i11, long j11, int i12, int i13, int i14, int i15, long j12, long j13) {
            return new LoadingAnimationModel(i11, j11, i12, i13, i14, i15, j12, j13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadingAnimationModel)) {
                return false;
            }
            LoadingAnimationModel loadingAnimationModel = (LoadingAnimationModel) obj;
            return this.firstProgress == loadingAnimationModel.firstProgress && this.firstDuration == loadingAnimationModel.firstDuration && this.download == loadingAnimationModel.download && this.decompress == loadingAnimationModel.decompress && this.creatRender == loadingAnimationModel.creatRender && this.loadRender == loadingAnimationModel.loadRender && this.secondDuration == loadingAnimationModel.secondDuration && this.finishAnimationDuration == loadingAnimationModel.finishAnimationDuration;
        }

        public final int getCreatRender() {
            return this.creatRender;
        }

        public final int getDecompress() {
            return this.decompress;
        }

        public final int getDownload() {
            return this.download;
        }

        public final long getFinishAnimationDuration() {
            return this.finishAnimationDuration;
        }

        public final long getFirstDuration() {
            return this.firstDuration;
        }

        public final int getFirstProgress() {
            return this.firstProgress;
        }

        public final int getLoadRender() {
            return this.loadRender;
        }

        public final long getSecondDuration() {
            return this.secondDuration;
        }

        public int hashCode() {
            return l.p.a(this.finishAnimationDuration) + ((l.p.a(this.secondDuration) + ((this.loadRender + ((this.creatRender + ((this.decompress + ((this.download + ((l.p.a(this.firstDuration) + (this.firstProgress * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final void setCreatRender(int i11) {
            this.creatRender = i11;
        }

        public final void setDecompress(int i11) {
            this.decompress = i11;
        }

        public final void setDownload(int i11) {
            this.download = i11;
        }

        public final void setFinishAnimationDuration(long j11) {
            this.finishAnimationDuration = j11;
        }

        public final void setFirstDuration(long j11) {
            this.firstDuration = j11;
        }

        public final void setFirstProgress(int i11) {
            this.firstProgress = i11;
        }

        public final void setLoadRender(int i11) {
            this.loadRender = i11;
        }

        public final void setSecondDuration(long j11) {
            this.secondDuration = j11;
        }

        public String toString() {
            StringBuilder sbA = hd.j.a("LoadingAnimationModel(firstProgress=");
            sbA.append(this.firstProgress);
            sbA.append(", firstDuration=");
            sbA.append(this.firstDuration);
            sbA.append(", download=");
            sbA.append(this.download);
            sbA.append(", decompress=");
            sbA.append(this.decompress);
            sbA.append(", creatRender=");
            sbA.append(this.creatRender);
            sbA.append(", loadRender=");
            sbA.append(this.loadRender);
            sbA.append(", secondDuration=");
            sbA.append(this.secondDuration);
            sbA.append(", finishAnimationDuration=");
            sbA.append(this.finishAnimationDuration);
            sbA.append(')');
            return sbA.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class a implements TypeEvaluator<Integer> {
        public a(LoadingTextView loadingTextView) {
        }

        @Override // android.animation.TypeEvaluator
        public Integer evaluate(float f11, Integer num, Integer num2) {
            Integer num3 = num;
            Integer num4 = num2;
            int iIntValue = num3 != null ? num3.intValue() : 0;
            return Integer.valueOf((int) ((((num4 != null ? num4.intValue() : 0) - iIntValue) * f11) + iIntValue));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31830a;

        static {
            int[] iArr = new int[LoadStepAction.values().length];
            try {
                iArr[LoadStepAction.STEP_START_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadStepAction.STEP_UPDATE_APP_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_DECOMPRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_CREAT_RENDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_LOAD_RENDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LoadStepAction.STEP_FINISH_MINIAPP_LOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f31830a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingTextView(Context context, AttributeSet attributeSet) {
        LoadingAnimationModel loadingAnimationModel;
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.OooO00o = "LoadingTextView";
        try {
            Object objFromJson = com.cloud.tmc.miniutils.util.k.f().fromJson(MiniAppConfigHelper.f30370a.e("miniLoadProgressConfig", "{\"creatRender\":97,\"decompress\":95,\"download\":93,\"finishAnimationDuration\":100,\"firstDuration\":3000,\"firstProgress\":90,\"loadRender\":99,\"secondDuration\":1000}"), (Class<Object>) LoadingAnimationModel.class);
            Intrinsics.f(objFromJson, "{\n            val loadPr…el::class.java)\n        }");
            loadingAnimationModel = (LoadingAnimationModel) objFromJson;
        } catch (Throwable unused) {
            loadingAnimationModel = new LoadingAnimationModel(0, 0L, 0, 0, 0, 0, 0L, 0L, 255, null);
        }
        this.OooO0O0 = loadingAnimationModel;
    }

    public static final void OooO00o(LoadingTextView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f31827OooO0Oo = 0;
        this$0.setLoadingProgress(0);
        this$0.setText("0%");
    }

    public static final void OooO00o(LoadingTextView this$0, ValueAnimator it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        this$0.f31827OooO0Oo = Integer.parseInt(it.getAnimatedValue().toString());
    }

    public static final void OooO0O0(LoadingTextView this$0, ValueAnimator it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        this$0.f31827OooO0Oo = Integer.parseInt(it.getAnimatedValue().toString());
    }

    public final void OooO00o() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        try {
            ObjectAnimator objectAnimator3 = this.f31829OooO0o0;
            if (objectAnimator3 != null && objectAnimator3.isRunning() && (objectAnimator2 = this.f31829OooO0o0) != null) {
                objectAnimator2.cancel();
            }
            ObjectAnimator objectAnimator4 = this.f31828OooO0o;
            if (objectAnimator4 != null && objectAnimator4.isRunning() && (objectAnimator = this.f31828OooO0o) != null) {
                objectAnimator.cancel();
            }
            OooO0O0();
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
        }
    }

    public final void OooO00o(int i11) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f31829OooO0o0;
        if (objectAnimator2 != null && objectAnimator2.isRunning() && (objectAnimator = this.f31829OooO0o0) != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this, "loadingProgress", new a(this), Integer.valueOf(i11), Integer.valueOf(this.OooO0O0.getFirstProgress()));
        this.f31829OooO0o0 = objectAnimatorOfObject;
        if (objectAnimatorOfObject != null) {
            objectAnimatorOfObject.setDuration(this.OooO0O0.getFirstDuration());
        }
        ObjectAnimator objectAnimator3 = this.f31829OooO0o0;
        if (objectAnimator3 != null) {
            objectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ObjectAnimator objectAnimator4 = this.f31829OooO0o0;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
        ObjectAnimator objectAnimator5 = this.f31829OooO0o0;
        if (objectAnimator5 != null) {
            objectAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.tmc.miniapp.widget.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingTextView.OooO00o(this.f31897a, valueAnimator);
                }
            });
        }
    }

    public final void OooO00o(int i11, int i12, long j11) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3 = this.f31829OooO0o0;
        if (objectAnimator3 == null || !objectAnimator3.isRunning() || i12 == 100) {
            ObjectAnimator objectAnimator4 = this.f31829OooO0o0;
            if (objectAnimator4 != null && objectAnimator4.isRunning() && (objectAnimator2 = this.f31829OooO0o0) != null) {
                objectAnimator2.cancel();
            }
            ObjectAnimator objectAnimator5 = this.f31828OooO0o;
            if (objectAnimator5 != null && objectAnimator5.isRunning() && (objectAnimator = this.f31828OooO0o) != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this, "loadingProgress", new a(this), Integer.valueOf(i11), Integer.valueOf(i12));
            this.f31828OooO0o = objectAnimatorOfObject;
            if (objectAnimatorOfObject != null) {
                objectAnimatorOfObject.setDuration(j11);
            }
            ObjectAnimator objectAnimator6 = this.f31828OooO0o;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
            ObjectAnimator objectAnimator7 = this.f31828OooO0o;
            if (objectAnimator7 != null) {
                objectAnimator7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.tmc.miniapp.widget.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LoadingTextView.OooO0O0(this.f31895a, valueAnimator);
                    }
                });
            }
        }
    }

    public final void OooO0O0() {
        post(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                LoadingTextView.OooO00o(this.f31896a);
            }
        });
    }

    public final int getLoadingProgress() {
        return this.OooO0OO;
    }

    public final LoadingAnimationModel getProgressConfigModel() {
        return this.OooO0O0;
    }

    public final void setLoadingProgress(int i11) {
        int i12 = this.f31827OooO0Oo;
        if (i12 != this.OooO0OO || i12 == 100) {
            int i13 = i12 + 1;
            if (i13 > 100) {
                i13 = 100;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i13);
            sb2.append('%');
            setText(sb2.toString());
            if (this.f31827OooO0Oo == 100) {
                Context context = getContext();
                com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
                if (oooO0OO != null) {
                    oooO0OO.hideStatusLoading();
                }
            }
        }
        this.OooO0OO = i11;
    }

    public final void setProgressConfigModel(LoadingAnimationModel loadingAnimationModel) {
        Intrinsics.g(loadingAnimationModel, "<set-?>");
        this.OooO0O0 = loadingAnimationModel;
    }
}
