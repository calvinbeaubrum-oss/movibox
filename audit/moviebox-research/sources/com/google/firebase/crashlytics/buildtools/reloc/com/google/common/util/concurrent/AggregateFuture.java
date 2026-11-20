package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t7;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.g<OutputT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f39955b = Logger.getLogger(AggregateFuture.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AggregateFuture<InputT, OutputT>.RunningState f39956a;

    /* JADX INFO: compiled from: source.java */
    public abstract class RunningState extends e implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends i0<? extends InputT>> futures;

        public RunningState(ImmutableCollection<? extends i0<? extends InputT>> immutableCollection, boolean z11, boolean z12) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(immutableCollection);
            this.allMustSucceed = z11;
            this.collectsValues = z12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            int iDecrementRemainingAndGet = decrementRemainingAndGet();
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(iDecrementRemainingAndGet >= 0, "Less than 0 remaining futures");
            if (iDecrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:13:0x002c  */
        /* JADX WARN: Code duplicated, block: B:14:0x002f  */
        /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
        private void handleException(Throwable th2) {
            boolean exception;
            boolean zE;
            boolean z11;
            String str;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(th2);
            if (this.allMustSucceed) {
                exception = AggregateFuture.this.setException(th2);
                if (exception) {
                    releaseResourcesAfterFailure();
                } else {
                    zE = AggregateFuture.e(getOrInitSeenExceptions(), th2);
                }
                z11 = th2 instanceof Error;
                if (((!exception) & this.allMustSucceed & zE) || z11) {
                    if (z11) {
                        str = "Input Future failed with Error";
                    } else {
                        str = "Got more than one input Future failure. Logging failures after the first";
                    }
                    AggregateFuture.f39955b.log(Level.SEVERE, str, th2);
                }
            }
            exception = false;
            zE = true;
            z11 = th2 instanceof Error;
            if (((!exception) & this.allMustSucceed & zE) || z11) {
                if (z11) {
                    str = "Input Future failed with Error";
                } else {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                AggregateFuture.f39955b.log(Level.SEVERE, str, th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleOneInputDone(int i11, Future<? extends InputT> future) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.f39956a = null;
                        AggregateFuture.this.cancel(false);
                    } else {
                        Object objD = Futures.d(future);
                        if (this.collectsValues) {
                            collectOneValue(this.allMustSucceed, i11, objD);
                        }
                    }
                } else if (this.collectsValues && !future.isCancelled()) {
                    collectOneValue(this.allMustSucceed, i11, Futures.d(future));
                }
            } catch (ExecutionException e11) {
                handleException(e11.getCause());
            } catch (Throwable th2) {
                handleException(th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
                return;
            }
            if (!this.allMustSucceed) {
                t7<? extends i0<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    it.next().addListener(this, MoreExecutors.a());
                }
                return;
            }
            t7<? extends i0<? extends InputT>> it2 = this.futures.iterator();
            final int i11 = 0;
            while (it2.hasNext()) {
                final i0<? extends InputT> next = it2.next();
                next.addListener(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AggregateFuture.RunningState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            RunningState.this.handleOneInputDone(i11, next);
                        } finally {
                            RunningState.this.decrementCountAndMaybeComplete();
                        }
                    }
                }, MoreExecutors.a());
                i11++;
            }
        }

        private void processCompleted() {
            if (this.collectsValues & (!this.allMustSucceed)) {
                t7<? extends i0<? extends InputT>> it = this.futures.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    handleOneInputDone(i11, it.next());
                    i11++;
                }
            }
            handleAllCompleted();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.e
        public final void addInitialException(Set<Throwable> set) {
            if (AggregateFuture.this.isCancelled()) {
                return;
            }
            AggregateFuture.e(set, AggregateFuture.this.trustedGetException());
        }

        public abstract void collectOneValue(boolean z11, int i11, InputT inputt);

        public abstract void handleAllCompleted();

        public void interruptTask() {
        }

        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }
    }

    public static boolean e(Set<Throwable> set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.f39956a;
        if (runningState != null) {
            this.f39956a = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).futures;
            boolean zWasInterrupted = wasInterrupted();
            if (zWasInterrupted) {
                runningState.interruptTask();
            }
            if (isCancelled() && (immutableCollection != null)) {
                t7 it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((i0) it.next()).cancel(zWasInterrupted);
                }
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.f39956a;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }
}
