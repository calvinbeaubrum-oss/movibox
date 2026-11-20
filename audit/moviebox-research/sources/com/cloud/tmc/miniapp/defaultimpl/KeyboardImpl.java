package com.cloud.tmc.miniapp.defaultimpl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.miniapp.defaultimpl.KeyboardImpl;
import h.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardImpl implements IKeyboardProxy {
    public static final a Companion = new a();
    public rb.a OooO00o;
    public int OooO0O0;
    public boolean OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Handler f31517OooO0Oo;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements rb.a {
        public b() {
        }

        @Override // rb.a
        public void a(int i11) {
            if (i11 != KeyboardImpl.this.OooO0O0) {
                KeyboardImpl.this.OooO0O0 = i11;
                Handler handler = KeyboardImpl.this.f31517OooO0Oo;
                handler.sendMessage(handler.obtainMessage(2, Integer.valueOf(i11)));
            }
        }

        @Override // rb.a
        public void b() {
            if (KeyboardImpl.this.OooO0OO) {
                return;
            }
            KeyboardImpl.this.OooO0OO = true;
            KeyboardImpl.this.f31517OooO0Oo.sendEmptyMessage(1);
        }

        @Override // rb.a
        public void c() {
            if (KeyboardImpl.this.OooO0OO) {
                KeyboardImpl.this.OooO0OO = false;
                KeyboardImpl.this.f31517OooO0Oo.sendEmptyMessage(3);
            }
        }
    }

    public KeyboardImpl() {
        Looper looperMyLooper = Looper.myLooper();
        this.f31517OooO0Oo = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, new Handler.Callback() { // from class: md.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return KeyboardImpl.OooO00o(this.f70987a, message);
            }
        });
    }

    public static final void OooO00o(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static final boolean OooO00o(KeyboardImpl this$0, Message it) {
        rb.a aVar;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "it");
        int i11 = it.what;
        if (i11 == 1) {
            rb.a aVar2 = this$0.OooO00o;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (i11 == 2) {
            rb.a aVar3 = this$0.OooO00o;
            if (aVar3 != null) {
                Object obj = it.obj;
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
                aVar3.a(((Integer) obj).intValue());
            }
        } else if (i11 == 3 && (aVar = this$0.OooO00o) != null) {
            aVar.c();
        }
        return true;
    }

    public static final void OooO0O0(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 2);
        }
    }

    public static final void OooO0OO(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void hideKeyboard(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: md.d
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO00o(view);
                }
            });
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void initKeyBoardChange(View view) {
        if (view != null) {
            ViewCompat.setWindowInsetsAnimationCallback(view, new g(WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime(), new b()));
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void releaseKeyBoardChange(View view) {
        if (view != null) {
            ViewCompat.setWindowInsetsAnimationCallback(view, null);
        }
        this.f31517OooO0Oo.removeCallbacksAndMessages(null);
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void setKeyBoardListener(rb.a aVar) {
        this.OooO00o = aVar;
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void showKeyboard(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: md.e
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO0O0(view);
                }
            });
        }
    }

    @Override // com.cloud.tmc.integration.proxy.IKeyboardProxy
    public void toggleSoftInput(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: md.c
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardImpl.OooO0OO(view);
                }
            });
        }
    }
}
