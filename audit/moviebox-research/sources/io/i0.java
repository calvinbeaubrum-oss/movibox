package io;

import java.lang.ref.Cleaner;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i0 extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cleaner f67299b;

    public i0() {
        super(0);
        this.f67299b = Cleaner.create();
    }

    @Override // io.e
    public final Runnable a(Object obj, Runnable runnable) {
        final Cleaner.Cleanable cleanableRegister = this.f67299b.register(obj, runnable);
        Objects.requireNonNull(cleanableRegister);
        return new Runnable() { // from class: io.h0
            @Override // java.lang.Runnable
            public final void run() {
                cleanableRegister.clean();
            }
        };
    }
}
