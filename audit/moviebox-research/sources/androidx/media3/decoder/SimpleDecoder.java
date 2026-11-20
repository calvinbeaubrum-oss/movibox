package androidx.media3.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.h;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayDeque;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends h, E extends DecoderException> implements g<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f9786a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final I[] f9790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O[] f9791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public I f9794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public E f9795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9798m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9787b = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f9799n = C.TIME_UNSET;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<I> f9788c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<O> f9789d = new ArrayDeque<>();

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.f9790e = iArr;
        this.f9792g = iArr.length;
        for (int i11 = 0; i11 < this.f9792g; i11++) {
            ((I[]) this.f9790e)[i11] = e();
        }
        this.f9791f = oArr;
        this.f9793h = oArr.length;
        for (int i12 = 0; i12 < this.f9793h; i12++) {
            ((O[]) this.f9791f)[i12] = f();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.r();
            }
        };
        this.f9786a = thread;
        thread.start();
    }

    @Override // androidx.media3.decoder.g
    public final void a(long j11) {
        synchronized (this.f9787b) {
            try {
                z3.a.g(this.f9792g == this.f9790e.length || this.f9796k);
                this.f9799n = j11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.media3.decoder.g
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(I i11) throws DecoderException {
        synchronized (this.f9787b) {
            n();
            z3.a.a(i11 == this.f9794i);
            this.f9788c.addLast(i11);
            m();
            this.f9794i = null;
        }
    }

    public final boolean d() {
        return !this.f9788c.isEmpty() && this.f9793h > 0;
    }

    public abstract I e();

    public abstract O f();

    @Override // androidx.media3.decoder.g
    public final void flush() {
        synchronized (this.f9787b) {
            try {
                this.f9796k = true;
                this.f9798m = 0;
                I i11 = this.f9794i;
                if (i11 != null) {
                    o(i11);
                    this.f9794i = null;
                }
                while (!this.f9788c.isEmpty()) {
                    o(this.f9788c.removeFirst());
                }
                while (!this.f9789d.isEmpty()) {
                    this.f9789d.removeFirst().release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract E g(Throwable th2);

    @Nullable
    public abstract E h(I i11, O o11, boolean z11);

    public final boolean i() throws InterruptedException {
        E e11;
        synchronized (this.f9787b) {
            while (!this.f9797l && !d()) {
                try {
                    this.f9787b.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.f9797l) {
                return false;
            }
            I iRemoveFirst = this.f9788c.removeFirst();
            O[] oArr = this.f9791f;
            int i11 = this.f9793h - 1;
            this.f9793h = i11;
            O o11 = oArr[i11];
            boolean z11 = this.f9796k;
            this.f9796k = false;
            if (iRemoveFirst.isEndOfStream()) {
                o11.addFlag(4);
            } else {
                long j11 = iRemoveFirst.f9782f;
                o11.timeUs = j11;
                if (!l(j11) || iRemoveFirst.isDecodeOnly()) {
                    o11.addFlag(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.isFirstSample()) {
                    o11.addFlag(ASTNode.NOJIT);
                }
                try {
                    e11 = (E) h(iRemoveFirst, o11, z11);
                } catch (OutOfMemoryError e12) {
                    e11 = (E) g(e12);
                } catch (RuntimeException e13) {
                    e11 = (E) g(e13);
                }
                if (e11 != null) {
                    synchronized (this.f9787b) {
                        this.f9795j = e11;
                    }
                    return false;
                }
            }
            synchronized (this.f9787b) {
                try {
                    if (this.f9796k) {
                        o11.release();
                    } else if ((!o11.isEndOfStream() && !l(o11.timeUs)) || o11.isDecodeOnly() || o11.shouldBeSkipped) {
                        this.f9798m++;
                        o11.release();
                    } else {
                        o11.skippedOutputBufferCount = this.f9798m;
                        this.f9798m = 0;
                        this.f9789d.addLast(o11);
                    }
                    o(iRemoveFirst);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return true;
        }
    }

    @Override // androidx.media3.decoder.g
    @Nullable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final I dequeueInputBuffer() throws DecoderException {
        I i11;
        synchronized (this.f9787b) {
            n();
            z3.a.g(this.f9794i == null);
            int i12 = this.f9792g;
            if (i12 == 0) {
                i11 = null;
            } else {
                I[] iArr = this.f9790e;
                int i13 = i12 - 1;
                this.f9792g = i13;
                i11 = iArr[i13];
            }
            this.f9794i = i11;
        }
        return i11;
    }

    @Override // androidx.media3.decoder.g
    @Nullable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.f9787b) {
            try {
                n();
                if (this.f9789d.isEmpty()) {
                    return null;
                }
                return this.f9789d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean l(long j11) {
        boolean z11;
        synchronized (this.f9787b) {
            long j12 = this.f9799n;
            z11 = j12 == C.TIME_UNSET || j11 >= j12;
        }
        return z11;
    }

    public final void m() {
        if (d()) {
            this.f9787b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends androidx.media3.decoder.DecoderException */
    public final void n() throws E, DecoderException {
        E e11 = this.f9795j;
        if (e11 != null) {
            throw e11;
        }
    }

    public final void o(I i11) {
        i11.clear();
        I[] iArr = this.f9790e;
        int i12 = this.f9792g;
        this.f9792g = i12 + 1;
        iArr[i12] = i11;
    }

    @CallSuper
    public void p(O o11) {
        synchronized (this.f9787b) {
            q(o11);
            m();
        }
    }

    public final void q(O o11) {
        o11.clear();
        O[] oArr = this.f9791f;
        int i11 = this.f9793h;
        this.f9793h = i11 + 1;
        oArr[i11] = o11;
    }

    public final void r() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (i());
    }

    @Override // androidx.media3.decoder.g
    @CallSuper
    public void release() {
        synchronized (this.f9787b) {
            this.f9797l = true;
            this.f9787b.notify();
        }
        try {
            this.f9786a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void s(int i11) {
        z3.a.g(this.f9792g == this.f9790e.length);
        for (I i12 : this.f9790e) {
            i12.b(i11);
        }
    }
}
