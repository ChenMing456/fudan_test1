/*
 * Created by С�� on 2017/10/18.  ���Ը�����Ȼ���Գ����������
 */

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.nlp.parser.dep.JointParser;
import org.fnlp.nlp.cn.tag.POSTagger;
import org.fnlp.nlp.parser.dep.DependencyTree;
import java.util.HashMap;
public class test0 {
    private static JointParser parser;
    public static void main(String[] args) throws Exception {

        // ʾ��1��--�ִʡ��������Ĵ��������󣬲�ʹ�á�models��Ŀ¼�µ�ģ���ļ���ʼ��
        CNFactory factory = CNFactory.getInstance("models");

        // ʹ�÷ִ��������ľ��ӽ��зִʣ��õ��ִʽ��
        String[] words = factory.seg("��ע��Ȼ���Դ�������ʶ�����ѧϰ�ȷ����ǰ�ؼ�����ҵ�綯̬��");

      //   ��ӡ�ִʽ��
        System.out.println("�ִʽ����");
        for(String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();


        // ʾ��2��--ʵ������ע���������Ĵ��������󣬲�ʹ�á�models��Ŀ¼�µ�ģ���ļ���ʼ��
        CNFactory factory2 = CNFactory.getInstance("models");

        // ʹ�ñ�ע���԰���ʵ�����ľ��ӽ��б�ע���õ����
        HashMap<String, String> result = factory2.ner("�й��Ͻ�ɽ����̨���о�Ա��־ƽ����Ĺ����Ŷӣ�ͨ���Դ˴���������ѧ�źŵĹ۲�͹��׷������״��ṩȷ��֤��֤ʵ�������Ǻϲ��������н�����Ԫ�ص���Ҫ��Դ����־ƽ˵��������������е� ���ͻƽ����쳧 ����");

        // ��ʾ��ע���
        System.out.println("ʵ���ע�����");
        System.out.println(result);



        // ʾ��3��--����䷨�������������Ĵ���������
        parser = new JointParser("models/dep.m");

//        System.out.println("�õ�֧�ֵ������ϵ���ͼ���");
       System.out.println(parser.getSupportedTypes());

        String word = "�ٶ��Ƕ�����ĳ˲ʱ�˶��������˶������ʸ��";
        test(word);
    }
    /**
     * ֻ������ӣ���������
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
