//这种方式, 由于每次获取示例都要获取锁, 不推荐使用, 性能较差
public static synchronized Singleton getInstance() {  
         if (single == null) {    
             single = new Singleton();  
         }    
        return single;  
}
