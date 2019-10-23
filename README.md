# adaptive-push-message-plugin

>实现思路

中介者模式作为观察者和被观察者之间的懒加载资源管理器，观察者集成全局id完成配置标识，被观察者获取观察者父级接口更新消息

>使用场景

可用跨生命周期的消息推送，配置拉取，以及资源分发


```
        public  static  void  main（String [] args）{

        //中介者是全体管理者，是最先存在的
        DataTransferMediator中介=  新的 DataTransferMediator（）;

        //这一步在数据平台实现，可以采用注解的方式注入到应用中，数据仅与中介者互动
        TransferObject aTransferObject =  新的 TransferObject（“ Haha ”，中介）；

        TransferObject bTransferObject =  新的 TransferObject（“ BoBo ”，中介者）;
        接收者 a =  新 接收者（）;


        //这一步可以通过应用启动时注册到分布式服务发现系统上来完成
        调解员。寄存器（aTransferObject，新 的DataListener（一个，CONF - >一个。 HAA（CONF）））;
        调解员。寄存器（aTransferObject，新 的DataListener（一个，CONF - >一个。 HAB（CONF）））;
        调解员。寄存器（bTransferObject，新 的DataListener（一个，CONF - >一个。 HAC（CONF）））;

        //核心：更新与通知
        aTransferObject 。update（“我被改变了”）;


        // mediator.unregister（cConfig，new ConfigObserver（b，conf-> b.hbc（conf）））;


    }
```
