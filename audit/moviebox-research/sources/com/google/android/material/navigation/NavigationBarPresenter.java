package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.q;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class NavigationBarPresenter implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f37189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavigationBarMenuView f37190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f37191c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37192d;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public ParcelableSparseArray f37194b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public SavedState(@NonNull Parcel parcel) {
            this.f37193a = parcel.readInt();
            this.f37194b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            parcel.writeInt(this.f37193a);
            parcel.writeParcelable(this.f37194b, 0);
        }
    }

    public void a(int i11) {
        this.f37192d = i11;
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(@Nullable androidx.appcompat.view.menu.f fVar, boolean z11) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(@Nullable androidx.appcompat.view.menu.f fVar, @Nullable h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f37190b.k(savedState.f37193a);
            this.f37190b.j(com.google.android.material.badge.c.d(this.f37190b.getContext(), savedState.f37194b));
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(@Nullable q qVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    @NonNull
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f37193a = this.f37190b.getSelectedItemId();
        savedState.f37194b = com.google.android.material.badge.c.e(this.f37190b.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f37192d;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        if (this.f37191c) {
            return;
        }
        if (z11) {
            this.f37190b.buildMenuView();
        } else {
            this.f37190b.updateMenuView();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(@Nullable androidx.appcompat.view.menu.f fVar, @Nullable h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(@NonNull Context context, @NonNull androidx.appcompat.view.menu.f fVar) {
        this.f37189a = fVar;
        this.f37190b.initialize(fVar);
    }

    public void l(@NonNull NavigationBarMenuView navigationBarMenuView) {
        this.f37190b = navigationBarMenuView;
    }

    public void m(boolean z11) {
        this.f37191c = z11;
    }
}
