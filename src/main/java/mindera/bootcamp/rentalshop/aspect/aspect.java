package mindera.bootcamp.rentalshop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aspect {

    private static final Logger logger = LoggerFactory.getLogger(aspect.class);

    @AfterThrowing(pointcut = "execution(* mindera.bootcamp.rentalshop.service.*.*(..))", throwing = "e")
    public void exceptionAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception thrown from " + joinPoint.getSignature().getName() + " method call with message: " + e.getMessage());
    }

    @Around("execution(* mindera.bootcamp.rentalshop.service.ClientServiceImpl.getClients(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long  startTime = System.currentTimeMillis();
        logger.info("Before " + joinPoint.getSignature().getName() + " method call");
        Object result = joinPoint.proceed();
        logger.info("After " + joinPoint.getSignature().getName() + " method call with result: " + result);
        long endTime = System.currentTimeMillis();
        logger.info("Execution time of " + joinPoint.getSignature().getName() + " method call: " + (endTime - startTime) + " milliseconds");
        return result;
    }

    @AfterReturning(pointcut = "execution(* mindera.bootcamp.rentalshop.service.VehicleServiceImpl.getVehicles(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("After returning from " + joinPoint.getSignature().getName() + " method call with result: " + result);
    }




}
