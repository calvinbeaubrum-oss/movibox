package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1<In> implements d0<In> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Out f13487a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t6.c f13488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f13489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j1.a f13490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a0 f13491e;

        public AnonymousClass1(t6.c cVar, Object obj, j1.a aVar, a0 a0Var) {
            this.f13488b = cVar;
            this.f13489c = obj;
            this.f13490d = aVar;
            this.f13491e = a0Var;
        }

        @Override // androidx.lifecycle.d0
        public void onChanged(@Nullable final In in2) {
            this.f13488b.c(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.f13489c) {
                        try {
                            ?? Apply = AnonymousClass1.this.f13490d.apply(in2);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Out out = anonymousClass1.f13487a;
                            if (out == 0 && Apply != 0) {
                                anonymousClass1.f13487a = Apply;
                                anonymousClass1.f13491e.n(Apply);
                            } else if (out != 0 && !out.equals(Apply)) {
                                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                                anonymousClass2.f13487a = Apply;
                                anonymousClass2.f13491e.n(Apply);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static <In, Out> LiveData<Out> a(@NonNull LiveData<In> liveData, @NonNull j1.a<In, Out> aVar, @NonNull t6.c cVar) {
        Object obj = new Object();
        a0 a0Var = new a0();
        a0Var.r(liveData, new AnonymousClass1(cVar, obj, aVar, a0Var));
        return a0Var;
    }
}
