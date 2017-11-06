package omeng.bbwhm.com.weixin.rxjava_or_rxandroid;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.retrofit2.bean.User;
import omeng.bbwhm.com.weixin.rxjava_or_rxandroid.interfa.Api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RxJavaTestActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG=RxJavaTestActivity.class.getSimpleName();
    private Button bt1,bt2,bt3,bt4,bt5;
    private TextView textView;
    private StringBuilder builder=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test);
        initView();
    }

    private void initView() {
        textView= (TextView) findViewById(R.id.rxjava_tv);
        bt1= (Button) findViewById(R.id.rxjava_bt1);
        bt2= (Button) findViewById(R.id.rxjava_bt2);
        bt3= (Button) findViewById(R.id.rxjava_bt3);
        bt4= (Button) findViewById(R.id.rxjava_bt4);
        bt5= (Button) findViewById(R.id.rxjava_bt5);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rxjava_bt1:
                send();
                break;
            case R.id.rxjava_bt2:

                break;
            case R.id.rxjava_bt3:
                threadRx();
                textView.setText(builder.toString());
                builder.setLength(0);
                break;
            case R.id.rxjava_bt4:
                mapTest();
                break;
            case R.id.rxjava_bt5:
                flatMapTest();
                break;

        }
    }

    //在子线程中发送事件，在主线程中接收
    public void threadRx(){
        Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                builder.append("当前线程"+Thread.currentThread().getName());
                builder.append("emit 1");
                Log.i(TAG,"当前线程 : "+Thread.currentThread().getName());
                Log.i(TAG,"emit 1");
                e.onNext(1);
            }

        });
        Consumer<Integer> consumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                builder.append("当前线程"+Thread.currentThread().getName());
                builder.append("onNext: "+ integer);
                Log.i(TAG, "当前线程 :" + Thread.currentThread().getName());
                Log.i(TAG, "onNext: " + integer);
            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);

    }
    private void Test1(){
        //创建上游
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable disposable;
            private int i;
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "subscribe");
                disposable=d;

            }

            @Override
            public void onNext(Integer value) {
                Log.i(TAG, "onNext: " + value);
                i++;
                if(value==2){
                    Log.d(TAG, "dispose");
                    disposable.dispose();
                    Log.d(TAG, "isDisposed : " + disposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "complete");
            }
        });
    }
    //map操作符
    public void mapTest(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "this is result"+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG,s);
            }
        });
    }
    //flatMap操作符 无序的
    public void flatMapTest(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list=new ArrayList<>();
                for (int i=0;i<3;i++){
                    list.add("I am value "+integer);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG,s);
            }
        });
    }
    //Retrofit+RxJava进行网络访问
    public void send(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.196:8080/TomcatDemo1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api service=retrofit.create(Api.class);
        service.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> value) {
                        Log.i("RxTestActivity",value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaTestActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(RxJavaTestActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    //数据库操作
    public void dbTest(){
        Observable.create(new ObservableOnSubscribe<List<User>>() {
            @Override
            public void subscribe(ObservableEmitter<List<User>> e) throws Exception {
                Cursor cursor=null;

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



}
