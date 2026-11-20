package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface Service {

    /* JADX INFO: compiled from: source.java */
    public enum State {
        NEW { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STARTING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        RUNNING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STOPPING { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        TERMINATED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        },
        FAILED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State.6
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        };

        public abstract boolean isTerminal();
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public void a(State state, Throwable th2) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }
    }

    State a();
}
