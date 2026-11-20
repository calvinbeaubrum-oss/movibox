package p015OoooOOO;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.R$styleable;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.cloud.tmc.miniutils.util.i0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p0.f;
import p0.i;
import p017OoooOo0.Oooo0;
import s0.b;
import v0.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o0000OO0 extends Oooo0<o0000OO0> implements f {
    public Date OooOOo;
    public String OooOOo0;
    public TextView OooOOoo;
    public String OooOo;
    public boolean OooOo0;
    public DateFormat OooOo00;
    public boolean OooOo0O;
    public String OooOo0o;
    public String OooOoO;
    public String OooOoO0;

    /* JADX INFO: renamed from: OooOoOO, reason: collision with root package name */
    public String f339OooOoOO;

    /* JADX INFO: renamed from: OooOoo, reason: collision with root package name */
    public String f340OooOoo;

    /* JADX INFO: renamed from: OooOoo0, reason: collision with root package name */
    public String f341OooOoo0;
    public int OooOooO;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f342a;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            f342a = iArr;
            try {
                iArr[MiniRefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f342a[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f342a[MiniRefreshState.REFRESHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f342a[MiniRefreshState.REFRESH_RELEASED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f342a[MiniRefreshState.RELEASE_TO_REFRESH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f342a[MiniRefreshState.RELEASE_TO_TWO_LEVEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f342a[MiniRefreshState.LOADING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public o0000OO0(Context context, AttributeSet attributeSet) {
        FragmentManager supportFragmentManager;
        super(context, null, 0);
        this.OooOOo0 = "LAST_UPDATE_TIME";
        this.OooOo0 = true;
        this.OooOo0O = true;
        this.OooOooO = 0;
        View.inflate(context, R$layout.layout_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R$id.srl_classics_arrow);
        this.f346OooO0o0 = imageView;
        TextView textView = (TextView) findViewById(R$id.srl_classics_update);
        this.OooOOoo = textView;
        ImageView imageView2 = (ImageView) findViewById(R$id.srl_classics_progress);
        this.f345OooO0o = imageView2;
        this.f344OooO0Oo = (TextView) findViewById(R$id.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.MiniClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MiniClassicsHeader_srlTextTimeMarginTop, layoutParams3.topMargin);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MiniClassicsFooter_srlDrawableMarginRight, layoutParams2.rightMargin);
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MiniClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.OooOOO0 = typedArrayObtainStyledAttributes.getInt(R$styleable.MiniClassicsHeader_srlFinishDuration, this.OooOOO0);
        this.OooOo0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniClassicsHeader_srlEnableLastTime, this.OooOo0);
        this.OooOo0O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniClassicsHeader_srlEnableArrowView, this.OooOo0O);
        this.OooO0O0 = b.f75915h[typedArrayObtainStyledAttributes.getInt(R$styleable.MiniClassicsHeader_srlClassicsSpinnerStyle, this.OooO0O0.f75916a)];
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlDrawableArrow)) {
            this.f346OooO0o0.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R$styleable.MiniClassicsHeader_srlDrawableArrow));
        } else if (this.f346OooO0o0.getDrawable() == null) {
            v0.a aVar = new v0.a();
            this.f347OooO0oo = aVar;
            aVar.a(-10066330);
            this.f346OooO0o0.setImageDrawable(this.f347OooO0oo);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlDrawableProgress)) {
            this.f345OooO0o.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R$styleable.MiniClassicsHeader_srlDrawableProgress));
        } else if (this.f345OooO0o.getDrawable() == null) {
            c cVar = new c();
            this.f343OooO = cVar;
            cVar.a(-10066330);
            this.f345OooO0o.setImageDrawable(this.f343OooO);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextSizeTitle)) {
            this.f344OooO0Oo.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MiniClassicsHeader_srlTextSizeTitle, x0.b.a(16.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextSizeTime)) {
            this.OooOOoo.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MiniClassicsHeader_srlTextSizeTime, x0.b.a(12.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlPrimaryColor)) {
            OooO0O0(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniClassicsHeader_srlPrimaryColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlAccentColor)) {
            OooO00o(typedArrayObtainStyledAttributes.getColor(R$styleable.MiniClassicsHeader_srlAccentColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextPulling)) {
            this.OooOo0o = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextPulling);
        } else {
            this.OooOo0o = context.getString(R$string.srl_header_pulling);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextLoading)) {
            this.OooOoO0 = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextLoading);
        } else {
            this.OooOoO0 = context.getString(R$string.srl_header_loading);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextRelease)) {
            this.OooOoO = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextRelease);
        } else {
            this.OooOoO = context.getString(R$string.srl_header_release);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextFinish)) {
            this.f339OooOoOO = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextFinish);
        } else {
            this.f339OooOoOO = context.getString(R$string.srl_header_finish);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextFailed)) {
            typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextFailed);
        } else {
            context.getString(R$string.srl_header_failed);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextSecondary)) {
            this.f340OooOoo = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextSecondary);
        } else {
            this.f340OooOoo = context.getString(R$string.srl_header_secondary);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextRefreshing)) {
            this.OooOo = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextRefreshing);
        } else {
            this.OooOo = context.getString(R$string.srl_header_refreshing);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniClassicsHeader_srlTextUpdate)) {
            this.f341OooOoo0 = typedArrayObtainStyledAttributes.getString(R$styleable.MiniClassicsHeader_srlTextUpdate);
        } else {
            this.f341OooOoo0 = context.getString(R$string.srl_header_update);
        }
        this.OooOo00 = new SimpleDateFormat(this.f341OooOoo0, Locale.getDefault());
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.OooOo0 ? 0 : 8);
        this.f346OooO0o0.setVisibility(this.OooOo0O ? 0 : 8);
        this.f344OooO0Oo.setText(isInEditMode() ? this.OooOo : this.OooOo0o);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        setVisibility(4);
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && supportFragmentManager.getFragments().size() > 0) {
                OooO00o(new Date());
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.OooOOo0 += context.getClass().getName();
        try {
            long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", this.OooOOo0);
            OooO00o(new Date(j11 == 0 ? System.currentTimeMillis() : j11));
        } catch (Throwable th3) {
            TmcLogger.h("MiniClassicsHeader", th3);
        }
    }

    @Override // p017OoooOo0.Oooo0, p017OoooOo0.Oooo000, p0.g
    public int OooO00o(@NonNull i iVar, boolean z11) {
        if (z11) {
            this.f344OooO0Oo.setText(this.f339OooOoOO);
            if (this.OooOOo != null) {
                OooO00o(new Date());
            }
        }
        if (z11) {
            return super.OooO00o(iVar, z11);
        }
        final ImageView imageView = this.f345OooO0o;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.postDelayed(new Runnable() { // from class: t0.a
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setVisibility(8);
            }
        }, this.OooOOO0 + 100);
        return this.OooOOO0;
    }

    public o0000OO0 OooO00o(Date date) {
        try {
            this.OooOOo = date;
            this.OooOOoo.setText(this.OooOo00.format(date));
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(getContext(), "miniLauncherGlobal", this.OooOOo0, date.getTime());
        } catch (Throwable th2) {
            Log.e("MiniClassicsHeader", "setLastUpdateTime: ", th2);
        }
        return this;
    }

    @Override // p017OoooOo0.Oooo000, w0.d
    public void OooO00o(@NonNull i iVar, @NonNull MiniRefreshState miniRefreshState, @NonNull MiniRefreshState miniRefreshState2) {
        ImageView imageView = this.f346OooO0o0;
        TextView textView = this.OooOOoo;
        switch (a.f342a[miniRefreshState2.ordinal()]) {
            case 1:
                textView.setVisibility(this.OooOo0 ? 0 : 8);
                this.f344OooO0Oo.setText(this.OooOo0o);
                if (this.OooOo0O) {
                    imageView.setVisibility(0);
                    imageView.animate().rotation(0.0f);
                }
                break;
            case 2:
                this.f344OooO0Oo.setText(this.OooOo0o);
                if (this.OooOo0O) {
                    imageView.setVisibility(0);
                    imageView.animate().rotation(0.0f);
                }
                break;
            case 3:
            case 4:
                this.f344OooO0Oo.setText(this.OooOo);
                if (this.OooOo0O) {
                    imageView.setVisibility(8);
                }
                break;
            case 5:
                try {
                    i0.c(100L);
                } catch (Throwable th2) {
                    TmcLogger.g("MiniRefreshHeader", "ReleaseToRefresh vibrate failed!", th2);
                }
                this.f344OooO0Oo.setText(this.OooOoO);
                if (this.OooOo0O) {
                    imageView.animate().rotation(180.0f);
                }
                break;
            case 6:
                this.f344OooO0Oo.setText(this.f340OooOoo);
                if (this.OooOo0O) {
                    imageView.animate().rotation(0.0f);
                }
                break;
            case 7:
                if (this.OooOo0O) {
                    imageView.setVisibility(8);
                }
                textView.setVisibility(this.OooOo0 ? 4 : 8);
                this.f344OooO0Oo.setText(this.OooOoO0);
                break;
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(boolean z11, float f11, int i11, int i12, int i13) {
        if (i11 >= this.OooOooO) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        } else if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    @Override // p017OoooOo0.Oooo0
    /* JADX INFO: renamed from: OooO0OO, reason: merged with bridge method [inline-methods] */
    public o0000OO0 OooO00o(int i11) {
        this.OooOOoo.setTextColor((16777215 & i11) | (-872415232));
        return (o0000OO0) super.OooO00o(i11);
    }
}
