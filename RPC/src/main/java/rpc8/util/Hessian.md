##Hession介绍<br>

Hession是一个轻量级的remoting on http工具，采用的是Binary RPC协议，所以它很适合发送二进制数据，同时又具有防火墙穿透能力。
Hessian一般是通过Web应用来提供服务，因此非常类似于我们平常使用的WebService。只是它不使用SAOP协议，但是相比webservice而言更简单、快捷。

Hessian官网：http://hessian.caucho.com/ <br>

Hessian可通过servlet提供远程服务，需要将匹配某个模式的请求映射到Hession服务。也可Spring框架整合，通过他的DispatcherServlet可以完成该功能，
DispatcherServlet可以将匹配模式的请求转发到Hessian服务。Hessian的serve端提供一个servlet积累，用来处理发送的请求，而Hessian的这个远程过程调用，完全使用
动态代理实现的，建议采用面向接口编程，Hession服务通过接口暴露。

原理简单描述：动态代理+序列化+http

特点：
1、角色划分：provider、consumer；
2、consumer需要指明provider的http服务地址，地址维护比较繁琐；
3、provider地址通过域名路由到nginx，可以实现 provider 的负载均衡，但是会导致""1+1(tomcat+nginx，而dubbo是tcp直连的，就不会出现该问题)"问题，产生单点压力，放大流量

##应用及协议Binary-RPC
Binary-RPC协议的一次远程通信过程：<BR>
1、客户端发起请求，按照Binary-RPC协议将请求信息进行填充；<BR>
2、填充完成之后将二进制格式文件转化为流，通过传输协议进行传输；<BR>
3、接收到流之后将流转化成二进制文件，按照Binary-RPC协议获取请求的信息并进行处理<br>
4、处理完毕后将结果按照Binary-RPC协议写入二进制文件中并返回