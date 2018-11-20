package org.code_crew.soundboard;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;

    private AudioManager audioManager;

    // Maximumn sound stream.
    private static final int MAX_STREAMS = 5;

    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;

    private boolean loaded;

    private int sound1;
    private int sound2;
    private float volume;
    private int sound3;
    private int sound4;
    private int sound5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);

        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);

        // Volumn (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;


        this.setVolumeControlStream(streamType);
        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

        this.soundPool = builder.build();
    }
    //
       else

    {
        // SoundPool(int maxStreams, int streamType, int srcQuality)
        this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
    }

    // When Sound Pool load complete.
       this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()

    {
        @Override
        public void onLoadComplete (SoundPool soundPool,int sampleId, int status){
        loaded = true;
    }
    });

    // Load sound file (sound.wav) into SoundPool.
       this.sound1 =this.soundPool.load(this,R.raw.sound1,1);
       this.sound2 =this.soundPool.load(this,R.raw.sound2,1);
       this.sound3 =this.soundPool.load(this,R.raw.sound3,1);
       this.sound4 =this.soundPool.load(this,R.raw.sound4,1);
       this.sound5 =this.soundPool.load(this,R.raw.sound5,1);


    }


    // When users click on the button "sound1"
    public void playSound1(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            // Play sound of gunfire. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.sound2, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    // When users click on the button "sound2"
    public void playSound2(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            int streamId = this.soundPool.play(this.sound1, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound3(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            int streamId = this.soundPool.play(this.sound3, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound4(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            int streamId = this.soundPool.play(this.sound4, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound5(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            int streamId = this.soundPool.play(this.sound5, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

}


