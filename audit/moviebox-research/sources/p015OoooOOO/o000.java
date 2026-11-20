package p015OoooOOO;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.cloud.tmc.miniutils.util.i0;
import hd.j;
import java.io.File;
import kd.k;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p0.f;
import p0.h;
import p0.i;
import p017OoooOo0.Oooo000;
import s0.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000 extends Oooo000 implements f {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public h f321OooO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public ImageView f322OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public String f323OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public TextView f324OooO0o0;
    public int OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public int f325OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public File f326OooOO0;
    public File OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public File f327OooOO0o;
    public File OooOOO0;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function1<Drawable, Unit> {
        public final /* synthetic */ ImageView OooO00o;
        public final /* synthetic */ Drawable OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(ImageView imageView, Drawable drawable) {
            super(1);
            this.OooO00o = imageView;
            this.OooO0O0 = drawable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Drawable drawable) {
            this.OooO00o.setImageDrawable(this.OooO0O0);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328a;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            try {
                iArr[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiniRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MiniRefreshState.REFRESH_RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MiniRefreshState.RELEASE_TO_REFRESH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f328a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public o000(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.g(context, "context");
        this.f325OooO0oo = 500;
        this.OooO0O0 = b.f75911d;
        View.inflate(context, R$layout.layout_sharp_news_header, this);
        this.f322OooO0Oo = (ImageView) findViewById(R$id.srl_classics_progress);
        TextView textView = (TextView) findViewById(R$id.srl_classics_title);
        this.f324OooO0o0 = textView;
        if (textView != null) {
            textView.setTextSize(0, x0.b.a(16.0f));
        }
        this.f323OooO0o = context.getString(R$string.srl_header_pulling);
        context.getString(R$string.srl_header_release);
        context.getString(R$string.srl_header_finish);
        context.getString(R$string.srl_header_failed);
        context.getString(R$string.srl_header_refreshing);
        setVisibility(4);
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public int OooO00o(i miniRefreshLayout, boolean z11) {
        Intrinsics.g(miniRefreshLayout, "miniRefreshLayout");
        if (z11) {
            OooO00o(2);
            TextView textView = this.f324OooO0o0;
            if (textView != null) {
                textView.setText("");
            }
        }
        return this.f325OooO0oo;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    /* JADX WARN: Code duplicated, block: B:31:0x004b  */
    public final void OooO00o(int i11) {
        ImageView imageView;
        File file;
        File file2;
        String absolutePath;
        Context context = getContext();
        if (context == null || (imageView = this.f322OooO0Oo) == null) {
            return;
        }
        if (i11 == 1) {
            file = this.f326OooOO0;
        } else if (i11 == 2) {
            file = this.OooOO0O;
        } else if (i11 != 3) {
            file = i11 != 4 ? null : this.OooOOO0;
        } else {
            file = this.f327OooOO0o;
        }
        if (!FileUtil.c(file)) {
            k.a(j.a("加载目标文件不存在，"), file != null ? file.getAbsolutePath() : null, "MiniCustomHeader");
            return;
        }
        if (i11 == 1) {
            file2 = this.f327OooOO0o;
        } else if (i11 == 2) {
            file2 = this.OooOOO0;
        } else if (i11 == 3) {
            file2 = this.f327OooOO0o;
        } else if (i11 != 4) {
            file2 = null;
        } else {
            file2 = this.OooOOO0;
        }
        if (!FileUtil.c(file2)) {
            k.a(j.a("加载占位图文件不存在，"), file2 != null ? file2.getAbsolutePath() : null, "MiniCustomHeader");
            return;
        }
        if (file2 != null) {
            try {
                absolutePath = file2.getAbsolutePath();
            } catch (Throwable th2) {
                TmcLogger.g("MiniCustomHeader", "Error loading image", th2);
                return;
            }
        } else {
            absolutePath = null;
        }
        Drawable drawableCreateFromPath = Drawable.createFromPath(absolutePath);
        if (i11 == 1) {
            ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgGifPlay(context, file, drawableCreateFromPath, imageView);
            return;
        }
        if (i11 == 2) {
            ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgGifPlayOnce(context, file, 0, imageView, new OooO0O0(imageView, drawableCreateFromPath));
        } else if (i11 == 3 || i11 == 4) {
            imageView.setImageDrawable(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(h kernel, int i11, int i12) {
        Intrinsics.g(kernel, "kernel");
        this.f321OooO = kernel;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(i miniRefreshLayout, int i11, int i12) {
        Intrinsics.g(miniRefreshLayout, "miniRefreshLayout");
        OooO00o(1);
    }

    @Override // p017OoooOo0.Oooo000, w0.d
    public void OooO00o(i miniRefreshLayout, MiniRefreshState oldState, MiniRefreshState newState) {
        Intrinsics.g(miniRefreshLayout, "miniRefreshLayout");
        Intrinsics.g(oldState, "oldState");
        Intrinsics.g(newState, "newState");
        int i11 = a.f328a[newState.ordinal()];
        if (i11 == 1) {
            OooO00o(3);
            ImageView imageView = this.f322OooO0Oo;
            if (imageView != null) {
                xb.i.e(imageView);
            }
            TextView textView = this.f324OooO0o0;
            if (textView == null) {
                return;
            }
            textView.setText(this.f323OooO0o);
            return;
        }
        if (i11 == 2 || i11 == 3) {
            TextView textView2 = this.f324OooO0o0;
            if (textView2 == null) {
                return;
            }
            textView2.setText("");
            return;
        }
        if (i11 != 4) {
            return;
        }
        try {
            i0.c(100L);
        } catch (Throwable th2) {
            TmcLogger.g("MiniCustomHeader", "ReleaseToRefresh vibrate failed!", th2);
        }
        TextView textView3 = this.f324OooO0o0;
        if (textView3 == null) {
            return;
        }
        textView3.setText(this.f323OooO0o);
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(boolean z11, float f11, int i11, int i12, int i13) {
        setAlpha(kotlin.ranges.a.c(0.0f, kotlin.ranges.a.f(1.0f, f11)));
        if (i11 > this.OooO0oO) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        } else if (getVisibility() != 4) {
            setVisibility(4);
        }
        if (i11 == 0) {
            OooO00o(3);
        }
    }
}
