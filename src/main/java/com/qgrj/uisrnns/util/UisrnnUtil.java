package com.qgrj.uisrnns.util;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.cloud.speech.v1p1beta1.WordInfo;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UisrnnUtil {
    /*
     * Please include the following imports to run this sample.
     *
     * import com.google.api.gax.longrunning.OperationFuture;
     * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
     * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
     * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
     * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
     * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
     * import com.google.cloud.speech.v1p1beta1.SpeechClient;
     * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
     * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
     * import com.google.cloud.speech.v1p1beta1.WordInfo;
     * import com.google.protobuf.ByteString;
     * import java.nio.file.Files;
     * import java.nio.file.Path;
     * import java.nio.file.Paths;
     */

    public static void sampleLongRunningRecognize() {
        // TODO(developer): Replace these variables before running the sample.
        String localFilePath = "resources/commercial_mono.wav";
        sampleLongRunningRecognize(localFilePath);
    }

    /**
     * Print confidence level for individual words in a transcription of a short audio file Separating
     * different speakers in an audio file recording
     *
     * @param localFilePath Path to local audio file, e.g. /path/audio.wav
     */
    public static void sampleLongRunningRecognize(String localFilePath) {
        try (SpeechClient speechClient = SpeechClient.create()) {

            // If enabled, each word in the first alternative of each result will be
            // tagged with a speaker tag to identify the speaker.

            boolean enableSpeakerDiarization = true;

            //可选。指定会话中的估计发言人数。
            // Optional. Specifies the estimated number of speakers in the conversation.
            int diarizationSpeakerCount = 2;

            // The language of the supplied audio
            //所提供音频的语言
            String languageCode = "en-US";
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            .setEnableSpeakerDiarization(enableSpeakerDiarization)
                            .setDiarizationSpeakerCount(diarizationSpeakerCount)
                            .setLanguageCode(languageCode)
                            .build();
            Path path = Paths.get(localFilePath);
            byte[] data = Files.readAllBytes(path);
            ByteString content = ByteString.copyFrom(data);
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
            LongRunningRecognizeRequest request =
                    LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
            OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
                    speechClient.longRunningRecognizeAsync(request);

            System.out.println("Waiting for operation to complete...");
            LongRunningRecognizeResponse response = future.get();
            for (SpeechRecognitionResult result : response.getResultsList()) {
                // First alternative has words tagged with speakers
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcript: %s\n", alternative.getTranscript());
                // Print the speakerTag of each word
                for (WordInfo word : alternative.getWordsList()) {
                    System.out.printf("Word: %s\n", word.getWord());
                    System.out.printf("Speaker tag: %s\n", word.getSpeakerTag());
                }
            }
        } catch (Exception exception) {
            System.err.println("Failed to create the client due to: " + exception);
        }
    }
}
