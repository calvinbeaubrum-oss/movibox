package id;

import android.view.View;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface f {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(f fVar, View view) {
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).hideKeyboard(view);
        }

        public static void b(f fVar, View view) {
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).showKeyboard(view);
        }

        public static void c(f fVar, View view) {
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).toggleSoftInput(view);
        }
    }
}
