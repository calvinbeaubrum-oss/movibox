package com.google.android.libraries.places.api.net;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface PlacesClient {
    @RecentlyNonNull
    Task<FetchPhotoResponse> fetchPhoto(@RecentlyNonNull FetchPhotoRequest fetchPhotoRequest);

    @RecentlyNonNull
    Task<FetchPlaceResponse> fetchPlace(@RecentlyNonNull FetchPlaceRequest fetchPlaceRequest);

    @RecentlyNonNull
    Task<FetchResolvedPhotoUriResponse> fetchResolvedPhotoUri(@RecentlyNonNull FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest);

    @RecentlyNonNull
    Task<FindAutocompletePredictionsResponse> findAutocompletePredictions(@RecentlyNonNull FindAutocompletePredictionsRequest findAutocompletePredictionsRequest);

    @RecentlyNonNull
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    Task<FindCurrentPlaceResponse> findCurrentPlace(@RecentlyNonNull FindCurrentPlaceRequest findCurrentPlaceRequest);

    @RecentlyNonNull
    Task<IsOpenResponse> isOpen(@RecentlyNonNull IsOpenRequest isOpenRequest);

    @RecentlyNonNull
    Task<SearchByTextResponse> searchByText(@RecentlyNonNull SearchByTextRequest searchByTextRequest);

    @RecentlyNonNull
    Task<SearchNearbyResponse> searchNearby(@RecentlyNonNull SearchNearbyRequest searchNearbyRequest);

    @RecentlyNonNull
    Task zzb(@RecentlyNonNull FetchPlaceRequest fetchPlaceRequest, int i11);

    @RecentlyNonNull
    Task zzd(@RecentlyNonNull FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i11);
}
