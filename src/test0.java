/*
 * Created by С�� on 2017/10/18.  ���Ը�����Ȼ���Գ����������
 */
import org.fnlp.nlp.cn.CNFactory;
import java.util.*;
public class test0 {
    public static void main(String[] args) throws Exception {

        // �������Ĵ��������󣬲�ʹ�á�models��Ŀ¼�µ�ģ���ļ���ʼ��
        CNFactory factory = CNFactory.getInstance("models");

        // ʹ�÷ִ��������ľ��ӽ��зִʣ��õ��ִʽ��
        String[] words = factory.seg("��ע��Ȼ���Դ�������ʶ�����ѧϰ�ȷ����ǰ�ؼ�����ҵ�綯̬��");

        // ��ӡ�ִʽ��
        for(String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();


        // �������Ĵ��������󣬲�ʹ�á�models��Ŀ¼�µ�ģ���ļ���ʼ��
        CNFactory factory2 = CNFactory.getInstance("models");

        // ʹ�ñ�ע���԰���ʵ�����ľ��ӽ��б�ע���õ����
        HashMap<String, String> result = factory2.ner("�й��Ͻ�ɽ����̨���о�Ա��־ƽ����Ĺ����Ŷӣ�ͨ���Դ˴���������ѧ�źŵĹ۲�͹��׷������״��ṩȷ��֤��֤ʵ�������Ǻϲ��������н�����Ԫ�ص���Ҫ��Դ����־ƽ˵��������������е� ���ͻƽ����쳧 ����");

        // ��ʾ��ע���
        System.out.println(result);
    }
}
