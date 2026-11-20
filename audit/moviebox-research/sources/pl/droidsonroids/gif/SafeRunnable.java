package pl.droidsonroids.gif;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
abstract class SafeRunnable implements Runnable {
    final GifDrawable mGifDrawable;

    public SafeRunnable(GifDrawable gifDrawable) {
        this.mGifDrawable = gifDrawable;
    }

    public abstract void doWork();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mGifDrawable.e()) {
                return;
            }
            doWork();
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
            }
            throw th2;
        }
    }
}
