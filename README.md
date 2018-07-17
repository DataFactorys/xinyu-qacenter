XXX-qacenter：DataManager的兄弟工程
=================

Design Philosophy
-----------------
基于springBoot的封装开发dubbo接口的http平台：本篇是数据工厂的兄弟平台，主要目的是封装开发一系列dubbo接口，包装成一个http接口，用于DataManager平台事务调用，通过这样来完成造数据目的。
举个列子：某电商平台要测试交易过程，测试人员通过手机app测试，需要完成以下动作：用户登录、进入店铺、选择商品、提交订单、支付...，而数据工厂可以把这一系列操作封装成一个http接口，这个http接口
主需要传登录用户的手机号码、店铺id、商品id、支付金额，后端接口逻辑：通过手机号码调dubbo接口获取userId，通过userId、商品id调创建订单dubbo接口、通过支付金额调支付订单dubbo接口。


兄弟项目
--------
基于Django的数据工厂平台，这两个个项目配合起来才能用哦
https://github.com/DataFactorys/xinyu-qacenter

新手入门手册
环境要求
-----------------
jdk1.8<br>
gradle4.8.1<br>
IDEA<br>


构建第一个springBoot项目
-----------------
可以参考：https://blog.csdn.net/saytime/article/details/74781696


代码架构
-----------------
![code](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/code.png)<br>
1.constants.enums里放的是一些枚举
    这里可以定义一些枚举，直接封装成http接口返回map，DataManager平台下拉框调这个http接口，就实现了select下拉框的功能
    ![enum](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/enum.png)<br>
    <br>
2.controller里是封装的http接口
    这里是每个http接口具体的实现，我们举个简单例子来看下从编写http接口，到DataManager中添加事务，调用接口整个过程
    下图中findDaily接口，先要引用dubbo接口，只需要一个参数dailyId，通过DataManager传入，在调用dubbo接口
    ![exp](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/exp.png)<br>
    DataManager中新增事务，填上findDaily接口地址：http://127.0.0.1:9111/xinyu/findDaily，填上入参1：日志id，再填写其他必填信息
    ![findDaily](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/findDaily.png)<br>
    <br>
    我们再来看一个带有下拉框的事务
    下图中新增日志事务，员工工号、模板列表、接收人都是下拉框，都需要调http接口
    ![getTemplateList](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/getTemplateList.png)<br>
    我们就看下模板列表http接口实现，直接是调dubbo接口获取模板list，在封装成map返回给前端
    ![getTemplate](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/getTemplate.png)<br>
    <br>
3.result里是封装的返回
    看过DataManager的童鞋应该清楚，DataManager那边要求http接口的返回值有格式要求，示例：{'status': true,'responseCode': 1,'message': '登录成功','entry': {'type1': 'buyer','type2': 'seller','type3': '测试','type4': '开发'}}
    Result类就是把数据封装成这样的结构
    ![result](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/result.png)<br>
    <br>
4.resources
    service.xml文件中配置zookeeper和dubbo接口<br>
    ![resources](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/resources.png)<br>
    示例：
    ![dubbo接口配置](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/service.png)<br>
    <br>
5.build.gradle，这里是配置mvn私服地址，还有依赖包
    ![gradle配置](https://github.com/DataFactorys/xinyu-qacenter/blob/master/images/gradle.png)<br>
    <br>
6.application.properties中配置
    server.port=9111，启动的端口号，我配置的是9111
    启动后，浏览器输入http://127.0.0.1:9111/sayhello，如果出现Hello SpringBoot !，说明启动成功

springBoot项目启动方式
-----------------
1 很简单，直接鼠标右击项目，run启动项目

2 项目目录下的命令行  mvn spring-boot:run

　　或者  gradlew bootRun

3 进入libs下或者target下 java -jar xxx.jar