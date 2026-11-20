package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f73888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f73889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f73890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f73891d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f73892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bitmap f73893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GifInfoHandle f73894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f73895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f73896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuffColorFilter f73897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f73898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f73899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f73900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RenderTask f73901o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f73902p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ScheduledFuture<?> f73903q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f73904r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f73905s;

    /* JADX INFO: renamed from: pl.droidsonroids.gif.GifDrawable$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass3 extends SafeRunnable {
        final /* synthetic */ int val$frameIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(GifDrawable gifDrawable, int i11) {
            super(gifDrawable);
            this.val$frameIndex = i11;
        }

        @Override // pl.droidsonroids.gif.SafeRunnable
        public void doWork() {
            GifDrawable gifDrawable = GifDrawable.this;
            gifDrawable.f73894h.z(this.val$frameIndex, gifDrawable.f73893g);
            GifDrawable.this.f73900n.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public GifDrawable(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.r(contentResolver, uri), null, null, true);
    }

    public GifDrawable(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(@NonNull Resources resources, int i11) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i11));
        float fB = d.b(resources, i11);
        this.f73905s = (int) (this.f73894h.g() * fB);
        this.f73904r = (int) (this.f73894h.n() * fB);
    }

    public GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z11) {
        this.f73889b = true;
        this.f73890c = Long.MIN_VALUE;
        this.f73891d = new Rect();
        this.f73892f = new Paint(6);
        this.f73895i = new ConcurrentLinkedQueue<>();
        RenderTask renderTask = new RenderTask(this);
        this.f73901o = renderTask;
        this.f73899m = z11;
        this.f73888a = scheduledThreadPoolExecutor == null ? c.a() : scheduledThreadPoolExecutor;
        this.f73894h = gifInfoHandle;
        Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.f73894h) {
                try {
                    if (!gifDrawable.f73894h.p() && gifDrawable.f73894h.g() >= gifInfoHandle.g() && gifDrawable.f73894h.n() >= gifInfoHandle.n()) {
                        gifDrawable.i();
                        bitmap = gifDrawable.f73893g;
                        bitmap.eraseColor(0);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (bitmap == null) {
            this.f73893g = Bitmap.createBitmap(gifInfoHandle.n(), gifInfoHandle.g(), Bitmap.Config.ARGB_8888);
        } else {
            this.f73893g = bitmap;
        }
        this.f73893g.setHasAlpha(!gifInfoHandle.o());
        this.f73902p = new Rect(0, 0, gifInfoHandle.n(), gifInfoHandle.g());
        this.f73900n = new f(this);
        renderTask.doWork();
        this.f73904r = gifInfoHandle.n();
        this.f73905s = gifInfoHandle.g();
    }

    public GifDrawable(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.f73903q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f73900n.removeMessages(-1);
    }

    public int b() {
        return this.f73894h.c();
    }

    public int c() {
        int iD = this.f73894h.d();
        return (iD == 0 || iD < this.f73894h.h()) ? iD : iD - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return d() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return d() > 1;
    }

    public int d() {
        return this.f73894h.l();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z11;
        if (this.f73897k == null || this.f73892f.getColorFilter() != null) {
            z11 = false;
        } else {
            this.f73892f.setColorFilter(this.f73897k);
            z11 = true;
        }
        canvas.drawBitmap(this.f73893g, this.f73902p, this.f73891d, this.f73892f);
        if (z11) {
            this.f73892f.setColorFilter(null);
        }
    }

    public boolean e() {
        return this.f73894h.p();
    }

    public void f() {
        this.f73888a.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.1
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                if (GifDrawable.this.f73894h.v()) {
                    GifDrawable.this.start();
                }
            }
        });
    }

    public final void g() {
        if (this.f73899m && this.f73889b) {
            long j11 = this.f73890c;
            if (j11 != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j11 - SystemClock.uptimeMillis());
                this.f73890c = Long.MIN_VALUE;
                this.f73888a.remove(this.f73901o);
                this.f73903q = this.f73888a.schedule(this.f73901o, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f73892f.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f73892f.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f73894h.e();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f73894h.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f73905s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f73904r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f73894h.o() || this.f73892f.getAlpha() < 255) ? -2 : -1;
    }

    public void h(int i11) {
        this.f73894h.B(i11);
    }

    public final void i() {
        this.f73889b = false;
        this.f73900n.removeMessages(-1);
        this.f73894h.t();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        g();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f73889b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f73889b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.f73896j) != null && colorStateList.isStateful());
    }

    public void j(long j11) {
        if (this.f73899m) {
            this.f73890c = 0L;
            this.f73900n.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.f73903q = this.f73888a.schedule(this.f73901o, Math.max(j11, 0L), TimeUnit.MILLISECONDS);
        }
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f73891d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f73896j;
        if (colorStateList == null || (mode = this.f73898l) == null) {
            return false;
        }
        this.f73897k = k(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(final int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f73888a.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.2
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                GifDrawable gifDrawable = GifDrawable.this;
                gifDrawable.f73894h.A(i11, gifDrawable.f73893g);
                this.mGifDrawable.f73900n.sendEmptyMessageAtTime(-1, 0L);
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f73892f.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f73892f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z11) {
        this.f73892f.setDither(z11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z11) {
        this.f73892f.setFilterBitmap(z11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f73896j = colorStateList;
        this.f73897k = k(colorStateList, this.f73898l);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f73898l = mode;
        this.f73897k = k(this.f73896j, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        if (!this.f73899m) {
            if (z11) {
                if (z12) {
                    f();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            try {
                if (this.f73889b) {
                    return;
                }
                this.f73889b = true;
                j(this.f73894h.w());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            try {
                if (this.f73889b) {
                    this.f73889b = false;
                    a();
                    this.f73894h.y();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f73894h.n()), Integer.valueOf(this.f73894h.g()), Integer.valueOf(this.f73894h.l()), Integer.valueOf(this.f73894h.j()));
    }
}
