XXX-qacenter��DataManager���ֵܹ���
=================

Design Philosophy
-----------------
����springBoot�ķ�װ����dubbo�ӿڵ�httpƽ̨����ƪ�����ݹ������ֵ�ƽ̨����ҪĿ���Ƿ�װ����һϵ��dubbo�ӿڣ���װ��һ��http�ӿڣ�����DataManagerƽ̨������ã�ͨ�����������������Ŀ�ġ�
�ٸ����ӣ�ĳ����ƽ̨Ҫ���Խ��׹��̣�������Աͨ���ֻ�app���ԣ���Ҫ������¶������û���¼��������̡�ѡ����Ʒ���ύ������֧��...�������ݹ������԰���һϵ�в�����װ��һ��http�ӿڣ����http�ӿ�
����Ҫ����¼�û����ֻ����롢����id����Ʒid��֧������˽ӿ��߼���ͨ���ֻ������dubbo�ӿڻ�ȡuserId��ͨ��userId����Ʒid����������dubbo�ӿڡ�ͨ��֧������֧������dubbo�ӿڡ�


�ֵ���Ŀ
--------
����Django�����ݹ���ƽ̨������������Ŀ�������������Ŷ
https://github.com/DataFactorys/xinyu-qacenter

���������ֲ�
����Ҫ��
-----------------
jdk1.8<br>
gradle4.8.1<br>
IDEA<br>


������һ��springBoot��Ŀ
-----------------
���Բο���https://blog.csdn.net/saytime/article/details/74781696


����ܹ�
-----------------
![code](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/code.png)<br>
1.constants.enums��ŵ���һЩö��
    ������Զ���һЩö�٣�ֱ�ӷ�װ��http�ӿڷ���map��DataManagerƽ̨����������http�ӿڣ���ʵ����select������Ĺ���
    ![enum](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/enum.png)<br>
    <br>
2.controller���Ƿ�װ��http�ӿ�
    ������ÿ��http�ӿھ����ʵ�֣����Ǿٸ������������´ӱ�дhttp�ӿڣ���DataManager��������񣬵��ýӿ���������
    ��ͼ��findDaily�ӿڣ���Ҫ����dubbo�ӿڣ�ֻ��Ҫһ������dailyId��ͨ��DataManager���룬�ڵ���dubbo�ӿ�
    ![exp](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/exp.png)<br>
    DataManager��������������findDaily�ӿڵ�ַ��http://127.0.0.1:9111/xinyu/findDaily���������1����־id������д����������Ϣ
    ![findDaily](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/findDaily.png)<br>
    <br>
    ����������һ�����������������
    ��ͼ��������־����Ա�����š�ģ���б������˶��������򣬶���Ҫ��http�ӿ�
    ![getTemplateList](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/getTemplateList.png)<br>
    ���ǾͿ���ģ���б�http�ӿ�ʵ�֣�ֱ���ǵ�dubbo�ӿڻ�ȡģ��list���ڷ�װ��map���ظ�ǰ��
    ![getTemplate](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/getTemplate.png)<br>
    <br>
3.result���Ƿ�װ�ķ���
    ����DataManager��ͯЬӦ�������DataManager�Ǳ�Ҫ��http�ӿڵķ���ֵ�и�ʽҪ��ʾ����{'status': true,'responseCode': 1,'message': '��¼�ɹ�','entry': {'type1': 'buyer','type2': 'seller','type3': '����','type4': '����'}}
    Result����ǰ����ݷ�װ�������Ľṹ
    ![result](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/result.png)<br>
    <br>
4.resources
    service.xml�ļ�������zookeeper��dubbo�ӿ�<br>
    ![resources](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/resources.png)<br>
    ʾ����
    ![dubbo�ӿ�����](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/service.png)<br>
    <br>
5.build.gradle������������mvn˽����ַ������������
    ![gradle����](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/gradle.png)<br>
    <br>
6.application.properties������
    server.port=9111�������Ķ˿ںţ������õ���9111
    ���������������http://127.0.0.1:9111/sayhello���������Hello SpringBoot !��˵�������ɹ�

springBoot��Ŀ������ʽ
-----------------
1 �ܼ򵥣�ֱ������һ���Ŀ��run������Ŀ

2 ��ĿĿ¼�µ�������  mvn spring-boot:run

��������  gradlew bootRun

3 ����libs�»���target�� java -jar xxx.jar