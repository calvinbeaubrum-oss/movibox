package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class RenderTask extends SafeRunnable {
    public RenderTask(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // pl.droidsonroids.gif.SafeRunnable
    public void doWork() {
        GifDrawable gifDrawable = this.mGifDrawable;
        long jU = gifDrawable.f73894h.u(gifDrawable.f73893g);
        if (jU >= 0) {
            this.mGifDrawable.f73890c = SystemClock.uptimeMillis() + jU;
            if (this.mGifDrawable.isVisible() && this.mGifDrawable.f73889b) {
                GifDrawable gifDrawable2 = this.mGifDrawable;
                if (!gifDrawable2.f73899m) {
                    gifDrawable2.f73888a.remove(this);
                    GifDrawable gifDrawable3 = this.mGifDrawable;
                    gifDrawable3.f73903q = gifDrawable3.f73888a.schedule(this, jU, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.mGifDrawable.f73895i.isEmpty() && this.mGifDrawable.b() == this.mGifDrawable.f73894h.l() - 1) {
                GifDrawable gifDrawable4 = this.mGifDrawable;
                gifDrawable4.f73900n.sendEmptyMessageAtTime(gifDrawable4.c(), this.mGifDrawable.f73890c);
            }
        } else {
            GifDrawable gifDrawable5 = this.mGifDrawable;
            gifDrawable5.f73890c = Long.MIN_VALUE;
            gifDrawable5.f73889b = false;
        }
        if (!this.mGifDrawable.isVisible() || this.mGifDrawable.f73900n.hasMessages(-1)) {
            return;
        }
        this.mGifDrawable.f73900n.sendEmptyMessageAtTime(-1, 0L);
    }
}
