## eureka最全配置如下

> 该配置建立在springboot配置文件(*.yml,*.properties)上，开发过程中选择自己所需的配置即可，其余有默认配置

```
eureka:
  instance:
    instanceId: ${spring.application.name}:${vcap.application.instance-id:${spring.application.instance-id:${random.value}}} #获取要在eureka注册的此实例的唯一ID（在appName范围内）
    hostname: producer  #主机名（如果可以在配置时确定的话）
    appname: unknown #获取要在eureka注册的应用程序的名称,默认unknown
    appGroupName: #获取要在尤里卡注册的应用程序组的名称
    instanceEnabledOnit: #指示是否在向eureka注册后立即启用实例以进行流量处理。有时，应用程序可能需要做一些预处理才能准备流量
    nonSecurePort: 80 #获取实例应在其上接收流量的非安全端口,默认80
    securePort: 443 #获取实例应在其上接收流量的安全端口，默认443
    nonSecurePortEnabled: true #指示是否应为非安全端口启用流量,默认true
    securePortEnabled: #指示是否应启用安全端口的流量
    leaseRenewalIntervalInSeconds: 30 #指示eureka客户端需要多长时间（以秒为单位）将心跳发送到eureka服务器，以指示其仍处于活动状态。如果在leaseExpirationDurationInSeconds中指定的时间内未接收到心跳，则eureka服务器将通过禁止访问该实例的方式从其视图中删除该实例。 请注意，如果实例实现 HealthCheckCallback并决定使其自身不可用，则该实例仍无法获得流量,默认30
    leaseExpirationDurationInSeconds: 90 #表示自eureka服务器接收到上一次心跳以来可以等待的时间（以秒为单位），之后它才能从其视图中删除该实例，并通过禁止对该实例的流量进行操作。 将该值设置得太长可能意味着即使实例未处于活动状态，也可以将流量路由到实例。将此值设置得太小可能意味着实例可能由于临时网络故障而无法进行通信。此值应设置为至少比leaseRenewalIntervalInSeconds中指定的值高,默认90
    virtualHostName: unknown #获取为此实例定义的虚拟主机名,默认unknown
    secureVirtualHostName: unknown #获取为此实例定义的安全虚拟主机名,默认unknown
    aSGName:  #获取与此实例关联的AWS自动扩展组名称。此信息在AWS环境中专门用于在实例启动并已禁用流量后自动将实例从服务中删除
    ipAddress: #获取实例的IPAdress。因为来自其他实例的通信主要使用{@link #getHostName（boolean）}中提供的信息进行。
    actuatorPrefix: /actuator #系统健康监控访问前缀
    statusPageUrlPath: /actuator/info #监控系统信息路径，默认actuatorPrefix + "/info"
    statusPageUrl: #监控状态路径
    homePageUrlPath: / #获取此实例的相对主页URL路径。然后，根据URL的hostName和通信类型（安全或不安全）构造主页URL。 通常，它仅供参考，其他服务也可以将其用作登录页面
    homePageUrl: #获取此实例的绝对主页URL。如果主页位于与eureka对话的同一实例中，则用户可以提供homePageUrlPath，否则，如果该实例是其他服务器的代理，则用户可以提供完整的URL。如果提供了完整的URL，则优先。 通常，它仅供参考，其他服务也可以将其用作登录页面。完整的URL应该采用http//${eureka.hostname}7001/ 格式，其中在运行时将替换${eureka.hostname}值
    healthCheckUrlPath: /actuator/health  #获取此实例的相对健康检查URL路径,默认actuatorPrefix + "/health"
    healthCheckUrl: #获取此实例的绝对健康检查页面URL。如果运行状况检查页面位于同一实例中，则用户可以提供 healthCheckUrlPath 与eureka对话，否则，如果该实例是其他服务器的代理，则用户可以提供完整的URL。如果提供了完整的URL，则具有优先级。 通常用于根据实例的运行状况做出明智的决策-例如，它可用于确定是否继续进行整个场的部署或停止部署而不会造成进一步的损害。完整的 URL应该采用http//${eureka.hostname}7001/的格式，其中 ${eureka.hostname}的值将在运行时替换
    secureHealthCheckUrl: #获取此实例的绝对安全运行状况检查页面URL。如果运行状况检查页面位于与eureka对话的同一实例中，则用户可以提供secureHealthCheckUrl，否则，如果该实例是其他服务器的代理，则用户可以提供完整的URL。如果提供了完整的URL，则优先。通常用于根据实例的运行状况做出明智的决策-例如，它可用于确定是否继续进行整个场的部署或停止部署而不会造成进一步的损害。完整的URL应该采用http//${eureka.hostname}7001/的格式，其中 ${eureka.hostname}的值将在运行时替换
    namespace: eureka #获取用于查找属性的名称空间。在Spring Cloud中被忽略
    preferIpAddress: false #在猜测主机名时，应根据操作系统报告的主机名使用服务器的IP地址,默认false
    initialStatus: up  #向远程Eureka服务器注册的初始状态,默认InstanceStatus.UP

  client:
    enabled: true #是否开启eureka客户端标识
    registerWithEureka: true #注册本身实例到eureka,默认true
    fetchRegistry: true #拉取eureka其他注册实例到本地,默认true
    serviceUrl: #可用区映射到与eureka服务器通信的标准URL列表。每个值可以是单个URL，也可以是逗号分隔的*位置列表。通常，eureka服务器URL带有协议，主机，端口，上下文和版本信息（如果有）。示例： https://ec2-256-156-243-129.compute-1.amazonaws.com:7001/eureka/ 更改在下一个服务URL刷新周期（由eurekaServiceUrlPollIntervalSeconds指定）下在运行时有效
      defaultZone: http://localhost:8801/register/eureka/ #默认defaultZone:http://localhost:8761/eureka/
    registryFetchIntervalSeconds: 30 #拉取注册信息的频率,秒为单位,默认30
    instanceInfoReplicationIntervalSeconds: 30 #更新本身注册实例到eureka服务器的频率,秒为单位,默认30
    initialInstanceInfoReplicationIntervalSeconds: 40  #首次复制本身实例到eureka服务器的频率,秒为单位,默认40
    eurekaServiceUrlPollIntervalSeconds: 300  #指示轮询eureka服务器信息更改的频率（以秒为单位）。可以添加或删除Eureka服务器，并且此设置控制eureka客户端应该多久知道一次,默认5分钟
    eurekaServerReadTimeoutSeconds: 8 #指示从eureka服务器读取到超时需要等待多长时间（以秒为单位）,默认8
    eurekaServerConnectTimeoutSeconds: 5 #指示与eureka服务器的连接需要等待超时的时间（以秒为单位）,默认5。请注意，客户端中的连接由org.apache.http.client.HttpClient池化，并且此设置会影响实际的连接创建以及从池中获取连接的等待时间
    eurekaServerTotalConnections: 200 #获取从eureka客户端到所有eureka服务器的允许的连接总数，默认200
    eurekaServerTotalConnectionsPerHost: 50 #获取从eureka客户端到eureka服务器主机的允许连接总数,默认50
    eurekaConnectionIdleTimeoutSeconds: 30 #指示与eureka服务器的HTTP连接可以空闲多少时间（以秒为单位），然后才能关闭它。在AWS环境中，建议将该值设置为30秒或更短时间，因为防火墙会在几分钟后清理连接信息，从而使连接悬而未决
    registryRefreshSingleVipAddress: #指示客户端是否仅对*个VIP的注册表信息感兴趣
    heartbeatExecutorThreadPoolSize: 2 #用于初始化heartbeatExecutor的线程池大小，默认2
    heartbeatExecutorExponentialBackOffBound: 10 #心跳执行器指数回退相关属性。如果发生一系列超时，它是重试延迟的最大乘数，默认10
    cacheRefreshExecutorThreadPoolSize: 2 #用于初始化cacheRefreshExecutor的线程池大小，默认2
    cacheRefreshExecutorExponentialBackOffBound: 10 #缓存刷新执行器指数回退相关属性。如果发生一系列超时，它是重试延迟的最大乘数，默认10
 ```