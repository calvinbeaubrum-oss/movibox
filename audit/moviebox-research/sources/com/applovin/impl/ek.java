package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ek extends bk implements ol {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f18750n;

    public ek(String str) {
        super(new rl[2], new sl[2]);
        this.f18750n = str;
        a(1024);
    }

    public abstract nl a(byte[] bArr, int i11, boolean z11);

    @Override // com.applovin.impl.bk
    public final pl a(rl rlVar, sl slVar, boolean z11) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) b1.a(rlVar.f21655c);
            slVar.a(rlVar.f21657f, a(byteBuffer.array(), byteBuffer.limit(), z11), rlVar.f22145j);
            slVar.c(Integer.MIN_VALUE);
            return null;
        } catch (pl e11) {
            return e11;
        }
    }

    @Override // com.applovin.impl.ol
    public void a(long j11) {
    }

    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final pl a(Throwable th2) {
        return new pl("Unexpected decode error", th2);
    }

    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final rl f() {
        return new rl();
    }

    @Override // com.applovin.impl.bk
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final sl g() {
        return new fk(new zg.a() { // from class: com.applovin.impl.kv
            @Override // com.applovin.impl.zg.a
            public final void a(zg zgVar) {
                this.f20283a.a(zgVar);
            }
        });
    }
}
