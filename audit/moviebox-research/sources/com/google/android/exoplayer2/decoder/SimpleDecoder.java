package com.google.android.exoplayer2.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.f;
import java.util.ArrayDeque;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends f, E extends DecoderException> implements d<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f33036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f33037b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<I> f33038c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<O> f33039d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final I[] f33040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O[] f33041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f33043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public I f33044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public E f33045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f33046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f33047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f33048m;

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.f33040e = iArr;
        this.f33042g = iArr.length;
        for (int i11 = 0; i11 < this.f33042g; i11++) {
            ((I[]) this.f33040e)[i11] = c();
        }
        this.f33041f = oArr;
        this.f33043h = oArr.length;
        for (int i12 = 0; i12 < this.f33043h; i12++) {
            ((O[]) this.f33041f)[i12] = d();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.p();
            }
        };
        this.f33036a = thread;
        thread.start();
    }

    public final boolean b() {
        return !this.f33038c.isEmpty() && this.f33043h > 0;
    }

    public abstract I c();

    public abstract O d();

    public abstract E e(Throwable th2);

    @Nullable
    public abstract E f(I i11, O o11, boolean z11);

    @Override // com.google.android.exoplayer2.decoder.d
    public final void flush() {
        synchronized (this.f33037b) {
            try {
                this.f33046k = true;
                this.f33048m = 0;
                I i11 = this.f33044i;
                if (i11 != null) {
                    m(i11);
                    this.f33044i = null;
                }
                while (!this.f33038c.isEmpty()) {
                    m(this.f33038c.removeFirst());
                }
                while (!this.f33039d.isEmpty()) {
                    this.f33039d.removeFirst().m();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean g() throws InterruptedException {
        E e11;
        synchronized (this.f33037b) {
            while (!this.f33047l && !b()) {
                try {
                    this.f33037b.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.f33047l) {
                return false;
            }
            I iRemoveFirst = this.f33038c.removeFirst();
            O[] oArr = this.f33041f;
            int i11 = this.f33043h - 1;
            this.f33043h = i11;
            O o11 = oArr[i11];
            boolean z11 = this.f33046k;
            this.f33046k = false;
            if (iRemoveFirst.i()) {
                o11.a(4);
            } else {
                if (iRemoveFirst.h()) {
                    o11.a(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.j()) {
                    o11.a(ASTNode.NOJIT);
                }
                try {
                    e11 = (E) f(iRemoveFirst, o11, z11);
                } catch (OutOfMemoryError e12) {
                    e11 = (E) e(e12);
                } catch (RuntimeException e13) {
                    e11 = (E) e(e13);
                }
                if (e11 != null) {
                    synchronized (this.f33037b) {
                        this.f33045j = e11;
                    }
                    return false;
                }
            }
            synchronized (this.f33037b) {
                try {
                    if (this.f33046k) {
                        o11.m();
                    } else if (o11.h()) {
                        this.f33048m++;
                        o11.m();
                    } else {
                        o11.f33075c = this.f33048m;
                        this.f33048m = 0;
                        this.f33039d.addLast(o11);
                    }
                    m(iRemoveFirst);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final I dequeueInputBuffer() throws DecoderException {
        I i11;
        synchronized (this.f33037b) {
            k();
            com.google.android.exoplayer2.util.a.g(this.f33044i == null);
            int i12 = this.f33042g;
            if (i12 == 0) {
                i11 = null;
            } else {
                I[] iArr = this.f33040e;
                int i13 = i12 - 1;
                this.f33042g = i13;
                i11 = iArr[i13];
            }
            this.f33044i = i11;
        }
        return i11;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.f33037b) {
            try {
                k();
                if (this.f33039d.isEmpty()) {
                    return null;
                }
                return this.f33039d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void j() {
        if (b()) {
            this.f33037b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    public final void k() throws E, DecoderException {
        E e11 = this.f33045j;
        if (e11 != null) {
            throw e11;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(I i11) throws DecoderException {
        synchronized (this.f33037b) {
            k();
            com.google.android.exoplayer2.util.a.a(i11 == this.f33044i);
            this.f33038c.addLast(i11);
            j();
            this.f33044i = null;
        }
    }

    public final void m(I i11) {
        i11.b();
        I[] iArr = this.f33040e;
        int i12 = this.f33042g;
        this.f33042g = i12 + 1;
        iArr[i12] = i11;
    }

    @CallSuper
    public void n(O o11) {
        synchronized (this.f33037b) {
            o(o11);
            j();
        }
    }

    public final void o(O o11) {
        o11.b();
        O[] oArr = this.f33041f;
        int i11 = this.f33043h;
        this.f33043h = i11 + 1;
        oArr[i11] = o11;
    }

    public final void p() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (g());
    }

    public final void q(int i11) {
        com.google.android.exoplayer2.util.a.g(this.f33042g == this.f33040e.length);
        for (I i12 : this.f33040e) {
            i12.n(i11);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @CallSuper
    public void release() {
        synchronized (this.f33037b) {
            this.f33047l = true;
            this.f33037b.notify();
        }
        try {
            this.f33036a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
