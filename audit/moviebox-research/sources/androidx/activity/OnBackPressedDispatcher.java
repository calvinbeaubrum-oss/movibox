package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.core.util.a<Boolean> f603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<p> f604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f609h;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(33)
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f610a = new a();

        public static final void c(Function0 onBackInvoked) {
            Intrinsics.g(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final Function0<Unit> onBackInvoked) {
            Intrinsics.g(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.q
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i11, Object callback) {
            Intrinsics.g(dispatcher, "dispatcher");
            Intrinsics.g(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i11, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            Intrinsics.g(dispatcher, "dispatcher");
            Intrinsics.g(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(34)
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f611a = new b();

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<androidx.activity.b, Unit> f612a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<androidx.activity.b, Unit> f613b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f614c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f615d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super androidx.activity.b, Unit> function1, Function1<? super androidx.activity.b, Unit> function2, Function0<Unit> function0, Function0<Unit> function3) {
                this.f612a = function1;
                this.f613b = function2;
                this.f614c = function0;
                this.f615d = function3;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f615d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f614c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                Intrinsics.g(backEvent, "backEvent");
                this.f613b.invoke(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                Intrinsics.g(backEvent, "backEvent");
                this.f612a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(Function1<? super androidx.activity.b, Unit> onBackStarted, Function1<? super androidx.activity.b, Unit> onBackProgressed, Function0<Unit> onBackInvoked, Function0<Unit> onBackCancelled) {
            Intrinsics.g(onBackStarted, "onBackStarted");
            Intrinsics.g(onBackProgressed, "onBackProgressed");
            Intrinsics.g(onBackInvoked, "onBackInvoked");
            Intrinsics.g(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class c implements androidx.lifecycle.r, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.activity.c f618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f619d;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, p onBackPressedCallback) {
            Intrinsics.g(lifecycle, "lifecycle");
            Intrinsics.g(onBackPressedCallback, "onBackPressedCallback");
            this.f619d = onBackPressedDispatcher;
            this.f616a = lifecycle;
            this.f617b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f616a.d(this);
            this.f617b.removeCancellable(this);
            androidx.activity.c cVar = this.f618c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f618c = null;
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(androidx.lifecycle.u source, Lifecycle.Event event) {
            Intrinsics.g(source, "source");
            Intrinsics.g(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f618c = this.f619d.j(this.f617b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f618c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public final class d implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f621b;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, p onBackPressedCallback) {
            Intrinsics.g(onBackPressedCallback, "onBackPressedCallback");
            this.f621b = onBackPressedDispatcher;
            this.f620a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f621b.f604c.remove(this.f620a);
            if (Intrinsics.b(this.f621b.f605d, this.f620a)) {
                this.f620a.handleOnBackCancelled();
                this.f621b.f605d = null;
            }
            this.f620a.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = this.f620a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f620a.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable, androidx.core.util.a<Boolean> aVar) {
        this.f602a = runnable;
        this.f603b = aVar;
        this.f604c = new ArrayDeque<>();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            this.f606e = i11 >= 34 ? b.f611a.a(new Function1<androidx.activity.b, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(androidx.activity.b bVar) {
                    invoke2(bVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.activity.b backEvent) {
                    Intrinsics.g(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.n(backEvent);
                }
            }, new Function1<androidx.activity.b, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(androidx.activity.b bVar) {
                    invoke2(bVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.activity.b backEvent) {
                    Intrinsics.g(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.m(backEvent);
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.this.l();
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.this.k();
                }
            }) : a.f610a.b(new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnBackPressedDispatcher.this.l();
                }
            });
        }
    }

    public final void h(p onBackPressedCallback) {
        Intrinsics.g(onBackPressedCallback, "onBackPressedCallback");
        j(onBackPressedCallback);
    }

    public final void i(androidx.lifecycle.u owner, p onBackPressedCallback) {
        Intrinsics.g(owner, "owner");
        Intrinsics.g(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new c(this, lifecycle, onBackPressedCallback));
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final androidx.activity.c j(p onBackPressedCallback) {
        Intrinsics.g(onBackPressedCallback, "onBackPressedCallback");
        this.f604c.add(onBackPressedCallback);
        d dVar = new d(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(dVar);
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return dVar;
    }

    public final void k() {
        p pVarPrevious;
        ArrayDeque<p> arrayDeque = this.f604c;
        ListIterator<p> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                pVarPrevious = null;
                break;
            }
            pVarPrevious = listIterator.previous();
        } while (!pVarPrevious.isEnabled());
        p pVar = pVarPrevious;
        this.f605d = null;
        if (pVar != null) {
            pVar.handleOnBackCancelled();
        }
    }

    public final void l() {
        p pVarPrevious;
        ArrayDeque<p> arrayDeque = this.f604c;
        ListIterator<p> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                pVarPrevious = null;
                break;
            }
            pVarPrevious = listIterator.previous();
        } while (!pVarPrevious.isEnabled());
        p pVar = pVarPrevious;
        this.f605d = null;
        if (pVar != null) {
            pVar.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f602a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void m(androidx.activity.b bVar) {
        p pVarPrevious;
        ArrayDeque<p> arrayDeque = this.f604c;
        ListIterator<p> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                pVarPrevious = null;
                break;
            }
            pVarPrevious = listIterator.previous();
        } while (!pVarPrevious.isEnabled());
        p pVar = pVarPrevious;
        if (pVar != null) {
            pVar.handleOnBackProgressed(bVar);
        }
    }

    public final void n(androidx.activity.b bVar) {
        p pVarPrevious;
        ArrayDeque<p> arrayDeque = this.f604c;
        ListIterator<p> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                pVarPrevious = null;
                break;
            }
            pVarPrevious = listIterator.previous();
        } while (!pVarPrevious.isEnabled());
        p pVar = pVarPrevious;
        this.f605d = pVar;
        if (pVar != null) {
            pVar.handleOnBackStarted(bVar);
        }
    }

    @RequiresApi(33)
    public final void o(OnBackInvokedDispatcher invoker) {
        Intrinsics.g(invoker, "invoker");
        this.f607f = invoker;
        p(this.f609h);
    }

    @RequiresApi(33)
    public final void p(boolean z11) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f607f;
        OnBackInvokedCallback onBackInvokedCallback = this.f606e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z11 && !this.f608g) {
            a.f610a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f608g = true;
        } else {
            if (z11 || !this.f608g) {
                return;
            }
            a.f610a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f608g = false;
        }
    }

    public final void q() {
        boolean z11 = this.f609h;
        ArrayDeque<p> arrayDeque = this.f604c;
        boolean z12 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<p> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (it.next().isEnabled()) {
                    z12 = true;
                    break;
                }
            }
        }
        this.f609h = z12;
        if (z12 != z11) {
            androidx.core.util.a<Boolean> aVar = this.f603b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z12));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z12);
            }
        }
    }
}
