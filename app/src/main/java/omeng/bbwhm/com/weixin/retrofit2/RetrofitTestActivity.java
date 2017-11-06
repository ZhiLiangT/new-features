package omeng.bbwhm.com.weixin.retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.retrofit2.bean.User;
import omeng.bbwhm.com.weixin.retrofit2.interfaces.AppURL;
import omeng.bbwhm.com.weixin.retrofit2.interfaces.IUserBiz;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTestActivity extends AppCompatActivity {
    private Button bt;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        bt= (Button) findViewById(R.id.retrofit_bt);
        textView= (TextView) findViewById(R.id.retrofit_tv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getUserList();
//                postUserList();
//                Test2();
//                Test_canshu();
                postUser();
            }
        });
    }
    public void getUserList(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserBiz userBiz=retrofit.create(IUserBiz.class);
        Call<List<User>> call=userBiz.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, final Response<List<User>> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(response.body()+"");
                    }
                });
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("访问失败");
                    }
                });
            }
        });
    }
    public void postUserList(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/username/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserBiz userBiz=retrofit.create(IUserBiz.class);
        Call<User> call=userBiz.getUser("TestServlet");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, final Response<User> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(response.body()+"");
                    }
                });
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("访问失败");
                    }
                });
            }
        });
    }

    public void Test(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppURL appURL=retrofit.create(AppURL.class);
        Call<List<User>> call=appURL.getIndex();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, final Response<List<User>> response) {
                Log.i("RetrofitTestActivity",response.body()+"");
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("RetrofitTestActivity","访问失败");
            }
        });
    }
    //固定地址/路径替换
    public void Test2(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppURL appURL=retrofit.create(AppURL.class);
        Call<List<User>> call=appURL.getUserList("TestServlet");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i("RetrofitTestActivity",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("RetrofitTestActivity","访问失败");
            }
        });
    }
    //携带参数
    public void Test_canshu(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppURL appURL=retrofit.create(AppURL.class);
        Call<List<User>> call=appURL.getUserCan(10,115);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i("RetrofitTestActivity",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("RetrofitTestActivity","访问失败");
            }
        });
    }
    public void postUser(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppURL appURL=retrofit.create(AppURL.class);
        Call<List<User>> call=appURL.postUserList(new User("小明","22"));
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.i("RetrofitTestActivity",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("RetrofitTestActivity","访问失败");
            }
        });
    }
}
