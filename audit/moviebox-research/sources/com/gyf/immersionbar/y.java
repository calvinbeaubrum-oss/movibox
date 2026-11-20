package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class y implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f41669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<FragmentManager, x> f41670d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestBarManagerFragment> f41671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, x> f41672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, SupportRequestBarManagerFragment> f41673h;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f41674a = new y();
    }

    public y() {
        this.f41667a = ImmersionBar.class.getName() + InstructionFileId.DOT;
        this.f41668b = ".tag.notOnly.";
        this.f41670d = new HashMap();
        this.f41671f = new HashMap();
        this.f41672g = new HashMap();
        this.f41673h = new HashMap();
        this.f41669c = new Handler(Looper.getMainLooper(), this);
    }

    public static <T> void a(@Nullable T t11, @NonNull String str) {
        if (t11 == null) {
            throw new NullPointerException(str);
        }
    }

    public static y i() {
        return b.f41674a;
    }

    public void b(Activity activity, Dialog dialog, boolean z11) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.f41667a + dialog.getClass().getName();
        if (!z11) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            k(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
        } else {
            h(activity.getFragmentManager(), str, true);
        }
    }

    public ImmersionBar c(Activity activity, Dialog dialog, boolean z11) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        String str = this.f41667a + dialog.getClass().getName();
        if (!z11) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).g0(activity, dialog) : g(activity.getFragmentManager(), str).a(activity, dialog);
    }

    public ImmersionBar d(Activity activity, boolean z11) {
        a(activity, "activity is null");
        String str = this.f41667a + activity.getClass().getName();
        if (!z11) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).h0(activity) : g(activity.getFragmentManager(), str).b(activity);
    }

    @RequiresApi(api = 17)
    public ImmersionBar e(Fragment fragment, boolean z11) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f41667a + fragment.getClass().getName();
        if (!z11) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return g(fragment.getChildFragmentManager(), str).b(fragment);
    }

    public ImmersionBar f(androidx.fragment.app.Fragment fragment, boolean z11) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof androidx.fragment.app.DialogFragment) {
            a(((androidx.fragment.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f41667a + fragment.getClass().getName();
        if (!z11) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return j(fragment.getChildFragmentManager(), str).h0(fragment);
    }

    public final x g(FragmentManager fragmentManager, String str) {
        return h(fragmentManager, str, false);
    }

    public final x h(FragmentManager fragmentManager, String str, boolean z11) {
        x xVar = (x) fragmentManager.findFragmentByTag(str);
        if (xVar == null && (xVar = this.f41670d.get(fragmentManager)) == null) {
            if (z11) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                for (Fragment fragment : fragmentManager.getFragments()) {
                    if (fragment instanceof x) {
                        String tag = fragment.getTag();
                        if (tag == null) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        } else if (tag.contains(".tag.notOnly.")) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        }
                    }
                }
            }
            xVar = new x();
            this.f41670d.put(fragmentManager, xVar);
            fragmentManager.beginTransaction().add(xVar, str).commitAllowingStateLoss();
            this.f41669c.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z11) {
            return xVar;
        }
        if (this.f41672g.get(str) == null) {
            this.f41672g.put(str, xVar);
            fragmentManager.beginTransaction().remove(xVar).commitAllowingStateLoss();
            this.f41669c.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            this.f41670d.remove((FragmentManager) message.obj);
            return true;
        }
        if (i11 == 2) {
            this.f41671f.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i11 == 3) {
            this.f41672g.remove((String) message.obj);
            return true;
        }
        if (i11 != 4) {
            return false;
        }
        this.f41673h.remove((String) message.obj);
        return true;
    }

    public final SupportRequestBarManagerFragment j(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return k(fragmentManager, str, false);
    }

    public final SupportRequestBarManagerFragment k(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z11) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = this.f41671f.get(fragmentManager)) == null) {
            if (z11) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.f41671f.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestBarManagerFragment, str).commitAllowingStateLoss();
            this.f41669c.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z11) {
            return supportRequestBarManagerFragment;
        }
        if (this.f41673h.get(str) == null) {
            this.f41673h.put(str, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().remove(supportRequestBarManagerFragment).commitAllowingStateLoss();
            this.f41669c.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }
}
