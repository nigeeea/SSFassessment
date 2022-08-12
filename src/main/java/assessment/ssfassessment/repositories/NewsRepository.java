package assessment.ssfassessment.repositories;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class NewsRepository {

    // @Value("${article.cache.duration}")
    // private Long cacheTime;

    // @Autowired
    // @Qualifier("redislab")
    // private RedisTemplate<String, String> redisTemplate;

    // public void save(String id, String payload){
    //     ValueOperations<String,String> valueOp = redisTemplate.opsForValue();
    //     valueOp.set(id, payload, Duration.ofMinutes(cacheTime));
    // }

    // public String get(String id){
    //     ValueOperations<String,String> valueOps = redisTemplate.opsForValue();
    //     return valueOps.get(id);
    // }
    
}
