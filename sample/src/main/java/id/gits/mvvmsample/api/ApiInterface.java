package id.gits.mvvmsample.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ibun on 8/23/16.
 */
public interface ApiInterface {
    @GET("group/{id}/users")
    Observable<List<String>> postLogin(@Path("id") int groupId);
}
