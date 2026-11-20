package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {

    /* JADX INFO: compiled from: source.java */
    public class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f21995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f21996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f21997c;

        public a(Class cls, b bVar, q qVar) {
            this.f21995a = cls;
            this.f21996b = bVar;
            this.f21997c = qVar;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f21995a.isInstance(activity)) {
                this.f21996b.a(activity);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!this.f21995a.isInstance(activity) || activity.isChangingConfigurations()) {
                return;
            }
            this.f21997c.b(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Activity activity);
    }

    public static Activity a(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static void a(Context context, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        if (!(context instanceof Activity)) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, Class cls, q qVar, b bVar) {
        qVar.a(new a(cls, bVar, qVar));
        a(context, cls);
    }

    public static void a(boolean z11, Activity activity) {
        if (!z11 || !z3.b()) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
            return;
        }
        WindowInsetsController insetsController = activity.getWindow().getInsetsController();
        if (insetsController == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        } else {
            insetsController.setSystemBarsBehavior(2);
            insetsController.hide(WindowInsets.Type.systemBars());
        }
    }

    public static boolean a(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isChangingConfigurations() || (z3.d() && activity.isDestroyed());
    }
}
