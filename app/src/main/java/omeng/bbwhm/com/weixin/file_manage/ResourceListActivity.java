package omeng.bbwhm.com.weixin.file_manage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.file_manage.utils.Constant;
import omeng.bbwhm.com.weixin.file_manage.utils.FolderAdapter;
import omeng.bbwhm.com.weixin.file_manage.utils.FolderChooserInfo;

public class ResourceListActivity extends BaseActivity {
    private RecyclerView rvList;
    private TextView tvTitle;
    private String resUrl;
    private int resType;
    private FolderAdapter adapter;
    private ExecutorService singleThreadExecutor;
    private List<FolderChooserInfo> parentContents;
    private List<FolderChooserInfo> mData;
    private File parentFolder;
    private boolean canGoUp = true;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_resource_list);
    }

    @Override
    public void initViews() {
        rvList=findViewById(R.id.res_rv);
        tvTitle=findViewById(R.id.res_list_title);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        resType=intent.getIntExtra(Constant.TAG_TYPE,0);
        resUrl=intent.getStringExtra(Constant.TAG_URL);
        if (resType==0) {
            tvTitle.setText("音乐");
        }else if (resType==1) {
            tvTitle.setText("视频");
        }else {
            tvTitle.setText("USB");
        }
        Log.i("ResourceListActivity", "resUrl:"+resUrl);
        mData=new ArrayList<>();
        GridLayoutManager manager=new GridLayoutManager(this, 5);

        rvList.setLayoutManager(manager);
        adapter=new FolderAdapter(this, mData);
        rvList.setAdapter(adapter);
        createThreadPool();
    }

    @Override
    public void initEvent() {
        //item点击事件
        adapter.setOnFolderItemClickListener(new FolderAdapter.OnFolderItemClickListener() {
            @Override
            public void onFolderItemClick(View view, int position, FolderChooserInfo info) {
                onSelection(view, position, info);
            }
        });
    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    mData.clear();
                    mData.addAll(getContentsArray());
                    adapter.setData(getContentsArray());
                    rvList.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    /**
     * 初始化数据
     */
    private void createThreadPool() {
        mData=new ArrayList<>();
        //创建线程池
        singleThreadExecutor= Executors.newSingleThreadExecutor();
        parentFolder = new File(resUrl);
        setData();
    }
    /**
     * 获取数据
     */
    private void setData() {
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                parentContents = listFiles();
                handler.sendEmptyMessage(0);
            }
        });
    }
    private List<FolderChooserInfo> listFiles() {
        File[] contents = parentFolder.listFiles();
        List<FolderChooserInfo> results = new ArrayList<>();
        List<FolderChooserInfo> res = new ArrayList<>();
        if (contents != null) {
            for (File fi : contents) {
                //如果是目录返回true
                if (fi.isDirectory()){
                    FolderChooserInfo info = new FolderChooserInfo();
                    info.setName(fi.getName());
                    info.setFile(fi);
                    info.setImage(fileType(fi));
                    results.add(info);
                }else {
                    FolderChooserInfo info = new FolderChooserInfo();
                    info.setName(fi.getName());
                    info.setFile(fi);
                    info.setImage(fileType(fi));
                    res.add(info);
                }
            }
            Collections.sort(results, new FolderSorter());
            results.addAll(res);
            return results;
        }
        return null;
    }
    public void onSelection( View view, int position, FolderChooserInfo info) {
        if (position==0 && parentFolder.getAbsolutePath().equals(resUrl) ) {
            finish();
        }else {
            if (canGoUp && position == 0) {
                if (parentFolder.isFile()) {
                    parentFolder = parentFolder.getParentFile();
                }
                parentFolder = parentFolder.getParentFile();
                if (parentFolder.getAbsolutePath().equals("/storage/emulated"))
                    parentFolder = parentFolder.getParentFile();
                canGoUp = parentFolder.getParent() != null;
            } else {
                parentFolder = info.getFile();
                canGoUp = true;
                if (parentFolder.getAbsolutePath().equals("/storage/emulated"))
                    parentFolder = Environment.getExternalStorageDirectory();
            }
            if(parentFolder.isFile()) {

            }else{
                rvList.setVisibility(View.GONE);
                setData();
            }
        }

    }
    private static class FolderSorter implements Comparator<FolderChooserInfo> {
        @Override
        public int compare(FolderChooserInfo lhs, FolderChooserInfo rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
    }
    private List<FolderChooserInfo> getContentsArray() {
        List<FolderChooserInfo> results = new ArrayList<>();
        if (parentContents == null) {
            if (canGoUp){
                FolderChooserInfo info = new FolderChooserInfo();
                info.setName("...");
                info.setFile(null);
                info.setImage(R.mipmap.folder_first);
                results.add(info);
            }
            return results;
        }
        if (canGoUp){
            FolderChooserInfo info = new FolderChooserInfo();
            info.setName("...");
            info.setFile(null);
            info.setImage(R.mipmap.folder_first);
            results.add(info);
        }
        results.addAll(parentContents);
        return results;
    }
    private int fileType(File file){
        int image = R.mipmap.ic_launcher;
        if(file.isDirectory()){
            image = R.mipmap.folder;
        }else{
            try {
//            指定文件类型的图标
                String[] token = file.getName().split("\\.");
                String suffix = token[token.length - 1];
                if (suffix.equalsIgnoreCase("txt")) {
                    image = R.mipmap.ic_launcher;
                } else if (suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("gif")) {
                    image = R.mipmap.ic_launcher;
                } else if (suffix.equalsIgnoreCase("mp3")) {
                    image = R.mipmap.music_file;
                } else if (suffix.equalsIgnoreCase("mp4") || suffix.equalsIgnoreCase("rmvb") || suffix.equalsIgnoreCase("avi")) {
                    image = R.mipmap.video_file;
                } else if (suffix.equalsIgnoreCase("apk")) {
                    image = R.mipmap.ic_launcher;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return image;
    }

}
