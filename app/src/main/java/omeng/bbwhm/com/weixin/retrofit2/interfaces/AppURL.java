package omeng.bbwhm.com.weixin.retrofit2.interfaces;

import java.util.List;

import omeng.bbwhm.com.weixin.retrofit2.bean.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tianzl on 2017/11/6.
 */

public interface AppURL {

    @GET("TestServlet")
    Call<List<User>> getIndex();

    @GET("{name}")
    Call<List<User>> getUserList(@Path("name")String name);

    @GET("TestServlet")
    Call<List<User>> getUserCan(@Query("start")int start,@Query("count")int count);

    @POST("TestPost")
    Call<List<User>> postUserList(@Body User user);

    @FormUrlEncoded
    @POST("TestPost")
    Call<List<User>> updateUser(@Field("name")String name,@Field("age")int age);

}
