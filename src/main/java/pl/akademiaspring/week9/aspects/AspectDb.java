package pl.akademiaspring.week9.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDb {

    private long elapsedTime;

    @Around("@annotation(AccessDb)")
    public void aroundAccessDb(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        joinPoint.proceed();

        elapsedTime = System.currentTimeMillis() - start;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
