package com.bytedance.sdk.openadsdk.core.Ql.We;

import com.bykv.vk.openvk.sc.sc.pFF.We.We;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends We {
    private final sc We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<pFF> f28128sc = Collections.synchronizedList(new ArrayList());
    private int pFF = 1;
    private int zY = 1;

    /* JADX INFO: compiled from: source.java */
    public interface pFF extends b.a {
        @Override // q8.b.a
        /* synthetic */ void ExN(b bVar);

        @Override // q8.b.a
        /* synthetic */ void We(b bVar);

        @Override // q8.b.a
        /* synthetic */ void pFF(b bVar);

        @Override // q8.b.a
        /* synthetic */ void pFF(b bVar, int i11);

        void sc(int i11, int i12);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, int i11);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, int i11, int i12);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, int i11, int i12, int i13);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, long j11);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, long j11, long j12);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, x8.b bVar2);

        @Override // q8.b.a
        /* synthetic */ void sc(b bVar, boolean z11);

        @Override // q8.b.a
        /* synthetic */ void zY(b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    public class sc implements b.a {
        private sc() {
        }

        @Override // q8.b.a
        public void ExN(b bVar) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).ExN(bVar);
            }
        }

        @Override // q8.b.a
        public void We(b bVar) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).We(bVar);
            }
        }

        @Override // q8.b.a
        public void pFF(b bVar) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).pFF(bVar);
            }
        }

        @Override // q8.b.a
        public void pFF(b bVar, int i11) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).pFF(bVar, i11);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar) {
            zY.sc(zY.this);
            if (zY.this.zY > zY.this.pFF) {
                Iterator it = zY.this.f28128sc.iterator();
                while (it.hasNext()) {
                    ((pFF) it.next()).sc(bVar);
                }
            } else {
                Iterator it2 = zY.this.f28128sc.iterator();
                while (it2.hasNext()) {
                    ((pFF) it2.next()).sc(zY.this.zY, zY.this.pFF);
                }
                zY.this.Ol();
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, int i11) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, i11);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, int i11, int i12) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, i11, i12);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, int i11, int i12, int i13) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, i11, i12, i13);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, long j11) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, j11);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, long j11, long j12) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, j11, j12);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, x8.b bVar2) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, bVar2);
            }
        }

        @Override // q8.b.a
        public void sc(b bVar, boolean z11) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).sc(bVar, z11);
            }
        }

        @Override // q8.b.a
        public void zY(b bVar) {
            Iterator it = zY.this.f28128sc.iterator();
            while (it.hasNext()) {
                ((pFF) it.next()).zY(bVar);
            }
        }
    }

    public zY() {
        sc scVar = new sc();
        this.We = scVar;
        super.sc(scVar);
        sc(500);
    }

    public static /* synthetic */ int sc(zY zYVar) {
        int i11 = zYVar.zY;
        zYVar.zY = i11 + 1;
        return i11;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.We
    public long Xc() {
        return super.Xc() + (((long) (this.zY - 1)) * super.dE());
    }

    public int YIK() {
        return this.zY;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.We
    public long dE() {
        return super.dE() * ((long) this.pFF);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.We
    public void sc(b.a aVar) {
        if (!(aVar instanceof pFF)) {
            super.sc(aVar);
        } else {
            if (this.f28128sc.contains(aVar)) {
                return;
            }
            this.f28128sc.add((pFF) aVar);
        }
    }

    public void zY(int i11) {
        this.pFF = Math.max(1, i11);
    }
}
