package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static sc f27035sc;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0265pFF {
        void sc();

        void sc(Throwable th2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();
    }

    public static Activity sc(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public static void sc(sc scVar) {
        f27035sc = scVar;
    }

    public static boolean sc(Context context, Intent intent, InterfaceC0265pFF interfaceC0265pFF) {
        return sc(context, intent, interfaceC0265pFF, false);
    }

    public static boolean sc(final Context context, final Intent intent, final InterfaceC0265pFF interfaceC0265pFF, boolean z11) {
        sc scVar;
        ExecutorService asyncStartActivityThreadPool;
        if (!z11 || (scVar = f27035sc) == null || !scVar.isEnableAsyncStartActivity() || (asyncStartActivityThreadPool = f27035sc.getAsyncStartActivityThreadPool()) == null) {
            return zY(context, intent, interfaceC0265pFF);
        }
        asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.Qj.Qj("startAct") { // from class: com.bytedance.sdk.component.utils.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                pFF.zY(context, intent, interfaceC0265pFF);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zY(Context context, Intent intent, InterfaceC0265pFF interfaceC0265pFF) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                context.startActivity(intent);
                if (interfaceC0265pFF == null) {
                    return true;
                }
                interfaceC0265pFF.sc();
                return true;
            } catch (Throwable th2) {
                if (interfaceC0265pFF != null) {
                    interfaceC0265pFF.sc(th2);
                }
            }
        }
        return false;
    }
}
