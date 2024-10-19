package com.thumbnail;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    String[] videoFileList = {
            "/storage/emulated/0/Xender/video/android 1.3gp",
            "/storage/emulated/0/Xender/video/android 2.mp4",
            "/storage/emulated/0/Xender/video/android 3.mp4",
            "/storage/emulated/0/Xender/video/android 4.mp4",
            "/storage/emulated/0/Xender/video/android 5.mp4",
            "/storage/emulated/0/Xender/video/android 6.mp4",
            "/storage/emulated/0/Xender/video/android 7.mp4",
            "/storage/emulated/0/Xender/video/android 8.mp4"
    };

    public class MyThumbnaildapter extends ArrayAdapter<String> {

        public MyThumbnaildapter(Context context, int textViewResourceId,
                                 String[] objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            View row = convertView;
            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
            }

            TextView textfilePath = (TextView)row.findViewById(R.id.FilePath);
            textfilePath.setText(videoFileList[position]);
            ImageView imageThumbnail = (ImageView)row.findViewById(R.id.Thumbnail);

            Bitmap bmThumbnail;
            bmThumbnail = ThumbnailUtils.createVideoThumbnail(videoFileList[position], MediaStore.Images.Thumbnails.MICRO_KIND);
            imageThumbnail.setImageBitmap(bmThumbnail);

            return row;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new MyThumbnaildapter(MainActivity.this, R.layout.row, videoFileList));
    }
}
