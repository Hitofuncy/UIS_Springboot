package com.qgrj.uisrnns.Controller;

import com.google.cloud.speech.v1p1beta1.*;
import com.google.protobuf.ByteString;
import com.qgrj.uisrnns.Pojo.CntDatatables;
import com.qgrj.uisrnns.Service.CntBellService;
import com.qgrj.uisrnns.Service.CntDatatablesService;
import com.qgrj.uisrnns.Service.CntRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping(path="/rnn/")
@ResponseBody
public class UisRnnController {


//    /**
//     * 读取目录下的所有文件
//     *
//     * @param dir
//     *            目录
//     * @param fileNames
//     *            保存文件名的集合
//     * @return
//     */
    String dir="D:\\test";
    public static void findFileList(File dir, List<String> fileNames) {
        if (!dir.exists() || !dir.isDirectory()) {// 判断是否存在目录
            return;
        }
        String[] files = dir.list();// 读取目录下的所有目录文件信息
        for (int i = 0; i < files.length; i++) {// 循环，添加文件名或回调自身
            File file = new File(dir, files[i]);
            if (file.isFile()) {// 如果文件
                fileNames.add(dir + "\\" + file.getName());// 添加文件全路径名
            } else {// 如果是目录
                findFileList(file, fileNames);// 回调自身继续查询
            }
        }
    }

    @Autowired
    CntRouterService cntRouterServiceImpl;
    @Autowired
    CntBellService cntBellServiceImpl;
    @Autowired
    CntDatatablesService cntDatatablesServiceImpl;
    @GetMapping(path="/uis")
    public void getuis(){
        // SETP1 遍历文件夹 提取出 文件名 和 文件路径
        List<String> strings = new ArrayList<String>();
        findFileList(new File(dir),strings);
        //     D:\test\192-168-1-1.m4a
        for (int i=0;i<strings.size();i++){
            String[] tmp=strings.get(i).split("\\\\");
            String filename=(tmp[tmp.length-1]).split("[.]")[0];
            String unip = toip(filename);
            int num=have_uis(filename,dir);
            //int num=2;
            Integer id = cntRouterServiceImpl.slectbyipofid(unip);
            String place = cntBellServiceImpl.selectByidofplace(id);
            //2020-04-06 21:48:16
            Date date=new Date();
            CntDatatables cntDatatables=new CntDatatables();
            cntDatatables.setDate(date);
            cntDatatables.setLocation(place);
            cntDatatables.setPeoplenum(num);
            cntDatatablesServiceImpl.insert(cntDatatables);

            new File(strings.get(i)).delete();
        }
    }
    public static String toip(String lastip){
        String ip = "";
        ip = lastip.replace("-",".");
        return ip;
    }

