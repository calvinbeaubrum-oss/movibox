package z;

import android.content.Context;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.c0;
import com.cloud.tmc.miniapp.prepare.steps.w;
import kotlin.jvm.internal.Intrinsics;
import p011Oooo00o.o00Ooo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StepType f81681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f81682b;

    /* JADX INFO: compiled from: source.java */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f81683a;

        static {
            int[] iArr = new int[StepType.values().length];
            try {
                iArr[StepType.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StepType.LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StepType.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f81683a = iArr;
        }
    }

    public g(StepType stepType) {
        Intrinsics.g(stepType, "stepType");
        this.f81681a = stepType;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public boolean OooO00o() {
        w wVar = this.f81682b;
        if (wVar != null) {
            return wVar.OooO00o();
        }
        return false;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        w wVar = this.f81682b;
        if (wVar != null) {
            wVar.a(prepareController, gVar, c0Var);
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public StepType b() {
        return this.f81681a;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public void c(PrepareController prepareController, lb.g gVar, c0 c0Var) {
        Context contextP;
        AppModel appModelE;
        if (gVar == null || (contextP = gVar.p()) == null || (appModelE = gVar.e()) == null || !o00Ooo.d(contextP, appModelE)) {
            d(true);
        } else {
            d(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(boolean z11) {
        if (this.f81682b != null) {
            return;
        }
        int i11 = a.f81683a[this.f81681a.ordinal()];
        int i12 = 3;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (i11 == 1) {
            this.f81682b = z11 ? new f(objArr2 == true ? 1 : 0, objArr == true ? 1 : 0, i12) : new u.a();
        } else if (i11 == 2) {
            this.f81682b = z11 ? new d(null, null, 3) : new u.d();
        } else {
            if (i11 != 3) {
                return;
            }
            this.f81682b = z11 ? new h(str, objArr3 == true ? 1 : 0, i12) : new u.e();
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public void finish() {
        w wVar = this.f81682b;
        if (wVar != null) {
            wVar.finish();
        }
    }
}
