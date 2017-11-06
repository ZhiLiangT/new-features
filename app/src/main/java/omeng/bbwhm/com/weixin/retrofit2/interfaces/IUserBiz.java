package omeng.bbwhm.com.weixin.retrofit2.interfaces;

import java.util.List;

import omeng.bbwhm.com.weixin.retrofit2.bean.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tianzl on 2017/11/6.
 */

public interface IUserBiz {
    @GET("TestServlet")
    Call<List<User>> getUsers();

    @GET("{username}")
    Call<User> getUser(@Path("username")String username);
}
