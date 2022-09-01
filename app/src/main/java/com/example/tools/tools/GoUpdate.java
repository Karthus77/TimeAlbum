package com.example.tools.tools;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.example.tools.MyData;
import com.example.tools.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoUpdate {
    private Disposable downDisposable;
    private ProgressBar progressBar;
    private TextView textView4;
    private Button upgrade;
    private long downloadLength = 0;
    private long contentLength = 0;
    private String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private Context context;
    private Activity activity;

    public GoUpdate(Context con, Activity act){
        context = con;
        activity =act;
    }
    public void test() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d("123300","zl");
            }
        }).subscribeOn(Schedulers.io())// 将被观察者切换到子线程
                .observeOn(AndroidSchedulers.mainThread())// 将观察者切换到主线程
                .subscribe(new Observer<String>() {
                    private Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }
                    @Override
                    public void onNext(String result) {
                        if (result.isEmpty()) {
                            Log.d("123300","zaiay");
                            return;
                        }
                        //2.判断版本是否最新，如果不是最新版本则更新
                        String downloadUrl = "http://122.9.2.27/media/package/ru.zdevs.zarchiver.apk";
                        String title = "是否升级到4.1.1版本？";
                        String size = "新版本大小：未知";
                        String msg = "1、优化api接口。\r\n2、添加使用demo演示。\r\n3、新增自定义更新服务API接口。\r\n4、优化更新提示界面。";
                        String versionCode = "0.9.0";
                        MyData myData = new MyData(context);
                        String version = myData.load_v();
                        Log.d("123300",">>>>>>");
                        if (!version.equals(versionCode)) {
                            LayoutInflater inflater = LayoutInflater.from(context);
                            View view = inflater.inflate(R.layout.new_update_layout, null);
                            AlertDialog.Builder mDialog = new AlertDialog.Builder(context, R.style.Translucent_NoTitle);
                            mDialog.setView(view);
                            mDialog.setCancelable(true);
                            Log.d("123300","!!!!!!!!");
                            mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                                @Override
                                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                                    return keyCode == KeyEvent.KEYCODE_BACK;
                                }
                            });
                            upgrade = view.findViewById(R.id.button);
                            TextView textView1 = view.findViewById(R.id.textView1);
                            TextView textView2 = view.findViewById(R.id.textView2);
                            TextView textView3 = view.findViewById(R.id.textView3);
                            ImageView iv_close = view.findViewById(R.id.iv_close);
                            textView1.setText(title);
                            textView2.setText(size);
                            textView3.setText(msg);
                            upgrade.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //动态询问是否授权
                                    int permission = ActivityCompat.checkSelfPermission(context,
                                            Manifest.permission.WRITE_EXTERNAL_STORAGE);
                                    if (permission != PackageManager.PERMISSION_GRANTED) {
                                        ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, 1);
                                    } else {
                                        upgrade.setVisibility(View.INVISIBLE);
                                        down(downloadUrl);
                                    }
                                }
                            });
                            iv_close.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                        finish();
                                }
                            });
                            mDialog.show();
                        } else {

                        }
                        mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        test();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void down(String downloadUrl) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                downApk(downloadUrl, emitter);
            }
        }).subscribeOn(Schedulers.io())// 将被观察者切换到子线程
                .observeOn(AndroidSchedulers.mainThread())// 将观察者切换到主线程
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        downDisposable = d;
                    }

                    @Override
                    public void onNext(Integer result) {
                        //设置ProgressDialog 进度条进度
                        progressBar.setProgress(result);
                        textView4.setText(result + "%");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "网络异常！请重新下载！", Toast.LENGTH_SHORT).show();
                        upgrade.setEnabled(true);
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "服务器异常！请重新下载！", Toast.LENGTH_SHORT).show();
                        upgrade.setEnabled(true);
                    }
                });
    }

    private void downApk(String downloadUrl, ObservableEmitter<Integer> emitter) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //下载失败
                breakpoint(downloadUrl, emitter);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() == null) {
                    //下载失败
                    breakpoint(downloadUrl, emitter);
                    return;
                }
                InputStream is = null;
                FileOutputStream fos = null;
                byte[] buff = new byte[2048];
                int len;
                try {
                    is = response.body().byteStream();
                    File file = createFile();
                    fos = new FileOutputStream(file);
                    long total = response.body().contentLength();
                    contentLength = total;
                    long sum = 0;
                    while ((len = is.read(buff)) != -1) {
                        fos.write(buff, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        //下载中，更新下载进度
                        emitter.onNext(progress);
                        downloadLength = sum;
                    }
                    fos.flush();
                    //4.下载完成，安装apk
                    installApk(activity, file);
                } catch (Exception e) {
                    e.printStackTrace();
                    breakpoint(downloadUrl, emitter);
                } finally {
                    try {
                        if (is != null)
                            is.close();
                        if (fos != null)
                            fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void breakpoint(String downloadUrl, ObservableEmitter<Integer> emitter) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .addHeader("RANGE", "bytes=" + downloadLength + "-" + contentLength)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //下载失败
                breakpoint(downloadUrl, emitter);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() == null) {
                    //下载失败
                    breakpoint(downloadUrl, emitter);
                    return;
                }
                InputStream is = null;
                RandomAccessFile randomFile = null;
                byte[] buff = new byte[2048];
                int len;
                try {
                    is = response.body().byteStream();
                    String root = Environment.getExternalStorageDirectory().getPath();
                    File file = new File(root, "updateDemo.apk");
                    randomFile = new RandomAccessFile(file, "rwd");
                    randomFile.seek(downloadLength);
                    long total = contentLength;
                    long sum = downloadLength;
                    while ((len = is.read(buff)) != -1) {
                        randomFile.write(buff, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        //下载中，更新下载进度
                        emitter.onNext(progress);
                        downloadLength = sum;
                    }
                    //4.下载完成，安装apk
                    installApk(activity, file);
                } catch (Exception e) {
                    e.printStackTrace();
                    breakpoint(downloadUrl, emitter);
                } finally {
                    try {
                        if (is != null)
                            is.close();
                        if (randomFile != null)
                            randomFile.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private File createFile() {
        String root = Environment.getExternalStorageDirectory().getPath();
        File file = new File(root, "updateDemo.apk");
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void installApk(Context context, File file) {
        if (context == null) {
            return;
        }
        String authority = context.getApplicationContext().getPackageName() + ".fileProvider";
        Uri apkUri = FileProvider.getUriForFile(context, authority, file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //判读版本是否在7.0以上
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
        //弹出安装窗口把原程序关闭。
        //避免安装完毕点击打开时没反应
        Process.killProcess(Process.myPid());
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        downDisposable.dispose();//取消订阅
//    }

}
