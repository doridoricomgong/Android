/* Android 7.0이상 지원 */
package com.example.downloadmanager_ex;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    String DOWNLOADURL = null;

    Button button;
    EditText textbox;

    // JAVA에서 long형 변수에 int의 범위를 벗어나는 수를 저장할 때 접미사 L을 붙여야함
    private long downloadId = -1L;
    private DownloadManager downloadManager;

    /*
    API level9
    이 API를 통해 다운로드를 요청하는 앱 ACTION_NOTIFICATION_CLICKED은 사용자가 알림 또는 다운로드 UI에서
    실행중인 다운로드를 클릭 할 때 적절하게 처리 할 브로드 캐스트 수신기를 등록해야한다.
     */
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {
                if (downloadId == id) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(id);
                    Cursor cursor = downloadManager.query(query);
                    if (!cursor.moveToFirst()) {
                        return;
                    }

                    int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                    int status = cursor.getInt(columnIndex);

                    // 다운로드 성공 및 실패시 토스트메시지 출력
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        Toast.makeText(MainActivity.this, "Download succeeded", Toast.LENGTH_SHORT).show();
                    } else if (status == DownloadManager.STATUS_FAILED) {
                        Toast.makeText(MainActivity.this, "Download failed", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (DownloadManager.ACTION_NOTIFICATION_CLICKED.equals(intent.getAction())) {
                Toast.makeText(context, "Notification clicked", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textbox = findViewById(R.id.text);

        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

        // BroadcastReceiver 동적 등록
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        intentFilter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED);
        registerReceiver(broadcastReceiver, intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try {
                    DOWNLOADURL = textbox.getText().toString();
                    download();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downloadManager.remove(downloadId);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    // Android 7.0 버전체크,
    // .setRequiresCharging에서 요구
    private void download() throws InterruptedException {
        File file = new File(getExternalFilesDir(null), "download.mp4");
        Uri downloadUri = Uri.parse(DOWNLOADURL);

        DownloadManager.Request request = new DownloadManager.Request(downloadUri)
                // 노티피케이션에 보이는 타이틀
                .setTitle("Downloading a video")
                // 노티피케이션에 보이는 디스크립션
                .setDescription("Downloading Dev Summit")
                // VISIBILITY_VISIBLE로 설정시 노티피케이션에 보여짐
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                // 파일이 저장될 위치의 URI
                .setDestinationUri(Uri.fromFile(file))
                // True로 설정 시 단말기가 충전중일 떄만 다운로드
                .setRequiresCharging(false)
                // True로 설정 시 모바일네트워크가 연결되었을 때도 다운로드
                .setAllowedOverMetered(true)
                // True로 설정 시 로밍네트워크가 연결되었을 때도 다운로드
                .setAllowedOverRoaming(true);

        downloadId = downloadManager.enqueue(request);

    }

    ;
}

