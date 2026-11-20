package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f8589a;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f8590a;

        public a(v vVar) {
            this.f8590a = vVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f8590a.k();
            this.f8590a.m();
            SpecialEffectsController.n((ViewGroup) fragmentK.mView.getParent(), j.this.f8589a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public j(FragmentManager fragmentManager) {
        this.f8589a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        v vVarCreateOrGetFragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f8589a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !h.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentFindFragmentById = resourceId != -1 ? this.f8589a.findFragmentById(resourceId) : null;
        if (fragmentFindFragmentById == null && string != null) {
            fragmentFindFragmentById = this.f8589a.findFragmentByTag(string);
        }
        if (fragmentFindFragmentById == null && id2 != -1) {
            fragmentFindFragmentById = this.f8589a.findFragmentById(id2);
        }
        if (fragmentFindFragmentById == null) {
            fragmentFindFragmentById = this.f8589a.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragmentFindFragmentById.mFromLayout = true;
            fragmentFindFragmentById.mFragmentId = resourceId != 0 ? resourceId : id2;
            fragmentFindFragmentById.mContainerId = id2;
            fragmentFindFragmentById.mTag = string;
            fragmentFindFragmentById.mInLayout = true;
            FragmentManager fragmentManager = this.f8589a;
            fragmentFindFragmentById.mFragmentManager = fragmentManager;
            fragmentFindFragmentById.mHost = fragmentManager.getHost();
            fragmentFindFragmentById.onInflate(this.f8589a.getHost().f(), attributeSet, fragmentFindFragmentById.mSavedFragmentState);
            vVarCreateOrGetFragmentStateManager = this.f8589a.addFragment(fragmentFindFragmentById);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Fragment " + fragmentFindFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentFindFragmentById.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            fragmentFindFragmentById.mInLayout = true;
            FragmentManager fragmentManager2 = this.f8589a;
            fragmentFindFragmentById.mFragmentManager = fragmentManager2;
            fragmentFindFragmentById.mHost = fragmentManager2.getHost();
            fragmentFindFragmentById.onInflate(this.f8589a.getHost().f(), attributeSet, fragmentFindFragmentById.mSavedFragmentState);
            vVarCreateOrGetFragmentStateManager = this.f8589a.createOrGetFragmentStateManager(fragmentFindFragmentById);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Retained Fragment " + fragmentFindFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(fragmentFindFragmentById, viewGroup);
        fragmentFindFragmentById.mContainer = viewGroup;
        vVarCreateOrGetFragmentStateManager.m();
        vVarCreateOrGetFragmentStateManager.j();
        View view2 = fragmentFindFragmentById.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentFindFragmentById.mView.getTag() == null) {
            fragmentFindFragmentById.mView.setTag(string);
        }
        fragmentFindFragmentById.mView.addOnAttachStateChangeListener(new a(vVarCreateOrGetFragmentStateManager));
        return fragmentFindFragmentById.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
