package com.example.okejon.insideout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import timber.log.Timber;

public class Emojifier {

    private static double SMILING_PROP_THRESHOLD = .15;
    private static double EYE_OPEN_PROP_THRESHOLD = .5;
    private static float EMOJI_SCALE_FACTOR=.9f;

    // Enum for all possible Emojis
    private enum Emoji {
        SMILE,
        FROWN,
        LEFT_WINK,
        RIGHT_WINK,
        LEFT_WINK_FROWN,
        RIGHT_WINK_FROWN,
        CLOSED_EYE_SMILE,
        CLOSED_EYE_FROWN
    }

    private static final String TAG = Emojifier.class.getSimpleName();

    public static Bitmap detectFaces(Context context, Bitmap image) {
        //get the detector
        FaceDetector detector = new FaceDetector.Builder(context).setTrackingEnabled(false).setClassificationType(FaceDetector.ALL_CLASSIFICATIONS).build();
        Frame frame = new Frame.Builder().setBitmap(image).build();
        SparseArray<Face> faces = detector.detect(frame);
        Timber.d("number of faces= " + faces.size());
        Bitmap resultBitmap = image;

        if (faces.size() == 0) {
            Toast.makeText(context, "no face", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < faces.size(); i++) {
                Face face = faces.valueAt(i);
                Bitmap emojiBitmap;
                switch (whichEmoji(face)) {
                    case SMILE:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.smile);
                        break;

                    case FROWN:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.frown);
                        break;

                    case LEFT_WINK:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.leftwink);
                        break;

                    case RIGHT_WINK:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.rightwink);
                        break;

                    case LEFT_WINK_FROWN:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.leftwinkfrown);
                        break;

                    case RIGHT_WINK_FROWN:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.rightwinkfrown);
                        break;

                    case CLOSED_EYE_SMILE:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.closed_smile);
                        break;

                    case CLOSED_EYE_FROWN:
                        emojiBitmap = BitmapFactory.decodeResource(context.getResources(),
                                R.drawable.closed_frown);
                        break;

                    default:
                        emojiBitmap = null;
                        Toast.makeText(context, "null", Toast.LENGTH_SHORT).show();
                }

                // Add the emojiBitmap to the proper position in the original image
                resultBitmap = addBitmapToFace(resultBitmap, emojiBitmap, face);
            }
        }
        detector.release();
        return resultBitmap;
    }

    private static Bitmap addBitmapToFace(Bitmap backgroundBitmap, Bitmap emojiBitmap, Face face) {

        // Initialize the results bitmap to be a mutable copy of the original image
        Bitmap resultBitmap = Bitmap.createBitmap(backgroundBitmap.getWidth(), backgroundBitmap.getHeight(), backgroundBitmap.getConfig());

        // Scale the emoji so it looks better on the face
        float scaleFactor = EMOJI_SCALE_FACTOR;

        // Determine the size of the emoji to match the width of the face and preserve aspect ratio
        int newEmojiWidth = (int) (face.getWidth()*scaleFactor);
        int newEmojiHeight = (int) (emojiBitmap.getHeight()*newEmojiWidth / emojiBitmap.getWidth() * scaleFactor);

        // Scale the emoji
        emojiBitmap = Bitmap.createScaledBitmap(emojiBitmap, newEmojiWidth, newEmojiHeight, false);

        // Determine the emoji position so it best lines up with the face
        float emojiPositionX = (face.getPosition().x + face.getWidth() / 2) - emojiBitmap.getWidth() / 2;
        float emojiPositionY = (face.getPosition().y + face.getHeight() / 2) - emojiBitmap.getHeight() / 3;

        // Create the canvas and draw the bitmaps to it
        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(backgroundBitmap, 0, 0, null);
        canvas.drawBitmap(emojiBitmap, emojiPositionX, emojiPositionY, null);
        return resultBitmap;
    }

    private static Emoji whichEmoji(Face face) {
        Timber.d( "getClassifications: smilingProb = " + face.getIsSmilingProbability());
        Timber.d("getClassifications: leftEyeOpenProb = " + face.getIsLeftEyeOpenProbability());
        Timber.d("getClassifications: rightEyeOpenProb = " + face.getIsRightEyeOpenProbability());
        boolean smiling = face.getIsSmilingProbability() > SMILING_PROP_THRESHOLD;
        boolean leftEyeClosed = face.getIsLeftEyeOpenProbability() < EYE_OPEN_PROP_THRESHOLD;
        boolean rightEyeClosed = face.getIsRightEyeOpenProbability() < EYE_OPEN_PROP_THRESHOLD;

        // Determine and log the appropriate emoji
        Emoji emoji;
        if (smiling) {
            if (leftEyeClosed && !rightEyeClosed) {
                emoji = Emoji.LEFT_WINK;
            } else if (rightEyeClosed && !leftEyeClosed) {
                emoji = Emoji.RIGHT_WINK;
            } else if (leftEyeClosed) {
                emoji = Emoji.CLOSED_EYE_SMILE;
            } else {
                emoji = Emoji.SMILE;
            }
        } else {
            if (leftEyeClosed && !rightEyeClosed) {
                emoji = Emoji.LEFT_WINK_FROWN;
            } else if (rightEyeClosed && !leftEyeClosed) {
                emoji = Emoji.RIGHT_WINK_FROWN;
            } else if (leftEyeClosed) {
                emoji = Emoji.CLOSED_EYE_FROWN;
            } else {
                emoji = Emoji.FROWN;
            }
        }

        // Log the chosen Emoji
        Timber.d("whichEmoji: " + emoji.name());
        return emoji;
    }
}