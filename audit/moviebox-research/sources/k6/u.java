package k6;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends j {
    public int P;
    public ArrayList<j> N = new ArrayList<>();
    public boolean O = true;
    public boolean Q = false;
    public int R = 0;

    /* JADX INFO: compiled from: source.java */
    public class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f68412a;

        public a(j jVar) {
            this.f68412a = jVar;
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            this.f68412a.Z();
            jVar.V(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u f68414a;

        public b(u uVar) {
            this.f68414a = uVar;
        }

        @Override // k6.r, k6.j.f
        public void b(@NonNull j jVar) {
            u uVar = this.f68414a;
            if (uVar.Q) {
                return;
            }
            uVar.g0();
            this.f68414a.Q = true;
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            u uVar = this.f68414a;
            int i11 = uVar.P - 1;
            uVar.P = i11;
            if (i11 == 0) {
                uVar.Q = false;
                uVar.q();
            }
            jVar.V(this);
        }
    }

    @Override // k6.j
    public void T(@Nullable View view) {
        super.T(view);
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).T(view);
        }
    }

    @Override // k6.j
    public void X(@Nullable View view) {
        super.X(view);
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).X(view);
        }
    }

    @Override // k6.j
    public void Z() {
        if (this.N.isEmpty()) {
            g0();
            q();
            return;
        }
        u0();
        if (this.O) {
            Iterator<j> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().Z();
            }
            return;
        }
        for (int i11 = 1; i11 < this.N.size(); i11++) {
            this.N.get(i11 - 1).a(new a(this.N.get(i11)));
        }
        j jVar = this.N.get(0);
        if (jVar != null) {
            jVar.Z();
        }
    }

    @Override // k6.j
    public void b0(@Nullable j.e eVar) {
        super.b0(eVar);
        this.R |= 8;
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).b0(eVar);
        }
    }

    @Override // k6.j
    public void cancel() {
        super.cancel();
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).cancel();
        }
    }

    @Override // k6.j
    public void d0(@Nullable g gVar) {
        super.d0(gVar);
        this.R |= 4;
        if (this.N != null) {
            for (int i11 = 0; i11 < this.N.size(); i11++) {
                this.N.get(i11).d0(gVar);
            }
        }
    }

    @Override // k6.j
    public void e0(@Nullable t tVar) {
        super.e0(tVar);
        this.R |= 2;
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).e0(tVar);
        }
    }

    @Override // k6.j
    public void g(@NonNull w wVar) {
        if (K(wVar.f68417b)) {
            for (j jVar : this.N) {
                if (jVar.K(wVar.f68417b)) {
                    jVar.g(wVar);
                    wVar.f68418c.add(jVar);
                }
            }
        }
    }

    @Override // k6.j
    public String h0(String str) {
        String strH0 = super.h0(str);
        for (int i11 = 0; i11 < this.N.size(); i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strH0);
            sb2.append("\n");
            sb2.append(this.N.get(i11).h0(str + "  "));
            strH0 = sb2.toString();
        }
        return strH0;
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public u a(@NonNull j.f fVar) {
        return (u) super.a(fVar);
    }

    @Override // k6.j
    public void j(w wVar) {
        super.j(wVar);
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.N.get(i11).j(wVar);
        }
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public u b(@NonNull View view) {
        for (int i11 = 0; i11 < this.N.size(); i11++) {
            this.N.get(i11).b(view);
        }
        return (u) super.b(view);
    }

    @Override // k6.j
    public void k(@NonNull w wVar) {
        if (K(wVar.f68417b)) {
            for (j jVar : this.N) {
                if (jVar.K(wVar.f68417b)) {
                    jVar.k(wVar);
                    wVar.f68418c.add(jVar);
                }
            }
        }
    }

    @NonNull
    public u k0(@NonNull j jVar) {
        l0(jVar);
        long j11 = this.f68350c;
        if (j11 >= 0) {
            jVar.a0(j11);
        }
        if ((this.R & 1) != 0) {
            jVar.c0(t());
        }
        if ((this.R & 2) != 0) {
            z();
            jVar.e0(null);
        }
        if ((this.R & 4) != 0) {
            jVar.d0(y());
        }
        if ((this.R & 8) != 0) {
            jVar.b0(s());
        }
        return this;
    }

    public final void l0(@NonNull j jVar) {
        this.N.add(jVar);
        jVar.f68365s = this;
    }

    @Nullable
    public j m0(int i11) {
        if (i11 < 0 || i11 >= this.N.size()) {
            return null;
        }
        return this.N.get(i11);
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public j clone() {
        u uVar = (u) super.clone();
        uVar.N = new ArrayList<>();
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            uVar.l0(this.N.get(i11).clone());
        }
        return uVar;
    }

    public int n0() {
        return this.N.size();
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public u V(@NonNull j.f fVar) {
        return (u) super.V(fVar);
    }

    @Override // k6.j
    public void p(@NonNull ViewGroup viewGroup, @NonNull x xVar, @NonNull x xVar2, @NonNull ArrayList<w> arrayList, @NonNull ArrayList<w> arrayList2) {
        long jC = C();
        int size = this.N.size();
        for (int i11 = 0; i11 < size; i11++) {
            j jVar = this.N.get(i11);
            if (jC > 0 && (this.O || i11 == 0)) {
                long jC2 = jVar.C();
                if (jC2 > 0) {
                    jVar.f0(jC2 + jC);
                } else {
                    jVar.f0(jC);
                }
            }
            jVar.p(viewGroup, xVar, xVar2, arrayList, arrayList2);
        }
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public u W(@NonNull View view) {
        for (int i11 = 0; i11 < this.N.size(); i11++) {
            this.N.get(i11).W(view);
        }
        return (u) super.W(view);
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public u a0(long j11) {
        ArrayList<j> arrayList;
        super.a0(j11);
        if (this.f68350c >= 0 && (arrayList = this.N) != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.N.get(i11).a0(j11);
            }
        }
        return this;
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public u c0(@Nullable TimeInterpolator timeInterpolator) {
        this.R |= 1;
        ArrayList<j> arrayList = this.N;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.N.get(i11).c0(timeInterpolator);
            }
        }
        return (u) super.c0(timeInterpolator);
    }

    @NonNull
    public u s0(int i11) {
        if (i11 == 0) {
            this.O = true;
        } else {
            if (i11 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i11);
            }
            this.O = false;
        }
        return this;
    }

    @Override // k6.j
    @NonNull
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public u f0(long j11) {
        return (u) super.f0(j11);
    }

    public final void u0() {
        b bVar = new b(this);
        Iterator<j> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.P = this.N.size();
    }
}
