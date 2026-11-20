package com.transsion.transfer.androidasync.future;

import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Continuation extends n implements fy.c, Runnable, com.transsion.transfer.androidasync.future.a {
    fy.a callback;
    Runnable cancelCallback;
    private boolean inNext;
    LinkedList<fy.c> mCallbacks;
    boolean started;
    private boolean waiting;

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f58522a;

        public a() {
        }

        @Override // fy.a
        public void i(Exception exc) {
            if (this.f58522a) {
                return;
            }
            this.f58522a = true;
            Continuation.this.waiting = false;
            if (exc == null) {
                Continuation.this.next();
            } else {
                Continuation.this.reportCompleted(exc);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f58524a;

        public b(c cVar) {
            this.f58524a = cVar;
        }

        @Override // fy.c
        public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
            this.f58524a.get();
            aVar.i(null);
        }
    }

    public Continuation() {
        this(null);
    }

    public Continuation(fy.a aVar) {
        this(aVar, null);
    }

    public Continuation(fy.a aVar, Runnable runnable) {
        this.mCallbacks = new LinkedList<>();
        this.cancelCallback = runnable;
        this.callback = aVar;
    }

    private fy.c hook(fy.c cVar) {
        if (cVar instanceof com.transsion.transfer.androidasync.future.b) {
            ((com.transsion.transfer.androidasync.future.b) cVar).setParent(this);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.inNext) {
            return;
        }
        while (this.mCallbacks.size() > 0 && !this.waiting && !isDone() && !isCancelled()) {
            fy.c cVarRemove = this.mCallbacks.remove();
            try {
                try {
                    this.inNext = true;
                    this.waiting = true;
                    cVarRemove.onContinue(this, wrap());
                } catch (Exception e11) {
                    reportCompleted(e11);
                }
                this.inNext = false;
            } catch (Throwable th2) {
                this.inNext = false;
                throw th2;
            }
        }
        if (this.waiting || isDone() || isCancelled()) {
            return;
        }
        reportCompleted(null);
    }

    private fy.a wrap() {
        return new a();
    }

    public Continuation add(c cVar) {
        cVar.setParent(this);
        add(new b(cVar));
        return this;
    }

    public Continuation add(fy.c cVar) {
        this.mCallbacks.add(hook(cVar));
        return this;
    }

    @Override // com.transsion.transfer.androidasync.future.n, com.transsion.transfer.androidasync.future.a
    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.cancelCallback;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public fy.a getCallback() {
        return this.callback;
    }

    public Runnable getCancelCallback() {
        return this.cancelCallback;
    }

    public Continuation insert(fy.c cVar) {
        this.mCallbacks.add(0, hook(cVar));
        return this;
    }

    @Override // fy.c
    public void onContinue(Continuation continuation, fy.a aVar) throws Exception {
        setCallback(aVar);
        start();
    }

    public void reportCompleted(Exception exc) {
        fy.a aVar;
        if (setComplete() && (aVar = this.callback) != null) {
            aVar.i(exc);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        start();
    }

    public void setCallback(fy.a aVar) {
        this.callback = aVar;
    }

    public void setCancelCallback(final com.transsion.transfer.androidasync.future.a aVar) {
        if (aVar == null) {
            this.cancelCallback = null;
        } else {
            this.cancelCallback = new Runnable() { // from class: com.transsion.transfer.androidasync.future.Continuation.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.cancel();
                }
            };
        }
    }

    public void setCancelCallback(Runnable runnable) {
        this.cancelCallback = runnable;
    }

    public Continuation start() {
        if (this.started) {
            throw new IllegalStateException("already started");
        }
        this.started = true;
        next();
        return this;
    }
}
