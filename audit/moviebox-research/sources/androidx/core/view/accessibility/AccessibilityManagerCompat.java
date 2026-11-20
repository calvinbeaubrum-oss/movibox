package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityManagerCompat {

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    /* JADX INFO: compiled from: source.java */
    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements AccessibilityManager.AccessibilityStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccessibilityStateChangeListener f7999a;

        public a(@NonNull AccessibilityStateChangeListener accessibilityStateChangeListener) {
            this.f7999a = accessibilityStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f7999a.equals(((a) obj).f7999a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7999a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z11) {
            this.f7999a.onAccessibilityStateChanged(z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class b {
        public static boolean a(AccessibilityManager accessibilityManager) {
            return accessibilityManager.isRequestFromAccessibilityTool();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TouchExplorationStateChangeListener f8000a;

        public c(@NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            this.f8000a = touchExplorationStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f8000a.equals(((c) obj).f8000a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8000a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z11) {
            this.f8000a.onTouchExplorationStateChanged(z11);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener(new a(accessibilityStateChangeListener));
    }

    public static boolean addTouchExplorationStateChangeListener(@NonNull AccessibilityManager accessibilityManager, @NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new c(touchExplorationStateChangeListener));
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i11) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i11);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(@NonNull AccessibilityManager accessibilityManager) {
        if (Build.VERSION.SDK_INT >= 34) {
            return b.a(accessibilityManager);
        }
        return true;
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener(new a(accessibilityStateChangeListener));
    }

    public static boolean removeTouchExplorationStateChangeListener(@NonNull AccessibilityManager accessibilityManager, @NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new c(touchExplorationStateChangeListener));
    }
}
