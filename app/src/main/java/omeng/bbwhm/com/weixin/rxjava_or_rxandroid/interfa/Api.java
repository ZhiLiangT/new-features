package omeng.bbwhm.com.weixin.rxjava_or_rxandroid.interfa;


import java.util.List;

import io.reactivex.Observable;
import omeng.bbwhm.com.weixin.retrofit2.bean.User;
import retrofit2.http.GET;

/**
 * Created by tianzl on 2017/11/6.
 */

public interface Api {

    @GET("TestServlet")
    Observable<List<User>>getUserList();

}
