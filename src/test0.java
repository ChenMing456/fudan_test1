/*
 * Created by 小陈 on 2017/10/18.  测试复旦自然语言程序包的运行
 */
import org.fnlp.nlp.cn.CNFactory;
import java.util.*;
public class test0 {
    public static void main(String[] args) throws Exception {

        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory = CNFactory.getInstance("models");

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

        // 打印分词结果
        for(String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();


        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory2 = CNFactory.getInstance("models");

        // 使用标注器对包含实体名的句子进行标注，得到结果
        HashMap<String, String> result = factory2.ner("中国紫金山天文台副研究员金志平参与的国际团队，通过对此次引力波光学信号的观测和光谱分析，首次提供确凿证据证实，中子星合并是宇宙中金银等元素的主要起源。金志平说：“这就是宇宙中的 巨型黄金制造厂 。”");

        // 显示标注结果
        System.out.println(result);
    }
}
