package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CycleDetectingLockFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, b>> f39957a = new MapMaker().l().i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f39958b = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<b>> f39959c = new a();

    /* JADX INFO: compiled from: source.java */
    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), b.class.getName());

        public ExampleStackTrace(b bVar, b bVar2) {
            super(bVar.a() + " -> " + bVar2.a());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (c.class.getName().equals(stackTrace[i11].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i11].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i11, length));
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum Policies {
        THROW { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f39958b.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* synthetic */ Policies(a aVar) {
            this();
        }

        public abstract /* synthetic */ void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        private PotentialDeadlockException(b bVar, b bVar2, ExampleStackTrace exampleStackTrace) {
            super(bVar, bVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }

        public /* synthetic */ PotentialDeadlockException(b bVar, b bVar2, ExampleStackTrace exampleStackTrace, a aVar) {
            this(bVar, bVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb2 = new StringBuilder(super.getMessage());
            for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
                sb2.append(", ");
                sb2.append(cause.getMessage());
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends ThreadLocal<ArrayList<b>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<b> initialValue() {
            return Lists.k(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39960a;

        public String a() {
            return this.f39960a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<E extends Enum<E>> extends CycleDetectingLockFactory {
    }
}
