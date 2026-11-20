package com.cloud.tmc.miniapp.prepare.controller;

import com.cloud.tmc.miniapp.prepare.steps.UpdateStep;
import com.cloud.tmc.miniapp.prepare.steps.c;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.m;
import com.cloud.tmc.miniapp.prepare.steps.p;
import com.cloud.tmc.miniapp.prepare.steps.q;
import com.cloud.tmc.miniapp.prepare.steps.s;
import com.cloud.tmc.miniapp.prepare.steps.y;
import com.cloud.tmc.miniapp.prepare.steps.z;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import lb.g;
import z.d;
import z.f;
import z.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends BasePrepareController {
    public a(g gVar, c0 c0Var, int i11, String str) {
        int i12 = 2;
        if (i11 != 1) {
            Integer num = null;
            if (i11 == 2) {
                ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4);
                this.steps = arrayBlockingQueue;
                arrayBlockingQueue.add(new f(str, num, i12));
                this.steps.add(new d(str, null, 2));
                this.steps.add(new s());
                this.steps.add(new h(str, num, i12));
            } else if (i11 != 3) {
                ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(12);
                this.steps = arrayBlockingQueue2;
                arrayBlockingQueue2.add(new y());
                this.steps.add(new c());
                this.steps.add(new UpdateStep());
                this.steps.add(new z());
                this.steps.add(new m());
                this.steps.add(new com.cloud.tmc.miniapp.prepare.steps.h());
                this.steps.add(new p());
                this.steps.add(new q());
                this.steps.add(new f(str, num, i12));
                this.steps.add(new d(str, null, 2));
                this.steps.add(new s());
                this.steps.add(new h(str, num, i12));
            } else {
                ArrayBlockingQueue arrayBlockingQueue3 = new ArrayBlockingQueue(3);
                this.steps = arrayBlockingQueue3;
                arrayBlockingQueue3.add(new f(str, 3));
                this.steps.add(new d(str, 3));
                this.steps.add(new s());
            }
        } else {
            ArrayBlockingQueue arrayBlockingQueue4 = new ArrayBlockingQueue(4);
            this.steps = arrayBlockingQueue4;
            arrayBlockingQueue4.add(new f(str, 2));
            this.steps.add(new d(str, 2));
            this.steps.add(new s());
            this.steps.add(new h(str, 2));
        }
        bindContext(gVar, c0Var);
        setInterceptors(new ArrayList());
    }
}