    public int have_uis(String filename,String filepath){

        conversionormat(filename,filepath); // 192_168_1_1.m4a

        String localFilePath = filepath+"\\"+filename+".wav";//""D:\\test\\audio.wav"; //
        String localstring = "";
        try {
            localstring = transcribeDiarization(localFilePath);
        }catch (Exception e){
            System.out.println("err"+e.toString());
        }
        //localstring="Speaker 1: I'm here \nSpeaker 2: hi I'd like to buy a Chrome Cast and I was wondering whether you could help me \nSpeaker 1: with that Hulu which color would you like we have blue black and breath let's get the black one okay Chris would you like the new concur fault remodel or the \nSpeaker 2: regular Comcast regular Chrome Cast \nSpeaker 1: design okay sure would you like to ship it regular or Express Express please terrific it's on the way thank you very much thank you bye bye\n";

        if(localstring == "") return  -1;
        String[] speaker_s = localstring.split("Speaker ");
        Set<Integer>cspeedtest = new HashSet<Integer>();

        for (int i=1;i<speaker_s.length;i++){
            Character ip = speaker_s[i].charAt(0);
            try {
                cspeedtest.add(Integer.parseInt(ip.toString()));
            }catch (Exception e){
                return -1;
            }
        }


        return cspeedtest.size(); // 使用集合处理以下另一种情况。
    }
    /**
     *
     * Speaker 3: 好 吃 的 开 始 录 音 乐 相 见 面
     * Speaker 1: 对 开 始 说 话 说 话 基 本 上 可 以 了
     * Speaker 3: 你 好 十 五 分 钟 或 者 是 空 调 和
     *
     * Process finished with exit code 0
     *
     * **/
    public static String conversionormat(String fileName,String iputload) {
        String webroot = "D:\\Program Files\\ffmpeg\\bin";  //ffmpeg安装路径

        String sourcePath = iputload+"\\" + fileName + ".m4a";
        String targetPath = iputload+"\\" + fileName + ".wav";
        Runtime run = null;
        try

        {
            run = Runtime.getRuntime();
            long start = System.currentTimeMillis();
            System.out.println(new File(webroot).getAbsolutePath());

            //执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame
            String tmp = "ffmpeg -y -i " + sourcePath + " -acodec pcm_s16le -ac 1 -ar 8000 " + targetPath;
            Process p = run.exec(new File(webroot).getAbsolutePath() + "/ffmpeg -y -i " + sourcePath + " -acodec pcm_s16le -ac 1 -ar 8000 " + targetPath);
            p.getOutputStream().close();
            p.getInputStream().close();
            p.getErrorStream().close();
            p.waitFor();
            long end = System.currentTimeMillis();

            System.out.println(sourcePath + " convert success, costs:" + (end - start) + "ms");
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {

//run调用lame解码器最后释放内存
            run.freeMemory();
        }
        return "1";
    }
    public static String transcribeDiarization(String fileName) throws Exception {
        Path path = Paths.get(fileName);
        byte[] content = Files.readAllBytes(path);

        try (SpeechClient speechClient = SpeechClient.create()) {
            // Get the contents of the local audio file
            RecognitionAudio recognitionAudio =
                    RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

            SpeakerDiarizationConfig speakerDiarizationConfig =
                    SpeakerDiarizationConfig.newBuilder()
                            .setEnableSpeakerDiarization(true)
                            .setMinSpeakerCount(2)
                            .setMaxSpeakerCount(50)
                            .build();

            // Configure request to enable Speaker diarization
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                            .setLanguageCode("zh-CN")
                            .setSampleRateHertz(8000)
                            .setDiarizationConfig(speakerDiarizationConfig)
                            .build();

            // Perform the transcription request
            RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

            // Speaker Tags are only included in the last result object, which has only one alternative.
            SpeechRecognitionAlternative alternative =
                    recognizeResponse.getResults(recognizeResponse.getResultsCount() - 1).getAlternatives(0);

            // The alternative is made up of WordInfo objects that contain the speaker_tag.
            WordInfo wordInfo = alternative.getWords(0);
            int currentSpeakerTag = wordInfo.getSpeakerTag();

            // For each word, get all the words associated with one speaker, once the speaker changes,
            // add a new line with the new speaker and their spoken words.
            StringBuilder speakerWords =
                    new StringBuilder(
                            String.format("Speaker %d: %s", wordInfo.getSpeakerTag(), wordInfo.getWord()));

            for (int i = 1; i < alternative.getWordsCount(); i++) {
                wordInfo = alternative.getWords(i);
                if (currentSpeakerTag == wordInfo.getSpeakerTag()) {
                    speakerWords.append(" ");
                    speakerWords.append(wordInfo.getWord());
                } else {
                    speakerWords.append(
                            String.format("\nSpeaker %d: %s", wordInfo.getSpeakerTag(), wordInfo.getWord()));
                    currentSpeakerTag = wordInfo.getSpeakerTag();
                }
            }

            System.out.println(speakerWords.toString());
            return speakerWords.toString();
        }
    }

}
