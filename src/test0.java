/*
 * Created by 小陈 on 2017/10/18.  测试复旦自然语言程序包的运行
 */

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.nlp.parser.dep.JointParser;
import org.fnlp.nlp.cn.tag.POSTagger;
import org.fnlp.nlp.parser.dep.DependencyTree;
import java.util.HashMap;
public class test0 {
    private static JointParser parser;
    public static void main(String[] args) throws Exception {

        // 示例1：--分词。创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory = CNFactory.getInstance("models");

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

      //   打印分词结果
        System.out.println("分词结果：");
        for(String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();


        // 示例2：--实体名标注。创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory2 = CNFactory.getInstance("models");

        // 使用标注器对包含实体名的句子进行标注，得到结果
        HashMap<String, String> result = factory2.ner("中国紫金山天文台副研究员金志平参与的国际团队，通过对此次引力波光学信号的观测和光谱分析，首次提供确凿证据证实，中子星合并是宇宙中金银等元素的主要起源。金志平说：“这就是宇宙中的 巨型黄金制造厂 。”");

        // 显示标注结果
        System.out.println("实体标注结果：");
        System.out.println(result);



        // 示例3：--依存句法分析。创建中文处理工厂对象
        parser = new JointParser("models/dep.m");

//        System.out.println("得到支持的依存关系类型集合");
       System.out.println(parser.getSupportedTypes());

        String word = "速度是动点在某瞬时运动快慢和运动方向的矢量";
        test(word);
    }
    /**
     * 只输入句子，不带词性
     * @throws Exception
     */
    private static void test(String word) throws Exception {
        POSTagger tag = new POSTagger("models/seg.m","models/pos.m");
        String[][] s = tag.tag2Array(word);
        try {
            DependencyTree tree1 = parser.parse2T(s[0],s[1]);
            System.out.println(tree1.toString());
            String stree1 = parser.parse2String(s[0],s[1],true);
            System.out.println(stree1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
