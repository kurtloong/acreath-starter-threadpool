## **一个基于actuator的线程池监控**
**实现功能**

 1. 线程池状态监控，通过接口返回
 2. 通过接口改变线程池参数配置
 
 **TODO**
 
 1. 在集群环境下的线程池监控

**使用**

 1. 添加Maven依赖

	>      <dependency>  
	>      <groupId>com.github.kurtloong</groupId>  
	>      <artifactId>acreath-starter-threadpool</artifactId>  
	>      <version>1.0.3-RELEASE</version>  
	>     </dependency>


 2. 添加application.yaml 配置
	 ```yaml
	 management:  
	  endpoints:  
	    web:  
	      exposure:  
	        include:  
	          - threadpool
	 ```

 3. 编写线程池配置文件
 
	```java
	@EnableAsync  
	@Configuration  
	public class ThreadPoolConfig {  
	    @Autowired  
	  private ThreadPoolUtil threadPoolUtil;  
  
	  @Bean  
	  public ThreadPoolExecutor asyncExecutor(){  
	        return threadPoolUtil.creatThreadPool(16,32,60, TimeUnit.SECONDS, new ResizeableBlockingQueue<>		(500),"asyncExecutor");  
	  }  
	}

	```

 4. 使用线程池
- 注解
	```java
	 @Async("asyncExecutor")  
	public  void getTrendQuery(){
	   //do something
	}
	```
- 直接使用
	```java
	public void test() {  
	  asyncExecutor.execute(()->{  
	    //do something
	            }  
	    );

	```

 5. 查看线程详情
	 
	http://localhost/actuator/threadpool/getThreadPoolListInfo //GET请求
	
	返回：
	```json
	 [
        {
            "active": 0, //正在进行的任务数
            "activePercent": "0%",//线程池负载
            "completedTaskCount": 17, //完成的任务数
            "corePoolSize": 16, //核心线程数 
            "keepAliveTime": 60000,//线程存活时间
            "largestPoolSize": 16,//到达的最大线程数
            "maximumPoolSize": 32, //最大线程数
            "poolSize": 16,//当前线程数
            "queueCapacity": 500,//队列长度 ps：如果不是ResizeableBlockingQueue 队列则默认为0
            "task": 0, //任务总数
            "queueSize":0,//队列中缓存的任务数量
            "threadPoolName": "asyncExecutor" //线程池名称
        }
    ]
	```
6. 查看线程池参数
http://localhost/actuator/threadpool/getThreadPoolFixInfo?threadPoolName=asyncExecutor //GET请求

	参数:

	| 名称 |  类型|
	|--|--|
	| threadPoolName | String |

	返回：
	
	```json
		{
	        "corePoolSize": 16, //核心线程数
	        "maximumPoolSize": 32, //最大线程数
	        "queueCapacity": 500, //队列大小
	        "queueType": "ResizeableBlockingQueue", //队列类型
	        "threadPoolName": "asyncExecutor" //线程池名称
		 }
	```

7. 修改线程池参数
	https://localhost/actuator/threadpool/setThreadPoolInfo  //Post请求

	参数:

	| 名称 |  类型|  备注|
	|--|--|--|
	| threadPoolName | String ||
	| corePoolSize| int|可变|
	| maximumPoolSize| int|可变|
	| queueCapacity| int|可变|
	| queueType| String |不可变|

	请求类型：json
	
	返回： Boolean
