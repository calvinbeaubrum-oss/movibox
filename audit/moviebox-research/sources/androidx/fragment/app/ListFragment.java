package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ListFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f8545a = new Handler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f8546b = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f8549f;
            listView.focusableViewAvailable(listView);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f8547c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ListAdapter f8548d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ListView f8549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f8550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f8551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f8552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f8553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f8554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8555l;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            ListFragment.this.h0((ListView) adapterView, view, i11, j11);
        }
    }

    public final void g0() {
        if (this.f8549f != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f8549f = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.f8551h = textView;
            if (textView == null) {
                this.f8550g = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.f8552i = view.findViewById(16711682);
            this.f8553j = view.findViewById(16711683);
            View viewFindViewById = view.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) viewFindViewById;
            this.f8549f = listView;
            View view2 = this.f8550g;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.f8554k;
                if (charSequence != null) {
                    this.f8551h.setText(charSequence);
                    this.f8549f.setEmptyView(this.f8551h);
                }
            }
        }
        this.f8555l = true;
        this.f8549f.setOnItemClickListener(this.f8547c);
        ListAdapter listAdapter = this.f8548d;
        if (listAdapter != null) {
            this.f8548d = null;
            i0(listAdapter);
        } else if (this.f8552i != null) {
            j0(false, false);
        }
        this.f8545a.post(this.f8546b);
    }

    public void h0(@NonNull ListView listView, @NonNull View view, int i11, long j11) {
    }

    public void i0(@Nullable ListAdapter listAdapter) {
        boolean z11 = this.f8548d != null;
        this.f8548d = listAdapter;
        ListView listView = this.f8549f;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f8555l || z11) {
                return;
            }
            j0(true, requireView().getWindowToken() != null);
        }
    }

    public final void j0(boolean z11, boolean z12) {
        g0();
        View view = this.f8552i;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f8555l == z11) {
            return;
        }
        this.f8555l = z11;
        if (z11) {
            if (z12) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.f8553j.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f8553j.clearAnimation();
            }
            this.f8552i.setVisibility(8);
            this.f8553j.setVisibility(0);
            return;
        }
        if (z12) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.f8553j.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f8553j.clearAnimation();
        }
        this.f8552i.setVisibility(0);
        this.f8553j.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextRequireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextRequireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(contextRequireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextRequireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f8545a.removeCallbacks(this.f8546b);
        this.f8549f = null;
        this.f8555l = false;
        this.f8553j = null;
        this.f8552i = null;
        this.f8550g = null;
        this.f8551h = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        g0();
    }
}
