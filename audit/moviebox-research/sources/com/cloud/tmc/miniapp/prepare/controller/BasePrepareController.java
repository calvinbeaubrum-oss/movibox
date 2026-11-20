package com.cloud.tmc.miniapp.prepare.controller;

import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.controller.OooO0O0.OooO0OO;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.UpdateStep;
import com.cloud.tmc.miniapp.prepare.steps.c;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.e0;
import com.cloud.tmc.miniapp.prepare.steps.h;
import com.cloud.tmc.miniapp.prepare.steps.m;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.prepare.steps.p;
import com.cloud.tmc.miniapp.prepare.steps.q;
import com.cloud.tmc.miniapp.prepare.steps.s;
import com.cloud.tmc.miniapp.prepare.steps.w;
import com.cloud.tmc.miniapp.prepare.steps.y;
import com.cloud.tmc.miniapp.prepare.steps.z;
import hd.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import lb.g;
import y.b;
import y.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public abstract class BasePrepareController implements PrepareController, OooO0O0.b {
    private static final String TAG = "Tmcresource:PrepareController";
    public w currentExecutingStep;
    private w pendingAfterStep;
    public Queue<w> steps;
    private Set<w> interceptedBeforeSteps = new HashSet();
    private PrepareController.Status status = PrepareController.Status.INIT;
    private boolean locked = false;
    private Object lockedKey = null;
    public List<e0> interceptors = Collections.EMPTY_LIST;
    public g context = null;
    public c0 callback = null;
    public boolean errorIntercepted = false;
    public OooO0O0 timer = null;

    public BasePrepareController() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(15);
        this.steps = arrayBlockingQueue;
        arrayBlockingQueue.add(new y());
        this.steps.add(new c());
        this.steps.add(new UpdateStep());
        this.steps.add(new z());
        this.steps.add(new m());
        this.steps.add(new h());
        this.steps.add(new p());
        this.steps.add(new q());
        this.steps.add(o000oOoO.b());
        this.steps.add(o000oOoO.a());
        this.steps.add(new y.c());
        this.steps.add(new b());
        this.steps.add(new f());
        this.steps.add(new s());
        this.steps.add(o000oOoO.c());
    }

    public BasePrepareController(w... wVarArr) {
        this.steps = new LinkedList(Arrays.asList(wVarArr));
    }

    private boolean interceptAfter(w wVar) {
        try {
            TmcLogger.c(TAG, "step " + wVar.b() + " interceptAfter");
            for (e0 e0Var : this.interceptors) {
                if (e0Var.c(wVar, this)) {
                    TmcLogger.c(TAG, "step " + wVar.b() + " intercepted after by " + e0Var.getClass().getName());
                    return true;
                }
            }
            return false;
        } finally {
            wVar.finish();
        }
    }

    private boolean interceptBefore(w wVar) {
        StringBuilder sbA = j.a("step ");
        sbA.append(wVar.b());
        sbA.append(" interceptBefore");
        TmcLogger.c(TAG, sbA.toString());
        this.interceptedBeforeSteps.add(wVar);
        for (e0 e0Var : this.interceptors) {
            if (e0Var.d(wVar, this)) {
                StringBuilder sbA2 = j.a("step ");
                sbA2.append(wVar.b());
                sbA2.append(" intercepted before by ");
                sbA2.append(e0Var.getClass().getName());
                TmcLogger.c(TAG, sbA2.toString());
                return true;
            }
        }
        return false;
    }

    private boolean interceptOnError(PrepareException prepareException) {
        Iterator<e0> it = this.interceptors.iterator();
        while (it.hasNext()) {
            if (it.next().a(prepareException, this)) {
                return true;
            }
        }
        return false;
    }

    public void bindContext(g gVar, c0 c0Var) {
        this.context = gVar;
        this.callback = c0Var;
    }

    public OooO0O0 createTimer(OooO0O0.b bVar) {
        return new OooO0O0(bVar, new OooO0O0.a());
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    @CallSuper
    public void finish() {
        OooO0O0.OooO0OO oooO0OO;
        TmcLogger.c(TAG, "finish");
        this.status = PrepareController.Status.FINISH;
        OooO0O0 oooO0O0 = this.timer;
        if (oooO0O0 != null && (oooO0OO = oooO0O0.f31566c) != null) {
            oooO0OO.OooO0O0 = true;
            ((OooO0O0.a) oooO0O0.f31565b).f31567a.removeCallbacks(oooO0O0.f31566c);
        }
        c0 c0Var = this.callback;
        if (c0Var != null) {
            c0Var.OooO00o();
        }
        this.steps.clear();
    }

    public PrepareController.Status getStatus() {
        return this.status;
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void lock(Object obj) {
        TmcLogger.c(TAG, "locked with key: " + obj);
        this.lockedKey = obj;
        this.locked = true;
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    @CallSuper
    public void moveToError(PrepareException prepareException) {
        OooO0O0.OooO0OO oooO0OO;
        if (!this.status.canContinue()) {
            this.errorIntercepted = true;
            return;
        }
        TmcLogger.g(TAG, "moveToError!", prepareException);
        unlock(this.lockedKey);
        this.errorIntercepted = false;
        if (interceptOnError(prepareException)) {
            this.errorIntercepted = true;
            return;
        }
        c0 c0Var = this.callback;
        if (c0Var != null) {
            g gVar = this.context;
            c0Var.f(gVar == null ? null : gVar.m(), prepareException);
        }
        this.locked = false;
        this.status = PrepareController.Status.ERROR;
        this.steps.clear();
        OooO0O0 oooO0O0 = this.timer;
        if (oooO0O0 == null || (oooO0OO = oooO0O0.f31566c) == null) {
            return;
        }
        oooO0OO.OooO0O0 = true;
        ((OooO0O0.a) oooO0O0.f31565b).f31567a.removeCallbacks(oooO0O0.f31566c);
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void moveToNext() {
        if (this.locked) {
            StringBuilder sbA = j.a("controller locked by ");
            sbA.append(this.currentExecutingStep);
            sbA.append(" cannot moveToNext!");
            TmcLogger.f(TAG, sbA.toString());
            return;
        }
        if (!this.status.canContinue()) {
            StringBuilder sbA2 = j.a("controller cannot moveToNext with status: ");
            sbA2.append(this.status);
            TmcLogger.f(TAG, sbA2.toString());
            return;
        }
        this.status = PrepareController.Status.EXECUTING;
        w wVar = this.pendingAfterStep;
        if (wVar != null) {
            boolean zInterceptAfter = interceptAfter(wVar);
            this.pendingAfterStep = null;
            if (zInterceptAfter) {
                return;
            }
        }
        w wVarPeek = this.steps.peek();
        if (wVarPeek == null) {
            finish();
            return;
        }
        wVarPeek.c(this, this.context, this.callback);
        this.currentExecutingStep = wVarPeek;
        if (this.interceptedBeforeSteps.contains(wVarPeek) || !interceptBefore(wVarPeek)) {
            try {
                this.steps.poll();
                TmcLogger.c(TAG, "step " + wVarPeek.b() + " execute");
                this.pendingAfterStep = wVarPeek;
                wVarPeek.a(this, this.context, this.callback);
                if (this.locked || wVarPeek.OooO00o()) {
                    return;
                }
                if (this.status.canContinue()) {
                    this.pendingAfterStep = null;
                    if (interceptAfter(wVarPeek)) {
                        return;
                    }
                    moveToNext();
                    return;
                }
                StringBuilder sbA3 = j.a("step ");
                sbA3.append(wVarPeek.b());
                sbA3.append(" can't continue after execute. status: ");
                sbA3.append(this.status);
                TmcLogger.o(TAG, sbA3.toString());
            } catch (PrepareException e11) {
                TmcLogger.g(TAG, wVarPeek.b() + " execute error!", e11);
                moveToError(e11);
            }
        }
    }

    public void onGetAppInfo(@NonNull AppModel appModel) {
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.OooO0O0.b
    public void onTimeout(long j11) {
        moveToError(new PrepareException("3", "ERROR_TIMEOUT with elapsed: " + j11));
    }

    public void postTimeOut(long j11) {
        long jCurrentTimeMillis;
        if (this.timer == null) {
            this.timer = createTimer(this);
        }
        TmcLogger.c(TAG, "postTimeout " + j11);
        OooO0O0 oooO0O0 = this.timer;
        OooO0O0.OooO0OO oooO0OO = oooO0O0.f31566c;
        if (oooO0OO != null) {
            oooO0OO.OooO0O0 = true;
            OooO0O0.OooO0OO oooO0OO2 = oooO0O0.f31566c;
            jCurrentTimeMillis = oooO0OO2.OooO00o;
            ((OooO0O0.a) oooO0O0.f31565b).f31567a.removeCallbacks(oooO0OO2);
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        OooO0O0.OooO0OO oooO0OO3 = oooO0O0.new OooO0OO(jCurrentTimeMillis);
        oooO0O0.f31566c = oooO0OO3;
        ((OooO0O0.a) oooO0O0.f31565b).f31567a.postDelayed(oooO0OO3, j11);
    }

    public void setInterceptors(@NonNull List<e0> list) {
        if (this.status != PrepareController.Status.INIT) {
            throw new IllegalStateException("You cannot set interceptor after execute");
        }
        ArrayList arrayList = new ArrayList(list);
        this.interceptors = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((e0) it.next()).b(this.context, this.callback);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void start() {
        moveToNext();
    }

    @Override // com.cloud.tmc.miniapp.prepare.controller.PrepareController
    public void unlock(Object obj) {
        if (this.locked) {
            TmcLogger.c(TAG, "unlocked with key: " + obj + ", lockedKey: " + this.lockedKey);
            if (obj != this.lockedKey) {
                return;
            }
            this.locked = false;
            this.lockedKey = null;
        }
    }
}
