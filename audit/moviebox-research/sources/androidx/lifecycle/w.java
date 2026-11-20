package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class w extends Lifecycle {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8790k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i1.a<t, b> f8792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle.State f8793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<u> f8794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<Lifecycle.State> f8798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kotlinx.coroutines.flow.v0<Lifecycle.State> f8799j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            Intrinsics.g(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Lifecycle.State f8800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f8801b;

        public b(t tVar, Lifecycle.State initialState) {
            Intrinsics.g(initialState, "initialState");
            Intrinsics.d(tVar);
            this.f8801b = z.f(tVar);
            this.f8800a = initialState;
        }

        public final void a(u uVar, Lifecycle.Event event) {
            Intrinsics.g(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f8800a = w.f8790k.a(this.f8800a, targetState);
            r rVar = this.f8801b;
            Intrinsics.d(uVar);
            rVar.onStateChanged(uVar, event);
            this.f8800a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f8800a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(u provider) {
        this(provider, true);
        Intrinsics.g(provider, "provider");
    }

    public w(u uVar, boolean z11) {
        this.f8791b = z11;
        this.f8792c = new i1.a<>();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.f8793d = state;
        this.f8798i = new ArrayList<>();
        this.f8794e = new WeakReference<>(uVar);
        this.f8799j = g1.a(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(t observer) {
        u uVar;
        Intrinsics.g(observer, "observer");
        g("addObserver");
        Lifecycle.State state = this.f8793d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (this.f8792c.i(observer, bVar) == null && (uVar = this.f8794e.get()) != null) {
            boolean z11 = this.f8795f != 0 || this.f8796g;
            Lifecycle.State stateF = f(observer);
            this.f8795f++;
            while (bVar.b().compareTo(stateF) < 0 && this.f8792c.contains(observer)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(uVar, eventC);
                l();
                stateF = f(observer);
            }
            if (!z11) {
                o();
            }
            this.f8795f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f8793d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void d(t observer) {
        Intrinsics.g(observer, "observer");
        g("removeObserver");
        this.f8792c.j(observer);
    }

    public final void e(u uVar) {
        Iterator<Map.Entry<t, b>> itDescendingIterator = this.f8792c.descendingIterator();
        Intrinsics.f(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f8797h) {
            Map.Entry<t, b> next = itDescendingIterator.next();
            Intrinsics.f(next, "next()");
            t key = next.getKey();
            b value = next.getValue();
            while (value.b().compareTo(this.f8793d) > 0 && !this.f8797h && this.f8792c.contains(key)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(value.b());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + value.b());
                }
                m(eventA.getTargetState());
                value.a(uVar, eventA);
                l();
            }
        }
    }

    public final Lifecycle.State f(t tVar) {
        b value;
        Map.Entry<t, b> entryO = this.f8792c.o(tVar);
        Lifecycle.State state = null;
        Lifecycle.State stateB = (entryO == null || (value = entryO.getValue()) == null) ? null : value.b();
        if (!this.f8798i.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f8798i;
            state = arrayList.get(arrayList.size() - 1);
        }
        a aVar = f8790k;
        return aVar.a(aVar.a(this.f8793d, stateB), state);
    }

    public final void g(String str) {
        if (!this.f8791b || y.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void h(u uVar) {
        i1.b<t, b>.d dVarE = this.f8792c.e();
        Intrinsics.f(dVarE, "observerMap.iteratorWithAdditions()");
        while (dVarE.hasNext() && !this.f8797h) {
            Map.Entry next = dVarE.next();
            t tVar = (t) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f8793d) < 0 && !this.f8797h && this.f8792c.contains(tVar)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(uVar, eventC);
                l();
            }
        }
    }

    public void i(Lifecycle.Event event) {
        Intrinsics.g(event, "event");
        g("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public final boolean j() {
        if (this.f8792c.size() == 0) {
            return true;
        }
        Map.Entry<t, b> entryA = this.f8792c.a();
        Intrinsics.d(entryA);
        Lifecycle.State stateB = entryA.getValue().b();
        Map.Entry<t, b> entryF = this.f8792c.f();
        Intrinsics.d(entryF);
        Lifecycle.State stateB2 = entryF.getValue().b();
        return stateB == stateB2 && this.f8793d == stateB2;
    }

    public final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.f8793d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + state + ", but was " + this.f8793d + " in component " + this.f8794e.get()).toString());
        }
        this.f8793d = state;
        if (this.f8796g || this.f8795f != 0) {
            this.f8797h = true;
            return;
        }
        this.f8796g = true;
        o();
        this.f8796g = false;
        if (this.f8793d == Lifecycle.State.DESTROYED) {
            this.f8792c = new i1.a<>();
        }
    }

    public final void l() {
        ArrayList<Lifecycle.State> arrayList = this.f8798i;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.f8798i.add(state);
    }

    public void n(Lifecycle.State state) {
        Intrinsics.g(state, "state");
        g("setCurrentState");
        k(state);
    }

    public final void o() {
        u uVar = this.f8794e.get();
        if (uVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.f8797h = false;
            Lifecycle.State state = this.f8793d;
            Map.Entry<t, b> entryA = this.f8792c.a();
            Intrinsics.d(entryA);
            if (state.compareTo(entryA.getValue().b()) < 0) {
                e(uVar);
            }
            Map.Entry<t, b> entryF = this.f8792c.f();
            if (!this.f8797h && entryF != null && this.f8793d.compareTo(entryF.getValue().b()) > 0) {
                h(uVar);
            }
        }
        this.f8797h = false;
        this.f8799j.setValue(b());
    }
}
