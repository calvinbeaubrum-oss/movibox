package com.mbridge.msdk.newreward.function.f;

import com.mbridge.msdk.newreward.a.b.f;
import com.mbridge.msdk.newreward.a.b.g;
import com.mbridge.msdk.newreward.a.b.h;
import com.mbridge.msdk.newreward.a.b.i;
import com.mbridge.msdk.newreward.a.b.j;
import com.mbridge.msdk.newreward.a.b.m;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f46475a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f46476b = false;

    /* JADX INFO: compiled from: source.java */
    public static class a implements com.mbridge.msdk.newreward.a.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.d.a.b f46477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f46478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.b.b f46479c;

        public a(com.mbridge.msdk.newreward.function.d.a.b bVar, d dVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f46477a = bVar;
            this.f46478b = dVar;
            this.f46479c = bVar2;
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.function.d.a.b bVar2 = this.f46477a;
            com.mbridge.msdk.newreward.a.b.b bVar3 = this.f46479c;
            if (d.a(this.f46478b)) {
                if (!bVar2.x()) {
                    this.f46478b.f46476b = true;
                    bVar3.a(bVar);
                } else {
                    this.f46478b.f46475a = true;
                    com.mbridge.msdk.newreward.function.e.c.a().b().a(bVar2.a(), bVar2.b(), bVar2.c(), bVar2.e(), 3);
                    bVar3.a(bVar2);
                }
            }
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(Object obj) {
            com.mbridge.msdk.newreward.function.d.a.b bVar = this.f46477a;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46479c;
            if (d.a(this.f46478b) && bVar.x()) {
                this.f46478b.f46475a = true;
                com.mbridge.msdk.newreward.function.e.c.a().b().a(bVar.a(), bVar.b(), bVar.c(), bVar.e(), 3);
                bVar2.a(bVar);
            }
        }
    }

    public static /* synthetic */ boolean a(d dVar) {
        return (dVar.f46475a || dVar.f46476b) ? false : true;
    }

    public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        this.f46475a = false;
        this.f46476b = false;
        a aVar = new a(bVar, this, bVar2);
        try {
            new com.mbridge.msdk.newreward.a.b.d().a(bVar, aVar);
        } catch (IOException e11) {
            aVar.a(new com.mbridge.msdk.foundation.c.b(880020, e11.getMessage()));
        }
        for (com.mbridge.msdk.newreward.function.d.a.a aVar2 : bVar.s()) {
            a aVar3 = new a(bVar, this, bVar2);
            try {
                new m().a(aVar2, aVar3);
            } catch (IOException e12) {
                aVar3.a(new com.mbridge.msdk.foundation.c.b(880020, e12.getMessage()));
            }
            a aVar4 = new a(bVar, this, bVar2);
            try {
                new com.mbridge.msdk.newreward.a.b.e().a(aVar2, aVar4);
            } catch (IOException e13) {
                aVar4.a(new com.mbridge.msdk.foundation.c.b(880020, e13.getMessage()));
            }
            a aVar5 = new a(bVar, this, bVar2);
            try {
                new f().a(aVar2, aVar5);
            } catch (IOException e14) {
                aVar5.a(new com.mbridge.msdk.foundation.c.b(880020, e14.getMessage()));
            }
            a aVar6 = new a(bVar, this, bVar2);
            try {
                new h().a(aVar2, aVar6);
            } catch (IOException e15) {
                aVar6.a(new com.mbridge.msdk.foundation.c.b(880020, e15.getMessage()));
            }
            a aVar7 = new a(bVar, this, bVar2);
            try {
                new i().a(aVar2, aVar7);
            } catch (IOException e16) {
                aVar7.a(new com.mbridge.msdk.foundation.c.b(880000, e16.getMessage()));
            }
            a aVar8 = new a(bVar, this, bVar2);
            try {
                new g().a(aVar2, aVar8);
            } catch (IOException e17) {
                aVar8.a(new com.mbridge.msdk.foundation.c.b(880000, e17.getMessage()));
            }
            a aVar9 = new a(bVar, this, bVar2);
            try {
                new j().a(aVar2, aVar9);
            } catch (IOException e18) {
                aVar9.a(new com.mbridge.msdk.foundation.c.b(880000, e18.getMessage()));
            }
        }
    }
}
