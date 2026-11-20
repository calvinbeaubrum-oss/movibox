package androidx.compose.ui;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.t1;

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
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3863a = a.f3864b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f3864b = new a();

        @Override // androidx.compose.ui.f
        public <R> R c(R r11, Function2<? super R, ? super b, ? extends R> function2) {
            return r11;
        }

        @Override // androidx.compose.ui.f
        public boolean d(Function1<? super b, Boolean> function1) {
            return true;
        }

        @Override // androidx.compose.ui.f
        public f f(f fVar) {
            return fVar;
        }

        public String toString() {
            return "Modifier";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b extends f {
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static abstract class c implements androidx.compose.ui.node.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k0 f3866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3867c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f3869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f3870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ObserverNodeOwnerScope f3871h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public NodeCoordinator f3872i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f3873j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f3874k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f3875l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f3876m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f3877n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f3865a = this;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3868d = -1;

        public final void A1(boolean z11) {
            this.f3873j = z11;
        }

        public final void B1(int i11) {
            this.f3867c = i11;
        }

        public final void C1(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.f3871h = observerNodeOwnerScope;
        }

        public final void D1(c cVar) {
            this.f3869f = cVar;
        }

        public final void E1(boolean z11) {
            this.f3874k = z11;
        }

        public final void F1(Function0<Unit> function0) {
            androidx.compose.ui.node.g.n(this).registerOnEndApplyChangesListener(function0);
        }

        public void G1(NodeCoordinator nodeCoordinator) {
            this.f3872i = nodeCoordinator;
        }

        public final int e1() {
            return this.f3868d;
        }

        public final c f1() {
            return this.f3870g;
        }

        public final NodeCoordinator g1() {
            return this.f3872i;
        }

        @Override // androidx.compose.ui.node.f
        public final c getNode() {
            return this.f3865a;
        }

        public final k0 h1() {
            k0 k0Var = this.f3866b;
            if (k0Var != null) {
                return k0Var;
            }
            k0 k0VarA = l0.a(androidx.compose.ui.node.g.n(this).getCoroutineContext().plus(t1.a((q1) androidx.compose.ui.node.g.n(this).getCoroutineContext().get(q1.f69514j8))));
            this.f3866b = k0VarA;
            return k0VarA;
        }

        public final boolean i1() {
            return this.f3873j;
        }

        public final int j1() {
            return this.f3867c;
        }

        public final ObserverNodeOwnerScope k1() {
            return this.f3871h;
        }

        public final c l1() {
            return this.f3869f;
        }

        public boolean m1() {
            return true;
        }

        public final boolean n1() {
            return this.f3874k;
        }

        public final boolean o1() {
            return this.f3877n;
        }

        public void p1() {
            if (!(!this.f3877n)) {
                h2.a.b("node attached multiple times");
            }
            if (!(this.f3872i != null)) {
                h2.a.b("attach invoked on a node without a coordinator");
            }
            this.f3877n = true;
            this.f3875l = true;
        }

        public void q1() {
            if (!this.f3877n) {
                h2.a.b("Cannot detach a node that is not attached");
            }
            if (!(!this.f3875l)) {
                h2.a.b("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (!(!this.f3876m)) {
                h2.a.b("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.f3877n = false;
            k0 k0Var = this.f3866b;
            if (k0Var != null) {
                l0.c(k0Var, new ModifierNodeDetachedCancellationException());
                this.f3866b = null;
            }
        }

        public void r1() {
        }

        public void s1() {
        }

        public void t1() {
        }

        public void u1() {
            if (!this.f3877n) {
                h2.a.b("reset() called on an unattached node");
            }
            t1();
        }

        public void v1() {
            if (!this.f3877n) {
                h2.a.b("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.f3875l) {
                h2.a.b("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.f3875l = false;
            r1();
            this.f3876m = true;
        }

        public void w1() {
            if (!this.f3877n) {
                h2.a.b("node detached multiple times");
            }
            if (!(this.f3872i != null)) {
                h2.a.b("detach invoked on a node without a coordinator");
            }
            if (!this.f3876m) {
                h2.a.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.f3876m = false;
            s1();
        }

        public final void x1(int i11) {
            this.f3868d = i11;
        }

        public void y1(c cVar) {
            this.f3865a = cVar;
        }

        public final void z1(c cVar) {
            this.f3870g = cVar;
        }
    }

    <R> R c(R r11, Function2<? super R, ? super b, ? extends R> function2);

    boolean d(Function1<? super b, Boolean> function1);

    f f(f fVar);
}
